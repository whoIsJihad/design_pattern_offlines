import java.util.Scanner;

public class TicketingSystem {
	private DisplayUnit displayUnit;
	private String identification;
	private String paymentTerminal;
	private String internetConnection;
	private String storage;
	private String controller;
	private String webServer;

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

	public void setInternetConnection(String internetConnection) {
		this.internetConnection = internetConnection;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public void setWebServer(String webServer) {
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
}
class DisplayUnit{
	String microController;
	String display;
}

interface Builder{
	void buildDisplayUnit();
	void buildIdentification();
	void buildPaymentTerminal();
	void buildInternetConnection();
	void buildController();
	void buildStorage();
	void buildWebServer();

}

class BasicBuilder implements Builder{
	private TicketingSystem ticketingSystem;
	public BasicBuilder(){
		ticketingSystem=new TicketingSystem();
	}
	@Override
	public void buildDisplayUnit(){
		DisplayUnit displayUnit=new DisplayUnit();
		displayUnit.microController="ATMega32";
		displayUnit.display="LCD";
		this.ticketingSystem.setDisplayUnit(displayUnit);
	} 
	@Override

	public void buildIdentification(){
		this.ticketingSystem.setIdentification("RFID cards");
	}

	public void buildPaymentTerminal(){
		this.ticketingSystem.setPaymentTerminal("On spot payment");
	}

	public void buildInternetConnection(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("a.GSM \n b.WIFI\n");
		String internetConnection=scanner.next();
		if(internetConnection=="GSM"){
			this.ticketingSystem.setInternetConnection("GSM");
		}
		else if(internetConnection=="WIFI"){
			this.ticketingSystem.setInternetConnection("WIFI");
		}
		else {
			System.out.println("Invalid");
			this.ticketingSystem.setInternetConnection(null);
		}
		scanner.close();
	}

	public void buildStorage(){
		this.ticketingSystem.setStorage("SD card");
	}
	public void buildController(){
		this.ticketingSystem.setController("Separate Controller Unit");
	}
	public void buildWebServer(){

		Scanner scanner=new Scanner(System.in);
		System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
		String framework=scanner.next();
		if(framework=="Django"||framework=="NodeJS"||framework=="Ruby"){
			this.ticketingSystem.setWebServer(framework);
		}
		else {
			System.err.println("Invalid");
			this.ticketingSystem.setWebServer(null);
		}
		scanner.close();
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
        displayUnit.microController = "Arduino Mega";
        displayUnit.display = "LED";
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override
    public void buildIdentification() {
        this.ticketingSystem.setIdentification("RFID cards");
    }

    @Override
    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("On spot payment");
    }

    @Override
    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection.equalsIgnoreCase("GSM")) {
            this.ticketingSystem.setInternetConnection("GSM");
        } else if (internetConnection.equalsIgnoreCase("WIFI")) {
            this.ticketingSystem.setInternetConnection("WIFI");
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
        this.ticketingSystem.setController("Arduino Controller");
    }

    @Override
    public void buildWebServer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django") || framework.equalsIgnoreCase("NodeJS") || framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(framework);
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
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
        displayUnit.microController = "Raspberry Pi";
        displayUnit.display = "OLED";
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override
    public void buildIdentification() {
        this.ticketingSystem.setIdentification("Fingerprint scanner");
    }

    @Override
    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("Card payment terminal");
    }

    @Override
    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection.equalsIgnoreCase("GSM")) {
            this.ticketingSystem.setInternetConnection("GSM");
        } else if (internetConnection.equalsIgnoreCase("WIFI")) {
            this.ticketingSystem.setInternetConnection("WIFI");
        } else {
            System.out.println("Invalid");
            this.ticketingSystem.setInternetConnection(null);
        }
        scanner.close();
    }

    @Override
    public void buildStorage() {
        this.ticketingSystem.setStorage("64GB SSD");
    }

    @Override
    public void buildController() {
        this.ticketingSystem.setController("Integrated Raspberry Pi");
    }

    @Override
    public void buildWebServer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django") || framework.equalsIgnoreCase("NodeJS") || framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(framework);
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
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
        displayUnit.microController = "Raspberry Pi";
        displayUnit.display = "Touch screen";
        this.ticketingSystem.setDisplayUnit(displayUnit);
    }

    @Override
    public void buildIdentification() {
        this.ticketingSystem.setIdentification("Facial recognition");
    }

    @Override
    public void buildPaymentTerminal() {
        this.ticketingSystem.setPaymentTerminal("Mobile payment integration");
    }

    @Override
    public void buildInternetConnection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.GSM \n b.WIFI\n");
        String internetConnection = scanner.next();
        if (internetConnection.equalsIgnoreCase("GSM")) {
            this.ticketingSystem.setInternetConnection("GSM");
        } else if (internetConnection.equalsIgnoreCase("WIFI")) {
            this.ticketingSystem.setInternetConnection("WIFI");
        } else {
            System.out.println("Invalid");
            this.ticketingSystem.setInternetConnection(null);
        }
        scanner.close();
    }

    @Override
    public void buildStorage() {
        this.ticketingSystem.setStorage("128GB SSD");
    }

    @Override
    public void buildController() {
        this.ticketingSystem.setController("Integrated Raspberry Pi with advanced controller unit");
    }

    @Override
    public void buildWebServer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a.Django \n b.NodeJS \n c.Ruby\n");
        String framework = scanner.next();
        if (framework.equalsIgnoreCase("Django") || framework.equalsIgnoreCase("NodeJS") || framework.equalsIgnoreCase("Ruby")) {
            this.ticketingSystem.setWebServer(framework);
        } else {
            System.err.println("Invalid");
            this.ticketingSystem.setWebServer(null);
        }
        scanner.close();
    }
}


