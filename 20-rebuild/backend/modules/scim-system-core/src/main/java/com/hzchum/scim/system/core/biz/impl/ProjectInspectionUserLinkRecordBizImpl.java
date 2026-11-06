package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.system.core.api.biz.ProjectInspectionUserLinkRecordBiz;
import com.hzchum.scim.system.core.api.enums.AuditStateEnum;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLinkRecord;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionUserLinkRecordDTOParam;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserLinkRecordService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserService;
import com.hzchum.scim.system.core.mapper.ProjectInspectionUserLinkRecordMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProjectInspectionUserLinkRecordBizImpl
   extends IBizImpl<ProjectInspectionUserLinkRecordService, ProjectInspectionUserLinkRecordMapper, ProjectInspectionUserLinkRecord>
   implements ProjectInspectionUserLinkRecordBiz {
   @Resource
   private ProjectInspectionUserService projectInspectionUserService;

   @Override
   public ProjectInspectionUserLinkRecord getMostNewRecordByMasterTableId(Long masterId) {
      List<ProjectInspectionUserLinkRecord> allRecord = this.baseMapper
         .selectList((Wrapper<ProjectInspectionUserLinkRecord>)Wrappers.<ProjectInspectionUserLinkRecord>lambdaQuery().orderByDesc(BaseEntity::getCreateTime));
      List<ProjectInspectionUserLinkRecord> succeedRosterTemp = allRecord.stream()
         .filter(record -> AuditStateEnum.SUCCEED.getType().equals(record.getAuditState()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(succeedRosterTemp)) {
         return succeedRosterTemp.get(0);
      }

      List<ProjectInspectionUserLinkRecord> failedRecord = allRecord.stream()
         .filter(record -> AuditStateEnum.FAILED.getType().equals(record.getAuditState()))
         .collect(Collectors.toList());
      return CollectionUtils.isNotEmpty(failedRecord) && failedRecord.size() == allRecord.size() ? failedRecord.get(0) : new ProjectInspectionUserLinkRecord();
   }

   @Override
   public ProjectInspectionUserLinkRecord createRecord(ProjectInspectionUserLinkRecordDTOParam recordDTOParam) {
      ProjectInspectionUser inspectionUser = this.projectInspectionUserService.getById(recordDTOParam.getInspectionUserId());
      Preconditions.checkArgument(inspectionUser != null, "巡检线路不存在!");
      ProjectInspectionUserLinkRecord isHasRecord = this.baseMapper
         .selectOne(
            (Wrapper<ProjectInspectionUserLinkRecord>)(Wrappers.<ProjectInspectionUserLinkRecord>lambdaQuery()
                  .eq(ProjectInspectionUserLinkRecord::getInspectionUserId, recordDTOParam.getInspectionUserId()))
               .eq(ProjectInspectionUserLinkRecord::getAuditState, AuditStateEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(isHasRecord == null, "删除申请正在审核中!");
      ProjectInspectionUserLinkRecord createRecord = BeanUtil.copy(recordDTOParam, ProjectInspectionUserLinkRecord.class);
      ProjectInspectionUserLinkRecord mostNewRecord = this.getMostNewRecordByMasterTableId(inspectionUser.getId());
      createRecord.setRecordSource(mostNewRecord.getId());
      createRecord.setAuditState(AuditStateEnum.AUDITING.getType());
      this.save(createRecord);
      return createRecord;
   }
}
