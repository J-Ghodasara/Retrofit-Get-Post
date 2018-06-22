package com.example.jayghodasara.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ViewAnimator
import kotlinx.android.synthetic.main.activity_createactivity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Createactivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createactivity)

        btn_submit.setOnClickListener(View.OnClickListener {

            var r: Retrofit.Builder = Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())

            var retrofit: Retrofit = r.build()

            var postpojo: Repos? = retrofit.create(Repos::class.java)

            var p: Postpojo = Postpojo()
            p.Body = et_body.text.toString()
            p.Title = et_title.text.toString()
            p.UserId = 11

            postpojo!!.createacc(p).enqueue(object : Callback<Postpojo> {
                override fun onFailure(call: Call<Postpojo>?, t: Throwable?) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Postpojo>?, response: Response<Postpojo>?) {

                    var post:Postpojo? = (response!!.body())
                    tv_response.text="   "+post!!.Id.toString()+"  "+post.Body.toString()+"  "+post.Title.toString()
                    Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_SHORT).show()
                }


            })


        })


    }
}
