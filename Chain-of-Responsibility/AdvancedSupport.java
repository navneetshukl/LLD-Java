public class AdvancedSupport implements SupportHandler{
    private SupportHandler next;

    @Override
    public void handleRequest(SupportTicket ticket){
        if(ticket.getLevel()==SupportTicket.TicketLevel.ADVANCED){
            System.out.println("Advanced Support (Manager): Handling - " + ticket.getMesssage());
        } else if(next!=null){
            next.handleRequest(ticket);
        } else{
            System.out.println("Advanced Support: This is beyond our capacity!");
        }
    }

    @Override
    public void setNext(SupportHandler nexSupportHandler){
        this.next=nexSupportHandler;
    }
}