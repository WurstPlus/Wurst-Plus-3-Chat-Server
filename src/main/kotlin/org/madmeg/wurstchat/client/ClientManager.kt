package org.madmeg.wurstchat.client

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class ClientManager {
    val clients: ArrayList<Client>

    init {
        this.clients = arrayListOf()
    }

    fun getClientFromName(name: String): Client? {
        for (c in clients) {
            if (c.username == name) {
                return c
            }
        }
        return null
    }

    fun getClientFromUuid(name: String): Client? {
        for (c in clients) {
            if (c.uuid == name) {
                return c
            }
        }
        return null
    }
}