public class SupportTicket{
    private final String message;
    private final TicketLevel level;

    public SupportTicket(String message,TicketLevel level){
        this.message=message;
        this.level=level;
    }

    public String getMesssage(){
        return message;
    }

    public TicketLevel getLevel(){
        return level;
    }

    public enum TicketLevel{
        BASIC,INTERMEDIATE,ADVANCED
    }
}