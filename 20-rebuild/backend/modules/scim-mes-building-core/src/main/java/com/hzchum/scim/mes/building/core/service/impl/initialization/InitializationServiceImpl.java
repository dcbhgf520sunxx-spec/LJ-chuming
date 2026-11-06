package com.hzchum.scim.mes.building.core.service.impl.initialization;

import com.alibaba.fastjson.JSONObject;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.mapper.initialization.InitializationMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationServiceImpl implements InitializationService {
   @Autowired
   private InitializationMapper mapper;

   @Override
   public List<String> selectSql(String sql) {
      return this.mapper.selectSql(sql);
   }

   @Override
   public List<JSONObject> selectList(String sql) {
      return this.mapper.selectList(sql);
   }

   @Override
   public void updateSql(String sql) {
      this.mapper.updateSql(sql);
   }
}
