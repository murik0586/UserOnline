const val HOUR = 60 * 60
const val MINUTE = 60
const val DAY = 24 * HOUR

var zeroMinuteInterval = 0..60
fun main() {
    val timeOffline = 79200
    println("Lion ${agoToText(timeOffline)}")

}


fun agoToText(timeOffline: Int): String {
    return when (timeOffline) {
        in zeroMinuteInterval -> "был(а) в сети только что"
        in (MINUTE + 1)..HOUR -> "был(а) ${formWordMinutesTheText(timeOffline)} назад"
        in (HOUR + 1)..DAY -> "был(а) ${formWordHourText(timeOffline)} назад"
        in (DAY + 1)..(DAY * 2) -> "был(а) вчера"
        in (DAY * 2)..(DAY * 3) -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun formWordHourText(timeOffline: Int): String {
    val hour = timeOffline / HOUR
    return when {
        hour % 100 in 11..20 -> "$hour часов"
        hour % 10 == 1 -> "$hour час"
        hour % 10 in 2..4 ->"$hour часа"
        else -> "$hour часов"
    }
}

fun formWordMinutesTheText(timeOffline: Int): String {
    val minutes = timeOffline / 60
    return when {
        minutes % 100 in 11..19 -> "$minutes минут"
        minutes % 10 == 1 -> "$minutes минуту"
        minutes % 10 in 2..4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}
