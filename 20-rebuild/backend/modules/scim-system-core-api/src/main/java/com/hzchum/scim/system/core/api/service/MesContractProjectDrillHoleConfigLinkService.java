package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectDrillHoleConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectDrillHoleConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectDrillHoleConfigLinkService extends IService<MesContractProjectDrillHoleConfigLink> {
   List<MesContractProjectDrillHoleConfigLinkDTO> listInfo(Long projectId, Integer statisticsConfigStatisticsMode);

   Boolean saveConfig(MesContractProjectDrillHoleConfigLinkSaveDTOParam param);

   Boolean batchSaveConfig(List<MesContractProjectDrillHoleConfigLinkSaveDTOParam> paramList);

   Boolean updateConfig(MesContractProjectDrillHoleConfigLinkSaveDTOParam param);

   Boolean batchDelete(List<Long> idList);

   PageVO<MesContractProjectDrillHoleConfigLinkDTO> pageInfo(
      Long projectId, Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize, List<String> sort
   );

   MesContractProjectDrillHoleConfigLinkDTO detailById(Long id);

   Boolean saveContractProjectDrillHoleConfigLink(Long contractProjectId, Integer contractProjectStatisticsMode);
}
