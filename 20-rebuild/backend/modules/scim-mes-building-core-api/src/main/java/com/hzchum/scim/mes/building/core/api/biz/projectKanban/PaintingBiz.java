package com.hzchum.scim.mes.building.core.api.biz.projectKanban;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban.MesBuildingPainting;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactPaintingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactTypePaintingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.PaintingSettingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProductSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ArtifactPaintingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.PaintingDTOParam;
import java.util.List;
import java.util.Map;

public interface PaintingBiz extends IBiz<MesBuildingPainting> {
   List<PaintingSettingDTO> settingList(Long projectId, Long monomerId);

   Boolean settingPainting(PaintingDTOParam dtoParam);

   List<ArtifactTypePaintingDTO> artifactTypePainting(Long projectId, Long monomerId);

   List<ArtifactPaintingDTO> artifactList(Long projectId, Long monomerId, Long configId, Long areaId, String serialNumber);

   PageVO<ArtifactPaintingDTO> artifactPage(
      Long projectId, Long monomerId, Long configId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   Boolean artifactSetting(List<ArtifactPaintingDTOParam> collect);

   PrintVO<List<Map<String, Object>>> artifactTypePaintingPrint(Long projectId, Long monomerId);

   ProductSummaryDTO artifactSummary(Long projectId, Long monomerId, Long configId, Long areaId, String serialNumber);
}
