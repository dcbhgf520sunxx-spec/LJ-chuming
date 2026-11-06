package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectImageProgress;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectImageProgressDTO;
import com.hzchum.scim.project.core.api.service.ProjectImageProgressService;
import com.hzchum.scim.project.core.mapper.ProjectImageProgressMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectImageProgressServiceImpl extends ServiceImpl<ProjectImageProgressMapper, ProjectImageProgress> implements ProjectImageProgressService {
   @Override
   public List<ProjectImageProgress> listImageProgress(Long projectId, String yearMonth, String date) {
      return this.baseMapper.selectImages(projectId, yearMonth, date);
   }

   @Override
   public List<ProjectImageProgressDTO> listByCondition(Long projectId, String yearMonth) {
      return this.baseMapper.selectByCondition(projectId, yearMonth);
   }
}
