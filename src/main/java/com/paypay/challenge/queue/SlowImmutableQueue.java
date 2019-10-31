package com.paypay.challenge.queue;

import java.util.Stack;

import com.paypay.challenge.clone.DeepCopy;
import com.paypay.challenge.exception.ImmutableQueueException;

import lombok.ToString;

/**
 * Defines an immutable queue that always makes an entirely new copy of its all
 * elements when doing enqueue; and an entirely new copy of its all elements
 * except the one to be removed when doing dequeue. Because the underlying
 * algorithm here uses deep copy to all elements of the queue, it is slow in the
 * operations of large-size immutable queues. Each element of the queue is
 * represented by class {@link Element}.
 * 
 * @author hoang.tran
 *
 * @param <T>
 *            the type of data of elements to be added to and removed from the
 *            queue.
 * @see com.paypay.challenge.queue.Element
 */
@ToString
public final class SlowImmutableQueue<T> implements Queue<T> {
    /**
     * <em>front</em> (also called <em>head</em> or <em>first node</em>) of the
     * queue. Elements are dequeued by removing them one-by-one from the queue's
     * <em>front</em>.
     */
    private final Element<T> front;

    /**
     * <em>back</em> (also called <em>last node</em> of the queue is where new
     * elements are added into the queue.
     */
    private final Element<T> back;

    /** Creates an empty immutable queue. */
    public SlowImmutableQueue() {
	this.front = null;
	this.back = null;
    }

    /**
     * Defines an immutable queue with two references pointing to the front and back
     * of it.
     * 
     * @param front
     *            the <em>front</em> of the queue from which elements are dequeued.
     * @param back
     *            the <em>back</em> of the queue to which elements are enqueued.
     */
    public SlowImmutableQueue(Element<T> front, Element<T> back) {
	this.back = DeepCopy.deepCopy(back);

	if (front == back) {
	    this.front = this.back;
	} else {
	    this.front = DeepCopy.deepCopy(front);
	}
    }

    /**
     * {@inheritDoc} Enqueue inserts a new element at the back of the queue as
     * follows:
     * <ul>
     * <li>first, creates a new element node,</li>
     * <li>then, copies the current immutable queue,</li>
     * <li>finally, let the new element point to the <em>back</em> of the copy
     * queue</li>
     * </ul>
     */
    public Queue<T> enQueue(T t) {
	// Both back and front point to the new element if the current queue is empty
	if (isEmpty()) {
	    Element<T> newElement = new Element<T>(t);
	    return new SlowImmutableQueue<T>(newElement, newElement);
	}

	// Push all elements' data into a stack
	Stack<T> elementDataStack = new Stack<T>();
	for (Element<T> e = this.back; e != null; e = e.getNextElement()) {
	    elementDataStack.push(e.getData());
	}

	// Throw exception if the number of elements exceeds the max allowed
	if (elementDataStack.size() == MAX_ELEMENTS) {
	    throw new ImmutableQueueException("Immutable queue overflow");
	}

	// Get the current queue's elements' data by popping elements data from the
	// stack, then build up a new immutable queue with new element added at the
	Element<T> front = new Element<T>(elementDataStack.pop());
	Element<T> nextElement = front;
	while (!elementDataStack.empty()) {
	    nextElement = new Element<T>(elementDataStack.pop(), nextElement);
	}
	Element<T> back = new Element<T>(t, nextElement);

	return new SlowImmutableQueue<T>(front, back);
    }

    /**
     * {@inheritDoc} Dequeue makes a new immutable queue in which all elements
     * except the one at the <em>front</em> (or the <em>head</em>) of the current
     * queue.
     * 
     * @throws ImmutableQueueException
     *             if the dequeue is operated on an empty queue.
     */
    public Queue<T> deQueue() throws ImmutableQueueException {
	// Throw exception if there is no element to be dequeued
	if (isEmpty()) {
	    throw new ImmutableQueueException("Immutable queue underflow");
	}

	// Return an empty immutable queue if only one element left in the current queue
	if (this.front == this.back) {
	    return new SlowImmutableQueue<T>();
	}

	// Push all elements' data into a stack except the least currently enqueued
	// element's data
	Stack<T> elementDataStack = new Stack<T>();
	for (Element<T> e = this.back; e != null && e.getNextElement() != null; e = e.getNextElement()) {
	    elementDataStack.push(e.getData());
	}

	// Create a new immutable queue using elements' data pushed in the stack
	Element<T> front = new Element<T>(elementDataStack.pop());
	Element<T> nextElement = front;
	while (!elementDataStack.isEmpty()) {
	    nextElement = new Element<T>(elementDataStack.pop(), nextElement);
	}

	return new SlowImmutableQueue<T>(front, nextElement);
    }

    /**
     * {@inheritDoc}
     */
    public T head() {
	if (isEmpty()) {
	    return null;
	}

	return this.front.getData();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
	return this.front == null;
    }
}