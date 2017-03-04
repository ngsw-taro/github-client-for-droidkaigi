package sample.githubclient.model

data class Page<out ITEM>(val totalCount: Long,
                          val items: List<ITEM>)
