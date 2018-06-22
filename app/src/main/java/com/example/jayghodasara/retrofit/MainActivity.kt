package com.example.jayghodasara.retrofit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        post.setOnClickListener(View.OnClickListener {

            var i:Intent=Intent(this,Createactivity::class.java)
            startActivity(i)
        })

        button.setOnClickListener(View.OnClickListener {

            username=editText.text.toString()

            var builder:Retrofit.Builder= Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create())

            var retrofit:Retrofit=builder.build()

            var repos: Repos? = retrofit.create(Repos::class.java)
            var call:Call<List<Pojo>> = repos!!.getusers(username)

            call.enqueue(object :Callback<List<Pojo>>{
                override fun onFailure(call: Call<List<Pojo>>?, t: Throwable?) {
                    Toast.makeText(applicationContext,"ERROR",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<List<Pojo>>?, response: Response<List<Pojo>>?) {
                    var list:List<Pojo>

                    if(response!!.body()!=null){
                     list = response!!.body()!!
                        var layoutman= LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
                        var adap:adapter= adapter(applicationContext,list)

                        recycle.layoutManager=layoutman
                        recycle.adapter=adap
                   }else{
                       Toast.makeText(applicationContext,"No such Username",Toast.LENGTH_SHORT).show()

                   }





                }

            })

        })


    }
}
