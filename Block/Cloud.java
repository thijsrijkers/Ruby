package com.mygdx.game.Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Cloud extends Block {
    public Cloud() {
        super(new Texture(Gdx.files.internal("GUI/cloud.png")), Type.Cloud);
    }
}