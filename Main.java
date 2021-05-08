import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        Employee em = new Employee();
        ArrayList<Employee> list = new ArrayList<Employee>();
        Hashtable<String, Integer> Jn = new Hashtable<String, Integer>();
        Hashtable<String, Integer> Sn = new Hashtable<String, Integer>();
        Hashtable<String, Integer> Mn = new Hashtable<String, Integer>();

        System.out.println("========= LOGIN =========");
        System.out.print("    username: ");
        String us = sc.next();
        System.out.print("    password: ");
        int pass = sc.nextInt();
        System.out.println("=========================");

        // Account admin
        String useradmin = "admin";
        int passadmin = 1234;
        while(us != useradmin && pass != passadmin){
            System.out.println("Invalid username or password!!");
            System.out.println("\n========= LOGIN =========");
            System.out.print("    username: ");
            us = sc.next();
            System.out.print("    password: ");
            pass = sc.nextInt();
            System.out.println("==========================");
        }

        System.out.println("Login successfully!");

        while(loop) {

            System.out.println(" ______________ Employee Management _____________");
            System.out.println("|        1. Add new Employee in Database         |");
            System.out.println("|        2. Delete Employee in Database          |");
            System.out.println("|        3. Show Employee List                   |");
            System.out.println("|        4. Show Employee by Position            |");
            System.out.println("|        5. End Program                          |");
            System.out.println("|________________________________________________|");
            System.out.print("Please select the number 1-4 : ");
            int mainchoice = sc.nextInt();

            switch(mainchoice) {
                // ADMIN INTERFACE************
                case 1:
                System.out.println("____________________ Add new Employee ____________________");
                em = new Employee();
                System.out.print("|   Enter your ID: ");
                em.setID(sc.nextInt());
                System.out.print("|   Enter your Firstname: ");
                em.setFName(sc.next());
                System.out.print("|   Enter your Lastname: ");
                em.setLName(sc.next());
                System.out.print("|   Enter your Age: ");
                em.setAge(sc.nextInt());
                System.out.print("|   Enter your Work experience: ");
                em.setExp(sc.nextInt());
                System.out.print("|   Enter your position(Ex:Junior, Senior, Manager): ");
                em.setPos(sc.next());
                // Add array to arraylist
                list.add(em);
                // Add array to hashtable
                String posem = em.getPos();
                int idem = em.getID();
                String nameem = em.getFName();

                if(posem.equals("Junior") || posem.equals("junior")){
                    Jn.put(nameem, idem);
                } else if(posem.equals("Senior") || posem.equals("senior")) {
                    Sn.put(nameem, idem);
                } else if(posem.equals("Manager") || posem.equals("manager")) {
                    Mn.put(nameem, idem);
                } else {
                    System.out.println("Error: Not found this position!");
                    break;
                }
                
                System.out.println("__________________________________________________________");

                break;

                case 2:
                //Need Display this position*** 
                if(list.isEmpty() == true){
                    System.out.println("\n          [No Employee in database...]");
                } else {
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i));
                    }
                }
                System.out.println("__________________________________________________________");
                //Delete() method
                System.out.print("Choose ID of Employee that you want to delete: ");
                int deleteEm = sc.nextInt();
                
                list.removeIf((Employee e) -> e.getID() == (deleteEm));
                Jn.values().remove(deleteEm);
                Sn.values().remove(deleteEm);
                Mn.values().remove(deleteEm);
                break;

                case 3:
                //Need Display this position***
                if(list.isEmpty() == true){
                    System.out.println("\n          [No Employee in database...]");
                } else {
                    for(int i = 0; i < list.size(); i++){
                        System.out.println(list.get(i));
                    }
                }
                System.out.println("__________________________________________________________");
                break;
                
                case 4:
                System.out.println(" ________ Selection Employee's Position _______");
                System.out.println("|               1. Junior                      |");
                System.out.println("|               2. Senior                      |");
                System.out.println("|               3. Manager                     |");
                System.out.println("|______________________________________________|");
                System.out.print("Please select the number 1-3 : ");
                int subchoice = sc.nextInt();
                switch(subchoice) {
                    case 1:
                    System.out.println("______________________ Junior List _______________________\n");
                    if(Jn.isEmpty() == true){
                        System.out.println("\n          [No Employee in database...]");
                    } else {
                        for(String n : Jn.keySet()) {
                            System.out.println("[id:" + Jn.get(n) + "]----Name: " + n);
                        }
                    }
                    System.out.println("__________________________________________________________");
                    break;

                    case 2:
                    System.out.println("______________________ Senior List _______________________\n");
                    if(Sn.isEmpty() == true){
                        System.out.println("\n          [No Employee in database...]");
                    } else {
                        for(String n : Sn.keySet()) {
                            System.out.println("[id:" + Sn.get(n) + "]----Name: " + n);
                        }
                    }
                    System.out.println("__________________________________________________________");
                    break;

                    case 3:
                    System.out.println("_____________________ Manager List _______________________\n");
                    if(Mn.isEmpty() == true){
                        System.out.println("\n          [No Employee in database...]");
                    } else {
                        for(String n : Mn.keySet()) {
                            System.out.println("[id:" + Mn.get(n) + "]----Name: " + n);
                        }
                    }
                    System.out.println("__________________________________________________________");
                    break;

                    default:
                    System.out.println("Please enter 1-3");
                }
                break;

                case 5:
                loop = false;
                System.out.println("************ END PROGRAM ************");
                break;

                default:
                System.out.println("Please enter 1-3");

            }
        }
    }

}
