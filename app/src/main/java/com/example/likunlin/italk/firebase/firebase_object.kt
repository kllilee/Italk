package com.example.likunlin.italk.firebase

import java.util.*

data class firebase(val name:String = "",val mail:String = "",val img_path:String = "",val check : String= "") {
}

object user{
    var name:String = ""
    var mail:String = ""
    var img_path:String = ""
    var check : String= ""
}

object message{
    var name:String = ""
    var time:String = ""
    var message:String =""
}
