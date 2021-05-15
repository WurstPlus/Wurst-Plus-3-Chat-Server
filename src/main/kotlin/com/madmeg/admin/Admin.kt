package com.madmeg.admin

import com.madmeg.admin.networking.Sockets

/**
 * @author Madmegsox1
 * @since 15/05/2021
 */


class Admin {
    init {
        println("Welcome to Wurst Chat Admin Console!\nPlease enter you admin key:\n> ")
        Main.key = readLine()!!
        println("1. Mute a Client\n" +
                "2. Shutdown server\n" +
                "3. Get Client info\n> ")
        val input = readLine()
        when(input){
            "1" -> {
                mute()
            }
            "2" -> {
                shutdown()
            }
            "3" -> {
                getClient()
            }
            else -> {
                println("Please enter a number 1-3!")
                Admin()
            }
        }
    }

    fun mute(){
        println("Please enter the uuid for the user to mute")
        val user = readLine()
        val s =Sockets().receiveSocket()
        Sockets().sendData(s , "client:mute:${Main.key}:$user:true")
        val data = Sockets().receiveData(s)
        if (data.readLine() == "server:mute:$user"){
            println("Muted $user!")
        }else{
            println("error\n${data.readLine()}")
        }
    }

    fun shutdown(){
        val s =Sockets().receiveSocket()
        Sockets().sendData(s , "client:shutdown:${Main.key}")
        val data = Sockets().receiveData(s)
        if(data.readLine() == "server:shutdown"){
            println("Server Shutdown!")
        }else{
            println("error\n${data.readLine()}")
        }
    }

    fun getClient(){
        println("Please enter the uuid for the user")
        val user = readLine()
        val s =Sockets().receiveSocket()
        Sockets().sendData(s , "client:getclientuuid:$user")
        val data = Sockets().receiveData(s)
        if(data.readLine().contains("server:getclientuuid:")){
            println(data.readLine())
            val spilt = data.readLine().split(":")
            println("Username: ${spilt[2]}")
            println("Uuid: ${spilt[3]}")
            println("isMuted: ${spilt[4]}")
        }
    }
}