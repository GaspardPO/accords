package eu.gaspard.accordsbackend.api

import eu.gaspard.accordsbackend.api.adapter.asNotes
import eu.gaspard.accordsbackend.core.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notesToChord")
class ChordController(private val chordsFinder: ChordsFinder) {

    @GetMapping
    fun translateNotesToChord(@RequestParam(name = "notes") notesAsString: String): Chord {
        val notes = notesAsString.asNotes()
        if (notes.isEmpty()) throw IllegalArgumentException("\"$notes\" does not contains a valid note.")
        return chordsFinder.findExactly(*notes)!!
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
}