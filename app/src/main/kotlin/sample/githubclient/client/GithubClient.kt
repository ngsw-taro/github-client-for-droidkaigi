package sample.githubclient.client

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import sample.githubclient.model.Page
import sample.githubclient.model.Repository

interface GithubClient {
    /*
     * exercise 7: 検索APIを叩くメソッドを提供しよう
     * Retrofitの形式で検索APIを叩くメソッドシグネチャを記述しましょう。
     *
     * API仕様
     * エンドポイント GET /search/repositories
     * クエリパラメータ q: 検索ワード
     * 戻り値 RepositoryをラップしたPage
     */
    @GET("/search/repositories")
    fun search(@Query("q") query: String): Call<Page<Repository>>
}