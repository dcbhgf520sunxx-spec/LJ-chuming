package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectAssemblingWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectAssemblingWeldingConfigLinkService extends IService<MesContractProjectAssemblingWeldingConfigLink> {
   List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfo(Long projectId);

   List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfoByProjectIds(List<Long> projectIds);

   Boolean saveContractProjectAssemblingWeldingConfigLink(Long contractProjectId);

   PageVO<MesContractProjectAssemblingWeldingConfigLinkDTO> pageInfo(Long projectId, Integer pageNumber, Integer pageSize, List<String> sort);

   MesContractProjectAssemblingWeldingConfigLinkDTO detailById(Long id);

   Boolean saveConfig(MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param);

   Boolean batchSaveConfig(List<MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam> params);

   Boolean updateConfig(MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param);

   Boolean deleteById(Long id);

   MesContractProjectAssemblingWeldingConfigLinkDTO getOneByCondition(Long projectId, Long artifactTypeId, String artifactName, Long processId);
}
