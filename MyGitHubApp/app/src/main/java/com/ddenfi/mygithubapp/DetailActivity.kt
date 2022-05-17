package com.ddenfi.mygithubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATAUSER = "extra_datauser"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailUsername: TextView = findViewById(R.id.tv_detail_username)
        val tvDetailUser: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailFollowers: TextView = findViewById(R.id.tv_detail_followers)
        val tvDetailFollowing: TextView = findViewById(R.id.tv_detail_following)
        val tvDetailRepository: TextView = findViewById(R.id.tv_detail_repositories)
        val tvDetailLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvDetailCompany: TextView = findViewById(R.id.tv_detail_company)
        val ivDetailImg: ImageView = findViewById(R.id.img_detail_photo)

        val datauser = intent.getParcelableExtra<DataUser>(EXTRA_DATAUSER) as DataUser
        val tvUsername = "@" + datauser.username.toString()
        val tvUser = datauser.user.toString()
        val tvFollowers = datauser.followers.toString()
        val tvFollowing = datauser.following.toString()
        val tvRepository = datauser.repository.toString()
        val tvLocation = datauser.location.toString()
        val tvCompany = datauser.company.toString()

        tvDetailUser.text = tvUser
        tvDetailUsername.text = tvUsername
        tvDetailFollowers.text = tvFollowers
        tvDetailFollowing.text = tvFollowing
        tvDetailRepository.text = tvRepository
        tvDetailLocation.text = tvLocation
        tvDetailCompany.text = tvCompany
        Glide.with(this)
            .load(datauser.photo)
            .circleCrop()
            .into(ivDetailImg)
    }
}