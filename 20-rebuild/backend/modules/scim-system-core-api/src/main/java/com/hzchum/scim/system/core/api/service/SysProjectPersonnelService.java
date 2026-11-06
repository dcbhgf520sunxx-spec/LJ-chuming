package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.SysProjectPersonnel;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectPersonnelSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectPersonnelUpdateDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysProjectPersonnelDTO;

public interface SysProjectPersonnelService extends IService<SysProjectPersonnel> {
   PageVO<SysProjectPersonnelDTO> listAllTemplate(String templateName, Integer status, Integer pageNumber, Integer pageSize);

   ListVO<ProjectUserLinkDTO> detailsTemplate(Long id);

   Boolean updateStatus(Long id, Integer status);

   Boolean saveTemplate(ProjectPersonnelSaveDTOParam requestVO);

   Boolean removeTemplate(Long id);

   Boolean updateTemplate(ProjectPersonnelUpdateDTOParam updateDTOParam);

   Boolean setDefault(Long id, Boolean isDefault);
}
