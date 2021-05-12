package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.globalChat
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 12/05/2021
 */
@Register("PostToGlobal", Types.MESSAGE, "postglobal")
class PostToGlobal: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        val client = clientManager.getClientFromUuid(command[3])!!
        if(globalChat.messages.containsKey(client)){
            val msgList = globalChat.messages.get(client)!!
            msgList.add(command[4])
            globalChat.messages.replace(client, msgList)
        }else{
            val msgList = arrayListOf<String>()
            msgList.add(command[4])
            globalChat.messages.put(client, msgList)
        }
    }
}