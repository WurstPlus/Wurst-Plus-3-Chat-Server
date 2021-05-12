package org.madmeg.wurstchat.networking

import org.madmeg.wurstchat.Main
import org.madmeg.wurstchat.console.Print
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

        for (c in parent.commands.commands) {
            try {
                if (command[1] == c.syntax && command[0] == "client") {
                    try {
                        if (c.secureKey == "") {
                            c.onCall(socket, command)
                        } else if (c.secureKey == command[2]) {
                            c.onCall(socket, command)
                        }
                    } catch (e: IndexOutOfBoundsException) {
                        return
                    } catch (e: Exception) {
                        Print("A Exception occurred in commands $e")
                    }
                }
            } catch (e: IndexOutOfBoundsException) {
                return
            } catch (e: Exception) {
                Print("A Exception occurred in commands loop $e")
            }

        }
    }
}