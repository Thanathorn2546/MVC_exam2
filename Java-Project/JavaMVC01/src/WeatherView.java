
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WeatherView {
    public void umReadFileCSVWeather(String prm_file_name) {
        String file = prm_file_name; 
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("Date "+ "         "+"Temp.");            
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
               String[] row = line.split(",");

               for (String index: row) {
                  //System.out.printf("%-10s", index);                  
                  printWeatherDetailsLine(index);
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

    public void printWeatherDetailsLine(String prm_index) {      
        System.out.printf("%-10s", prm_index);        
    }    
    
    public void printWeatherDetails(String prm_team_name, String prm_team_score) {
        System.out.println("Weather Details: ");
        System.out.println("Date.: "+prm_team_name);
        System.out.println("Temperature: "+prm_team_score);        
    }     
}
