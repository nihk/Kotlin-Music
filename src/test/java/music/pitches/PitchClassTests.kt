package music.pitches

import org.junit.Assert
import org.junit.Test

class PitchClassTests {
    val c = PitchClass(PitchLetter.C, Accidental(AccidentalSign.Natural))
    val d = PitchClass(PitchLetter.D, Accidental(AccidentalSign.Natural))
    val dFlat = PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat))
    val eSharp = PitchClass(PitchLetter.E, Accidental(AccidentalSign.Sharp))
    val g = PitchClass(PitchLetter.G, Accidental(AccidentalSign.Natural))
    val aSharp = PitchClass(PitchLetter.A, Accidental(AccidentalSign.Sharp))
    val bFlat = PitchClass(PitchLetter.B, Accidental(AccidentalSign.Flat))

    @Test
    fun plus_basic() {
        Assert.assertEquals(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat)), c + dFlat)
        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental(AccidentalSign.Natural)), d + d)
        Assert.assertEquals(PitchClass(PitchLetter.A, Accidental(AccidentalSign.Flat)), g + dFlat)
        Assert.assertEquals(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Natural)), g + g)
        Assert.assertEquals(PitchClass(PitchLetter.A, Accidental(AccidentalSign.Flat)), aSharp + bFlat)
        Assert.assertEquals(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Natural)), eSharp + g)
        Assert.assertEquals(PitchClass(PitchLetter.G, Accidental(AccidentalSign.Flat)), eSharp + dFlat)
    }
}