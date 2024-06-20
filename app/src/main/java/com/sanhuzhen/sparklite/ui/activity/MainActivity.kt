package com.sanhuzhen.sparklite.ui.activity

import androidx.lifecycle.ViewModelProvider
import com.sanhuzhen.sparklite.base.BaseActivity
import com.sanhuzhen.sparklite.databinding.ActivityMainBinding
import com.sanhuzhen.sparklite.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun afterCreate() {
        mViewModel.getAnswer("你是谁")
    }

}