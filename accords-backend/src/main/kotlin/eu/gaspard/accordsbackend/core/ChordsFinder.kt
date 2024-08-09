package eu.gaspard.accordsbackend.core

import org.springframework.stereotype.Service

@Service
class ChordsFinder(val chordsRepository: ChordsRepository) {


    fun findExactly(vararg notes: Note): Chord? = chordsRepository.findExcatly(notes)

    fun find(vararg notes : Note): List<Chord> {
        return chordsRepository.findChordsContaining(notes)
    }
}
