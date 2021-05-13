package org.madmeg.wurstchat.command.commands.client

import org.madmeg.wurstchat.client.Client
import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 13/05/2021
 */

@Register("AcceptFriendRequest", Types.CLIENT, "acceptfriendrq")
class AcceptFriendRequest: Command() {
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        val client = clientManager.getClientFromUuid(command[5])!!
        val isAccepted = command[6] == "true"
        if(fromClient.friends[client] == false && client.friends[fromClient] == true){
            fromClient.friends.replace(client, isAccepted)
            client.friends.replace(fromClient, isAccepted)
        }
        Sockets().sendData(socket, "server:acceptfriendrq:$isAccepted")
    }
}