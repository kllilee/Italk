package com.example.likunlin.italk.information

import com.example.likunlin.italk.firebase.user.name

class friends_info(val name:String, val img_path :String) {

}

class friends_list: ArrayList<friends_info>(){
    fun get ():ArrayList<friends_info>{
        val friends_info_1 = ArrayList<friends_info>()
        friends_info_1.add(friends_info(name = "blueking01",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking02",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking03",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking04",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking05",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking01",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking02",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking03",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking04",img_path = "R.id."))
        friends_info_1.add(friends_info(name = "blueking05",img_path = "R.id."))

        return friends_info_1
    }
}