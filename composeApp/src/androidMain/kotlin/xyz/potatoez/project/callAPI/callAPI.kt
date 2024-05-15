package xyz.potatoez.project.callAPI

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

object NetworkService {
    private const val BASE_URL = "https://api.wavjaby.nckuctf.org/api/v0/"
    suspend fun callAPI(path: String, parameterName: Map<String, String>): CourseSearchResponse {
        val httpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
        httpClient.use { client ->
            val res = client.get(BASE_URL + path) {
                url {
                    parameterName.forEach { (key, value) -> parameters.append(key, value) }
                }
            }
            val body: CourseSearchResponse = res.body()
            return body
        }
    }
}

