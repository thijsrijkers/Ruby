package com.mygdx.game.Block;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BoxShapeBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Disposable;

public class Block implements Disposable
{
    private static ModelBuilder modelBuilder = new ModelBuilder();
    private Material material;
    private Model model;
    private ModelInstance instance;
    private Type type;

    public Block(Texture texture, Type type)
    {
        this.type = type;
        material = new Material(TextureAttribute.createDiffuse(texture));
        modelBuilder.begin();
        modelBuilder.node();
        MeshPartBuilder mesh_part_builder = modelBuilder.part("box", GL20.GL_TRIANGLES, VertexAttributes.Usage.Position
                | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates, material);
        BoxShapeBuilder.build(mesh_part_builder, 5, 5, 5);
        model = modelBuilder.end();

        instance = new ModelInstance(model);
    }

    public void setPosition(float x, float y, float z){
        instance.transform = new Matrix4().translate(x, y, z);
    }

    public ModelInstance getInstance() {
        return instance;
    }

    public void dispose()
    {
        model.dispose();
    }

    public enum Type
    {
        DirtBlock,
        Cloud,
        Leaves,
        Oak,
        Stone,
        GrassBlock;
    }
}
