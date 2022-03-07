# Deadlock prevention

## What are the necessary conditions for deadlocks

- _Mutual exclusion_: Limited number of threads may utilize a resource concurrently.
- _Hold and wait_: A thread holding a resource may request access to other resources and wait until it gets them.
- _No preemption_: Resources are released only voluntarily by the thread holding the resource.
- _Circular wait_: There is a set of threads, where T1 is waiting for a resource held by T2. T2 is waiting for a resource held by T3 and so forth.

## Why does the initial solution lead to a deadlock (by looking at the deadlock conditions)?

The initial solution leads to a deadlock because a **circular wait** happens. The problem is that the right fork of one
philosoph is the left fork of the other philosoph and the left fork is taken first.

Example: 3 Philosophers
For example a philosoph p1 claims the left fork f1, suddenly the execution is 
switched to another philosoph p2, which takes his left fork f2, which is the right fork f2 of p1. Therefore, p1 occupies the  
the fork f1, until the p2 releases f2. p2 can't take his right fork f1 afterwards, which results in a **circular wait**.
p3 can take his left fork f3, but can't also not continue, because f2 is occupied by p2. Therefore, the problem also contains
**Hold and wait**, because a thread requests the left fork first and then waits for the right fork. **Mutual exclusion** is also
the case because a limited number of threads (philosophers) want to a resource concurrently (forks). And **No preemption** is also
fulfilled, because only the thread releases the occupied forks.

___

## Switch the order in which philosophers take the fork by using the following scheme: Odd philosophers start with the left fork, while even philosophers start with the right hand?
## Does this strategy resolve the deadlock and why?

The deadlock is resolved because the fork between odd and even philosophers can't be blocked. An odd or even philosopher
can always take the fork between two philosophers.

The odd philosopher takes his left fork first, while the even philosopher takes his right fork. The fork between
the philosophers can be taken by both philosophers, because it is the right fork of the odd philosopher and the left fork
of the even philosopher.

Therefore, at least one philosopher can take both forks.

## Measure the total time spent in waiting for forks and compare it to the total runtime. Interpret the measurement - Was the result expected?

## Can you think of other techniques for deadlock prevention?

## Make sure to always shutdown the program cooperatively and to always cleanup all allocated resources
