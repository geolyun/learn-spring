package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {
	
	public static void main(String[] args) {
		
		// var game = new MarioGame();
		// var game = new SuperContraGame();
		
		var game = new PacmanGame(); // 1: 객체 생성
		
		var gameRunner = new GameRunner(game); 
		// 2: 객체 생성 + 의존성을 연결하는 역할
		// game is a Dependencies
		
		gameRunner.run();
	}

}
