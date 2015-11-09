package main;

public class Kacho extends Handler {
	private String names;

    public Kacho(String names) {
    	this.names = names;
    }

    public void request(String position) {
    	if (position.equals("一般社員") || position.equals("課長")) {
    		System.out.print(" " + names);
    		next.request(position);
    	} else {
    		next.request(position);
    	}
    }
}
