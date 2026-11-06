package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOtherApportionmentLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectOtherApportionmentLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectOtherApportionmentLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectOtherApportionmentLinkService extends IService<MesContractProjectOtherApportionmentLink> {
   List<MesContractProjectOtherApportionmentLinkDTO> listInfo(Long projectId);

   Boolean saveContractProjectOtherApportionmentLink(Long contractProjectId);

   MesContractProjectOtherApportionmentLinkDTO detailById(Long id);

   Boolean saveConfig(MesContractProjectOtherApportionmentLinkSaveDTOParam param);

   Boolean editConfig(MesContractProjectOtherApportionmentLinkSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
