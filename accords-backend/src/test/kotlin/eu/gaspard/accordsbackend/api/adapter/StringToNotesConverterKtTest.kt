package eu.gaspard.accordsbackend.api.adapter

import eu.gaspard.accordsbackend.core.Note.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringToNotesConverterShould {

    @Test
    fun should_extract_notes() {
        assertThat("C#,F,A#".asNotes()).containsExactly(Cs, F, As)
        assertThat("C,A,F".asNotes()).containsExactly(C, A, F)
        assertThat("B,E,F".asNotes()).containsExactly(B, E, F)
    }

    @Test
    fun should_extract_notes_with_spaces() {
        assertThat("C# F A#".asNotes()).containsExactly(Cs, F, As)
        assertThat("C A F".asNotes()).containsExactly(C, A, F)
    }

    @Test
    fun should_extract_notes_with_lowercases() {
        assertThat("c# f a#".asNotes()).containsExactly(Cs, F, As)
        assertThat("c a f".asNotes()).containsExactly(C, A, F)
        assertThat("b,e,f".asNotes()).containsExactly(B, E, F)
    }

    @Test
    fun should_extract_notes_with_s_for_sharp() {
        assertThat("cs f as".asNotes()).containsExactly(Cs, F, As)
        assertThat("Cs f As".asNotes()).containsExactly(Cs, F, As)
    }

    @Test
    fun should_extract_notes_with_b_for_flat() {
        assertThat("c f ab".asNotes()).containsExactly(C, F, Gs)
        assertThat("Eb Bb Ab".asNotes()).containsExactly(Ds, As, Gs)
        assertThat("eb bb ab".asNotes()).containsExactly(Ds, As, Gs)
        assertThat("ebbbab".asNotes()).containsExactly(Ds, As, Gs)
        assertThat("eb".asNotes()).containsExactly(Ds) // and not E, B
        assertThat("e,b".asNotes()).containsExactly(E, B)
        assertThat("e b".asNotes()).containsExactly(E, B)
    }

    @Test
    fun should_remove_invalid_symbols() {
        assertThat("a,k".asNotes()).containsExactly(A)
        assertThat("akjd".asNotes()).containsExactly(A,D)
        assertThat("éé".asNotes()).isEmpty()
    }
}