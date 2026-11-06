package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryMaterial;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialClassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialUpdateDTOParam;
import java.util.List;

public interface TechAuxiliaryMaterialService extends IService<TechAuxiliaryMaterial> {
   PageVO<AuxiliaryMaterialDTO> listAuxiliaryMaterials(
      Long projectId, Long monomerId, String classificationName, String serialNumber, Integer pageNumber, Integer pageSize, List<String> sort
   );

   Boolean saveAuxiliaryMaterial(Long projectId, Long monomerId, List<AuxiliaryMaterialSaveDTOParam> saveDTOParamList);

   Boolean updateAuxiliaryMaterial(AuxiliaryMaterialUpdateDTOParam updateDTOParam);

   Boolean deleteAuxiliaryMaterials(Long projectId, List<Long> ids);

   List<TechAuxiliaryMaterial> listByBusinessId(Long businessId);

   PageVO listAuxiliaryMaterialPrint(AuxiliaryMaterialPrintDTOParam param);

   TechStandardPartBaseInfo getInfoById(Long productId);

   List<AuxiliaryMaterialClassDTO> listAuxiliaryMaterialClass(Long projectId);
}
