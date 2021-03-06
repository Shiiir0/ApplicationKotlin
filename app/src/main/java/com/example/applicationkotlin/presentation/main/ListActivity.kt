package com.example.applicationkotlin.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationkotlin.R
import com.example.applicationkotlin.domain.entity.Character
import com.example.applicationkotlin.domain.services.HpService
import com.example.applicationkotlin.domain.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.core.logger.MESSAGE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class ListActivity : AppCompatActivity(), CharacterAdapter.OnItemClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        loadCharacters()

    }

    private fun loadCharacters() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(HpService::class.java)
        val requestCall = destinationService.getCharacters()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<Character>> {
            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val characterList = response.body()!!
                    Log.d("Response", "characterList size : ${characterList.size}")
                    rvCharacters.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@ListActivity)
                        adapter = CharacterAdapter(response.body()!!, this@ListActivity)
                    }
                }else{
                    Toast.makeText(this@ListActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(position: Int, mCharacters : List<Character>) {
        //Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("EXTRA_CHARACTER", mCharacters[position] as Serializable)

        startActivity(intent)
    }
}