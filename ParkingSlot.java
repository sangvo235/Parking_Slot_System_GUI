
/**
 * Parking Slot Class
 * 
 * @author      Sang Vo (104020390)
 * @version     JDK 18
 * @date        17 October 2022
 */

public class ParkingSlot {
  
  // Declaring Final
  public static final String slotNumEntered = null;

  // Declaring Variables
  private String id;
  private boolean type;
  private Car car;

  /**
   * Constructor for objects of Parking Slot Class
   * Intializes instance variables: id, type and car
   *
   * @param id   Parking Slot identifier
   * @param type Type of Parking Slot
   * @param car  Car details consisting of registration number and owner's name
   */
  public ParkingSlot(String newId, boolean newType) {
    this.id = newId;
    this.type = newType;
  }

  /**
   * Retrieve parking slot ID using the get method
   *
   * @return Parking slot ID starting with a capital letter, followed by a
   *         two-digit number eg. A01
   */
  public String getId() {
    return id;
  }

  /**
   * Retrieve parking slot type using the get method
   *
   * @return Boolean where true represents parking slot for "Staff" and false for "Visitor"
   */
  public boolean getType() {
    return type;
  }

  /**
   * Retrieve Car details
   *
   * @return Car details if it is occupied in the slot, otherwise null
   */
  public Car getCar() {
    return car;
  }

  /**
   * Change car slot ID using the set method
   *
   * @return Returns a string object that contains the selected and changed
   *         variable
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Change car slot type using the set method
   *
   * @return Returns a string object that contains the selected and changed
   *         variable
   */
  public void setType(boolean type) {
    this.type = type;
  }

  /**
   * Conversion of boolean to relevant string for car slot type
   *
   * @return Relevant string indicating if user is staff or visitor
   */
  public String displaySlotType() {
    if (type == true) {
      return "Staff";
    } else {
      return "Visitor";
    }
  }

  /**
   * Retrieve park car using set method
   *
   * @return Parked car details consisting of String registrationNumber, String owner, boolean StaffMember
   */
  public void parkCar(Car car) {
    this.car = car;
  }

  /**
   * Remove car from parking slot using set methood
   *
   * @return Removal of car details from parking slot
   */
  public void removeCar() {
    this.car = null;
  }

  /**
   * Java internally calls toString() method
   * Overriding this method will return specified values
   *
   * @return Returns a String object instead of hashcode values
   */
  public String toString() {
    return "Slot ID: "+ id + ", Type: " + displaySlotType() + ", " + car;
  }

}