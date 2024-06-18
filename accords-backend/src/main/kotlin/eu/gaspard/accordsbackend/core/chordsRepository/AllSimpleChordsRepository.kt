package eu.gaspard.accordsbackend.core.chordsRepository

import eu.gaspard.accordsbackend.core.Chord
import eu.gaspard.accordsbackend.core.ChordsRepository
import eu.gaspard.accordsbackend.core.Note
import org.springframework.stereotype.Repository

@Repository
class AllSimpleChordsRepository : ChordsRepository {

    val allsimpleChords = ChordsGenerator().generateAllChords()

    override fun findExcatly(notes: Array<out Note>): Chord? {
        return allsimpleChords.find { it.containsExactly(notes) }
    }
}