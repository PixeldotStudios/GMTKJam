/*
    MIT License

    Copyright (c) 2017 James Bulman

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
*/
package com.pixeldot.firewall.Level.Blocks;

import com.cluster.engine.Physics.Shapes.Polygon;
import com.cluster.engine.Utilities.Interfaces.EntityRenderable;
import com.pixeldot.firewall.Level.BlockType;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Shape;
import org.jsfml.system.Vector2f;

public abstract class Block implements EntityRenderable {

    protected Vector2f position;
    protected Vector2f size;
    protected Polygon shape;

    public Block(Vector2f position, Vector2f size) {
        this.position = position;
        this.size = size;

        float hw = size.x / 2f;
        float hh = size.y  / 2f;
        Vector2f[] vertices = {
                new Vector2f(-hw, -hh), new Vector2f(hw, -hh),
                new Vector2f(hw, hh), new Vector2f(-hw, hh)
        };

        shape = new Polygon(vertices);
    }

    public void render(RenderWindow renderer) {
        Shape s = (Shape) shape.getDrawable();
        s.setPosition(position.x + size.x / 2f, position.y + size.y / 2f);

        renderer.draw(s);
    }

    public abstract BlockType getType();

    public Vector2f getPosition() { return position; }
    public Vector2f getSize() { return size; }
    public Polygon getShape() { return shape; }
}
