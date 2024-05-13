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
	/**
	 * width, height are considered to be in simulation units
	 */
	
    private final int width;

    private final int height;

    /**
     * width, height expressed in simulation units
     */
    public BufferedImageRenderer(int width, int height)
    {
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
    	int[] arg = new int[4*width*height];
    	for (int i = 0 ; i < 4*width*height ; i++) {
    		arg[i] = 0xFF000000;
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
     * Draws a colored 2x2-pixels square (in UI coord) on bufferedImage at the spec. position (in simulation coord) 
     */
    private void drawPixel(BufferedImage bufferedImage, Point position, Color color)
    {
		int UIx = 2*position.getX();
		int UIy = 2*position.getY();
		bufferedImage.setRGB(UIx, UIy , color.asInteger());
		bufferedImage.setRGB(UIx+1, UIy , color.asInteger());
		bufferedImage.setRGB(UIx, UIy+1 , color.asInteger());
		bufferedImage.setRGB(UIx+1, UIy+1 , color.asInteger());

    }
}
