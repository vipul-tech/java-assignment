package emp.assignment; 

import java.io.*;
import java.sql.*;
import java.util.*;

abstract class Emp implements Serializable  
{
	static int empCount = 0;  

    	int empID;
    	String name;
    	int age;
    	int salary;
    	String desig;

    	public Emp(int salary, String desig)
    	{
        	this.getDetails();
        	this.salary = salary;
        	this.desig = desig;
        	EmpDAO dao = new EmpDB();                 
        	dao.save(this);
    	}
    	private void getDetails()
    	{
        	empID = InValidIDException.getID();
        	name = InValidNameException.getName();
        	age = InValidAgeException.getAge();
    	}

    	public String toString()
    	{
        	System.out.println("EmpID : "+empID);
        	System.out.println("Name : "+name);
        	System.out.println("Age : "+age);
        	System.out.println("Salary : "+salary);
        	System.out.println("Designation : "+desig);
        	System.out.println();
        	return null;
    	}

    	public abstract void raiseSalary();

    	public static void display(){       
        	EmpDAO dao = new EmpDB();
        	dao.display();
    	}

    	public static void delete(){      
        	System.out.println("Enter Employee ID ");
        	int empid = new Scanner(System.in).nextInt();
        	EmpDAO dao = new EmpDB();
        	dao.findByID(empid);
        	System.out.println("Do you really want to remove the Employee (Y/N) ");
        	char ch = new Scanner(System.in).next().charAt(0);

        	if (Character.toUpperCase(ch) == 'Y'){
            		dao.delete(empid);
        	}
    	}

    	public static void update(){ 
        	EmpDAO dao = new EmpDB();
        	dao.update();
    	}
	public static void findByID(){ 
        	EmpDAO dao = new EmpDB();
        	dao.findByID();
    	}
	public static void findByNumber(){ 
        	EmpDAO dao = new EmpDB();
        	dao.findByNumber();
    	}
	public static void sortBy(int c){ 
        	EmpDAO dao = new EmpDB();
        	dao.sortBy(c);
    	}
	public static void first(){ 
        	EmpDAO dao = new EmpDB();
        	dao.first();
    	}
	public static void last(){ 
        	EmpDAO dao = new EmpDB();
        	dao.last();
    	}
}

final class Clerk extends Emp
{
    	Clerk()
    	{ 
        	super(10000, "Clerk");
    	}
    	public void raiseSalary(){
        	salary += 2000;
    	}
}
final class Programmer extends Emp
{
    	Programmer()
    	{
        	super(25000, "Programmer");
    	}
    	public void raiseSalary()
    	{
        	salary += 5000;
    	}
}
final class Manager extends Emp
{
    	Manager()
    	{
        	super(80000, "Manager");
    	}
    	public void raiseSalary()
    	{
        salary += 10000;
    	}
}

public class EmpMainDatabase
{
	public static void main(String args[])
	{
		int ch1 = 0, ch2 = 0 ,ch3 = 0;
        	do
		{
			System.out.println("-----------------");
			System.out.println("  1. Create ");
			System.out.println("  2. Display ");
			System.out.println("  3. Raise Salary ");
            		System.out.println("  4. Remove ");
			System.out.println("  5. Search ");
			System.out.println("  6. Exit ");
			System.out.println("-----------------");
			System.out.print("Enter choice : ");
			try {
                		ch1 = new Scanner(System.in).nextInt();      
            		}
			catch (Exception e){
                		System.out.println("Please Enter correct choice (Number Only)");
                		continue;
            		}
			if(ch1==1)
			{
				do
				{
					System.out.println("-----------------");
					System.out.println("  1. Clerk ");
					System.out.println("  2. Programmer ");
					System.out.println("  3. Manager ");
					System.out.println("  4. Exit ");
					System.out.println("-----------------");
					System.out.print("Enter choice : ");
					try {
                        			ch2 = new Scanner(System.in).nextInt();                
                    			}
					catch (Exception e){
                        			System.out.println("Please Enter correct choice (Number Only)");
					    	continue;
                    			}
					switch(ch2)
					{
						case 1 : new Clerk();   
							 Emp.empCount++;
							 break;
						case 2 : new Programmer();      
							 Emp.empCount++;
							 break;
						case 3 : new Manager();     
							 Emp.empCount++;
							 break;
					}

				}while(ch2 != 4);
			}
			if(ch1==2)
			{
				Emp.display();
			}
			if(ch1==3)
			{
			    	Emp.update();
			}
			if (ch1 == 4){
			    	Emp.delete();
            		}
			if (ch1 == 5){
				do
				{
					System.out.println("-----------------");
					System.out.println("  1. By ID ");
					System.out.println("  2. By Record Number ");
					System.out.println("  3. Sort By ");
					System.out.println("  4. First ");
					System.out.println("  5. Last ");
					System.out.println("  6. Exit ");
					System.out.println("-----------------");
					System.out.print("Enter choice : ");
					try {
                        			ch2 = new Scanner(System.in).nextInt();                
                    			}
					catch (Exception e){
                        			System.out.println("Please Enter correct choice (Number Only)");
					    	continue;
                    			}
					switch(ch2)
					{
						case 1 : Emp.findByID();
							 break;
						case 2 : Emp.findByNumber();
							 break;
						case 3 : do
							 {
								System.out.println("-----------------");
								System.out.println("  1. Sort By Emp ID ");
								System.out.println("  2. Sort By Name ");
								System.out.println("  3. Sort By Salary ");
								System.out.println("  4. Sort By Age ");
								System.out.println("  5. Sort By Designation ");
								System.out.println("  6. Exit ");
								System.out.println("-----------------");
								System.out.print("Enter choice : ");
								try {
                        						ch3 = new Scanner(System.in).nextInt();
									Emp.sortBy(ch3);                
                    						}
								catch (Exception e){
                        						System.out.println("Please Enter correct choice (Number Only)");
									continue;
								}
                    					 }while(ch3!=6);
							 break;
						case 4 : Emp.first();
							 break;
						case 5 : Emp.last();
							 break;
					}

				}while(ch2 != 6);
			}
		}while(ch1 != 6);
        	System.out.println("Total Employee count = "+ Emp.empCount);
	}
}

class InValidIDException extends Exception{
    	public InValidIDException(){}
    	public InValidIDException(String msg){
        	super(msg);
    	}
    	public static int getID(){
        	while (true) {
            		System.out.print("Enter ID : ");
            		try {
                		int id = new Scanner(System.in).nextInt();
                		if (id <= 0 )
                    			throw new InValidIDException(" ID must be positive !! ");
                		else
                    			return id;
           		}
			catch(InputMismatchException e){
                		System.out.println("Please Enter correct ID (Numbers Only) !! ");
            		}
			catch (InValidIDException e){
                		System.out.println(" Please enter positive number !! ");
            		}
        	}
    	}
}

class InValidAgeException extends Exception{
    	public InValidAgeException(){}
    	public InValidAgeException(String msg){
        	super(msg);
    	}

    	public static int getAge(){
        	while (true) {
            		System.out.print("Enter age : ");
            		try {
                		int age = new Scanner(System.in).nextInt();
                		if (age < 21 || age > 60)
                    			throw new InValidAgeException("out of limit. Enter age between 21 - 60... ");
                		else
                    			return age;
            		}
			catch (InputMismatchException e){
                		System.out.println("Please Enter correct age (Numbers Only) !! ");
            		}
			catch (InValidAgeException e){
                		System.out.println("Please Enter age between 21 - 60 !! ");
            		}
        	}
    	}
}
class InValidNameException extends Exception{
    	public InValidNameException(){}
    	public InValidNameException(String msg){
        	super(msg);
    	}

    	public static String getName(){
        	while (true) {
            		System.out.print("Enter name : ");
            		try {
                		String name = new Scanner(System.in).next();
                		if (!name.matches("^[a-zA-Z]*$"))
                    			throw new InValidNameException("Please enter between a to z");
                		else
                    			return name;
            		}
			catch (InValidNameException e) {
                		System.out.println(e.getMessage());
            		}
        	}
    	}
}

interface EmpDAO{
    	public void save(Emp e);
    	public void update();
    	public void display();
	public void findByID(int empid);
    	public void delete(int empid);
//--------------------------------------
	public void findByID();
	public void findByNumber();
	public void sortBy(int c);
	public void first();
	public void last();
}

class EmpDB implements EmpDAO{
    	static Connection con;
    	static
    	{
        	try{
            		Class.forName("oracle.jdbc.driver.OracleDriver");
            		con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","12345");
        	}
		catch(ClassNotFoundException | SQLException e){
            		e.printStackTrace();
        	}
   	 }

    	public void save(Emp e){
        	int i =0;
        	String query = "insert into employee values(?,?,?,?,?)";
        	try {
            		PreparedStatement ps = con.prepareStatement(query);
            		ps.setInt(1, e.empID);
            		ps.setString(2, e.name);
            		ps.setInt(3, e.age);
            		ps.setInt(4, e.salary);
            		ps.setString(5, e.desig);
            		i = ps.executeUpdate();
			ps.close();
        	}
		catch (SQLException ex) {
            		ex.printStackTrace();
        	}
        	System.out.println();
    	}

    	public void delete(int empid){  
        	int i=0;
        	String query = "delete from employee where empid=?";
        	try {
            		PreparedStatement ps = con.prepareStatement(query);
            		ps.setInt(1,empid);
            		i = ps.executeUpdate();
			ps.close();
        	}
		catch (SQLException e) {
            		e.printStackTrace();
        	}
   	}

   	public void update(){ 
        	                             
        	try {
            		CallableStatement cstmt = con.prepareCall("CALL empl()");
            		cstmt.execute();
			cstmt.close();
        	}
		catch (SQLException e) {
            		e.printStackTrace();
        	}
    	}

    	public void display(){
        	String query = "select * from employee";
        	try {
            		PreparedStatement ps = con.prepareStatement(query);
            		ResultSet res = ps.executeQuery();
            		while (res.next()){
                		System.out.println("EmpID : "+res.getInt(1));
                		System.out.println("Name : "+res.getString(2));
                		System.out.println("Age : "+res.getInt(3));
                		System.out.println("Salary : "+res.getInt(4));
                		System.out.println("Designation : "+res.getString(5));
                		System.out.println();
            		}
			res.close();
			ps.close();
        	} 
		catch (SQLException e) {
            		e.printStackTrace();
        	}
    	}

	public void findByID(int empid){
        	String query = "select * from employee where empid = "+empid;
        	try {
            		PreparedStatement ps = con.prepareStatement(query);
            		ResultSet res = ps.executeQuery();
            		while (res.next()){
                		System.out.println("EmpID : "+res.getInt(1));
                		System.out.println("Name : "+res.getString(2));
                		System.out.println("Age : "+res.getInt(3));
                		System.out.println("Salary : "+res.getInt(4));
                		System.out.println("Designation : "+res.getString(5));
                		System.out.println();
            		}
        	}
		catch (SQLException e){
            		e.printStackTrace();
        	}
    	}
//-------------------------------------------------------------
    	public void findByID(){
		int empid;
		System.out.println("Enter Emp ID : ");
		Scanner sc = new Scanner(System.in);
		empid=sc.nextInt();
        	String query = "select * from employee where empid = "+empid;
        	try {
            		PreparedStatement ps = con.prepareStatement(query);
            		ResultSet res = ps.executeQuery();
            		while (res.next()){
                		System.out.println("EmpID : "+res.getInt(1));
                		System.out.println("Name : "+res.getString(2));
                		System.out.println("Age : "+res.getInt(3));
                		System.out.println("Salary : "+res.getInt(4));
                		System.out.println("Designation : "+res.getString(5));
                		System.out.println();
            		}
			res.close();
			ps.close();
        	}
		catch (SQLException e){
            		e.printStackTrace();
        	}
    	}


	public void findByNumber(){
		int num;
		System.out.println("Enter Emp record number : ");
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
        	//String query = "select * from employee where empid = "+empid;
        	try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            		ResultSet res = stmt.executeQuery("select * from employee");
			res.absolute(num);
            		{
                		System.out.println("EmpID : "+res.getInt(1));
                		System.out.println("Name : "+res.getString(2));
                		System.out.println("Age : "+res.getInt(3));
                		System.out.println("Salary : "+res.getInt(4));
                		System.out.println("Designation : "+res.getString(5));
                		System.out.println();
            		}
			res.close();
			stmt.close();
        	}
		catch (SQLException e){
            		e.printStackTrace();
        	}
    	}

	public void first(){
        	try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            		ResultSet res = stmt.executeQuery("select * from employee");
			res.first();
            		{
                		System.out.println("EmpID : "+res.getInt(1));
                		System.out.println("Name : "+res.getString(2));
                		System.out.println("Age : "+res.getInt(3));
                		System.out.println("Salary : "+res.getInt(4));
                		System.out.println("Designation : "+res.getString(5));
                		System.out.println();
            		}
			res.close();
			stmt.close();
        	}
		catch (SQLException e){
            		e.printStackTrace();
        	}
    	}

	public void last(){
        	try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            		ResultSet res = stmt.executeQuery("select * from employee");
			res.last();
            		{
                		System.out.println("EmpID : "+res.getInt(1));
                		System.out.println("Name : "+res.getString(2));
                		System.out.println("Age : "+res.getInt(3));
                		System.out.println("Salary : "+res.getInt(4));
                		System.out.println("Designation : "+res.getString(5));
                		System.out.println();
            		}
			res.close();
			stmt.close();
        	}
		catch (SQLException e){
            		e.printStackTrace();
        	}
    	}

	public void sortBy(int ch2){
		
			try{
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            		ResultSet res=null;
			switch(ch2)
			{
				case 1 : res = stmt.executeQuery("select * from employee order by empid");
					 while (res.next()){
                				System.out.println("EmpID : "+res.getInt(1));
                				System.out.println("Name : "+res.getString(2));
                				System.out.println("Age : "+res.getInt(3));
                				System.out.println("Salary : "+res.getInt(4));
                				System.out.println("Designation : "+res.getString(5));
                				System.out.println();
            				 }
					 break;
				case 2 : res = stmt.executeQuery("select * from employee order by name");
					 while (res.next()){
                				System.out.println("EmpID : "+res.getInt(1));
                				System.out.println("Name : "+res.getString(2));
                				System.out.println("Age : "+res.getInt(3));
                				System.out.println("Salary : "+res.getInt(4));
                				System.out.println("Designation : "+res.getString(5));
                				System.out.println();
            				 }
					 break;
				case 3 : res = stmt.executeQuery("select * from employee order by salary");
					 while (res.next()){
                				System.out.println("EmpID : "+res.getInt(1));
                				System.out.println("Name : "+res.getString(2));
                				System.out.println("Age : "+res.getInt(3));
                				System.out.println("Salary : "+res.getInt(4));
                				System.out.println("Designation : "+res.getString(5));
                				System.out.println();
            				 }
					 break;
				case 4 : res = stmt.executeQuery("select * from employee order by age");
					 while (res.next()){
                				System.out.println("EmpID : "+res.getInt(1));
                				System.out.println("Name : "+res.getString(2));
                				System.out.println("Age : "+res.getInt(3));
                				System.out.println("Salary : "+res.getInt(4));
                				System.out.println("Designation : "+res.getString(5));
                				System.out.println();
            				 }
					 break;
				case 5 : res = stmt.executeQuery("select * from employee order by desig");
					 while (res.next()){
                				System.out.println("EmpID : "+res.getInt(1));
                				System.out.println("Name : "+res.getString(2));
                				System.out.println("Age : "+res.getInt(3));
                				System.out.println("Salary : "+res.getInt(4));
                				System.out.println("Designation : "+res.getString(5));
                				System.out.println();
            				 }
					 break;
			}
			res.close();
			stmt.close();
        		}
			catch (SQLException e){
            			e.printStackTrace();
        		}
			
	}
}
