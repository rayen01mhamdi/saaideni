package com.example.sos.core.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.text.SimpleDateFormat
import java.util.*

data class UserLocationData(
    val latitude: Double,
    val longitude: Double,
    val accuracyMeters: Float,
    val timestamp: Long,
    val isAvailable: Boolean = true
) {
    fun getFormattedCoordinates(): String {
        return String.format(Locale.US, "%.5f, %.5f", latitude, longitude)
    }

    fun getFormattedTimestamp(): String {
        val sdf = SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}

class LocationHelper(private val context: Context) {

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @SuppressLint("MissingPermission")
    fun getLastKnownLocation(): UserLocationData? {
        try {
            val gpsLoc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            val netLoc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            val passiveLoc = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)

            val bestLoc = listOfNotNull(gpsLoc, netLoc, passiveLoc)
                .maxByOrNull { it.time }

            return bestLoc?.toUserData()
        } catch (e: Exception) {
            return null
        }
    }

    @SuppressLint("MissingPermission")
    fun requestLocationUpdates(): Flow<UserLocationData> = callbackFlow {
        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                trySend(location.toUserData())
            }
            @Deprecated("Deprecated in Java")
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        try {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    3000L,
                    5f,
                    listener
                )
            }
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    5000L,
                    10f,
                    listener
                )
            }
        } catch (e: Exception) {
            // Ignore permission error
        }

        val last = getLastKnownLocation()
        if (last != null) {
            trySend(last)
        }

        awaitClose {
            try {
                locationManager.removeUpdates(listener)
            } catch (e: Exception) {}
        }
    }

    private fun Location.toUserData(): UserLocationData {
        return UserLocationData(
            latitude = latitude,
            longitude = longitude,
            accuracyMeters = accuracy,
            timestamp = time,
            isAvailable = true
        )
    }
}
