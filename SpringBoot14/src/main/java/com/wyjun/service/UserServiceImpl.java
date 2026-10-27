package com.wyjun.service;

import com.wyjun.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    // 使用ConcurrentHashMap模拟数据存储
    private ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<>();

    // 使用AtomicLong生成ID
    // 自动维护一个线程安全的自增id。
    private AtomicLong idGenerator = new AtomicLong(1);

    // 初始化一些测试数据
    public UserServiceImpl() {
        LocalDateTime now = LocalDateTime.now();

        for (int i = 1; i <= 5; i++) {
            Long id = (long) i;
            User user = new User();
            user.setId(id);
            user.setUsername("用户" + i);
            user.setPassword("123456");
            user.setEmail("user" + i + "@example.com");
            user.setAge(20 + i);
            user.setPhone("1380013800" + i);
            user.setCreateTime(now.minusDays(i));
            user.setUpdateTime(now.minusDays(i));

            userMap.put(id, user);
            idGenerator.set(i + 1);
        }
    }

    @Override
    public User addUser(User user) {
        // 生成ID
        Long id = idGenerator.getAndIncrement();
        user.setId(id);

        // 设置创建时间和更新时间
        LocalDateTime now = LocalDateTime.now();
        user.setCreateTime(now);
        user.setUpdateTime(now);

        // 保存用户
        userMap.put(id, user);

        return user;
    }

    @Override
    public User updateUser(User user) {
        Long id = user.getId();
        if (id == null || !userMap.containsKey(id)) {
            throw new RuntimeException("用户不存在");
        }

        // 获取原用户数据
        User existingUser = userMap.get(id);

        // 更新字段（在实际项目中，这里需要逐个字段判断是否更新）
        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getAge() != null) {
            existingUser.setAge(user.getAge());
        }
        if (user.getPhone() != null) {
            existingUser.setPhone(user.getPhone());
        }

        // 更新时间
        existingUser.setUpdateTime(LocalDateTime.now());

        // 保存更新
        userMap.put(id, existingUser);

        return existingUser;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!userMap.containsKey(id)) {
            return false;
        }

        userMap.remove(id);
        return true;
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        List<User> result = new ArrayList<>();
        for (User user : userMap.values()) {
            if (user.getUsername().contains(username)) {
                result.add(user);
            }
        }
        return result;
    }
}