package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.client.ClientManager
import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.console.Print
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

@Register("PingGetDm", Types.PING, "pinggetdm")
class PingGetDm: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        val client = clientManager.getClientFromUuid(command[3])
        var toSend = ":"
        if(client!!.messages.keys.isEmpty()){
            Sockets().sendData(socket, "server:pinggetdm:none")
        }
        for(c in client.messages.keys){
            toSend += "${c.uuid}["
            val msg = client.messages[c]!!
            var len = 0;
            for(i in msg){
                len++
                if(len >= msg.size){
                    toSend += "$i]-"
                }else {
                    toSend += "$i|"
                }
            }
        }
        Sockets().sendData(socket, "server:pinggetdm$toSend")
    }
}