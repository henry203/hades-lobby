package com.hadeslobby.lobbyv2

import com.google.common.io.ByteStreams
import com.hadeslobby.lobbyv2.events.player.PlayerEventsManager
import com.hadeslobby.lobbyv2.events.player.ServerManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import java.util.logging.Logger


/**
 * Plugin de lobby V2 da HadesLobbyV1
 * é continuação do plugin antigo.
 */

class LobbyMain() : JavaPlugin(), Plugin{

    private var totalNetworkPlayers = 0

    companion object {
        private var instance: LobbyMain? = null

        fun getInstance(): LobbyMain? {
            return instance
        }
    }

    override fun onLoad() {

        Bukkit.getConsoleSender().sendMessage("§c[HarplyCore] [HadesLobbyV2] §fconnecting to api api.harply.com.br")
     /// checker to api recuse
        Bukkit.getConsoleSender().sendMessage("§c[HarplyCore] [HadesLobbyV2] §cconnecting failed api recuse.")
        super.onLoad()
    }

    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("§6[HadesLobbyV2] §fInicializando...")
        Bukkit.getConsoleSender().sendMessage("§e[HadesLobbyV2] §fCarregando o plugin [1/4]")

        Bukkit.getConsoleSender().sendMessage("§e[HadesLobbyV2] §fConfigurando os mundos [2/4]")

        this.server.worlds.forEach(action = { world ->
            world.setGameRuleValue("randomTickSpeed", "-999")
            world.setGameRuleValue("doFireTick", "false")
            world.setGameRuleValue("doDaylightCycle", "false")
            world.setGameRuleValue("doMobSpawning", "false")
            world.time = 1200
        })
            Bukkit.getConsoleSender().sendMessage("§e[HadesLobbyV2] §fMundos configurados! [3/5]")
            this.loadEvents()

        Bukkit.getConsoleSender().sendMessage("§e[HadesLobbyV2] §fPlugin inicializado com sucesso! [5/5]")
    }

    private fun loadEvents() {
        object : BukkitRunnable() {
            override fun run() {
                Bukkit.getPluginManager().registerEvents(ServerManager(), this@LobbyMain)
                Bukkit.getPluginManager().registerEvents(PlayerEventsManager(), this@LobbyMain)
                Bukkit.getConsoleSender().sendMessage("§e[HadesLobbyV2] §feventos carregados com sucesso!")

            }
        }.runTask(this)
    }

    fun getTotalNetwork(p: Player): Int {
        val out = ByteStreams.newDataOutput()
        out.writeUTF("PlayerCount")
        out.writeUTF("ALL")
        p.sendPluginMessage(instance, "BungeeCord", out.toByteArray())
        return totalNetworkPlayers
    }
}
