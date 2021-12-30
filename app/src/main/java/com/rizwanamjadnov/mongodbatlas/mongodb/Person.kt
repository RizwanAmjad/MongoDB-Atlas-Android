package com.rizwanamjadnov.mongodbatlas.mongodb

import io.realm.mongodb.App
import io.realm.Realm
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.User
import io.realm.mongodb.mongo.MongoCollection
import io.realm.mongodb.mongo.iterable.FindIterable
import org.bson.Document

class Person(
    private val name: String,
    private val age: Int
){
    companion object{
        private const val APP_NAME = "mongodbapp-ztaos"
    }

    lateinit var app: App
    var user: User
    var collection: MongoCollection<Document>

    init{
        Realm.init(this)
        var app = App(AppConfiguration.Builder(APP_NAME).build())
        user = app.currentUser()!!
        val mongoClient =
            user!!.getMongoClient("mongodb-atlas")

        val database = mongoClient.getDatabase("Mongodb")
        collection = database.getCollection("collection")
    }

    fun create(name: String, age: Int){
        collection.insertOne(Document().apply {
            put(name, age)
        })
    }

    fun read():FindIterable<Document>{
        return collection.find()
    }

    fun update(name: String, age: Int){
        collection.findOneAndUpdate(Document().apply{},Document().apply {
            put(name, age)
        }, )
    }

    fun delete(){
        collection.findOneAndDelete(Document().apply{})
    }

}