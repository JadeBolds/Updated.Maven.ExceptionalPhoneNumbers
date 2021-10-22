package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;

import java.util.ArrayList;
import java.util.Random;


import java.util.logging.Logger;

public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) throws InvalidPhoneNumberFormatException {
        PhoneNumber[] arrayOfPhoneNumbers = new PhoneNumber[phoneNumberCount];
        for(int j = 0; j < phoneNumberCount; j++){
            arrayOfPhoneNumbers[j] = createRandomPhoneNumber();
        }
        return arrayOfPhoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() throws InvalidPhoneNumberFormatException {
        //Random rand = new Random();
        int areaCodeMin = 100;
        int areaCodeMax = 999;

        int centralOfficeMin = 0;
        int centralOfficeMax = 999;

        int phoneLineMin = 1000;
        int phoneLineMax = 9999;

        int areaCode = (int)(Math.random()*(areaCodeMax-areaCodeMin+1)+areaCodeMin);
        int centralOfficeCode = (int)(Math.random()*(centralOfficeMax-centralOfficeMin+1)+centralOfficeMin);
        int phoneLineCode = (int)(Math.random()*(phoneLineMax-phoneLineMin+1)+phoneLineMin);


        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) throws InvalidPhoneNumberFormatException {
        String areaCodeString = String.valueOf(areaCode);
        String centralOfficeCodeString = String.valueOf(centralOfficeCode);
        String phoneLineCodeString = String.valueOf(phoneLineCode);

        String phoneNumberString = areaCodeString + centralOfficeCodeString + phoneLineCodeString;

        try {
            createPhoneNumber(phoneNumberString);
        }
        catch(InvalidPhoneNumberFormatException e) {
            return null;
        }

        return createPhoneNumber(phoneNumberString);
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
//        if(phoneNumberString != "(###)-###-####"){
//            throw new InvalidPhoneNumberFormatException();
//        }
        return new PhoneNumber(phoneNumberString);
    }
}
