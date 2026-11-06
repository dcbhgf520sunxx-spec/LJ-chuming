package com.hzchum.scim.mes.building.core.api.biz.craft;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesBuildingPaintCalculateRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintCalculateRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesBuildingPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintStructureClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintTechnologyArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintCalculateRecordSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesBuildingPaintTechnologyQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintTechnologyArtifactQueryParam;
import java.util.List;

public interface MesBuildingPaintCalculateRecordBiz extends IBiz<MesBuildingPaintCalculateRecord> {
   PageVO<MesBuildingPaintTechnologyProjectGroupDTO> pageListProjectPaintTechnology(
      MesBuildingPaintTechnologyQueryParam param, Integer pageNumber, Integer pageSize
   );

   List<MesPaintStructureClassDTO> getUnCalculateStructureClassList(Long paintTechnologyId);

   Boolean savePaintCalculateRecord(MesBuildingPaintCalculateRecordSaveParam param);

   Boolean removeCalculateRecord(List<Long> calculateRecordIds);

   List<MesBuildingPaintCalculateRecordDTO> listPaintCalculateRecord(Long paintTechnologyId);

   PrintVO<List<MesPaintStructureClassDTO>> printListPaintCalculateRecord(Long calculateRecordId);

   PageVO<MesPaintTechnologyArtifactDTO> calculateRecordArtifactList(MesPaintTechnologyArtifactQueryParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<MesPaintTechnologyArtifactDTO>> printCalculateRecordArtifactList(MesPaintTechnologyArtifactQueryParam param);
}
