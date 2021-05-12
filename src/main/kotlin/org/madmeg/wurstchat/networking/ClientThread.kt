package org.madmeg.wurstchat.networking

import org.madmeg.wurstchat.Main
import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.console.Print
import org.madmeg.wurstchat.getIllegalChars
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class ClientThread(socket: Socket, parent: Main) : Thread() {
    val socket: Socket = socket
    val parent: Main = parent
    override fun run() {
        handleClient()
        parent.clientThreads.remove(this)
    }

    private fun handleClient() {
        val reader = Sockets().receiveData(socket)

        val data = reader.readLine() // Reads the data
        val command = data.split(":") // Splits command
        for (i in command) {
            for (x in getIllegalChars()) {
                if (i.contains(x)) {
                    Sockets().sendData(socket, "server:error1")
                    return
                }
            }
        }

        for (c in parent.commands.commands) {
            try {
                if (command[1] == c.syntax && command[0] == "client") {
                    try {
                        if (c.secureKey == "") {
                            val client = clientManager.getClientFromUuid(command[3])!!
                            if(client.username != command[2]){
                                Sockets().sendData(socket, "server:error4")
                                return
                            }
                            c.onCall(socket, command, client)
                        } else if (c.secureKey == command[2]) {
                            c.onCall(socket, command)
                        }
                    } catch (e: IndexOutOfBoundsException) {
                        Sockets().sendData(socket, "server:error2")
                        return
                    } catch (e: Exception) {
                        Print("A Exception occurred in commands $e")
                        Sockets().sendData(socket, "server:error3")
                        return
                    }
                }
            } catch (e: IndexOutOfBoundsException) {
                Sockets().sendData(socket, "server:error2")
                return
            } catch (e: Exception) {
                Print("A Exception occurred in commands loop $e")
                Sockets().sendData(socket, "server:error3")
                return
            }

        }
    }
}