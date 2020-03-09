package com.mygdx.game.Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Dirt extends Block {
    public Dirt() {
        super(new Texture(Gdx.files.internal("blocks/grass_top.jpg")), Type.DirtBlock);
    }
}