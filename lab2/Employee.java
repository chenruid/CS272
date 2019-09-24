
public class Employee {
   //instance variables
	private String name;
	private int no ;
	private int age ;
	private String state;
	private int code;
	private int[]advisor;

	//constructor 
	public Employee() {
		name = null;
		no = 0;
		age = 0;
		state = null;
		code = 0;
		advisor = new int[3];
	}// end no-argument constructor.
	
	public Employee(String n,int num,int a,String s,int c,int[]array) {
	name = n;
	no = num;
	 age = a;
	 state = s;
	 code = c;
	advisor = array;
	}
		//copy constructor 
	public Employee (Employee emp) {
	
	if(emp != null && emp instanceof Employee){
	// create new instance of Employee object
	
		this.name = new String(emp.name);
		this.state = new String(emp.state);
		this.no = emp.no;
		this.age = emp.age;
		this.code = emp.code;
		this.advisor= emp.advisor;
		
	}//end if
	
	}//end copy constructor
	
	//The getMethods of all the instance variables
	public String getName() {
		return name;
	}
	
	public int getNo() {
		return no;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getState() {
		return state;
	}
	
	public int getCode() {
		return code;
	}
	
	public int []getAdvisor() {
	    return advisor;
	}
	
	//The getMethods of all the instance variables
	
	public void setName(String n) {
		name = n;
	}
	
	public void setNo(int num) {
		no = num;
	}
	 
	public void setAge(int a) {
		age = a;
	}
	
	public void setState(String s) {
	     state = s;
	}

	public void setCode(int c) {
		 code = c;	
	}
	
	public void setAdvisor(int[] array) {
		 advisor = array;
	}
	
	//toString() method to generate a string representation of an employee.
	 
	public String toString() {
		System.out.print( "Name: " + name + "," + "Number: " + no + "," + "Age: " + age+ "," + "State: " + state + "," + "Code: " + code + "," + "Advisor: ");
		
		for(int j=0; j<3; j++) {
		   if(advisor[j] != 0) {
			   System.out.print( advisor[j] + " ");
		   }	
		}
	
		return "";
	}
	
	public boolean equals(Employee emp) {
		//emp1 is the calling object
		if(emp != null && emp instanceof Employee) {
			if(no == emp.getNo())
				return true;
		}// end if 
		return false;
    }// end boolean equals 
	
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		int []alladvisors = new int[6];
		if (e1 == null || e2 == null) {
			return null;
		}
		for (int i =0; i<3 ; i++) {
	        if(e1.getAdvisor()[i] != 0 && e2.getAdvisor()[i] != 0) {
				if(e1.getAdvisor()[i] == e2.getAdvisor()[i]) {
				alladvisors[i] = e1.getAdvisor()[i];
				}
		        if(e1.getAdvisor()[i] != e2.getAdvisor()[i]) {
			     alladvisors[i] = e1.getAdvisor()[i];
		         alladvisors[i+1] = e2.getAdvisor()[i];
		   
			} //end if 
		}//end if 
		}//end for 
		return alladvisors;
	}// end static method 
	
	public static void main(String[] args) { 
	   
		// create arrays
	   int []emp1advisor = {1,2,3};
	   int []emp2advisor = {2,3,4};
	   int []emp3advisor = {5,7,9};
	   int []emp4advisor = {7,8,9};
	
	   //test the constructor 
	   Employee emp1 = new Employee("Sam", 1, 20, "NM", 88001, emp1advisor);
	   Employee emp2 = new Employee("Tom", 2, 23, "MA", 88002, emp2advisor);
	   Employee emp3 = new Employee("Jane", 3, 28, "NY", 88003, emp3advisor);
	   Employee emp4= new Employee("Josh", 4, 20, "NM", 88004, emp4advisor);
	   
	   // test the set method
	   emp1.setName("Sam");
	   emp1.setNo(1);
	   emp1.setAge(20);
	   emp1.setState("NM");
	   emp1.setCode(88001);
	   emp1.setAdvisor(emp1advisor);
	 
	   // test the get method 
	   System.out.print("Name: " + emp2.getName()+ "," + "Number: " + emp2.getNo() + "," + "Age: " + emp2.getAge() + "," + "State: " + emp2.getState() + "," + "Code: " + emp2.getCode() + ","+"Advisors: ");
	   for (int i = 0; i< emp2advisor.length; i++) {
		   System.out.print(emp2advisor[i]+" ");
	   }
	   System.out.println();
	   
	   Employee emp5 = new Employee(emp1);// test the copy Method 
	   emp5.toString();// test the toString Method
      
	   System.out.println();
	   System.out.println(emp3.equals(emp2));//test the equals method
	   
	   int []tempar = new int[6];
	   
	   tempar = getAllAdvisors(emp1,emp4);
	   
	   
	   
	   for (int j =0; j <tempar.length ; j++) {
		   if(tempar[j] != 0)
		   System.out.print(tempar[j]);
	}
	   
	} // end main
	
	
}// end class
