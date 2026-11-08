package com.example.sos

import com.example.sos.data.model.FacilityType
import com.example.sos.data.repository.FacilityRepository
import org.junit.Assert.*
import org.junit.Test

class FacilityRepositoryTest {

    @Test
    fun testFacilitiesListNotEmpty() {
        assertTrue(FacilityRepository.facilities.isNotEmpty())
    }

    @Test
    fun testCalculateDistanceKm() {
        // Distance between NYC Bellevue (40.7388, -73.9754) and NYPD Precinct (40.7371, -73.9822) ~0.6 km
        val dist = FacilityRepository.calculateDistanceKm(40.7388, -73.9754, 40.7371, -73.9822)
        assertTrue(dist > 0.1 && dist < 2.0)
    }

    @Test
    fun testGetNearestFacility_Hospital() {
        // User in NYC (40.7380, -73.9800)
        val nearest = FacilityRepository.getNearestFacility(40.7380, -73.9800, FacilityType.HOSPITAL, "US")
        assertNotNull(nearest)
        assertEquals("NYC Health + Hospitals / Bellevue", nearest?.first?.nameEn)
    }
}
