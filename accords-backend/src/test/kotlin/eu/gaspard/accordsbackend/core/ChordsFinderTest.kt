package eu.gaspard.accordsbackend.core

import eu.gaspard.accordsbackend.core.Note.*
import eu.gaspard.accordsbackend.core.chordsRepository.AllSimpleChordsRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChordsFinderTest {
    val chordsRepository: ChordsRepository = AllSimpleChordsRepository()

    val finder = ChordsFinder(chordsRepository)

    @Test
    fun should_return_Major_chords() {
        assertThat(finder.findExactly(C, E, G)?.name).isEqualTo("C")
        assertThat(finder.findExactly(E, Gs, B)?.name).isEqualTo("E")
        assertThat(finder.findExactly(D, Fs, A)?.name).isEqualTo("D")
        assertThat(finder.findExactly(F, A, C)?.name).isEqualTo("F")
        assertThat(finder.findExactly(G, B, D)?.name).isEqualTo("G")
        assertThat(finder.findExactly(A, Cs, E)?.name).isEqualTo("A")
        assertThat(finder.findExactly(As, D, F)?.name).isEqualTo("Bb")

        // reversed:
        assertThat(finder.findExactly(E, G, C)?.name).isEqualTo("C")
        assertThat(finder.findExactly(G, C, E)?.name).isEqualTo("C")
    }

    @Test
    fun should_return_Minor_chords() {
        assertThat(finder.findExactly(A, C, E)?.name).isEqualTo("Am")
        assertThat(finder.findExactly(As, Cs, F)?.name).isEqualTo("Bbm")
        assertThat(finder.findExactly(C, Ds, G)?.name).isEqualTo("Cm")

        // reversed:
        assertThat(finder.findExactly(E, A, C)?.name).isEqualTo("Am")
        assertThat(finder.findExactly(E, C, A)?.name).isEqualTo("Am")
    }

    @Test
    fun should_return_empty_when_not_found() {
        assertThat(finder.findExactly(A, B, C, D, E)).isNull()
    }

    @Test
    fun should_return_empty_when_not_precise_enough() {
        assertThat(finder.findExactly(A)).isNull()
        assertThat(finder.findExactly(A, E)).isNull()
    }

    @Test
    fun should_find_plausibles_chords() {
        assertThat(finder.find(C, E))
            .containsExactlyInAnyOrder(
                MinorChord(A),
                MinorSeventhChord(A),
                MinorWithMajorSeventhChord(A),
                MajorChord(C),
                MajorSeventhChord(C),
                SeventhChord(C),
                AugmentedChord(C),
                MinorWithMajorSeventhChord(Cs),
                MajorSeventhChord(F),
                MinorWithMajorSeventhChord(F),
                AugmentedChord(Gs),
                AugmentedChord(E),
                )
    }
}