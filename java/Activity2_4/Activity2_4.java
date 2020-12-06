package Activity2_4;

public class Activity2_4 {
	
    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println("The String is : " + str);
        }
    }

	public static void main(String[] args){
        try {
            Activity2_4.exceptionTest("Will print to console");
            Activity2_4.exceptionTest("Won't execute");
            Activity2_4.exceptionTest(null);
        } 
        catch(CustomException ce) {
        	System.out.println("Inside catch block: " + ce.getMessage());
        }
    }

}