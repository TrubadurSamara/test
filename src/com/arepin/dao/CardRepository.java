package com.arepin.dao;


import com.arepin.entity.Card;

public interface CardRepository {

    Card[] findAll();
}
