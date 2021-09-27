import Connection.Connection;
import Packages.Package;
import WebServer.WebServer;

class Components {
    private Package aPackage;
    private Connection connection;
    private WebServer webServer;

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public WebServer getWebServer() {
        return webServer;
    }

    public void setWebServer(WebServer webServer) {
        this.webServer = webServer;
    }

    public void show() {
        System.out.println ("Microcontroller : " + aPackage.hardware ().microcontroller ().name ());
        System.out.println ("Weight Measurement : " + aPackage.weightMeasurement ().option ());
        System.out.println ("Identification : " + aPackage.hardware ().identification ().CardType ());
        System.out.println ("Storage : " + aPackage.hardware ().storage ().type ());
        System.out.println ("Display : " + aPackage.hardware ().display ().type ());
        System.out.println ("Internet connection : " + connection.type ());
        System.out.println ("Controller : " + aPackage.hardware ().controller ().type ());
        System.out.println ("Web Server : " + webServer.name ());
        System.out.println ();
    }
}
