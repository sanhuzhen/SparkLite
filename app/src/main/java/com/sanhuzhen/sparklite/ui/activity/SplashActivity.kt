package com.sanhuzhen.sparklite.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.sanhuzhen.sparklite.base.BaseActivity
import com.sanhuzhen.sparklite.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity: BaseActivity<ActivitySplashBinding>() {
    companion object{
        //总倒计时
        private const val totalDuration = 5000L
        //倒计时间隔
        private const val DownInterval = 1000L
    }

    private val myHandler = Handler(Looper.getMainLooper())

    private var remainingTime = totalDuration

    private val runnable = object : Runnable{
        override fun run() {
            if (remainingTime > 0){
                remainingTime -= DownInterval
                binding.tvSkip.text = "${remainingTime/1000}s,跳过"
                myHandler.postDelayed(this, DownInterval)
            }else{
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun afterCreate() {
        myHandler.post(runnable)
        binding.tvSkip.setOnClickListener {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        hideStatusBar()
    }
    override fun onDestroy() {
        super.onDestroy()
        myHandler.removeCallbacks(runnable)
    }

    //隐藏状态栏
    private fun hideStatusBar(){
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}