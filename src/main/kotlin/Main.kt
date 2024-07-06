const val HOUR = 60 * 60
const val MINUTE = 60
const val DAYS = 24 * HOUR

var zeroMinuteInterval = 0..60
fun main() {
    val timeOffline = 121
    println("Lion ${agoToText(timeOffline)}")

}


fun agoToText(timeOffline: Int): String {
    //TODO осталась дополнительная функция отвечающая за: ЧАС, ЧАСА, ЧАСОВ,
    return when (timeOffline) {
        in zeroMinuteInterval -> "был(а) в сети только что"
        in (MINUTE + 1)..HOUR -> "был(а) ${formWordMinutesTheText(timeOffline)} назад"
        in (HOUR + 1)..DAYS -> "был(а) x часов назад"
        in (DAYS + 1)..(DAYS * 2) -> "был(а) вчера"
        in (DAYS * 2)..(DAYS * 3) -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun formWordMinutesTheText(timeOffline: Int): String {
    val minutes = timeOffline / 60
    val lastDigit = minutes % 10
    val lastTwoDigit = minutes % 100

    return when {
        lastTwoDigit in 11..19 -> "$minutes минут"
        lastDigit == 1 -> "$minutes минуту"
        lastDigit in 2..4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}
/*
Для часов:

1, 21 час назад
2, 3, 4, 22, 23, 24 часа назад
5-20 часов назад.
Итог: у вас должен быть репозиторий на GitHub, в котором будет ваш Gradle-проект. */