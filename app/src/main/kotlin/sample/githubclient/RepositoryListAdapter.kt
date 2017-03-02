package sample.githubclient

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import sample.githubclient.model.Repository

class RepositoryListAdapter(private val context: Context) : BaseAdapter() {

    var repositories: List<Repository> = emptyList()

    override fun getCount(): Int = repositories.size

    override fun getItem(position: Int): Any = repositories[position]

    override fun getItemId(position: Int): Long = repositories[position].id

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
            (convertView as? RepositoryView ?: RepositoryView(context)).apply {
                setRepository(repositories[position])
            }
}