package org.madmeg.wurstchat.command

import org.madmeg.wurstchat.command.commands.admin.*
import org.madmeg.wurstchat.command.commands.message.*
import org.madmeg.wurstchat.command.commands.ping.*
import org.madmeg.wurstchat.command.commands.client.*

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class Commands {
    var commands: ArrayList<Command>

    init {
        commands = arrayListOf()
        //CLIENT
        commands.add(NewClient())
        commands.add(GetClientFromUuid())
        commands.add(AcceptFriendRequest())
        commands.add(SendFriendRequest())
        commands.add(GetFriends())

        //MESSAGE
        commands.add(DmUser())
        commands.add(PostToGlobal())

        //PINGS
        commands.add(PingUpCommand())
        commands.add(PingDownCommand())
        commands.add(PingGetDm())
        commands.add(PingGetGlobal())

        //ADMIN
        commands.add(ShutdownCommand())
        commands.add(MuteCommand())
    }

    fun getCommands(name: Class<*>): Command {
        for (c in commands) {
            if (name.isInstance(c)) {
                return c
            }
        }
        return null!!
    }

    fun getCommandsWithType(types: Types): Command {
        for (c in commands) {
            if (types == c.type) {
                return c
            }
        }
        return null!!
    }
}