package com.example.likunlin.italk.firebase

import java.util.*

data class firebase(val name:String = "",val mail:String = "",val img_path:String = "",val check : String= "") {
}


class message_info(var name:String,var time :String , var img_name:Int ,var message:String,var chanel : String) {

}

class message_info_1() {
    var name:String =""
    var time :String =""
    var img_name:Int = 0
    var message:String=""
    var chanel : String =""

}


object user{
    var name:String = ""
    var mail:String = ""
    var img_path:String = ""
    var check : String= ""
}

object firebase_message{
    var name:String = ""
    var time:String = ""
    var message:String =""
    var img_name:String =""
    var chanel:String = ""

}
