import java.lang.System;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] arqs) {       
        int li_topic_no = 0;
        Scanner in = new Scanner(System.in); 
        System.out.println("================================");  
        System.out.println("   Topic 1 Input Student        ");     
        System.out.println("   Topic 2 Input Team"           );  
        System.out.println("   Topic 3 Input Weather        "); 
        System.out.println("   Topic 4 Show Student   ");     
        System.out.println("   Topic 5 Show Team      ");  
        System.out.println("   Topic 6 Show Weather   ");         
        System.out.println("================================");          
        System.out.printf("Please choose topic? ");
                 
        li_topic_no = Integer.parseInt(in.nextLine()); 
        if (li_topic_no == 1) {
           Student insStudent = new Student();
           StudentView insStudentView = new StudentView();     
           StudentController insStudentController = new StudentController(insStudent,insStudentView);
            
           //===== Input File Student =====//       
           insStudentController.umInputDataToFileStudent("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_stadent_data.txt");            
        } else if (li_topic_no == 2) {
           Team insTeam = new Team();
           TeamView insTeamView = new TeamView();     
           TeamController insTeamController = new TeamController(insTeam,insTeamView);
            
           //===== Input File Student =====//       
           insTeamController.umInputDataToFileTeam("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_team_data.txt");                        
        } else if (li_topic_no == 3) {
           Weather insWeather = new Weather();
           WeatherView insWeatherView = new WeatherView();     
           WeatherController insWeatherController = new WeatherController(insWeather,insWeatherView);
            
           //===== Input File Student =====//       
           insWeatherController.umInputDataToFileWeather("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_weather_data.txt");                                    
        } else  if (li_topic_no == 4) {
           Student insStudent = new Student();
           StudentView insStudentView = new StudentView();     
           StudentController insStudentController = new StudentController(insStudent,insStudentView);
            
           //===== Show File Student =====//       
           //insStudentController.umResdFileCSVStudent("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_stadent_data.txt");                        
           insStudentView.umReadFileCSVStudent("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_stadent_data.txt");                                   
        } else  if (li_topic_no == 5) {
           Team insTeam = new Team();
           TeamView insTeamView = new TeamView();     
           TeamController insTeamController = new TeamController(insTeam,insTeamView);
            
           //===== Show File Team =====//       
           //insTeamController.umReadFileCSVTeam("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_team_data.txt"); 
           insTeamView.umReadFileCSVTeam("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_team_data.txt");                                           
        } else  if (li_topic_no == 6) {
           Weather insWeather = new Weather();
           WeatherView insWeatherView = new WeatherView();     
           WeatherController insWeatherController = new WeatherController(insWeather,insWeatherView);
            
           //===== Show File Weather =====//       
           //insWeatherController.umResdFileCSVWeather("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_weather_data.txt");                                                
           insWeatherView.umReadFileCSVWeather("D:\\Java-Project\\JavaMVC01\\example_read_file_csv\\input_weather_data.txt");                                         
        }
    }      
}

