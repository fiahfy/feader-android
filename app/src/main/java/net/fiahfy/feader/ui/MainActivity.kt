package net.fiahfy.feader.ui

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import net.fiahfy.feader.R
import net.fiahfy.feader.model.RSS
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    private val rssUrl = "https://fiahfy.blogspot.com/feeds/posts/summary?alt=json"
    private val client = OkHttpClient()
    private val gson = GsonBuilder().create()
    private val intent = CustomTabsIntent.Builder().build()
    private val adapter by lazy { ArrayAdapter<String>(this, android.R.layout.simple_list_item_1) }

    private var entries = emptyList<RSS.Feed.Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refresher.setOnRefreshListener(this)

        list_view.adapter = adapter
        list_view.onItemClickListener = this

        load()
    }

    // SwipeRefreshLayout.OnRefreshListener

    override fun onRefresh() {
        load()
    }

    // AdapterView.OnItemClickListener

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val entry = entries[p2]
        entry.permalink?.let {
            intent.launchUrl(this, Uri.parse(it))
        }
    }

    // Private

    private fun load() {
        Observable.create<RSS> {
            val request = Request.Builder()
                    .url(rssUrl)
                    .build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    val rss = gson.fromJson(body.string(), RSS::class.java)
                    it.onNext(rss)
                }
                it.onComplete()
            } else {
                it.onError(Throwable())
            }
        }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    refresher.isRefreshing = false
                }
                .subscribe {
                    entries = it.feed.entries
                    adapter.clear()
                    adapter.addAll(entries.map { it.title.text })
                }
    }
}
