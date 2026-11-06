package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.cut.core.api.service.NestCutPlateService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskDTOParam;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingSchedulingBizImpl implements MesBuildingSchedulingBiz {
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private MesBuildingProductProcessService mesBuildingProductProcessService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Resource
   private MesBuildingTaskBiz taskBiz;
   @Resource
   NestCutPlateService nestCutPlateService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveScheduling(
      List<MesBuildingSchedulingDTOParam> schedulingDTOParamList, LocalDateTime askCompleteTime, Boolean booleanSaveTask
   ) {
      List<MesBuildingTaskDTOParam> taskDTOParams = new ArrayList<>();
      schedulingDTOParamList.forEach(
         e -> {
            e.setUserId(UserUtil.getCurrentUserId());
            e.setIssueStatus(null);
            e.setCompleteQuantity(null);
            e.setTaskQuantity(null);
            Long productProcessId = this.mesBuildingUtilsBiz.selectProductProcessIdByProductIdAndType(e.getProductId(), e.getProductType());
            Preconditions.checkArgument(productProcessId != null, "操作失败 没有对应的工序");
            e.setProductProcessId(productProcessId);
            Preconditions.checkArgument(
               this.mesBuildingUtilsBiz
                  .checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(e.getFactoryId(), e.getWorkshopId(), e.getProductionLineId(), null, null, null),
               "工厂，车间，生产线不正确"
            );
            Preconditions.checkArgument(
               this.mesBuildingUtilsBiz.checkSchedulingQuantity(e.getProductId(), e.getProductType(), e.getSchedulingQuantity()), "排产失败,排产数量不正确"
            );
            MesBuildingScheduling scheduling = BeanUtil.copy(e, MesBuildingScheduling.class);
            this.schedulingService.save(scheduling);
            if (booleanSaveTask) {
               taskDTOParams.add(
                  MesBuildingTaskDTOParam.builder()
                     .schedulingId(scheduling.getId())
                     .taskQuantity(scheduling.getSchedulingQuantity())
                     .askCompleteTime(askCompleteTime)
                     .build()
               );
            }
         }
      );
      return true;
   }

   @Override
   public List<MesBuildingScheduling> selectSummaryData(Long lineId, Long projectId) {
      return this.schedulingService
         .list(
            Wrappers.lambdaQuery(MesBuildingScheduling.class)
               .eq(MesBuildingScheduling::getProductionLineId, lineId)
               .eq(MesBuildingScheduling::getProjectId, projectId)
         );
   }
}
