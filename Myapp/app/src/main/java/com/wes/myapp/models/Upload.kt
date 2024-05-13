package com.wes.myapp.models

import com.google.firebase.auth.ActionCodeUrl
import java.net.URL

class Upload {
    var name :String =""
    var quantity :String=""
    var price :String = ""
    var imageUrl:String =""
    var id :String = ""
    constructor(name:String, quantity :String,
                price :String, imageUrl: String,
                id :String){
        this.name =name
        this.quantity=quantity
        this.price = price
        this.imageUrl = imageUrl
        this.id =id

    }
    constructor()

}