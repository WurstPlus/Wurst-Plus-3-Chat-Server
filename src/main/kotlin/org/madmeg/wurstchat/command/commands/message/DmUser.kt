package org.madmeg.wurstchat.command.commands.message

import org.madmeg.wurstchat.client.Client
import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

@Register("dmUser", Types.MESSAGE, "dmuser")
class DmUser: Command() {
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        //val fromClient = clientManager.getClientFromUuid(command[3])!!
        val toClient = clientManager.getClientFromUuid(command[5])
        if(toClient == null){
            Sockets().sendData(socket, "server:dmuser:error1")
            return
        }
        if(!toClient.online){
            Sockets().sendData(socket, "server:dmuser:error2")
            return
        }
        if(fromClient.muted){
            Sockets().sendData(socket, "server:dmuser:error3")
            return
        }
        val msg = command[6]
        if(toClient.messages.containsKey(fromClient)) {
            val msgList = toClient.messages[fromClient]!!
            msgList.add(msg)
            toClient.messages.replace(fromClient, msgList)
        }else{
            val msgList = arrayListOf<String>()
            msgList.add(msg)
            toClient.messages.put(fromClient, msgList)
        }
        Sockets().sendData(socket, "server:dmuser:sent")
    }
}