package com.hadeslobby.lobbyv2.menus

import com.hadeslobby.lobbyv2.utils.ItemBuilder
import com.hadeslobby.lobbyv2.utils.SkullCreator
import org.bukkit.Bukkit
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player

object LobbiesMenu {
    fun open(p: Player) {
        val inv = Bukkit.createInventory(null, 27, "Lobbies")
        inv.setItem(10, ItemBuilder(SkullCreator.itemFromUrl("b21f8f3e52fa21b45ff56f3f73dd21661ff257d97bd52ed958f2d757be89a961")).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).name("§aLobby #1").lore("§f Players: §7" + Bukkit.getOnlinePlayers().size + "/150", "", "§eVocê está aqui.").removeAttributes().build())
        inv.setItem(11, ItemBuilder(SkullCreator.itemFromUrl("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025")).name("§aLobby #2").lore("§f Players: §70/150", "", "§cManutenção.").removeAttributes().build())
        inv.setItem(12, ItemBuilder(SkullCreator.itemFromUrl("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025")).name("§aLobby #3").lore("§f Players: §70/150", "", "§cManutenção.").removeAttributes().build())
        p.openInventory(inv)
    }
}