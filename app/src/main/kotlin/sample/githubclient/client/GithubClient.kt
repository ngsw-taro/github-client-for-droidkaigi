package sample.githubclient.client

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import sample.githubclient.model.Page
import sample.githubclient.model.Repository

interface GithubClient {

    @GET("/search/repositories")
    fun search(@Query("q") query: String): Call<Page<Repository>>
}