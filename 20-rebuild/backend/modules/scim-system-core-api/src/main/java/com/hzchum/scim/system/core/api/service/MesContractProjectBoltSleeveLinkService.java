package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectBoltSleeveLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectBoltSleeveLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectBoltSleeveLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectBoltSleeveLinkService extends IService<MesContractProjectBoltSleeveLink> {
   List<MesContractProjectBoltSleeveLinkDTO> listInfo(Long projectId);

   List<MesContractProjectBoltSleeveLinkDTO> listInfoByCondition(Long processId, List<Long> contractProjectIds);

   Boolean saveContractProjectBoltSleeveLink(Long contractProjectId);

   MesContractProjectBoltSleeveLinkDTO detailById(Long id);

   Boolean saveConfig(MesContractProjectBoltSleeveLinkSaveDTOParam param);

   Boolean updateConfig(MesContractProjectBoltSleeveLinkSaveDTOParam param);

   Boolean deleteById(Long id);

   MesContractProjectBoltSleeveLinkDTO getOneByCondition(Long projectId, String typeName, Long processId);
}
