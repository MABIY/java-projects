package chapter6;
/**
 * Following the form of the example Lunch.java,creat a class called
 * ConnectionManager that manages a fixed array of Connection objects, but
 * can only get them via a static method in ConnectionManager. When ConnectionManager
 * run out of objects, it returns a null reference, Test the class in main().
 * @author liu.hua
 */

class Connection{
    private static int count = 0;
    private int i =0;
    private Connection(){
        i = count;
        System.out.println("Connection: " +i);
    }

    //Allow creation via static method:
    static Connection makeConnection(){
        count++;
        return new Connection();
    }
    public static int howMany() {
        return count;
    }

    public String toString(){
        return ("Connection " + count);
    }
}
public class ConnectionManager {
   static int howManyLeft =3;

   static Connection[] ca =new Connection[howManyLeft];
    {
        for(int i = 0; i < ca.length; i++) {
            ca[i] = Connection.makeConnection();
        }
    }

    public static Connection getConnection(){
        if(howManyLeft >0){
            return ca[--howManyLeft];
        }else {
            System.out.println("No more connection");
            return null;
        }
    }

    public static void main(String[] args){
        ConnectionManager cm = new ConnectionManager();
        System.out.println(cm.howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);

    }
}
