package Activity2_1;

public class MyBook extends Book{
	
	@Override
	public void setTitle(String s) {
	title = s;	
	}	
	  public static void main(String []args) {
	      String title = "Harry Potter";	;
	      MyBook newNovel = new MyBook();
	      newNovel.setTitle(title);
	      System.out.println("The title is: " + '"' + newNovel.getTitle() + '"');
	  }
	}