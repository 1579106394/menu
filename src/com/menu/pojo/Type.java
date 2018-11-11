package com.menu.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `type` (
 *   `type_id` varchar(36) NOT NULL,
 *   `type_name` varchar(36) NOT NULL,
 *     `type_num` int(11) NOT NULL DEFAULT '0',
 *   PRIMARY KEY (`type_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Type implements Serializable {

    private String typeId;
    private String typeName;
    private Integer typeNum;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

	public Integer getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(Integer typeNum) {
		this.typeNum = typeNum;
	}
    
    
}
