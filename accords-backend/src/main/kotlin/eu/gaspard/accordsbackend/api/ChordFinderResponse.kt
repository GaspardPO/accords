package eu.gaspard.accordsbackend.api

import eu.gaspard.accordsbackend.core.Chord

data class ChordFinderResponse(val chord: Chord?, val otherPlausibleChords: List<Chord>)
