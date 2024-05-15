package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepos;

    public List<User> getAllUsers(){
        Iterable<User> allIterables= userRepos.findAll();
        return mapToList(allIterables);

       // Iterable<User> userIter=userRepos.findAll();
//       return StreamSupport.stream(userIter.spliterator(),false)
//               .map((user -> (User) user))
//               .collect(Collectors.toList());
    };

    private List<User> mapToList(Iterable<User> users){
        List<User> usersList= new ArrayList<>();
        for(User usr: users){
            usersList.add(usr);
        }
        return usersList;

    }
}
