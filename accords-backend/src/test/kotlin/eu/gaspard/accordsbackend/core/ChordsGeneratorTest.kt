package eu.gaspard.accordsbackend.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChordsGeneratorTest{

    @Test
    fun generate_all_chords(){
        val nb_of_differents_types_of_chords = 9
        // minor, major, seventh, maj7, min7, m(maj7), dim, dim7, aug
        val nb_of_notes = 12
        assertThat(ChordsGenerator().generateAllChords())
            .hasSize(nb_of_notes * nb_of_differents_types_of_chords)
    }
}