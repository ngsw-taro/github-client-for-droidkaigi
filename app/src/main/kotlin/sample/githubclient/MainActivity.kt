package sample.githubclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import co.metalab.asyncawait.async
import co.metalab.asyncawait.awaitSuccessful
import sample.githubclient.client.GithubClient
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var githubClient: GithubClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.component.inject(this)

        setContentView(R.layout.activity_main)

        val listAdapter = RepositoryListAdapter(this)
        val listView = findViewById(R.id.list_view) as ListView
        listView.adapter = listAdapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val repository = listAdapter.repositories[position]
            val intent = RepositoryActivity.intent(this, repository)
            startActivity(intent)
        }

        val searchEditText = findViewById(R.id.search_edit_text) as EditText
        val searchButton = findViewById(R.id.search_button) as Button

        searchButton.setOnClickListener {
            async {
                val query = searchEditText.text.toString()
                val page = awaitSuccessful(githubClient.search(query))
                listAdapter.repositories = page.items
                listAdapter.notifyDataSetChanged()
            }.onError {
                toast("エラー")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        async.cancelAll()
    }
}
