package com.mapper;

import com.domain.User;
import org.springframework.stereotype.Component;


@Component
public interface UserMapper
{
    public void insert(User user);

    public void update(User user);
}
