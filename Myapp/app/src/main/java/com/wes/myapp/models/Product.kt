package com.wes.myapp.models

class Product {
    lateinit var name :String
    lateinit var quantity :String
    lateinit var price :String
    var id :String= ""
    constructor(name:String ,quantity :String,
                price :String, id :String){
        this.name = name
        this.quantity = quantity
        this.price= price
        this.id = id

    }
    constructor()
}