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

public class ManagementCompany {
    // Constants
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Instance variables
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Constructors
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer, otherCompany.plot.getX(), otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        this.numberOfProperties = otherCompany.numberOfProperties;
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    // Method to add a property
    public int addProperty(Property property) {
        if (isPropertiesFull()) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        properties[numberOfProperties] = property;
        return numberOfProperties++;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Method to get total rent
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Method to get property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    // Method to remove the last property
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[--numberOfProperties] = null;
        }
    }

    // Method to check if properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Method to get the count of properties
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Method to check if management fee is valid
    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n")
          .append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n")
          .append(" total management Fee: ").append(getTotalRent() * (mgmFeePer / 100)).append("\n");
        return sb.toString();
    }
}
