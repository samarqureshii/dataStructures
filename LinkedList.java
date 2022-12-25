/*
* This program stores the relevant modifier and accesor methods of the LinkedList structure, which contains 
*individual Node objects. Additional helper methods allow user to retrieve certain information regarding the list
*Name: Samar Qureshi
*Date: Dec 25/2021
Course: ICS4U
*/

package com.company.dataStructure;

public class LinkedList {
    private static Node head; //head of the list
    private int size; //the size of the linked list

    public LinkedList(){
        //constructor that contains general initial info about the list
        head = null;
        size = 0;
    }

    /*
    * Returns the number of Nodes in the LinkedList
    *Pre: nothing
    *Post: size of the list
    */
    public int getSize(){
        return size;
    }

    /*
    *Adds a Book object to the front of the list by setting the head to the Node created to store the new Book
    *Pre: Linked list with given Nodes storing each of the Books
    *Post: Updated LinkedList with the added Book stored in a new Node
    */
    public void addAtFront(Book newBook){
        Node newNode = new Node(newBook);
        newNode.setNext(head);
        head = newNode; //only access to the list is from the head

        System.out.println("\nAdded " + newBook.getTitle() + " to the list.");
        size++;
    }

    /*
    *Removes a Book object from any location in the list by iterating through every Node, and if the Book the 
    *user wishes to remove is in the list, the pointers of the list "skip over", omitting that particular Node
    *Pre: Linked List with givenNodes storing each of the Books
    *Post: Updated LinkedList with the omission of the particular Book
    */
    public Book remove(Book bookToRemove){
        Node current = head;

        if(isEmpty()){ //if the head is null
            System.out.println("No books to remove!");
            return bookToRemove;
        }

        if(current.getBook().equals(bookToRemove)){
            //if the book to remove is found in the head
            head = current.getNext(); //the head becomes the next Node
            System.out.println("\nRemoved " + bookToRemove.getTitle() + " from the list.");
            size--; //number of Nodes decreases
            return bookToRemove;
        }

        while(current.getNext() != null && !isEmpty()){ //iterating through every Node until the end of the list

            if(current.getNext().getBook().equals(bookToRemove)){ // if the Book that needs to be removed is found 
                Node temp = current.getNext();
                current.setNext(temp.getNext()); //current Node is set to the next next Node 
                System.out.println("\nRemoved " + bookToRemove.getTitle() + " from the list.");
                size--; //number of Nodes decreases
                return bookToRemove;
            }
            
            current = current.getNext(); //iterating through every Node
        }
       
        System.out.println("\nLooks like '" + bookToRemove.getTitle() + "' (" + bookToRemove.getYear() + ")" 
        + " is not in the list!");
        return bookToRemove;
    }

    /*
    * Displays every Book object in the list 
    *Pre: nothing
    *Post: Each Book is printed out elegantly on multiple lines 
    */
    public String toString(){
        Node current = head;
        String info = "\n->>Current list of books:";

        if(isEmpty()){ //if the list is empty
            return "There appears to be no books in your list.";
        }

        info += current.toString();

        while(current.getNext() != null){ 
            //while the next node is not null, loop through the nodes
            current = current.getNext();
            info += current.getBook(); //information from each book is added to info
        }

        return info; //returns growing info chain
    }

    /*
    *Determines if the list is empty or not
    *Pre: nothing
    *Post: returns a true or false boolean based on the data in the head of the list
    */
    public boolean isEmpty(){
        if(head == null || head.getNext() == null){ //no elements in the list
            return true;
        }
        return false;
    }

    /*
    *Determines the Book that appears first alphabetically in the list 
    *Pre: nothing
    *Post: Returns the title that appears first lexicographically
    */
    public Book firstTitle(){
        Node current = head;
        Book first = head.getBook();

        while(current != null){ //loops through all the nodes until the current one is null, in which there are no more Nodes
            if(current.getBook().getTitle().compareToIgnoreCase(first.getTitle()) < 0){
                //if the current book appears "ahead" of the next book
                first = current.getBook();
            }

            current = current.getNext(); //iterating through all the Nodes in the list
        }

        System.out.println("\nThe book that appears first alphabetically in the list is '" + first.getTitle() + "'.");
        return first;
    }

    /*
    *Determines the Book that was published most recently
    *Pre: nothing
    *Post: Returns the Book who has the greatest year of publication
    */
    public Book recentYear(){
        Node current = head;
        Book mostRecent = head.getBook();

        while(current != null){ //iterates through all the Nodes until one of them is null
            if(current.getBook().getYear() > mostRecent.getYear()){
                //if the current year is more recent than that of the previously most recent Book
                mostRecent = current.getBook();
            }

            current = current.getNext(); //iterating through the books
        }

        System.out.println("\nThe book that was published most recently in the list is '" + mostRecent.getTitle() 
        + "' (" + mostRecent.getYear() + ")");
        return mostRecent;
    }

    /*
    *Sorts Books by year of publication
    *Pre: nothing
    *Post: Sorted list with books arranged from old to new in terms of year of publication
    */
    public void sortByYear(){
        if (head == null || head.getNext() == null) {
            //if there are no Books to sort
            return;
        }

        for (Node iter = head; iter != null; iter = iter.getNext()) {
            //stops iterating through the Nodes when the list has been exhausted

            Node prev = null;
            Node current = head;

            for (Node next = current.getNext(); next != null; next = current.getNext()) { 
                //stops iterating through the Nodes when the next Node is null
                if (current.getBook().getYear() > next.getBook().getYear()) {
                    //if a more recent book was found, swap the Nodes
                    if (prev == null) {
                        //first run through
                        head = next;
                    } 
                    
                    else {
                        //every other run through case
                        prev.setNext(next);
                    }

                    //itereting through each Node while keeping track of the current, next, and previous Nodes
                    current.setNext(next.getNext());
                    next.setNext(current);
                    prev = next;

                } 
                
                else { //if the Nodes do not need to be swapped
                    prev = current;
                    current = next;
                }

            }
        }
    }

    /*
    *Sorts Books lexicographically by title 
    *Pre: nothing
    *Post: Sorted list with books arranged in alphabetical order 
    */
    public void sortByTitle(){
        if (head == null || head.getNext() == null) {
            //if there are no Books to sort
            return;
        }

        for (Node iter = head; iter != null; iter = iter.getNext()) {
            //stops iterating through the Nodes when the list has been exhausted

            Node prev = null;
            Node current = head;

            for (Node next = current.getNext(); next != null; next = current.getNext()) { 
                //stops iterating through the Nodes when the next Node is null
                if (current.getBook().getTitle().compareTo(next.getBook().getTitle()) > 0) {
                    //if comparison returns a value less than 0, swap the Nodes
                    if (prev == null) {
                        //first run through
                        head = next;
                    } 
                    
                    else {
                        //every other run through case
                        prev.setNext(next);
                    }

                    //itereting through each Node while keeping track of the current, next, and previous Nodes
                    current.setNext(next.getNext());
                    next.setNext(current);
                    prev = next;

                } 
                
                else { //if the Nodes do not need to be swapped
                    prev = current;
                    current = next;
                }

            }
        }
    }

    /*
    * Each Node object creates a new Book object that corresponds to its location in the LinkedList
    */
    public class Node{
        private Node next;
        private Book book;

        public Node(Book newBook){
            //associates a Book object with each Node
            book = newBook;
            next = null; //always points to a null object
        }
        
        /*
        * Modifier method that allows the title and year of the Book object to be set at once
        *Pre: nothing
        *Post: Book contains new info such as year and title
        */
        public void setBook(int newYear, String newTitle){
            book.setYear(newYear);
            book.setTitle(newTitle);    
        }

        /*
        * Modifier method that sets information for the next Node in relation to the current Node
        *Pre: nothing
        *Post: next Node is set with given info
        */
        public void setNext(Node newNode){
            next = newNode;
        }

        /*
        * Accessor method that returns the next Node in the list
        *Pre: nothing
        *Post: returns next Node in the list
        */
        public Node getNext(){
            return next;
        }

        /*
        * Accessor method that returns a Book in relation to a given Node
        *Pre: nothing
        *Post: returns Book
        */
        public Book getBook(){
            return book;
        }

        /*
        * Elegantly displays the information from the Book as a String
        *Pre: nothing
        *Post: String display of a given Book
        */
        public String toString(){
            return book.toString();
        }

    }
}
