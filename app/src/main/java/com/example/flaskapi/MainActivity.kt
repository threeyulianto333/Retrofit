package com.example.flaskapi


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flaskapi.adapter.BukuAdapter
import com.example.flaskapi.model.Buku
import com.example.flaskapi.service.BukuService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var bukuAdapter: BukuAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvBuku)
        bukuAdapter = BukuAdapter(this)
        rvBuku.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = bukuAdapter


        val bukuInterface = BukuService.DataRepository.create().getBuku()

        //apiInterface.enqueue( Callback<List<Movie>>())
        bukuInterface.enqueue( object : Callback<List<Buku>> {
            //val bukuList: List<Buku> = Gson().fromJson(body, Array<Buku>::class.java).toList()

            override fun onResponse(call: Call<List<Buku>>?, response: Response<List<Buku>>?) {
                //if(response?.body() != null)

                //bukuAdapter.setBukuListItems(response.body()!!)
                bukuAdapter.setBukuListItems(response!!.body()!!)
                Toast.makeText(this@MainActivity, "Berhasil", Toast.LENGTH_SHORT).show()
                tvIsi.text = bukuInterface.toString()
            }

            override fun onFailure(call: Call<List<Buku>>?, t: Throwable?) {
//                Toast.makeText(this@MainActivity, "Gagal load data", Toast.LENGTH_SHORT).show()
//                //tvIsi.text = bukuInterface.toString()
//                tvIsi.text = t.toString()

                if (t is IOException) {
//                    Toast.makeText(ErrorHandlingActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    tvIsi.text = t.toString()
                    Toast.makeText(this@MainActivity, "Gagal load data gampang", Toast.LENGTH_SHORT).show()
                    // logging probably not necessary
                }
                else {
                    tvIsi.text = t.toString()
                    Toast.makeText(this@MainActivity, "Gagal load data Fatal", Toast.LENGTH_SHORT).show()
//                    Toast.makeText(ErrorHandlingActivity.this, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
            }
        })

    }

}



