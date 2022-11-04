import java.util.Iterator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Cark Park Class - maintains list of slots in the parking
 * 
 * @author      Sang Vo (104020390)
 * @version     JDK 18
 * @date        17 October 2022
 */

public class CarPark {

    // Creating the parking slot array
    ArrayList<ParkingSlot> slots = new ArrayList<ParkingSlot>();

  /**
   * Searching if the parking slot exist
   *
   * @return boolean where true indicates a parking slot exist and false conversely
   */
    public boolean hasParkingSlot(String searching) {
        // Scan for eg. A01 in slots (Parking Slot Array)
        for (ParkingSlot slot : slots) {
            // If slot matches ID return true
            if (slot.getId().equals(searching))
                return true;
        }
        return false;
    }

  /**
   * Adding parking slot
   *
   * @return String displaying slot ID and slot type
   */
    public String addParkingSlot(String newId, boolean newType) {
        // Create new Parking Slot
        ParkingSlot slotObj = new ParkingSlot(newId, newType);
        // Add to Array List
        slots.add(slotObj);
        // Return Parking Slot Details
        return slotObj.toString();
    }

  /**
   * Deleting parking slot
   *
   * @return deleted parking slot if input slot ID exist and does not already contain a parked car
   */
    public void deleteParkingSlot(String identifier) {
        // Creating interator
        Iterator<ParkingSlot> here = slots.iterator();
        // While loop while
        while (here.hasNext()) {
            ParkingSlot slot = here.next();
            String id = slot.getId();
            if (id.equals(identifier)) {
                if (slot.getCar() == null) {
                    // Removal of parking slot
                    here.remove();
                } 
            }
        }
    }

  /**
   * Finding Car via Registration Number
   *
   * @return Car details otherwise return null
   */
    public Car findACarByRegis(String registerNumber) {
        for (ParkingSlot s : slots) {
            if (s.getCar() != null) {
                if (s.getCar().getRegistrationNumber().equals(registerNumber)) {
                    return s.getCar();
                }
            }
        }
        return null;
    }

  /**
   * Adding/Parking a car into a parking slot
   *
   * @return Car and parking slot details after parking the car into the slot succcessfully,
   *         additionally parking time displayed
   */
    public String addCar(Car car, String slotId) {
            
        for (ParkingSlot s : slots) {
            if (s.getId().equals(slotId)) {
                if (s.getCar() == null) {
                    
                    // add car to parking slot
                    s.parkCar(car);
                    
                    // list time of when car is parked
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String parkedTime = now.format(formatter);
                    car.setLocalDateTime(now);

                    String newEntry = car.toString() + " " + parkedTime;

                    return newEntry;
                }
            }
        }
        return "unable to park car";
    }

  /**
   * List of all slots and their encapsulated variables
   *
   * @return Parking slot, car and elapse time details
   */
    public String listSlots(Car car) {
        for (ParkingSlot s : slots) {
            if (s.getCar() == null) {
                car = s.getCar();
            } else {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime recordTime = car.getLocalDateTime();
                long hour = ChronoUnit.HOURS.between(recordTime, now);
                long minute = ChronoUnit.MINUTES.between(recordTime, now) % 60;
                long second = ChronoUnit.SECONDS.between(recordTime, now) % 60;

                String newEntry = "Slot ID: " + s.getId() + 
                                    ", Type: " + s.displaySlotType().toString() + 
                                    ", "+ s.getCar().toString() + 
                                    ", Elapse time since car has been parked ~ Hours: " + hour + ", Minutes: " + minute + ", Seconds: " + second;                        
                return newEntry;
            }
        }
        return null;
    }

  /**
   * Finding a car given car registration number
   *
   * @return Parking slot, car and elapse time details
   */
    public String findCar(String regoNumber) {
        for (ParkingSlot s : slots) {
            if (s.getCar() != null) {
                String id = s.getCar().getRegistrationNumber();
                if (id.equals(regoNumber)) {
                    if (s.getCar() != null) {

                        LocalDateTime now = LocalDateTime.now();
                        LocalDateTime recordTime = s.getCar().getLocalDateTime();
                        long hour = ChronoUnit.HOURS.between(recordTime, now);
                        long minute = ChronoUnit.MINUTES.between(recordTime, now) % 60;
                        long second = ChronoUnit.SECONDS.between(recordTime, now) % 60;

                        String newEntry = "Slot ID: " + s.getId() + 
                                          ", Type: " + s.displaySlotType().toString() + 
                                          ", "+ s.getCar().toString() + 
                                          ", Elapse time since car has been parked ~ Hours: " + hour + ", Minutes: " + minute + ", Seconds: " + second;

                        return newEntry;
                    } 
                }
            }
        }
        return "incorrect";
    }

  /**
   * Deleting car given car registration number
   *
   * @return Removal of car details from existing slot if registration number is valid
   */
    public void deleteCar(String regoNumber) {
        for (ParkingSlot s : slots) {
            if (s.getCar() != null) {
                String id = s.getCar().getRegistrationNumber();
                if (id.equals(regoNumber)) {
                    if (s.getCar() != null) {
                        s.removeCar();
                    } 
                }
            }
        }
    }

  /**
   * Check parking slot ID form
   *
   * @return boolean of true if matches the correct parking slot form is given eg. A01
   */
    public boolean checkParkingSlotId(String slotEntry) {

        if (slotEntry.matches("[A-Z][0-9]{2}")) {
            return true;
        }
        return false;
    }

  /**
   * Check car registration number form
   *
   * @return boolean of true if matches the correct car registration number form is given eg. A1234
   */
    public boolean checkCarRegistration(String regoEntry) {

        if (regoEntry.matches("[A-Z][0-9]{4}")) {
            return true;
        }
        return false;
    }

}
