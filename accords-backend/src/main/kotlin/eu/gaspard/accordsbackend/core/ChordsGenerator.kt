package eu.gaspard.accordsbackend.core

class ChordsGenerator {

    fun generateAllChords(): List<Chord> =
        Note.values().flatMap { listOf(
            MajorChord(it),
            MinorChord(it),
            SeventhChord(it),
            MajorSeventhChord(it),
            MinorSeventhChord(it),
            MinorWithMajorSeventhChord(it),
            DiminishedChord(it),
            DiminishedSeventhChord(it),
            AugmentedChord(it)
        ) }
}
