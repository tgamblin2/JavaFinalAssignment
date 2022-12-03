package A4_Flights;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainForm extends javax.swing.JFrame implements ActionListener {

    Location[] locations = null;
    Flight[] allFlights = null;
    FlightSchedule schedule = null;

    ArrayList<Flight> flights = new ArrayList<>();

    public MainForm() {
        initComponents();
        initComboQuery();
        initComboFormat();
        initComboReport();

        txtStatus.setText("No data loaded.");
        activateReadyState(false);

        this.pack();
    }

    private void activateReadyState(boolean bReady) {
        txtLocationsFile.setEnabled(!bReady);
        txtFlightsFile.setEnabled(!bReady);
        btnLoad.setEnabled(!bReady);

        btnAllFlightsDisplayFormat.setEnabled(bReady);
        btnAllFlightsArchiveFormat.setEnabled(bReady);
        comboQuery.setEnabled(bReady);
        comboParameter.setEnabled(bReady);
        comboFormat.setEnabled(bReady);
        comboReport.setEnabled(bReady);
        btnQuery.setEnabled(bReady);
        btnReport.setEnabled(bReady);
        txtOutput.setEnabled(bReady);
    }

    private void initComboQuery() {
        comboQuery.removeAllItems();
        comboQuery.addItem(Common.DESTINATION);
        comboQuery.addItem(Common.FLIGHT_TYPE);
        comboQuery.setSelectedIndex(0);
        comboQuery.addActionListener(this);
    }

    private void initComboFormat() {
        comboFormat.removeAllItems();
        comboFormat.addItem(Common.DISPLAY_FORMAT);
        comboFormat.addItem(Common.ARCHIVE_FORMAT);
    }

    private void initComboReport() {
        comboReport.removeAllItems();
        comboReport.addItem(Common.SUMMARY_FLIGHT_TYPE);
        comboReport.addItem(Common.SUMMARY_DESTINATION);
        comboReport.addItem(Common.POLICY_ERRORS);
    }

    /**
     * What to do when the selection in the query combo box changes.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        comboParameter.removeAllItems();
        String queryType = comboQuery.getSelectedItem().toString();
        if (queryType.equals(Common.FLIGHT_TYPE)) {
            comboParameter.addItem(Common.CARGO);
            comboParameter.addItem(Common.PASSENGER);
            comboParameter.addItem(Common.TRAINING);
        } else if (queryType.equals(Common.DESTINATION)) {
            for (Location loc : locations) {
                comboParameter.addItem(loc.getLocationCode() + " (" + loc.getCity() + ", " + loc.getCountry() + ")");
            }
        }
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtLocationsFile = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFlightsFile = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        btnAllFlightsDisplayFormat = new javax.swing.JButton();
        btnAllFlightsArchiveFormat = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnQuery = new javax.swing.JButton();
        comboParameter = new javax.swing.JComboBox();
        comboQuery = new javax.swing.JComboBox();
        comboFormat = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        comboReport = new javax.swing.JComboBox();
        btnReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Assignment 6 - A Flight Schedule");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        jLabel2.setText("Locations:");

        txtLocationsFile.setText("locations.csv");

        jLabel1.setText("Flights:");

        txtFlightsFile.setText("flights.csv");

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnAllFlightsDisplayFormat.setText("All Flights in Display Format");
        btnAllFlightsDisplayFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllFlightsDisplayFormatActionPerformed(evt);
            }
        });

        btnAllFlightsArchiveFormat.setText("All Flights in Archive Format");
        btnAllFlightsArchiveFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllFlightsArchiveFormatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocationsFile)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFlightsFile, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAllFlightsDisplayFormat)
                        .addGap(18, 18, 18)
                        .addComponent(btnAllFlightsArchiveFormat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLocationsFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad)
                    .addComponent(jLabel1)
                    .addComponent(txtFlightsFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAllFlightsDisplayFormat)
                    .addComponent(btnAllFlightsArchiveFormat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtStatus.setEditable(false);
        txtStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Queries"));

        btnQuery.setText("Execute Query");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });

        comboParameter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboQuery.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuery)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboParameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuery))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Reports"));

        comboReport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnReport.setText("Display Report");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReport)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        if (!createLocations(txtLocationsFile.getText())) {
            return;
        }
        if (!createFlights(txtFlightsFile.getText())) {
            return;
        }
        if (locations == null || allFlights == null) {
            return;
        }

        schedule = new FlightSchedule(allFlights);

        txtStatus.setText("Data files loaded.");
        activateReadyState(true);
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed

        String query = comboQuery.getSelectedItem().toString();
        String param = comboParameter.getSelectedItem().toString();
        String format = comboFormat.getSelectedItem().toString();
        Flight[] flights = null;

        if (query.equals(Common.FLIGHT_TYPE)) {
            flights = schedule.getFlightsByType(param);
        } else if (query.equals(Common.DESTINATION)) {
            param = param.substring(0, 3); // extract Location Code ONLY
            flights = schedule.getFlightsByDestination(param);
        }

        int totalWeight = findTotalWeight(flights);

        if (format.equals(Common.ARCHIVE_FORMAT)) {
            outputFlightsInArchiveFormat(flights);
        } else if (format.equals(Common.DISPLAY_FORMAT)) {
            outputFlightsInDisplayFormat(flights);
        }
        txtOutput.append("\n" + "Total Weight = " + Common.format(totalWeight));


    }//GEN-LAST:event_btnQueryActionPerformed

private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed

    String report = comboReport.getSelectedItem().toString();

    if (report.equals(Common.SUMMARY_FLIGHT_TYPE)) {
        reportSummaryByFlightType();
    } else if (report.equals(Common.SUMMARY_DESTINATION)) {
        reportSummaryByDestination();
    } else if (report.equals(Common.POLICY_ERRORS)) {
        runPolicyCheckReport();
    }

}//GEN-LAST:event_btnReportActionPerformed

    private void btnAllFlightsDisplayFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllFlightsDisplayFormatActionPerformed

        outputFlightsInDisplayFormat(schedule.getAllFlights());

    }//GEN-LAST:event_btnAllFlightsDisplayFormatActionPerformed

    private void btnAllFlightsArchiveFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllFlightsArchiveFormatActionPerformed

        outputFlightsInArchiveFormat(schedule.getAllFlights());

    }//GEN-LAST:event_btnAllFlightsArchiveFormatActionPerformed

    private void reportSummaryByFlightType() {
        // TODO-C1
        String output = "Summary of Flights by Type\n\n";
        int numCargoFlights = schedule.countFlightsByType(Common.CARGO);
        int numPassengerFlights = schedule.countFlightsByType(Common.PASSENGER);
        int numTrainingFlights = schedule.countFlightsByType(Common.TRAINING);
        Flight[] cargoFlights = schedule.getFlightsByType(Common.CARGO);
        Flight[] passengerFlights = schedule.getFlightsByType(Common.PASSENGER);
        Flight[] trainingFlights = schedule.getFlightsByType(Common.TRAINING);

        output += numCargoFlights + " Cargo Flights\tweight = " + Common.format(findTotalWeight(cargoFlights));
        output += "\n" + numPassengerFlights + " Passenger Flights\t" + "weight = " + Common.format(findTotalWeight(passengerFlights));
        output += "\n" + numTrainingFlights + " Training Flights\t" + "weight = " + Common.format(findTotalWeight(trainingFlights));
        output += "\n--------------------------------------------------------------------";
        output += "\n" + allFlights.length + " Flights\t\tweight = " + Common.format(findTotalWeight(allFlights));

        txtOutput.setText(output);
    }

    private void reportSummaryByDestination() {
        // TODO-C2
        String output = "Summary of Flights by Destination\n";
        for (int i = 0; i < locations.length; i++) {
            int flightsByDestination = schedule.countFlightsByDestination(locations[i].getLocationCode());
            if (flightsByDestination != 0) {
                output += "\n" + flightsByDestination;
                output += " flights to " + locations[i].getLocationCode();
                output += "   \t ";
                Flight[] flightsByLocation = schedule.getFlightsByDestination(locations[i].getLocationCode());
                output += "weight = " + Common.format(findTotalWeight(flightsByLocation));
            }
        }
        output += "\n--------------------------------------------------------------------";
        output += "\n" + allFlights.length + " Flights   \t  \tweight = " + Common.format(findTotalWeight(allFlights));

        txtOutput.setText(output);
    }

    private void outputFlightsInArchiveFormat(Flight[] flights) {

        txtOutput.setText("");
        int count = 0;
        for (Flight flight : flights) {
            txtOutput.append(flight.toArchiveFormat() + "\n");
            count++;
        }
        txtOutput.append("\nNumber of Flights: " + count);
    }

    private void outputFlightsInDisplayFormat(Flight[] flights) {

        txtOutput.setText("");
        int count = 0;
        for (Flight flight : flights) {
            txtOutput.append(flight.toDisplayReport() + "\n");
            count++;
        }
        txtOutput.append("\nNumber of Flights: " + count);
    }

    private int findTotalWeight(Flight[] flights) {

        int res = 0;
        for (Flight flight : flights) {
            res += flight.calculateWeight();
        }
        return res;
    }

    /**
     * Creates Location objects from data in a file.
     *
     * @param fileName the file containing the location data
     * @return an array of Location objects
     */
    private boolean createLocations(String fileName) {
        ArrayList<Location> result = new ArrayList<>();
        CSV_Parser p = new CSV_Parser();
        try {
            if (!p.open(fileName)) {
                return false;
            }
            while (p.getNextLine()) {
                Location loc = Location.parseCSV(p);
                if (loc == null) {
                    System.out.println("error parsing Location, line=" + p.getLine());
                } else {
                    result.add(loc);
                }
            }
            System.out.println("" + result.size() + " Locations loaded");
            this.locations = result.toArray(Location[]::new);
            return true;
        } finally {
            p.close();
        }
    }

    /**
     * Creates Flight objects from data in a file.
     *
     * @param fileName the file containing the flight data
     * @return an array of Flight objects
     */
    private boolean createFlights(String fileName) {

        // TODO-A5 complete this method
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                try {
                    String flightType = parts[0];
                    String flightNumber = parts[1];
                    String dayOfWeek = parts[2];
                    int departureTime = Integer.parseInt(parts[3]);
                    String locationCode = parts[4];
                    Location destination = findLocation(locationCode);
                    int numCrew = Integer.parseInt(parts[5]);
                    if (parts.length > 6) {
                        if (Common.CARGO.equals(flightType)) {
                            int cargoWeight = Integer.parseInt(parts[6]);
                            CargoFlight flight = new CargoFlight(flightNumber, dayOfWeek,
                                    departureTime, destination, numCrew, cargoWeight);
                            flights.add(flight);
                        } else if (Common.PASSENGER.equals(flightType)) {
                            int numPassengers = Integer.parseInt(parts[6]);
                            PassengerFlight flight = new PassengerFlight(flightNumber, dayOfWeek,
                                    departureTime, destination, numCrew, numPassengers);
                            flights.add(flight);
                        }
                    } else {
                        TrainingFlight flight = new TrainingFlight(flightNumber, dayOfWeek,
                                departureTime, destination, numCrew);
                        flights.add(flight);
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
            }

            allFlights = flights.toArray(new Flight[flights.size()]);
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Oops ! Exception=" + ex.getMessage());
            return false;
        }
    }

    /**
     * Finds the Location object with the specified location code.
     *
     * @param locationCode the three-letter location code to match
     * @return the Location object with that code.
     */
    private Location findLocation(String locationCode) {
        for (Location loc : locations) {
            if (loc.getLocationCode().equals(locationCode)) {
                return loc;
            }
        }
        return null;
    }

    private void runPolicyCheckReport() {
        // TODO-D2
        Flight[] flights = schedule.getAllFlights();
        String[] policyChecks = PolicyChecker.runPolicyChecks(flights);
        String output = "Policy Errors\n";
        for (int i = 0; i < flights.length; i++) {
            if (!Common.NO_ERROR.equals(policyChecks[i])) {
                output += "\n" + flights[i].toArchiveFormat() + "\n";
                output += policyChecks[i] + "\n";
            }
        }
        txtOutput.setText(output);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllFlightsArchiveFormat;
    private javax.swing.JButton btnAllFlightsDisplayFormat;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnReport;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboFormat;
    private javax.swing.JComboBox comboParameter;
    private javax.swing.JComboBox comboQuery;
    private javax.swing.JComboBox comboReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFlightsFile;
    private javax.swing.JTextField txtLocationsFile;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

}