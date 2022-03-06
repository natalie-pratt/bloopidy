package week_5;

import java.util.*;

import static input.InputUtils.*;

/**
 * A t-shirt vendor works at week-long events.  Each event runs for 5 days, from Monday to Friday.
 *
 * The vendor needs to store data about every event. They need to save the
 *
 *    - Name of the event
 *    - T-shirts sold on Monday at that event
 *    - T-shirts sold on Tuesday at that event
 *    - T-shirts sold on Wednesday at that event
 *    - T-shirts sold on Thursday at that event
 *    - T-shirts sold on Friday at that event
 *
 *  For every event.  You may not know all the data about an event when it
 *  is created in the data store, but you will know the name and at least one day of sales.
 *
 *  Complete this program to gather, and analyse data, about t-shirt sales.
 *  You'll need to decide what data structure to use to store the data.
 *  Hint: your data structure may need to contain other data structures
 *
 *  Your data structure should support these tasks:
 *    - Add a new event and sales for a day
 *    - Add another day sales for an existing event
 *    - Return an array of 5 days of sales for one event
 *    - Check if an event exists in the data structure
 *    - Calculate if a day of sales is above average for the week of sales
 *
 *  Use the exact strings "Monday", "Tuesday", "Wednesday", "Thursday" and "Friday"
 *  to add and search for data in your data structure.
 *  Optional: you can add helper methods to validate and make user input easier.
 *
 *  One of the tests will always fail. Part of your grade will be from human review of your code,
 *  the data structure you choose, and how you implement the required methods.
 *
 *  NOTE the tests don't know what data structure you will use. Several tests check
 *  your code by calling your addSalesForDay method to add example data, and then call your other
 *  method in sequence and checking that the expected data is returned.
 *  *So, all the tests will fail until you create your data structure, and finish the addSalesForDay method.*
 */

public class Question_5_Sales_Records {
    
    // This array may be useful, or not. The only valid days to store sales data for are Monday through Friday.
    List<String> validDays = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    Map <String, Map<String, Integer>> eventInfo = new HashMap<>();
    
    public static void main(String[] args) {
        new Question_5_Sales_Records().sales();   // Don't modify this
    }

    public void sales() {
        
        // You may edit this as needed, to help test the methods in your program
        
        // Testing adding data
        
        do {
            String event = stringInput("Enter event name");
            String day = stringInput("Enter day of week");
            int quantity = positiveIntInput("Enter t-shirts sold on " + day + " at " + event);
            addSales(event, day, quantity);
        } while (yesNoInput("More sales data to add?"));
        
        // Testing getting event data
    
        System.out.println("Fetching Event Data");
        
        String event = stringInput("Enter event name");
        System.out.println("Does event exist? " + eventExists(event));
        System.out.println("All sales data for event: " + Arrays.toString(salesForEvent(event)));
        
        // Test comparing a day to the average for the week
    
        System.out.println("Comparing a day to the average for the event week");
        event = stringInput("Enter event name");
        String day = stringInput("Enter day of the week");
        
        if (daySaleAtOrAboveAverageForWeek(event, day)) {    // note this will crash until you have implemented daySaleAtOrAboveAverageForWeek method
            System.out.printf("Sales for event %s on day %s are at or above average.\n", event, day);
            System.out.println("All sales for " + event + " are " + Arrays.toString(salesForEvent(event)));
        }
        else {
            System.out.printf("Sales for event %s on day %s are below average.\n", event, day);
            System.out.println("All sales for " + event + " are " + Arrays.toString(salesForEvent(event)));
        }
        
        // Test comparing an event that doesn't exist to the average for the week
        if (daySaleAtOrAboveAverageForWeek("Don't exist", "Wednesday") == null) {
            System.out.println("Event does not exist");
        }
    
        // Test comparing a day that doesn't exist to an average. Only Monday-Friday are valid days.
        addSales("PyCon", "Wednesday", 10);
        if (daySaleAtOrAboveAverageForWeek("PyCon", "Saturday") == null) {
            System.out.println("Day or event name does not exist");
        }
    
    
    }
    
    
    public void addSales(String event, String day, int quantity) {
        
        for (String eventKey : eventInfo.keySet()) {

            if (!validDays.contains(day)) {

                break;

            }
            
            if (!eventInfo.containsKey(event)) {
                
                Map<String, Integer> newEventInfo = new HashMap<>();
                newEventInfo.put(day, quantity);
                eventInfo.put(event, newEventInfo);
                
                
            } else if (eventInfo.containsKey(event) && !eventInfo.get(event).containsKey(day)) {

                eventInfo.get(event).put(day, quantity);

            } else {

                eventInfo.get(event).put(day, quantity);

            }
            
        }
        

    }
    
    
    public int[] salesForEvent(String event) {

        if (!eventInfo.containsKey(event)) {

            return null;

        }
        System.out.println(event);

        int[] weeklySales = new int[5];

        for (int x = 0; x < eventInfo.get(event).size(); x++) {



        }

    
    }
    
    
    public boolean eventExists(String event) {
        // TODO return true if the event has been created
        // TODO return false otherwise.
    
        throw new RuntimeException("Not implemented");  // TODO Delete and replace with your code.
    
    }
    
    
    public Boolean daySaleAtOrAboveAverageForWeek(String event, String day) {
        
        // TODO return null if the event name is not found in your data structure
        // TODO return null if the day of the week is not a valid day in your data structure
        //     (only Monday - Friday are valid. The check should be case sensitive.)
        
        // TODO use the data in your data structure to analyse the sales data for
        // one event. Calculate the average sales per day for the sales data present
        // return true if the sales for day are at or above average
        // return false if the sales for day are below average
        // return false if no data is recorded for that day
        
        // Example: the vendor works at JavaCon. Sales are Monday = 4, Tuesday = 2, Wednesday = 6, Thursday = 6, Friday = 3.
        // All 5 days have sales recorded. The total sales are 21. The average sales are 21/5 = 4.2.
        // If this method is called for JavaCon on Tuesday, it will return false.
        // If this method is called for JavaCon on Wednesday, it will return true.
        
        // Example: the vendor works at PythonCon. Sales are Monday = 5, Tuesday = (no data set - default to zero), Wednesday = 0, Thursday = 5, Friday = 4.
        // The total sales are 14. The average sales for the week is 14/5 = 2.8.
        // If this method is called for PythonCon on Monday, it will return true.
        // If this method is called for PythonCon on Tuesday, it will return false.
        // If this method is called for PythonCon on Wednesday, it will return false.
    
        throw new RuntimeException("Not implemented");  // TODO Delete and replace with your code.
    
    }
    
}
