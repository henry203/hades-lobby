package com.hadeslobby.lobbyv2.events.player

import com.hadeslobby.lobbyv2.LobbyMain
import com.hadeslobby.lobbyv2.hotbar.HotbarManager
import com.hadeslobby.lobbyv2.menus.LobbiesMenu
import com.hadeslobby.lobbyv2.menus.ProfileMenu
import com.hadeslobby.lobbyv2.menus.ServersMenu
import com.hadeslobby.lobbyv2.utils.ItemBuilder
import com.hadeslobby.lobbyv2.utils.SkullCreator
import com.hadeslobby.lobbyv2.utils.TabManager
import com.nickuc.login.api.event.bukkit.auth.AuthenticateEvent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockBurnEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.FoodLevelChangeEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.weather.WeatherChangeEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class ServerManager : Listener{

    @EventHandler fun onFood(event: FoodLevelChangeEvent) {
        event.foodLevel = 100
        event.isCancelled = true
    }

    @EventHandler fun onBreakBlock(event: BlockBreakEvent) {
        val player:Player = event.player
        event.isCancelled = true
        player.sendMessage("§cVocê não pode quebrar bloco deste local.")

        if(player.hasPermission("block.break")) {
            event.isCancelled = false
        }
    }

    @EventHandler fun playerInteract(event: PlayerInteractEvent) {
        val player: Player = event.player
        val item: ItemStack = event.item
        if (item.type != Material.AIR) {
            if (item.hasItemMeta()) {
                if (item.itemMeta.displayName.equals("§aJogadores visíveis")) {
                    event.isCancelled = true
                    player.inventory.setItem(1, (ItemBuilder(ItemStack(SkullCreator.itemFromUrl("2a17e97037ce353f85f5c65df435d29449a88da4442e4361cf99abbe1f892fb")))).name("§aJogadores invisíveis").build());
                    player.sendMessage("§cAgora os jogadores estão invisíveis.");
                } else if (item.itemMeta.displayName.equals("§aVisible players")) {
                    event.isCancelled = true
                    player.inventory.setItem(1, (ItemBuilder(ItemStack(SkullCreator.itemFromUrl("2a17e97037ce353f85f5c65df435d29449a88da4442e4361cf99abbe1f892fb")))).name("§cInvisible players").build());
                    player.sendMessage("§cNow players are invisible.")
                } else if (item.itemMeta.displayName.equals("§eGerenciador")) {
                    event.isCancelled = true
                    ProfileMenu.open(player)
                } else if (item.itemMeta.displayName.equals("§eEscolha o servidor")) {
                    event.isCancelled = true
                    ServersMenu.open(player)
                } else if (item.itemMeta.displayName.equals("§eLobbies")) {
                    event.isCancelled = true
                    LobbiesMenu.open(player)

                }
            }
        }
    }

    @EventHandler fun onInteract(event: InventoryClickEvent) {
        if (event.whoClicked is Player) {
            val player: Player = event.whoClicked as Player
            if (event.clickedInventory == null) {
                return
            }

            if (!player.hasPermission("lobby.admin")) {
                event.isCancelled = true
            }

            if (event.clickedInventory.title.equals("Modos de Jogo")) {
                event.isCancelled = true
                when (event.rawSlot) {
                    12 -> player.closeInventory()
                }
                if(event.clickedInventory.title.equals("Lobbies")) {
                    event.isCancelled = true
                    when (event.rawSlot) {
                        12 -> player.closeInventory()
                    }
                }
                if (event.clickedInventory.title.equals("Gerenciador"))
                    event.isCancelled = true
                when (event.rawSlot) {
                    12 -> player.closeInventory()
                }

            }
        }
    }

    @EventHandler fun onBlockPlace(event: BlockPlaceEvent) {
        val player: Player = event.player
        event.isCancelled = true

        if(player.hasPermission("block.place")) {
            event.isCancelled = false
        }
    }

    @EventHandler fun onWeather(event: WeatherChangeEvent) {
        event.isCancelled = true
    }

    @EventHandler fun onBlockBrun(event: BlockBurnEvent) {
        event.isCancelled = true
    }

    @EventHandler fun authenticate(event: AuthenticateEvent) {
        val player:Player = event.player
        HotbarManager.removeItens(player)

        if(player.hasPermission("fly.usar")) {
            if (player.allowFlight) {
                player.allowFlight = true
            }
        }

        if(player.hasPermission("broadcast.join")) {
            Bukkit.getOnlinePlayers().forEach(action = { p ->
                p.sendMessage("§8[§7!§8] " + player.name + " §6entrou neste lobby!")
            })

            if(player.hasPermission("admin.perm")) {
                HotbarManager.giveItens(player)
                player.removePotionEffect(PotionEffectType.WEAKNESS)
                player.removePotionEffect(PotionEffectType.BLINDNESS)
                HotbarManager.giveItens(player)
            } else {
                player.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 99999, 1))
                player.addPotionEffect(PotionEffect(PotionEffectType.BLINDNESS, 99999,1))

                TabManager.build(player, "\n§d§lHARPLY HUB\n§f jogar.harply.com.br\n", " \n §fConheça o nosso site §eharply.com.br §fe nossa loja §eloja.harply.com.br\n§fAcesse nosso Discord utilizando §9/discord\n \n§7 Atualmente estamos com §d" + LobbyMain.getInstance()?.getTotalNetwork(player)+ "§7 jogadores online.\n")
                HotbarManager.temporaryItens(player)
            }

        }
    }
}