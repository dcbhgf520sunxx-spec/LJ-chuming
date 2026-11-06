package com.hzchum.scim.mes.building.core.mapper.initialization;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InitializationMapper {
   List<String> selectSql(String sql);

   void updateSql(String sqlList);

   List<JSONObject> selectList(@Param("sql") String sql);
}
