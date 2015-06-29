package io.github.Nick3306.Auction;

import java.util.ArrayList;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Auction
{
	ArrayList<String> bidders = new ArrayList<String>();
	Player seller;
	Player highestBidder;
	double highestBid;
	ItemStack items;
	
	Auction(Player seller, double startingBid, Player owner)
	{
		this.seller = seller;
		this.highestBid = startingBid;
		this.highestBidder = owner;
	}
	
	void setSeller(Player seller)
	{
		this.seller = seller;
	}
	void setHighestBid(double highestBid)
	{
		this.highestBid = highestBid;
	}
	void setHigesthBidder(Player highestBidder)
	{
		this.highestBidder = highestBidder;
	}
	Player getSeller()
	{
		return seller;
	}
	double getHighestBid()
	{
		return highestBid;
	}
	Player getHighestBidder()
	{
		return highestBidder;
	}
	ItemStack getItemStack()
	{
		return items;
	}
	void setItemStack(ItemStack items)
	{
		this.items = items;
	}
	
}
