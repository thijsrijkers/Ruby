package com.mygdx.game.Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Grass extends Block {
    public Grass() {
        super(new Texture(Gdx.files.internal("blocks/leaves.png")), Type.GrassBlock);
    }
}