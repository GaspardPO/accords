package eu.gaspard.accordsbackend.core


interface ChordsRepository {
    fun findExcatly(notes: Array<out Note>): Chord?

    fun findChordsContaining(notes: Array<out Note>): List<Chord>
}
