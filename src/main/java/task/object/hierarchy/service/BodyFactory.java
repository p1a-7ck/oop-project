package task.object.hierarchy.service;

import task.object.hierarchy.entity.body.*;

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

    public AstralBody createAstralBody(AstralBody astralBody) {
        Random random = new Random();
        NameFactory nameFactory = new NameFactory();
        nameFactory.setLength(random.nextInt(this.nameMaxLength - this.nameMinLength) + this.nameMinLength);
        astralBody.setName(nameFactory.createRandomName());
        astralBody.setMass(random.nextDouble() * (this.maxMass - this.minMass) + this.minMass);
        astralBody.setDensity(random.nextDouble() * (this.maxDensity - this.minDensity) + this.minDensity);
        astralBody.setDiameter(random.nextDouble() * (this.maxDiameter - this.minDiameter) + this.minDiameter);
        astralBody.setDistanceFromCenter(random.nextDouble() * (this.maxDistanceFromCenter - this.minDistanceFromCenter) + this.minDistanceFromCenter);
        return astralBody;
    }

    public int getNameMinLength() {
        return nameMinLength;
    }

    public void setNameMinLength(int nameMinLength) {
        this.nameMinLength = nameMinLength;
    }

    public int getNameMaxLength() {
        return nameMaxLength;
    }

    public void setNameMaxLength(int nameMaxLength) {
        this.nameMaxLength = nameMaxLength;
    }

    public double getMinMass() {
        return minMass;
    }

    public void setMinMass(double minMass) {
        this.minMass = minMass;
    }

    public double getMaxMass() {
        return maxMass;
    }

    public void setMaxMass(double maxMass) {
        this.maxMass = maxMass;
    }

    public double getMinDensity() {
        return minDensity;
    }

    public void setMinDensity(double minDensity) {
        this.minDensity = minDensity;
    }

    public double getMaxDensity() {
        return maxDensity;
    }

    public void setMaxDensity(double maxDensity) {
        this.maxDensity = maxDensity;
    }

    public double getMinDiameter() {
        return minDiameter;
    }

    public void setMinDiameter(double minDiameter) {
        this.minDiameter = minDiameter;
    }

    public double getMaxDiameter() {
        return maxDiameter;
    }

    public void setMaxDiameter(double maxDiameter) {
        this.maxDiameter = maxDiameter;
    }

    public double getMinDistanceFromCenter() {
        return minDistanceFromCenter;
    }

    public void setMinDistanceFromCenter(double minDistanceFromCenter) {
        this.minDistanceFromCenter = minDistanceFromCenter;
    }

    public double getMaxDistanceFromCenter() {
        return maxDistanceFromCenter;
    }

    public void setMaxDistanceFromCenter(double maxDistanceFromCenter) {
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }
}
