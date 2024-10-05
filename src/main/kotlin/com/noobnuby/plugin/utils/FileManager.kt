package com.noobnuby.plugin.utils

import com.noobnuby.plugin.Main
import java.io.File


object FileManager {
	private val dir = File(Main.instance.dataFolder.path)

	private fun getFile(): File? {
		return dir.listFiles()?.find { it.name.endsWith(".zip") }
	}

	fun getName(): String {
		return getFile()?.name ?: ""
	}
}

