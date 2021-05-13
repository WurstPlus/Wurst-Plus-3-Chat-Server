package org.madmeg.wurstchat.console

import com.google.gson.*
import org.madmeg.wurstchat.clientManager
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


/**
 * @author Madmegsox1
 * @since 10/05/2021
 */


class ShutdownThread: Thread() {
    override fun run() {
        Print("Saving Client's data")
        saveClients()
        saveClientData()
    }

    private fun saveClientData(){
        val mainObject = JsonObject()
        for(c in clientManager.clients) {
            val messageObject = JsonObject()
            for(v in c.messages.keys){
                val clientArray = JsonArray()
                val m = c.messages[v]!!
                for(i in m){
                    clientArray.add(i)
                }
                messageObject.add(v.uuid, clientArray)
            }

            mainObject.add(c.uuid, messageObject)
        }
        val file = File("db\\chatlogs.json")
        if(!Files.exists(Paths.get("db\\"))){
            Files.createDirectories(Paths.get("db\\"))
        }
        try {
            val gson = GsonBuilder().setPrettyPrinting().create()
            val fileWriter = FileWriter(file)
            val jp = JsonParser()
            val je: JsonElement = jp.parse(mainObject.toString())
            fileWriter.write(gson.toJson(je))
            fileWriter.close()
            file.createNewFile()
        }catch (e: IOException){
            Print("An error occurred with file saving $e")
        }
    }

    private fun saveClients(){
        val mainObject = JsonObject()
        for(c in clientManager.clients){
            val clientObject = JsonObject()
            clientObject.addProperty("name", c.username)
            clientObject.addProperty("muted", c.muted)
            clientObject.addProperty("key", c.key)
            mainObject.add(c.uuid, clientObject)
        }
        val file = File("db\\clients.json")
        if(!Files.exists(Paths.get("db\\"))){
            Files.createDirectories(Paths.get("db\\"))
        }
        try {
            val fileWriter = FileWriter(file)
            val gson = GsonBuilder().setPrettyPrinting().create()
            val jp = JsonParser()
            val je: JsonElement = jp.parse(mainObject.toString())
            fileWriter.write(gson.toJson(je))
            fileWriter.close()
            file.createNewFile()
        }catch (e: IOException){
            Print("An error occurred with file saving $e")
        }
    }
}