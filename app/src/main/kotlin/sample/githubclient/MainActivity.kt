package sample.githubclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sample.githubclient.client.GithubClient
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /**
     * exercise 9: GithubClientをインジェクトしよう
     * DaggerでGithubClientをインジェクトしましょう。
     * GithubClientをプロパティとして保持し、
     * (application as GithubClientApp).inject(this)を呼んでインジェクト。
     *
     * exercise 8で生成したGithubClientのコードの削除を忘れずに。
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = RepositoryListAdapter(this)

        /*
         * exercise 2: リポジトリのダミーデータをリスト表示しよう
         *
         * 手順1. Repositoryクラスのコンストラクタを呼び出して、インスタンスを得る
         * 手順2. listOf関数で、リストを生成する
         * 手順3. listAdapterのrepositoriesプロパティに、表示対象のRepotiroyリストをセットする
         * （手順4. RepositoryViewクラスのコメントアウトを外す）
         *
         * コード挿入位置↓
         */

        val listView = findViewById(R.id.list_view) as ListView
        listView.adapter = listAdapter

        /*
         * exercise 5: 詳細画面を起動しよう
         * リスト項目がクリックされたら、対象のリポジトリの詳細画面を起動しましょう。
         * RepositoryActivityのコンパニオンオブジェクトが持つintent関数を使用し、
         * 起動用インテントを取得します。
         *
         * コード挿入位置↓
         */

        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        /*
         * exercise 8: GithubClientで検索を実行しよう
         * Retrofitの機能を使ってGithubClientオブジェクトを取得し、検索しましょう。
         * また、検索結果として取得したリポジトリを画面に反映しましょう。
         *
         * ヒント
         * * Class<GithubClient>インスタンスを得るにはGithubClient::class.javaという記法を用います
         * * 匿名クラスを定義するには object: コンストラクタ呼び出しorインタフェース名 {...}と記述します
         * * listAdapter.notifyDataSetChanged()を呼び出してリスト表示を更新します
         */

//        val githubClient =

        val searchEditText = findViewById(R.id.search_edit_text) as EditText
        val searchButton = findViewById(R.id.search_button) as Button
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
        }

        /*
         * exercise 10: コルーチンを使ってみよう
         * Kotlin 1.1で入った新機能を活用したライブラリを使って、
         * APIアクセスからビューの更新までをコーディングしてみましょう。
         *
         * ヒント
         * asyncブロックの中でawaitブロックが使えます。
         * awaitブロック内は非同期に実行されます。
         */
    }
}
