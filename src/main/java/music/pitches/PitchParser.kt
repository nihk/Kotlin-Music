package music.pitches

object PitchParser {
    fun parsePitch(pitch: String): Pitch {
        val pitchClass = parsePitchClass(pitch)
        val octave = parseOctave(pitch)

        return Pitch(pitchClass, octave)
    }

    fun parsePitchClass(pitchClass: String): PitchClass {
        if (pitchClass.isEmpty()) {
            throw Exception("Given an empty String to parse")
        }

        val it = pitchClass.iterator()
        val pitchLetter = parsePitchLetter(it)
        val accidental = parseAccidental(it)

        return PitchClass(pitchLetter, accidental)
    }

    private fun parsePitchLetter(it: CharIterator) = when (it.next().toUpperCase()) {
        'C' -> PitchLetter.C
        'D' -> PitchLetter.D
        'E' -> PitchLetter.E
        'F' -> PitchLetter.F
        'G' -> PitchLetter.G
        'A' -> PitchLetter.A
        'B' -> PitchLetter.B
        else -> throw Exception("Not a parsable character!")
    }

    private fun parseAccidental(it: CharIterator): Accidental {
        if (!it.hasNext()) {
            return Accidental(AccidentalSign.Natural)
        }

        var quantity = 0
        var accidentalSign = AccidentalSign.Natural
        var done = false

        while (it.hasNext() && !done) {
            val nextChar = it.nextChar()

            if (nextChar.isDigit()) {
                done = true
            } else if (nextChar.equals('b')) {
                accidentalSign = AccidentalSign.Flat
                ++quantity
            } else if (nextChar.equals('#')) {
                accidentalSign = AccidentalSign.Sharp
                ++quantity
            } else {
                throw Exception("Unknown accidental character")
            }
        }

        return Accidental(accidentalSign, Math.max(quantity, 1))
    }

    private fun parseOctave(pitchStr: String): Int {
        val octave = pitchStr[pitchStr.length - 1]
        if (octave.isDigit()) {
            return octave.toString().toInt()
        } else {
            throw Exception("No octave exists")
        }
    }
}