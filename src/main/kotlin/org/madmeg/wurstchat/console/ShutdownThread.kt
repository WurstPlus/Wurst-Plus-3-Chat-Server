package org.madmeg.wurstchat.console

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
        saveClientData()
    }

    private fun saveClientData(){
        val mainObject = JsonObject()
        for(c in clientManager.clients) {
            val messageObject = JsonObject()
            var msg = ""
            for(v in c.messages.keys){
                msg += "${c.uuid}["
                val m = c.messages[c]!!
                var len = 0
                for(i in m){
                    len++
                    if(len >= m.size){
                        msg += "$i]-"
                    }else{
                        msg += "$i|"
                    }
                }
            }
            messageObject.addProperty("messages", msg)
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
}