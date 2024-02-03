
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentView {
    
    public void umReadFileCSVStudent(String prm_file_name) {
        String file = prm_file_name; //"src\\students.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            System.out.println("Student Id. "+ "         "+"Student Score");            
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
               String[] row = line.split(",");

               for (String index: row) {
                  //System.out.printf("%-10s", index);                  
                  printStudentDetailsLine(index);
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

    public void printStudentDetailsLine(String prm_index) {      
        System.out.printf("%-10s", prm_index);        
    }
    
    public void printStudentDetails(String prm_stud_id, String prm_stud_score) {
        System.out.println("Student Details: ");
        System.out.println("Student Id.: "+prm_stud_id);
        System.out.println("Student Score: "+prm_stud_score);       
    }
}    

