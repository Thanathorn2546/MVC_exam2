
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeatherController {
    // Model Object
    // View Object
    private Weather insWeather;
    private WeatherView insWeatherView;

    public WeatherController(Weather prm_insWeat, WeatherView prm_insWeatView) {
        this.insWeather = prm_insWeat;
        this.insWeatherView = prm_insWeatView;
    }

    //control moedel object
    public void setWeatherDate(String prm_name) {
        insWeather.setWeatDate(prm_name);
    }

    public void setWeatherTemp(String prm_temp) {
        insWeather.setWeatTemp(prm_temp);
    }

    public String getWeatherName() {
        return insWeather.getWeatDate();
    }

    public String getWeatherTemp() {
        return insWeather.getWeatTemp();
    }

    //control view object
    public void updateView() {
        //insStudentView.printStudentDetails(insStudent.getStudId(), insStudent.getStudScore());
    }

    public void umInputDataToFileWeather(String prm_path_file_name) {
        try {
           Scanner in = new Scanner(System.in);
           int li_row = 0;
           String ls_student_id = "";
           String ls_score = "";
           String ls_input_flag = "";

           BufferedWriter writer = new BufferedWriter(new FileWriter(prm_path_file_name));           
           while (!ls_input_flag.toUpperCase().equals("N")) {
               
               System.out.printf("Date : ");             
               //ls_student_id = in.nextLine();           
               //insStudent.setStudId(ls_student_id); 
               insWeather.setWeatDate(in.nextLine());                
               
               System.out.printf("Temp. : ");
               //ls_score = in.nextLine();
               insWeather.setWeatTemp(in.nextLine());                
        
               li_row++;
               
               if (li_row == 1) {
                 writer.write(insWeather.getWeatDate()+","+insWeather.getWeatTemp());                 
               } else {
                 writer.write("\n"+insWeather.getWeatDate()+","+insWeather.getWeatTemp());                   
               }
               
               System.out.printf("Do you want to input data again [Y/N]?");
               ls_input_flag = in.nextLine();
            }
            writer.close();           
        } catch (IOException e) {
             e.printStackTrace();
        }         
    }
    
    public static void umResdFileCSVWeather(String prm_file_name) {
        String file = prm_file_name; //"src\\students.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
               String[] row = line.split(",");

               for (String index: row) {
                  System.out.printf("%-206s", index);
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
}
