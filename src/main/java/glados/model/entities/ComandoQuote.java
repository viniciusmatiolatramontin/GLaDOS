package glados.model.entities;

import glados.model.controller.QuoteController;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ComandoQuote extends ListenerAdapter {
	
    private QuoteController controller;
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getMessage().getContentRaw().equalsIgnoreCase("!quote")) {
			controller = new QuoteController();
			event.getChannel().sendMessage(controller.getQuote().getQuoteString()).queue();
		}
	}
}
