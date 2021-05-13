package org.madmeg.wurstchat.console

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.madmeg.wurstchat.client.Client
import org.madmeg.wurstchat.clientManager
import java.io.File
import java.io.FileReader

/**
 * @author Madmegsox1
 * @since 12/05/2021
 */

class LoadData {
    fun loadClients(){
        val jsonParser = JsonParser()
        val file = File("db\\clients.json")
        if(!file.exists())return
        val reader = FileReader(file)
        val element = jsonParser.parse(reader)
        val jsonObject: JsonObject = element.asJsonObject
        for(clients in jsonObject.keySet()){
            val clientObject = jsonObject.get(clients).asJsonObject
            val c = Client(clientObject.get("name").asString, clients)
            clientManager.clients.add(c)
            c.muted = clientObject.get("muted").asBoolean
            c.key = clientObject.get("key").asString
        }
    }

    fun loadMessages(){
        val jsonParser = JsonParser()
        val file = File("db\\chatlogs.json")
        if(!file.exists())return
        val reader = FileReader(file)
        val element = jsonParser.parse(reader)
        val jsonObject: JsonObject = element.asJsonObject
        for(client in jsonObject.keySet()){
            val subClient = jsonObject.get(client).asJsonObject
            val msg = arrayListOf<String>()
            val c = clientManager.getClientFromUuid(client)
            for(comp in subClient.keySet()){
                for(i in subClient.get(comp).asJsonArray){
                    msg.add(i.asString)
                }
                c!!.messages.put(clientManager.getClientFromUuid(comp)!!, msg)
            }
        }
    }
}