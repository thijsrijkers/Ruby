package com.mygdx.game.Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Oak extends Block {
    public Oak() {
        super(new Texture(Gdx.files.internal("blocks/log_big_oak.png")), Type.Oak);
    }
}