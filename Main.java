import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main Class - Implementation & Running Java GUI
 * 
 * @author      Sang Vo (104020390)
 * @version     JDK 18
 * @date        17 October 2022
 */

public class Main {

    // Declaring Variables
    static CarPark carParkObj = new CarPark();
    static JFrame frame;
    static JPanel panel5a;
    static JPanel panel5b;
    static JPanel panel5b1;
    static JPanel panel5b2;
    static JLabel labelTitleStaff;
    static JLabel labelTitleVisitor;
    static JButton staffButton;

    public static void main(String[] args) {

        // Primary panels in order, respectively : NORTH, WEST, EAST, SOUTH, CENTER
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        // Setting background of main panels on frame
        panel1.setBackground(new Color(0xf0f8ff));
        panel2.setBackground(null);
        panel3.setBackground(null);
        panel4.setBackground(new Color(0xf0f8ff));
        panel5.setBackground(null);
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

        // Setting dimensions of main panels on frame
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(25, 100));
        panel3.setPreferredSize(new Dimension(25, 100));
        panel4.setPreferredSize(new Dimension(50, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

        // Panel 5 --- sub labels
        // Panel5a - where the features/buttons will be
        panel5a = new JPanel(); 
        panel5a.setLayout(new GridLayout(4, 2));

        // Panel5b - main panel to hold parking slot data
        panel5b = new JPanel(); 
        panel5b.setLayout(new BoxLayout(panel5b, BoxLayout.X_AXIS));

        // Panel5b1 - staff panel
        panel5b1 = new JPanel(); // 
        panel5b1.setBackground(Color.PINK);
        panel5b1.setLayout(new GridLayout(8, 1));
        panel5b1.setPreferredSize(new Dimension(50, 100));

        // Panel5b2 - visitor panel
        panel5b2 = new JPanel();
        panel5b2.setBackground(Color.ORANGE);
        panel5b2.setLayout(new GridLayout(8, 1));
        panel5b2.setPreferredSize(new Dimension(50, 100));

        panel5.add(panel5a);
        panel5.add(panel5b);

        // Creating and adding the 7 buttons to panel5a --- 
        JButton addSlot = new JButton("1: Add a parking slot");
        addSlot.setForeground(Color.BLUE);
        addSlot.setFocusable(false);
        panel5a.add(addSlot);

        JButton deleteSlot = new JButton("2: Delete a parking slot");
        deleteSlot.setForeground(Color.BLUE);
        deleteSlot.setFocusable(false);
        panel5a.add(deleteSlot);

        JButton listSlot = new JButton("3: List all slots");
        listSlot.setForeground(Color.BLUE);
        listSlot.setFocusable(false);
        panel5a.add(listSlot);

        JButton parkCar = new JButton("4: Park car into slot");
        parkCar.setForeground(Color.BLUE);
        parkCar.setFocusable(false);
        panel5a.add(parkCar);

        JButton findCar = new JButton("5: Find a car by registration number");
        findCar.setForeground(Color.BLUE);
        findCar.setFocusable(false);
        panel5a.add(findCar);

        JButton removeCar = new JButton("6: Remove a car by registration number");
        removeCar.setForeground(Color.BLUE);
        removeCar.setFocusable(false);
        panel5a.add(removeCar);

        JButton exitButton = new JButton("7: Exit");
        exitButton.setForeground(Color.BLUE);
        exitButton.setFocusable(false);
        panel5a.add(exitButton);
        
        // Add staff and visitor panel to the main panel grouping them 
        panel5b.add(panel5b1);
        panel5b.add(panel5b2);

        // Set button size
        panel5a.setPreferredSize(new Dimension(100, -150));
        panel5b.setPreferredSize(new Dimension(100, 100));

        // Labels for 5b1 (Staff)
        labelTitleStaff = new JLabel(); // create a label
        labelTitleStaff.setText("Staff"); // set text of label
        labelTitleStaff.setFont(new Font("Hack", Font.BOLD, 20)); // set font of text
        labelTitleStaff.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        labelTitleStaff.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
        labelTitleStaff.setBorder(new EmptyBorder(10, 0, 10, 20)); // set margin
        panel5b1.add(labelTitleStaff);

        // Labels for 5b2 (Visitor)
        labelTitleVisitor = new JLabel(); // create a label
        labelTitleVisitor.setText("Visitor"); // set text of label
        labelTitleVisitor.setFont(new Font("Hack", Font.BOLD, 20)); // set font of text
        labelTitleVisitor.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        labelTitleVisitor.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
        labelTitleVisitor.setBorder(new EmptyBorder(10, 0, 10, 0)); // set margin
        panel5b2.add(labelTitleVisitor);

        // Panel 1 --- sub labels
        JLabel label1 = new JLabel(); // create a label
        label1.setText("GUI Parking Slot System"); // set text of label
        label1.setFont(new Font("Hack", Font.BOLD, 28)); // set font of text
        label1.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label1.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label

        JLabel label2 = new JLabel(); // create a label
        label2.setText("Please select one of the following options:"); // set text of label
        label2.setFont(new Font("Consolas", Font.PLAIN, 18)); // set font of text
        label2.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label2.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label

        panel1.setLayout(new GridLayout(2, 1, 0, 0));
        panel1.add(label1);
        panel1.add(label2);

        // Panel 4 --- sub labels
        JLabel label3 = new JLabel(); // create a label
        label3.setText("\u00a9 2022 Sang Vo"); // set text of label
        label3.setFont(new Font("Hack", Font.BOLD, 16)); // set font of text
        label3.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label3.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label

        panel4.setLayout(new BorderLayout());
        panel4.add(label3);

        // Final frames
        frame = new JFrame();
        frame.setTitle("GUI Parking Slot System - Sang Vo");;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1200);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setVisible(true);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.EAST);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.CENTER);

        // Add Parking Slot
        addSlot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String id = JOptionPane.showInputDialog(frame,
                        "Please enter a slot ID which starts with a capital letter, followed by a two-digit number eg. A01");

                if (carParkObj.checkParkingSlotId(id) == true) { // check parking slot ID form is correct eg. A01

                    if (carParkObj.hasParkingSlot(id) == false) { // check parking slot ID does not exist 

                        // Recasting Button Yes = "Staff" and No  = "Visitor"
                        String[] parkingSlotTypeRes = { "Staff", "Visitor" };

                        int type = JOptionPane.showOptionDialog(frame,
                                "Please select a parking slot type below: ",
                                "Parking Slot Type",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                parkingSlotTypeRes,
                                null);

                        // For Staff
                        if (type == JOptionPane.YES_OPTION) {
                            String output = carParkObj.addParkingSlot(id, true);
                            JButton staffButton = new JButton(output);
                            panel5b1.add(staffButton);
                            panel5b1.removeAll();
                            panel5b2.removeAll();
                            rebuildSlots();
                            panel5b.repaint();
                            panel5b.revalidate();
                        }
                        // For Visitor
                        else {
                            String output = carParkObj.addParkingSlot(id, false);
                            JButton visitorButton = new JButton(output);
                            panel5b2.add(visitorButton);
                            panel5b1.removeAll();
                            panel5b2.removeAll();
                            rebuildSlots();
                            panel5b.repaint();
                            panel5b.revalidate();
                        }

                    } else { // If parking slot is already created
                        JOptionPane.showMessageDialog(frame,
                                "Invalid, this parking slot already exist!",
                                "Parking Slot Exist",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } else { // If user does not entry the correct slot ID format
                    JOptionPane.showMessageDialog(frame,
                            "Invalid, check that the entry for parking slot ID starts with a capital letter, followed by a two-digit number eg. A01",
                            "Invalid Parking Slot Entry",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        // Delete a parking slot
        deleteSlot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Ask for user input
                String id = JOptionPane.showInputDialog(frame,
                        "Please enter a slot ID which starts with a capital letter, followed by a two-digit number eg. A01");

                if (carParkObj.hasParkingSlot(id) == true) { // If slot is valid 

                    int todelete = JOptionPane.showOptionDialog(frame,
                            "Do you wish to delete this parking slot?",
                            "Deleting Selected Parking Slot",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            null);

                    // If yes to deletion
                    if (todelete == JOptionPane.YES_OPTION) {
                        // Deleting parking slot
                        carParkObj.deleteParkingSlot(id);
                        panel5b1.removeAll();
                        panel5b2.removeAll();
                        rebuildSlots();
                        panel5b.repaint();
                        panel5b.revalidate();

                    }
                    // If no to deletion
                    else {
                        return;
                    }
                } else { // If car parking slot does not exist
                    JOptionPane.showMessageDialog(frame,
                            "This car parking slot does not exist!",
                            "Invalid Parking Slot Entry for Deletion",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        // List all slots
        listSlot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Creating new frame to hold list data
                JFrame listAllSlotFrame = new JFrame();
                listAllSlotFrame.setLayout(new GridLayout(10,2));
                listAllSlotFrame.setSize(1200, 900); // sets the x-demension, and y-demension of frame
                listAllSlotFrame.setTitle("Listing All Car Park Slots");
                listAllSlotFrame.setLocationRelativeTo(null);
                listAllSlotFrame.setVisible(true);
                listAllSlotFrame.getContentPane().setBackground(new Color(0xf0f8ff)); // change color of background

                for (ParkingSlot reParkingSlot : carParkObj.slots) { // Iterate through parking slot array

                    JLabel slotLabel = new JLabel();
                    Border slotBorder = BorderFactory.createLineBorder(Color.BLACK,1);

                    if (reParkingSlot.getCar() != null) { // If a car exist change colour of text to purple to indicate occupancy
        
                        slotLabel.setForeground(Color.decode("#5a4fcf"));
                    
                    }

                    if (reParkingSlot.getCar() == null) { 

                        // Assignment of time is not required if no car is parked in slot
                        String text = reParkingSlot.toString();
                        slotLabel.setText(text);
                        slotLabel.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
                        slotLabel.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label

                        if (text.contains("Staff")){
                            slotLabel.setBackground(Color.PINK); // set background color for staff
    
                        }
                        else {
                            slotLabel.setBackground(Color.ORANGE); // set background color for visitor
                        }
                    
                    } else {
                        
                        // Assign time to the String if there is a car parked in the slot
                        LocalDateTime now = LocalDateTime.now();
                        LocalDateTime recordTime = reParkingSlot.getCar().getLocalDateTime();
                        long hour = ChronoUnit.HOURS.between(recordTime, now);
                        long minute = ChronoUnit.MINUTES.between(recordTime, now) % 60;
                        long second = ChronoUnit.SECONDS.between(recordTime, now) % 60;

                        String newEntry = "Slot ID: " + reParkingSlot.getId().toString() + 
                                          ", Type: " + reParkingSlot.displaySlotType().toString() + 
                                          ", "+ reParkingSlot.getCar().toString() + 
                                          ", Elapse time since car has been parked ~ Hours: " + hour + ", Minutes: " + minute + ", Seconds: " + second;

                        slotLabel.setText(newEntry);
                        slotLabel.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
                        slotLabel.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label

                        if (newEntry.contains("Staff")){
                            slotLabel.setBackground(Color.PINK); // set background color for staff
    
                        }
                        else {
                            slotLabel.setBackground(Color.ORANGE); // set background color for visitor
                        }
        
                    }

                    slotLabel.setOpaque(true); // Display background color
                    slotLabel.setBorder(slotBorder);
                    listAllSlotFrame.add(slotLabel);
                }
            }

        });

        // Park car into parking slot
        parkCar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Ask for user input - car registration number
                String regoInput = JOptionPane.showInputDialog(frame,
                "Please enter a registration number starting with a capital letter, followed by a four-digit number e.g A1234");

                if (carParkObj.checkCarRegistration(regoInput) == true) { // check car registration form
                    
                    if (carParkObj.findACarByRegis(regoInput) == null) { // check car registration does not already exist
                    
                        // Ask for user input - parking slot ID
                        String idInput = JOptionPane.showInputDialog(frame,
                        "Enter an existing slot ID eg. D01");

                        if (carParkObj.checkParkingSlotId(idInput) == true) { // check parking slot form 

                            if (carParkObj.hasParkingSlot(idInput) == true) { // check parking slot doesn't already exist

                                for (int i = 0; i < carParkObj.slots.size(); i++) { // for loop required to iterate till the input parking slot is reached

                                    if (carParkObj.slots.get(i).getId().equals(idInput) == true) {

                                    // Recasting Button Yes = "Staff" and No  = "Visitor"
                                    String[] carTypeRes = { "Staff", "Visitor" };

                                    int carType = JOptionPane.showOptionDialog(frame,
                                            "Please select a car owner type below: ",
                                            "Car Owner Type",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE,
                                            null,
                                            carTypeRes,
                                            null);

                                        // For staff
                                        if (carType == JOptionPane.YES_OPTION && carParkObj.slots.get(i).getType() == true) {
                                            
                                            String nameInput = JOptionPane.showInputDialog(frame,
                                            "Enter a name for the owner of the car eg. Joshua");
            
                                            carParkObj.addCar(new Car(regoInput, nameInput, true), idInput);

                                                panel5b1.removeAll();
                                                panel5b2.removeAll();
                                                rebuildSlots();
                                                panel5b.repaint();
                                                panel5b.revalidate();
                                        }
                                        // For visitor
                                        else if (carType == JOptionPane.NO_OPTION && carParkObj.slots.get(i).getType() == false) {
                                            
                                            String nameInput = JOptionPane.showInputDialog(frame,
                                            "Enter a name for the owner of the car eg. Joshua");
            
                                            carParkObj.addCar(new Car(regoInput, nameInput, false), idInput);

                                                panel5b1.removeAll();
                                                panel5b2.removeAll();
                                                rebuildSlots();
                                                panel5b.repaint();
                                                panel5b.revalidate();
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(frame,
                                                "Invalid, car type and slot type does not match!",
                                                "Invalid Non-Matching Car & Slot Types",
                                                JOptionPane.PLAIN_MESSAGE);  
                                        }
                                    } 
                                }
                            } else { // If slot form is correct but slot does not exist 
                                JOptionPane.showMessageDialog(frame,
                                    "Invalid, enter a parking slot ID that exist",
                                    "Parking Slot Does Not Exist",
                                    JOptionPane.PLAIN_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(frame,
                                "Invalid car slot entry form, please ensure slot ID starts with a capital letter, followed by a two-digit number eg. A01",
                                "Invalid Car Slot Entry Form",
                                JOptionPane.PLAIN_MESSAGE);  
                        }          
                    } else { // If car registration form is invalid eg. A0132133
                        JOptionPane.showMessageDialog(frame,
                                "Invalid, car registration number already exists!",
                                "Invalid Existing Car Registration Number",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } else { // If car registration form is invalid eg. A0132133
                    JOptionPane.showMessageDialog(frame,
                            "Invalid, enter a car registration number starting with a capital letter, followed by a four-digit number e.g A1234",
                            "Invalid Car Registration Form",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        // Find Car by Registration Number
        findCar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // User input - car registration number
                String regoInput = JOptionPane.showInputDialog(frame,
                "Please enter a registration number starting with a capital letter, followed by a four-digit number e.g A1234");

                if (carParkObj.findCar(regoInput) != "incorrect") { // input car registration number exist

                    JOptionPane.showMessageDialog(null,                     
                        carParkObj.findCar(regoInput),
                        "Finding Car by Registration Number", 
                        JOptionPane.PLAIN_MESSAGE);
                
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid, enter a valid car registration number starting with a capital letter, followed by a four-digit number e.g A1234",
                            "Invalid Car Registration Number",
                            JOptionPane.PLAIN_MESSAGE);
                }

            }

        });

        // Remove Car by Registration Number
        removeCar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // User input - car registration number
                String regoInput = JOptionPane.showInputDialog(frame,
                "Please enter a registration number starting with a capital letter, followed by a four-digit number e.g A1234");

                if (carParkObj.findACarByRegis(regoInput) != null) { // if car registration exist 

                    int todelete = JOptionPane.showOptionDialog(frame,
                        "Do you wish to remove this car from the parking slot?",
                        "Remove Selected Car",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        null,
                        null);

                    // If yes to deletion
                    if (todelete == JOptionPane.YES_OPTION) {
                        // Deleting car from slot
                        carParkObj.deleteCar(regoInput);
                        panel5b1.removeAll();
                        panel5b2.removeAll();
                        rebuildSlots();
                        panel5b.repaint();
                        panel5b.revalidate();

                    }
                    // If no to deletion
                    else {
                        return;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid, enter a valid car registration number starting with a capital letter, followed by a four-digit number e.g A1234",
                            "Invalid Car Registration Number",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }

        });


        // Exit
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });

    }


    // Rebuild after deletion
    public static void rebuildSlots() {

        panel5b2.setBackground(Color.ORANGE);
        panel5b2.setLayout(new GridLayout(8, 1));

        // Labels for 5b1
        labelTitleStaff = new JLabel(); // create a label
        labelTitleStaff.setText("Staff"); // set text of label
        labelTitleStaff.setFont(new Font("Hack", Font.BOLD, 20)); // set font of text
        labelTitleStaff.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        labelTitleStaff.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
        labelTitleStaff.setBorder(new EmptyBorder(10, 0, 10, 20)); // set margin
        panel5b1.add(labelTitleStaff);

        // Labels for 5b2
        labelTitleVisitor = new JLabel(); // create a label
        labelTitleVisitor.setText("Visitor"); // set text of label
        labelTitleVisitor.setFont(new Font("Hack", Font.BOLD, 20)); // set font of text
        labelTitleVisitor.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        labelTitleVisitor.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
        labelTitleVisitor.setBorder(new EmptyBorder(10, 0, 10, 0)); // set margin
        panel5b2.add(labelTitleVisitor);

        for (int i = 0; i < carParkObj.slots.size(); i++) {
            if (carParkObj.slots.get(i).getType() == true) {
                String id = carParkObj.slots.get(i).toString();

                JButton staffButton = new JButton(id);

            staffButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    // If the staff button contains owner than it currently has no car
                    // Hence options are only to delete Car 
                    if (staffButton.toString().contains("Owner")) {

                        int todelete = JOptionPane.showOptionDialog(frame,
                            "Do you wish to remove this car from the parking slot?",
                            "Remove Selected Car",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            null);

                        // If yes to deletion
                        if (todelete == JOptionPane.YES_OPTION) {
                            String aString = staffButton.toString();
                            Pattern pattern = Pattern.compile("[A-Z][0-9]{4}");
                            Matcher matcher = pattern.matcher(aString);
                            if (matcher.find())
                            {
                                matcher.group(0).toString();
                            }

                            // Deleting parking slot
                            carParkObj.deleteCar(matcher.group(0).toString());
                            panel5b1.removeAll();
                            panel5b2.removeAll();
                            rebuildSlots();
                            panel5b.repaint();
                            panel5b.revalidate();
    
                        }
                        // If no to deletion
                        else {
                            return;
                        }

                    }
                    if (staffButton.toString().contains("null")) {

                        // Recasting Button Yes = "Add Car" and No  = "Remove Parking Slot"
                        String[] options = { "Add Car", "Remove Parking Slot" };

                        int type = JOptionPane.showOptionDialog(frame,
                                "Please select a parking slot type below: ",
                                "Add Car or Remove Slot",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                null);

                        // Add Car
                        if (type == JOptionPane.YES_OPTION) {
                            // Ask for user input - car registration number
                            String regoInput = JOptionPane.showInputDialog(frame,
                            "Please enter a registration number starting with a capital letter, followed by a four-digit number e.g A1234");

                            if (carParkObj.checkCarRegistration(regoInput) == true) { // check car registration form
                    
                                if (carParkObj.findACarByRegis(regoInput) == null) { // check car registration does not already exist

                                    String aString = staffButton.toString();
                                    Pattern pattern = Pattern.compile("[A-Z][0-9]{2}");
                                    Matcher matcher = pattern.matcher(aString);
                                    if (matcher.find())
                                    {
                                        matcher.group(0).toString();
                                    }
            
                                    for (int i = 0; i < carParkObj.slots.size(); i++) { // for loop required to iterate till the input parking slot is reached
    
                                        if (carParkObj.slots.get(i).getId().equals(matcher.group(0).toString()) == true) {
                                                    
                                            String nameInput = JOptionPane.showInputDialog(frame,
                                            "Enter a name for the owner of the car eg. Joshua");
            
                                            carParkObj.addCar(new Car(regoInput, nameInput, true), matcher.group(0).toString());

                                                panel5b1.removeAll();
                                                panel5b2.removeAll();
                                                rebuildSlots();
                                                panel5b.repaint();
                                                panel5b.revalidate();
                                        }
                                    }
                                }
                                else { // If car registration form is invalid eg. A0132133
                                    JOptionPane.showMessageDialog(frame,
                                            "Invalid, car registration number already exists!",
                                            "Invalid Existing Car Registration Number",
                                            JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                            else { // If car registration form is invalid eg. A0132133
                                JOptionPane.showMessageDialog(frame,
                                        "Invalid, enter a car registration number starting with a capital letter, followed by a four-digit number e.g A1234",
                                        "Invalid Car Registration Form",
                                        JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        // For Remove Parking Slot
                        else {
            
                            String aString = staffButton.toString();
                            Pattern pattern = Pattern.compile("[A-Z][0-9]{2}");
                            Matcher matcher = pattern.matcher(aString);
                            if (matcher.find())
                            {
                                matcher.group(0).toString();
                            }

                            int todelete = JOptionPane.showOptionDialog(frame,
                                    "Do you wish to delete this parking slot?",
                                    "Deleting Selected Parking Slot",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    null,
                                    null);

                            // If yes to deletion
                            if (todelete == JOptionPane.YES_OPTION) {
                                // Deleting parking slot
                                carParkObj.deleteParkingSlot(matcher.group(0).toString());
                                panel5b1.removeAll();
                                panel5b2.removeAll();
                                rebuildSlots();
                                panel5b.repaint();
                                panel5b.revalidate();

                            }
                            // If no to deletion
                            else {
                                return;
                            }
                        }
                    }
                }
            });
        
            if (carParkObj.slots.get(i).getCar() != null) {
                staffButton.setForeground(Color.decode("#5a4fcf"));
            }

            panel5b1.add(staffButton);

            } else{
                String id = carParkObj.slots.get(i).toString();

                JButton visitorButton = new JButton(id);

                visitorButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
    
                        // If the visitor button contains owner than it currently has no car
                        // Hence options are only to delete Car 
                        if (visitorButton.toString().contains("Owner")) {
    
                            int todelete = JOptionPane.showOptionDialog(frame,
                                "Do you wish to remove this car from the parking slot?",
                                "Remove Selected Car",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                null,
                                null);
    
                            // If yes to deletion - visitor
                            if (todelete == JOptionPane.YES_OPTION) {
                                String aString = visitorButton.toString();
                                Pattern pattern = Pattern.compile("[A-Z][0-9]{4}");
                                Matcher matcher = pattern.matcher(aString);
                                if (matcher.find())
                                {
                                    matcher.group(0).toString();
                                }
    
                                // Deleting parking slot
                                carParkObj.deleteCar(matcher.group(0).toString());
                                panel5b1.removeAll();
                                panel5b2.removeAll();
                                rebuildSlots();
                                panel5b.repaint();
                                panel5b.revalidate();
        
                            }
                            // If no to deletion
                            else {
                                return;
                            }
    
                        }
                        if (visitorButton.toString().contains("null")) {
    
                            // Recasting Button Yes = "Add Car" and No  = "Remove Parking Slot"
                            String[] options = { "Add Car", "Remove Parking Slot" };
    
                            int type = JOptionPane.showOptionDialog(frame,
                                    "Please select a parking slot type below: ",
                                    "Add Car or Remove Slot",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    null);
    
                            // Add Car - visitor
                            if (type == JOptionPane.YES_OPTION) {
            
                            // Ask for user input - car registration number
                            String regoInput = JOptionPane.showInputDialog(frame,
                            "Please enter a registration number starting with a capital letter, followed by a four-digit number e.g A1234");

                            if (carParkObj.checkCarRegistration(regoInput) == true) { // check car registration form
                    
                                if (carParkObj.findACarByRegis(regoInput) == null) { // check car registration does not already exist

                                    String aString = visitorButton.toString();
                                    Pattern pattern = Pattern.compile("[A-Z][0-9]{2}");
                                    Matcher matcher = pattern.matcher(aString);
                                    if (matcher.find())
                                    {
                                        matcher.group(0).toString();
                                    }
            
                                    for (int i = 0; i < carParkObj.slots.size(); i++) { // for loop required to iterate till the input parking slot is reached
    
                                        if (carParkObj.slots.get(i).getId().equals(matcher.group(0).toString()) == true) {
                                                    
                                            String nameInput = JOptionPane.showInputDialog(frame,
                                            "Enter a name for the owner of the car eg. Joshua");
            
                                            carParkObj.addCar(new Car(regoInput, nameInput, false), matcher.group(0).toString());

                                                panel5b1.removeAll();
                                                panel5b2.removeAll();
                                                rebuildSlots();
                                                panel5b.repaint();
                                                panel5b.revalidate();
                                        }
                                    }
                                }
                                else { // If car registration form is invalid eg. A0132133
                                    JOptionPane.showMessageDialog(frame,
                                            "Invalid, car registration number already exists!",
                                            "Invalid Existing Car Registration Number",
                                            JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                            else { // If car registration form is invalid eg. A0132133
                                JOptionPane.showMessageDialog(frame,
                                        "Invalid, enter a car registration number starting with a capital letter, followed by a four-digit number e.g A1234",
                                        "Invalid Car Registration Form",
                                        JOptionPane.PLAIN_MESSAGE);
                            }
                            }
                            // For Remove Parking Slot
                            else {
                
                                String aString = visitorButton.toString();
                                Pattern pattern = Pattern.compile("[A-Z][0-9]{2}");
                                Matcher matcher = pattern.matcher(aString);
                                if (matcher.find())
                                {
                                    matcher.group(0).toString();
                                }
    
                                int todelete = JOptionPane.showOptionDialog(frame,
                                        "Do you wish to delete this parking slot?",
                                        "Deleting Selected Parking Slot",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                        null,
                                        null,
                                        null);
    
                                // If yes to deletion
                                if (todelete == JOptionPane.YES_OPTION) {
                                    // Deleting parking slot
                                    carParkObj.deleteParkingSlot(matcher.group(0).toString());
                                    panel5b1.removeAll();
                                    panel5b2.removeAll();
                                    rebuildSlots();
                                    panel5b.repaint();
                                    panel5b.revalidate();
                                }
                                // If no to deletion
                                else {
                                    return;
                                }
                            }
                        }
                    }
                });                

                if (carParkObj.slots.get(i).getCar() != null) {

                    visitorButton.setForeground(Color.decode("#5a4fcf"));
                
                }

                panel5b2.add(visitorButton);

            }
        }
    }

}

