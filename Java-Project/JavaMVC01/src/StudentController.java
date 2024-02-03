
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentController {
    // Model Object
    // View Object
    private Student insStudent;
    private StudentView insStudentView;

    public StudentController(Student prm_insStudent, StudentView prm_insStudentView) {
        this.insStudent = prm_insStudent;
        this.insStudentView = prm_insStudentView;
    }

    //control model object
    public void setStudentId(String prm_id) {
        insStudent.setStudId(prm_id);
    }

    public void setStudentScore(String prm_score) {
        insStudent.setStudScore(prm_score);
    }

    public String getStudentId() {
        return insStudent.getStudId();
    }

    public String getStudentSscore() {
        return insStudent.getStudScore();
    }

    //control view object
    public void updateView() {
        //insStudentView.printStudentDetails(insStudent.getStudId(), insStudent.getStudScore());
    }
    
    public void umInputDataToFileStudent(String prm_path_file_name) {
        try {
           Scanner in = new Scanner(System.in);
           int li_row = 0;
           String ls_student_id = "";
           String ls_score = "";
           String ls_input_flag = "";

           BufferedWriter writer = new BufferedWriter(new FileWriter(prm_path_file_name));           
           while (!ls_input_flag.toUpperCase().equals("N")) {
               
               System.out.printf("Student Id. : ");             
               //ls_student_id = in.nextLine();           
               //insStudent.setStudId(ls_student_id); 
               insStudent.setStudId(in.nextLine());                
               
               System.out.printf("Score : ");
               //ls_score = in.nextLine();
               insStudent.setStudScore(in.nextLine());                
        
               li_row++;
               
               if (li_row == 1) {
                 writer.write(insStudent.getStudId()+","+insStudent.getStudScore());                 
               } else {
                 writer.write("\n"+insStudent.getStudId()+","+insStudent.getStudScore());                   
               }
               
               System.out.printf("Do you want to input data again [Y/N]?");
               ls_input_flag = in.nextLine();
            }
            writer.close();           
        } catch (IOException e) {
             e.printStackTrace();
        }         
    } 
    
    public static void umResdFileCSVStudent(String prm_file_name) {
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
