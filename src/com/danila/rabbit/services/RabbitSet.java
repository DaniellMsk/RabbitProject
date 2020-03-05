package com.danila.rabbit.services;

import com.danila.rabbit.dao.RabbitDao;
import com.danila.rabbit.dto.RabbitInput;

public class RabbitSet {
    private static final RabbitSet rabbitSet = new RabbitSet();

    public void setRabbit(RabbitInput rabbit) {
        RabbitDao.getInstance().saveRabbit(rabbit);
    }

    public static RabbitSet getInstance(){
        return rabbitSet;
    }
}
