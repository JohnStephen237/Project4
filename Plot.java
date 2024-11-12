/*
 * Class: CMSC203 
 * Instructor: Professor Gary Thai
 * Description: (Give a brief description for each Class)
 * Due: 11/11/2024
 * Platform/compiler: Visual Studio Code
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Johan Mbouwa
*/



public class Plot {
    // Attributes
    private int x;        // X-coordinate of the upper left corner
    private int y;        // Y-coordinate of the upper left corner
    private int width;    // Horizontal extent of the plot
    private int depth;    // Vertical extent of the plot

    // Constructors

    // Default constructor (creates a plot with width and depth of 1)
    public Plot() {
        this(0, 0, 1, 1);
    }

    // Parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Copy constructor
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to determine if this plot overlaps with another plot
    public boolean overlaps(Plot plot) {
        return !(plot.x + plot.width <= this.x || 
                 plot.x >= this.x + this.width || 
                 plot.y + plot.depth <= this.y || 
                 plot.y >= this.y + this.depth);
    }

    // Method to check if this plot encompasses another plot
    public boolean encompasses(Plot plot) {
        return (plot.x >= this.x && 
                plot.y >= this.y && 
                plot.x + plot.width <= this.x + this.width && 
                plot.y + plot.depth <= this.y + this.depth);
    }

    // toString method to represent a Plot instance
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
