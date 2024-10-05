package com.noobnuby.plugin.utils

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

fun getIP(): String {
	var ip: String

	val client = HttpClient(CIO) {
		BrowserUserAgent()
	}

	runBlocking {
		ip = client.get("https://checkip.amazonaws.com/").body<String>()
	}

	return ip.trim()
}