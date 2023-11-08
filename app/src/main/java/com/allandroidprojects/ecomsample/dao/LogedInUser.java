package com.allandroidprojects.ecomsample.dao;

import com.allandroidprojects.ecomsample.model.User;

public class LogedInUser {
    public static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LogedInUser.user = user;
    }
}
