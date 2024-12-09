import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Scanner;

public class TicketConfiguration implements Serializable {
    private class ticket_Data {
        private int total_Ticket_Numbers;
        private int ticket_Release_Rate;
        private int customer_Retrieval_Rate;
        private int maximum_Ticket_Capacity;

        public TicketConfiguration(){}

        public void TicketConfiguration(int total_Ticket_Numbers,
                                   int ticket_Release_Rate,
                                   int customer_Retrieval_Rate,
                                   int maximum_Ticket_Capacity ){
            this.total_Ticket_Numbers = total_Ticket_Numbers;
            this.ticket_Release_Rate = ticket_Release_Rate;
            this.customer_Retrieval_Rate = customer_Retrieval_Rate;
            this.maximum_Ticket_Capacity = maximum_Ticket_Capacity;
        }

        //getters
        public int getTotal_Ticket_Numbers() {
            return total_Ticket_Numbers;
        }

        public int getTicket_Release_Rate() {
            return ticket_Release_Rate;
        }

        public int getCustomer_Retrieval_Rate() {
            return customer_Retrieval_Rate;
        }

        public int getMaximum_Ticket_Capacity() {
            return maximum_Ticket_Capacity;
        }

        //setters
        public void setTotal_Ticket_Numbers(int total_Ticket_Numbers) {
            this.total_Ticket_Numbers = total_Ticket_Numbers;
        }

        public void setTicket_Release_Rate(int ticket_Release_Rate) {
            this.ticket_Release_Rate = ticket_Release_Rate;
        }

        public void setCustomer_Retrieval_Rate(int customer_Retrieval_Rate) {
            this.customer_Retrieval_Rate = customer_Retrieval_Rate;
        }

        public void setMaximum_Ticket_Capacity(int maximum_Ticket_Capacity) {
            this.maximum_Ticket_Capacity = maximum_Ticket_Capacity;
        }

        public void save_To_Json (String filename) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try (FileWriter writer = new FileWriter(filename)){
                gson.toJson(this, writer);
                System.out.println("Configuration saved to " + filename);
            }
            catch (IOException e){
                System.out.println("Error saving configuration to " + e.getMessage());
            }

        }

        public static TicketConfiguration fromUserInputs(user_Inputs inputs){
            return new TicketConfiguration(
                    inputs.getTotal_Ticket_Numbers(),
                    inputs.getTicket_Release_Rate(),
                    inputs.getCustomerRetrieval_Rate(),
                    inputs.getMaximum_Ticket_Capacity()
            );
        }

    }
}
