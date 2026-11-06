package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesBuildingBoChuNestingResultInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesJobMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesNestingResultSteelPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.JobSteelPlateParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingBoChuNestingResultService extends IService<MesBuildingBoChuNestingResult> {
   String getMaxFileName(String prefix);

   MesJobMachinePartSummaryDTO jobMachinePartSummary(Integer jobId);

   List<MesJobMachinePartSummaryDTO> jobMachinePartSummaryList(List<Integer> jobIdList);

   PageVO<MesNestingResultSteelPlateDTO> pageInfo(NestingResultQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesNestingResultSteelPlateDTO> listInfo(NestingResultQuery query);

   Boolean jobSteelPlateDelete(JobSteelPlateParam param);

   Boolean jobSteelPlateScheduling(JobSteelPlateParam param);

   Boolean jobSteelPlateSecondaryScheduling(JobSteelPlateParam param);

   Boolean jobSteelPlateSecondarySchedulingV2(JobSteelPlateParam param);

   void jobSteelPlateBatchDownloadReportForm(NestingResultQuery query, HttpServletResponse response);

   Boolean jobSteelPlateSchedulingRevoke(JobSteelPlateParam param);

   void jobSteelPlateCuttingCodeDownload(Integer jobId, Long nestingResultId, HttpServletResponse response);

   List<MesBuildingBoChuNestingResultInfoDTO> listByQueryCondition(NestingResultQuery query);
}
