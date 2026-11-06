package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingTaskNeedMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.PickingPartDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingProductInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkTreeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkshopTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ApprovePartRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartNestingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingBoChuJobDirectoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingTeamDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskNeedMachinePartSchedulingMapper extends BaseMapper<MesBuildingTaskNeedMachinePartScheduling> {
   List<MesBuildingTaskNeedMachinePartSchedulingDO> getNeedDetailByIds(@Param("ids") List<Long> ids);

   List<WorkshopDetailDO> getWorkShopList(@Param("param") MachinePartNestingTeamDTOParam param);

   List<MachinePartNestingTeamDTO> getTeamList(@Param("param") MachinePartNestingTeamDTOParam param);

   List<MachinePartNestingTeamDTO> getNeedMachinePartOrderList(@Param("param") MachinePartNestingTeamDTOParam param);

   List<MachinePartNestingDetailDTO> getNeedMachinePartDetailList(@Param("param") MachinePartNestingProductDetailDTOParam param);

   int passDeleteCount();

   List<MesBuildingBoChuJobDirectory> getMesBuildingBoChuJobDirectoryByProjectId(
      @Param("projectIdsStr") String projectIdsStr, @Param("workshopId") String workshopId, @Param("teamCode") Long teamCode
   );

   List<MesBuildingBoChuJobDirectory> getMesBuildingBoChuJobDirectoryByWorkshopId(
      @Param("workshopIdStr") String workshopIdStr, @Param("teamCode") Long teamCode
   );

   List<MesBuildingBoChuJobDirectoryDTO> getMesBuildingBoChuJobDirectoryByProjectIdAll(
      @Param("name") String name,
      @Param("projectIdsStr") String projectIdsStr,
      @Param("startDate") String startDate,
      @Param("endDate") String endDate,
      @Param("workShopId") List<Long> workShopId
   );

   List<MesBuildingBoChuJobDirectoryDTO> getWorkList(WorkTreeDTO workTreeDTO);

   int insertMesBuildingBoChuJobDirectory(@Param("param") MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory);

   String getDictionaryByNameAndSort(@Param("name") String name, @Param("sort") Integer sort);

   List<MachinePartNestingProductInfoDTO> getJobInfoByJobId(@Param("jobId") Integer jobId);

   List<WorkshopTeamDTO> getWorkShopNestingList();

   void deleteMesBuildingBoChuJobDirectoryByJobId(@Param("jobId") Integer jobId);

   List<MesBuildingTeamUserLink> getTeamLeaderName(@Param("teamId") Long teamId);

   ApprovePartRecordDTO resultByApprovePartList(@Param("dataId") Long dataId);

   List<PickingPartDO> getWmsPickingDTOParam(@Param("dataId") Long dataId);
}
