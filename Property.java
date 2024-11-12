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

public class Property {
    // Attributes
    private String propertyName; // Name of the property
    private String city;         // City where the property is located
    private double rentAmount;   // Rental amount for the property
    private String owner;        // Owner of the property
    private Plot plot;           // Plot associated with the property

    // Constructors

    // Default constructor (creates a property with empty strings and a default plot)
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot(); // Creates a default Plot
    }

    // Parameterized constructor (without plot coordinates)
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(); // Creates a default Plot
    }

    // Parameterized constructor (with plot coordinates)
    public Property(String propertyName, String city, double rentAmount, String owner, 
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot); // Copy the plot
    }

    // Getters and Setters
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    // toString method to represent a Property instance
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
