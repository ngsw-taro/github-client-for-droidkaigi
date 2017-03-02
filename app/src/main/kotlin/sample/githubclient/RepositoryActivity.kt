package sample.githubclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import sample.githubclient.model.Repository

class RepositoryActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context, repository: Repository): Intent =
                context.intent<RepositoryActivity>()
                        .putExtra("repository", repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        val repository: Repository = intent["repository"] ?: throw IllegalStateException("repositoryがないよ")
        title = repository.fullName

        val repositoryView = findViewById(R.id.repository_view) as RepositoryView
        repositoryView.setRepository(repository)

        val webView = findViewById(R.id.web_view) as WebView
        webView.loadUrl(repository.htmlUrl)
    }
}