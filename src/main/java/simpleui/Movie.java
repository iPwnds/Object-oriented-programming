package simpleui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import sim1.CreatureA;
import sim1.CreatureB;
import sim1.Simulation;
import util.Chronometer;
import util.Color;
import util.FrameRateTimer;
import util.Point;

@SuppressWarnings("serial")
public class Movie extends JComponent 
{
    public final static int NANOSECONDS_PER_MILLISECOND = 1000000;
    /**
     * bfiRenderer is an aux object drawing 2x2-pixel squares on bufferedImage
     * bfiRenderer uses the same scale than world
     * @invar | bfiRenderer.getWidth() * 2 == bufferedImage.getWidth()
     * @invar | bfiRenderer.getHeight() * 2 == bufferedImage.getHeight()
     * @invar | bfiRenderer.getWidth() == sim.getWorld().getWidth() && bfiRenderer.getHeight() == sim.getWorld().getHeight()
     */
    private final BufferedImage bufferedImage;
    private final BufferedImageRenderer bfiRenderer;
    private final FrameRateTimer timer;
    private final Chronometer chronometer;
    private final Simulation sim;

    
    /**
     * LEGIT
     * 
     * movieWidth, movieHeight are considered to be in simulation units.

     */
    public Movie(int targetFrameRate, Simulation sim)
    {
    	
    	if (sim == null) { throw new IllegalArgumentException(); }
    	if (targetFrameRate <= 0) { throw new IllegalArgumentException(); }
    	
    	int movieWidth = sim.getWorld().getWidth();
    	int movieHeight = sim.getWorld().getHeight();
    	
        this.bufferedImage = new BufferedImage(2 * movieWidth, 2 * movieHeight, BufferedImage.TYPE_INT_ARGB);
        this.bfiRenderer = new BufferedImageRenderer(movieWidth, movieHeight);
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
    /**
     * LEGIT
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(this.bufferedImage.getWidth(), this.bufferedImage.getHeight());
    }

    @Override
    /**
     * 
     * The last `repaint()` call ends up calling the present method recursively.
     * 
     * This method implementation is correct, except for the (?) part. 
     * 
     */
    public void paintComponent(Graphics g)
    {
        long elapsedNanoseconds = this.chronometer.elapsedNanoseconds();

        var elapsedSinceLastUpdate = timer.update(elapsedNanoseconds);
        if ( elapsedSinceLastUpdate.isPresent() )
        {
           
            //(?)

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
     * Draws creatures on this.bufferedImage
     * See this.bfiRenderer.renderCreature
     */
    private void renderCreatures() 
    {
    	this.bfiRenderer.clearPixels(bufferedImage);

        CreatureA[] populationA = this.sim.getWorld().getPopulationA();
        CreatureB[] populationB = this.sim.getWorld().getPopulationB();

        for (CreatureA creature : populationA) 
        {
            Point position = creature.getPosition();
            Color color = Color.RED;

            this.bfiRenderer.renderCreature(bufferedImage, position, color);
        }

        for (CreatureB creature : populationB) 
        {
            Point position = creature.getPosition();
            Color color = Color.BLUE;

            this.bfiRenderer.renderCreature(bufferedImage, position, color);
        }
    }
}