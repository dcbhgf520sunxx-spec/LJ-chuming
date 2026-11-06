package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectStatisticsConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectStatisticsConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectStatisticsConfigLinkService extends IService<MesContractProjectStatisticsConfigLink> {
   List<MesContractProjectStatisticsConfigLinkDTO> listInfo(Integer statisticsMode, String projectNumberOrName);

   Boolean saveContractProjectStatisticsConfig(Long contractProjectId);

   Boolean updateContractProjectStatisticsConfig(MesContractProjectStatisticsConfigLinkSaveDTOParam param);

   PageVO<MesContractProjectStatisticsConfigLinkDTO> pageInfo(Integer statisticsMode, String projectNumberOrName, Integer pageNumber, Integer pageSize);
}
