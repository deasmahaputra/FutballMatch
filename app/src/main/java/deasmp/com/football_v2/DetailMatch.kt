package deasmp.com.football_v2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import deasmp.com.football_v2.service.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.detail_match_layout.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DetailMatch : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_match_layout)

        val idEvent: String = intent.getStringExtra("idEvent")

        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val apiMatch = retrofit.create(Api::class.java)

        apiMatch.getDetailMatch(idEvent)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    success ->
                    Log.d("test", "BERHASIL")
                    idevent_tv.text = success.events.strEvent.toString()
                }, {
                    error ->
                    Log.d("test", "GAGAL")
                })


    }

}