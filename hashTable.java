/*
  Federico Rubino
  frubino
  hashTable
  Assignment #5
  working/tested
*/

import java.lang.Math;
import java.util.ArrayList;

public class hashTable{

    //default constructor
    public hashTable(){
	table = new ArrayList<ArrayList<Record>>();
	for(int i = 0; i < m; i++){
	    ArrayList <Record> temp = new ArrayList<Record>();
	    table.add(temp);
	}
    }

    //constructor that takes a size as an argument
    public hashTable(int size){
	m = size;
	table = new ArrayList<ArrayList<Record>>();
	for(int i = 0; i < m; i++){
	    ArrayList <Record> temp = new ArrayList<Record>();
	    table.add(temp);
	}
    }

    //this is for the save functionality 
    //ArralyList filled with only the values
    public ArrayList<Record> getAllData(){
	ArrayList<Record> allData = new ArrayList<Record>();
	for(int i = 0; i < m; i++){ //iterate through the entire hash... O(n)
	    for(int j = 0; j < table.get(i).size(); j++){
		allData.add(table.get(i).get(j));
	    }
	}
	return allData;
    }

    //inserts value into the table
    public void insert(Record rec){
	table.get(hash(rec)).add(rec);
    }

    //deletes value at calculated hash position
    public void delete(int key){
	int hashed = hash(key);
	if(!table.get(hashed).isEmpty()){
	    table.get(hashed).remove(0);
	}
    }

    //clears all the values in the table, without breaking the functionality of the table
    public void clear(){
	for(int i = 0; i < m; i++){
            ArrayList <Record> temp;
            table.get(i).clear();
        }
    }

    //searches for the value that is calcuated in hash
    public Record search(int key){ 
	int hashed = hash(key);
	if(!table.get(hashed).isEmpty()){
	    Record temp = table.get(hashed).get(0);
	    return temp;
	} else{	return null;}
    }

    /* Same as Search()????
    // find return value: some type of index
    private Record find(int key){ 
	return table.get(hash(key)).get(0);
    }
    */

    //calc hash value given object as parameter
    private int hash(Record rec){
	return hash(rec.getID());
	
    }
    
    //calc hash value with given key value
    private int hash(int key){
	return (int) (Math.floor(m * ((key * C) - Math.floor(key * C))));
    }
    
    
    //member variables
    private int m = 100;  
    private double C = (Math.sqrt(5) - 1) / 2;
    private ArrayList<ArrayList<Record>> table;
}

