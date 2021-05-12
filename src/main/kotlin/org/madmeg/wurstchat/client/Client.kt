package org.madmeg.wurstchat.client

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class Client(username: String, uuid: String) {
    val username: String
    val uuid: String
    var online: Boolean
    var muted: Boolean
    val messages: MutableMap<Client, ArrayList<String>>
    init {
        this.username = username
        this.uuid = uuid
        this.online = false
        this.muted = false
        this.messages = mutableMapOf()
    }
}