package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessStandardPartQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartAddDtoParam;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public interface BusinessStandardPartService extends IService<BusinessStandardPart> {
   List<BusinessStandardPart> listByCondition(BusinessStandardPartQueryDtoParam param);

   Long addBusiness(StandardPartAddDtoParam addDTOParam);

   void editBusiness(@NotNull Long businessId, @NotNull BigDecimal quantity, BigDecimal mete);
}
