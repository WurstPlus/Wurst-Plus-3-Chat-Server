package org.madmeg.wurstchat.command.commands.client

import org.madmeg.wurstchat.client.Client
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 15/05/2021
 */

@Register("GetFriends", Types.CLIENT, "getfriends")
class GetFriends: Command() {
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        var sendString = ""
        for (f in fromClient.friends.keys){
            if(fromClient.friends.get(f) == true && f.friends.get(fromClient) == true){
                sendString += "${f.username}|"
            }
        }
        if(sendString == ""){
            Sockets().sendData(socket, "server:getfriends:error1")
        }else {
            Sockets().sendData(socket, "server:getfriends:$sendString")
        }
    }
}