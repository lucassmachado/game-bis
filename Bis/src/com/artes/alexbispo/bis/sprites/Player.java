package com.artes.alexbispo.bis.sprites;

import static com.artes.alexbispo.bis.DeviceSettings.screenWidth;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGRect;

import com.artes.alexbispo.bis.Assets;
import com.artes.alexbispo.bis.scenes.ShootEngineDelegate;

public class Player extends CCSprite {
	
	private float positionX = screenWidth()/2;
	private float positionY = 50;
	private ShootEngineDelegate delegate;
	
	public Player() {
		super(Assets.NAVE);		
		setPosition(positionX, positionY);
	}
	
	public void setDelegate(ShootEngineDelegate delegate){
		this.delegate = delegate;
	}
}
