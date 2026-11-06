package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.mapper.ProjectUserLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectUserLinkServiceImpl extends ServiceImpl<ProjectUserLinkMapper, ProjectUserLink> implements ProjectUserLinkService {
   @Override
   public ListVO<UserResponseVO> listUser(Long projectId) {
      List<ProjectUserLinkDTO> responseVOS = this.baseMapper.listByProjectIdAndUserName(projectId, null);
      return (ListVO)new ListVO<ProjectUserLinkDTO>(responseVOS);
   }

   @Override
   public void checkProjectUser(Long projectId) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (!user.isAdmin()) {
         int count = this.baseMapper
            .selectCount(
               (Wrapper<ProjectUserLink>)(new LambdaQueryWrapper<ProjectUserLink>().eq(ProjectUserLink::getProjectId, projectId))
                  .eq(ProjectUserLink::getUserId, user.getId())
            );
         Preconditions.checkArgument(count > 0, "当前用户未关联该项目!");
      }
   }
}
