package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter; //default
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Block.Block;
import com.mygdx.game.Grid_Camera.CameraControl;
import com.mygdx.game.Grid_Camera.Grid;

public class game extends ApplicationAdapter {
    public final float field_of_view = 69;
    public final float camera_degrees_per_pixel = 0.1f;

    public PerspectiveCamera camera;
    public CameraControl camera_controller;
    public Environment environment;
    public Grid grid;

    @Override
    public void create()
    {
        camera = new PerspectiveCamera(field_of_view, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0, 10f, 10f);
        camera.update();

        grid = new Grid();

        camera_controller = new CameraControl(camera) {
            @Override
            public boolean touchDown(int X, int Y, int pointer, int button) {
                if (button == 0) {
                    grid.editGrid(camera.position, camera.direction, Block.Type.DirtBlock);
                } else if (button == 1) {
                    grid.editGrid(camera.position, camera.direction, null);
                }
                return super.touchDown(X, Y, pointer, button);
            }
        };
        camera_controller.setDegreesPerPixel(camera_degrees_per_pixel);
        camera_controller.setVelocity(15);
        Gdx.input.setInputProcessor(camera_controller);
        Gdx.input.setCursorCatched(true);

        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound/minecraftmusic.mp3"));
        music.setLooping(true);
        music.setVolume(0.2f);
        music.play();
    }

    public void render()
    {
        camera_controller.update();
        ModelBatch batch = new ModelBatch();

        Gdx.gl.glClearColor(1.5f, 0.8f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Block  block = new Block(new Texture(Gdx.files.internal("blocks/grass_top.jpg")), Block.Type.DirtBlock);
        block.setPosition(0, 0, 0);

        batch.begin(camera);
        grid.render(batch, environment);
        batch.render(block.getInstance(), environment);
        batch.end();
    }
}