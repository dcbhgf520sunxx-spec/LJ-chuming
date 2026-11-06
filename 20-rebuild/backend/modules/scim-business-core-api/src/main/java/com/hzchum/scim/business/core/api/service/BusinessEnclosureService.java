package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.dto.EnclosureSummaryDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureFindDTOParam;
import java.util.List;

public interface BusinessEnclosureService extends IService<BusinessEnclosure> {
   Long addBusinessInfo(EnclosureAddDTOParam param);

   void editBusinessInfo(EnclosureEditDTOParam param);

   List<BusinessEnclosure> listByCondition(EnclosureFindDTOParam param);

   EnclosureSummaryDTO summary(Long projectId, Long monomerId);
}
