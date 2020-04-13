package KotlinCoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlinx.coroutines.launch


fun main() {
    var result = AtomicInteger()

    for (i in 1..15_000) {
        thread(start = true) {
            result.getAndIncrement()
        }
    }

    for (i in 1..1_500_000) {
        GlobalScope.launch {
            result.getAndIncrement()
        }
    }

    Thread.sleep(1000L)
    println(result.get())
}