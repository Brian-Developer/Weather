package com.example.weatherforecast.ui.main

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.Validator
import com.example.weatherforecast.adapter.ItemAdapter

class MainFragment : Fragment() {
    lateinit var recycle_result: RecyclerView
    lateinit var btn_weather: Button
    lateinit var edit_city: EditText
    lateinit var tv_error_message: TextView
    var mLastClickTime : Long = 0
    var defaultInterval: Int = 2000
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View
        view =  inflater.inflate(R.layout.main_fragment, container, false)
        recycle_result = view.findViewById(R.id.recycle_result)
        btn_weather = view.findViewById(R.id.btn_weather)
        tv_error_message = view.findViewById(R.id.tv_error_message)
        edit_city = view.findViewById(R.id.edit_city)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Declare ViewModel for MainFragment

        btn_weather.setOnClickListener(View.OnClickListener {
            if (SystemClock.elapsedRealtime() - mLastClickTime < defaultInterval) {
                Toast.makeText(activity, "Action to fast", Toast.LENGTH_SHORT).show()
            }
            mLastClickTime = SystemClock.elapsedRealtime()

            if(!Validator.validateInputCity(edit_city.text.trim().toString()))
                Toast.makeText(activity, "Please enter at least 3 characters", Toast.LENGTH_SHORT).show()
            else
                viewValue()
        })
    }

    private fun viewValue(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.retrieveAPIData(edit_city.text.trim().toString())
        viewModel.responseData.observe(viewLifecycleOwner, Observer {
            if(it.responseSuccess != null){
                //Sorry, I still can't handle all cases that make adapter crashed since any errors happen.
                recycle_result.visibility = View.VISIBLE
                tv_error_message.visibility = View.GONE
                recycle_result.layoutManager = LinearLayoutManager(activity)
                val adapter  = ItemAdapter(it.responseSuccess)
                recycle_result.adapter = adapter
            } else if(it.responseFail != null) {
                recycle_result.visibility = View.GONE
                tv_error_message.visibility = View.VISIBLE
                tv_error_message.text = "Response: " + it.responseFail?.message + "\n" + "Code: " + it.responseFail?.cod
            } else {
                recycle_result.visibility = View.GONE
                tv_error_message.visibility = View.VISIBLE
                tv_error_message.text = "Response: " + it.throwable?.toString()
            }
        })
    }
}