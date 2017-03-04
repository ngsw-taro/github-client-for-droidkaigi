package sample.githubclient.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User(val id: Long,
                @SerializedName("login") val loginId: String,
                val avatarUrl: String) : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User =
                    User(source.readLong(), source.readString(), source.readString())

            override fun newArray(size: Int): Array<out User?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(loginId)
        dest.writeString(avatarUrl)
    }
}