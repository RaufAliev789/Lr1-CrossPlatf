import kotlin.math.abs
import kotlin.math.exp

// Рекурсивное вычисление e^x через ряд Маклорена
 fun maclaurinExp(
    x: Double,
    n: Int = 0,
    currentSerMember: Double = 1.0,
    sum: Double = 0.0,
    eps: Double
): Double {
    return if (abs(currentSerMember) < eps) {
        sum
    } else {
        val newSum = sum + currentSerMember
        val nextSerMem = currentSerMember * x / (n + 1)
        maclaurinExp(x, n + 1, nextSerMem, newSum, eps)
    }
}

// Исключения
fun readDouble(attempt: String): Double {
    while (true) {
        print(attempt)
        val input = readLine()
        val number = input?.toDoubleOrNull()
        if (number != null) return number
        println("Ошибка: нужно ввести число, попробуйте снова.")
    }
}
//
fun main() {
    val x = readDouble("Введите x: ")
    val eps = readDouble("Введите точность eps (>0): ")

    if (eps <= 0) {
        println("Ошибка: точность должна быть положительной.")
        return
    }

    val result = maclaurinExp(x, eps = eps)
    val builtin = exp(x)

    println("e^x через ряд Маклорена = $result")
    println("e^x через Math.exp = $builtin")
    println("Погрешность = ${abs(result - builtin)}")
}
