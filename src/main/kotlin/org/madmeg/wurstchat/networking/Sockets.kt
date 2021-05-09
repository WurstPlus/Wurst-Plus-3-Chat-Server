package org.madmeg.wurstchat.networking

import org.madmeg.wurstchat.PORT
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class Sockets {
    fun openPort(): ServerSocket{
        val socket = ServerSocket(PORT)
        return socket
    }

    fun receiveSocket(socket: ServerSocket): Socket{
        return socket.accept()
    }

    fun receiveData(socket: Socket): BufferedReader{
        val stream = socket.getInputStream()
        return BufferedReader(InputStreamReader(stream))
    }

    fun sendData(socket: Socket, message: String){
        val output = socket.getOutputStream()
        val writer = PrintWriter(output, true)
        writer.println(message)
    }
}