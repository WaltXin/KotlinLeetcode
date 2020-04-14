package KotlinCoroutines

import kotlinx.coroutines.*
import java.lang.Exception

fun main() = runBlocking {
    //joinFunc()
    //cancelFunc_BuildIn()
    //cancelFunc_OwnFunc()
    //cancelFunc_HandleException()
    //cancelFunc_withTimeOutV1()
    cancelFunc_withTimeOutV2()
}

suspend fun joinFunc() {
    var job = GlobalScope.launch {
        delay(1000)
        print("World")
    }
    print("Hello, ")
    //join will wait until the job finished, similar with thread join
    job.join()
}

suspend fun cancelFunc_BuildIn() {
    var job = GlobalScope.launch {
        repeat(1000) {
            delay(100) //delay is build-in suspend function, it will manage the cancellation for us
            print(".")
        }
    }

    delay(2500)

    job.cancel() //cancel the job
    job.join() //wait till the job finished
    //job.cancelAndJoin()
    println("now i can quit")
}

suspend fun cancelFunc_OwnFunc() {
    var job = GlobalScope.launch {
        repeat(1000) {
            //if (!isActive) return@launch //use isActive to check is this coroutine is being cancelled
            if (!isActive) throw CancellationException() //this exception will hand over to coroutine infrastructure and will cancel the coroutine for us
            Thread.sleep(100)
            print(".")
        }
    }

    delay(2500)

    job.cancel() //cancel the job
    job.join() //wait till the job finished
    //job.cancelAndJoin()
    println("now i can quit")
}

suspend fun cancelFunc_HandleException() {

    var job = GlobalScope.launch {
        try {
            repeat(1000) {
                yield()
                Thread.sleep(100)
                print(".")
            }
        } catch (ex: CancellationException) {
            println("reason: ${ex.message}")
        } finally {
            println("In finally")
        }
    }

    delay(2500)

    job.cancel(CancellationException("Too slow"))
    job.join()
    println("now i can quit")
}

suspend fun cancelFunc_withTimeOutV1() {
    try {
        var job = withTimeout(100) {
            repeat(1000) {
                yield()
                print(".")
                delay(20)
            }
        }
    } catch (ex: TimeoutCancellationException) {
        println(ex.message)
    }
    delay(2500)
}

suspend fun cancelFunc_withTimeOutV2() {
    var job = withTimeoutOrNull(100) {
        repeat(1000) {
            yield()
            print(".")
            delay(20)
        }
    }
    if (job == null) {
        println("time out")
    }
    delay(2500)
}

/**
 * Yields the thread (or thread pool) of the current coroutine dispatcher to other coroutines to run if possible.
 * This suspending function is cancellable. If the Job of the current coroutine is cancelled or completed when this suspending function is invoked or while this function is waiting for dispatch, it resumes with a CancellationException.
 * Note: This function always checks for cancellation even when it does not suspend.
 */
