package io.github.Nick3306.Auction;

import io.github.Nick3306.Auction.Main;
import java.text.NumberFormat;
import java.text.ParsePosition;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.api.Economy;


public class AuctionCommand implements CommandExecutor
{

	private Main plugin;
	public void Auction(Main plugin)
	 {
	   this.plugin = plugin;
	 }
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
								if((Integer.parseInt(args[1]) >=256 && Integer.parseInt(args[1]) <=258) || (Integer.parseInt(args[1]) >= 267 && Integer.parseInt(args[1]) <= 279) || (Integer.parseInt(args[1]) >= 283 && Integer.parseInt(args[1]) <= 286) || (Integer.parseInt(args[1]) >= 290 && Integer.parseInt(args[1]) <= 294) || (Integer.parseInt(args[1]) >= 298 && Integer.parseInt(args[1]) <= 317))
								{
									sender.sendMessage("Armor and tools are not able to be auctioned yet");
								}
								else
								{
									ItemStack items  = player.getItemInHand();
									player.setItemInHand(null);
									Auction a = new Auction(player, Double.parseDouble(args[3]), items);
									this.plugin.auctions.add(a);
									sender.sendMessage("Your items have been put up for auction");
								}
							}
							else
							{
								sender.sendMessage("Your starting bid is not a valid number!");
								return false;
							}
						}}
						else
						{
							sender.sendMessage("You do not have eough of that Item!");
							return false;
						}
					}
					else
					{
						sender.sendMessage("That is not a valid block!");
						return false;
					}
				}
				else
				{
					sender.sendMessage("Too few arguments for sell!");
					sender.sendMessage("Usage: /auction sell (blockID)(ammount)(starting bid)");
					return false;
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
