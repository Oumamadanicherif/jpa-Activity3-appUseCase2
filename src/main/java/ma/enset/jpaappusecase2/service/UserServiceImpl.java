package ma.enset.jpaappusecase2.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.jpaappusecase2.entities.Role;
import ma.enset.jpaappusecase2.entities.User;
import ma.enset.jpaappusecase2.repositories.RoleRepository;
import ma.enset.jpaappusecase2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName) ;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    User user = findUserByUserName(username);
    Role role = findRoleByRoleName(roleName);
    if (user.getRoles()!=null) {
        user.getRoles().add(role);
        role.getUsers().add(user);
    }
    //userRepository.save(user);
    }
}
