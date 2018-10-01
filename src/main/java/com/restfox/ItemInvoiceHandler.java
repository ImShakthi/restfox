package com.restfox;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restfox.rest.data.model.Item;

@Path("items")
public class ItemInvoiceHandler {

	private static Map<Long, Item> itemMap = new HashMap<>();

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Item getItem(@PathParam("id") final long id) {
		System.out.println(itemMap);
		System.out.println(">>>> " + itemMap.get(id));
		return itemMap.get(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(MediaType.TEXT_PLAIN)
	public String addItem(final Item item) {
		System.out.println(item);
		item.updateGrossPrice();
		itemMap.put(item.getItemId(), item);
		return "Item added successfully.";
	}

	@GET
	@Path("/dummy")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Item addDummy() {
		Item item = new Item();
		item.setItemId(123);
		item.setName("dummy");
		return item;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Item[] getItems() {
		Item[] items = new Item[itemMap.size()];
		Set<Long> keys = itemMap.keySet();

		int index = 0;
		for (Long key : keys) {
			items[index] = itemMap.get(key);
			index++;
		}
		return items;
	}
}
