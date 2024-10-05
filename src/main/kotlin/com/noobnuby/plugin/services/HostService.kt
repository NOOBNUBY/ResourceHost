package com.noobnuby.plugin.services

import com.noobnuby.plugin.Main
import com.noobnuby.plugin.utils.FileManager
import com.noobnuby.plugin.utils.getSHA1
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.fileRouting() {
	routing {
		get("/${getSHA1(FileManager.getPath())}") {
			val dir = File(Main.instance.dataFolder.path)
			val file = File(dir, FileManager.getName())
			call.respondFile(file)
		}
	}
}