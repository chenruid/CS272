package lab;
import java.io.*;
public class EmployeeFileOp {
	 
	
     private static String[][] data = new String[303][7];
	 private static int age[] = new int[302];
     public static void read(String csvFile){
	 //an array to store all the array
    	
	     String l = "";
         String cvsSplitBy = ",";
	     try {
	    	 int i = 0;
	    	 
	            FileReader fileReader = new FileReader(csvFile);

	            // BufferedReader class is a wrapper class for FileReader
	         BufferedReader bufferedReader= new BufferedReader(fileReader);
	         
	           
	            while((l = bufferedReader.readLine()) != null) {
	            	
	           
	            String [] tempdata = l.split(cvsSplitBy);
	            if(i == 0) {
	            	
	              data[i][0] = tempdata[0];// Employee name
	              data[i][1] = tempdata[1];// Employee number
	              data[i][2] = tempdata[2];// state
	              data[i][3] = tempdata[3];// zip
	              data[i][4] = tempdata[5];//age
	              data[i][5] = tempdata[6];//sex
	             
	            }// end if
	            
	            else if(i < 302) {
	            	data[i][0] = tempdata[0];// Last name
		            data[i][1] = tempdata[1];// First name
		            data[i][2] = tempdata[2];// Employee number
		            data[i][3] = tempdata[3];// State
		            data[i][4] = tempdata[4];// Zip
		            data[i][5] = tempdata[6]; // Age
		            data[i][6] = tempdata[7];// Sex
		            	               
		            
	               }
                i++;
            }// end loop
	       
	      
	     
	         bufferedReader.close();
	     }catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file ");                
	        }catch(IOException ex) {
	            System.out.println("Error reading file '");                  
	        }
	           System.out.println("Finish reading pairs from file ");

	     
	}// end read
   

	      
	
	
		public static void write (String csvFile) {
		try {
			
			// first create file object for file placed at location 
			File file = new File(csvFile);
			
			//// create FileWriter object with file as parameter
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(data[0][0]+","+data[0][1]+","+data[0][2]+","+data[0][3]+","+data[0][4]+","+data[0][5]+"\n");			
			
			
			for(int i= 1;i < 302;i++){ // write the data
				
			   try { 
				age[i]=Integer.parseInt(data[i][5]);
			   
			   } catch (NumberFormatException e) {
					age[i] = 100;
				}
				if (age[i] <= 30) {
					bufferedWriter.write(data[i][0]+","+data[i][1]+","+data[i][2]+","+data[i][3]+","+data[i][4]+","+data[i][5]+ ","+data[i][6]+"\n");			
				}
			
			
	
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing pairs to file ");
	} 
	
		public static void main(String[] args) {
		
		//read("test.txt");		
		//write("test_copy.txt"); 
			read("C:\\Users\\ruidc\\OneDrive\\Desktop\\core_dataset.csv");		
			write("young_employee.csv."); 
	
			} // end main
	
			}// end class
	

