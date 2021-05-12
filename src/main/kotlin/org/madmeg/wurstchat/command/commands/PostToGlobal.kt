package org.madmeg.wurstchat.command.commands

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
@Register("PostToGlobal", Types.MESSAGE, "postglobal")
class PostToGlobal: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        val client = clientManager.getClientFromUuid(command[3])!!
        if(client.muted){
            Sockets().sendData(socket, "server:postglobal:error1")
            return
        }
        var count = 0
        if(globalChat.messages.isNotEmpty()) {
            for (i in globalChat.messages.keys) {
                count++
            }
        }
        globalChat.messages.put(count, Pair(client, command[4]))
        Sockets().sendData(socket, "server:postglobal:posted")
    }
}