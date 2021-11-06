package glados;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.security.auth.login.LoginException;

import glados.model.entities.ComandoFact;
import glados.model.entities.ComandoQuote;

public class App {
    public static void main(String[] args) throws LoginException{
    	String token = "";
    	
    	try(BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\token.txt"))) {
    		token = br.readLine();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
        JDABuilder builder = JDABuilder.createDefault(token);
        
        builder.setActivity(Activity.playing("Portal 2"));
        builder.addEventListeners(new ComandoFact());
        builder.addEventListeners(new ComandoQuote());
        
        builder.build();
    }

}

