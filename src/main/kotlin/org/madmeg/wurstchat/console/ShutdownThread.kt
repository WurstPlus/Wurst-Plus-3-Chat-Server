package org.madmeg.wurstchat.console

import com.google.gson.JsonArray
import com.google.gson.JsonObject
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
            val fileWriter = FileWriter(file)
            fileWriter.write(mainObject.toString())
            fileWriter.close()
            file.createNewFile()
        }catch (e: IOException){
            Print("An error occurred with file saving $e")
        }
    }

    private fun saveClients(){
        val mainObject = JsonObject()
        for(c in clientManager.clients){
            mainObject.addProperty(c.uuid, c.username+":"+c.muted+":"+c.key)
        }
        val file = File("db\\clients.json")
        if(!Files.exists(Paths.get("db\\"))){
            Files.createDirectories(Paths.get("db\\"))
        }
        try {
            val fileWriter = FileWriter(file)
            fileWriter.write(mainObject.toString())
            fileWriter.close()
            file.createNewFile()
        }catch (e: IOException){
            Print("An error occurred with file saving $e")
        }
    }
}