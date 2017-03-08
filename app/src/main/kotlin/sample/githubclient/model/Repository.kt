package sample.githubclient.model

import android.os.Parcel
import android.os.Parcelable

/*
 * exercise 1: リポジトリクラスを作ろう
 *
 * 下記にあるプロパティを定義しましょう。
 *  * Long型のid
 *  * String型のfullName
 *  * String型のdescription
 *  * String型のhtmlUrl
 *  * Int型のstargazersCount
 *  * User型のowner
 *  * String型のlanguage（ただしnullable）
 */

/*
 * exercise 3: Parcelableを実装しよう
 * インテントに載せるためにParcelableになるための要件を満たしましょう。
 * Userクラスが参考になります。
 */

class Repository(val id: Long,
                 val fullName: String,
                 val description: String,
                 val htmlUrl: String,
                 val stargazersCount: Int,
                 val owner: User,
                 val language: String?) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Repository> = object : Parcelable.Creator<Repository> {
            override fun createFromParcel(source: Parcel): Repository =
                    Repository(source.readLong(),
                            source.readString(),
                            source.readString(),
                            source.readString(),
                            source.readInt(),
                            source.readParcelable(Repository::class.java.classLoader),
                            source.readString())

            override fun newArray(size: Int): Array<out Repository?> = kotlin.arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(fullName)
        dest.writeString(description)
        dest.writeString(htmlUrl)
        dest.writeInt(stargazersCount)
        dest.writeParcelable(owner, flags)
        dest.writeString(language)
    }
}