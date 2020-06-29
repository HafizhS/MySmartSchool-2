package com.example.mysmartschooll

import java.lang.reflect.Constructor

class Entity_smartinfo(var idInfo: String?, var pengirim: String, var date: String, var judul: String, var about: String){


    constructor(): this("","","","","")
    constructor(s: String, s1: String, s2: String, s3: String) : this()


}