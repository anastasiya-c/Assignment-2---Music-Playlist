import java.io.*;

public class Song {

	protected String track;
	protected Song next;


	//constructor
	public Song(String t) {
		track =t;
		next=null;

	}

	//constructor
	public Song(String t, Song s) {
		track =t;
		next=s;
	}

	//method displays the track name
	public void display() {
		System.out.println(track);
	}

	//method prints the track name to the file
	public void display(PrintWriter outFile) {

		outFile.println(track);
	}


}
