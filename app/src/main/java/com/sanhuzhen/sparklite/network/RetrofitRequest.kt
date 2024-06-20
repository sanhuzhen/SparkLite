package com.sanhuzhen.sparklite.network

import com.sanhuzhen.sparklite.api.ApiService
import com.sanhuzhen.sparklite.bean.AnswerALi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRequest {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.pearktrue.cn/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)


    //对阿里云回答进行网络请求
    fun getAnswer(question: String): Observable<AnswerALi>{
        return apiService.getAnswer(question)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}