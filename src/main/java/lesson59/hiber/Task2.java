package lesson59.hiber;


public class Task2 {
    public static void main(String[] args) {
        UserService userService = new UserService();
//        userService.addDepartment(new Department("dep1", 1_000_000d));
        //userService.addUser(new User("user1", 20));
        User userById = userService.getUserById(2L);
//        userById.setDepartment(userService.getDepById(1L));
//        userService.updateUser(userById);

//        Passport passport = new Passport("1234", "123456");
//        userService.addPassport(passport);
//        userById.setPassport(passport);
//        userService.updateUser(userById);


//        SocialNetwork vk = new SocialNetwork("VK", "vk.com");
//        userService.addSocial(vk);

        userService.addSocialForUser(2l, 1l);



    }
}
