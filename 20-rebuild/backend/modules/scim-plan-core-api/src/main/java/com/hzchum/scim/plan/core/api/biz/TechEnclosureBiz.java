package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.biz.check.MesTechEnclosureInventoryOperationDTOParam;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo._do.ProjectSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureSubscribeDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.check.MesTechInventoryOperationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureNeedSchedulingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectSchedulingStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.EnclosureSubscribeQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeCheckDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechEnclosureChangeRecordQueryVoParam;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface TechEnclosureBiz {
   PageVO<EnclosureResponseDTO> pageListEnclosure(EnclosureListQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<EnclosureResponseDTO> pageListEnclosureV2(EnclosureListQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort);

   void importEnclosure(MultipartFile file, Long enclosurePlanId, Integer importType, HttpServletResponse response);

   @Transactional(rollbackFor = Exception.class)
   Boolean importEnclosureV2(MesTechEnclosureInventoryOperationDTOParam dtoParam);

   @Transactional(rollbackFor = Exception.class)
   void importInventory(MultipartFile file, Long areaId, Integer importType, HttpServletResponse response);

   @Transactional(rollbackFor = Exception.class)
   Boolean commitChangeRecord(EnclosureUpdateDTOParam param);

   Boolean saveEnclosure(Long enclosurePlanId, EnclosureSaveDTOParam saveDTOParam);

   Boolean saveEnclosureList(Long planId, List<EnclosureSaveDTOParam> saveDTOParamList);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveEnclosureListV2(Long areaId, List<EnclosureSaveDTOParam> saveDTOParamList);

   Boolean updateEnclosure(EnclosureUpdateDTOParam updateDTOParam);

   Boolean oneClear(Long areaId);

   @Transactional(rollbackFor = Exception.class)
   Boolean enclosureAreaClear(Long areaId);

   Boolean updateStatus(Long enclosureId, Boolean status);

   Boolean updateStatusV2(Long enclosureId, Boolean status);

   Boolean deleteEnclosure(List<Long> enclosureIds);

   EnclosureDTO getEnclosureDTOById(Long id);

   EnclosureDTO getEnclosureDTOByIdV2(Long id);

   List<EnclosureProjectSchedulingStateDTO> listByType(Integer year, Integer state, String name, Integer projectType, Integer lumpSumSystemType);

   List<ProjectSchedulingTreeDO> enclosureSchedulingTree(Integer year, Integer state, String name);

   List<Integer> projectCategory(Long projectId);

   Map<Long, String> projectEnclosureDictionary(List<Long> areaIds);

   List<EnclosurePlanDTO> planByCondition(Long projectId, Integer type);

   PageVO<EnclosureNeedSchedulingDTO> listEnclosure(List<Long> planIds, Integer category, Integer pageNumber, Integer pageSize);

   PageVO<TechEnclosureSubscribeDTO> getUnSchedulingEnclosureList(EnclosureSubscribeQueryDtoParam param, Integer pageNumber, Integer pageSize);

   PageVO<TechEnclosureChangeRecordDTO> pageListChangeRecord(TechEnclosureChangeRecordQueryVoParam param, Integer pageNumber, Integer pageSize);

   @Transactional(rollbackFor = Exception.class)
   Boolean checkChange(TechChangeCheckDtoParam param);

   PageVO<MesTechInventoryOperationDTO> getInventoryList(
      String projectName, String createUserName, String reviewedName, Integer inventoryReviewedEnum, Integer pageNumber, Integer pageSize
   );

   PageVO<EnclosureNeedSchedulingDTO> listEnclosureV2(List<Long> areaIds, Long dictionaryId, Integer pageNumber, Integer pageSize);

   PageVO<EnclosureNeedSchedulingDTO> schedulingListEnclosure(List<Long> areaIds, Integer dictionaryId, Integer pageNumber, Integer pageSize);

   PageVO<EnclosureResponseDTO> enclosureV2(EnclosureListQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort);

   List<EnclosureResponseDTO> enclosureListV2(EnclosureListQueryDTOParam queryDTOParam);
}
