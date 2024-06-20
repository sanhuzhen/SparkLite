package com.sanhuzhen.sparklite.ui.activity

import com.sanhuzhen.sparklite.base.BaseActivity
import com.sanhuzhen.sparklite.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun afterCreate() {

    }

}