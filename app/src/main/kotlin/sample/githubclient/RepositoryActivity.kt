package sample.githubclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import sample.githubclient.model.Repository

class RepositoryActivity : AppCompatActivity() {

    companion object {
        /*
         * exercise 4: 起動用インテント生成関数を提供しよう
         * TODO()を削除して、コードを書いてください。
         */
        fun intent(context: Context, repository: Repository): Intent =
                Intent(context, RepositoryActivity::class.java)
                        .putExtra("repository", repository)

//        fun intent(context: Context, repository: Repository): Intent =
//                context.intent<Repository>()
//                        .putExtra("repository", repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        /*
         * exercise 6: リポジトリの情報を表示しよう
         * インテントから受け取ったリポジトリの情報をビューに反映しましょう。
         * 対象ビューは下記のとおりです。
         *  * RepositoryView型 R.id.repository_view
         *  * WebView型 R.id.web_view
         *
         *  （タイトルとしてリポジトリのフルネームを入れると良いかも！）
         */
        val repository: Repository = intent.getParcelableExtra("repository") ?: throw IllegalStateException("repositoryがないよ")
        title = repository.fullName

        val repositoryView = findViewById(R.id.repository_view) as RepositoryView
        repositoryView.setRepository(repository)

        val webView = findViewById(R.id.web_view) as WebView
        webView.loadUrl(repository.htmlUrl)
    }
}
