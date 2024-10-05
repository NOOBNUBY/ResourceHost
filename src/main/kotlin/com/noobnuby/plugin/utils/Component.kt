package com.noobnuby.plugin.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

fun String.toMini(): Component = MiniMessage.miniMessage().deserialize(this)