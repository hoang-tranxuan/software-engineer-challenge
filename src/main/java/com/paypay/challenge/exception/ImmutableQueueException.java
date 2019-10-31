package com.paypay.challenge.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A simple class defining exceptions that may occur during any operations
 * and/or process of immutable queues.
 * 
 * @author hoang.tran
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class ImmutableQueueException extends RuntimeException {
    private String message;

    public ImmutableQueueException(String message) {
	super();
	this.message = message;
    }

    public ImmutableQueueException() {
	super("Exception occured while processing immutable queue.");
    }
}