package org.madmeg.wurstchat.command.commands.admin

import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 12/05/2021
 */

@Register("MuteCommand", Types.ADMIN, "mute", "133333") // Change key!
class MuteCommand: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        clientManager.getClientFromUuid(command[3])!!.muted = command[4] == "true"
        Sockets().sendData(socket, "server:mute:${command[3]}")
    }
}