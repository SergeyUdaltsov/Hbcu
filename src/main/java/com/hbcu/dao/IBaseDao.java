package com.hbcu.dao;

import java.util.List;

public interface IBaseDao<ENTITY> {

    void save(ENTITY item);

    List<ENTITY> getAllEntities();
}
