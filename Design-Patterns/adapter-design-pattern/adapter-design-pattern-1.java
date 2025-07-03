// Target Interface (expected by the new system)
interface ModernPrinter {
    void printFormatted(String text);
}

// Adaptee (legacy class with incompatible interface)
class OldPrinter {
    public void printText(String text) {
        System.out.println("Printing: " + text);
    }
}

// Adapter (bridges OldPrinter to ModernPrinter)
class PrinterAdapter implements ModernPrinter {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void printFormatted(String text) {
        // Convert the modern request to the legacy format
        String formattedText = "*** " + text + " ***";
        oldPrinter.printText(formattedText);
    }
}

// Client code
class AdapterDemo {
    public static void main(String[] args) {
        // Create instance of legacy printer
        OldPrinter oldPrinter = new OldPrinter();
        
        // Wrap it with the adapter
        ModernPrinter printer = new PrinterAdapter(oldPrinter);
        
        // Use the modern interface
        printer.printFormatted("Hello, World!");
    }
}
/*
### Explanation of Adapter Design Pattern
- Target Interface (ModernPrinter): Defines the interface that the client or new system expects to interact with.
- Adaptee (OldPrinter): The existing legacy class with an incompatible interface that needs to be integrated.
- Adapter (PrinterAdapter): Implements the target interface (ModernPrinter) and internally uses the adaptee (OldPrinter) by converting the client's requests to match the adaptee's interface (e.g., adding formatting to the input).
- Client (AdapterDemo): Interacts with the target interface (ModernPrinter) without any knowledge of the underlying legacy system (OldPrinter).

### Key Points
- The adapter enables compatibility between the OldPrinter and the ModernPrinter interface, allowing the legacy system to work with the new system.
- It promotes reusability by allowing existing code to be used without modification.
- Commonly used in scenarios like integrating third-party libraries, legacy systems, or adapting APIs to new requirements.
 */