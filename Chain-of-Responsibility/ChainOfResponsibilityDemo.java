public class ChainOfResponsibilityDemo{
    public static void main(String[] args) {
        SupportHandler basic=new BasicSupport();
        SupportHandler intermediate=new IntermediateSupport();
        SupportHandler advanced=new AdvancedSupport();

        basic.setNext(intermediate);
        intermediate.setNext(advanced);

        SupportTicket ticket1=new SupportTicket("Printer not working",SupportTicket.TicketLevel.BASIC);
        SupportTicket ticket2=new SupportTicket("Server down in production",SupportTicket.TicketLevel.INTERMEDIATE);
        SupportTicket ticket3 = new SupportTicket(
            "Database corruption", SupportTicket.TicketLevel.ADVANCED);
        SupportTicket ticket4 = new SupportTicket(
            "Unknown alien invasion", SupportTicket.TicketLevel.ADVANCED);

            System.out.println("=== Submitting Tickets ===");
        basic.handleRequest(ticket1);
        System.out.println();
        basic.handleRequest(ticket2);
        System.out.println();
        basic.handleRequest(ticket3);
        System.out.println();
        basic.handleRequest(ticket4);
    }
}