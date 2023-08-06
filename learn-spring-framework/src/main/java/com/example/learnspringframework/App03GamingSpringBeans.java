package com.example.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContraGame;

public class App03GamingSpringBeans {
	
	public static void main(String[] args) {
		
		try(var context =
				new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
		
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
			
		}
	}
}

