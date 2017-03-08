package sample.githubclient

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView

import sample.githubclient.model.Repository

class RepositoryView : FrameLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_repository, this)
    }

    val userAvatarView: SimpleDraweeView = findViewById(R.id.user_avatar_view) as SimpleDraweeView

    val repositoryNameView: TextView = findViewById(R.id.repository_name_view) as TextView

    val repositoryDescriptionView: TextView = findViewById(R.id.repository_description_view) as TextView

    val repositoryLanguageView: TextView = findViewById(R.id.repository_language_view) as TextView

    val repositoryStargazerCountView: TextView = findViewById(R.id.repository_stargazer_count_view) as TextView

    fun setRepository(repository: Repository) {
        repository.run {
            userAvatarView.setImageURI(owner.avatarUrl)
            repositoryNameView.text = fullName
            repositoryDescriptionView.text = description
            repositoryLanguageView.text = language
            repositoryStargazerCountView.text = context.getString(R.string.stargazer_count, stargazersCount)
        }
    }
}