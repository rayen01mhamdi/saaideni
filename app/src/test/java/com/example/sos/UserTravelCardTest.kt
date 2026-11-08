package com.example.sos

import com.example.sos.data.model.UserTravelCard
import org.junit.Assert.*
import org.junit.Test

class UserTravelCardTest {

    @Test
    fun testEmptyCardState() {
        val emptyCard = UserTravelCard()
        assertTrue(emptyCard.isEmpty())
    }

    @Test
    fun testFilledCardState() {
        val filledCard = UserTravelCard(
            fullName = "John Doe",
            emergencyContactName = "Jane Doe",
            emergencyContactPhone = "+123456789"
        )
        assertFalse(filledCard.isEmpty())
    }
}
