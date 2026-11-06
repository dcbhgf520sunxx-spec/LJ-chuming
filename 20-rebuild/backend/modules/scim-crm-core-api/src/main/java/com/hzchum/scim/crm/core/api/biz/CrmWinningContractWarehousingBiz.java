package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmWinningContractWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBackfillTheDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRemainderCanEstablishProjectDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRemainderCanEstablishProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingSimpleDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUpLoadStampContractParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmNonDirectSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParamV2;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmWinningContractWarehousingBiz extends IBiz<CrmWinningContractWarehousing> {
   List<CrmRemainderCanEstablishProjectInfoDTO> getRemainderCanEstablishProjectInfo(Long id);

   PageVO<CrmWinningContractWarehousingPageDTO> getContractList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum,
      String condition,
      List<Integer> tenderRequirement,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean saveCrmWinningContractWarehousing(CrmWinningContractWarehousingSaveParam copy);

   Boolean upLoadStampContract(CrmUpLoadStampContractParam crmUpLoadStampContractParam);

   CrmWinningContractWarehousingDetailDTO getContractDetail(Long id);

   CrmRemainderCanEstablishProjectDetailDTO getRemainderCanEstablishProjectDetail(Long id);

   PrintVO<List<Map<String, Object>>> getContractListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      Integer crmProjectScheduleTypeEnum,
      String crmEnterpriseWarehousingName
   );

   Boolean getContractDetailDownLoad(Long id, HttpServletResponse response);

   List<CrmWinningContractWarehousingSimpleDTO> getSimpleList();

   CrmBackfillTheDetailDTO backfillTheDetails(Long id);

   HashMap<String, Integer> getContractSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum
   );

   Boolean saveCrmWinningContractWarehousingCustom(CrmWinningContractWarehousingSaveParamV2 copy);

   PageVO<CrmSpecialProgramsDTO> getSpecialProgramsList(
      Boolean reportingStatus,
      Integer crmSubmissionStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String projectNumber,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean saveSpecialPrograms(List<CrmSpecialProgramsSaveParam> copy);

   List<CrmSpecialProgramsDetailDTO> getSpecialProgramsDetail(Long id);

   Boolean saveNonDirectSpecialPrograms(CrmNonDirectSpecialProgramsSaveParam copy);
}
