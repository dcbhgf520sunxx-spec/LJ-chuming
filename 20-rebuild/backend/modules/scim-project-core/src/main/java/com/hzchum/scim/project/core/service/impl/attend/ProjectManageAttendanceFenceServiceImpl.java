package com.hzchum.scim.project.core.service.impl.attend;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceFence;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceFenceDTO;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceFenceService;
import com.hzchum.scim.project.core.mapper.attend.ProjectManageAttendanceFenceMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageAttendanceFenceServiceImpl
   extends ServiceImpl<ProjectManageAttendanceFenceMapper, ProjectManageAttendanceFence>
   implements ProjectManageAttendanceFenceService {
   @Override
   public List<ProjectManageAttendanceFenceDTO> getAttendanceFence(Long projectId) {
      List<ProjectManageAttendanceFence> projectManageAttendanceFences = this.list(
         Wrappers.lambdaQuery(ProjectManageAttendanceFence.class)
            .eq(ProjectManageAttendanceFence::getProjectId, projectId)
            .orderByAsc(ProjectManageAttendanceFence::getSort)
      );
      if (CollectionUtils.isEmpty(projectManageAttendanceFences)) {
         return null;
      }

      List<ProjectManageAttendanceFenceDTO> projectManageAttendanceFenceDTOS = new ArrayList<>();

      for (ProjectManageAttendanceFence projectManageAttendanceFence : projectManageAttendanceFences) {
         String[] split = projectManageAttendanceFence.getPoint().split(",");
         projectManageAttendanceFenceDTOS.add(
            ProjectManageAttendanceFenceDTO.builder()
               .projectId(projectManageAttendanceFence.getProjectId())
               .lat(split[1])
               .sort(projectManageAttendanceFence.getSort())
               .lng(split[0])
               .id(projectManageAttendanceFence.getId())
               .build()
         );
      }

      return projectManageAttendanceFenceDTOS;
   }
}
