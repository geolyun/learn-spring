package com.example.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContraGame;

@Configuration
@ComponentScan("com.example.learnspringframework.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context =
				new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
		
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
			
		}
	}
}

