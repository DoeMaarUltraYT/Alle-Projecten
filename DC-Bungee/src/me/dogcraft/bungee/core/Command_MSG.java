package me.dogcraft.bungee.core;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by gebruiker on 28-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Bungee
 * Package: me.dogcraft.bungee.core
 */
public class Command_MSG extends Command {
    public Plugin pl;
    public Command_MSG(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) commandSender;

        }
    }
}
