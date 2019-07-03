/*
  Federico Rubino
  frubino
  Assignment #5
  Hash Table
  p5.java
  working/ tested
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

//main: interface for the hashmap with menu
//uses switch cases for the different options
public class p5{

    public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	hashTable hash = new hashTable(178000);
	boolean run = true;
	int tempKey;
	String tempData;
	while(run){
	    System.out.print("(1)load (2)insert (3)delete (4)search (5)clear (6)save (7)quit -- Your choice? ");
	    int option = input.nextInt();

	    switch (option){
	    case 1: //load
		System.out.print("read hash table - filename? ");
		String filename = input.next();
		try{
		    Scanner fileInput = new Scanner(new File(filename));
		    while(fileInput.hasNextLine()){
			tempKey = fileInput.nextInt();
			tempData = fileInput.nextLine();
			//inserting new Records
			Record tempR = new Record(tempKey, tempData);
			hash.insert(tempR);
		    }
		    fileInput.close();
		} catch(Exception e){
		    System.err.println(filename + ": File not found!");
		}
		break;
		    
	    case 2: //insert
		System.out.println("input new record:");
		tempKey = input.nextInt();
		tempData = input.nextLine();
		Record tempR2 = new Record(tempKey, tempData);
		hash.insert(tempR2);
		break;
		
	    case 3: //delete
		System.out.print("delete record - key?" );
		int deleteKey = input.nextInt();
		Record toBeDel = hash.search(deleteKey);
		if(toBeDel != null){
		    System.out.printf("%nDelete: %09d%s%n", toBeDel.getID(), toBeDel.getData());
		    hash.delete(deleteKey);
		} else {
		    System.out.printf("%nDelete not found: %09d%n", deleteKey);
		}
		break;
		
	    case 4: //search
		System.out.print("search for record - key?" );
		int searchKey = input.nextInt();
		Record searchRec = hash.search(searchKey);
		if(searchRec != null){
		    System.out.printf("%nFound: %09d%s%n", searchRec.getID(), searchRec.getData());
		} else {
		    System.out.printf("%nSearch not found: %09d%n", searchKey);
		}
		break;
		
	    case 5: //clear
		hash.clear();
		System.out.println("clearing hash table");
		break;
		
	    case 6: //save
		System.out.print("write hash table - filename? ");
		String writeFile = input.next();
		try{
		    FileWriter fileWriter = new FileWriter(writeFile);
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    ArrayList<Record> allData = hash.getAllData();
		    for(int i = 0; i < allData.size(); i++){
			Record tempRec = allData.get(i);
			printWriter.printf("%09d%s%n", tempRec.getID(), tempRec.getData());
		    }
		    printWriter.close();
		} catch(IOException e ){
		    System.err.println(writeFile + ": File not found!");
		}
		break;
		
	    case 7:  //quit
		run = false;
		break;
	    default: 
		System.out.println("invalid option");
		break;
	    }//switch
	}//while
	input.close();
    }
}
