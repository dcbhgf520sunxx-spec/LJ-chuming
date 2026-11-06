package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentCategoryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentDTO;
import java.util.List;
import java.util.Map;

public interface ContractProjectContentService extends IService<ContractProjectContent> {
   List<String> listContentName(Long projectId);

   String getProjectContentStr(Long projectId, String separator);

   List<ProjectContentDTO> listProjectContentByPId(Long projectId);

   List<ProjectContentDTO> listByContentStr(String projectContent);

   Map<Integer, List<ProjectContentCategoryDTO>> listProjectContentCategory(Integer businessType, int flag);
}
