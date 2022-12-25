/*
* This program allows the user to choose between two types of data structures, the Queue and the Linked List
*in order to add or remove elements, and retrieve relevant components of each structure
*Name: Samar Qureshi
*Date: Dec 25/2021
Course: ICS4U
*/

package com.company.dataStructure;

import java.util.Scanner;

public class ADSmain {
    public static final Scanner input = new Scanner(System.in);
    public static int product = 1;
    public static void main(String[] args){
        Queue queue1 = new Queue(10);
        LinkedList list1 = new LinkedList();
        boolean masterFlag = true; //if program is still running or not 
        boolean LFlag = true; // if Linked Lists part of the program is still running
        boolean qFlag = true; // if Queues part of the program is still running 

        System.out.println("\n\nWelcome to Samar's ADS program!");

        while(masterFlag){ 
            String option = "";
            do{
                System.out.println("\nPlease select an option from the master menu below:" + 
                "\n1. Queues" + 
                "\n2. Linked Lists" + 
                "\n3. Exit master program ");
                System.out.print("\nChoice: ");
                option = input.nextLine();
            } while(!option.equals("1") && !option.equals("2") && !option.equals("3"));

            if(option.equals("1")){ //if user selects queues
                fillQueue(queue1);

                while(qFlag){ 
                    String choice = "";
        
                    do{
                        System.out.println("\n\n===============Please select an option from the Queues menu below=============== \n" + 
                        "\n1. Dequeue numbers from the queue one by one until a number larger than 100 is found" +
                        "\n2. Determine the product of the dequeued numbers" + 
                        "\n3. Display current queue" + 
                        "\n4. Display number of elements left in the queue" +
                        "\n5. Add a number to the end of the queue" + 
                        "\n6. Remove a number from the front of the queue" +
                        "\n7. Make the queue empty" +
                        "\n8. Exit Queues");
                        
                        System.out.print("\nChoice: ");
                        choice = input.nextLine();
                    } while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
                                && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8"));
        
                    if(choice.equals("1")){ //dequeue all numbers until one is more than 100
                        System.out.println("\n");
                        dequeueTill100(queue1);
                    }
        
                    else if(choice.equals("2")){ //determine product of dequeued numbers
                        System.out.print("\nProduct of the dequeued numbers: " + product);
                    }
        
                    else if(choice.equals("3")){ //display current queue
                        System.out.println("\n\n" + queue1);
                    }
        
                    else if(choice.equals("4")){ //display number of elements left in the queue
                        System.out.println("\nCurrent size of queue: " + queue1.getSize());
                    }
        
                    else if(choice.equals("5")){ //add a number to the end of the queue
                        System.out.println("\nWhat number would you like to add to the queue?");
                        queue1.enqueue(input.nextInt());
                        input.nextLine();
        
                    }
        
                    else if(choice.equals("6")){ //removes a number from the front of the queue
                        queue1.dequeue();
                    }

                    else if(choice.equals("7")){ //makes the queue empty
                        queue1.makeEmpty();
                    }
        
                    else if(choice.equals("8")){ //exits the queues program
                        qFlag = false;
                    }   
                }

            }

            else if(option.equals("2")){ //linked lists
                String choice = "";
                fillList(list1);

                while(LFlag){
                    do{
                        System.out.println("\n\n===============Please select an option from the Linked Lists menu below=============== \n" + 
                            "\n1. Determine the book that appears first alphabetically" +
                            "\n2. Determine the book that was published most recently" + 
                            "\n3. Display current list of books" + 
                            "\n4. Add a book to the list" +
                            "\n5. Remove a book from the list" + 
                            "\n6. Sort the books by alphabetical order" +
                            "\n7. Sort the books by year of publication" +
                            "\n8. Determine the number of books in the list" +
                            "\n9. Exit Linked Lists");
                            System.out.print("\nChoice: ");
                            choice = input.nextLine();
                    } while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
                        && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8") && !choice.equals("9"));

                        if(choice.equals("1")){ //determine book that appears first alphabetically
                            list1.firstTitle();
                        }
            
                        else if(choice.equals("2")){ //determine book that was published most recently
                            list1.recentYear();
                        }
            
                        else if(choice.equals("3")){ //displays current list of books
                            System.out.println(list1);
                        }
            
                        else if(choice.equals("4")){ //add a book to the list
                            System.out.println("Title of the book to be added to the list: ");
                            String titleToAdd = input.nextLine();

                            System.out.println("\nYear of publication for " + titleToAdd + ": ");
                            int yearToAdd = input.nextInt();
                            input.nextLine();

                            list1.addAtFront(new Book(yearToAdd, titleToAdd));
                        }
            
                        else if(choice.equals("5")){ //removes a book from the list
                            System.out.println("Title of the book to be removed from the list: ");
                            String titleToRemove = input.nextLine();

                            System.out.println("Year of publication of the book to be removed: ");
                            int yearToRemove = input.nextInt();     
                            input.nextLine();

                            list1.remove(new Book(yearToRemove, titleToRemove));
                        }
            
                        else if(choice.equals("6")){ //sort the books in alphabetical order
                            list1.sortByTitle();
                            System.out.println("\n-->Sorted list by alphabetical order: \n" + list1);
                        }

                        else if(choice.equals("7")){ //sort the books by year of publication
                            list1.sortByYear();
                            System.out.println("\n-->Sorted list by year of publication: \n" + list1);
                        }

                        else if(choice.equals("8")){ //determine number of books in the list
                            System.out.println("\nNumber of books in the list: " + list1.getSize());
                        }
            
                        else if(choice.equals("9")){ //exit linked lists
                            LFlag = false;
                        } 
                }
            }

            if(option.equals("3")){ //exit master program
                masterFlag = false;
            }
        }

        System.out.println("Thank you for using the ADS program, goodbye!");
    }

    /*
    * fillQueue() prompts the user to fill up the queue with 10 integers, stores them in the queue object
    *Pre: empty queue object
    *Post: queue object with 10 user inputted integers
    */
    public static Queue fillQueue(Queue queue1){
        System.out.println("\n\nEnter 10 integers to be added to the queue, followed by a line break.");
        for(int i = 0; i<queue1.data.length; i++){
            System.out.println("\nNumber " + (i+1) + ": ");
            queue1.enqueue(Integer.parseInt(input.nextLine()));
        }

        return queue1;
    }

    /*
    *Dequeues each integer in the queue until it reaches an integer that is greater than 100, multiplies
    *product variable by each dequeued number
    *Pre: Queue object that stores a given number of integers
    *Post: Queue object that stores new number of integers, after dequeueing, and returns product of the dequeued numbers
    */
    public static int dequeueTill100(Queue queue1){
        boolean flag = true;
        product = 1; 

        for(int i = 0; i<queue1.data.length && flag; i++){
            if(queue1.getFront() > 100){  
                flag = false;
            }

            else if(queue1.isEmpty()){
                System.out.println("Cannot dequeue, queue is currently empty!");
                return product;
            }

            else{
                product *= queue1.getFront();
                queue1.dequeue();   
            }
        }

        return product;
    }

    /*
    * Prompts the user to enter 5 books, done through the filling of a LinkedList with Book objects that 
    store the year of publication and the book title
    *Pre: Empty Linked List with null head
    *Post: Linked List with 5 Nodes that each contain a Book and its properties
    */
    public static LinkedList fillList(LinkedList list1){
        String bookTitle;
        int yearPub;

        System.out.println("Enter 5 books to be added to the list, including title and year of publication.");

        for(int i = 1; i <= 5; i++){
            System.out.println("\n\nTitle of book " + i + ": ");
            bookTitle = input.nextLine();
            System.out.println("Year of publication for " + bookTitle + ": ");
            yearPub = input.nextInt();
            input.nextLine();

            list1.addAtFront(new Book(yearPub, bookTitle));
            
        }

        return list1;
    }


}
