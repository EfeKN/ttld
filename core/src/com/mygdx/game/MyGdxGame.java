package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	
	SpriteBatch batch;
	Texture img;
	TextureRegion[] animationFramesWalk, animationFramesMelee;
	Animation<TextureRegion> animationWalk, animationMelee;
	float elapsedTime;
	int i;
	
	@Override
	public void create () {
		i =0;
		batch = new SpriteBatch();
		img = new Texture("Scarab.png");
		animationFramesWalk = new TextureRegion[4];
		animationFramesMelee = new TextureRegion[5];
		
		TextureRegion[][] tmpFrames = TextureRegion.split(img, 16, 16);
		loadFrames(tmpFrames);
		animationWalk = new Animation<TextureRegion>(1f/30f, animationFramesWalk);
		animationMelee = new Animation<TextureRegion>(1f/30f, animationFramesMelee);
		//animation = new Animation(1f/15f, animationFrames);
	}
	
	private void loadFrames(TextureRegion[][] tmpFrames) {
		animationFramesWalk[0] = tmpFrames[1][0];
		animationFramesWalk[1] = tmpFrames[1][1];
		animationFramesWalk[2] = tmpFrames[1][2];
		animationFramesWalk[3] = tmpFrames[1][3];
		
		animationFramesMelee[0] = tmpFrames[3][0];
		animationFramesMelee[1] = tmpFrames[3][1];
		animationFramesMelee[2] = tmpFrames[3][2];
		animationFramesMelee[3] = tmpFrames[3][3];
		animationFramesMelee[4] = tmpFrames[3][4];
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0.0f,0,0.0f,1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(animationWalk.getKeyFrame(elapsedTime, true),i++,0);
		batch.draw(animationMelee.getKeyFrame(elapsedTime, true),i++,16);
		batch.end();
		if(i>=600)
			i=0;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
