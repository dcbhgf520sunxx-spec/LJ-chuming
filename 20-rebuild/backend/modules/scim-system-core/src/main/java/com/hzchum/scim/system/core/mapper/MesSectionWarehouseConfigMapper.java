package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface MesSectionWarehouseConfigMapper extends BaseMapper<MesSectionWarehouseConfig> {
   @Delete("DELETE FROM ${tableName}")
   int deleteAllFromTable(@Param("tableName") String tableName);
}
