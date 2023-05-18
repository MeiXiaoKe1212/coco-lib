package com.coco.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


/**
 * AutoGetseatUsers
 *
 * @author coco
 * @date 2023-05-17
 */
@Data
public class AutoGetseatUsers extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 手机账号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 选择书库
     */
    private String shuku;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 选择座位号
     */
    private String seatNum;

    /**
     * 识别码
     */
    private String code;

}
