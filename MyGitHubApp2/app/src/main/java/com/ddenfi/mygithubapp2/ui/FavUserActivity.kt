package com.ddenfi.mygithubapp2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddenfi.mygithubapp2.adapter.ListUserAdapter
import com.ddenfi.mygithubapp2.database.DetailUser
import com.ddenfi.mygithubapp2.databinding.ActivityFavUserBinding
import com.ddenfi.mygithubapp2.viewmodel.FavViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavUserBinding
    private val favViewModel by viewModels<FavViewModel>()
    private val adapter by lazy {
        ListUserAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Favorite User"

        CoroutineScope(Dispatchers.Main).launch {
            favViewModel.getFavUser().observe(this@FavUserActivity) {
                adapter.setData(it)
            }
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvFavUser.setHasFixedSize(true)
        binding.rvFavUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = adapter
        binding.rvFavUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallBack(object : ListUserAdapter.OnItemCLickCallBack {
            override fun onItemClicked(user: DetailUser) {
                val toDetailActivity = Intent(this@FavUserActivity, DetailUserActivity::class.java)
                toDetailActivity.putExtra(DetailUserActivity.EXTRA_DATAUSER, user)
                startActivity(toDetailActivity)
            }
        })
    }
}