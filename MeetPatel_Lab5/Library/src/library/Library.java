/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
/**
 *
 * @author Meet Patel
 */
public class Library {
    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) {
        // TODO code application logic here
        
    try{
        Class.forName("org.sqlite.JDBC");
    }catch(java.lang.ClassNotFoundException e){
        System.err.print("ClassNotFoundException: ");
        System.err.println(e.getMessage());             
    }    
    String url = "jdbc:sqlite:library.db"*/    
    //Connection con = DriverManager.getConnnection(url, "myLogin", "myPassword" );}}
   public static void main(String[]args) throws SQLException{
      while(true){
          function1();
      }
    } 
        
 public static void function1(){      
      Scanner sc = new Scanner(System.in);
        char li=14;
        Connection c =null;
        Statement statement=null;
        ResultSet resultset=null;
      
    try{
        Class.forName("org.sqlite.JDBC");
    }  catch(java.lang.ClassNotFoundException e){
        System.err.println("ClassNotFoundException");
        System.err.println(e.getMessage());
        
         }
 try{
          c = DriverManager.getConnection("jdbc:sqlite:lab5.db");
          statement = c.createStatement();           
          System.out.println("1: Show the List of Books with an Amazing Rating Greater than 4.5");
          System.out.println("2: Show the List of Books which are Fiction or NonFiction");
          System.out.println("3: Which Books came Between Year 2010 and 2012");
          System.out.println("4: What is the Highest Price of the BOOK");
          System.out.println("5: Name of Authors with More than 1 Book");
          System.out.println("6: What is the Book with a specific ISBN number");
          System.out.println("7: What is the Name of the Author who wrote a specific Book");
          System.out.println("8: Name of the Book which was bought by a Particular Customer");
          System.out.println("9: What are the Total Number of Warehouses in Particular Location ?");
          System.out.println("10:What are the Books which Fall Between Certain Price Range ? ");
          System.out.println("11:Inserting new Data to the Database?");
          System.out.println("12: Update the Following Table in the Database ?");
          System.out.println("13: Delete the Following Table in the Database?");
          //Asking for userinput
           System.out.print("Select any option :");
           Scanner s = new Scanner(System.in);
           int userinput = s.nextInt();
           s.nextLine();
        
          //Case Statments
          switch(userinput){
            
              case 1:
                   String sql;
                   sql = "SELECT BookName,AmazonRating FROM BOOK";
                   ResultSet result= statement.executeQuery(sql);
                    
                    while(result.next()){
                    double amzrating= result.getDouble("AmazonRating");
                    String name =result.getString("BookName");
                         if(amzrating>4.5){
                         System.out.println("BookName :"+name+li+"AmazonRating : "+amzrating);
                         System.out.println();
                        }
                    }
                    System.out.println("\n");
                    System.out.println("-----------------------------------------------------------");
                    break;
              case 2:
                      sql ="SELECT BOOKNAME,Genre FROM BOOK";
                      result =statement.executeQuery(sql);
                      ArrayList<String> store1 = new ArrayList<String>();
                       ArrayList<String> store2 = new ArrayList<String>();
                      
                      while(result.next()){ 
                   
                          String nonfiction = result.getString("Genre");
                          String name =result.getString("BookName");
                           String fiction =result.getString("Genre");
                          if(nonfiction.equals("NonFiction")){
                              store1.add(name);
                          }
                         if(fiction.equals("Fiction")){
                             store2.add(name);
                             
                         }
//                        
                      } 

                        System.out.println("Nonfiction List->\n"); 
                        for(String line:store1){
                            System.out.println("-->"+line);
                        }
                        System.out.println("\n");
                       System.out.println("fiction List->\n"); 
                        for(String line:store2){
                            System.out.println("-->"+line);
                        }

                      System.out.println("\n");
                      System.out.println("-----------------------------------------------------------");

                break;
              case 3:
                      sql ="SELECT BOOKNAME,PublicationDate FROM BOOK";
                      result =statement.executeQuery(sql);
                     int d1= 20100101;
                     int d2= 20120101;
                      
                      while(result.next()){ 
                         
                           String name =result.getString("BookName");
                           
                           int datestring =result.getInt("PublicationDate");
                           if(d1<datestring && datestring<d2){
                               System.out.println("-->"+name);
                           }
              
                      }
                   System.out.println("\n");
                      System.out.println("-----------------------------------------------------------");      
                     
                break;     
                
              case 4:
                  sql ="SELECT Max(Price) AS MaxPrice, BookName  FROM BOOK";
                  result= statement.executeQuery(sql);
//                  Integer Maxvalue = new Integer(-1);
                  if(result.next()){
                    int w =result.getInt("MaxPrice");
                    String name=result.getString("BookName");
                    System.out.println("Name :"+name+"  "+"Price :"+w);
                     
                  }
                System.out.println("\n");
                System.out.println("-----------------------------------------------------------"); 
                  break;
                  
              case 5:

                sql ="select Authorname from Author where AuthorId in "
                +"(select AuthorId from BookAuthor group by authorid having count(AuthorId)> 1)";
                   result =statement.executeQuery(sql);
                  
                  while(result.next()){
                      String so =result.getObject("Authorname").toString();
                      
                      System.out.println("--->"+so);
                   }
                  
                     System.out.println("\n");
                      System.out.println("-----------------------------------------------------------");      
                     
//                   }
               
                   break;
                   
              case 6:
                   sql ="SELECT BookName,ISBN FROM BOOK WHERE ISBN == 143039644;";
                    result= statement.executeQuery(sql);
                    while(result.next()){
                        int isbn = result.getInt("ISBN");
                        String name =result.getString("BookName");
                        if(isbn == 143039644){
                            System.out.println("Name of Book with specified ISBN : "+ name);
                        }
                    }
                  System.out.println("\n");
                  System.out.println("-----------------------------------------------------------");      
                         
                break;
                
                 
          
          case 7:
   sql ="select AuthorName FROM Author WHERE AuthorId=(SELECT AuthorID FROM "
           + "Author WHERE AuthorId=(SELECT AuthorId FROM BOOK WHERE BookName='Asylum '))";
                  result= statement.executeQuery(sql);
//                  Integer Maxvalue = new Integer(-1);
                  if(result.next()){
                    String w =result.getString(1);
                   // String name=result.getString("BookName");
                    System.out.println("Name of Author of Book Asylum is :" + w);
                     
                  }
                System.out.println("\n");
                System.out.println("-----------------------------------------------------------"); 
                  break;
  case 8:
            sql ="select BOOKName FROM BOOK WHERE BOOKId=("
         + "SELECT BOOKID FROM BOOK WHERE BOOKId=(SELECT BookId FROM Customer WHERE CustomerName='Kiley'))";
                  result= statement.executeQuery(sql);
//                  Integer Maxvalue = new Integer(-1);
                  if(result.next()){
                    String w =result.getString(1);
                   // String name=result.getString("BookName");
                    System.out.println("Name of Books whose Author is Kiley    :" + w);
                     
                  }
                System.out.println("\n");
                System.out.println("-----------------------------------------------------------"); 
                  break;
         
  case 9:
      sql= "Select count(*) FROM Warehouse WHERE location='NewYork'";
      result = statement.executeQuery(sql);
      while(result.next()){
          int count = result.getInt(1);
          System.out.println(" Number of Warehouses in NewYork: "+ count);
      }
       System.out.println("\n");
                System.out.println("-----------------------------------------------------------"); 
                  break;

   case 10:
      sql ="SELECT * FROM BOOK WHERE price > 10 AND price < 20";
       ArrayList<String> store3 = new ArrayList<String>();
      result = statement.executeQuery(sql);
         while(result.next()){
          store3.add(result.getString(2));          
      }
        System.out.println("  Books which fall between price range of 10 and 20: ");
           for(String line:store3){
           System.out.println("-->"+line) ;} 
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------"); 
        break;
        case 11:
                        statement = c.createStatement(); 
                        System.out.println("Please enter the Name of the Book:");
                        String Name = sc.nextLine();
                        System.out.println("Please enter the Price of the Book:");
                        String Price = sc.nextLine();
                        System.out.println("Please enter the ISBN number of the Book:");
                        String ISBN = sc.nextLine();
                        System.out.println("Please enter the Language of the Book:");
                        String Language = sc.nextLine();
                        System.out.println("Please enter the Book is Fiction or NonFiction");
                        String FictionNonFiction = sc.nextLine();
                        System.out.println("Please enter the PublicationDate of the Book");
                        String PublicationDate = sc.nextLine();
                        statement.executeUpdate("INSERT INTO BOOK (BookName, Price, ISBN, Language, Genre, PublicationDate, AmazonRating) VALUES ("+"'"+Name+"'"+","+"'"+Price+"'"+","+"'"+ISBN+"'"+","+"'"+Language+"'"+","+"'"+FictionNonFiction+"'"+","+"'"+PublicationDate+"'"+","+"'NULL"+"');"); 
                        System.out.println("New User Successfully Inserted in the DATABASE !!!!");
                        System.out.println("--------------------------------");
        break; 
        case 12:
          statement = c.createStatement();
           sql = "UPDATE BOOK set Price = 25.67 where BookId=6;";
            statement.executeUpdate(sql);
            System.out.println("Price is now 25.67");
            break;
        case 13:
                   statement = c.createStatement();
                  sql = "DELETE from BOOK where BookId=10;";
                  System.out.println("BookId is now Deleted");
                    statement.executeUpdate(sql);
                    break;            
        default:
        System.out.println(" Select between 1-14: ");
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------"); 
        break;
         
          }          
       //   System.out.println(result.getString(3));
       
        
        //  statement.close();
          //resultset.close();
          c.close();
          
 }   
      //   statement.close();
 
 catch(SQLException ex){
        System.err.println("--------SQL Exception--------");
         System.err.println("SqlState"+ex.getSQLState());
         System.err.println("Message"+ex.getMessage());
        System.err.println("Vendor"+ex.getErrorCode());
  }
}
}
    
