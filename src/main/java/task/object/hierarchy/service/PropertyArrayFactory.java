package task.object.hierarchy.service;

import task.object.hierarchy.entity.property.PropertyArray;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class PropertyArrayFactory {
    private int nameMinLength = 1;
    private int nameMaxLength = 1;
    private int minPropertiesNumber;
    private int maxPropertiesNumber;
    private int minNumericValue;
    private int maxNumericValue;
    private int minStringLength;
    private int maxStringLength;

    public PropertyArrayFactory() {
    }

    public void createRandomPropertyArray(PropertyArray propertyArray) {
        String propertyName;
        Random random = new Random();
        NameFactory nameFactory = new NameFactory();
        for (int i = 0; i < random.nextInt(this.maxPropertiesNumber - this.minPropertiesNumber) + this.minPropertiesNumber; i++) {
            nameFactory.setLength(random.nextInt(this.nameMaxLength - this.nameMinLength) + this.nameMinLength);
            propertyName = nameFactory.createRandomName();
            try {
                switch (random.nextInt(4)) {
                    case 0: //int
                        propertyArray.addProperty(propertyName,
                                random.nextInt(this.maxNumericValue - this.minNumericValue) + this.minNumericValue);
                    case 1: //long
                        propertyArray.addProperty(propertyName,
                                random.nextLong() * (this.maxNumericValue - this.minNumericValue) + this.minNumericValue);
                    case 2: //double
                        propertyArray.addProperty(propertyName,
                                random.nextDouble() * (this.maxNumericValue - this.minNumericValue) + this.minNumericValue);
                    case 3: //String
                        nameFactory.setLength(random.nextInt(this.maxStringLength - this.minStringLength) + this.minStringLength);
                        propertyArray.addProperty(propertyName, nameFactory.createRandomName());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Randomly created property's name '" + propertyName + "' not unique");
            }

        }
    }

    public int getNameMinLength() {
        return nameMinLength;
    }

    public void setNameMinLength(int nameMinLength) {
        if (nameMinLength <= 0)
            throw new IllegalArgumentException("Property name should be at least one symbol");
        if (nameMinLength > this.nameMaxLength)
            throw new IllegalArgumentException("Property name's minimum length should be less than or equal to maximum length");
        this.nameMinLength = nameMinLength;
    }

    public int getNameMaxLength() {
        return nameMaxLength;
    }

    public void setNameMaxLength(int nameMaxLength) {
        if (nameMaxLength <= 0)
            throw new IllegalArgumentException("Property name should be at least one symbol");
        if (nameMaxLength < this.nameMinLength)
            throw new IllegalArgumentException("Property name's maximum length should more than or equal to minimum length");
        this.nameMaxLength = nameMaxLength;
    }

    public int getMinPropertiesNumber() {
        return minPropertiesNumber;
    }

    public void setMinPropertiesNumber(int minPropertiesNumber) {
        if (minPropertiesNumber < 0)
            throw new IllegalArgumentException("Minimum number of properties should be more than zero");
        if (minPropertiesNumber > this.maxPropertiesNumber)
            throw new IllegalArgumentException("Properties' minimum number should be less than or equal to maximum");
        this.minPropertiesNumber = minPropertiesNumber;
    }

    public int getMaxPropertiesNumber() {
        return maxPropertiesNumber;
    }

    public void setMaxPropertiesNumber(int maxPropertiesNumber) {
        if (maxPropertiesNumber < 0)
            throw new IllegalArgumentException("Minimum number of properties should be more than zero");
        if (maxPropertiesNumber < this.minPropertiesNumber)
            throw new IllegalArgumentException("Properties' maximum number should be more than or equal to minimum");
        this.maxPropertiesNumber = maxPropertiesNumber;
    }

    public int getMinNumericValue() {
        return minNumericValue;
    }

    public void setMinNumericValue(int minNumericValue) {
        if (minNumericValue > this.maxNumericValue)
            throw new IllegalArgumentException("Minimum numeric value should be less than or equal to maximum");
        this.minNumericValue = minNumericValue;
    }

    public int getMaxNumericValue() {
        return maxNumericValue;
    }

    public void setMaxNumericValue(int maxNumericValue) {
        if (maxNumericValue < this.minNumericValue)
            throw new IllegalArgumentException("Maximum numeric value should be more than or equal to minimum");
        this.maxNumericValue = maxNumericValue;
    }

    public int getMinStringLength() {
        return minStringLength;
    }

    public void setMinStringLength(int minStringLength) {
        if (minStringLength < 0)
            throw new IllegalArgumentException("Minimum length of string should be more than zero");
        if (minStringLength > this.maxStringLength)
            throw new IllegalArgumentException("String's minimum length should be less than or equal to maximum");
        this.minStringLength = minStringLength;
    }

    public int getMaxStringLength() {
        return maxStringLength;
    }

    public void setMaxStringLength(int maxStringLength) {
        if (maxStringLength < 0)
            throw new IllegalArgumentException("Minimum length of string should be more than zero");
        if (maxStringLength < this.minStringLength)
            throw new IllegalArgumentException("String's maximum length should be more than or equal to minimum");
        this.maxStringLength = maxStringLength;
    }
}
