package com.example.uas_1972046_JhonathanOktavianus.DAO;

import java.util.List;

/**
 * 1972046 - Jhonathan Oktavianus
 */
public interface DAOInterface<T> {
    public int addData(T data);
    public int updateData(T data);

    List<T> showData();
}
