package com.example.mi_primer_juego;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;



public class MainActivity extends SimpleBaseGameActivity {

	private Camera mCamera;
	private static int WIDTH = 800;
	private static int HEIGHT= 480;
	Rectangle rectangulo;

	@Override
	public EngineOptions onCreateEngineOptions() {


		// Definimos nuestra camara
		mCamera = new Camera(0, 0, WIDTH, HEIGHT);
		// Ahora declaramos las opciones del motor 
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new FillResolutionPolicy(), mCamera);
		//EngineOptions(es full screen?, Cual es la orientacion de la pantalla?, Como actuaremos ante distintas resoluciones?, y la camara)
	
		
		// impedimos que la pantalla se apague por inactividad		
		engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		// Return the engineOptions object, passing it to the engine
		return engineOptions;
		
		
		
	}

	@Override
	protected void onCreateResources()  {

		/* La creacion de recursos como sprite, sonidos y textos no son 
		 * relevantes en este ejemplo y las trataremos despues, ahora vamos a trabajar con
		 * recursos que no debemos cargar*/		
		
		rectangulo = new Rectangle(mCamera.getWidth()/2, mCamera.getHeight()/2, 100, 100, getVertexBufferObjectManager());
		//RGB cada valor contiene 256 colores, pero aqui se manejan como flotantes de 0.0 a 1.0
		rectangulo.setColor(0.3f, 0.5f, 0.2f);
		
		
	}

	@Override
	protected Scene onCreateScene() {

		Scene sceneEjemplo = new Scene();
		
		//Añadimos el rectangulo a la escene
		sceneEjemplo.attachChild(rectangulo);
		
		
		return sceneEjemplo;
	}




}