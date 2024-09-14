import java.util.Scanner;

public class TicketingSystem {
    private DisplayUnit displayUnit;
    private String identification;
    private String paymentTerminal;
    private InternetConnection internetConnection;
    private String storage;
    private String controller;
    private WebServer webServer;

    // Setters
    public void setDisplayUnit(DisplayUnit displayUnit) {
        this.displayUnit = displayUnit;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setPaymentTerminal(String paymentTerminal) {
        this.paymentTerminal = paymentTerminal;
    }

    public void setInternetConnection(InternetConnection internetConnection) {
        this.internetConnection = internetConnection;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public void setWebServer(WebServer webServer) {
        this.webServer = webServer;
    }

    // Method to show details of the TicketingSystem
    public void showDetails() {
        System.out.println("Ticketing System Details:");
        System.out.println("Display Unit: " + (displayUnit != null ? displayUnit.toString() : "Not Set"));
        System.out.println("Identification: " + (identification != null ? identification : "Not Set"));
        System.out.println("Payment Terminal: " + (paymentTerminal != null ? paymentTerminal : "Not Set"));
        System.out.println("Internet Connection: " + (internetConnection != null ? internetConnection : "Not Set"));
        System.out.println("Storage: " + (storage != null ? storage : "Not Set"));
        System.out.println("Controller: " + (controller != null ? controller : "Not Set"));
        System.out.println("Web Server: " + (webServer != null ? webServer : "Not Set"));
    }

    public static void main(String[] args) {
        System.out.println("successfully compiled");
    }
}

class DisplayUnit {
    public String microController;
    public String display;

    public void setMicroController(String microController) {
        this.microController = microController;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}

interface Builder {
    void buildDisplayUnit();

    void buildIdentification();

    void buildPaymentTerminal();

    void buildInternetConnection();

    void buildController();

    void buildStorage();

    void buildWebServer();

}

class BasicBuilder implements Builder {
    private TicketingSystem ticketingSystem;

    public BasicBuilder() {
        ticketingSystem = new TicketingSystem();
    }

    @Override
    public void buildDisplayUnit() {
        DisplayUnit displayUnit = new DisplayUnit();
        displayUnit.setMicroController("ATMega32");
        displayUnit.setDisplay("LCD");
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override

    public void buildIdentification() {
        this.ticketingSystem.setIdentification("RFID cards");
    }

    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("Payment terminal has been set up for ticketing system(basic)");
    }

    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your internet connection: ");
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection == "GSM") {
            this.ticketingSystem.setInternetConnection(new GSMConnectionFactory().createConnection());
        } else if (internetConnection == "WIFI") {
            this.ticketingSystem.setInternetConnection(new WiFiConnectionFactory().createConnection());
        } else {
            System.out.println("Invalid");
            this.ticketingSystem.setInternetConnection(null);
        }
        scanner.close();
    }

    public void buildStorage() {
        this.ticketingSystem.setStorage("SD card");
    }

    public void buildController() {
        this.ticketingSystem.setController("Separate Controller Unit has been set up");
    }

    public void buildWebServer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your web server framework : ");
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django")) {
            this.ticketingSystem.setWebServer(new DjangoWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("NodeJS")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
    }

    public TicketingSystem getFinalProduct() {
        return this.ticketingSystem;
    }

}

class StandardBuilder implements Builder {
    private TicketingSystem ticketingSystem;

    public StandardBuilder() {
        ticketingSystem = new TicketingSystem();
    }

    @Override
    public void buildDisplayUnit() {
        DisplayUnit displayUnit = new DisplayUnit();
        displayUnit.setMicroController("Arduino Mega");
        displayUnit.setDisplay("LED");
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override
    public void buildIdentification() {
        this.ticketingSystem.setIdentification("RFID cards");
    }

    @Override
    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("Payment terminal has been set up for ticketing system(standard)");

    }

    @Override
    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection.equalsIgnoreCase("GSM")) {
            this.ticketingSystem.setInternetConnection(new GSMConnectionFactory().createConnection());
        } else if (internetConnection.equalsIgnoreCase("WIFI")) {
            this.ticketingSystem.setInternetConnection(new WiFiConnectionFactory().createConnection());
        } else {
            System.out.println("Invalid");
            this.ticketingSystem.setInternetConnection(null);
        }
        scanner.close();
    }

    @Override
    public void buildStorage() {
        this.ticketingSystem.setStorage("SD card");
    }

    @Override
    public void buildController() {
        this.ticketingSystem.setController("Separate Controller Unit has been set up");

    }

    @Override
    public void buildWebServer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your web server framework : ");
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django")) {
            this.ticketingSystem.setWebServer(new DjangoWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("NodeJS")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
    }

    public TicketingSystem getFinalProduct() {
        return this.ticketingSystem;
    }
}

class AdvancedBuilder implements Builder {
    private TicketingSystem ticketingSystem;

    public AdvancedBuilder() {
        ticketingSystem = new TicketingSystem();
    }

    @Override
    public void buildDisplayUnit() {
        DisplayUnit displayUnit = new DisplayUnit();
        displayUnit.setMicroController("Raspberry Pi");
        displayUnit.setDisplay("OLED");
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override
    public void buildIdentification() {
        this.ticketingSystem.setIdentification("NFC Cards");
    }

    @Override
    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("Payment terminal has been set up for ticketing system(advanced)");

    }

    @Override
    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection.equalsIgnoreCase("GSM")) {
            this.ticketingSystem.setInternetConnection(new GSMConnectionFactory().createConnection());
        } else if (internetConnection.equalsIgnoreCase("WIFI")) {
            this.ticketingSystem.setInternetConnection(new WiFiConnectionFactory().createConnection());
        } else {
            System.out.println("Invalid");
            this.ticketingSystem.setInternetConnection(null);
        }
        scanner.close();
    }

    @Override
    public void buildStorage() {
        this.ticketingSystem.setStorage("Built in storage is already provided with Rasberry PI");
    }

    @Override
    public void buildController() {
        this.ticketingSystem.setController("Separate Controller Unit has been set up");
    }

    @Override
    public void buildWebServer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your web server framework : ");
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django")) {
            this.ticketingSystem.setWebServer(new DjangoWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("NodeJS")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
    }

    public TicketingSystem getFinalProduct() {
        return this.ticketingSystem;
    }
}

class PremiumBuilder implements Builder {
    private TicketingSystem ticketingSystem;

    public PremiumBuilder() {
        ticketingSystem = new TicketingSystem();
    }

    @Override
    public void buildDisplayUnit() {
        DisplayUnit displayUnit = new DisplayUnit();
        displayUnit.setMicroController("Rasberry PI");
        displayUnit.setDisplay("Touch screen");
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override
    public void buildIdentification() {
        this.ticketingSystem.setIdentification("NFC cards");
    }

    @Override
    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("Payment terminal has been set up for ticketing system(premium)");
    }

    @Override
    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection.equalsIgnoreCase("GSM")) {
            this.ticketingSystem.setInternetConnection(new GSMConnectionFactory().createConnection());
        } else if (internetConnection.equalsIgnoreCase("WIFI")) {
            this.ticketingSystem.setInternetConnection(new WiFiConnectionFactory().createConnection());
        } else {
            System.out.println("Invalid");
            this.ticketingSystem.setInternetConnection(null);
        }
        scanner.close();
    }

    @Override
    public void buildStorage() {
        this.ticketingSystem.setStorage("Built in storage is already provided with Rasberry PI");
    }

    @Override
    public void buildController() {
        this.ticketingSystem.setController("Touch screen is already setup as a controller");
    }

    @Override
    public void buildWebServer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your web server framework : ");
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django")) {
            this.ticketingSystem.setWebServer(new DjangoWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("NodeJS")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else if (framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(new NodeJSWebServerFactory().createWebServer());
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
    }

    public TicketingSystem getFinalProduct() {
        return this.ticketingSystem;
    }
}

class Director {
    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void build() {
        builder.buildDisplayUnit();
        builder.buildIdentification();
        builder.buildPaymentTerminal();
        builder.buildInternetConnection();
        builder.buildStorage();
        builder.buildController();
        builder.buildWebServer();
    }
}
