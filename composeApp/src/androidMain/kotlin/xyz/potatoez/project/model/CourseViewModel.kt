package xyz.potatoez.project.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.potatoez.project.callAPI.CourseSearchResponse

class CourseViewModel(val repo: Repository) : ViewModel() {
    private lateinit var courseSearchResponse: CourseSearchResponse
    fun getData(path: String, params: Map<String, String>): CourseSearchResponse {
        viewModelScope.launch {
            courseSearchResponse = repo.repoData(path, params)
        }
        return courseSearchResponse
    }
}