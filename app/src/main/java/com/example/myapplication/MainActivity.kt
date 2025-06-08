package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TAG: String = "=== MainActivity"

    private lateinit var tvClickInfo: TextView
    private lateinit var tvMotionInfo: TextView
    private var cntClick: Int = 0

//    var pDownX=0
//    var pDownY=0
//    var pUpX=0
//    var pUpY=0

    companion object {
        private val KEY_RANDOM_VALUE: String = "RandomValue"
    }


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvClickInfo = this.findViewById<TextView>(R.id.tvClickInfo)
        this.tvMotionInfo = this.findViewById<TextView>(R.id.tvMotionInfo)
        val LL: LinearLayout = this.findViewById(R.id.main)

        val TV: TextView = this.findViewById(R.id.tv1)
        val Tv2 : TextView = this.findViewById(R.id.text_view_id)

        LL.setOnTouchListener { v, event ->
            val action = event.action
            val x = event.x
            val y = event.y
            var S = ""
            when (action) {
                MotionEvent.ACTION_DOWN -> S += "Нажатие\n"
                MotionEvent.ACTION_MOVE -> S += "Перемещение\n"
                MotionEvent.ACTION_UP -> S += "Отпускание\n"
            }
            S += "X = $x\nY = $y"
            this.tvMotionInfo.setText(S)
            false
        }

        LL.setOnClickListener {
            //-- Увеличиваем счетчик количества кликов по Активности --
            cntClick++
            //-- Отображаем информацию в виджете tvClickInfo --
            tvClickInfo.text = "Количество кликов: " +  this@MainActivity.cntClick
        }

        Tv2.setText(R.string.app_name)

        if (savedInstanceState != null) {
            val value: String = savedInstanceState.getString(KEY_RANDOM_VALUE).toString()
            TV.setText(value)
        } else {
            val value = (Math.random() * 100).toInt()
            TV.setText("Случайное число: " + value)
        }

        Log.d(TAG, "onCreate")

    }


    public override fun onSaveInstanceState(bundle: Bundle) {
        super.onSaveInstanceState(bundle)
        Log.d(TAG, "onSaveInstanceState")
        //--- Читаем значение из Текстового поля ---------
        val TV: TextView? = this.findViewById<View>(R.id.tv1) as TextView?
        val value = TV?.text.toString()
        //--- И помещаем его в Bundle --------------------
        bundle.putString(KEY_RANDOM_VALUE, value)
    }

    override fun onStart() {
        super.onStart() //Обязательно вызвать
        //метод родительского класса
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume() //Обязательно вызвать
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause() //Обязательно вызвать
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop() //Обязательно вызвать
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy() //Обязательно вызвать
        Log.d(TAG, "onDestroy")
    }

    fun makeMeToast(view: View?){
        Log.w(this.TAG, "Лог-сообщение");
        Toast.makeText(this,"ShalomShabbat", Toast.LENGTH_SHORT).show()

    }

    fun btnClick(view:View?){
        val txtView: TextView = this.findViewById(R.id.text_view_id)
        val value = (Math.random() * 100).toInt()
        txtView.setText("Случайное число: " + value)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        val id: Int = item.itemId
//        when(id){
//            R.id.action_settings ->  return true
//            R.id.action_hello_world -> {
//                Toast.makeText(this, R.string.action_hello_world, Toast.LENGTH_LONG).show()
//                return true
//            }
//            R.id.action_android_forever -> {
//                Toast.makeText(this, R.string.action_android_forever, Toast.LENGTH_SHORT).show()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}