package com.example.collegeprojectfinal

class signinuserclass {
    var name:String=""
    var email:String=""
    var password:String=""
    var cnfpassword:String=""
    constructor()
    constructor(name: String, email: String, password: String, cnfpassword: String) {
        this.name = name
        this.email = email
        this.password = password
        this.cnfpassword = cnfpassword
    }

}