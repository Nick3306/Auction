package io.github.Nick3306.Auction;

import java.text.NumberFormat;
import java.text.ParsePosition;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		
		if (command.getName().equalsIgnoreCase("auction"))
		{
			Player player = Bukkit.getPlayerExact(sender.getName());
			if(args.length > 4)
			{
				sender.sendMessage("Too many arguments!");
			}
			if(args.length < 1)
			{
				sender.sendMessage("Too few arguments!");
			}
			if(args[0].equalsIgnoreCase("sell"))
			{
				if(args.length == 4)
				{
					if(Material.getMaterial(args[1])!=null)
					{
						if(player.getInventory().contains(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
						{
							if(isNumeric(args[3]))
							{
								
							}
							else
							{
								sender.sendMessage("Your starting bid is not a valid number!");
							}
						}
						else
						{
							sender.sendMessage("You do not have eough of that Item!");
						}
					}
					else
					{
						sender.sendMessage("That is not a valid block!");
					}
				}
				else
				{
					sender.sendMessage("Too few arguments for sell!");
					sender.sendMessage("Usage: /auction sell (blockID)(ammount)(starting bid)");
				}
				
			}
		
		return false;
	}
	public static boolean isNumeric(String str)
	{
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
	
}
