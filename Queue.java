/*
* This program contains the relevant modifier and accesor methods in the Queue object, allowing the user to 
*retrieve, add, or remove certain information from the queue.
*Name: Samar Qureshi
*Date: Dec 25/2021
Course: ICS4U
*/

package com.company.dataStructure;

public class Queue {
    int [] data; //stores queue elements
	int front; //the element at the beginning of the queue
	private int rear; //the element at the end of the queue
	private int size; //size of the current queue
	static int product; //stores the product of the dequeued numbers

    public Queue (int maxSize){ //constructor that stores general information for intial queue
		data = new int[maxSize]; //client code determines max possible size of the queue
		front = -1;
		rear = -1;
		size = 0;
		product = 1;
	}

	/*
    *Removes the element at the front of the queue
    *Pre: Initial queue 
    *Post: Queue with new front location and the omission of an element (if possible)
    */
	public int dequeue() { 

		if(isEmpty()){ //if queue is empty, nothing can be dequeued
			System.out.println("Cannot dequeue, queue is currently empty!");
			return -1;
		}

		int n = data[front];
		System.out.println("Dequeueing: " + n);

		front++;
		front = front % data.length; //mod allows for circular array, new location of front element
		size --;
		return n;

	}

	/*
    * Adds an element to the rear of the queue
    *Pre: Initial queue
    *Post: New Queue with new rear location and the addition of an element (if possible)
    */
	public int enqueue(int n) { 
		//where n is the item we want to add 
		if(size == data.length || isFull()){ //if the queue is full, we cannot add anything
			System.out.println("\nLooks like your queue is currently full. Unable to add " + n + ".");
			return n;
		}

		else if(front == -1){ //first time messing with queue
			front = 0;
		}

		rear++;
		rear %= data.length; //mod allows for circular implementation
		data[rear] = n; //element is added at new location of rear
		System.out.println("Added " + n + " to the queue.");

		size ++;
		return n;
	}
	
	/*
    *Pre: nothing
    *Post: accesor method that returns the element at the front of the queue
    */
	public int getFront(){
		if(front == -1){ //checks to see if the queue is empty
			return 1;
		}

		return data[front];
	}

	/*
    *Pre: nothing
    *Post: accessor method that returns the current number of elements in the queue
    */
	public int getSize() {
		return size;
	}
	
	/*
    * Makes the queue empty by setting the front and rear to -1
    *Pre: initial queue
    *Post: "empty" queue
    */
	public void makeEmpty(){
		front = -1;
		rear = -1;
		size = 0;

		System.out.println("\nQueue is now empty!");
	}

	/*
    * Checks if the queue is empty
    *Pre: nothing
    *Post: returns a boolean based on the location of front and rear and the size of the queue
    */
	public boolean isEmpty(){
		if(front == -1 && rear == -1 || size == 0){
			return true;
		}

		 return false;
	}

	/*
    *Checks if the queue is full
    *Pre: nothing
    *Post: returns a boolean based on the location of the rear in relation to the front element 
    */
	public boolean isFull(){
		if(rear+1 % data.length == front){
			return true;
		}

		else{
			return false;
		}
	}

	/*
    * Displays every element in the current queue
    *Pre: nothing
    *Post: Elegant display of each element in the queue in relation to the front and rear
    */
	public String toString(){
		if(!isEmpty()){
			String info = "Your current queue: | ";

			for(int i = 0, ii = 0; i<size; i++){
				if(front % data.length + i < data.length){ // checking to see if every element has gone over
					info += (data[front % data.length + i] + " | "); //+i
				}

				else{
					info +=  data[ii] + " | ";
					ii++;
				}
			}
			return info;
		}

		else {
			return "Nothing to show, your queue is currently empty!";
		}
	}
		
}
 