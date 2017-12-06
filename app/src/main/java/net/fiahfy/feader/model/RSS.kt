package net.fiahfy.feader.model

import com.google.gson.annotations.SerializedName

data class RSS(
    val encoding: String,
    val version: String,
    val feed: Feed
) {
    data class Feed(
            @SerializedName("entry")
            val entries: List<Entry>
    ) {
        data class Entry(
                val title: Title,
                @SerializedName("link")
                val links: List<Link>
        ) {
            data class Title(
                    @SerializedName("\$t")
                    val text: String
            )
            data class Link(
                    val rel: String,
                    val href: String
            )
            var permalink: String? = null
                get() = links.first { it.rel == "alternate" }.href
        }
    }
}
