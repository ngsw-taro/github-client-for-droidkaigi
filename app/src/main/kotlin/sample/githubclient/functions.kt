package sample.githubclient

import android.content.Context
import android.content.Intent

inline fun <reified T : Any> Context.intent(): Intent = Intent(this, T::class.java)