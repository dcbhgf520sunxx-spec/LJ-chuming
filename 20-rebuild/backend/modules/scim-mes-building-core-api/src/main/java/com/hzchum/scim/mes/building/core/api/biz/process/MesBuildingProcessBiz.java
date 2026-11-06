package com.hzchum.scim.mes.building.core.api.biz.process;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.BuildingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessNode;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessRequestDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.ProcessListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.ProcessWageDTOParam;
import java.util.List;
import java.util.Map;

public interface MesBuildingProcessBiz {
   Boolean removeByIds(List<Long> ids);

   List<MesBuildingProcessDTO> listByCondition(Integer productType, Boolean organizationType);

   List<MesBuildingProcessNode> getPartListTree();

   List<MesBuildingProcessDTO> listByCondition(Integer productType, Integer ProductionLineTypeEnum);

   Map<String, ProcessListDTO> listGroupByCondition();

   List<MesBuildingProcessDTO> listByConditionV2(Integer productType, Integer boolFixedProcess);

   ProcessListDTO listGroupByCondition(Integer productionLineTypeEnum);

   PageVO<MesBuildingProcessDTO> processPage(MesBuildingProcessDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   Boolean saveProcessWage(List<ProcessWageDTOParam> dtoParamList);

   Boolean saveList(List<MesBuildingProcessDTOParam> nameList, Integer productType);

   List<MesBuildingProcessDO> getByProcess(Long id);

   List<BuildingTeamDTO> getByTeam(Long taskId, Long processId);

   List<MesBuildingProcessDTO> listRivetWeldArtyFactList();

   List<MesBuildingProcessDTO> listRivetWeldAssembleList();

   List<MesBuildingProcessDTO> getWorkshopByProcessList(Long workshopId);

   List<MesBuildingProcessDTO> partCutWayList(Integer partProdMode, Integer productCategoryType, Integer type);

   Boolean saveOrUpdateProcess(MesBuildingProcessRequestDTO voRequest);
}
