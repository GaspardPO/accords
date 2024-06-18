package eu.gaspard.accordsbackend.core


interface ChordsRepository {
    fun findExcatly(notes: Array<out Note>): Chord?
}
