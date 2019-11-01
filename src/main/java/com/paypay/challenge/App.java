package com.paypay.challenge;

import java.util.ArrayList;

import com.paypay.challenge.queue.Element;
import com.paypay.challenge.queue.Queue;
import com.paypay.challenge.queue.SlowImmutableQueue;
import com.paypay.challenge.test.model.Address;

/**
 * Defines entry method of the application. This application is to demonstrate
 * immutable queue implementation.
 * 
 * @author hoang.tran
 */
public class App {
    public static void main(String[] args) {
	System.out.println("Immutable Queue Application\n\n");

	// Demonstration of immutable element
	System.out.println("Demonstration of immutable elements");
	Address address1 = new Address("Germany", "Berlin", 1111);
	Address address2 = new Address("France", "Paris", 2222);
	Element<Address> element1 = new Element<>(address1);
	Element<Address> element2 = new Element<>(address2, element1);

	System.out.println("\telement1=" + element1);
	System.out.println("\telement2=" + element2);

	// Change addresses used to set element1 and elemenet2
	address1.setCity("Frankfurt");
	address2.setCity("Le Havre");
	System.out.println("\taddress1=" + address1);
	System.out.println("\taddress2=" + address2);

	// Print out element1 and element2 again to check that their address is not
	// changed even address1 and address2 were changed
	System.out.println("\telement1=" + element1);
	System.out.println("\telement2=" + element2);

	// Demonstration of slow immutable queue
	System.out.println("\nDemonstration of immutable queues");
	SlowImmutableQueue<Address> addrQueue = new SlowImmutableQueue<Address>();
	System.out.println("\taddrQueue=" + addrQueue);

	Queue<Address> queue1 = addrQueue.enQueue(new Address("USA", "New York", 1234));
	System.out.println("\tqueue1=" + queue1);

	Queue<Address> queue2 = queue1.enQueue(new Address("Japan", "Tokyo", 9876));
	System.out.println("\tqueue2=" + queue2);

	Queue<Address> queue3 = queue2.deQueue();
	System.out.println("\tqueue3=" + queue3);

	Queue<Address> queue4 = queue3.enQueue(new Address("England", "London", 2468));
	System.out.println("\tqueue4=" + queue4);

	Queue<Address> queue5 = queue4.deQueue();
	System.out.println("\tqueue5=" + queue5);

	Queue<Address> queue6 = queue5.deQueue();
	System.out.println("\tqueue6=" + queue6);

	// After a sequences of enqueues and dequeues, print out all queues to see that
	// each immutable queue after being initialized has never been changed - they
	// are immutable
	System.out.println("\nAfter enqueuing and dequeuing immutable queues");
	ArrayList<Queue<Address>> queues = new ArrayList<Queue<Address>>();
	queues.add(addrQueue);
	queues.add(queue1);
	queues.add(queue2);
	queues.add(queue3);
	queues.add(queue4);
	queues.add(queue5);
	queues.add(queue6);

	queues.forEach(q -> {
	    System.out.println("\t" + q);
	});
    }
}