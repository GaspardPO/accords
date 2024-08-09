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
    fun translateNotesToChord(@RequestParam(name = "notes") notesAsString: String): ChordFinderResponse {
        val notes = notesAsString.asNotes()
        if (notes.isEmpty()) throw IllegalArgumentException("\"$notesAsString\" does not contains a valid note.")
        val exactChord = chordsFinder.findExactly(*notes)
        val plausibleChords = chordsFinder.find(*notes).toMutableList()
        plausibleChords.remove(exactChord)

        return ChordFinderResponse(exactChord, plausibleChords)
    }
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
}