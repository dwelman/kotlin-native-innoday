import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeExactly

class ListBuilderTest : StringSpec({

    "ListBuilder of 10 is 2002" {
        listBuilder(10) shouldBeExactly 2002
    }

    "ListBuilder of 20 is 42504" {
        listBuilder(20) shouldBeExactly 42504
    }
})