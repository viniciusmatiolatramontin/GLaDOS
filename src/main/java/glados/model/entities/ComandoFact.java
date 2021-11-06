package glados.model.entities;

import glados.model.controller.FactController;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ComandoFact extends ListenerAdapter {
	
	private RandomFact fact;
	private FactController controller;
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getMessage().getContentRaw().equalsIgnoreCase("!fact")) {
			controller = new FactController();
			fact = controller.getFact();
			EmbedBuilder builder = new EmbedBuilder();
			builder.setFooter(fact.getSource_url());
			builder.setTitle(fact.getText());
			event.getChannel().sendMessageEmbeds(builder.build()).queue();
		}
	}
}
