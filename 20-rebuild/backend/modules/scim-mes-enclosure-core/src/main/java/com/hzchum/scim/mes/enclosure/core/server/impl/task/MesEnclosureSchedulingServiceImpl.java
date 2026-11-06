package com.hzchum.scim.mes.enclosure.core.server.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureScheduling;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureSchedulingService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.MesEnclosureSchedulingMapper;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureSchedulingServiceImpl
   extends ServiceImpl<MesEnclosureSchedulingMapper, MesEnclosureScheduling>
   implements MesEnclosureSchedulingService {
   @Autowired
   private TechDrawingService techDrawingService;

   @Override
   public Boolean checkStatus(Long productionLine) {
      return this.baseMapper
         .selectList((Wrapper<MesEnclosureScheduling>)Wrappers.<MesEnclosureScheduling>lambdaQuery().eq(MesEnclosureScheduling::getProductionLineId, productionLine))
         .stream()
         .noneMatch(e -> e.getSchedulingQuantity().equals(e.getCompleteQuantity()));
   }
}
