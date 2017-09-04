package music.pitches

open class Pitch(
        pitchLetter: PitchLetter,
        accidental: Accidental,
        val octave: Int)
    : PitchClass(pitchLetter, accidental) {

    init {
        if (octave < 0) {
            throw ExceptionInInitializerError("Octave must be a positive value. Was given: $octave")
        }
    }

    constructor(pitchClass: PitchClass, octave: Int)
            : this(pitchClass.pitchLetter, pitchClass.accidental, octave)

    override fun toString() = super.toString() + octave
}