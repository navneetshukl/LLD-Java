// Target interface - what our application expects
interface Database {
    void connect();
    void executeQuery(String query);
    void disconnect();
}

// Legacy MySQL class with different method names
class LegacyMySQLDatabase {
    public void mysqlConnect() {
        System.out.println("Connecting to MySQL database...");
    }
    
    public void mysqlQuery(String sql) {
        System.out.println("Executing MySQL query: " + sql);
    }
    
    public void mysqlDisconnect() {
        System.out.println("Disconnecting from MySQL database");
    }
}

// Third-party PostgreSQL class with different interface
class PostgreSQLConnector {
    public void establishConnection() {
        System.out.println("Establishing PostgreSQL connection...");
    }
    
    public void runSQL(String statement) {
        System.out.println("Running PostgreSQL statement: " + statement);
    }
    
    public void closeConnection() {
        System.out.println("Closing PostgreSQL connection");
    }
}

// Adapter for MySQL
class MySQLAdapter implements Database {
    private LegacyMySQLDatabase mysqlDb;
    
    public MySQLAdapter(LegacyMySQLDatabase mysqlDb) {
        this.mysqlDb = mysqlDb;
    }
    
    @Override
    public void connect() {
        mysqlDb.mysqlConnect();
    }
    
    @Override
    public void executeQuery(String query) {
        mysqlDb.mysqlQuery(query);
    }
    
    @Override
    public void disconnect() {
        mysqlDb.mysqlDisconnect();
    }
}

// Adapter for PostgreSQL
class PostgreSQLAdapter implements Database {
    private PostgreSQLConnector postgresDb;
    
    public PostgreSQLAdapter(PostgreSQLConnector postgresDb) {
        this.postgresDb = postgresDb;
    }
    
    @Override
    public void connect() {
        postgresDb.establishConnection();
    }
    
    @Override
    public void executeQuery(String query) {
        postgresDb.runSQL(query);
    }
    
    @Override
    public void disconnect() {
        postgresDb.closeConnection();
    }
}

// Client code that works with any database
class DatabaseManager {
    public void performDatabaseOperations(Database db) {
        db.connect();
        db.executeQuery("SELECT * FROM users");
        db.executeQuery("UPDATE users SET active = true");
        db.disconnect();
    }
}

// Demo
 class DatabaseAdapterDemo {
    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        
        System.out.println("=== Using MySQL ===");
        LegacyMySQLDatabase mysql = new LegacyMySQLDatabase();
        Database mysqlAdapter = new MySQLAdapter(mysql);
        manager.performDatabaseOperations(mysqlAdapter);
        
        System.out.println("\n=== Using PostgreSQL ===");
        PostgreSQLConnector postgres = new PostgreSQLConnector();
        Database postgresAdapter = new PostgreSQLAdapter(postgres);
        manager.performDatabaseOperations(postgresAdapter);
    }
}