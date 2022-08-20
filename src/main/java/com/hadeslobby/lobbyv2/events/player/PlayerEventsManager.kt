package com.hadeslobby.lobbyv2.events.player

import com.hadeslobby.lobbyv2.LobbyMain
import com.hadeslobby.lobbyv2.utils.TabManager
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scoreboard.DisplaySlot

class PlayerEventsManager : Listener {

    @EventHandler fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage = null
        val player:Player = event.player
        player.gameMode = GameMode.ADVENTURE
        player.foodLevel = 100
        player.maxHealth = 20.0
        player.health = 20.0
        player.level = 1200
        player.addPotionEffect(PotionEffect(PotionEffectType.WEAKNESS, 99999, 1))
        player.addPotionEffect(PotionEffect(PotionEffectType.BLINDNESS, 99999,1))


                TabManager.build(player, "\n§d§lHARPLY AUTENTICAR\n§f jogar.harply.com.br\n", " \n §fConheça o nosso site §eharply.com.br §fe nossa loja §eloja.harply.com.br\n§fAcesse nosso Discord utilizando §9/discord\n\n§7 Atualmente estamos com §d" + LobbyMain.getInstance()?.getTotalNetwork(player) + "§7 jogadores online.\n")


        player.sendMessage("\n §7Olá, §d" + player.name+ "§7 o servidor está indisponível no momento.\n §7saiba mais acessando: §ddiscord.harply.com.br")
        }
    }



@EventHandler fun onLeave(event: PlayerQuitEvent) {
    event.quitMessage = null
}