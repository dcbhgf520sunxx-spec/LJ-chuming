package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.get.PlanDTO;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.mapper.EnclosurePlanMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EnclosurePlanServiceImpl extends ServiceImpl<EnclosurePlanMapper, EnclosurePlan> implements EnclosurePlanService {
   private static final Logger log = LoggerFactory.getLogger(EnclosurePlanServiceImpl.class);
   @Resource
   private MesEnclosureTaskBiz taskBiz;

   @Override
   public List<PlanDTO> listPlansByProjectId(Long projectId, Integer category) {
      List<PlanDTO> dtos = new ArrayList<>();
      List<EnclosurePlan> plans = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(EnclosurePlan.class).eq(EnclosurePlan::getProjectId, projectId).eq(category != null, EnclosurePlan::getCategory, category)
         );
      if (CollectionUtils.isEmpty(plans)) {
         return new ArrayList<>();
      }

      for (EnclosurePlan plan : plans) {
         PlanDTO copy = BeanUtil.copy(plan, PlanDTO.class);
         copy.setPlanId(plan.getId());
         copy.setPlanName(plan.getName());
         dtos.add(copy);
      }

      return dtos;
   }

   @Override
   public NameInfo getSimpleById(Long id) {
      EnclosurePlan enclosurePlan = this.baseMapper.selectById(id);
      return BeanUtil.copy(enclosurePlan, NameInfo.class);
   }

   @Override
   public List<String> selectSql(String areaName) {
      return this.baseMapper.selectSql(areaName);
   }

   @Override
   public void updateSql(String s) {
      this.baseMapper.updateSql(s);
   }
}
