package simpleui;

import java.awt.image.BufferedImage;

import util.Color;
import util.Point;

/**
 * LEGIT
 * 
 * A helper class for drawing on a BufferedImage but using sim coordinates. See renderCreature.
 */
public class BufferedImageRenderer
{
	private final int fac;
	
    private final int width;

    private final int height;

    /**
     * width, height expressed in simulation units
     */
    public BufferedImageRenderer(int width, int height, int fac)
    {
    	this.fac = fac;    	
        if ( width <= 0 )
        {
            throw new IllegalArgumentException("Invalid width");
        }
        if ( height <= 0 )
        {
            throw new IllegalArgumentException("Invalid height");
        }

        this.width = width;
        this.height = height;
    }

    public int getWidth() { return this.width; }

    public int getHeight() { return this.height; }

    public boolean isValidPosition(Point position)
    {
        if ( position == null )
        {
            throw new IllegalArgumentException("position cannot be null");
        }

        return 0 <= position.getX() &&
                position.getX() < this.getWidth() &&
                0 <= position.getY() &&
                position.getY() < this.getHeight();
    }

    public void clearPixels(BufferedImage bufferedImage)
    {
    	int[] arg = new int[this.fac * this.fac * width * height];
    	for (int i = 0 ; i < this.fac * this.fac *width * height ; i++) {
    		int val = 120;
    		arg[i] = (new Color(val,val,val)).asInteger();
    	}
    	bufferedImage.setRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), arg, 0, bufferedImage.getWidth());
    }
    
    /**
     * Draws a creature on bufferedImage at the spec. position (in simulation coord) 
     */
    public void renderCreature(BufferedImage bufferedImage, Point position, Color color)
    {
        this.drawPixel(bufferedImage, position, color);
    }

    /**
     * Draws a colored fac x fac  -pixels square (in UI coord) on bufferedImage at the spec. position (in simulation coord) 
     */
    private void drawPixel(BufferedImage bufferedImage, Point position, Color color)
    {
		int UIx = this.fac * position.getX();
		int UIy = this.fac * position.getY();
		int c = color.asInteger();
		for (int i = 0; i< fac ; i++) {
			for (int j = 0; j < fac ; j++) {
				bufferedImage.setRGB(UIx + i , UIy + j , c);
			}
		}
//		bufferedImage.setRGB(UIx, UIy , color.asInteger());
//		bufferedImage.setRGB(UIx+1, UIy , color.asInteger());
//		bufferedImage.setRGB(UIx, UIy+1 , color.asInteger());
//		bufferedImage.setRGB(UIx+1, UIy+1 , color.asInteger());
    }
}
