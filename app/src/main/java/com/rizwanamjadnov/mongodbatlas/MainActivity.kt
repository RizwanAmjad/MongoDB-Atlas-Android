package com.rizwanamjadnov.mongodbatlas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import org.bson.Document


class MainActivity : AppCompatActivity() {
    companion object{
        private const val APP_NAME = "mongodbapp-ztaos"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)
        val app = App(AppConfiguration.Builder(APP_NAME).build())

        val user = app.currentUser()

        val mongoClient =
            user!!.getMongoClient("mongodb-atlas")

        val database = mongoClient.getDatabase("Mongodb")
        val collection = database.getCollection("collection")

        collection.insertOne(Document().apply {
            put("name", "RizwanAmjad")
        })

    }
}