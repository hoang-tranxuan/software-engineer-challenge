package com.paypay.challenge.queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.paypay.challenge.test.model.Address;

/**
 * Unit tests for the {@link SlowImmutableQueue} class.
 * 
 * @author hoang.tran
 */
public class SlowImmutableQueueTest {
    /**
     * Tests that calling {@link SlowImmutableQueue#enQueue(Object)} on an immutable
     * queue does not change its contents. Instead, enqueue will make an entirely
     * new copy of the original queue and add new element to the back of that new
     * queue.
     */
    @Test
    public void enQueue_doesNotChangeOriginalQueue() {
	// Prepare test data
	Queue<Address> originalQueue = new SlowImmutableQueue<>();

	// Call method to be test
	Queue<Address> newQueue = originalQueue.enQueue(new Address("USA", "New York", 1234));

	// Assert test result
	// Check that the originalQueue is still empty after it called enQueue method
	assertTrue(originalQueue.isEmpty());

	// Check that the newQueue isn't empty - meaning that the enQueue method call
	// was successful
	assertFalse(newQueue.isEmpty());
    }

    /**
     * Tests that calling {@link SlowImmutableQueue#deQueue()} on an immutable queue
     * does not change the queue itself. Instead, it make a copy of the original
     * with the element at the front of that copy queue removed.
     */
    @Test
    public void deQueue_doesNotChangeOriginalQueue() {
	// Prepare test data
	Element<Address> element1 = new Element<Address>(new Address("Japan", "Tokyo", 1234));
	Queue<Address> originalQueue = new SlowImmutableQueue<>(element1, element1);

	// Check that the original queue has one element (not empty)
	assertFalse(originalQueue.isEmpty());

	// Call method to be test
	Queue<Address> newQueue = originalQueue.deQueue();

	// Assert test result
	// Check that the newQueue is now empty
	assertTrue(newQueue.isEmpty());

	// Assert that the originalQueue still have one element (not empty)
	assertFalse(originalQueue.isEmpty());
    }
}