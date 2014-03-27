package com.artes.alexbispo.bis.scenes;

import static com.artes.alexbispo.bis.DeviceSettings.*;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;

import com.artes.alexbispo.bis.Assets;

public class GameButtons extends CCLayer implements ButtonDelegate {
	
	private Button leftControl;
	private Button rightControl;
	private Button shootButton;
	
	public static GameButtons gameButtons() {
		return new GameButtons();
	}
	
	public GameButtons() {
		//Habilita o toque na tela
		this.setIsTouchEnabled(true);
		
		// Cria os botões
		this.leftControl = new Button(Assets.LEFTCONTROL);
		this.rightControl = new Button(Assets.RIGHTCONTROL);
		this.shootButton = new Button(Assets.SHOOTBUTTON);
		
		// configura as delegações
		this.leftControl.setDelegate(this);
		this.rightControl.setDelegate(this);
		this.shootButton.setDelegate(this);
		
		// Configura posições
		setButtonsPosition();
		
		// Adiciona os botões na tela
		addChild(this.leftControl);
		addChild(this.rightControl);
		addChild(this.shootButton);
	}

	private void setButtonsPosition() {
		// Posição dos botões
		leftControl.setPosition(screenResolution(
									CGPoint.ccp(40, 40)));
		rightControl.setPosition(screenResolution(
				CGPoint.ccp(100, 40)));
		shootButton.setPosition(screenResolution(
				CGPoint.ccp(screenWidth() - 40, 40)));
		
	}

	@Override
	public void buttonClicked(Button sender) {
		if(sender.equals(this.leftControl)){
			System.out.println("Button clicked: Left!");
		}
		
		if(sender.equals(this.rightControl)){
			System.out.println("Button clicked: Right!");
		}
		
		if(sender.equals(this.shootButton)){
			System.out.println("Button cliked: Shooting!");
		}
		
	}

}
