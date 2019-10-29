package com.paypay.challenge.queue;

/**
 * Interface defining APIs that will be implemented for immutable queues (a
 * First In First Out data structure).
 * 
 * @author hoang.tran
 *
 * @param <T>
 *            type of the elements put into the queue.
 */
public interface Queue<T> {
    /**
     * Adds the element t into the queue and returns that new queue.
     * 
     * @param t
     *            the element to be put into the queue.
     * @return a new queue containing the newly added element.
     */
    public Queue<T> enQueue(T t);

    /**
     * Removes the element at the beginning of the queue, and returns the new queue.
     * 
     * @return the new queue without the removed element.
     */
    public Queue<T> deQueue();

    /**
     * Refers the element at the head (front) of the queue.
     * 
     * @return a copy of the element at the head of the queue.
     */
    public T head();

    /**
     * Checks if the queue does not contain any elements.
     * 
     * @return {@code true} if this queue is empty; {@code false} otherwise.
     */
    public boolean isEmpty();
}