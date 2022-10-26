import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeExactly

class SolveHonaiTest : StringSpec({

    "SolveHonai of 10 is 1023" {
        solveHanoi(10) shouldBeExactly 1023
    }

    "SolveHonai of 10 is 1023" {
        solveHanoi(20) shouldBeExactly 1048575
    }
})