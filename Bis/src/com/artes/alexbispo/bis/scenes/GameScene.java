package com.artes.alexbispo.bis.scenes;

import static com.artes.alexbispo.bis.DeviceSettings.screenHeight;
import static com.artes.alexbispo.bis.DeviceSettings.screenResolution;
import static com.artes.alexbispo.bis.DeviceSettings.screenWidth;

import java.util.ArrayList;
import java.util.List;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;

import com.artes.alexbispo.bis.Assets;
import com.artes.alexbispo.bis.sprites.Meteor;
import com.artes.alexbispo.bis.sprites.Player;
import com.artes.alexbispo.bis.sprites.ScreenBackground;

public class GameScene extends CCLayer implements MeteorsEngineDelegate {
	
	private ScreenBackground background;
	private MeteorsEngine meteorsEngine;
	private CCLayer playerLayer;
	private CCLayer meteorsLayer;
	private List meteorsArray;
	private Player player;
	private GameButtons controlsLayers;
	
	private GameScene(){
		this.background = new ScreenBackground(Assets.BACKGROUND);
		this.background.setPosition(
				screenResolution(
				CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
		this.addChild(this.background);
		
		// adicionando a camada do player
		this.playerLayer = CCLayer.node();
		this.addChild(this.playerLayer);
		
		// adicionando a camada dos meteoros
		this.meteorsLayer = CCLayer.node();
		this.addChild(this.meteorsLayer);
		
		// adicionando a camada dos controles
		this.controlsLayers = new GameButtons();
		this.addChild(this.controlsLayers);
		
		this.addGameObjects();
	}
	
	public static CCScene createGame() {
		CCScene scene = CCScene.node();
		GameScene layer = new GameScene();
		scene.addChild(layer);
		return scene;
	}

	@Override
	public void createMeteor(Meteor meteor) {
		this.meteorsLayer.addChild(meteor);
		meteor.start();
		this.meteorsArray.add(meteor);
		
	}
	
	public void addGameObjects() {
		this.player = new Player();
		this.playerLayer.addChild(this.player);
		
		this.meteorsArray = new ArrayList();
		this.meteorsEngine = new MeteorsEngine();
		
	}
	
	@Override
	public void onEnter() {	
		super.onEnter();
		this.startEngines();
	}

	private void startEngines() {
		this.addChild(this.meteorsEngine);
		this.meteorsEngine.setDelegate(this);
		
	}
}
