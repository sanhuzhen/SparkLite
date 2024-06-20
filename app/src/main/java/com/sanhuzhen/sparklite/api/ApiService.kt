package com.sanhuzhen.sparklite.api

import com.sanhuzhen.sparklite.bean.AnswerALi
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // 获取回答
    @GET("qwen/")
    fun getAnswer(@Query("question") question: String): Observable<AnswerALi>

}