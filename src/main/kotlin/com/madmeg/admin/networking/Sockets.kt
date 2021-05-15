package com.madmeg.admin.networking

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

    fun receiveSocket(): Socket{
        return Socket("0.0.0.0", 4200)
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