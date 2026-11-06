package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectGroupWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectGroupWeldingConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectGroupWeldingConfigLinkService extends IService<MesContractProjectGroupWeldingConfigLink> {
   List<MesContractProjectGroupWeldingConfigLinkDTO> listInfo(Long projectId);

   List<MesContractProjectGroupWeldingConfigLinkDTO> listInfoByProjectIds(List<Long> projectIds);

   Boolean saveContractProjectGroupWeldingConfigLink(Long contractProjectId);

   PageVO<MesContractProjectGroupWeldingConfigLinkDTO> pageInfo(Long projectId, Integer pageNumber, Integer pageSize, List<String> sort);

   MesContractProjectGroupWeldingConfigLinkDTO detailById(Long id);

   Boolean saveConfig(MesContractProjectGroupWeldingConfigLinkSaveDTOParam param);

   Boolean batchSaveConfig(List<MesContractProjectGroupWeldingConfigLinkSaveDTOParam> paramList);

   Boolean updateConfig(MesContractProjectGroupWeldingConfigLinkSaveDTOParam param);

   Boolean batchDelete(List<Long> idList);

   MesContractProjectGroupWeldingConfigLinkDTO getOneByCondition(Long projectId, Long assembleConfigId, Long processId);
}
