package eu.gaspard.accordsbackend.api

import eu.gaspard.accordsbackend.api.adapter.asNotes
import eu.gaspard.accordsbackend.core.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/notesToChord")
class ChordController(private val chordsFinder: ChordsFinder) {

    @GetMapping
    fun translateNotesToChord(@RequestParam notes: String): Chord {
        return chordsFinder.findExactly(*notes.asNotes())!!
    }
}