import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Car Class
 * 
 * @author      Sang Vo (104020390)
 * @version     JDK 18
 * @date        17 October 2022
 */

public class Car {
  
    // Declaring Variables
    private String registrationNumber;
    private String owner;
    private boolean staffMember;
    private LocalDateTime localDateTime;

    /**
     * Constructor for objects of Car Class 
     * Intializes instance variables: registrationNumber, owner and staffMember
     *
     * @param   registrationNumber  Car's Registration Number
     * @param   owner               Name of Owner
     * @param   staffMember         If owner is a staff member
     * @param   localDateTime       Displays when car is parked in slot 
     */
    public Car(String newregistrationNumber, String newOwner, boolean newStaffMember) {
        this.registrationNumber = newregistrationNumber;
        this.owner = newOwner;
        this.staffMember = newStaffMember;
    }

    /**
      * Retrieve registration number using the get method
      *
      * @return   Registration number starting with a capital letter, followed by a four-digit number e.g. A1234
      */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
      * Retrieve owner name using the get method
      *
      * @return    String of owner's name 
      */
    public String getOwner() {
        return owner;
    }

    /**
      * Retrieve boolean using getter is method 
      *
      * @return    null if staff member, otherwise user is vistor
      */
    public boolean isStaffMember() {
        return staffMember;
    } 

    /**
      * Conversion of boolean to relevant string for car type
      *
      * @return    Relevant string indicating if user is staff or visitor 
      */
    public String displayType() {
        if (staffMember == true) {
            return "Staff";
        }
        else {
            return "Visitor";
        }
    }

    /**
      * Retrieve local date and time name using the get method
      *
      * @return    A date-time without a time-zone in the ISO-8601 calendar system, e.g. 2007-12-03 T10:15:30.
      */
      public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    /**
      * Change LocalDateTime using the set method 
      *
      * @return    Returns a string object that contains the selected and changed variable 
      */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
  
    /**
      * Assigns a time for when a car is parked in a valid slot
      *
      * @return    Returns a date-time formatted string
      */
    public String parkedTime() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime recordTime = getLocalDateTime();

        return recordTime.format(formatter);
    }

    /**
     * Java internally calls toString() method
     * Overriding this method will return specified values
     *
     * @return    Returns a String object instead of hashcode values
     */ 
    public String toString() {
        return "Registration Number: "+registrationNumber+", Owner: "+ owner + ", Parked Time: " + parkedTime();
    }

 }