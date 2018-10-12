package itk.myoganugraha.aplikasisederhanakotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rvNews: RecyclerView

    var thumbnails: IntArray = intArrayOf(R.drawable.chrvches, R.drawable.wtf_coming, R.drawable.paramore_tour,
    R.drawable.gun_n_roses_tour, R.drawable.clean_bandit_tour, R.drawable.charlie_puth_tour)

    var icon: IntArray = intArrayOf(R.drawable.chrvches, R.drawable.wtf_icon, R.drawable.paramore, R.drawable.gun_n_roses,
            R.drawable.clean_bandit, R.drawable.charlie_puth)

    var listNews = arrayOf("CHVRCHES Live in Jakarta", "#WTF18 is Coming!!", "Paramore - Tour Four",
            "Guns N' Roses: Not In This Lifetime Tour", "Clean Bandit - I Miss You Tour",
            "Charlie Puth  - Voicenotes Live in Indonesia")

    var user= arrayOf("CHVRCHES", "We The Fest", "Paramore", "Gun N' Roses", "Clean Bandit", "Charlie Puth")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents();
    }

    private fun initComponents() {

        val rvNews = findViewById<RecyclerView>(R.id.recyclerview_news)
        rvNews?.setHasFixedSize(true)
        rvNews?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val listData = ArrayList<DataModel>()
        for(i in 0 until listNews.size ) {
            listData.add(DataModel(thumbnails[i], icon[i], user[i], listNews[i]))
        }
        var rvAdapter = RecyclerviewAdapter(this, listData)
        rvNews.adapter = rvAdapter
    }
}
