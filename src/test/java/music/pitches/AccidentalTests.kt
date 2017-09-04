package music.pitches

import org.junit.Assert
import org.junit.Test

class AccidentalTests {
    val natural = Accidental(AccidentalSign.Natural)
    val sharp = Accidental(AccidentalSign.Sharp)
    val doubleSharp = Accidental(AccidentalSign.Sharp, 2)
    val flat = Accidental(AccidentalSign.Flat)
    val doubleFlat = Accidental(AccidentalSign.Flat, 2)

    @Test
    fun plus_accidental_semitoneDistance() {
        Assert.assertEquals(1, (natural + sharp).semitoneDistance())
        Assert.assertEquals(2, (natural + doubleSharp).semitoneDistance())
        Assert.assertEquals(-1, (natural + flat).semitoneDistance())
        Assert.assertEquals(-2, (natural + doubleFlat).semitoneDistance())
        Assert.assertEquals(0, (sharp + flat).semitoneDistance())
        Assert.assertEquals(1, (doubleSharp + flat).semitoneDistance())
        Assert.assertEquals(-1, (sharp + doubleFlat).semitoneDistance())
        Assert.assertEquals(0, (doubleSharp + doubleFlat).semitoneDistance())
        Assert.assertEquals(2, (sharp + sharp).semitoneDistance())
        Assert.assertEquals(3, (doubleSharp + sharp).semitoneDistance())
        Assert.assertEquals(-2, (flat + flat).semitoneDistance())
        Assert.assertEquals(-3, (flat + doubleFlat).semitoneDistance())
    }

    @Test
    fun plus_number_semitoneDistance() {
        Assert.assertEquals(1, (natural + 1).semitoneDistance())
        Assert.assertEquals(2, (natural + 2).semitoneDistance())
        Assert.assertEquals(-1, (natural - 1).semitoneDistance())
        Assert.assertEquals(-2, (natural - 2).semitoneDistance())
        Assert.assertEquals(0, (sharp - 1).semitoneDistance())
        Assert.assertEquals(1, (doubleSharp - 1).semitoneDistance())
        Assert.assertEquals(-1, (sharp - 2).semitoneDistance())
        Assert.assertEquals(0, (doubleSharp - 2).semitoneDistance())
        Assert.assertEquals(2, (sharp + 1).semitoneDistance())
        Assert.assertEquals(3, (doubleSharp + 1).semitoneDistance())
        Assert.assertEquals(-2, (flat - 1).semitoneDistance())
        Assert.assertEquals(-3, (flat - 2).semitoneDistance())
        Assert.assertEquals(-3, (doubleFlat - 1).semitoneDistance())
        Assert.assertEquals(-4, (doubleFlat - 2).semitoneDistance())
    }

    @Test
    fun plus_accidental_sign() {
        Assert.assertEquals(AccidentalSign.Sharp, (natural + 1).sign)
        Assert.assertEquals(AccidentalSign.Sharp, (natural + 2).sign)
        Assert.assertEquals(AccidentalSign.Flat, (natural - 1).sign)
        Assert.assertEquals(AccidentalSign.Flat, (natural - 2).sign)
        Assert.assertEquals(AccidentalSign.Natural, (sharp - 1).sign)
        Assert.assertEquals(AccidentalSign.Sharp, (doubleSharp - 1).sign)
        Assert.assertEquals(AccidentalSign.Flat, (sharp - 2).sign)
        Assert.assertEquals(AccidentalSign.Natural, (doubleSharp - 2).sign)
        Assert.assertEquals(AccidentalSign.Sharp, (sharp + 1).sign)
        Assert.assertEquals(AccidentalSign.Sharp, (doubleSharp + 1).sign)
        Assert.assertEquals(AccidentalSign.Flat, (flat - 1).sign)
        Assert.assertEquals(AccidentalSign.Flat, (flat - 2).sign)
        Assert.assertEquals(AccidentalSign.Flat, (doubleFlat - 1).sign)
        Assert.assertEquals(AccidentalSign.Flat, (doubleFlat - 2).sign)
    }
}