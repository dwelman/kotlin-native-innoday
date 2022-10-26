fun solveHanoi(N: Int, from_peg: String = "peg1", to_peg: String = "peg2", spare_peg: String = "peg3"): Long {
    var counter = 1L
    if (N <= 1) {
        return 1
    }
    if (N > 1) {
        counter += solveHanoi(N - 1, from_peg, spare_peg, to_peg)
    }
    if (N > 1) {
        counter += solveHanoi(N - 1, spare_peg, to_peg, from_peg)
    }

    return counter
}