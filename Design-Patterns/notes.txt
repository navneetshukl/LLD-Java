For a Low-Level Design (LLD) interview, you should be familiar with design patterns that help structure code in a modular, maintainable, and scalable way. Below is a concise overview of some basic and commonly used design patterns, grouped by their type, relevant for LLD interviews. These patterns are often discussed in the context of object-oriented programming (OOP) and can be applied to real-world system design problems.

---

### 1. Creational Design Patterns
These patterns focus on object creation mechanisms, improving flexibility and reusability.

- **Singleton Pattern**  
  - Purpose: Ensures a class has only one instance and provides a global point of access to it.  
  - Use Case: Database connection pools, logging frameworks, or configuration managers.  
  - Example: A `DatabaseConnection` class that ensures only one connection is created.  
  - Key Points: Use lazy initialization, thread safety (e.g., double-checked locking in Java), and avoid overuse to prevent tight coupling.  

- **Factory Method Pattern**  
  - Purpose: Defines an interface for creating objects but lets subclasses decide which class to instantiate.  
  - Use Case: Creating different types of objects based on input, like payment processors (CreditCard, PayPal).  
  - Example: A `PaymentFactory` that returns a `PaymentProcessor` based on the payment type.  
  - Key Points: Promotes loose coupling and adheres to the Open-Closed Principle.

- **Abstract Factory Pattern**  
  - Purpose: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.  
  - Use Case: UI toolkits for different operating systems (Windows, macOS).  
  - Example: A `GUIFactory` that creates buttons and windows for a specific OS.  
  - Key Points: Useful for systems requiring multiple related objects to work together.

- **Builder Pattern**  
  - Purpose: Separates the construction of a complex object from its representation, allowing step-by-step construction.  
  - Use Case: Constructing objects with many optional parameters, like a `UserProfile` or `HttpRequest`.  
  - Example: A `HouseBuilder` that constructs a house with optional features (garage, pool).  
  - Key Points: Improves readability and handles complex object creation cleanly.

---

### 2. Structural Design Patterns
These patterns focus on composing objects and classes to form larger structures while keeping the system flexible.

- **Adapter Pattern**  
  - Purpose: Allows incompatible interfaces to work together by acting as a bridge.  
  - Use Case: Integrating a legacy system with a modern API.  
  - Example: An `XMLToJSONAdapter` that converts XML data to JSON for a new system.  
  - Key Points: Promotes reusability of existing code without modification.

- **Decorator Pattern**  
  - Purpose: Dynamically adds responsibilities to objects without modifying their code.  
  - Use Case: Adding features to a base object, like toppings on a pizza or filters on a stream.  
  - Example: A `Coffee` class with decorators like `MilkDecorator` or `SugarDecorator`.  
  - Key Points: Follows the Open-Closed Principle and provides flexibility over inheritance.

- **Facade Pattern**  
  - Purpose: Provides a simplified interface to a complex subsystem.  
  - Use Case: Simplifying interaction with a library or framework, like a `BankingFacade` for account operations.  
  - Example: A `MultimediaFacade` that handles audio, video, and subtitles with one interface.  
  - Key Points: Reduces complexity and improves usability for clients.

- **Composite Pattern**  
  - Purpose: Treats individual objects and compositions of objects uniformly in a tree structure.  
  - Use Case: File systems (files and directories) or organizational hierarchies.  
  - Example: A `FileSystemComponent` interface implemented by both `File` and `Directory`.  
  - Key Points: Simplifies client code by treating leaf and composite objects the same.

---

### 3. Behavioral Design Patterns
These patterns focus on communication and interaction between objects, improving flexibility.

- **Observer Pattern**  
  - Purpose: Defines a one-to-many dependency where objects (observers) are notified of state changes in a subject.  
  - Use Case: Event handling systems, like UI button clicks or pub-sub models.  
  - Example: A `NewsAgency` (subject) notifies `Subscribers` (observers) of new articles.  
  - Key Points: Promotes loose coupling but can lead to memory leaks if observers aren’t removed.

- **Strategy Pattern**  
  - Purpose: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.  
  - Use Case: Sorting algorithms or payment strategies (CreditCard, UPI).  
  - Example: A `Navigation` class that switches between `DrivingStrategy` and `WalkingStrategy`.  
  - Key Points: Enables runtime algorithm switching and adheres to the Open-Closed Principle.

- **Command Pattern**  
  - Purpose: Encapsulates a request as an object, allowing parameterization and queuing of requests.  
  - Use Case: Undo/redo operations, task scheduling, or remote control systems.  
  - Example: A `RemoteControl` that executes `Command` objects like `TurnOnTV`.  
  - Key Points: Decouples invoker from receiver and supports undo functionality.

- **Template Method Pattern**  
  - Purpose: Defines the skeleton of an algorithm, allowing subclasses to customize specific steps.  
  - Use Case: Standardizing processes with variable steps, like report generation.  
  - Example: A `DataProcessor` abstract class with a fixed `process()` method and customizable steps.  
  - Key Points: Promotes code reuse and enforces a consistent structure.

- **State Pattern**  
  - Purpose: Allows an object to change its behavior when its internal state changes, appearing as if it changes its class.  
  - Use Case: Vending machines or traffic light systems.  
  - Example: A `VendingMachine` with states like `NoCoinState` and `HasCoinState`.  
  - Key Points: Eliminates large conditional statements and improves maintainability.

---

### Tips for LLD Interviews
1. Understand Requirements: Clarify the problem statement and constraints before jumping into design.  
2. Choose the Right Pattern: Explain why a pattern fits the problem (e.g., Singleton for global access, Strategy for interchangeable algorithms).  
3. Draw UML Diagrams: Be prepared to sketch class diagrams or sequence diagrams to illustrate your design.  
4. Discuss Trade-offs: Mention pros (e.g., flexibility) and cons (e.g., complexity) of the chosen pattern.  
5. Code Snippets: Be ready to write pseudocode or code (e.g., in Java/C++/Python) to implement the pattern.  
6. Common LLD Problems: Practice designing systems like:
   - Parking Lot System (Composite, Factory)
   - Vending Machine (State, Singleton)
   - Library Management System (Observer, Facade)
   - Online Food Delivery (Strategy, Builder)

---

### Example Interview Question
Question: Design a parking lot system.  
Approach:  
- Use Composite Pattern for parking spots (individual spots and floors as composites).  
- Use Factory Pattern to create different types of spots (compact, large, handicapped).  
- Use Singleton Pattern for the parking lot manager to track available spots.  
- Draw a UML diagram showing classes like `ParkingSpot`, `ParkingFloor`, and `ParkingLot`.  
- Discuss scalability (e.g., adding new spot types) and thread safety for the Singleton.

---

### Resources for Practice
- Books: *Design Patterns: Elements of Reusable Object-Oriented Software* (Gang of Four), *Head First Design Patterns*.  
- Websites: LeetCode (system design section), GeeksforGeeks, Refactoring.Guru.  
- Mock Interviews: Platforms like Pramp or InterviewBit for LLD practice.

If you want me to elaborate on any specific pattern, provide a sample problem, or share code examples, let me know!