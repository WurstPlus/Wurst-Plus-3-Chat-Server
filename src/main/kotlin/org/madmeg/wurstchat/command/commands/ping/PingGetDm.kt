package org.madmeg.wurstchat.command.commands.ping

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

@Register("PingGetDm", Types.PING, "pinggetdm")
class PingGetDm: Command() {
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        //val fromClient = clientManager.getClientFromUuid(command[3])
        var toSend = ":"
        if(fromClient.messages.keys.isEmpty()){
            Sockets().sendData(socket, "server:pinggetdm:none")
        }
        for(c in fromClient.messages.keys){
            toSend += "${c.uuid}["
            val msg = fromClient.messages[c]!!
            var len = 0;
            for(i in msg){
                len++
                if(len >= msg.size){
                    toSend += "$i];"
                }else {
                    toSend += "$i|"
                }
            }
        }
        Sockets().sendData(socket, "server:pinggetdm$toSend")
    }
}