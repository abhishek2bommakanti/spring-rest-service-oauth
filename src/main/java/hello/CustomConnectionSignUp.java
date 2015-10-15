/**
 * 
 */
package hello;

import hello.data.User;
import hello.data.UserRepository;

import javax.inject.Inject;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

/**
 * @author abhishek
 *
 */
@Component
public class CustomConnectionSignUp implements ConnectionSignUp {
	@Inject
	private UserRepository userRepository;
	
	@Override
	public String execute(Connection<?> connection) {
		UserProfile userProfile = connection.fetchUserProfile();
		
		if (!org.springframework.util.StringUtils.isEmpty(userProfile.getEmail())) {
			User user = userRepository.findByLogin(userProfile.getEmail());
			if (user != null && user.getId() != 0) {
				return user.getId().toString();
			}
			else {
				User userToCreate = new User();
				userToCreate.setName(userProfile.getName());
				userToCreate.setLogin(userProfile.getEmail());
				
				User createdUser = userRepository.save(userToCreate);
				return createdUser.getId().toString();
			}
		}
		else {
			throw new RuntimeException("Could not retrieve e-mail address from social network");
		}
	}
}
