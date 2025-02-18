/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dequeusingqueues;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author sheha
 */
public class DequeUsingQueues {
    private Queue<Integer> frontQueue;
    private Queue<Integer> rearQueue;

    public DequeUsingQueues() {
        frontQueue = new LinkedList<>();
        rearQueue = new LinkedList<>();
    }

    // Add to the front
    public void addFront(int value) {
        frontQueue.add(value);
    }

    // Add to the rear
    public void addRear(int value) {
        rearQueue.add(value);
    }

    // Remove from the front
    public int removeFront() {
        if (!frontQueue.isEmpty()) {
            return frontQueue.poll();
        } else if (!rearQueue.isEmpty()) {
            shiftQueues(rearQueue, frontQueue);
            return frontQueue.poll();
        } else {
            System.out.println("Deque is empty!");
            return -1;
        }
    }

    // Remove from the rear
    public int removeRear() {
        if (!rearQueue.isEmpty()) {
            return rearQueue.poll();
        } else if (!frontQueue.isEmpty()) {
            shiftQueues(frontQueue, rearQueue);
            return rearQueue.poll();
        } else {
            System.out.println("Deque is empty!");
            return -1;
        }
    }

    // Peek Front
    public int peekFront() {
        if (!frontQueue.isEmpty()) {
            return frontQueue.peek();
        } else if (!rearQueue.isEmpty()) {
            shiftQueues(rearQueue, frontQueue);
            return frontQueue.peek();
        } else {
            System.out.println("Deque is empty!");
            return -1;
        }
    }

    // Peek Rear
    public int peekRear() {
        if (!rearQueue.isEmpty()) {
            return rearQueue.peek();
        } else if (!frontQueue.isEmpty()) {
            shiftQueues(frontQueue, rearQueue);
            return rearQueue.peek();
        } else {
            System.out.println("Deque is empty!");
            return -1;
        }
    }

    // Move all elements from source queue to destination queue
    private void shiftQueues(Queue<Integer> source, Queue<Integer> destination) {
        while (!source.isEmpty()) {
            destination.add(source.poll());
        }
    }

    // Display contents of both queues
    public void display() {
        System.out.println("Front Queue: " + frontQueue);
        System.out.println("Rear Queue: " + rearQueue);
    }
        public static void main(String[] args) {
        DequeUsingQueues deque = new DequeUsingQueues();

        deque.addFront(10);
        deque.addFront(20);
        deque.addRear(30);
        deque.addRear(40);

        deque.display();

        System.out.println("Removed Front: " + deque.removeFront());
        System.out.println("Removed Rear: " + deque.removeRear());

        deque.display();
        System.out.println("Front Peek: " + deque.peekFront());
        System.out.println("Rear Peek: " + deque.peekRear());
    }
}
