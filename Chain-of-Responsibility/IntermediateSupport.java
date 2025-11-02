public class IntermediateSupport implements SupportHandler{
    private SupportHandler next;

    @Override
    public void handleRequest(SupportTicket ticket){
        if(ticket.getLevel()==SupportTicket.TicketLevel.INTERMEDIATE){
            System.out.println("Intermediate Support: Handling - "+ticket.getMesssage());
        } else if(next!=null){
            System.out.println("Intermediate Support: Cannot handle, passing to next...");
            next.handleRequest(ticket);
        } else{
            System.out.println("Intermediate Support: No one can handle this ticket");
        }
    }

    @Override
    public void setNext(SupportHandler nextHandler){
        this.next=nextHandler;
    }
}