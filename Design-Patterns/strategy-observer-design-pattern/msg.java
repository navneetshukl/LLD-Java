
class msg implements notification {

    String to;

    public msg(String to) {
        this.to = to;
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending message to " + to);
    }

}
