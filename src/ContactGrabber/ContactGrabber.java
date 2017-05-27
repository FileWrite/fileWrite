package ContactGrabber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class ContactGrabber {
    public static void main(String[] args) throws IOException {

        String directory = "data";
        String filename = "contactNames.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        List<String> contacts = Files.readAllLines(dataFile);

        do {

            System.out.println("---------------------");
            System.out.println("MENU:");
            System.out.println("\t1. View contacts.\n" +
                    "\t2. Add a new contact.\n" +
                    "\t3. Search a contact by name.\n" +
                    "\t4. Delete an existing contact.\n" +
                    "\t5. Exit.\n"+
                    "Enter an option (1, 2, 3, 4 or 5):\n");

            Scanner userInput = new Scanner(System.in);
            int input = userInput.nextInt();

            if ( input ==5){
                Files.write(
                        Paths.get("data","contactNames.txt"),contacts);
                System.exit(0);
            } //end option 5

            if (input == 4) {    //---------------------
                  System.out.println("Which contact would you like to delete");
                }

            if (input == 1) {    //---------------------
                for (String line : contacts) {
                    System.out.println(line);
                }
            } else if (input == 2) {   //-----------------

                System.out.println("enter contact name: ");
                String ContactName = userInput.next();

                System.out.println("enter contact number");
                String ContactNumber = userInput.next();

                contacts.add(ContactName + " | " + ContactNumber + "\n");

            } else if (input == 3) {
                System.out.println("Enter name to search for\n-------------------");
                String searchName = userInput.next();
                Boolean found = false;

                for(String contact : contacts) {
                    if (contact.toLowerCase().contains(searchName.toLowerCase())) {
                        System.out.print("\nThe search term was found in this contact :" + contact +"\n");
                        found=true;
                    }
                }
                if (!found) {
                    System.out.println("No result found for: " + searchName);
                }

                else if ( input ==5){
                    Files.write(
                            Paths.get("data","contactNames.txt"),contacts);
                    System.exit(0);
                } //end option 5

                //else if (input ==4){
                  //  System.out.println("you entered #4");
                //}else System.out.println("enter a valid menu option");

            }//end of choice #3


        } while (true);

    }//end psvm
}// end class
