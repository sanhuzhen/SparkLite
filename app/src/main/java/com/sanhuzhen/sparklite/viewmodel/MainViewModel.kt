package com.sanhuzhen.sparklite.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanhuzhen.sparklite.bean.AnswerALi
import com.sanhuzhen.sparklite.network.RetrofitRequest
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainViewModel : ViewModel() {
    private val _answerLists: MutableLiveData<AnswerALi> = MutableLiveData()

    val answer: MutableLiveData<AnswerALi>
        get() = _answerLists

    fun getAnswer(question: String) {
        RetrofitRequest.getAnswer(question).subscribe(
            object : Observer<AnswerALi> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: AnswerALi) {
                    Log.d("getAnswre", "----------------   $t")
                    _answerLists.postValue(t)
                }

                override fun onError(e: Throwable) {
                    Log.d("Error", "------------------  ${e.message}")
                }

                override fun onComplete() {
                }
            })

    }
}
