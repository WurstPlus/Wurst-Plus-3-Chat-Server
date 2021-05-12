package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.client.Client
import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.globalChat
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 12/05/2021
 */
@Register("PingGetGlobal", Types.PING, "pinggetglobal")
class PingGetGlobal: Command() {
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        //val fromClient = clientManager.getClientFromUuid(command[3])
        var toSend = ":"
        if(globalChat.messages.isEmpty()){
            Sockets().sendData(socket, "server:pinggetglobal:none")
        }
        for(c in globalChat.messages.keys){
            toSend += "$c|"+ globalChat.messages[c]!!.first.uuid+"|"+ globalChat.messages[c]!!.second +";"
        }
        Sockets().sendData(socket, "server:pinggetglobal$toSend")
    }
}