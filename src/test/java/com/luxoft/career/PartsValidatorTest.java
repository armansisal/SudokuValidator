package com.luxoft.career;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartsValidatorTest {

    private PartsValidator partsValidator;

    @Before
    @Test
    public void setup(){
        partsValidator = new PartsValidator("6,2,4,5,3,9,1,8,7\n5,1,9,7,2,8,6,3,4\n8,3,7,6,1,4,2,9,5\n1,4,3,8,6,5,7,2,9\n9,5,8,2,4,7,3,6,1\n7,6,2,3,9,1,4,5,8\n3,7,1,9,5,6,8,4,2\n4,9,6,1,8,2,5,7,3\n2,8,5,4,7,3,9,1,9\n");
        Assert.assertEquals(Result.SUCCESS, partsValidator.parse());
    }

    @Test
    public void validateColumnTrue() {
        Assert.assertEquals(Result.SUCCESS, partsValidator.validateColumn(0));
    }

    @Test
    public void validateColumnFalse() {
        Assert.assertNotEquals(Result.SUCCESS, partsValidator.validateColumn(8));
    }

    @Test
    public void validateRowTrue() {
        Assert.assertEquals(Result.SUCCESS, partsValidator.validateRow(0));
    }

    @Test
    public void validateRowFalse() {
        Assert.assertNotEquals(Result.SUCCESS, partsValidator.validateRow(8));
    }

    @Test
    public void validateBox3x3True() {
        Assert.assertEquals(Result.SUCCESS, partsValidator.validateBox3x3(0));
    }

    @Test
    public void validateBox3x3False() {
        Assert.assertNotEquals(Result.SUCCESS, partsValidator.validateBox3x3(8));
    }


}