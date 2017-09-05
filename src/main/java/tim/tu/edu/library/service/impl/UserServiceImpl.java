package tim.tu.edu.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim.tu.edu.library.domain.User;
import tim.tu.edu.library.repository.UserRepository;
import tim.tu.edu.library.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
