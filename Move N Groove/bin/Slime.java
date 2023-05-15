package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Slime {
    public float x, y;
    public float saveX, saveY;
    public float size;
    public int type;
    public BufferedImage img;
    public BufferedImage[] imgs;

    public float w, h;
    public boolean flipX;
    public float speed = 3;
    public boolean removeFlag;

    public int animationIndex = 0;
    private int animationFrameLength = 5;
    public int currentAnimationFrame = 0;

    public Slime(float x, float y, float size, int type) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.type = type;

        imgs = type == Constants.GREEN_SLIME ? BufferedImages.greenSlimeImgs : BufferedImages.orangeSlimeImgs;
        updateImage(imgs[0]);
    }

    public void display(Graphics g) {
        if (flipX){
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-img.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            img = op.filter(img, null);
        }
        g.drawImage(img, (int)(x - w/2), (int)(y - h/2), (int)w, (int)h, null);
        //g.drawOval((int) (x-w/2), (int) (y-h/2), (int)w, (int)h);
    }

 
    
    
    
    
    
    
    
    
    
    
    
    public void move(){
        float distance = Constants.WIDTH/2 - x;
        float direction = Math.signum(distance);
        x += direction * speed;
    }

    public void animate(){
        currentAnimationFrame++;
        if (currentAnimationFrame >= imgs.length * animationFrameLength){
            currentAnimationFrame = 0;
        }
        updateImage(imgs[currentAnimationFrame / animationFrameLength]);
    }

    public void savePosition(){
        saveX = x;
        saveY = y;
    }
    public void loadPosition(){
        x = saveX;
        y = saveY;
    }

    public void updateImage(BufferedImage img) {
        this.img = img;
        w = img.getWidth() * size;
        h = img.getHeight() * size;
    }
}
