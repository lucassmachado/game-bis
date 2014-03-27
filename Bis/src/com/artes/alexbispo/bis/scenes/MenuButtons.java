package com.artes.alexbispo.bis.scenes;

import static com.artes.alexbispo.bis.DeviceSettings.screenHeight;
import static com.artes.alexbispo.bis.DeviceSettings.screenResolution;
import static com.artes.alexbispo.bis.DeviceSettings.screenWidth;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import com.artes.alexbispo.bis.Assets;

public class MenuButtons extends CCLayer implements ButtonDelegate {
	
	private Button playButton;
	private Button highscoredButton;
	private Button helpButton;
	private Button soundButton;
	
	public MenuButtons() {
		this.setIsTouchEnabled(true);
		
		this.playButton = new Button(Assets.PLAY);
		this.highscoredButton = new Button(Assets.HIGHSCORE);
		this.helpButton = new Button(Assets.HELP);
		this.soundButton = new Button(Assets.SOUND);
		
		this.playButton.setDelegate(this);
		this.highscoredButton.setDelegate(this);
		this.helpButton.setDelegate(this);
		this.soundButton.setDelegate(this);
		
		
		//coloca bot�es na posi��o correta
		setButtonspPosition();
		
		addChild(playButton);
		addChild(highscoredButton);
		addChild(helpButton);
		addChild(soundButton);
	}
	
	private void setButtonspPosition() {
		// Buttons Positions
		playButton.setPosition(screenResolution(CGPoint.ccp(
				screenWidth() / 2, screenHeight() - 250)));
		
		highscoredButton.setPosition(screenResolution(CGPoint.ccp(
				screenWidth() / 2, screenHeight() - 300)));
		
		helpButton.setPosition(screenResolution(CGPoint.ccp(
				screenWidth() / 2, screenHeight() - 350)));
		
		soundButton.setPosition(screenResolution(CGPoint.ccp(
				screenWidth() / 2 - 100, screenHeight() - 420)));
	}

	@Override
	public void buttonClicked(Button sender) {
		if(sender.equals(this.playButton)) {
			System.out.println("Button clicked: Play");
			CCDirector.sharedDirector().replaceScene(
					CCFadeTransition.transition(1.0f,
							GameScene.createGame()));
		}
		
		if(sender.equals(this.highscoredButton)) {
			System.out.println("Button clicked: Highscore");
		}
		
		if(sender.equals(this.helpButton)) {
			System.out.println("Button clicked: Help");
		}
		
		if(sender.equals(this.soundButton)) {
			System.out.println("Button clicked: Sound");
		}
		
	}
	
}
