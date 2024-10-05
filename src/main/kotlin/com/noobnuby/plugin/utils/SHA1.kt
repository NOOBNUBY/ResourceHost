package com.noobnuby.plugin.utils

import java.io.File
import java.io.FileInputStream
import java.security.DigestInputStream
import java.security.MessageDigest

object SHA1 {
	fun sha1CodeString(file: File): String {
		FileInputStream(file).use { fileInputStream ->
			DigestInputStream(fileInputStream, MessageDigest.getInstance("SHA-1")).use { digestInputStream ->
				val bytes = ByteArray(1024)
				var digest: MessageDigest? = null

				while (digestInputStream.read(bytes) > 0) digest = digestInputStream.messageDigest
				val resultByteArry = digest!!.digest()
				return bytesToHexString(resultByteArry)
			}
		}
	}

	private fun bytesToHexString(bytes: ByteArray): String {
		val sb = StringBuilder()
		for (b in bytes) {
			val value = b.toInt() and 0xFF
			if (value < 16) {
				sb.append("0")
			}
			sb.append(Integer.toHexString(value).uppercase())
		}
		return sb.toString()
	}
}