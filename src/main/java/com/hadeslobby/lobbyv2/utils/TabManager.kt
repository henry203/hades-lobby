package com.hadeslobby.lobbyv2.utils

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player

object TabManager {
    fun build(player: Player, header: String?, footer: String?) {
        var header = header
        var footer = footer
        if (header == null) {
            header = ""
        }
        if (footer == null) {
            footer = ""
        }
        val tabHeader = IChatBaseComponent.ChatSerializer.a("{\"text\":\"$header\"}")
        val tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\":\"$footer\"}")
        val headerPacket = PacketPlayOutPlayerListHeaderFooter(tabHeader)
        try {
            val field = headerPacket.javaClass.getDeclaredField("b")
            field.isAccessible = true
            field[headerPacket] = tabFooter
        } catch (var10: Exception) {
            var10.printStackTrace()
        } finally {
            (player as CraftPlayer).handle.playerConnection.sendPacket(headerPacket)
        }
    }
}