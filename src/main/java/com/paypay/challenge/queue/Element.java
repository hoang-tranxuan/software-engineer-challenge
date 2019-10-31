package com.paypay.challenge.queue;

import com.paypay.challenge.clone.DeepCopy;

import lombok.ToString;

/**
 * Defines an immutable object representing each element of the immutable queue.
 * 
 * <pre>
 *      back                                    front
 *       |                                        |
 *       |                                        |
 *   +--------+     +--------+               +--------+
 *   |  data  |     |  data  |               |  data  |
 *   |        |     |        |               |        |
 *   |  next -+---->|  next -+----> ... ---->|  next -+----> null
 *   +--------+     +--------+               +--------+
 *       /                                        \
 *      /                                          \
 *   enqueue                                     dequeue
 * </pre>
 *
 * @author hoang.tran
 *
 * @param <T>
 *            the type of the data contained in each element of the queue.
 */
@ToString
public final class Element<T> {
    /** The data saved in each element of the queue. */
    private final T data;

    /** The reference to the next */
    private final Element<T> nextElement;

    /**
     * Creates a queue element with the {@code nextElement} pointing to null. This
     * constructor is used to create the element on the front (head) of the queue.
     * 
     * @param data
     *            the data to be saved in the element.
     */
    public Element(T data) {
	this(data, null);
    }

    /**
     * Creates a queue element with the {@code nextElement} pointing to another
     * element that was added to the queue right before.
     * 
     * @param data
     *            the data to be saved inside the element.
     * @param nextElement
     *            the element added to the queue right before the order this element
     *            is created and enqueued.
     */
    public Element(T data, Element<T> nextElement) {
	this.data = DeepCopy.deepCopy(data);
	this.nextElement = nextElement == null ? null : DeepCopy.deepCopy(nextElement);
    }

    /**
     * Gets data saved inside this element.
     * 
     * @return a deep copy of the data save in this element.
     */
    public T getData() {
	return DeepCopy.deepCopy(this.data);
    }

    /**
     * Gets the reference to the next element that this element points to.
     * 
     * @return the next element to be referred by this element.
     */
    public Element<T> getNextElement() {
	return this.nextElement;
    }
}