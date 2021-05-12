package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import java.net.Socket

/**
@author Madmegsox1
@since 12/05/2021
 */

@Register("MuteCommand", Types.ADMIN, "mute", "1122222") // Change key!
class MuteCommand: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        clientManager.getClientFromUuid(command[3])!!.muted = command[4] == "true"
    }
}