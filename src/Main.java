import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        user_Inputs inputs = new user_Inputs();

        //calling input class
        inputs.prompt_Tickets();

        TicketConfiguration config = TicketConfiguration.fromUserInputs(inputs);

        System.out.println("Configuration Details : ");
        System.out.println(config);

        config.save_To_Json("Configuration.json");
    }
}

//instance variables to store inputs
class user_Inputs{
    private int total_Ticket_Numbers;
    private int ticket_Release_Rate;
    private int customer_Retrieval_Rate;
    private int maximum_Ticket_Capacity;


    //method to collect inputs
    public void prompt_Tickets() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Total Number of Tickets : ");
        this.total_Ticket_Numbers = scan.nextInt();

        System.out.println("Enter Ticket Release Rate : ");
        this.ticket_Release_Rate = scan.nextInt();

        System.out.println("Customer Retrieval Rate : ");
        this.customer_Retrieval_Rate = scan.nextInt();

        System.out.println("Enter Maximum Ticket Capacity : ");
        this.maximum_Ticket_Capacity = scan.nextInt();

    }

    //getter methods
    public int getTotal_Ticket_Numbers() {
        return total_Ticket_Numbers;
    }

    public int getTicket_Release_Rate() {
        return ticket_Release_Rate;
    }

    public int getCustomerRetrieval_Rate() {
        return customer_Retrieval_Rate;
    }

    public int getMaximum_Ticket_Capacity() {
        return maximum_Ticket_Capacity;
    }

}

