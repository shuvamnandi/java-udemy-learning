package com.shuvamnandi;

import com.shuvamnandi.arrayblockingqueue.MyConsumerWithArrayBlockingQueue;
import com.shuvamnandi.arrayblockingqueue.MyProducerWithArrayBlockingQueue;
import com.shuvamnandi.deadlocks.Thread1;
import com.shuvamnandi.deadlocks.Thread2;
import com.shuvamnandi.messages.MyReader;
import com.shuvamnandi.messages.Message;
import com.shuvamnandi.messages.MyWriter;
import com.shuvamnandi.multiplethreads.Countdown;
import com.shuvamnandi.multiplethreads.CountdownThread;
import com.shuvamnandi.producerconsumer.MyConsumer;
import com.shuvamnandi.producerconsumer.MyProducer;
import com.shuvamnandi.threads.AnotherThread;
import com.shuvamnandi.threads.MyRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.shuvamnandi.ThreadColor.*;

public class Main {
    public static void basicThreadExamples() {
        System.out.println(ANSI_GREEN + "Hello from the main thread.");

        // Priority of threads is up to system scheduling
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        // anotherThread.run(); // This runs on the thread from where the run() method is called
        anotherThread.start();

        // Anonymous thread example
        new Thread() {
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class thread!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        // anotherThread.interrupt();

        new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from the anonymous class's implementation of run!");
                try {
                    System.out.println(ANSI_CYAN + "Waiting until anotherThread is complete.");
                    anotherThread.join(20000);
                    System.out.println(ANSI_CYAN + "I am running again after anotherThread is complete or time out.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN + "I couldn't wait after all. I was interrupted");
                    return;
                }
            }
        }).start();
        System.out.println(ANSI_GREEN + "Hello again from the main thread.");
        // anotherThread.start(); // gives an IllegalThreadStateException on calling start() once again
    }

    public static void multipleThreadsExamples() {
        Countdown countdown = new Countdown();
        // No interference if there are separate countdown objects
        // CountdownThread countdownThread1 = new CountdownThread(new Countdown());
        // countdownThread1.setName("Thread-1");
        // CountdownThread countdownThread2 = new CountdownThread(new Countdown());
        // countdownThread1.setName("Thread-2");
        CountdownThread countdownThread1 = new CountdownThread(countdown);
        countdownThread1.setName("Thread-1");
        CountdownThread countdownThread2 = new CountdownThread(countdown);
        countdownThread1.setName("Thread-2");
        countdownThread1.start();
        countdownThread2.start();
    }

    public static void messageWithDeadlockExamples() {
        Message message = new Message();
        MyWriter myWriter = new MyWriter(message);
        MyReader myReader = new MyReader(message);

        (new Thread(myWriter)).start();
        (new Thread(myReader)).start();
    }

    public static void producerConsumerExamples() {
        List<String> buffer = new ArrayList<>(); // a thread-unsafe collection is used as an example

        // Reentrant lock - if a thread is already holding a reentrant lock when it reaches the code that requires the
        // same lock, it can continue executing it and it doesn't have to obtain the lock again.
        ReentrantLock bufferLock = new ReentrantLock(true); // this accepts a fairness parameter to try to wake up a thread that has been waiting for the longest time
        MyProducer myProducer = new MyProducer(buffer, ANSI_BLUE, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ANSI_RED, bufferLock);

        new Thread(myProducer).start();
        new Thread(myConsumer1).start();
        new Thread(myConsumer2).start();
    }

    public static void executerServiceExample() {
        List<String> buffer = new ArrayList<>(); // a thread-unsafe collection is used as an example
        ReentrantLock bufferLock = new ReentrantLock(true); // this accepts a fairness parameter to try to wake up a thread that has been waiting for the longest time

        ExecutorService executorService = Executors.newFixedThreadPool(3); // only allows 3 active threads at a time

        MyProducer myProducer = new MyProducer(buffer, ANSI_BLUE, bufferLock);
        MyConsumer myConsumer1 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ANSI_RED, bufferLock);

        executorService.execute(myProducer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);

        Future<String> futureResult = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                System.out.println(ANSI_GREEN + "I'm being called from the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(ANSI_CYAN + "Result from future: " + futureResult.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong in the future.get call");
        } catch (InterruptedException e) {
            System.out.println("Interrupted the future.get call");
        }

        executorService.shutdown();
        /*
        Implementations of ExecutorService interface manage threads for us, so that we don't have to explicitly create
        and start threads.The implementation is provided by the JDK to manage things like thread scheduling, and they
        also optimize the creation of threads (which can generally be expensive in terms of performance and memory).
        However, we still have to provide runnable objects to the service because we still have to code the tasks
        we want to execute on background threads, but we don't directly manage any threads as such.
        The executive service implementations allow us to focus on the code we want to run without the fuss of
        managing threads and their life cycles.
        We create an implementation of executive service and give it the tasks we want to run, without worrying about
        the details of how the tasks will actually be run. The executive service implementations makes use of thread pools.
        Thread pool is a managed set of threads. A thread pool is a managed set of threads.
        It reduces the overhead of thread creation, especially in applications that use a large number of threads.
        A thread pool may also limit the number of threads that are active, running or blocked at any one particular time.
        When using a certain types of thread pool, an application can't run wild and create an excessive number of threads.
        In Java, we use thread polls through the executive service implementations.
        Since thread pools can limit the number of active threads, it's possible that when we asked the service to
        run a task it won't be able to run it straight away. For example, if the maximum number of threads has been set
        to 20, there may already be 20 active threads when we submitted a task. In that case, the task will have to wait
        on the services queue until one of the active threads actually terminates.
        Using an executive service for this application is overkill, but it's vital for applications that use a large
        number of threads because using them allows the JVM to optimize thread management.
        We can use the submit method on the ExecutorService object, which accepts a Callable object, very similar to a
        Runnable object, except that it can return a value the value can be returned as an object of type Future.
         */
    }

    public static void arrayBlockingQueueExamples() {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(10); // ArrayBlockingQueue with a capacity of elements it can hold at a time

        MyProducerWithArrayBlockingQueue myProducer = new MyProducerWithArrayBlockingQueue(buffer, ANSI_BLUE);
        MyConsumerWithArrayBlockingQueue myConsumer1 = new MyConsumerWithArrayBlockingQueue(buffer, ANSI_GREEN);
        MyConsumerWithArrayBlockingQueue myConsumer2 = new MyConsumerWithArrayBlockingQueue(buffer, ANSI_RED);

        new Thread(myProducer).start();
        new Thread(myConsumer1).start();
        new Thread(myConsumer2).start();
    }

    public static void deadlockExamples() {
        /*
        Deadlocks occur when two or more threads are blocked on locks and every thread that's blocked is
        holding a lock that another block thread wants. For example, thread 1 is holding lock 1 and waiting
        to acquire lock 2 but thread 2 is holding lock 2 and waiting to acquire lock 1.
        Because all the threads holding the locks are blocked, they will never release the locks they're
        holding and so none of the waiting threads will actually ever run.
         */
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread1 thread1 = new Thread1(lock1, lock2);
        Thread2 thread2 = new Thread2(lock1, lock2);

        thread1.start();
        thread2.start();
        /*
        How the deadlock happened:
        Thread 1 obtained lock 1 then called sleep and got suspended.
        Thread 2 then ran and obtained lock 2 and then called sleep and got suspended.
        Thread 1 woke up and tried to obtain lock 2 but thread 2 is holding lock 2 so thread 1 blocks.
        Then thread 2 wakes up and tries to obtain lock 1 but thread 1 has got to lock 1 already, so thread 2
        blocks at this point.
        In other words, thread 1 will never be able to run and thread 2 will never be able to run.
        How to avoid deadlocks -
        1. Always use 1 lock object instead of 2. But this is not a practical solution for many applications that may
        need multiple locks.
        2. Ensure that all threads acquire the multiple locks in the same order.
        In this case, thread 1 had acquired lock 1 first whereas thread 2 had acquired lock 2 first, leading to deadlock.
         */
    }

    public static void main(String[] args) {
        // basicThreadExamples();
        // multipleThreadsExamples();
        // messageWithDeadlockExamples();
        // producerConsumerExamples();
        // executerServiceExample();
        // arrayBlockingQueueExamples();
        deadlockExamples();
    }
}
