package com.hadeslobby.lobbyv2.menus

import com.hadeslobby.lobbyv2.utils.ItemBuilder
import com.hadeslobby.lobbyv2.utils.SkullCreator
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.inventory.ItemStack

object ProfileMenu {
    fun open(p: Player) {
        val inv = Bukkit.createInventory(null, 45, "Gerenciador")
        inv.setItem(13, ItemBuilder(Material.SKULL_ITEM).durability(3.toShort().toInt()).name("§aInformações Pessoais").lore("", "§fCargo: §8???", "§fCash: §8???", "", "§fCadastrado: ", "§fÚltimo acesso: §8XX/XX/2022").build())
        inv.setItem(28, ItemBuilder(Material.REDSTONE_COMPARATOR).name("§bPreferencias").lore("§7Clique para ver suas preferencias.").build())
        inv.setItem(30, ItemBuilder(Material.CHEST).name("§6Colecionáveis").lore("§7Clique para abrir!").build())
        inv.setItem(32, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("69b2889020583565f88d50537870c59aad802594fabd837e1d14f5a06ae34509"))).name("§3Idioma").lore("§7Clique para selecionar um idioma!").removeAttributes().build())
        inv.setItem(34, ItemBuilder(Material.ITEM_FRAME).name("§aSua skin").lore("§7Altere sua skin.").removeAttributes().build())
        p.openInventory(inv)
    }

    fun open2(p: Player) {
        val inv = Bukkit.createInventory(null, 45, "Manager")
        inv.setItem(13, ItemBuilder(Material.SKULL_ITEM).durability(3.toShort().toInt()).name("§aPersonal information").lore("", "§fRank: §8???", "§fCash: §8???", "", "§fRegistered: §8XX/XX/2022", "§fLast access: §8XX/XX/2022").build())
        inv.setItem(28, ItemBuilder(Material.REDSTONE_COMPARATOR).name("§bPreferences").lore("§7Click to see your preferences.").build())
        inv.setItem(30, ItemBuilder(Material.CHEST).name("§6Collectibles").lore("§7Click to open!").build())
        inv.setItem(32, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("69b2889020583565f88d50537870c59aad802594fabd837e1d14f5a06ae34509"))).name("§3Language").lore("§7Click to select a language!").removeAttributes().build())
        inv.setItem(34, ItemBuilder(Material.ITEM_FRAME).name("§aYour skin").lore("§7Change your skin.").removeAttributes().build())
        p.openInventory(inv)
    }
}