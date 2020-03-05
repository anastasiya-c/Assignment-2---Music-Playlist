import java.io.PrintWriter;

public class StackListeningHistory {

	protected Song top;
	protected int size;


	//constructor
	public StackListeningHistory() {
		top=null;
		size=0;
	}

	//method checks if the Stack is empty
	public boolean isEmpty() {
		return (size==0);
	}

	//the method adds a song to the stack
	public void addSong(String s) {
		Song t = new Song(s, top);
		top=t;
	}


	//the method returns the last listened song (on the top of the stack)
	public Song lastListened() {
		return top;
	}


	//method prints the name of the tracks in the stack to the screen in an order from the last listened 
	public void display() {

		Song cur = top;

		while (cur!=null) {

			cur.display();
			cur=cur.next;

		}
	}


	//method prints the name of the tracks to the file in an order from the last listened 
	public void display(PrintWriter outFile) {

		Song cur = top;

		outFile.println("Your listening history: ");
		outFile.println();

		while (cur!=null) {

			cur.display(outFile);
			cur=cur.next;

		}
	}
}
