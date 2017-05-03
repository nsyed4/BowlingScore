package com.noor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@Profile("!test")
public class BowlingScoreApplication implements CommandLineRunner {

    @Autowired
    private Game game;
    
	public static void main(String[] args) {
		SpringApplication.run(BowlingScoreApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
	    game.play();
	}
}
