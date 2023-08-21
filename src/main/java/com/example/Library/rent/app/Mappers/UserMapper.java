package com.example.Library.rent.app.Mappers;

import com.example.Library.rent.app.Core.User;
import com.example.Library.rent.app.DTO.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(),
                        userDto.getFirstname(),
                        userDto.getLastname());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                           user.getName(),
                           user.getLastName());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
