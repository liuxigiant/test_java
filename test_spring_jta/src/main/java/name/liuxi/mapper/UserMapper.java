package name.liuxi.mapper;

import name.liuxi.domain.User;
import org.springframework.stereotype.Component;


@Component
public interface UserMapper
{
    public Integer insert(User user);

    public void update(User user);
}
