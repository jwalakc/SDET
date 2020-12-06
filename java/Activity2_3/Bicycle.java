 package Activity2_3;
 
 class Bicycle implements BicycleParts, BicycleOperations {

	    public int gears;
	    public int currentSpeed;

	    //the Bicycle class has one constructor
	    public Bicycle(int gears, int currentSpeed) {
	        this.gears = gears;
	        this.currentSpeed = currentSpeed;
	    }

	    //Bicycle class has three methods
	    @Override
	    public void applyBrake(int decrement) {
	        currentSpeed -= decrement;
	        System.out.println("Current speed after applying brake: " + currentSpeed);
	    }
	    
	    @Override
	    public void speedUp(int increment) {
	        currentSpeed += increment;
	        System.out.println("Current speed after speeding up: " + currentSpeed);
	    }

	    //Method to print info of Bicycle
	    public String bicycleDesc() {
	        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
	    }
	}