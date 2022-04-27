import java.util.Scanner;

class password {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Asking the user to input that how many password wanted
        System.out.println("How many random password you want? ");
        int total = in.nextInt();

        //Asking the user to input how long the password would be
        System.out.println("How long you want to be your password? ");
        int length = in.nextInt();

        String[] randomPasswords = new String[total];

        //Randomly generates passwords total numbers of times
        for(int i = 0; i < total; i++) {

            //Creating a veriable to store the random password
            String randomPassword = " ";
            
            for(int j = 0; j < length; j++) {

                //Add a random Lowercase or Uppercase charecter to our randomPassword string
                randomPassword += randomCharacter();
            }

            //Adding the random password in the array
            randomPasswords[i] = randomPassword;
        }

        //Printing the random password array
        printpassword(randomPasswords);

        //Calling the strength method
        System.out.println(getPasswordStrenth(length));
    }


    //This method gives a massage to strength of the password
    public static String getPasswordStrenth(int length) {
        if (length < 6) {
            return "WEAK PASSWORD";
        }

        else if (length < 10) {
            return "MEDIUM PASSWORD";
        }

        else {
            return "STRONG PASSWORD";
        }
    }


    //This function prints out an array that us passed in as a parameter
    public static void printpassword(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    //Creating this function to generate LOWERCASE or UPPERCASE and (0-9) using ASCII
    //where '0' - '9' => 48-57
    //'A' - 'Z' => 65-90
    //'a' - 'z' => 97-122
    public static char randomCharacter() {

        //We multiply Math.random() by 62 because there are 26 lowercase and 26 uppercase letters and 10 numbers (26+26+10=62)
        //This random number has values between 0 (inclusive) and 62 (exclusive)
        int rand = (int)(Math.random()*62);

        //0-61 inclusive = all possible values of rand
		//0-9 inclusive = 10 possible numbers/digits
		//10-35 inclusive = 26 possible uppercase letters
		//36-61 inclusive = 26 possible lowercase letters
		//If rand is between 0 (inclusive) and 9 (inclusive), we can say it's a number/digit
		//If rand is between 10 (inclusive) and 35 (inclusive), we can say it's an uppercase letter
		//If rand is between 36 (inclusive) and 61 (inclusive), we can say it's a lowercase letter
        if(rand <= 9) {

            //Number (48-57 in ASCII)
			//To convert from 0-9 to 48-57, we can add 48 to rand because 48-0 = 48
            int number = rand + 48;
            //This way, rand = 0 => number = 48 => '0'
			//Remember to cast our int value to a char!
            return (char)(number);
        }

        else if(rand <= 35) {

            //Uppercase letter (65-90 in ASCII)
			//To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
            int uppercase = rand + 55;
            //This way, rand = 10 => uppercase = 65 => 'A'
			//Remember to cast our int value to a char!
            return (char)(uppercase);
        }

        else {

            //Lowercase letter (97-122 in ASCII)
			//To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
            int lowercase = rand + 61;
            //This way, rand = 36 => lowercase = 97 => 'a'
			//Remember to cast our int value to a char!
            return (char)(lowercase);        
        }
    }
}