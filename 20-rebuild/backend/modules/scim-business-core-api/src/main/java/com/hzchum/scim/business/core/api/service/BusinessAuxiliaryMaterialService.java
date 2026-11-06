package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.business.core.api.pojo._do.AuxiliaryMaterialSummaryDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessAuxiliaryMaterial;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialFindDTOParam;
import java.util.List;
import java.util.Map;

public interface BusinessAuxiliaryMaterialService extends IService<BusinessAuxiliaryMaterial> {
   Long addBusinessInfo(AuxiliaryMaterialAddDTOParam param);

   void editBusinessInfo(AuxiliaryMaterialEditDTOParam param);

   BusinessAuxiliaryMaterial getByCondition(AuxiliaryMaterialFindDTOParam param);

   ListVO<BusinessAuxiliaryMaterial> listByCondition(AuxiliaryMaterialFindDTOParam param);

   PrintVO<List<Map<String, Object>>> printListByCondition(AuxiliaryMaterialFindDTOParam param);

   AuxiliaryMaterialSummaryDO summary(Long projectId, Long monomerId);
}
