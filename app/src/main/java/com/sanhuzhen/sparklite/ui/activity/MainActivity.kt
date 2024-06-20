package com.sanhuzhen.sparklite.ui.activity

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanhuzhen.sparklite.adapter.RvAdapter
import com.sanhuzhen.sparklite.base.BaseActivity
import com.sanhuzhen.sparklite.bean.AnswerType
import com.sanhuzhen.sparklite.databinding.ActivityMainBinding
import com.sanhuzhen.sparklite.util.Toast
import com.sanhuzhen.sparklite.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val wordList = ArrayList<AnswerType>()
    private lateinit var question: String

    private val mViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun afterCreate() {
        wordList.add(AnswerType("你好，我是水神芙宁娜，请问你有什么问题吗？", AnswerType.TYPE_QUESTION))
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = RvAdapter(wordList)
        mViewModel.answer.observe(this) {
            wordList.add(AnswerType(it.answer, AnswerType.TYPE_QUESTION))
            binding.rvMain.adapter = RvAdapter(wordList)
            binding.rvMain.adapter?.notifyItemInserted(wordList.size-1)
            binding.rvMain.scrollToPosition(wordList.size-1)
        }
        binding.btnMain.setOnClickListener {
            question = binding.etMain.text.toString()
            if (question.isNotEmpty()) {
                mViewModel.getAnswer(question)
            }else{
                Toast.ToastLong(this, "请输入问题")
            }
            wordList.add(AnswerType(question, AnswerType.TYPE_ANSWER))
            binding.rvMain.adapter = RvAdapter(wordList)
            binding.rvMain.adapter?.notifyItemInserted(wordList.size-1)
            binding.rvMain.scrollToPosition(wordList.size-1)
            binding.etMain.text.clear()
        }
    }

}