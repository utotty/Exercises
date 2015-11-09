package main;

public class Hira extends Handler {
	private String names;

    public Hira(String names) {
    	this.names = names;
    }

    public void request(String position) {
    	if (position.equals("一般社員")) {
    		System.out.print(" " + names);
    		next.request(position);
    	} else {
    		next.request(position);
    	}
    }
}
