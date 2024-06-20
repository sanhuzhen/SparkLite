package com.sanhuzhen.sparklite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sanhuzhen.sparklite.R
import com.sanhuzhen.sparklite.bean.AnswerType
import com.sanhuzhen.sparklite.bean.AnswerType.Companion.TYPE_QUESTION

class RvAdapter(val list: List<AnswerType>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(view: View): RecyclerView.ViewHolder(view){
        val leftQuestion: TextView = view.findViewById(R.id.tv_left)
    }
    inner class RightViewHolder(view: View): RecyclerView.ViewHolder(view){
        val rightAnswer: TextView = view.findViewById(R.id.tv_right)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if(viewType == TYPE_QUESTION){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_left,parent,false)
        LeftViewHolder(view)
    }else{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_right,parent,false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val word = list[position]
        when(holder){
            is LeftViewHolder -> holder.leftQuestion.text = word.Word
            is RightViewHolder -> holder.rightAnswer.text = word.Word
            else -> throw IllegalAccessException()
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        val word = list[position]
        return word.Type
    }

}