package music

import music.chords.Chord
import music.pitches.*

fun main(args: Array<String>) {
    val dDoubleFlat4 = PitchParser.parsePitch("Dbb4")
    println(dDoubleFlat4)                        // Dbb4
    println(dDoubleFlat4.pitchLetter)            // D
    println(dDoubleFlat4.accidental)             // bb
    println(dDoubleFlat4.octave)                 // 4
    println(PitchUtils.frequency(dDoubleFlat4))  // 261.6255653005986

    val gHalfDiminished7th = Chord.fromPitchStrings("G4", "Bb4", "Db4", "F5")
    println(gHalfDiminished7th)                  // [G4, Bb4, Db4, F5]
}