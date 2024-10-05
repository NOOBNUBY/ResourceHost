package com.noobnuby.plugin.utils

import java.io.File
import java.io.FileInputStream
import java.security.DigestInputStream
import java.security.MessageDigest

fun getSHA1(file: File): ByteArray? {
	val fileInputStream = FileInputStream(file)
	var digest = MessageDigest.getInstance("SHA-1")
	val digestInputStream = DigestInputStream(fileInputStream, digest)
	val bytes = ByteArray(1024)

	while (digestInputStream.read(bytes) > 0) digest = digestInputStream.messageDigest
	return digest.digest()
}