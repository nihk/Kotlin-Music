package music.pitches

open class PitchClass(
        val pitchLetter: PitchLetter,
        val accidental: Accidental = Accidental(AccidentalSign.Natural)) {

    operator fun plus(pitchClass: PitchClass): PitchClass =
            plus(PitchUtils.setTheoryNumber(pitchClass.pitchLetter) + pitchClass.accidental.semitoneDistance())

    operator fun plus(i :Int): PitchClass {
        val setTheoryNumber = PitchUtils.setTheoryNumber(pitchLetter) + accidental.semitoneDistance()
        val newSetTheoryNumber = (setTheoryNumber + i) % PitchUtils.numPitchesInOctave

        return PitchUtils.nearestPitchClass(newSetTheoryNumber)
    }

    override fun toString() = pitchLetter.toString() + accidental.toString()

    operator fun minus(i: Int) = plus(-i)

    operator fun inc() = plus(1)

    operator fun dec() = minus(1)
}