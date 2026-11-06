package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.pojo.dto.SysAuxiliaryClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysAuxiliaryClassificationDTOParam;

public interface SysAuxiliaryClassificationBiz extends IBiz<SysAuxiliaryClassification> {
   PageVO<SysAuxiliaryClassificationDTO> listAuxiliaryClass(String name, Integer pageNumber, Integer pageSize);

   Boolean saveAuxiliaryClass(SysAuxiliaryClassificationDTOParam param);

   Boolean updateAuxiliaryClass(SysAuxiliaryClassificationDTOParam param);

   Boolean delById(Long id);
}
