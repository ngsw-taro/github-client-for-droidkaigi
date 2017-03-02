package sample.githubclient.dagger

import dagger.Component
import sample.githubclient.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
}
