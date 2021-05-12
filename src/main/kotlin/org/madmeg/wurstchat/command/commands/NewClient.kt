package org.madmeg.wurstchat.command.commands

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

@Register("NewClient", Types.CLIENT, "newclient")
class NewClient : Command() { // name = 2 uuid = 3
    override fun onCall(socket: Socket, command: List<String>) {
        var flag = false
        for (c in clientManager.clients) {
            if(command[3] == c.uuid){
                flag = true
            }
        }
        if(!flag) {
            clientManager.clients.add(Client(command[2], command[3]))
            Sockets().sendData(socket, "server:newclient:true")
        }else {
            Sockets().sendData(socket, "server:newclient:false")
        }

    }
}