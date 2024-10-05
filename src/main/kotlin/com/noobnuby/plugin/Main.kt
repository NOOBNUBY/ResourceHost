package com.noobnuby.plugin

import com.noobnuby.plugin.commands.HelloBrigadier
import com.noobnuby.plugin.events.Join
import com.noobnuby.plugin.services.fileRouting
import com.noobnuby.plugin.utils.fileName
import com.noobnuby.plugin.utils.toMini
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.bukkit.plugin.java.JavaPlugin
import kotlin.math.log

class Main : JavaPlugin() {
    companion object { lateinit var instance: Main }
	private val logPrefix = "<gradient:#9838ff:#00b3ff>[ResourceHost<b></b>]</gradient>"

    override fun onEnable() {
        instance = this
        saveDefaultConfig()
		//[ Developed by noobnuby ]
        HelloBrigadier.registerCommand()

        server.pluginManager.apply {
            registerEvents(Join(),this@Main)
        }

		logger.info(dataFolder.path)
		logger.info(fileName())

		componentLogger.info("$logPrefix Enable!".toMini())
		if(config.getBoolean("enable-self-host")) {
			embeddedServer(Netty, port = config.getInt("self-host-port"), host = "0.0.0.0") {
				fileRouting()
			}.start(wait = false)
		}
    }

	override fun onDisable() {
		componentLogger.info("$logPrefix Disable!".toMini())
	}
}
