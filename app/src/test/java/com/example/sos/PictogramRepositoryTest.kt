package com.example.sos

import com.example.sos.data.model.PictogramCategory
import com.example.sos.data.repository.PictogramRepository
import org.junit.Assert.*
import org.junit.Test

class PictogramRepositoryTest {

    @Test
    fun testPictogramsDatasetNotEmpty() {
        val pictograms = PictogramRepository.pictograms
        assertTrue(pictograms.isNotEmpty())
    }

    @Test
    fun testCategoryFiltering() {
        val medical = PictogramRepository.getByCategory(PictogramCategory.MEDICAL)
        assertTrue(medical.isNotEmpty())
        assertTrue(medical.all { it.category == PictogramCategory.MEDICAL })
    }

    @Test
    fun testSentenceComposition_English() {
        val pictograms = PictogramRepository.pictograms.take(2)
        val composed = PictogramRepository.composeSentence(pictograms, "en")

        val expected = "${pictograms[0].getText("en")}. ${pictograms[1].getText("en")}."
        assertEquals(expected, composed)
    }

    @Test
    fun testSentenceComposition_French() {
        val pictograms = PictogramRepository.pictograms.take(2)
        val composed = PictogramRepository.composeSentence(pictograms, "fr")

        val expected = "${pictograms[0].getText("fr")}. ${pictograms[1].getText("fr")}."
        assertEquals(expected, composed)
    }

    @Test
    fun testSentenceComposition_Arabic() {
        val pictograms = PictogramRepository.pictograms.take(2)
        val composed = PictogramRepository.composeSentence(pictograms, "ar")

        val expected = "${pictograms[0].getText("ar")} • ${pictograms[1].getText("ar")}"
        assertEquals(expected, composed)
    }

    @Test
    fun testFallbackToEnglish_WhenLanguageUnknown() {
        val pictogram = PictogramRepository.pictograms.first()
        val text = pictogram.getText("unknown_lang")
        assertEquals(pictogram.getText("en"), text)
    }
}
