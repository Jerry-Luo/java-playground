package com.jerry.commons.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jerry.spring.boot.amqp.allscene.transferentity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMapperTest {

    @Test
    public void testObjToJsonString() {
        User user = new User();
        user.setName("test");
        user.setPass("testpass");
        System.out.println(JsonMapper.obj2Str(user));

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);
        System.out.println(JsonMapper.obj2Str(list));

        Map<String, User> map = new HashMap<>();
        map.put("one", user);
        map.put("two", user);
        System.out.println(JsonMapper.obj2Str(map));
    }

    @Test
    public void testStringToObj() {
        String jsonString = "{\"name\":\"test\",\"pass\":\"testpass\"}";
        User user = JsonMapper.str2Obj(jsonString, new TypeReference<>() {
        });
        System.out.println(user.getName() + "  " + user.getPass());

        System.out.println("---------------");

        String listJsonString = "[{\"name\":\"test\",\"pass\":\"testpass\"},{\"name\":\"test\",\"pass\":\"testpass\"},{\"name\":\"test\",\"pass\":\"testpass\"}]";
        List<User> list = JsonMapper.str2Obj(listJsonString, new TypeReference<>() {
        });
        for (User u : list) {
            System.out.println(u.getName() + " " + u.getPass());
        }

        System.out.println("---------------");
        String mapJsonString = "{\"one\":{\"name\":\"test\",\"pass\":\"testpass\"},\"two\":{\"name\":\"test\",\"pass\":\"testpass\"}}";
        Map<String, User> map = JsonMapper.str2Obj(mapJsonString, new TypeReference<>() {
        });
        for (String key : map.keySet()) {
            User u = map.get(key);
            System.out.println(u.getName() + " " + u.getPass());
        }

    }
}