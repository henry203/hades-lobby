package com.hadeslobby.lobbyv2.hotbar

import com.hadeslobby.lobbyv2.utils.ItemBuilder
import com.hadeslobby.lobbyv2.utils.SkullCreator
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.inventory.ItemStack

object HotbarManager {
    fun giveItens(player: Player) {
        player.inventory.setItem(4, ItemBuilder(Material.COMPASS).name("§eEscolha o servidor").lore(*arrayOf("§7(Escolha um de nossos modos de jogo através daqui)")).build())
        player.inventory.setItem(2, ItemBuilder(Material.WOOD_SWORD).name("§eEntrar no modo pvp").lore(*arrayOf("§7(Batalhe com outros jogadores através daqui)")).removeAttributes().build())
        player.inventory.setItem(6, ItemBuilder(Material.REDSTONE_COMPARATOR).name("§eGerenciador").lore(*arrayOf("§7(Clique aqui para gerenciar)")).build())
        player.inventory.setItem(7, ItemBuilder(Material.NETHER_STAR).name("§eLobbies").lore("§7(Clique aqui para selecionar um lobby!)").removeAttributes().build())
        player.inventory.setItem(1, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("e9e4bdcf172d5dc77c2bd4e37ad985399a9f2cdebf72463929ea4b666ef6f80"))).name("§aJogadores visíveis").build())
    }

    fun temporaryItens(player: Player) {
        player.inventory.setItem(4, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("cd91f51266eddc6207f12ae8d7a49c5db0415ada04dab92bb7686afdb17f4d4e"))).name("§9Discord").lore("§7Acesse nosso Discord para novidades.").removeAttributes().build())
    }

    fun removeItens(player: Player) {
        player.inventory.clear()
    }
}