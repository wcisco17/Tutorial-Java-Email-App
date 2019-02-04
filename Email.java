import java.util.Scanner;

public class Email {
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private String department;
        private int mailboxCapacity = 500;
        private String alternateEmail;
        private String companySufix;

        private int passwordLength =10;

        public boolean bool = false;


        // Constructor to receive first and last name.
            public Email(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
               
                // Call for company name
                this.companySufix = setCompanyName();

                // Call a method asking for the deparment - return department
                this.department = setDepartment();


                // Call a method that returns a random password
                this.password = randomPassword(passwordLength);
                System.out.println("Your password is: " + this.password);

                // Generate Email
                email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "-" + companySufix;
            }
        
         public String setCompanyName() {
            String setCompanyName;
            Scanner in = new Scanner(System.in);
            

            System.out.println("Enter company name: ");

            bool = false;

            do {

                while(!in.hasNextLine()) {
                    System.out.println("Not the right value..");
                    in.next();
                }
                bool = true;
                setCompanyName = in.nextLine();
                
            } while (!bool);


            return setCompanyName + ".com";
         }

        // As for a department
        private String setDepartment() {
            int depChoice;
            Scanner in = new Scanner(System.in);

            System.out.println("Enter the deparment: \n1 for Sales\n2 for Development\n3 for Accounting\0 for none");

            do {
                while(!in.hasNextInt()) {
                    System.out.println("Not the right value..");
                    in.next();
                }
                
               depChoice = in.nextInt();
            } while(!(depChoice == 1) && !(depChoice == 2) && !(depChoice == 3));




                   switch (depChoice) {
                       case 1:
                           return "Sales";
                       case 2:
                           return "Dev";
                       case 3:
                           return "Acct";
                       default:
                           return "";
                           
                   }
       
        }

        //  Generate random password
        private String randomPassword(int length) {
            String passwordSet = "ABCDEFHIGKLMNOPQRT!#&*^";
            char[] password = new char[length];

            for (int i = 0; i < length; i++) {
                int random = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(random);
            }
            return new String(password);
        }

        // Set the mailbox capacity

        private void setMailboxCapacity(int capacity) {
            this.mailboxCapacity = capacity;
        }



        // Set the alternative email
        public void setAlernateEmail(String altEmail) {
            this.alternateEmail = altEmail;
   
        }
        
        // Change password
        public void changePassword(String password) {
            this.password = password;
        }

        public int getMailBoxCapacity() {
            return mailboxCapacity;
        }


        public String getAlternateEmail() {
            return alternateEmail;
        }

        public String getPassword() {
            return password;
        }

        public String showInfo() {
            return "DISPLAY NAME: " + firstName + " " + lastName + 
                        "\n" + 
                    "COMPANY EMAIL: " + email + 
                        "\n" + 
                    "MAILBOX CAPACITY: " + mailboxCapacity;
        }


}
