package KotlinCoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{
    GlobalScope.launch {
        delay(1000L)
        print("World")
    }
    print("Hello,")
    delays()
}

suspend fun delays() {
    delay(1500L)
}