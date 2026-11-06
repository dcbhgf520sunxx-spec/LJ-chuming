package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import java.util.List;

public interface EnclosurePlanService extends IService<EnclosurePlan> {
   List listPlansByProjectId(Long projectId, Integer category);

   NameInfo getSimpleById(Long id);

   List<String> selectSql(String areaName);

   void updateSql(String s);
}
