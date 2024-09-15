import java.util.Scanner;

public class client{
    public static void main(String args[]){
        System.out.println("We have four type of packages for the client:\n");
        System.out.println("********************************");
        System.out.println("Basic : ATMega32 with LCD display");
        System.out.println("Standard : Arduino Mega with LED display ");
        System.out.println("Advanced: Raspberry Pi with OLED display");
        System.out.println("Premium: Rasberry Pi with touch screen display");
        System.out.println("********************************");

        int choice;
        //creating a builder reference
        Builder builder;
        Scanner sc=new Scanner(System.in);;
        System.out.println("Enter your choice: ");
        System.out.println("1 for Basic,2 for Standard,3 for Advanced,4 for Premium");
        choice=sc.nextInt();
        System.out.println("********************************");
        //1 for basic,2 for advanced,3 for standard,4 for premium

        switch(choice){
            case 1:
                System.out.println("You have selected Basic package");
                System.out.println("ATMega32 with LCD display");
                builder=new BasicBuilder();
                break;
            case 2:
                System.out.println("You have selected Standard package");
                System.out.println("Arduino Mega with LED display");
                builder=new StandardBuilder();
                break;
            case 3:
                System.out.println("You have selected Advanced package");
                System.out.println("Raspberry Pi with OLED display");
                builder=new AdvancedBuilder();
                break;
            case 4:
                System.out.println("You have selected Premium package");
                System.out.println("Raspberry Pi with touch screen display");
                builder=new PremiumBuilder();
                break;
            default:
                System.out.println("Invalid choice");
                builder=null;
        }

        System.out.println("********************************");
        //getting the connection type and also server type for the classes
        String connectionType,serverType;
        System.out.println("Enter the connection type: ");
        //two connection type wifi and gsm
        System.out.println("you can choose between a.wifi and b.gsm");
        connectionType=sc.next();

        //three type of server
        System.out.println("you can choose between a.Django b.NodeJS c.Ruby");

        System.out.println("Enter the server type: ");
        serverType=sc.next();

        Director director=new Director(builder);
        director.build(connectionType,serverType);
        builder.getFinalProduct().showDetails();

    }
}