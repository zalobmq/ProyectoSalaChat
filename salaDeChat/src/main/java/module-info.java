module slc.salaDeChat {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.sun.xml.bind;
    requires jakarta.xml.bind;
    
    opens slc.salaDeChat to javafx.fxml;
    opens modelos to jakarta.xml.bind, com.sun.xml.bind;
    exports slc.salaDeChat;
}
