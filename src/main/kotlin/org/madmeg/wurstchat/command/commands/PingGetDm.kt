package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.client.ClientManager
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
    override fun onCall(socket: Socket, command: List<String>) {
        val client = ClientManager().getClientFromUuid(command[3])
        var toSend = ":"
        for(c in client!!.messages.keys){
            toSend += "${c.uuid}["
            val msg = client.messages[c]!!
            for(i in msg){
                if(msg.indexOf(i) == msg.size){
                    toSend += "$i]-"
                }else {
                    toSend += "$i|"
                }
            }
        }
        Sockets().sendData(socket, "server:pinggetdm$toSend")
    }
}