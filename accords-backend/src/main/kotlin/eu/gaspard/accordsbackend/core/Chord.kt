package eu.gaspard.accordsbackend.core

abstract class Chord(val notes: List<Note>, val suffix: String = "") {

    val name: String
        get() = notes[0].note_as_string + suffix

    constructor(root: Note, intervals: IntArray, suffix: String = "") :
            this(intervals.map(root::noteAfterInterval),  suffix)

    fun containsExactly(notes: Array<out Note>) =
        this.notes.toSortedSet().equals(notes.toSet())

    fun contains(notes: Array<out Note>): Boolean =
        this.notes.toSortedSet().containsAll(notes.toList())

    override fun toString(): String {
        return "$name ($notes)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Chord) return false

        if (notes != other.notes) return false
        if (suffix != other.suffix) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = notes.hashCode()
        result = 31 * result + suffix.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }


}

class MajorChord(root: Note) : Chord(root, intArrayOf(0, 4, 7))
class MinorChord(root: Note) : Chord(root, intArrayOf(0, 3, 7), "m")
class SeventhChord(root: Note) : Chord(root, intArrayOf(0, 4, 7, 10), "7")
class MajorSeventhChord(root: Note) : Chord(root, intArrayOf(0, 4, 7, 11), "maj7")
class MinorSeventhChord(root: Note) : Chord(root, intArrayOf(0, 3, 7, 10), "m7")
class MinorWithMajorSeventhChord(root: Note) : Chord(root, intArrayOf(0, 3, 7, 11), "m(maj7)")
class DiminishedChord(root: Note) : Chord(root, intArrayOf(0, 3, 6), "dim")
class DiminishedSeventhChord(root: Note) : Chord(root, intArrayOf(0, 3, 6, 9), "dim7")
class AugmentedChord(root: Note) : Chord(root, intArrayOf(0, 4, 8), "aug")
