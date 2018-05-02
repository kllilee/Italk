package com.example.likunlin.italk.information

class message_list: ArrayList<message_info>() {


    fun get():ArrayList<message_info> {
        val message_info_1 = ArrayList<message_info>()

        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test1",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Hury",time = "2018/03/16",message = "test2",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test3",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "York",time = "2018/03/16",message = "test4",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test5",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test1",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Hury",time = "2018/03/16",message = "test2",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test3",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "York",time = "2018/03/16",message = "test4",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test5",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test1",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Hury",time = "2018/03/16",message = "test2",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test3",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "York",time = "2018/03/16",message = "test4",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test5",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test1",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Hury",time = "2018/03/16",message = "test2",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test3",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "York",time = "2018/03/16",message = "test4",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test5",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test1",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Hury",time = "2018/03/16",message = "test2",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test3",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "York",time = "2018/03/16",message = "test4",img_name = "img_path",chanel = "admin01"))
        message_info_1.add(message_info(name = "Ted",time = "2018/03/16",message = "test5",img_name = "img_path",chanel = "admin01"))


        return message_info_1
    }
}


class message_info(val name:String,val time :String , val img_name :String ,val message:String,val chanel : String) {

}