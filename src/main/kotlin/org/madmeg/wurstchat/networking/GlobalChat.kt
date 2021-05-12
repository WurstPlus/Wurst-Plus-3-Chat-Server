package org.madmeg.wurstchat.networking

import org.madmeg.wurstchat.client.Client

/**
 * @author Madmegsox1
 * @since 12/05/2021
 */

class GlobalChat {
    val messages: MutableMap<Int, Pair<Client, String>>
    init {
        this.messages = mutableMapOf()
    }
}