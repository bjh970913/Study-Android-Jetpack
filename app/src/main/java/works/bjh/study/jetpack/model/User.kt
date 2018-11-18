package works.bjh.study.jetpack.model

class User(
        val firstName: String,
        val lastName: String,
        private var number: Int
) {
    fun getNumberStr(): String {
        return number.toString()
    }

    fun add() {
        number++
    }


}
