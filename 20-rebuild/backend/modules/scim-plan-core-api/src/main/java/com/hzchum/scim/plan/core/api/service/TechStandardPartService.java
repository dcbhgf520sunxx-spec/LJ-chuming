package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import java.util.List;

public interface TechStandardPartService extends IService<TechStandardPart> {
   List<TechStandardPart> listByCondition(TechStandardPartQueryDtoParam param, Integer permissionCheck, Long userId);

   PageVO listTechStandardPartPrint(AuxiliaryMaterialPrintDTOParam param);
}
