package com.example.demo;

import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) o;
        customRevisionEntity.setUserName(getCurrentUser());
    }

    private String getCurrentUser() {
        return "User2";
    }
}
