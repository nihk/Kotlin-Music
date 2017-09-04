package music.pitches

enum class AccidentalSign(val value: Int) {
    Flat(-1), Natural(0), Sharp(1);

    override fun toString() = when (this) {
        Flat -> "b"
        Natural -> ""
        Sharp -> "#"
    }
}