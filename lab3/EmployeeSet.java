import java.io.*;
import java.util.*;

public class EmployeeSet{

    public static class Employee{
	String name;
	int no;
	int age;
	String state;
	int zip;
	//int[] advisor;
	
	//Constructor for Employee object
	public Employee(){
	    //System.out.println("Constructor called");
	    name=null;
	    no=0;
	    age=0;
	    state=null;
	    zip=0;
	    //advisor=null;		
	}
    }  
 
   
    //public static int icount;
    
    public static Employee[] em = null;
    public EmployeeSet(){
	final int initial_capacity=10;
	em = new Employee[initial_capacity];
	for (int i=0;i<initial_capacity;i++){
	    em[i]=new Employee();
	}
	//icount=0;
    }
    

    //Copy Constructor
    public EmployeeSet(Object obj) {
	if ((obj != null) && (obj instanceof Employee)){
	    // Creates new instance of Employee object Employee em= (Employee) obj;
	    EmployeeSet datacopy = (EmployeeSet) obj;
	    for (int i=0;i<datacopy.em.length;i++){
		this.em[i].name =new String(datacopy.em[i].name);
		this.em[i].no   = datacopy.em[i].no;
		this.em[i].age  = datacopy.em[i].age;
		this.em[i].state= new String(datacopy.em[i].state);
		this.em[i].zip  = datacopy.em[i].zip;
		//this.em[i].advisor = datacopy.em[i].advisor;
	    }
	}
    } // End of Copy Constructor
    

    public int size;
    public int size(){
	size=0;
	for (int i=0;i<this.em.length;i++){
	    if (em[i].name!=null){
		size++;
	    }
	}
	//System.out.println(size);
	return size;
    }
	
    public int capacity(){
	//System.out.println(this.em.length);
	return this.em.length;
    }


    public void add(Employee a){
	if ((a != null) && (a instanceof Employee)){
	    if (this.size()!=this.capacity()){
		//System.out.println("size"+this.size());
		//System.out.println("capacity"+this.capacity());
		int position=this.size();
		this.em[position].name=a.name;
		this.em[position].no=a.no;
		this.em[position].age =a.age;
		this.em[position].state =a.state;
		this.em[position].zip = a.zip;
	    }else{
		int icapacity=this.capacity();
		this.ensureCapacity(2*icapacity);
		int position=this.size();
		this.em[position].name=a.name;
		this.em[position].no=a.no;
		this.em[position].age =a.age;
		this.em[position].state =a.state;
		this.em[position].zip = a.zip;
	    }
	}
    }

    public boolean contains;
    public boolean contains(Employee a){
	if (a == null){
	    contains=false;
	    //System.out.println("oooooo");
	}else{
	    int isize= this.size();
	    for (int i=0;i<isize;i++){		
		if (this.em[i].no==a.no){
		    //System.out.println("found");
		    contains=true;
		    break;
		}else{
		    contains=false;
		}
	    }
	}
	return contains;
    }

    public boolean remove;
    public boolean remove(int eno){
	
	int isize= this.size();
	for (int i=0;i<isize;i++){		
	    if (this.em[i].no==eno){
		//System.out.println("found");
		//System.out.println(i);
		//System.out.println(this.em[i].no);		
		if (i!=isize-1){
		    for (int j=i+1;j<isize;j++){
			this.em[j-1].name =this.em[j].name;
			this.em[j-1].no   =this.em[j].no;
			this.em[j-1].age  =this.em[j].age;
			this.em[j-1].state=this.em[j].state;
			this.em[j-1].zip  =this.em[j].zip;
		    }
		    this.em[isize-1].name =null;
		    this.em[isize-1].no   =0;
		    this.em[isize-1].age  =0;
		    this.em[isize-1].state=null;
		    this.em[isize-1].zip  =0;
		}else{
		    this.em[i].name =null;
		    this.em[i].no   =0;
		    this.em[i].age  =0;
		    this.em[i].state=null;
		    this.em[i].zip  =0;
		}
		
		remove=true;
		break;
	    }else{
		remove=false;
	    }
	}
	return remove;
	
    }




    public void ensureCapacity(int minimumCapacity){
	if (minimumCapacity>=0){
	    
	    int isize=this.size();
	    System.out.println("Capacity of data collection before enlarging "+isize);
	    
	    /*
	    EmployeeSet datacp =null;
	    datacp =new EmployeeSet();
	    datacp.em = new Employee[minimumCapacity];
	    //Employee[] datacp = new Employee[minimumCapacity];
	    for (int i=0;i<minimumCapacity;i++){
		datacp.em[i]=new Employee();
	    }
	 
	    
	    //System.arraycopy(this.em, 0, datacp.em, 0, isize);
	    
	    for (int i=0;i<isize;i++){
		System.out.println(i);
		datacp.em[i].name=this.em[i].name;
		datacp.em[i].no   =this.em[i].no;
		datacp.em[i].age  =this.em[i].age;
		datacp.em[i].state=this.em[i].state;
		datacp.em[i].zip  =this.em[i].zip;
	    }

	    System.out.println("after copy to datacp: "+datacp.em[0].name);
	    System.out.println("after copy to datacp: "+this.em[0].name);
	    */

	    Employee[] datacp= new Employee[minimumCapacity];
		for (int i=0;i<minimumCapacity;i++){
		    datacp[i]=new Employee();
		}
	    System.arraycopy(this.em, 0, datacp, 0, isize);

	    
	    //System.out.println("after copy to datacp: "+datacp[0].name);
	    //System.out.println("after copy to datacp: "+this.em[0].name);
	    
	    /*this.em = new Employee[minimumCapacity];
	    for (int i=0;i<minimumCapacity;i++){
		this.em[i]=new Employee();
	    }

	    
	    	    
	    for (int i=0;i<isize;i++){
		System.out.println(i);
		this.em[i].name=new String(datacp[i].name);
		this.em[i].no   =datacp[i].no;
		this.em[i].age  =datacp[i].age;
		this.em[i].state=new String(datacp[i].state);
		this.em[i].zip  =datacp[i].zip;

	    }
	    */
	    //for (int i=0;i<minimumCapacity;i++){
	    //this.em[i]=datacp.em[i];
	    //}

	    this.em=datacp;
	    System.out.println("Capacity of data collection has been enlarged to "+this.em.length);
	}
    }
    
    public boolean addOrNot;
    public boolean ordered;
    public void addOrdered(Employee a){	
	
	for (int i=0;i<this.size()-1;i++){
	    if (this.em[i].no>this.em[i+1].no){
		ordered=false;
		System.out.println("Number array are not in ascending order");
	    }
	}
	
	if ((a != null) && (a instanceof Employee) && (ordered=true)){
	    if (this.size()!=this.capacity()){
		int isize=this.size();
		//System.out.println("size of current data collection "+isize);
		for (int i=0;i<isize;i++){
		    if (this.em[i].no>a.no){
			addOrNot=true;
			for (int j=isize;j>i;j--){
			    this.em[j].name =this.em[j-1].name;
			    this.em[j].no   =this.em[j-1].no;
			    this.em[j].age  =this.em[j-1].age;
			    this.em[j].state=this.em[j-1].state;
			    this.em[j].zip  =this.em[j-1].zip;
			}
			this.em[i].name =a.name;
			this.em[i].no   =a.no;
			this.em[i].age  =a.age;
			this.em[i].state=a.state;
			this.em[i].zip  =a.zip;
			break;
		    } 
		}
		if (addOrNot==false){
		    this.add(a);
		}
	    }else{
		int icapacity=this.capacity();
		this.ensureCapacity(2*icapacity);
		int isize=this.size();
		for (int i=0;i<isize;i++){
		    if (this.em[i].no>a.no){
			addOrNot=true;
			for (int j=isize;j>i;j--){
			    this.em[j].name =this.em[j-1].name;
			    this.em[j].no   =this.em[j-1].no;
			    this.em[j].age  =this.em[j-1].age;
			    this.em[j].state=this.em[j-1].state;
			    this.em[j].zip  =this.em[j-1].zip;
			}
			//System.out.println("add a.name "+a.name);
			this.em[i].name =a.name;
			this.em[i].no   =a.no;
			this.em[i].age  =a.age;
			this.em[i].state=a.state;
			this.em[i].zip  =a.zip;
			break;
		    }
		}
		if (addOrNot==false){
		    this.add(a);
		}
       	    }
	}	
    }



    public static void main(String[] args) {

        String fname="core_dataset.csv";
	int icount = 0; 
	String line = "";
	EmployeeSet data =null;	
	data = new EmployeeSet();
	try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);
	    // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

	    while((line = bufferedReader.readLine()) != null) {
                //parse line
		if(icount==0){
		    icount++;
                }else{
		    String[] lineStr = line.split(",");
		    if(lineStr.length!=0) {
			Employee addEm = new Employee();
			addEm.name=lineStr[0]+", "+lineStr[1];
			addEm.no=Integer.parseInt(lineStr[2]);
			addEm.age=Integer.parseInt(lineStr[6]);
			addEm.state=lineStr[3];
			addEm.zip=Integer.parseInt(lineStr[4]);
			data.addOrdered(addEm);
			
		    }    
                }
            }
            bufferedReader.close(); // Always close files.         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
	System.out.println("Finish reading data from file "+ fname);
	
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+"\t"+data.em[i].no);
	}

	
	/*
	EmployeeSet data =null;	
	data = new EmployeeSet();
	data.em[0].name="Tom";
	data.em[0].no=3;
	data.em[0].age=30;
	data.em[0].state="NM";
	data.em[0].zip=88005;


	Employee a = new Employee();
	a.name="Tommy";
	a.no=11;
	a.age=31;
	a.state="CA";
	a.zip=12048;
	data.add(a);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	Employee b = new Employee();
	b.name="Gordon";
	b.no=17;
	b.age=33;
	b.state="MA";
	b.zip=11488;
	data.add(b);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	
	System.out.println("\n");
	EmployeeSet datacp = new EmployeeSet(data);
	System.out.println("Copied data colleciton em[0].name: "+datacp.em[0].name);
	System.out.println("Number of element for copied data collection: "+datacp.size());
	System.out.println("Capacity of the copied data collection: "+datacp.capacity());

	
	
	System.out.println("\n");
	System.out.println("Contains Gordon? "+data.contains(b));
	System.out.println("Data in data collection ");
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}
	System.out.println("Removes employee with no 100? "+data.remove(100));
	System.out.println("Data in data collection ");
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	System.out.println("Removes employee with no 111? "+data.remove(111));
	System.out.println("Data in data collection ");
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	

	System.out.println("\n");
	System.out.println("Test addOrdered in the following");
	Employee c = new Employee();
	c.name="Germy";
	c.no=18;
	c.age=39;
	c.state="MI";
	c.zip=11678;
	
	data.addOrdered(c);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	
	System.out.println("\n");
	Employee d = new Employee();
	d.name="Jesus";
	d.no=8;
	d.age=23;
	d.state="MN";
	d.zip=11988;
	data.addOrdered(d);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}
	

	*/


	
    }
    
}
