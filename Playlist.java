import java.io.*;

public class Playlist {

	protected Song first;

	//no-args constructor
	public Playlist() {
		first = null;

	}


	//method adds song to the LinkedList Playlist in alphabetical order
	public void addSong(String s) {
		Song a = new Song(s);
		Song previous = null; // start at first
		Song current = first;
		// until end of list,
		while (current != null && s.compareToIgnoreCase(current.track)>0)
		{ 
			previous = current;
			current = current.next; // go to next item
		}
		if(previous==null) // at beginning of list
			first = a; 
		else // not at beginning
			previous.next = a; 
		a.next = current; 

	}

	//method prints the names of the tracks in the playlist to the screen
	public void display() {

		Song current = first; // start at beginning of list

		while(current != null) // until end of list,
		{
			current.display(); // print data
			current = current.next; // move to next link
		}

	}

	//method prints the names of the tracks in the playlist to the file 
	public void display(PrintWriter outFile) {

		Song current = first; // start at beginning of list

		outFile.println("Your weekly playlist in ascending order: ");
		outFile.println();

		while(current != null) // until end of list,
		{
			current.display(outFile); // print data
			current = current.next; // move to next link

		}

	}
}
