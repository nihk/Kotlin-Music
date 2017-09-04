package music.pitches

import kotlin.math.abs

data class Accidental(val sign: AccidentalSign, val quantity: Int = 1) {

    init {
        if (quantity < 1) {
            throw ExceptionInInitializerError("Accidental quantity cannot be less than 1. Was given: $quantity")
        }
    }

    fun semitoneDistance() = sign.value * quantity

    operator fun plus(accidental: Accidental) = plus(accidental.semitoneDistance())

    operator fun plus(i: Int): Accidental {
        val result = semitoneDistance() + i

        return when {
            result > 0 -> Accidental(AccidentalSign.Sharp, result)
            result < 0 -> Accidental(AccidentalSign.Flat, abs(result))
            else -> Accidental(AccidentalSign.Natural)
        }
    }

    operator fun minus(i: Int) = plus(-i)

    operator fun inc() = plus(1)

    operator fun dec() = minus(1)

    // TODO: Consider the notation for double-sharps: i.e. 'x' rather than '##'
    override fun toString(): String {
        val signString = sign.toString()
        val stringBuilder = StringBuilder(signString)
        for (i in 1 until quantity) {
            stringBuilder.append(signString)
        }

        return stringBuilder.toString()
    }
}