package com.hzchum.scim.project.core.biz.impl.attend;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.project.core.api.biz.attend.ProjectManageAttendanceFenceBiz;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceFence;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceFenceDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.PointDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageAttendanceFenceDTOParam;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceFenceService;
import com.hzchum.scim.project.core.mapper.attend.ProjectManageAttendanceFenceMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectManageAttendanceFenceBizImpl
   extends IBizImpl<ProjectManageAttendanceFenceService, ProjectManageAttendanceFenceMapper, ProjectManageAttendanceFence>
   implements ProjectManageAttendanceFenceBiz {
   @Transactional
   @Override
   public Boolean setAttendanceFence(ProjectManageAttendanceFenceDTOParam copy) {
      Preconditions.checkArgument(copy.getProjectId() != null, "请选择项目");
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(copy.getPoints()) && copy.getPoints().size() > 2, "请检查点位需三个点位以上");
      this.baseService.remove(Wrappers.lambdaQuery(ProjectManageAttendanceFence.class).eq(ProjectManageAttendanceFence::getProjectId, copy.getProjectId()));
      List<PointDTOParam> points = copy.getPoints();
      points.forEach(
         item -> this.baseService
            .save(ProjectManageAttendanceFence.builder().projectId(copy.getProjectId()).point(item.getPoint()).sort(item.getSort()).build())
      );
      return true;
   }

   @Override
   public List<ProjectManageAttendanceFenceDTO> getAttendanceFence(Long projectId) {
      return this.baseService.getAttendanceFence(projectId);
   }
}
