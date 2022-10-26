import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeExactly

class FactorialTest : StringSpec({
    "Factorial of 5 is 120" {
        factorial(5) shouldBeExactly 120
    }

    "Factorial of 12 is 479001600" {
        factorial(12) shouldBeExactly 479001600
    }
})
