package com.sanhuzhen.sparklite.bean

class AnswerType(val Word: String,val Type: Int) {
    companion object{
        const val TYPE_QUESTION = 0
        const val TYPE_ANSWER = 1
    }
}