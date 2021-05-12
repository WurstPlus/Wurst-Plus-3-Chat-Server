package org.madmeg.wurstchat.client

import org.madmeg.wurstchat.security.keyGen

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
    val friends: MutableMap<Client, Boolean>
    var key: String
    init {
        this.username = username
        this.uuid = uuid
        this.key = keyGen().newKey()
        this.online = false
        this.muted = false
        this.messages = mutableMapOf()
        this.friends = mutableMapOf()
    }
}