package sample.githubclient

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.annotation.IdRes
import android.view.View
import android.widget.Toast
import retrofit2.Retrofit
import kotlin.reflect.KClass

fun <T : View> View.findView(@IdRes id: Int): T = findViewById(id) as T

val Activity.app: GithubClientApp
    get() = application as GithubClientApp

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun <T : Any> Retrofit.create(service: KClass<T>): T = create(service.java)

inline fun <reified T : Any> Retrofit.create(): T = create(T::class)

inline fun <reified T : Any> Context.intent(): Intent = Intent(this, T::class.java)

operator fun <T : Parcelable> Intent.get(name: String): T? = getParcelableExtra(name)