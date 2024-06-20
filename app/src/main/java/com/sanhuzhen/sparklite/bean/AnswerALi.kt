package com.sanhuzhen.sparklite.bean

data class AnswerALi(
    val answer: String,
    val api_source: String,
    val code: Int,
    val model: String,
    val msg: String,
    val question: String
)