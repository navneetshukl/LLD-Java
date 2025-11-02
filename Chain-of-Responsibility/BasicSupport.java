public class BasicSupport implements SupportHandler{
    private SupportHandler next;

    @Override
    public void handleRequest(SupportTicket ticket){
        if(ticket.getLevel()==SupportTicket.TicketLevel.BASIC){
            System.out.println("Basic Support: Handling - "+ticket.getMesssage());
        } else if(next!=null){
            System.out.println("Basic Support: Cannot handle, passing to next...");
            next.handleRequest(ticket);
        } else{
            System.out.println("Basic Support: No one can handle this ticket!");
        }
    }

    @Override
    public void setNext(SupportHandler nextHandler){
        this.next=nextHandler;
    }
}