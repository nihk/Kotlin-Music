package music.chords

import music.pitches.PitchClass
import music.pitches.PitchParser

class Chord(vararg pitchClasses: PitchClass) {
    val members = setOf(*pitchClasses)

    companion object {
        fun fromPitchStrings(vararg pitchClasses: String): Chord {
            val list = ArrayList<PitchClass>(pitchClasses.size)
            pitchClasses.forEach { pc -> list.add(PitchParser.parsePitch(pc)) }
            val arr = list.toTypedArray()
            return Chord(*arr)
        }
    }

    override fun toString() = members.toString()
}