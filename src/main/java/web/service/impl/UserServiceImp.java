package web.service.impl;

import web.dao.UserDAO;
import web.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.service.UserService;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;


    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public User findUserToID(Long id) {
       return userDAO.findUserToID(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

}
