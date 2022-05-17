package com.ddenfi.mygithubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<DataUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<DataUser>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)

            val listUser = ArrayList<DataUser>()
            for (i in dataUsername.indices) {
                val user = DataUser(dataUsername[i],dataName[i],dataPhoto.getResourceId(i,-1),dataLocation[i],dataRepository[i],dataCompany[i],dataFollowers[i],dataFollowing[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallBack(object : ListUserAdapter.OnItemCLickCallBack {
            override fun onItemClicked(data: DataUser) {
                val moveToDetailActivity = Intent(this@MainActivity,DetailActivity::class.java)
                moveToDetailActivity.putExtra(DetailActivity.EXTRA_DATAUSER,data)
                startActivity(moveToDetailActivity)
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: DataUser) {
        Toast.makeText(this,"test " + user.user,Toast.LENGTH_SHORT).show()
    }

}