package music.pitches

object PitchUtils {
    val numPitchesInOctave = 12
    private val pianoKeyShift = 8;

    fun frequency(pitch: Pitch): Double {
        val pianoKey = pianoKey(pitch)

        // Source: https://en.wikipedia.org/wiki/Piano_key_frequencies
        return Math.pow(2.0, (pianoKey - 49) / 12.0) * 440.0;
    }

    private fun pianoKey(pitch: Pitch): Int {
        val setTheoryNumber = setTheoryNumber(pitch.pitchLetter)
        val accidental = pitch.accidental

        return setTheoryNumber + pitch.octave * numPitchesInOctave + accidental.semitoneDistance() - pianoKeyShift
    }

    fun setTheoryNumber(pitchLetter: PitchLetter) = when (pitchLetter) {
        PitchLetter.C -> 0
        PitchLetter.D -> 2
        PitchLetter.E -> 4
        PitchLetter.F -> 5
        PitchLetter.G -> 7
        PitchLetter.A -> 9
        PitchLetter.B -> 11
    }

    /**
     * @param leaningAccidental Since there's no one-to-one mapping of a set theory number to a pitch class, e.g.
     * 6 could be both F# or Gb, this parameter decides what the accidental preference should be to break these 'ties'.
     */
    fun nearestPitchClass(setTheoryNumber: Int, leaningAccidental: AccidentalSign = AccidentalSign.Flat): PitchClass {
        val isFlatLeaning = leaningAccidental == AccidentalSign.Flat

        return when (setTheoryNumber) {
            0 -> PitchClass(PitchLetter.C)
            1 -> if (isFlatLeaning) {
                PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat))
            } else {
                PitchClass(PitchLetter.C, Accidental(AccidentalSign.Sharp))
            }
            2 -> PitchClass(PitchLetter.D)
            3 -> if (isFlatLeaning) {
                PitchClass(PitchLetter.E, Accidental(AccidentalSign.Flat))
            } else {
                PitchClass(PitchLetter.D, Accidental(AccidentalSign.Sharp))
            }
            4 -> PitchClass(PitchLetter.E)
            5 -> PitchClass(PitchLetter.F)
            6 -> if (isFlatLeaning) {
                PitchClass(PitchLetter.G, Accidental(AccidentalSign.Flat))
            } else {
                PitchClass(PitchLetter.F, Accidental(AccidentalSign.Sharp))
            }
            7 -> PitchClass(PitchLetter.G)
            8 -> if (isFlatLeaning) {
                PitchClass(PitchLetter.A, Accidental(AccidentalSign.Flat))
            } else {
                PitchClass(PitchLetter.G, Accidental(AccidentalSign.Sharp))
            }
            9 -> PitchClass(PitchLetter.A)
            10 -> if (isFlatLeaning) {
                PitchClass(PitchLetter.B, Accidental(AccidentalSign.Flat))
            } else {
                PitchClass(PitchLetter.A, Accidental(AccidentalSign.Sharp))
            }
            11 -> PitchClass(PitchLetter.B)
            else -> throw UnsupportedOperationException("$setTheoryNumber needs to be between 0 and ${numPitchesInOctave}")
        }
    }

    fun mod12(value: Int) = modN(value, numPitchesInOctave)

    fun modN(value: Int, mod: Int): Int {
        var result = value
        while (result < 0) {
            result += mod
        }

        return result % mod
    }
}