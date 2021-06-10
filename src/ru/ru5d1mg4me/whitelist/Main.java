package ru.ru5d1mg4me.whitelist;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerLoginEvent event) {
        for(OfflinePlayer offlineplayer : Bukkit.getServer().getWhitelistedPlayers()) {
            if(offlineplayer.getName().equals(event.getPlayer().getName())) {
                event.allow();
            }
        }
    }
}