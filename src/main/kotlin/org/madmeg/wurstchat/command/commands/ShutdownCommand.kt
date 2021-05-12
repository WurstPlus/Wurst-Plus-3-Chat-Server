package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.console.Print
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket
import kotlin.system.exitProcess

@Register("Shutdown", Types.ADMIN, "shutdown", "133333") // Change key if you are running this
class ShutdownCommand: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        Print("Shutdown request from ${socket.inetAddress}")
        Sockets().sendData(socket, "server:shutdown")
        exitProcess(1)
    }
}