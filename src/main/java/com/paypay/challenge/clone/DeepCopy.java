package com.paypay.challenge.clone;

import com.google.gson.Gson;

/**
 * Provides deep copy method(s) to copy objects. The deep copy is important in
 * implementing immutable classes and/or collections including immutable queue.
 * Deep copy makes sure that all fields and nested objects are separately copied
 * and makes an entirely new object with the same contents as the original one.
 * This will help us to avoid the unexpected change behaviors affecting to the
 * new object when any changes occur in the original one. We introduce the first
 * implementation converting the original object into JSON, then making a new
 * separate object by converting back that JSON data. <a href=
 * "https://mvnrepository.com/artifact/com.google.code.gson/gson">Gson</a> will
 * be used for the conversion between objects and JSON.
 * 
 * @author hoang.tran
 *
 * @param <T>
 *            type of the object to be deep copied.
 */
public class DeepCopy<T> {
    /**
     * Deeply copies the given original object and creates a separate but
     * same-content object.
     * 
     * @param originalObj
     *            the original object to be copied.
     * @return an entirely new object with the same contents as the given one.
     */
    public static final <T> T deepCopy(T originalObj) {
	Gson gson = new Gson();

	String originalJSON = gson.toJson(originalObj);
	@SuppressWarnings("unchecked")
	T newObj = (T) gson.fromJson(originalJSON, originalObj.getClass());

	return newObj;
    }
}