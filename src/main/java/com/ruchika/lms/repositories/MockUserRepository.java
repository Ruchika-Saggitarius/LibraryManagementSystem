package com.ruchika.lms.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.ruchika.lms.model.User;

@Repository
public class MockUserRepository implements IUserRepository{

    List<User> users = new ArrayList<User>();

    @Override
    public void saveUser(User newUser) {
        users.add(newUser);
    }

    @Override
    public User loginUser(String email, String password) {
        for(User user: users) {
            if(user.getEmail().equals(email)) {
                if(BCrypt.checkpw(password, user.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        for(User user: users) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByUserId(String userId) {
        for(User user: users) {
            if(user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
        
    }

    @Override
    public void updateEmailOfUser(String userId, String newEmail) {
        for(User user: users) {
            if(user.getUserId().equals(userId)) {
                user.setEmail(newEmail);
            }
        }
    }

    @Override
    public void ResetPasswordOfUser(String userId, String newHashedPassword) {
        for(User user: users) {
            if(user.getUserId().equals(userId)) {
                    user.setPassword(newHashedPassword);
                }
            }
    }
        
    

    @Override
    public void ForgotPasswordSendLinkViaEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ForgotPasswordSendLinkViaEmail'");
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        for(User user: users) {
            if(user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfDisplayNameExists(String displayName) {
        for(User user: users) {
            if(user.getDisplayName().equals(displayName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public boolean checkIfPasswordMatches(String userId, String password) {
        for(User user: users) {
            if(user.getUserId().equals(userId)) {
                if(BCrypt.checkpw(password, user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkIfUserIdExists(String userId) {
        for(User user: users) {
            if(user.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

  

    
}
