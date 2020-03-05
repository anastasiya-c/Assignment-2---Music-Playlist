//Anastasiya Chabotska
//Assignment 2

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class HW2 {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub



		//create an array of files found in the directory the directory
		File [] fileArray = new File(
				"/Users/anastasiyachabotska/Desktop/Workspace/HW 2").listFiles();

		//create output files 

		//the output file to demonstrate a playlist for one of the weeks
		PrintWriter weeklyPlaylist = new PrintWriter("weeklyPlaylist.txt");

		//the output file to demonstrate a merged playlist 
		PrintWriter mergedPlaylist = new PrintWriter ("mergedPlaylist.txt");

		//the output file to demonstrate the listening history
		PrintWriter listeningHistory = new PrintWriter ("listeningHistory.txt");



		//an array of playlists(LinkedLists) for each week 
		ArrayList<Playlist> allWeeks = new ArrayList<>();


		//read-in the track names from the input files
		for (File f : fileArray) {

			//read only csv files found in the directory
			if(f.getName().endsWith(".csv")) {

				Scanner sc = new Scanner(f);

				String line=sc.nextLine();

				//create an empty LinkedList
				Playlist myList = new Playlist();

				while(sc.hasNext()) {

					line = sc.nextLine();

					String[] tokens = line.split(",");

					myList.addSong(tokens[1].replaceAll("\"", ""));

				}

				sc.close();

				//add the playlist to the array
				allWeeks.add(myList);

			}



		}

		//print the playlist for the first week to the file for the purpose of demonstration
		allWeeks.get(0).display(weeklyPlaylist);
		weeklyPlaylist.close();


		//create a new empty playlist (Queue)
		QueuePlaylist myPlaylist = new QueuePlaylist();

		//merge all the weekly playlists into one queue
		myPlaylist = myPlaylist.merge(allWeeks.get(0), allWeeks.get(1), allWeeks.get(2), allWeeks.get(3));



		//print the queue merged playlist to the file for the purpose of demonstration
		myPlaylist.display(mergedPlaylist);
		mergedPlaylist.close();



		//create a listening history(Stack)
		StackListeningHistory songHistory = new StackListeningHistory();

		//listening to all songs in the Queue playlist
		while (!myPlaylist.isEmpty()) {

			//add songs to the stack in an order as they are listened to in the queue
			songHistory.addSong(myPlaylist.dequeue().track);

		}

		//print the listening history to the file
		songHistory.display(listeningHistory);
		listeningHistory.close();




	}



}
