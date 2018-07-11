package com.example.tintash.firstapp
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test_java1.*

class KotlinActivity1 : BaseClassActivity() {

    var count_int = 0
    lateinit var context: Context
    val TOTAL_COUNT = "total"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_java1)
        context = this
        setter()
    }
    fun setter(){
        count.setOnClickListener {
            count_int += 1
            tv_count.text = count_int.toString()
        }
        random.setOnClickListener{ v-> startNewActivity() }
        toast.setOnClickListener {_->
            showToast("Test Toast", Toast.LENGTH_SHORT)
        }
    }

    private fun startNewActivity() {

        val intent = Intent(context,KotlinActivity2::class.java)
        intent.putExtra(TOTAL_COUNT,count_int)
        startActivity(intent)
    }

    private fun showToast(message: String, length:Int){
        Toast.makeText(context,message,length).show()
    }
}
