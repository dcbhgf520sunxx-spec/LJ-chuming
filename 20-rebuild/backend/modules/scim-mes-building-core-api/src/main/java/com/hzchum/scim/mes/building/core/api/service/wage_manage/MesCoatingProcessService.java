package com.hzchum.scim.mes.building.core.api.service.wage_manage;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesCoatingProcessSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import java.math.BigDecimal;
import java.util.List;

public interface MesCoatingProcessService extends IService<MesCoatingProcess> {
   List<MesCoatingProcessDTO> listInfo(Long contractProjectId);

   List<MesCoatingProcessDTO> listInfoByContractProjectIds(List<Long> contractProjectIds);

   MesCoatingProcessDTO detailById(Long id);

   Boolean saveCoatingProcess(MesCoatingProcessSaveDTOParam saveDTOParam);

   List<MesCoatingProcessArtifactTypeDTO> artifactTypeList(Long projectId, Long monomerId, Long areaId);

   PageVO<MesCoatingProcessArtifactDTO> artifactList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long artifactTypeId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean updateCoatingProcess(MesCoatingProcessSaveDTOParam saveDTOParam);

   Boolean deleteById(Long id);

   List<MesCoatingProcessArtifactDTO> coatingProcessArtifactList(Long id, String name, String serialNumber, String specification, String material);

   Boolean editArtifactList(MesCoatingProcessSaveDTOParam saveDTOParam);

   Boolean deleteArtifact(MesCoatingProcessSaveDTOParam saveDTOParam);

   PrintVO listPrint(Long contractProjectId);

   Boolean noPaintingRequired(List<TechArtifact> artifactList);

   Boolean addArtifactList(MesCoatingProcessSaveDTOParam saveDTOParam);

   List<MesCoatingProcessArtifactDTO> coatingProcessArtifactDetailList(Long id, Long artifactId, BigDecimal area, Boolean boolProduced);

   PageVO<MesCoatingProcessArtifactDTO> coatingProcessArtifactDetailPage(
      Long id, Long artifactId, BigDecimal area, Boolean boolProduced, Integer pageNumber, Integer pageSize
   );

   Boolean coatingProcessArtifactDetailDelete(Long coatingProcessId, List<Long> ids);
}
