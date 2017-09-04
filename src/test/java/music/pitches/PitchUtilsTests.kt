package music.pitches

import org.junit.Assert
import org.junit.Test

class PitchUtilsTests {
    private val delta = 0.001

    @Test
    fun frequencies_naturals_octave0() {
        val c0 = Pitch(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Natural)), 0)
        val d0 = Pitch(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Natural)), 0)
        val e0 = Pitch(PitchClass(PitchLetter.E, Accidental(AccidentalSign.Natural)), 0)
        val f0 = Pitch(PitchClass(PitchLetter.F, Accidental(AccidentalSign.Natural)), 0)
        val g0 = Pitch(PitchClass(PitchLetter.G, Accidental(AccidentalSign.Natural)), 0)
        val a0 = Pitch(PitchClass(PitchLetter.A, Accidental(AccidentalSign.Natural)), 0)
        val b0 = Pitch(PitchClass(PitchLetter.B, Accidental(AccidentalSign.Natural)), 0)

        val c0Frequency = PitchUtils.frequency(c0)
        val d0Frequency = PitchUtils.frequency(d0)
        val e0Frequency = PitchUtils.frequency(e0)
        val f0Frequency = PitchUtils.frequency(f0)
        val g0Frequency = PitchUtils.frequency(g0)
        val a0Frequency = PitchUtils.frequency(a0)
        val b0Frequency = PitchUtils.frequency(b0)

        Assert.assertEquals(16.351, c0Frequency, delta)
        Assert.assertEquals(18.354, d0Frequency, delta)
        Assert.assertEquals(20.601, e0Frequency, delta)
        Assert.assertEquals(21.826, f0Frequency, delta)
        Assert.assertEquals(24.499, g0Frequency, delta)
        Assert.assertEquals(27.500, a0Frequency, delta)
        Assert.assertEquals(30.867, b0Frequency, delta)
    }

    @Test
    fun frequencies_naturals_arbitrary() {
        val a1 = Pitch(PitchClass(PitchLetter.A, Accidental(AccidentalSign.Natural)), 1)
        val c1 = Pitch(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Natural)), 1)
        val a2 = Pitch(PitchClass(PitchLetter.A, Accidental(AccidentalSign.Natural)), 2)
        val g6 = Pitch(PitchClass(PitchLetter.G, Accidental(AccidentalSign.Natural)), 6)
        val e7 = Pitch(PitchClass(PitchLetter.E, Accidental(AccidentalSign.Natural)), 7)
        val c8 = Pitch(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Natural)), 8)

        val a1Frequency = PitchUtils.frequency(a1)
        val c1Frequency = PitchUtils.frequency(c1)
        val a2Frequency = PitchUtils.frequency(a2)
        val g6Frequency = PitchUtils.frequency(g6)
        val e7Frequency = PitchUtils.frequency(e7)
        val c8Frequency = PitchUtils.frequency(c8)

        Assert.assertEquals(55.000, a1Frequency, delta)
        Assert.assertEquals(32.703, c1Frequency, delta)
        Assert.assertEquals(110.000, a2Frequency, delta)
        Assert.assertEquals(1567.981, g6Frequency, delta)
        Assert.assertEquals(2637.020, e7Frequency, delta)
        Assert.assertEquals(4186.009, c8Frequency, delta)
    }

    @Test
    fun frequencies_basic_accidentals() {
        val fSharp2 = Pitch(PitchClass(PitchLetter.F, Accidental(AccidentalSign.Sharp)), 2)
        val cSharp3 = Pitch(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Sharp)), 3)
        val dFlat3 = Pitch(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat)), 3)
        val dFlat4 = Pitch(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat)), 4)
        val eSharp4 = Pitch(PitchClass(PitchLetter.E, Accidental(AccidentalSign.Sharp)), 4)
        val bFlat5 = Pitch(PitchClass(PitchLetter.B, Accidental(AccidentalSign.Flat)), 5)

        val fSharp2Frequency = PitchUtils.frequency(fSharp2)
        val cSharp3Frequency = PitchUtils.frequency(cSharp3)
        val dFlat3Frequency = PitchUtils.frequency(dFlat3)
        val dFlat4Frequency = PitchUtils.frequency(dFlat4)
        val eSharp4Frequency = PitchUtils.frequency(eSharp4)
        val bFlat5Frequency = PitchUtils.frequency(bFlat5)

        Assert.assertEquals(92.498, fSharp2Frequency, delta)
        Assert.assertEquals(138.591, cSharp3Frequency, delta)
        Assert.assertEquals(138.591, dFlat3Frequency, delta)
        Assert.assertEquals(277.182, dFlat4Frequency, delta)
        Assert.assertEquals(349.228, eSharp4Frequency, delta)
        Assert.assertEquals(932.328, bFlat5Frequency, delta)
    }

    @Test
    fun frequencies_extended_accidentals() {
        val fDblSharp2 = Pitch(PitchClass(PitchLetter.F, Accidental(AccidentalSign.Sharp, 2)), 2)
        val cDblSharp3 = Pitch(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Sharp, 2)), 3)
        val dDblFlat3 = Pitch(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat, 2)), 3)
        val dTrplFlat4 = Pitch(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat, 3)), 4)
        val eQuadSharp4 = Pitch(PitchClass(PitchLetter.E, Accidental(AccidentalSign.Sharp, 4)), 4)
        val bQuinFlat5 = Pitch(PitchClass(PitchLetter.B, Accidental(AccidentalSign.Flat, 5)), 5)

        val fDblSharp2Frequency = PitchUtils.frequency(fDblSharp2)
        val cDblSharp3Frequency = PitchUtils.frequency(cDblSharp3)
        val dDblFlat3Frequency = PitchUtils.frequency(dDblFlat3)
        val dTrplFlat4Frequency = PitchUtils.frequency(dTrplFlat4)
        val eQuadSharp4Frequency = PitchUtils.frequency(eQuadSharp4)
        val bQuinFlat5Frequency = PitchUtils.frequency(bQuinFlat5)

        Assert.assertEquals(97.998, fDblSharp2Frequency, delta)
        Assert.assertEquals(146.832, cDblSharp3Frequency, delta)
        Assert.assertEquals(130.813, dDblFlat3Frequency, delta)
        Assert.assertEquals(246.942, dTrplFlat4Frequency, delta)
        Assert.assertEquals(415.305, eQuadSharp4Frequency, delta)
        Assert.assertEquals(739.989, bQuinFlat5Frequency, delta)
    }

    @Test
    fun frequencies_edgecase_accidentals() {
        val bSharp2 = Pitch(PitchClass(PitchLetter.B, Accidental(AccidentalSign.Sharp)), 2)
        val cFlat3 = Pitch(PitchClass(PitchLetter.C, Accidental(AccidentalSign.Flat)), 3)

        val bSharp2Frequency = PitchUtils.frequency(bSharp2)
        val cFlat3Frequency = PitchUtils.frequency(cFlat3)

        Assert.assertEquals(130.813, bSharp2Frequency, delta)
        Assert.assertEquals(123.471, cFlat3Frequency, delta)
    }

    @Test
    fun mod12() {
        val negative = -5
        val largeNumber = 20
        val basicNumber = 8

        val result1 = PitchUtils.mod12(negative)
        val result2 = PitchUtils.mod12(largeNumber)
        val result3 = PitchUtils.mod12(basicNumber)

        Assert.assertEquals(7, result1)
        Assert.assertEquals(8, result2)
        Assert.assertEquals(8, result3)
    }
}