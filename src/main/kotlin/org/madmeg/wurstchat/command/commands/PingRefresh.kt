package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

@Register("PingRefresh", Types.PING, "pingrefresh")
class PingRefresh: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        //Sockets().sendData(socket, )
    }
}