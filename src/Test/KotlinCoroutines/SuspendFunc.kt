package KotlinCoroutines

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class SuspendFunc {
    @Test
    fun testSuspendFuncWorks () = runBlocking {
        delays()
    }

}