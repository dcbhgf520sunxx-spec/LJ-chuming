package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractTechBaseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractTechListDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanTechDto;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;

public interface ContractTechService extends IService<ContractTech> {
   BigDecimal getWeightMeter(Long projectId, String plate);

   ContractTechBaseDTO getWithDTO(Long projectId, Integer type, String plate);

   List<Map<String, Object>> getEnclosureConfig(Long projectId, Integer type, String plateType);

   ContractTechListDTO listTech(Long projectId, Integer type);

   List<String> listPlate(Long projectId, Integer type);

   List<Map<String, Integer>> listEnclosureMeasureMode(Long projectId);

   List<Integer> changeEnclosureMeasureMode(Long projectId, List<MeasureModeDTOParam> measureModeDTOParamList);

   Integer getMeasureMode(@NotNull Long projectId, @NotNull Integer productType, Integer category);

   Map<Integer, Integer> listProjectMeasureMode(Long projectId);

   List<EnclosurePlanTechDto> findByProjectId(Long projectId);
}
