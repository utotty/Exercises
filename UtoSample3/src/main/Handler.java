package main;

public abstract class Handler {
    protected Handler next;

    protected String staffNames = "";

    public Handler setNext(Handler handler) {
        this.next = handler;
        return handler;
    }

    public abstract void request(String position);
}
