package fr.niixoz.plugin.commands;

import fr.niixoz.plugin.permissions.PermissionEnum;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class TestCommand extends AbstractCommand {

    public TestCommand() {
        super("test", "Commande de Test", "/test", PermissionEnum.PERMISSION_ALL);
    }

    @Override
    public boolean executeCommand(Player player, Command command, String s, String[] args) throws Exception {
        return false;
    }
}
