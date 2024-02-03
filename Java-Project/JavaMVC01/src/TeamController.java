
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.Comparator;

public class TeamController {
    // Model Object
    // View Object
    private Team insTeam;
    private TeamView insTeamView;

    public TeamController(Team prm_insTeam, TeamView prm_insTeamView) {
        this.insTeam = prm_insTeam;
        this.insTeamView = prm_insTeamView;
    }

    //control moedel object
    public void setTeamName(String prm_name) {
        insTeam.setTeamName(prm_name);
    }

    public void setTeamScore(String prm_score) {
        insTeam.setTeamScore(prm_score);
    }

    public String getTeamName() {
        return insTeam.getTeamName();
    }

    public String getTeamScore() {
        return insTeam.getTeamScore();
    }

    //control view object
    public void updateView() {
        //insStudentView.printStudentDetails(insStudent.getStudId(), insStudent.getStudScore());
    }
    
    public void umInputDataToFileTeam(String prm_path_file_name) {
        try {
           Scanner in = new Scanner(System.in);
           int li_row = 0;
           String ls_student_id = "";
           String ls_score = "";
           String ls_input_flag = "";

           BufferedWriter writer = new BufferedWriter(new FileWriter(prm_path_file_name));           
           while (!ls_input_flag.toUpperCase().equals("N")) {
               
               System.out.printf("Team Name : ");             
               //ls_student_id = in.nextLine();           
               //insStudent.setStudId(ls_student_id); 
               insTeam.setTeamName(in.nextLine());                
               
               System.out.printf("Score : ");
               //ls_score = in.nextLine();
               insTeam.setTeamScore(in.nextLine());                
        
               li_row++;
               
               if (li_row == 1) {
                 writer.write(insTeam.getTeamName()+","+insTeam.getTeamScore());                 
               } else {
                 writer.write("\n"+insTeam.getTeamName()+","+insTeam.getTeamScore());                   
               }
               
               System.out.printf("Do you want to input data again [Y/N]?");
               ls_input_flag = in.nextLine();
            }
            writer.close();           
        } catch (IOException e) {
             e.printStackTrace();
        }         
    }
    
    public static void umReadFileCSVTeam(String prm_file_name) {
        String file = prm_file_name; //"src\\students.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
               String[] row = line.split(",");

               for (String index: row) {
                  System.out.printf("%-10s", index);
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
