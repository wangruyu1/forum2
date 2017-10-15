package com.leisure.forum;

import com.leisure.forum.entity.User;
import com.leisure.forum.user.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
public class ForumApplicationTests {
	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setQq("12323@qq.com");
		user.setForumName("wangruyu1");
		user.setRealName("wangruyu");
		user.setPassword("wangruyu123");
        user.setRole("ROLE_USER");
        userController.addUser(user);
	}

}
