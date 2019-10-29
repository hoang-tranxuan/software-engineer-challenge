package com.paypay.challenge.clone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.paypay.challenge.test.model.Address;
import com.paypay.challenge.test.model.User;
import com.paypay.challenge.test.util.Utilities;

/**
 * Unit tests for the {@link DeepCopy} class.
 * 
 * @author hoang.tran
 */
public class DeepCopyTest {
    /**
     * Tests that the {@link DeepCopy#deepCopy(Object)} method correctly creates a
     * separate object that has the same contents as the original one.
     */
    @Test
    public void deepCopy_createSeparateObjectsWithSameContents() {
	// Prepare test data
	User ana = new User("Ana", Utilities.stringToDate("1990-06-15"), new Address("USA", "Los Angeles", 123456));
	User suzuki = new User("Suzuki", Utilities.stringToDate("1987-12-21"), new Address("Japan", null, 9876543));
	User chris = new User("Chris", null, null);

	// Call method to be tested
	User anaCopy = DeepCopy.deepCopy(ana);
	User suzukiCopy = DeepCopy.deepCopy(suzuki);
	User chrisCopy = DeepCopy.deepCopy(chris);

	// Assert test result
	// Check that the original and the copy objects have the same contents
	assertEquals(ana, anaCopy);

	// Check that the original and the copy objects are separate objects
	// (use == operator to compare object references)
	assertFalse(ana == anaCopy);

	assertEquals(suzuki, suzukiCopy);
	assertFalse(suzuki == suzukiCopy);
	assertEquals(chris, chrisCopy);
	assertFalse(chris == chrisCopy);
    }

    /**
     * Tests that the copy object created by {@link DeepCopy#deepCopy(Object)} is
     * not affected when the original object is changed.
     */
    @Test
    public void deepCopy_changesOnOriginalObjectDonotAffectCopyObject() {
	// Prepare test data
	User originalObj = new User("Ana", Utilities.stringToDate("1990-06-15"),
		new Address("USA", "Los Angeles", 123456));

	// Call method to be tested to make a copy object
	User copyObj = DeepCopy.deepCopy(originalObj);

	// Assert right after the copy the original and copy objects have same contents
	assertEquals(originalObj, copyObj);

	// Change some of properties' value of the original object
	originalObj.getAddress().setCity("New York");

	// Assert that the original and copy objects now have different contents
	// meaning that the change to the original doesn't affect to the copy
	assertNotEquals(originalObj, copyObj);
    }
}