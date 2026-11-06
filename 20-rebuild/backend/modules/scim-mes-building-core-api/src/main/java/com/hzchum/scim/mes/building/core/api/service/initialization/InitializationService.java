package com.hzchum.scim.mes.building.core.api.service.initialization;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

public interface InitializationService {
   List<String> selectSql(String sql);

   List<JSONObject> selectList(String sql);

   void updateSql(String sql);
}
