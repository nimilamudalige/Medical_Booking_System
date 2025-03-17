package lk.ijse.medicalbookingsystem.service;

import lk.ijse.medicalbookingsystem.dto.UserDTO;

public interface UserService {

    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}
