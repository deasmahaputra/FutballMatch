package deasmp.com.football_v2.service

import deasmp.com.football_v2.response.DetailMatchResponse
import deasmp.com.football_v2.response.FootballMatchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/api/v1/json/1/eventsround.php?id=4328&r=38&s=1415")
    fun getMatch() : Observable<FootballMatchResponse>

    @GET("/api/v1/json/1/lookupevent.php")
    fun getDetailMatch(@Query("id") id : String) : Observable<DetailMatchResponse>

}