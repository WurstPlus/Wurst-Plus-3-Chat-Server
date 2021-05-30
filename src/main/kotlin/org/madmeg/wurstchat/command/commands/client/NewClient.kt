package org.madmeg.wurstchat.command.commands.client

import org.madmeg.wurstchat.client.Client
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

@Register("NewClient", Types.NOPRAM, "newclient")
class NewClient : Command() { // name = 2 uuid = 3
    override fun onCall(socket: Socket, command: List<String>) {
        var flag = false
        for (c in clientManager.clients) {
            if(command[3] == c.uuid){
                flag = true
            }
        }
        if(!flag) {
            val c = Client(command[2], command[3])
            clientManager.clients.add(c)
            Sockets().sendData(socket, "server:newclient:true:${c.key}")
        }else {
            Sockets().sendData(socket, "server:newclient:false")
        }

    }
}
