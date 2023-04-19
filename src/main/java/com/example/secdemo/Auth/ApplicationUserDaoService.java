package com.example.secdemo.Auth;

import com.example.secdemo.DBAuth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("db")
public class ApplicationUserDaoService implements ApplicationUserDao {

    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RolePermissionMappingRepository repo;
    @Autowired
    private final PermissionRepository permissionRepository;
    @Autowired
    private final RoleRepository roleRepository;

    public ApplicationUserDaoService(PasswordEncoder passwordEncoder,
                                     UserRepository userRepository,
                                     RolePermissionMappingRepository repo,
                                     PermissionRepository permissionRepository,
                                     RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.repo = repo;
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("Not found!");
        Role role = roleRepository.findById(userRepository.findRoleByUsername(username)).get();
        List<Permission> permissions = permissionRepository.findAllById(repo.findPermissionByRole(role.getRoleId()));
        return Optional.of(new ApplicationUser(user.get(), role, permissions));
    }
}
