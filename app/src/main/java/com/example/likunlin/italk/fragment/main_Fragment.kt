package com.example.likunlin.italk.fragment


import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.likunlin.italk.R
import com.example.likunlin.italk.firebase.user
import com.example.likunlin.italk.login
import kotlinx.android.synthetic.main.main_fragment.*


class main_Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private val bt_signout_click = View.OnClickListener{
        signout()
    }

    private fun signout() {

        user.name = ""
        user.mail = ""
        user.img_path =""
        user.check = "NO"
        val preference = PreferenceManager.getDefaultSharedPreferences(context)
        preference.edit().clear().commit()

        val intent = Intent(context,login::class.java)
        startActivity(intent)
    }

    private fun init() {

        main_name.setText(user.name)

        bt_signout.setOnClickListener(bt_signout_click)



    }


}
