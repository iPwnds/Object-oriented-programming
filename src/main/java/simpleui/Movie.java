package simpleui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import sim.Simulation;
import util.Chronometer;
import util.FrameRateTimer;

@SuppressWarnings("serial")
/**
 * LEGIT
 */
public class Movie extends JComponent {
	
    public final static int NANOSECONDS_PER_MILLISECOND = 1000000;

    /**
     * bfiRenderer is an aux object drawing 2x2-pixel squares on bufferedImage
     * bfiRenderer uses the same scale than world
     */
    private final BufferedImage bufferedImage;
    private final BufferedImageRenderer bfiRenderer;

    private final FrameRateTimer timer;

    private final Chronometer chronometer;
    
    private final Simulation sim;
    
    private final int fac; //1 simulation pixel = fac actual pixels

    /**
     * movieWidth, movieHeight are considered to be in simulation units.

     */
    public Movie(int targetFrameRate, Simulation sim, int fac)
    {
    	
    	this.fac = fac;
    	if (sim == null) { throw new IllegalArgumentException(); }
    	if (targetFrameRate <= 0) { throw new IllegalArgumentException(); }
    	
    	int movieWidth = sim.getWorld().getWidth();
    	int movieHeight = sim.getWorld().getHeight();
    	
        this.bufferedImage = new BufferedImage(this.fac * movieWidth, this.fac * movieHeight, BufferedImage.TYPE_INT_ARGB);
        this.bfiRenderer = new BufferedImageRenderer(movieWidth, movieHeight, this.fac);
        this.chronometer = new Chronometer();
        this.timer = new FrameRateTimer(targetFrameRate);
        this.sim = sim;
    }
    
    /**
     * LEGIT
     */
    public Simulation getSim() {
    	return sim;
    }

    public int getTargetFramesPerSecond()
    {
        return this.timer.getTargetFrameRate();
    }

    public void setTargetFrameRate(int targetFrameRate)
    {
        this.timer.setTargetFrameRate(targetFrameRate);
    }
    
    
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(this.bufferedImage.getWidth(), this.bufferedImage.getHeight());
    }

    @Override
    /**
     * the last `repaint()` call ends up calling the present method recursively
     */
    public void paintComponent(Graphics g)
    {
        var elapsedNanoseconds = this.chronometer.elapsedNanoseconds();

        var elapsedSinceLastUpdate = timer.update(elapsedNanoseconds);
        if ( elapsedSinceLastUpdate.isPresent() )
        {
           
            sim.getWorld().step();
            renderEntities();

        }
        else
        {
            try
            {
                Thread.sleep(1);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

        g.drawImage(this.bufferedImage, 0, 0, null);
        repaint();
    }
    
    /**
     * Draws entities on bufferedImage
     */
    private void renderEntities() {
    	this.bfiRenderer.clearPixels(bufferedImage);
    	sim.getWorld().giveEntityStream().forEach(entity ->
    	this.bfiRenderer.renderCreature(bufferedImage, entity.getPosition(), entity.getColor()));
    }
}
