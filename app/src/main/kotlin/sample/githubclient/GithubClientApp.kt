package sample.githubclient

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import sample.githubclient.dagger.AppComponent
import sample.githubclient.dagger.DaggerAppComponent

class GithubClientApp : Application() {

    var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        component = DaggerAppComponent.create()
    }
}