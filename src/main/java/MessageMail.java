import sun.misc.Queue;

public class MessageMail {
    String name;
    Queue<String> messageQueqe;

    public MessageMail(String name) {
        this.name = name;
        messageQueqe = new Queue<>();
    }

    public void addMessage(String value){
        messageQueqe.enqueue(value);
        System.out.println(value);
    }

    public String getMessage(){
        if(!messageQueqe.isEmpty()) {
            try {
                return messageQueqe.dequeue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty(){
        return messageQueqe.isEmpty();
    }
}
