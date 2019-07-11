package com.example.wisata.viewModel.homescreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.BaseAdapter
import com.example.wisata.MainActivity
import com.example.wisata.R
import com.example.wisata.activity.ActivityWisataAlam
import com.example.wisata.activity.ActivityWisataKuliner
import com.example.wisata.activity.ActivityWisataPantai
import com.example.wisata.activity.ActivityWisataSejarah
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.layout_adapter.view.*

class ActivityHomeScreen : AppCompatActivity() {
    var adapter: ImageAdapter? = null
    var homeAdapter = ArrayList<HomeScreenAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        // load foods
        homeAdapter.add(HomeScreenAdapter("Wisata Alam", R.drawable.alam))
        homeAdapter.add(HomeScreenAdapter("Wisata Pantai", R.drawable.pantai))
        homeAdapter.add(HomeScreenAdapter("Wisata Sejarah", R.drawable.sejarah))
        homeAdapter.add(HomeScreenAdapter("Wisata Kuliner", R.drawable.kuliner))
        adapter = ImageAdapter(this, homeAdapter)

        gvHome.adapter = adapter
        gvHome.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                //Toast.makeText(this, "Anda memilih: 0",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityWisataAlam::class.java)
                startActivity(intent)
            } else if (position == 1) {
//                Toast.makeText(this, "Anda memilih: 1", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityWisataPantai::class.java)
                startActivity(intent)
            } else if (position == 2) {
                //Toast.makeText(this, "Anda memilih: 2", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityWisataSejarah::class.java)
                startActivity(intent)
            } else if (position == 3) {
//                Toast.makeText(this, "Anda memilih: 3", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityWisataKuliner::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        startActivity(Intent(this, MainActivity::class.java))
        return super.onOptionsItemSelected(item)
    }


    class ImageAdapter : BaseAdapter {
        var homeAdapter = ArrayList<HomeScreenAdapter>()
        var context: Context? = null

        constructor(context: Context, homeAdapter: ArrayList<HomeScreenAdapter>) : super() {
            this.context = context
            this.homeAdapter = homeAdapter
        }

        override fun getCount(): Int {
            return homeAdapter.size
        }

        override fun getItem(position: Int): Any {
            return homeAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val list = this.homeAdapter[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var homeView = inflator.inflate(R.layout.layout_adapter, null)
            homeView.imgList.setImageResource(list.image!!)
            homeView.tvName.text = list.name!!

            return homeView
        }
    }
}