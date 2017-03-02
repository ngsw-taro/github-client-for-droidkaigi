package sample.githubclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import co.metalab.asyncawait.async
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface Greeter {
    fun hello(): String
}

@Module
class MyModule {
    @Provides
    fun provideGreeter(): Greeter = object : Greeter {
        override fun hello(): String = "Hello"
    }
}

@Component(modules = arrayOf(MyModule::class))
interface MyComponent {
    fun inject(a: MainActivity)
}

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var greeter: Greeter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMyComponent.create().inject(this)

        async {
            val got = await { greeter.hello() }
            Toast.makeText(this@MainActivity, got, Toast.LENGTH_SHORT).show()
        }
    }
}
