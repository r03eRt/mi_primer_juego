package com.example.mi_primer_juego;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;



public class MainActivity extends SimpleBaseGameActivity {

	private Camera mCamera;
	private static int WIDTH = 800;
	private static int HEIGHT= 480;
	Rectangle rectangulo;
	private BitmapTextureAtlas miAtlas;
	private ITextureRegion personaje;
	private Sprite charSprite;
	
	private ITiledTextureRegion texturaAnimada;
	private AnimatedSprite spriteAnimado;
	

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
		
		//Indicamos donde se encuentran las imagenes
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("sprites/");
		//creamos el atlas,darle medidas y tipo de textura
		miAtlas=new BitmapTextureAtlas(getTextureManager(), 800, 800, TextureOptions.DEFAULT);
		//Ubicamos nuestra imagen en nuestro sheet(atlas)
		personaje=BitmapTextureAtlasTextureRegionFactory.createFromAsset(miAtlas, this, "player.png",0,0);
		texturaAnimada=BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(miAtlas, this, "animado.png", 66, 0,10,10);
		
		
		//lo cargamos
		miAtlas.load();
		
		//hemos creado 70x70 para meter una imagen de 47x66,comenzando en el punto 0,0
		
		
		
		
	}

	@Override
	protected Scene onCreateScene() {

		Scene sceneEjemplo = new Scene();

		//posicion x,posicion y ,textura y elemento andengine
		charSprite= new Sprite(0, 200, personaje, getVertexBufferObjectManager());
		sceneEjemplo.attachChild(charSprite);
		
		spriteAnimado=new AnimatedSprite(200, 200, texturaAnimada, getVertexBufferObjectManager());
		long[] duracionFrame={200,200,200,200,200,200};
		spriteAnimado.animate(duracionFrame,1,6,true);
		
		sceneEjemplo.attachChild(spriteAnimado);
		
		
		
		
		
		return sceneEjemplo;
	}




}