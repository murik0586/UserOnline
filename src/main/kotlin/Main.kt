const val HOUR = 60 * 60
const val MINUTE = 60
const val DAYS = 24 * MINUTE * MINUTE


var zeroMinuteInterval = 0..60
fun main() {

    val timeOffline = DAYS * 3 + 1

    println("Lion ${agoToText(timeOffline)}")

}


fun agoToText(timeOffline: Int): String {
    //TODO нужны дополнительные функции отвечающие за МИНУТ, МИНУТУ, МИНУТЫ, ЧАС, ЧАСА, ЧАСОВ,
    return when (timeOffline) {
        in zeroMinuteInterval -> "был(а) в сети только что"
        in (MINUTE + 1).. HOUR -> "был(а) x минут назад"
        in (HOUR + 1)..DAYS -> "был(а) x часов назад"
        in (DAYS + 1)..(DAYS*2) -> "был(а) вчера"
        in (DAYS *2)..(DAYS*3) -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}