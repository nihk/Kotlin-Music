package music.pitches

import org.junit.Assert
import org.junit.Test

class PitchParserTests {

    @Test
    fun parse_pitchClass_noAccidental() {
        val c = "C"

        val cParsed = PitchParser.parsePitchClass(c)

        Assert.assertEquals(PitchLetter.C, cParsed.pitchLetter)
        Assert.assertEquals(AccidentalSign.Natural, cParsed.accidental.sign)
        Assert.assertEquals(1, cParsed.accidental.quantity)
    }

    @Test
    fun parse_pitchClass_basicAccidental() {
        val dFlat = "Db"
        val eSharp = "E#"
        val bFlat = "Bb"

        val dFlatParsed = PitchParser.parsePitchClass(dFlat)
        val eSharpParsed = PitchParser.parsePitchClass(eSharp)
        val bFlatParsed = PitchParser.parsePitchClass(bFlat)

        Assert.assertEquals(PitchLetter.D, dFlatParsed.pitchLetter)
        Assert.assertEquals(PitchLetter.E, eSharpParsed.pitchLetter)
        Assert.assertEquals(PitchLetter.B, bFlatParsed.pitchLetter)
        Assert.assertEquals(AccidentalSign.Flat, dFlatParsed.accidental.sign)
        Assert.assertEquals(AccidentalSign.Sharp, eSharpParsed.accidental.sign)
        Assert.assertEquals(AccidentalSign.Flat, bFlatParsed.accidental.sign)
        Assert.assertEquals(1, dFlatParsed.accidental.quantity)
        Assert.assertEquals(1, eSharpParsed.accidental.quantity)
        Assert.assertEquals(1, bFlatParsed.accidental.quantity)
    }

    @Test
    fun parse_pitchClass_extendedAccidental() {
        val dDoubleFlat = "Dbb"
        val eTripleSharp = "E###"

        val dDoubleFlatParsed = PitchParser.parsePitchClass(dDoubleFlat)
        val eTripleSharpParsed = PitchParser.parsePitchClass(eTripleSharp)

        Assert.assertEquals(PitchLetter.D, dDoubleFlatParsed.pitchLetter)
        Assert.assertEquals(PitchLetter.E, eTripleSharpParsed.pitchLetter)
        Assert.assertEquals(AccidentalSign.Flat, dDoubleFlatParsed.accidental.sign)
        Assert.assertEquals(AccidentalSign.Sharp, eTripleSharpParsed.accidental.sign)
        Assert.assertEquals(2, dDoubleFlatParsed.accidental.quantity)
        Assert.assertEquals(3, eTripleSharpParsed.accidental.quantity)
    }

    @Test
    fun parse_pitch() {
        val cSharp4 = "C#4"
        val aFlat3 = "Ab3"
        val d4 = "D4"
        val eSharp1 = "E#1"
        val bFlat0 = "Bb0"

        val cSharp4Parsed = PitchParser.parsePitch(cSharp4)
        val aFlat3Parsed = PitchParser.parsePitch(aFlat3)
        val d4Parsed = PitchParser.parsePitch(d4)
        val eSharp1Parsed = PitchParser.parsePitch(eSharp1)
        val bFlat0Parsed = PitchParser.parsePitch(bFlat0)

        Assert.assertEquals(4, cSharp4Parsed.octave)
        Assert.assertEquals(3, aFlat3Parsed.octave)
        Assert.assertEquals(4, d4Parsed.octave)
        Assert.assertEquals(1, eSharp1Parsed.octave)
        Assert.assertEquals(0, bFlat0Parsed.octave)

        Assert.assertEquals(AccidentalSign.Sharp, cSharp4Parsed.accidental.sign)
        Assert.assertEquals(AccidentalSign.Flat, aFlat3Parsed.accidental.sign)
        Assert.assertEquals(PitchLetter.C, cSharp4Parsed.pitchLetter)
        Assert.assertEquals(PitchLetter.A, aFlat3Parsed.pitchLetter)
        Assert.assertEquals(PitchLetter.D, d4Parsed.pitchLetter)
        Assert.assertEquals(PitchLetter.E, eSharp1Parsed.pitchLetter)
        Assert.assertEquals(PitchLetter.B, bFlat0Parsed.pitchLetter)
        Assert.assertEquals(AccidentalSign.Natural, d4Parsed.accidental.sign)
        Assert.assertEquals(AccidentalSign.Sharp, eSharp1Parsed.accidental.sign)
        Assert.assertEquals(AccidentalSign.Flat, bFlat0Parsed.accidental.sign)
        Assert.assertEquals(1, cSharp4Parsed.accidental.quantity)
        Assert.assertEquals(1, aFlat3Parsed.accidental.quantity)
        Assert.assertEquals(1, d4Parsed.accidental.quantity)
        Assert.assertEquals(1, eSharp1Parsed.accidental.quantity)
        Assert.assertEquals(1, bFlat0Parsed.accidental.quantity)
    }
}