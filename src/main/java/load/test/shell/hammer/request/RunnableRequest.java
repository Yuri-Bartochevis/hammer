package load.test.shell.hammer.request;

public class RunnableRequest implements Runnable {
    private final Request request;

    public RunnableRequest(Request request) {
        this.request = request;
    }

    public void run() {
        request.make();
    }
}
