package com.mygdx.game.Grid_Camera;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;

public class CameraControl extends FirstPersonCameraController {
    public CameraControl(Camera camera) {
        super(camera);
    }

    @Override
    public boolean mouseMoved(int X, int Y) {
        touchDragged(X, Y, 0);
        return super.mouseMoved(X, Y);
    }
}
