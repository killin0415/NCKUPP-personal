package xyz.potatoez.project.model

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import xyz.potatoez.project.callAPI.NetworkService

class Repository(
    private val networkService: NetworkService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun repoData(path: String, params: Map<String, String>) = withContext(defaultDispatcher) {
        networkService.callAPI(path, params)
    }
}