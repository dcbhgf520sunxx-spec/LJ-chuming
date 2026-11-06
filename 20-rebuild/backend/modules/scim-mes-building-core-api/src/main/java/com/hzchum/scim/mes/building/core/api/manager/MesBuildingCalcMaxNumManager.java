package com.hzchum.scim.mes.building.core.api.manager;

import com.hzchum.scim.common.core.api.pojo.dto.MesBuildingLinkCommonDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.MesBuildingCalcuDTOParam;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactBasicChangeDTOParam;
import java.util.List;
import java.util.Map;

public interface MesBuildingCalcMaxNumManager {
   void calculateMaximumCars(List<MesBuildingCalcuDTOParam> calcuDTOParamList);

   void checkArtifactNumberChanger(Map<Long, List<Integer>> artifactIdSortNumberListMap, Boolean boolPass);

   void checkAssembleNumberChanger(Map<Long, List<Integer>> artifactNumberListMap, Boolean boolPass);

   <T extends MesBuildingLinkCommonDTOParam> List<T> checkPackNumberAndBuild(
      List<T> packageOrCargoLinks, Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap
   );

   void changeArtifact(TechArtifact artifact, ArtifactBasicChangeDTOParam param);

   List<Integer> getNumberList(Long taskProcessId, Boolean boolAssist, Long assistGroupId, Integer quantity);

   List<Integer> getNumberListV2(Long taskProcessId, Boolean boolAssist, Long assistLineId, Integer quantity);
}
