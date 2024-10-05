package com.noobnuby.plugin.events

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.utils.FileManager
import com.noobnuby.plugin.utils.SHA1
import com.noobnuby.plugin.utils.getIP
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class Join : Listener {
	@EventHandler
	fun PlayerJoinEvent.onJoin() {
		val sha1 = SHA1.sha1CodeString(FileManager.getFile()!!)
		player.setResourcePack("http://${getIP()}:${Main.instance.config.getInt("self-host-port")}/$sha1", sha1)
	}
}