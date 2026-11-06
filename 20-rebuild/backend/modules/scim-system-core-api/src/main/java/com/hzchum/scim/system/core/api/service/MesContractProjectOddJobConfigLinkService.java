package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOddJobConfigLink;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectOddJobConfigLinkSaveDTOParam;
import java.util.List;

public interface MesContractProjectOddJobConfigLinkService extends IService<MesContractProjectOddJobConfigLink> {
   PageVO<MesContractProjectOddJobConfigLink> pageInfo(Long projectId, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesContractProjectOddJobConfigLink> listInfo(Long projectId);

   MesContractProjectOddJobConfigLink detailById(Long id);

   Boolean saveConfig(MesContractProjectOddJobConfigLinkSaveDTOParam param);

   Boolean editConfig(MesContractProjectOddJobConfigLinkSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteById(Long id);

   Boolean saveContractProjectOddJobConfigLink(Long contractProjectId);
}
