package com.menu.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `vagetable` (
 *   `vage_id` varchar(36) NOT NULL,
 *   `vage_name` varchar(36) NOT NULL,
 *   `vage_type` varchar(36) NOT NULL COMMENT '菜品类型（蔬菜？肉？甜点？）',
 *   `vage_num` int(11) NOT NULL DEFAULT '0',
 *   `vage_price` double(10,0) NOT NULL DEFAULT '0',
 *   `vage_delete` int(11) NOT NULL COMMENT '1正常2删除',
 *   PRIMARY KEY (`vage_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Vagetable implements Serializable {

    private String vageId;
    private String vageName;
    private Integer vageNum;
    private Double vagePrice;
    private Integer vageDelete;
    private Type type;

    public String getVageId() {
        return vageId;
    }

    public void setVageId(String vageId) {
        this.vageId = vageId;
    }

    public String getVageName() {
        return vageName;
    }

    public void setVageName(String vageName) {
        this.vageName = vageName;
    }

    public Integer getVageNum() {
        return vageNum;
    }

    public void setVageNum(Integer vageNum) {
        this.vageNum = vageNum;
    }

    public Double getVagePrice() {
        return vagePrice;
    }

    public void setVagePrice(Double vagePrice) {
        this.vagePrice = vagePrice;
    }

    public Integer getVageDelete() {
        return vageDelete;
    }

    public void setVageDelete(Integer vageDelete) {
        this.vageDelete = vageDelete;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
