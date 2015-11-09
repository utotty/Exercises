package main;

public class Shacho extends Handler {
	private String names;

	public Shacho(String names) {
    	this.names = names;
    }

	public void request(String position) {
		System.out.print(" " + names);
    }
}
