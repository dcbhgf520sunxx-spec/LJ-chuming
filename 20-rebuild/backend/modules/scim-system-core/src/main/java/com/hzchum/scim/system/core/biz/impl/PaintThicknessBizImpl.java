package com.hzchum.scim.system.core.biz.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.system.core.api.biz.PaintThicknessBiz;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaintThicknessBizImpl implements PaintThicknessBiz {
   private static final Logger log = LoggerFactory.getLogger(PaintThicknessBizImpl.class);
   @Resource
   private ConfigService configService;
   @Resource
   private MesBuildingProcessService processService;

   @Override
   public Boolean savePaintThickness(PaintThicknessDO paintThicknessDO) {
      List<Long> processIds = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.PAINT.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      Preconditions.checkArgument(processIds.containsAll(paintThicknessDO.getProcesses()), "漆膜厚度相关工序必须是油漆类工序！");
      this.configService.updateConfig("PAINT_THICKNESS_DETECTION", JSON.toJSONString(paintThicknessDO));
      return Boolean.TRUE;
   }

   @Override
   public PaintThicknessDO getPaintThicknessConfig() {
      return this.configService.getPaintThicknessConfig();
   }

   @Override
   public ListVO listPaintArtyFactList() {
      return new ListVO(
         this.processService
            .list(
               (Wrapper<MesBuildingProcess>)((Wrappers.<MesBuildingProcess>lambdaQuery()
                        .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                     .eq(MesBuildingProcess::getType, ProcessTypeEnum.PAINT.getType()))
                  .orderByAsc(MesBuildingProcess::getSort)
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingProcessDTO.class))
            .collect(Collectors.toList())
      );
   }
}
