package com.mygdx.game.Block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Stone extends Block {
    public Stone() {
        super(new Texture(Gdx.files.internal("blocks/Stone.png")), Type.Stone);
    }
}