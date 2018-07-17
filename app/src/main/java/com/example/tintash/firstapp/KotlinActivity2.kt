package com.example.tintash.firstapp

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test_java2.*
import java.util.*

class KotlinActivity2 : BaseClassActivity() {

    val TOTAL_COUNT = "total"
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_java2)
        count = intent.getIntExtra(TOTAL_COUNT,0)
        val r = Random()
        var randomInt = 0
        if (count > 0) {
            randomInt = r.nextInt(count +1)
        }
        random.text = randomInt.toString()
        header.text = getString(R.string.header, count)
    }
}
