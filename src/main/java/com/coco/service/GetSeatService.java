package com.coco.service;

import com.coco.domain.AutoGetseatUsers;

/**
 * @author coco
 * @data 2023/5/17
 */
public interface GetSeatService {

    /**
     * 刷新参数信息
     * TODO
     */
    void refreshParameters();

    boolean saveParameter(AutoGetseatUsers user);

    void startGetSeats();

    void getOneSeat(AutoGetseatUsers user);

}
