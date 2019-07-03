/*
  Federico Rubino
  frubino
  HashTable
  Assignment #5
  Record.java
  working/tested
*/

public class Record{

    //constructor
    public Record(){
	ID = 0;
	data = "";
    }

    //constructor with parameters
    public Record(int key, String data){
        ID = key;
        this.data = data;
    }

    // returns a clone
    public Record clone(){
	Record copy = new Record();
	copy.data = data;
	copy.ID = ID;
	return copy;
    }

    // returns ID
    public int getID(){
	return ID;
    }

    //returns data as a String
    public String getData(){
	return data;
    }

    //member variables
    private int ID;
    private String data;

} //class
