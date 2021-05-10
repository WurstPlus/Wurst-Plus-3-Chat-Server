package org.madmeg.wurstchat.command.commands

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
    override fun onCall(socket: Socket, command: List<String>) {
        val fromClient = Client(command[2], command[3])
        val toClient = clientManager.getClientFromUuid(command[4])
        if(toClient == null){
            Sockets().sendData(socket, "server:dmuser:error1")
            return
        }
        if(!toClient.online){
            Sockets().sendData(socket, "server:dmuser:error2")
            return
        }
        val msg = command[5]
        val msgList = toClient.messages.get(fromClient)
        msgList!!.add(msg)
        toClient.messages.replace(fromClient, msgList)
        Sockets().sendData(socket, "server:dmuser:sent")
    }
}