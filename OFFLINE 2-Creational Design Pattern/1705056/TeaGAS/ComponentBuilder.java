import Connection.Ethernet;
import Connection.GSM;
import Connection.WiFi;
import Packages.Diamond;
import Packages.Gold;
import Packages.Platinum;
import Packages.Silver;
import WebServer.Django;
import WebServer.Laravel;
import WebServer.Spring;

class ComponentBuilder {

    private boolean setPackage(String packageName, Components components) {
        if (packageName.equalsIgnoreCase ("Silver")) {
            components.setaPackage (new Silver ());
        }
        else if (packageName.equalsIgnoreCase ("Gold")) {
            components.setaPackage (new Gold ());
        }
        else if (packageName.equalsIgnoreCase ("Diamond")) {
            components.setaPackage (new Diamond ());
        }
        else if (packageName.equalsIgnoreCase ("Platinum")) {
            components.setaPackage (new Platinum ());
        }
        else {
            return false;
        }
        return true;
    }

    private boolean setConnection(String connection, Components components) {
        if (connection.equalsIgnoreCase ("WiFi")) {
            components.setConnection (new WiFi ());
        }
        else if (connection.equalsIgnoreCase ("Ethernet")) {
            if (!components.getaPackage ().hardware ().microcontroller ().name ().equals ("Raspberry Pi")) {
                return false;
            }
            components.setConnection (new Ethernet ());
        }
        else if (connection.equalsIgnoreCase ("GSM")) {
            components.setConnection (new GSM ());
        }
        else {
            return false;
        }
        return true;
    }

    private boolean setWebserver(String webServer, Components components) {
        if (webServer.equalsIgnoreCase ("Django")) {
            components.setWebServer (new Django ());
        }
        else if (webServer.equalsIgnoreCase ("Spring")) {
            components.setWebServer (new Spring ());
        }
        else if (webServer.equalsIgnoreCase ("Laravel")) {
            components.setWebServer (new Laravel ());
        }
        else {
            return false;
        }
        return true;
    }

    public Components buildComponents(String packageName, String connection, String webServer) {
        Components components = new Components ();
        if (!setPackage (packageName, components)) {
            System.out.println ("Invalid Package!");
            return null;
        }
        if (!setConnection (connection, components)) {
            System.out.println ("Invalid Connection!");
            return null;
        }
        if (!setWebserver (webServer, components)) {
            System.out.println ("Invalid WebServer!");
            return null;
        }
        return components;
    }

}
