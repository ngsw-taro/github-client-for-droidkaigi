package sample.githubclient.model

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
                 val language: String?)