import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class Course (val y: String, val dn: String,
                   val sn: Int?, val ca: String,
                   val sc: String, val g: Int,
                   val fc: String?, val fg: String?,
                   val ct: String, val cn: String,
                   val ci: String?, val cl: String?,
                   val tg: List<String>?, val c: Float?,
                   val r: Boolean?, val i: List<String>?,
                   val s: Int?, val a: Int?,
                   val t: List<String>?)
@Serializable
data class CourseSearchResponse(val success: Boolean,
                                val data: List<Course>?,
                                val msg: String? = null, val code: Int,
                                val err: List<String>? = null,
                                val warn: List<String>? = null)

suspend fun callAPI(path: String): CourseSearchResponse {
    val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    httpClient.use { httpClient ->
        val res = httpClient.get("https://api.wavjaby.nckuctf.org/api/v0/historySearch?dept=F7")
        val body: CourseSearchResponse = res.body()
        return body
    }
}

fun main() {

}