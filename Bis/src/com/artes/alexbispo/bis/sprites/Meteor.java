package com.artes.alexbispo.bis.sprites;

import static com.artes.alexbispo.bis.DeviceSettings.screenHeight;
import static com.artes.alexbispo.bis.DeviceSettings.screenResolution;
import static com.artes.alexbispo.bis.DeviceSettings.screenWidth;

import java.util.Random;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class Meteor extends CCSprite {
	private float x, y;
	
	public Meteor(String image){
		super(image);
		x = new Random().nextInt(Math.round(screenWidth()));
		y = screenHeight();
	}

	public void start() {
		this.schedule("update");
		
	}
	
	public void update(float dt) {
		y -= 1;
		this.setPosition(screenResolution(CGPoint.ccp(x, y)));
	}

}
