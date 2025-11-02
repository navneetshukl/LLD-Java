public interface SupportHandler{
    void handleRequest(SupportTicket ticket);
    void setNext(SupportHandler nextHandler);
}