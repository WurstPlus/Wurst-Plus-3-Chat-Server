package org.madmeg.wurstchat.command

import org.madmeg.wurstchat.command.commands.*


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

        //MESSAGE
        commands.add(DmUser())

        //PINGS
        commands.add(PingUpCommand())
        commands.add(PingDownCommand())
        commands.add(PingGetDm())

        //ADMIN
        commands.add(ShutdownCommand())
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