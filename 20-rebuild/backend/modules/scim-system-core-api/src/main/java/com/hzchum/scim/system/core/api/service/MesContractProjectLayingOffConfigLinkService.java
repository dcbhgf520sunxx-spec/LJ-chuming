package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectLayingOffConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectLayingOffConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectLayingOffConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectLayingOffConfigLinkService extends IService<MesContractProjectLayingOffConfigLink> {
   List<MesContractProjectLayingOffConfigLinkDTO> listInfo(Long projectId, Integer statisticsConfigStatisticsMode);

   List<MesContractProjectLayingOffConfigLinkDTO> listInfoByProjectIds(List<Long> projectIds);

   Boolean updateContractProjectLayingOffConfigLink(MesContractProjectLayingOffConfigLinkSaveDTOParam param);

   Boolean saveContractProjectLayingOffConfigLink(Long contractProjectId, Integer contractProjectStatisticsMode);

   Boolean saveConfig(MesContractProjectLayingOffConfigLinkSaveDTOParam param);

   Boolean batchSaveConfig(List<MesContractProjectLayingOffConfigLinkSaveDTOParam> paramList);

   Boolean batchDelete(List<Long> idList);

   PageVO<MesContractProjectLayingOffConfigLinkDTO> pageInfo(
      Long projectId, Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize, List<String> sort
   );

   MesContractProjectLayingOffConfigLinkDTO detailById(Long id);

   MesContractProjectLayingOffConfigLinkDTO getOneByCondition(Long projectId, Integer machinePartType, Long steelClassificationId, Boolean boolFixedPrice);
}
