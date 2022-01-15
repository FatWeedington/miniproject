module btx.prog.one.miniproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.xml;

    opens btx.prog.one.miniproject to javafx.fxml;
    exports btx.prog.one.miniproject.hospital.gui;
    opens btx.prog.one.miniproject.hospital.domain to javafx.fxml;
}