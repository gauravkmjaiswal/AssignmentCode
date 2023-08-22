import java.util.Scanner;
import java.util.Objects;

import entity.Book;
import entity.User;
import service.BookService;
import service.UserService;

public class BookShopApplication {

	public static void main(String[] args) {
		
		int choosenNumber = 0;
		boolean flag=true;
		UserService userService = new UserService();
		BookService bookService = new BookService();
		User user = new User(); 
		Scanner sc = new Scanner(System.in);
		
		while(flag)
		{
			user = null;
			System.out.println("Press 1 to Register\nPress 2 to Login  \nPress 0 to exit");
			
			choosenNumber = sc.nextInt();
			
			switch(choosenNumber)
			{
				case 1 : user = userService.registerUser();
						 System.out.println(user);
				
				case 2 : if( Objects.isNull(user))
						 {
							 user = userService.getUser(); 
							 System.out.println(user);
						 }
						 System.out.println("logged in ");
						 
						 boolean bookFlag = true;
						 while(bookFlag)
						 {
							 Book book = null;
							 System.out.println("Press 1 to see available books \nPress 2 to get Book");
							 if(user.getUserType().equals("admin"))
							 {
								 System.out.println("Press 3 to add book");
								 System.out.println("Press 4 to see all users");
							 }
							 System.out.println("Press 0 to logout");
							 
							 int option=0;
							 option = sc.nextInt();
							 switch(option)
							 {
							 	case 1 : bookService.getBooks();
							 		break;
							 	case 2 : bookService.getBook();
							 		break;
							 	case 3 : if(!(user.getUserType().equals("admin")))
							 			{
							 				System.out.println("access denied");
							 				break;
							 			}	
							 			book = bookService.addBook();
							 			System.out.println(book);
							 		break;
							 	case 4 : if(!(user.getUserType().equals("admin")))
							 			{
							 				System.out.println("access denied");
							 				break;
							 			}
							 			userService.getUsers();
							 		break;
							 	case 0 : System.out.println("logout");
							 			 bookFlag = false;
							 			 user = null;
							 			 break;
							 	default :System.out.println("try again");
							 			 break;
							 			 
							 			
							 }
						 }
						 
						
					break;
				case 0 : System.out.println("exit");
						 user = null;
						 flag= false;
					break;
				default : System.out.println("try again");
					break;
			}
		}
		
		
		

	}

}
