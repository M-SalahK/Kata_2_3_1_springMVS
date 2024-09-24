package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDAO.findUser(id);
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
