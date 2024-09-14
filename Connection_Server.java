public class Connection_Server {
    //empty class
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
        System.out.println("GSM  connection has been built for the system");
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
//interface for factory
interface InternetConnectionFactory{
    InternetConnection createConnection();
}
interface WebServerFactory{
    WebServer createWebServer();
}

class WiFiConnectionFactory implements InternetConnectionFactory {
    public InternetConnection createConnection() {
        return new WiFiConnection();
    }
}

class GSMConnectionFactory implements InternetConnectionFactory {
    public InternetConnection createConnection() {
        return new GSMConnection();
    }
}

class DjangoWebServerFactory implements WebServerFactory{
    public WebServer createWebServer(){
        return new DjangoWebServer();
    }
}

class RubyWebServerFactory implements WebServerFactory{
    public WebServer createWebServer(){
        return new RubyWebServer();
    }
}
class NodeJSWebServerFactory implements WebServerFactory{
    public WebServer createWebServer(){
        return new NodeJSWebServer();
    }
}





