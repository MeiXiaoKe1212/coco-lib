package com.coco.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


/**
 * VerifyCode
 *
 * @author coco
 * @date 2023-05-17
 */
@Data
public class Shuku extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 书库缩写
     */
    private String name;

    /**
     * 页面位置(xpath形式)
     */
    private String htmlPath;


}
