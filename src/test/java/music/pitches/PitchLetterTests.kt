package music.pitches

import org.junit.Assert
import org.junit.Test

class PitchLetterTests {

    @Test
    fun plus_basic() {
        var pitchLetter = PitchLetter.A

        pitchLetter += 1

        Assert.assertEquals(PitchLetter.B, pitchLetter)
    }

    @Test
    fun plus_wrapAround() {
        var pitchLetter = PitchLetter.G

        pitchLetter += 2

        Assert.assertEquals(PitchLetter.B, pitchLetter)
    }

    @Test
    fun minus_basic() {
        var pitchLetter = PitchLetter.B

        pitchLetter -= 1

        Assert.assertEquals(PitchLetter.A, pitchLetter)
    }

    @Test
    fun minus_wrapAround() {
        var pitchLetter = PitchLetter.A

        pitchLetter -= 2

        Assert.assertEquals(PitchLetter.F, pitchLetter)
    }
}