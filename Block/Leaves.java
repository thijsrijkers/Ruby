package com.mygdx.game.Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Leaves extends Block {
    public Leaves() {
        super(new Texture(Gdx.files.internal("blocks/leaves_big_oak.png")), Type.Leaves);
    }
}