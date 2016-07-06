package task.object.hierarchy.service;

import task.object.hierarchy.entity.body.*;
import task.object.hierarchy.entity.property.PropertyArray;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class BodyFactory {
    private int nameMinLength;
    private int nameMaxLength;
    private double minMass;
    private double maxMass;
    private double minDensity;
    private double maxDensity;
    private double minDiameter;
    private double maxDiameter;
    private double minDistanceFromCenter;
    private double maxDistanceFromCenter;

    public BodyFactory() {
    }

    public AstralBody createRandomAstralBody(AstralBody astralBody, PropertyArrayFactory propertyArrayFactory) {
        Random random = new Random();
        NameFactory nameFactory = new NameFactory();
        nameFactory.setLength(random.nextInt(this.nameMaxLength - this.nameMinLength) + this.nameMinLength);
        astralBody.setName(nameFactory.createRandomName());
        astralBody.setMass(random.nextDouble() * (this.maxMass - this.minMass) + this.minMass);
        astralBody.setDensity(random.nextDouble() * (this.maxDensity - this.minDensity) + this.minDensity);
        astralBody.setDiameter(random.nextDouble() * (this.maxDiameter - this.minDiameter) + this.minDiameter);
        astralBody.setDistanceFromCenter(random.nextDouble() * (this.maxDistanceFromCenter - this.minDistanceFromCenter) + this.minDistanceFromCenter);
        propertyArrayFactory.createRandomPropertyArray(astralBody.getPropertyArray());
        return astralBody;
    }

    public int getNameMinLength() {
        return nameMinLength;
    }

    public void setNameMinLength(int nameMinLength) {
        if (nameMinLength < 0)
            throw new IllegalArgumentException("Length of name should be more than or equal to zero");
        if (nameMinLength > this.nameMaxLength)
            throw new IllegalArgumentException("Name's minimum length should be less than or equal to maximum");
        this.nameMinLength = nameMinLength;
    }

    public int getNameMaxLength() {
        return nameMaxLength;
    }

    public void setNameMaxLength(int nameMaxLength) {
        if (nameMaxLength < 0)
            throw new IllegalArgumentException("Length of name should be more than or equal to zero");
        if (nameMaxLength < this.nameMinLength)
            throw new IllegalArgumentException("Name's maximum length should be more than or equal to minimum");
        this.nameMaxLength = nameMaxLength;
    }

    public double getMinMass() {
        return minMass;
    }

    public void setMinMass(double minMass) {
        if (minMass < 0)
            throw new IllegalArgumentException("Minimum mass should be more than or equal to zero");
        if (minMass > this.maxMass)
            throw new IllegalArgumentException("Minimum mass should be less than or equal to maximum");
        this.minMass = minMass;
    }

    public double getMaxMass() {
        return maxMass;
    }

    public void setMaxMass(double maxMass) {
        if (maxMass < 0)
            throw new IllegalArgumentException("Maximum mass should be more than or equal to zero");
        if (maxMass < this.minMass)
            throw new IllegalArgumentException("Maximum mass should be more than or equal to minimum");
        this.maxMass = maxMass;
    }

    public double getMinDensity() {
        return minDensity;
    }

    public void setMinDensity(double minDensity) {
        if (minDensity < 0)
            throw new IllegalArgumentException("Minimum density should be more than or equal to zero");
        if (minDensity > this.maxDensity)
            throw new IllegalArgumentException("Minimum density should be less than or equal to maximum");
        this.minDensity = minDensity;
    }

    public double getMaxDensity() {
        return maxDensity;
    }

    public void setMaxDensity(double maxDensity) {
        if (maxDensity < 0)
            throw new IllegalArgumentException("Maximum density should be more than or equal to zero");
        if (maxDensity < this.minDensity)
            throw new IllegalArgumentException("Maximum density should be more than or equal to minimum");
        this.maxDensity = maxDensity;
    }

    public double getMinDiameter() {
        return minDiameter;
    }

    public void setMinDiameter(double minDiameter) {
        if (minDiameter < 0)
            throw new IllegalArgumentException("Minimum diameter should be more than or equal to zero");
        if (minDiameter > this.maxDiameter)
            throw new IllegalArgumentException("Minimum diameter should be less than or equal to maximum");
        this.minDiameter = minDiameter;
    }

    public double getMaxDiameter() {
        return maxDiameter;
    }

    public void setMaxDiameter(double maxDiameter) {
        if (maxDiameter < 0)
            throw new IllegalArgumentException("Maximum diameter should be more than or equal to zero");
        if (maxDiameter < this.minDiameter)
            throw new IllegalArgumentException("Maximum diameter should be more than or equal to minimum");
        this.maxDiameter = maxDiameter;
    }

    public double getMinDistanceFromCenter() {
        return minDistanceFromCenter;
    }

    public void setMinDistanceFromCenter(double minDistanceFromCenter) {
        if (minDistanceFromCenter < 0)
            throw new IllegalArgumentException("Minimum distance from center should be more than or equal to zero");
        if (minDistanceFromCenter > this.maxDistanceFromCenter)
            throw new IllegalArgumentException("Minimum distance from center should be less than or equal to maximum");
        this.minDistanceFromCenter = minDistanceFromCenter;
    }

    public double getMaxDistanceFromCenter() {
        return maxDistanceFromCenter;
    }

    public void setMaxDistanceFromCenter(double maxDistanceFromCenter) {
        if (maxDistanceFromCenter < 0)
            throw new IllegalArgumentException("Maximum distance from center should be more than or equal to zero");
        if (maxDistanceFromCenter < this.minDistanceFromCenter)
            throw new IllegalArgumentException("Maximum distance from center should be more than or equal to minimum");
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }
}
