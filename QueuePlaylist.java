import java.util.*;
import java.io.*;


public class QueuePlaylist {

	protected Song head;
	protected Song tail;
	protected int size;

	//constructor
	public QueuePlaylist() {
		head=null;
		tail=null;
		size=0;
	}


	//method checks if the queue has elements in it 
	public boolean isEmpty()
	{
		return (size == 0);
	}

	//adds an element to the end of the queue
	public void enqueue(String s) {

		Song ss = tail; //store the previous tail Song into ss 
		tail = new Song (s, null); //create a new Song and make it the tail
		if (isEmpty()) 
		{
			head = tail;
		}
		else 
		{
			ss.next = tail;
		}
		size++;
	}


	//deleted an element from the beginning of the queue
	public Song dequeue() {

		Song temp=head;
		head=head.next;
		size--;
		return temp;

	}


	/*method merges 4 LinkedLists into a queue, preserving the alphabetical order and avoiding duplicates
	 * Input:
	 * 4 sorted LinkedLists 
	 * Process:
	 * Creates a HashSet and adds elements from the LL's to the set (HashSet used to avoid duplicates)
	 * Creates an ArrayList and moves elements from the set into it (ArrayList used to implement Collections.sort later)
	 * Sorts the ArrayList
	 * Moves the elements from the array into a queue
	 * Output:
	 * Returns a sorted queue without duplicates
	 * */

	public QueuePlaylist merge(Playlist a, Playlist b, Playlist c, Playlist d) {


		//use set to avoid duplicates
		Set<String> list = new HashSet<String>();

		//add elements from the first LinkedList to the set
		Song current = a.first;
		while (current!=null) {

			list.add(current.track);
			current=current.next;

		}

		//add elements from the 2nd LL to the set
		current = b.first;
		while (current!=null) {

			list.add(current.track);
			current=current.next;

		}

		//add elements from the 3rd LL to the set
		current = c.first;
		while (current!=null) {

			list.add(current.track);
			current=current.next;

		}

		//add elements from the 4th LL to the set
		current = d.first;
		while (current!=null) {

			list.add(current.track);
			current=current.next;

		}

		//create a new queue
		QueuePlaylist myList= new QueuePlaylist();

		//create an ArrayList and move the elements from set into it
		ArrayList<String> array = new ArrayList<String>(list);

		//use the sort function to establish the alphabetical order which was lost while adding elements to the set
		Collections.sort(array, String.CASE_INSENSITIVE_ORDER);

		//add the elements of the array to the queue
		for (String str: array) {
			myList.enqueue(str);

		}

		return myList; //return the queue

		/* IGNORE THE COMMENTED PART

		 * Song t1 = a.first;
	Song t2= b.first;

	QueuePlaylist mergedList = new QueuePlaylist();

	while (t1.next!=null && t2.next!=null) {
		if (t1.track.compareToIgnoreCase(t2.track)<0) {
			mergedList.enqueue(t1.track);
			mergedList.enqueue(t2.track);

		}

		else if (t1.track.compareToIgnoreCase(t2.track)==0) {
			mergedList.enqueue(t1.track);
		}
		else {
			mergedList.enqueue(t2.track);
			mergedList.enqueue(t1.track);

		}
		t1=t1.next;
		t2=t2.next;
	}

	Set<String> set = new HashSet<String>();
	Song cur = mergedList.head;
	for (int i=0; i<mergedList.size; i++) {
		set.add(cur.track);
		cur=cur.next;
	}

	QueuePlaylist myList= new QueuePlaylist();

	for (String str: set) {
		myList.enqueue(str);
	}

	return myList;
		 */
	}



	//method prints the name of all tracks to the screen
	public void display() {


		Song current = head; // start at beginning of list

		while(current != null) // until end of list,
		{
			current.display(); // print data
			current = current.next; // move to next link

		}

	}

	//prints the name of all tracks to the file
	public void display(PrintWriter outFile) {


		Song current = head; // start at beginning of list


		outFile.println ("Your merged playlist for the past weeks: ");
		outFile.println();

		while(current != null) // until end of list,
		{
			current.display(outFile); // print data
			current = current.next; // move to next link

		}

	}
}
