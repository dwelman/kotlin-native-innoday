

fun factorial(number: Int) =
    (1..number).reduce { acc, i ->  acc * i }
