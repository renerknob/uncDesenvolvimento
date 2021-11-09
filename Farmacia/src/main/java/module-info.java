module br.unc.rener.farmacia {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.unc.rener.farmacia to javafx.fxml;
    exports br.unc.rener.farmacia;
}
