
class email implements notification {

    String toAddress;

    public email(String toAddress) {
        this.toAddress = toAddress;
    }

    @Override
    public void sendNotification() {
        System.out.println("Sending Email to " + toAddress);

    }
}
