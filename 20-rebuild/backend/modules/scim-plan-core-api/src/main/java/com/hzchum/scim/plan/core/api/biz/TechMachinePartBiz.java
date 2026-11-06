package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSpacerParallelDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.steel.PlateMatchDTOParam;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechMachinePartBiz {
   PageVO<MachinePartResponseDTO> pageListByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum,
      Integer pageNumber,
      Integer size
   );

   void pageListByConditionExport(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer status,
      Integer type,
      String serialNumber,
      String specification,
      String material,
      String thick,
      Integer steelPlateTypeEnum,
      HttpServletResponse response
   );

   MachinePartDTO getMachinePartInfoById(Long id);

   void updateMachinePartSteel(Long steelId, Boolean isSelectNull, List<PlateMatchDTOParam> links);

   List<TechMachinePart> listBySteelId(Long steelId);

   void initSteelInfo(Long steelId);

   List<ComponentCrderInformationDTO> selectByProjectId(Long projectId);

   List<TechMachinePartDTO> listSpacerByCondition(String serialNumber, String specification, String thick, String material);

   PageVO<TechMachinePartDTO> listSpacerByConditionPage(
      String serialNumber, String specification, String thick, String material, Integer pageNumber, Integer pageSize, List<String> sort
   );

   HashMap<String, Set<String>> getScreeningCondition();

   Boolean saveSpacerParallelList(List<MachinePartSpacerParallelDTOParam> dtoParamList);

   Boolean removeSpacerParallel(List<Long> ids);

   Boolean uploadFileAndUnzip(MultipartFile file, Long id, Integer dataType);

   String uploadTemporaryFiles(MultipartFile file, Integer dataType);
}
