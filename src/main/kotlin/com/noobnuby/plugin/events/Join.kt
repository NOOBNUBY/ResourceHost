package com.noobnuby.plugin.events

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.Main.Companion.uuid
import com.noobnuby.plugin.utils.FileManager
import com.noobnuby.plugin.utils.getSHA1
import com.noobnuby.plugin.utils.toMini
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import java.io.File
import java.lang.Deprecated

@Suppress("Deprecation")
class Join: Listener {
    @EventHandler
    fun PlayerJoinEvent.onJoin() {
		player.setResourcePack("http://127.0.0.1:${Main.instance.config.getInt("self-host-port")}/$uuid")
    }
}