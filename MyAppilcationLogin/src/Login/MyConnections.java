package Login; 

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;  
import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MyConnections {  
    static Connection con = null;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static Properties p;
    
    public void connection() throws Exception {   
    FileReader reader = new FileReader("C:\\Users\\This pc\\Documents\\NetBeansProjects\\MyAppilcationLogin\\src\\Login\\login.properties");        
    p = new Properties();  
    p.load(reader);        
        try {         
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            System.out.println("step 1");  
            con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("uname"),p.getProperty("upass"));  
            System.out.println("Connection Set");
        } catch(Exception e){ 
            System.out.println(e);
        }  
    }
    
    
    public void addUser(CreateAccount acc) throws Exception {
        System.out.println("Method:{} addUser");
        String querry = "INSERT INTO Alice.USER_INFO (ID, FIRSTNAME, LASTNAME,USERNAME,EMAIL,PHONE,PASSWORD) VALUES (?,?,?,?,?,?,?)"; 
        try {
            System.out.println("tr1");
//                long id = System.currentTimeMillis();
                UUID uid = UUID.randomUUID();
                pst = con.prepareStatement(querry);
                System.out.println("tr2");
                pst.setString(1, uid.toString());
                pst.setString(2,acc.getFname());
                pst.setString(3,acc.getLname());
                pst.setString(4,acc.getUser());
                pst.setString(5,acc.getEmail());
                pst.setString(6,acc.getPhone());
                pst.setString(7,acc.getPassword());
                System.out.println("try it");
                int count = pst.executeUpdate();
                System.out.println("Execute-update:"+count);                               
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
            con.close(); 
        }
    }
    
    
    public void loginUser(Login_Application app) throws Exception{
        System.out.println("Method:{} loginUser");
        String user = app.getUser();
        String pass = app.getPassword();
        String querry = "SELECT username, password FROM Alice.USER_INFO WHERE USERNAME = '"+user+"' AND PASSWORD = '"+pass+"'";
        try {
            System.out.println("try-1");   
            st = con.createStatement();
            rs = st.executeQuery(querry);
            System.out.println("try it");            
            if (rs.next()) {
            String usernameFromDB = rs.getString("USERNAME");
            System.out.println("Username: " + usernameFromDB);  
            app.dispose();
            new MainPage().setVisible(true);   
            } else {
              System.out.println("No username found in the database.");
              JOptionPane.showMessageDialog(null, "No such user exists Login");
           }                   
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            st.close();
            con.close(); 
        }
    }

    
    public void deleteUser() {
        try{  
            st= con.createStatement();
            String querry = "DELETE FROM Alice.USER_INFO WHERE id = 99";
            rs = st.executeQuery(querry);
        }catch(Exception e){ 
            System.out.println(e);
        } 
    }
    
    
    public void listUsers(MainPage obj){
        try{
            st= con.createStatement();
            rs=st.executeQuery("SELECT * FROM Alice.USER_INFO");
            while(rs.next()) {
             System.out.println(rs.getLong(1)+" "+ rs.getString(2)+" "+ rs.getString(3)+" "+ rs.getString(4)+" "+ rs.getString(5)+" "+ rs.getString(6)+" "+ rs.getString(7));             
             String id = String.valueOf(rs.getLong("id"));
             String fname = String.valueOf(rs.getString("firstname"));
             String lname = String.valueOf(rs.getString("lastname"));
             String username = String.valueOf(rs.getString("username"));
             String email = String.valueOf(rs.getString("email"));
             String phone = String.valueOf(rs.getString("phone"));
             String password = String.valueOf(rs.getString("password"));
             String tableData[] = {id, fname, lname,username,email,phone,password};
             DefaultTableModel tbModel = (DefaultTableModel)obj.jTable1.getModel();          
             tbModel.addRow(tableData);
            }
            System.out.println("Execute");
            con.close();  
            System.out.println("Close");
        } catch(Exception e){ 
            System.out.println(e);
        }
    }
    
    
    public static void sendMail(String recpMail) throws MessagingException, FileNotFoundException, IOException {
      System.out.println("sending mail setting");
      FileReader reader = new FileReader("C:\\Users\\This pc\\Documents\\NetBeansProjects\\MyAppilcationLogin\\src\\Login\\login.properties");        
      p = new Properties();  
      p.load(reader);
      p.put("mail.smtp.auth", p.getProperty("auth"));
      p.put("mail.smtp.starttls.enable", p.getProperty("starttls.enable"));
      p.put("mail.smtp.host"    ,   p.getProperty("host"));
      p.put("mail.smtp.port", p.getProperty("port"));
        
      final String myAcc = p.getProperty("myAcc");
      final String password = p.getProperty("password");
      System.out.println("sending mail account");
      Session session = Session.getInstance(p,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(myAcc, password);
            }
	});
      System.out.println("sending mail authentication");
      Message mesg = prepareMessage(session, myAcc, recpMail);
      Transport.send(mesg);
      System.out.println("done");
    }
    
    
    private static Message prepareMessage(Session session, String myAcc, String recpMail) {
        try{System.out.println("try 1");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAcc));            
	    message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(recpMail));
	    message.setSubject("Demo Mail");
            System.out.println("try 2");
	    message.setContent(
             "<div style=\"border: 3px double #0d6efd; padding: 1rem;\">\n" +
"                    <h1 style=\"padding-top: 5px;padding-bottom: 20px;text-align: center;color: #0d6efd; font-size: 35px;\"> \n" +
"                        In Mail \n" +
"                    </h1>\n" +
"\n" +
"                        <table style=\"width:100%;\" id=\"lg_table\">\n" +
"                            <tr>\n" +
"                            <th style=\"text-align: left;\"> <b>FROM:</b></th>\n" +
"                            <th style=\"text-align: left;\"> <b>TO:</b></th>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td style=\"width:50%; font-size: 14px; color: #0d6efd;\" th:text=${}\"\">Alice Khan</td>\n" +
"                                <td style=\"width:50%; font-size: 14px; color: #0d6efd;\" th:text=\"\">Nida Khan</td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td style=\"width:50%; font-size: 14px ;\" th:text=\"\">Java</td>\n" +
"                                <td style=\"width:50%; font-size: 14px ;\" th:text=\"\">SRM</td>\n" +
"                            </tr>\n" +
"                            \n" +
"                            <tr>\n" +
"                                <td style=\"width:50%; font-size: 14px ;\" th:text=\"\">Agra</td>\n" +
"                                <td style=\"width:50%; font-size: 14px ;\" th:text=\"\">Delhi</td>\n" +
"                            </tr>\n" +
"                        </table> <hr> </div>",
             "text/html");
            System.out.println("33 try");
           return message;
        }catch(Exception ex){
            System.out.println("exception arises:"+ex);
        }
        System.out.println("try ok");
        return null;
    }
}  