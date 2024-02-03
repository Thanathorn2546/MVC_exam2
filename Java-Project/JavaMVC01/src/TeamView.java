
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeamView {
    public void umReadFileCSVTeam(String prm_file_name) {
        String file = prm_file_name; 
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("Team Name "+ "         "+"Team Score");            
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
               String[] row = line.split(",");

               for (String index: row) {
                  //System.out.printf("%-10s", index);                  
                  printTeamDetailsLine(index);
               }
               System.out.println();
               
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();               
            }
            catch (IOException e) {
                e.printStackTrace();                
            }
        }
    }

    public void printTeamDetailsLine(String prm_index) {      
        System.out.printf("%-10s", prm_index);        
    }
    
    public void printTeamDetails(String prm_team_name, String prm_team_score) {
        System.out.println("Team Details: ");
        System.out.println("Team Name.: "+prm_team_name);
        System.out.println("Team Score: "+prm_team_score);        
    }    
}
