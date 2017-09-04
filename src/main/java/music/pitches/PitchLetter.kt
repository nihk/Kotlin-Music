package music.pitches

enum class PitchLetter {
    A, B, C, D, E, F, G;

    operator fun plus(pitchLetter: PitchLetter) = this + pitchLetter.ordinal

    operator fun plus(i: Int): PitchLetter {
        val values = values()
        val size = values.size
        var plusValue = i

        while (plusValue < 0) {
            plusValue += size
        }

        val nextIndex = (this.ordinal + plusValue) % size
        return values[nextIndex]
    }

    operator fun minus(i: Int) = plus(-i)

    operator fun inc() = plus(1)

    operator fun dec() = minus(1)
}