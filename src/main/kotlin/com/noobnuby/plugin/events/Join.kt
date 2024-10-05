package com.noobnuby.plugin.events

import com.noobnuby.plugin.utils.FileManager
import com.noobnuby.plugin.utils.getSHA1
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Join: Listener {
    @EventHandler
    fun PlayerJoinEvent.onJoin() {
		player.setResourcePack("",getSHA1(FileManager.getPath()), false)
    }
}