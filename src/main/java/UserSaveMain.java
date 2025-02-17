import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import jpastart.jpa.EMF;
import jpastart.reserve.model.Review;
import jpastart.reserve.model.User;
import jpastart.services.DeleteUserService;
import jpastart.services.NewUserService;
import jpastart.services.ReviewService;
import jpastart.services.UpdateUserService;

public class UserSaveMain {
    public static void main(String[] args) {
        EMF.init();
        // EntityManager em = EMF.createEntityManager();
        // EntityTransaction tx = EMF.getTransaction();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("명령어를 입력하세요. new, update, delete, review, exit");
                String command = br.readLine();
                if(command.startsWith("new")){
                    handlerNewUser(br);
                }else if(command.startsWith("update")){
                    handlerUpdateUser(br);
                }else if(command.startsWith("delete")){
                    handlerDeleteUser(br);
                }else if(command.startsWith("review")){
                    handlerReview(br);
                }else if(command.startsWith("exit")){
                    break;
                }
                // br.readLine();
            }
            // tx.begin();
            // User user = new User("test@test.com", "test", new Date());
            // em.persist(user);
            // tx.commit();

            //조회
            // User findUser = em.find(User.class, user.getEmail());
            // System.out.println(findUser);

            //수정
            // findUser.changeName("test2");
            
            // tx.commit();

            //삭제
            // em.remove(findUser);
            // tx.commit();
        } catch (Exception e) {
            // tx.rollback();
            e.printStackTrace();
        } finally {
            // em.close();
        }
        // EMF.close();
    }

    private static void handlerNewUser(BufferedReader br) throws Exception{
        System.out.println("이메일을 입력하세요.");
        String email = br.readLine();
        System.out.println("이름을 입력하세요.");
        String name = br.readLine();
        User user = new User(email, name, new Date());
        NewUserService newUserService = new NewUserService();
        newUserService.register(user);
    }

    private static void handlerUpdateUser(BufferedReader br) throws Exception{
        System.out.println("이메일을 입력하세요.");
        String email = br.readLine();
        System.out.println("이름을 입력하세요.");
        String name = br.readLine();
        User user = new User(email, name, new Date());
        UpdateUserService updateUserService = new UpdateUserService();
        updateUserService.update(user);
    }
    
    private static void handlerDeleteUser(BufferedReader br) throws Exception{
        System.out.println("이메일을 입력하세요.");
        String email = br.readLine();
        User user = new User(email, null, null);
        DeleteUserService deleteUserService = new DeleteUserService();
        deleteUserService.delete(user);
    }

    private static void handlerReview(BufferedReader br) throws Exception{
        System.out.println("호텔 아이디를 입력하세요.");
        String hotelId = br.readLine();
        System.out.println("평점을 입력하세요.");
        String mark = br.readLine();
        System.out.println("이름을 입력하세요.");
        String name = br.readLine();
        System.out.println("코멘트를 입력하세요.");
        String comment = br.readLine();
        
        
        Review review = new Review(Long.parseLong(hotelId), Integer.parseInt(mark), name, comment, new Date());
        ReviewService reviewService = new ReviewService();
        reviewService.register(review);
    }
}
