package eu.gaspard.accordsbackend.core

class ChordsFinder(private val allChords: List<Chord>) {
    fun findExactly(vararg notes: Note): Chord? =
        allChords.firstOrNull { it.containsExactly(notes) }
}
