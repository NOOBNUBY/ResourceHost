package com.noobnuby.plugin.utils

import java.io.FileInputStream
import java.security.MessageDigest


fun getSHA1(path: String): ByteArray? {
	try {
		FileInputStream(path).use { fis ->
			val sha1 = MessageDigest.getInstance("SHA-1")
			val data = ByteArray(1024)
			var read = 0
			while ((fis.read(data).also { read = it }) != -1) {
				sha1.update(data, 0, read)
			}
			return sha1.digest()
		}
	} catch (ex: Exception) {
		ex.printStackTrace()
		return null
	}
}