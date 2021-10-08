package glados;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


import javax.security.auth.login.LoginException;

public class App {
    public static void main(String[] args) throws LoginException{
        JDABuilder builder = JDABuilder.createDefault("ODU4NzMzMzkwMzc4MTcyNDM2.YNibyg.PZeee_7FtRNgtF0VilSBr12FtcQ");
        
        builder.setActivity(Activity.playing("Portal 2"));
        builder.addEventListeners(new ComandoFact());
        
        builder.build();
    }

}

