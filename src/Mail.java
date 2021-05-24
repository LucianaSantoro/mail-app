import com.sun.corba.se.spi.ior.IdentifiableFactory;

import javax.activation.DataSource;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Mail {


    private String password;
    private String name;
    private String lastName;
    private String mainMail;
    private String alternativeMail;
    private String department;
    private Integer mailCapacity;
    private Integer menuChoice;
    private String companyName;
    private String currentPassword;


    Scanner keyboard = new Scanner(System.in);

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMainMail() {
        return mainMail;
    }

    public void setMainMail(String mainMail) {
        this.mainMail = mainMail;
    }

    public String getAlternativeMail() {
        return alternativeMail;
    }

    public void setAlternativeMail(String alternativeMail) {
        this.alternativeMail = alternativeMail;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getMailCapacity() {
        return mailCapacity;
    }

    public void setMailCapacity(Integer mailCapacity) {
        this.mailCapacity = mailCapacity;
    }

    public Mail() {
    }

    public Mail(String password, String name, String lastName, String mainMail, String alternativeMail, String department, Integer mailCapacity) {
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.mainMail = mainMail;
        this.alternativeMail = alternativeMail;
        this.department = department;
        this.mailCapacity = mailCapacity;
    }

    @Override
    public int hashCode() {
        return 42 * Objects.hash(this.password, this.currentPassword) ;
    }

    @Override
    public String toString() {
        return "Mail { Password = "
                + password + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null ){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        if(this == obj){
            return true;
        }
        Mail mail = (Mail)obj;
        if(this.name != mail.password||this.currentPassword != mail.currentPassword){
            return false;
        }
        return true;
    }


    public void mainMenu() {
        int continueMenu;
        do {
            System.out.println("########    Welcome to the corporate mail generator    #########\n");
            printMenu();
            menuChoice = keyboard.nextInt();

            switch (menuChoice) {
                case 1:
                    askPersonalInformation();
                    generateCorporateMail();
                    generateRandomPassword();
                    break;
                case 2:
                    changePassword();
                    break;
                case 3:
                    setMailboxCapacity();
                    break;
                case 4:
                    generateAlternativeMail();
                    break;
                default:
                    System.out.println("Invalid number, please try again.");
                    break;
            }
            System.out.println("Would you like to make any more changes? \n1) Yes\n2) No");
            continueMenu = keyboard.nextInt();

        } while (continueMenu == 1);
    }

    private void printMenu() {
        System.out.println("#################    Choose an option    ######################");
        System.out.println(" | 1 | Set personal information");
        System.out.println(" | 2 | Change password");
        System.out.println(" | 3 | Set alternative mail");
        System.out.println(" | 4 | Change mailbox capacity");
    }


    public void askPersonalInformation() {
        System.out.println("Please enter your name.");
        name = keyboard.next();

        System.out.println("Please enter your lastname.");
        lastName = keyboard.next();

        System.out.println("Do you belong to a job department? \n1) Yes\n2) No");
        int option = keyboard.nextInt();
        if (option == 1) {
            int continueMenu;
            do {
                System.out.println("Enter your department: ");
                System.out.println("| 1 | Sales");
                System.out.println("| 2 | Development");
                System.out.println("| 3 | Accounting");

                int departmentOption = keyboard.nextInt();

                    switch (departmentOption) {
                    case 1:
                        department = "sales.";
                        break;
                    case 2:
                        department = "dev.";
                        break;
                    case 3:
                        department = "acc.";
                        break;
                    default:
                        System.out.println("Invalid number, please try again.");
                        break;
                }
                System.out.println("Would you like to make any more changes? \n1) Yes\n2) No");
                continueMenu = keyboard.nextInt();

            } while (continueMenu == 1);
        } else {
            department = "";
        }

        System.out.println("Please enter your company name.");
        companyName = keyboard.next();
    }


    public void generateRandomPassword() {

        // **** Code from: https://www.programiz.com/java-programming/examples/generate-random-string ****

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String password = sb.toString();
        System.out.println("Your password is " + password);
    }

    public void changePassword() {
        // hay que validar con el pass anterior?

        int continueMenu;
        do {
            System.out.println("Enter current password: ");
            currentPassword = keyboard.next();


            if (currentPassword.equals(password)) {// TODO tampoco agarró el equals
                System.out.println("Enter new password: ");
                password = keyboard.next();
                System.out.println("Your new password is: " + password);

            } else {
                System.out.println("Invalid password.");
            }
            System.out.println("Would you like to change your password again?\n\t1) Yes\n\t2) No");
            continueMenu = keyboard.nextInt();
        } while (continueMenu == 1);
    }

    public String generateCorporateMail() {
        if (department.isEmpty()) {
            mainMail = name + lastName + "@" + companyName + ".com";
        } else {
            mainMail = name + lastName + "@" + department + "." + companyName + ".com";
        }
        System.out.println(mainMail);
        return mainMail;
    }

    public void setMailboxCapacity() {

        Boolean continueMenu;

        do {
            System.out.println("########      Set the mailbox capacity     ##########");
            System.out.println("| 1 | 1 GB");
            System.out.println("| 2 | 5 GB");
            System.out.println("| 3 | 10 GB");
            System.out.println("| 4 | 25 GB");

            int option = keyboard.nextInt();
            switch (option) {
                case 1:
                    mailCapacity = 1;
                    continueMenu = false;
                    break;
                case 2:
                    mailCapacity = 5;
                    continueMenu = false;
                    break;
                case 3:
                    mailCapacity = 10;
                    continueMenu = false;
                    break;
                case 4:
                    mailCapacity = 25;
                    continueMenu = false;
                    break;
                default:
                    System.out.println("Invalid number, please try again.");
                    continueMenu = true;
                    break;
            }
        } while (continueMenu == true);
    }

    public void generateAlternativeMail() {
        System.out.println("Please enter your secondary mail.");
        alternativeMail = keyboard.next();

    }

}
