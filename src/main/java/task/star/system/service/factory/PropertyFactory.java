package task.star.system.service.factory;

import task.star.system.model.entity.Body;

import java.util.Random;

/**
 * Created by P1A-7CK on 06.07.2016.
 */
public class PropertyFactory {
    public NameFactory nameFactory = new NameFactory();
    private int minPropertiesNumber;
    private int maxPropertiesNumber;
    private int minNumericValue;
    private int maxNumericValue;
    private int minStringLength;
    private int maxStringLength;

    public PropertyFactory() {
    }

    public void createRandomProperty(Body body) {
        NameFactory stringFactory = new NameFactory();
        Random random = new Random();

        stringFactory.setNameMaxLength(this.maxStringLength);
        stringFactory.setNameMinLength(this.minStringLength);
        for (int i = 0; i < random.nextInt(this.maxPropertiesNumber - this.minPropertiesNumber) +
                this.minPropertiesNumber; i++) {
            try {
                switch (random.nextInt(4)) {
                    case 0: //int
                        body.addProperty(nameFactory.createRandomName(),
                                random.nextInt(this.maxNumericValue - this.minNumericValue) +
                                        this.minNumericValue);
                    case 1: //long
                        body.addProperty(nameFactory.createRandomName(),
                                random.nextLong() * (this.maxNumericValue - this.minNumericValue) +
                                        this.minNumericValue);
                    case 2: //double
                        body.addProperty(nameFactory.createRandomName(),
                                random.nextDouble() * (this.maxNumericValue - this.minNumericValue) +
                                        this.minNumericValue);
                    case 3: //String
                        body.addProperty(nameFactory.createRandomName(), stringFactory.createRandomName());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Not unique random property naming exception");
            }
        }
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
