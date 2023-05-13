import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Interfaz extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JButton btnQuemar;
    private JScrollPane scroll;
    private JTextArea textArea1;
    private JTextField fieldStreet;
    private JTextField fieldCity;
    private JTextField fieldState;
    private JTextField fieldZipCode;
    private JButton btnCrearNuevo;
    private JTextField rFieldStreet;
    private JTextField rFieldCity;
    private JTextField rFieldState;
    private JTextField rFieldZipCode;
    private JTextField fieldRemove;
    private JButton REMOVEButton;
    private JButton btnMostrar;
    private JTextArea areaMostrar;
    private JTextArea areaQuemar;

    private TrackingSystem mtracking = new TrackingSystem();

    public Interfaz() {

        btnQuemar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quemarDatos(mtracking);
                textArea1.setText(mtracking.getPackages().toString());
                scroll.add(textArea1);
                //btnQuemar.setEnabled(false);
            }
        });
        btnCrearNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Address sa = new Address(fieldStreet.getText(),fieldCity.getText(),fieldState.getText(),fieldZipCode.getText());
                Address ra = new Address(rFieldStreet.getText(),rFieldCity.getText(),rFieldState.getText(),rFieldZipCode.getText());
                Package pkg = new Package(sa,ra,LocalDate.now());
                mtracking.addPackage(pkg);
                JOptionPane.showMessageDialog(null, "Creado con exito");
                Limpiar();
            }
        });
        REMOVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean eleccion = mtracking.removePackage(fieldRemove.getText());
                if(eleccion == true){
                    JOptionPane.showMessageDialog(null, "Removido con exito");
                }
                else{
                    JOptionPane.showMessageDialog(null, "El elemento no existe");
                }

            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaMostrar.setText(mtracking.getPackages().toString());
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    public void quemarDatos(TrackingSystem trackingSystem) {

        Address senderAddress1 = new Address("Sender Street 1", "Sender City 1", "Sender State 1", "Sender Zip 1");
        Address recipientAddress1 = new Address("Recipient Street 1", "Recipient City 1", "Recipient State 1", "Recipient Zip 1");
        Package pkg1 = new Package(senderAddress1, recipientAddress1, LocalDate.now());
        trackingSystem.addPackage(pkg1);

        Address senderAddress2 = new Address("Sender Street 2", "Sender City 2", "Sender State 2", "Sender Zip 2");
        Address recipientAddress2 = new Address("Recipient Street 2", "Recipient City 2", "Recipient State 2", "Recipient Zip 2");
        Package pkg2 = new Package(senderAddress2, recipientAddress2, LocalDate.now());
        trackingSystem.addPackage(pkg2);

        Address senderAddress3 = new Address("Sender Street 3", "Sender City 3", "Sender State 3", "Sender Zip 3");
        Address recipientAddress3 = new Address("Recipient Street 3", "Recipient City 3", "Recipient State 3", "Recipient Zip 3");
        Package pkg3 = new Package(senderAddress3, recipientAddress3, LocalDate.now());
        trackingSystem.addPackage(pkg3);

        Address senderAddress4 = new Address("Sender Street 4", "Sender City 4", "Sender State 4", "Sender Zip 4");
        Address recipientAddress4 = new Address("Recipient Street 4", "Recipient City 4", "Recipient State 4", "Recipient Zip 4");
        Package pkg4 = new Package(senderAddress4, recipientAddress4, LocalDate.now());
        trackingSystem.addPackage(pkg4);

        Address senderAddress5 = new Address("Sender Street 5", "Sender City 5", "Sender State 5", "Sender Zip 5");
        Address recipientAddress5 = new Address("Recipient Street 5", "Recipient City 5", "Recipient State 5", "Recipient Zip 5");
        Package pkg5 = new Package(senderAddress5, recipientAddress5, LocalDate.now());
        trackingSystem.addPackage(pkg5);

        Address senderAddress6 = new Address("Sender Street 6", "Sender City 6", "Sender State 6", "Sender Zip 6");
        Address recipientAddress6 = new Address("Recipient Street 6", "Recipient City 6", "Recipient State 6", "Recipient Zip 6");
        Package pkg6 = new Package(senderAddress6, recipientAddress6, LocalDate.now());
        trackingSystem.addPackage(pkg6);

    }

    public void Limpiar(){
        fieldCity.setText("");
        fieldState.setText("");
        fieldStreet.setText("");
        fieldZipCode.setText("");
        rFieldCity.setText("");
        rFieldState.setText("");
        rFieldStreet.setText("");
        rFieldZipCode.setText("");
    }
}

