# Immutable Queue
## Overview
This project implements an immutable queue as a solution for the [Software Engineer Challenge](https://github.com/Pay-Baymax/SoftwareEngineerChalleng)'s coding task. The key idea behind the implementation of immutable queues is to make sure that any operations (method calls from the outside and inside public method calls) on the queues will not change their internal current state (no changes to any of the queue object's properties values). In order to do that,
* we limit to let the state of a queue to be initialized only when calling its constructor. Once, this initial state is set, it will never change.
* whenever we enqueue a data element, we use a _deep copy_ of the data object, not the original data object itself. This will helps us avoid any potential errors that might occur when the original object's state is changed. A deep copy of an object has an exact copy of all fields of the original object but in additional, if the original object has any references to other objects as fields, the copy of those objects is also created.
* and we only provide public methods for getting the queue's state, no public methods for setting the queue's state - avoiding the outside classes to change the queue.

The implementation here is considered to be slow when working with large-size immutable queues. That is because the underlying algorithm copies all elements of the original queues to create a new queue when enqueuing or dequeuing elements. However, for the purpose of demonstrating an immutable queue, the author chose a simple implementation.

Inside the root directory of the project, you can find the following PDF file containing the solution for the design question.
> [Software Engineer Challenge - Design a Google Analytic like Backend System.pdf](https://github.com/hoang-tranxuan/software-engineer-challenge/blob/master/Software%20Engineer%20Challenge%20-%20Design%20a%20Google%20Analytic%20like%20Backend%20System.pdf)

## Source Code Overview
Source code for the main implementation is grouped as in the following packages:

**Package** | **Description**
----------- | ---------------
[com.paypay.challenge]() | Contains the definition of the main app entry point.
[com.paypay.challenge.clone]() | Consists of a simple implementation of the deep copy.
[com.paypay.challenge.exception]() | Defines exceptions that might occur when manipulating immutable queues.
[com.paypay.challenge.queue]() | 
[com.paypay.challenge.test.model]() |
[com.paypay.challenge.test.util]() |

Sour code for tests is written in the following JUnit test classes:

**Class** | **Description**
----------- | ---------------
[DeepCopyTest.java]() |
[SlowImmutableQueueTest.java]() |

## Build and Run Tests
This project is set to use [Maven](https://maven.apache.org/) as build/testing tool. The implementation is written in Java and is specified to use Java 8.

If you have Maven correctly installed in your machine, you can build and run the app by issuing the following command via terminal/cmd prompt after cd into `software-engineer-challenge` directory:
```
# Build app
mvn clean package

# Run app
mvn exec:java -Dexec.mainClass="com.paypay.challenge.App"

# Run test
mvn test
```

## Author
* **Tran Xuan Hoang**
* **Emails:** hoang.tran@rakuten.com | hoangtx.social@gmail.com
