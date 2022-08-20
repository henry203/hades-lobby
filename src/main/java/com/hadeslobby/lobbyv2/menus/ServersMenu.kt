package com.hadeslobby.lobbyv2.menus

import com.hadeslobby.lobbyv2.utils.ItemBuilder
import com.hadeslobby.lobbyv2.utils.SkullCreator
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object ServersMenu {
    fun open(player: Player) {
        val inventory = Bukkit.createInventory(player, 45, "Modos de Jogo")
        inventory.setItem(12, ItemBuilder(Material.NETHER_STAR).name("§aLobbies").lore(*arrayOf("§7Alterne entre os lobbies aqui!")).build())
        inventory.setItem(14, ItemBuilder(Material.DIAMOND).name("§bContribua com o servidor!").lore(*arrayOf("", "§7  Você pode ajudar o servidor", "§7  tornando-se §fVIP §7e adquirindo", "§7  pacotes de §fCash§7!", "", "§7  Além de ajudar a manter o servidor", "§7  online, você ainda terá acesso", "§7  a vários §fbenefícios§7!", "")).build())
        inventory.setItem(28, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("c670c653401f8b0a712f2777349f0293d2e967d82d2724128dada0653bd01958"))).name("§aFactions Volts").lore(*arrayOf("", "§7Convoque sua facção para o campo de", "§7batalha num mundo 5.000/5.000, onde", "§7ação e aventura não faltarão!", "", "§aClique para jogar.")).build())
        inventory.setItem(29, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("9631597dce4e4051e8d5a543641966ab54fbf25a0ed6047f11e6140d88bf48f"))).name("§aRankUP").lore(*arrayOf("", "§7Aventure-se num mundo repleto de trabalhos", "§7e obstáculos, participe de um clã para se tornar", "§7mais forte e junto deles conquistar o servidor!", "", "§cInacessível.")).build())
        inventory.setItem(30, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))).name("§c§kEm breve").lore(*arrayOf("§7Em breve um novo modo", "§7de jogo ocupará este slot.")).build())
        inventory.setItem(32, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))).name("§c§kEm breve").lore(*arrayOf("§7Em breve um novo modo", "§7de jogo ocupará este slot.")).build())
        inventory.setItem(33, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))).name("§c§kEm breve").lore(*arrayOf("§7Em breve um novo modo", "§7de jogo ocupará este slot.")).build())
        inventory.setItem(34, ItemBuilder(ItemStack(SkullCreator.itemFromUrl("3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))).name("§c§kEm breve").lore(*arrayOf("§7Em breve um novo modo", "§7de jogo ocupará este slot.")).build())
        player.openInventory(inventory)
    }
}