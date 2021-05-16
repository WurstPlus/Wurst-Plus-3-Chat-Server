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
 * @since 12/05/2021
 */
@Register("GetClientFromUuid", Types.NOPRAM, "getclientuuid")
class GetClientFromUuid: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        val c = clientManager.getClientFromUuid(command[2])!!
        Sockets().sendData(socket, "server:getclientuuid:${c.username}:${c.uuid}:${c.muted}")
    }
}