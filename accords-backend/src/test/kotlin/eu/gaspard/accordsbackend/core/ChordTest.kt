package eu.gaspard.accordsbackend.core

import eu.gaspard.accordsbackend.core.Note.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChordTest {

    @Test
    fun should_create_major_chord() {
        val cMajor = MajorChord(C)
        assertThat(cMajor.notes).containsOnly(C, E, G)
        assertThat(cMajor.name).isEqualTo("C")

        val bMajor = MajorChord(B)
        assertThat(bMajor.notes).containsOnly(B, Ds, Fs)
        assertThat(bMajor.name).isEqualTo("B")
    }

    @Test
    fun should_create_minor_chord() {
        val cMinor = MinorChord(C)
        assertThat(cMinor.notes).containsOnly(C, Ds, G)
        assertThat(cMinor.name).isEqualTo("Cm")

        val aMinor = MinorChord(A)
        assertThat(aMinor.notes).containsOnly(A, C, E)
        assertThat(aMinor.name).isEqualTo("Am")
    }

    @Test
    fun should_create_seventh_chord() {
        val c7 = SeventhChord(C)
        assertThat(c7.notes).containsOnly(C, E, G, As)
        assertThat(c7.name).isEqualTo("C7")


        val b7 = SeventhChord(B)
        assertThat(b7.notes).containsOnly(B, Ds, Fs, A)
        assertThat(b7.name).isEqualTo("B7")

        val cMajor7 = MajorSeventhChord(C)
        assertThat(cMajor7.notes).containsOnly(C, E, G, B)
        assertThat(cMajor7.name).isEqualTo("Cmaj7")

        val cm7 = MinorSeventhChord(C)
        assertThat(cm7.notes).containsOnly(C, Ds, G, As)
        assertThat(cm7.name).isEqualTo("Cm7")

        val cmMaj7 = MinorWithMajorSeventhChord(C)
        assertThat(cmMaj7.notes).containsOnly(C, Ds, G, B)
        assertThat(cmMaj7.name).isEqualTo("Cm(maj7)")
    }

    @Test
    fun should_create_other_chords(){
        val CDim = DiminishedChord(C)
        assertThat(CDim.notes).containsOnly(C, Ds, Fs)
        assertThat(CDim.name).isEqualTo("Cdim")

        val CDim7 = DiminishedSeventhChord(C)
        assertThat(CDim7.notes).containsOnly(C, Ds, Fs, A)
        assertThat(CDim7.name).isEqualTo("Cdim7")

        val CAug = AugmentedChord(C)
        assertThat(CAug.notes).containsOnly(C, E, Gs)
        assertThat(CAug.name).isEqualTo("Caug")
    }
}