package sample.githubclient

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import sample.githubclient.dagger.AppComponent
import sample.githubclient.dagger.DaggerAppComponent

class GithubClientApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}