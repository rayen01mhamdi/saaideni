package com.example.sos

import com.example.sos.data.repository.CountryRepository
import org.junit.Assert.*
import org.junit.Test

class CountryRepositoryTest {

    @Test
    fun testCountryDatasetContainsPopularDestinations() {
        val countries = CountryRepository.countries
        assertTrue(countries.size >= 20)
    }

    @Test
    fun testGetByCode_ValidCodes() {
        val us = CountryRepository.getByCode("US")
        assertNotNull(us)
        assertEquals("United States", us?.nameEn)

        val fr = CountryRepository.getByCode("FR")
        assertNotNull(fr)
        assertEquals("France", fr?.nameEn)

        val sa = CountryRepository.getByCode("SA")
        assertNotNull(sa)
        assertEquals("Saudi Arabia", sa?.nameEn)
    }

    @Test
    fun testGetByCode_CaseInsensitive() {
        val usLower = CountryRepository.getByCode("us")
        assertNotNull(usLower)
        assertEquals("US", usLower?.code)
    }

    @Test
    fun testDefaultCountryFallback() {
        val defaultCty = CountryRepository.getDefaultCountry()
        assertNotNull(defaultCty)
        assertEquals("US", defaultCty.code)
    }
}
