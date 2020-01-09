package com.example.ookbee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.architecturecomponent.ui.login.BookFragment
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val list = listOf(1, 8, 2, 6, 5, 3, 5, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.inTransaction {
            add(R.id.container, BookFragment())
        }
    }
}


//ข้อ1
//String s1 = new String("Test");
//String s2 = new String("Test");
//if (s1==s2)
//System.out.println("Same");
//if (s1.equals(s2))
//System.out.println("Equals");

// s1 == s2 System.out.println("Same");

//  if (s1.equals(s2)) เทียบสตริงได้เพราะ string  ใช้ equals


//ข้อ 2
private fun IsOverlapped(statdate: String, endDate: String): Boolean{
    val mutableList : MutableList<Date> = ArrayList()
    val start = convertDate(statdate)
    val end  = convertDate(endDate)
    mutableList.add(start)
    mutableList.add(end)
    val result = mutableList.groupBy { it }.values.mapNotNull { it.maxBy { it } }
    return false
}

private fun convertDate(statdate: String): Date {
    val patternDefault: String = "yyyyMMdd"
    val format = SimpleDateFormat(patternDefault, Locale("th", "TH"))
    var date = format.parse(statdate)
    return date
}

//ข้อ 3 getmacValue
private fun GetMaxTwo(array: List<Int>) {
    //val max = amplitudes.max() ?: 0
    //return max
    var highest = Int.MIN_VALUE
    var secondHighest = Int.MIN_VALUE
    for (i in array.indices) {
        if (array[i] > highest) {
            secondHighest = highest
            highest = array[i]
        } else if (array[i] > secondHighest) {
            secondHighest = array[i]
        }
    }
}

//ข้อ 4 ไล่ดูใน Code ได้เลยครับ เริ่มที่ BookFragment()
