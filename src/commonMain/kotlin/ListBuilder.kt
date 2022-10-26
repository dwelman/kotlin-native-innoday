fun listBuilder(size: Int): Int {
    val result: List<List<List<List<Int>>>> = (0 .. size).map { firstLayer ->
        (0 .. firstLayer).map { secondLayer ->
            (0 .. secondLayer).map { thirdLayer ->
                (0 .. thirdLayer).map {
                    it
                }
            }
        }
    }

    return result.flatMap { secondLayer -> secondLayer.flatMap { it.flatten() } }.sum()
}