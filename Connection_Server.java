public class Connection_Server {
    // empty class
}

interface InternetConnection {
    void connect();
}

interface WebServer {
    void configure();
}

class WiFiConnection implements InternetConnection {
    public void connect() {
        System.out.println("wifi connection has been built for the system");
    }
}

class GSMConnection implements InternetConnection {
    public void connect() {
        System.out.println("GSM connection has been built for the system");
    }
}

class EthernetConnection implements InternetConnection {
    public void connect() {
        System.out.println("Ethernet connection has been built for the system");
    }
}


class DjangoWebServer implements WebServer {
    public void configure() {
        System.out.println("Django web server has been configured into the system");
    }
}

class NodeJSWebServer implements WebServer {
    public void configure() {
        System.out.println("NodeJS web server has been configured into the system");
    }
}

class RubyWebServer implements WebServer {
    public void configure() {
        System.out.println("Ruby web server has been configured into the system");
    }
}

// interface for factory
class InternetConnectionFactory {

    InternetConnection createConnection(String connectionType) {
        if (connectionType.equalsIgnoreCase("WiFi")) {
            return new WiFiConnection();
        } else if (connectionType.equalsIgnoreCase("GSM")) {
            return new GSMConnection();
        } else if (connectionType.equalsIgnoreCase("Ethernet")) {
            return new EthernetConnection();
        }
        return null;
        
    }
}

class WebServerFactory {
    WebServer createWebServer(String serverType) {
        if (serverType.equalsIgnoreCase("Ruby"))
            return new RubyWebServer();
        else if (serverType.equalsIgnoreCase("NodeJS"))
            return new NodeJSWebServer();
        else if (serverType.equalsIgnoreCase("Django"))
            return new DjangoWebServer();
        return null;
    }
}
