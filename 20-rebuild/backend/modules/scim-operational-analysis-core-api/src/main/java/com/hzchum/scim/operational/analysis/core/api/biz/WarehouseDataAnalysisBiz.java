package com.hzchum.scim.operational.analysis.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ClassificationSimpleDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.MaterialOutInCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.CommonDetailSimpleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ClassifyCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventorySimpleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MonthInventoryCostDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectOutSummaryDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface WarehouseDataAnalysisBiz {
   List<ClassCostDTO> getSteelsInventoryInventory(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<ClassifyCostDTO> getAuxiliaryOrOtherInventory(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId);

   PageVO<MaterialInventorySimpleDTO> getInventorySimpleDTOPage(
      LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getInventorySimpleDTOPrint(LocalDate yearDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId);

   void getInventorySimpleDTODownload(LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId);

   List<DateCostDTO> getOperationsAnalysisInventoryGroupByMonth(LocalDate yearDate, Integer basicClass, Long branchCompanyId, Long workshopId);

   PageVO<MaterialInventorySimpleDTO> getOperationsAnalysisInventoryGroupByMonthPageList(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getOperationsAnalysisInventoryGroupByMonthPrint(
      LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId
   );

   void getOperationsAnalysisInventoryGroupByMonthDownload(LocalDate yearMouthDate, Integer basicClass, Long classifyId, Long branchCompanyId, Long workshopId);

   Map<String, Object> getMainMaterialOutInMete(Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   Map<String, Object> getAuxiliaryMaterialOutInMete(Long classifyId, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<MaterialOutInCostDTO> getMaterialOutInCost(Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   PrintVO<List<Map<String, Object>>> getMaterialOutInCostPrint(Integer basicClass, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   void getMaterialOutInCostDownload(Integer basicClass, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   PageVO<CommonDetailSimpleDTO> getMaterialOutRecord(
      Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getMaterialOutRecordPrint(Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   void getMaterialOutRecordDownload(Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   PageVO<CommonDetailSimpleDTO> getMaterialInRecord(
      Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getMaterialInRecordPrint(Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   void getMaterialInRecordDownload(Integer basicClass, Long classifyId, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<ProjectOutSummaryDTO> getProjectOutSummaryList(Integer status, LocalDate yearDate, Long branchCompanyId, Long workshopId);

   Map<String, List<CommonDetailSimpleDTO>> getProjectOutDetailList(
      Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId
   );

   void downloadProjectOutDetailList(Long projectId, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<ClassificationSimpleDTO> getAuxiliaryOneLevel();

   List<DateCostDTO> getSurplusMaterialInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   PrintVO<List<Map<String, Object>>> getSurplusMaterialInventoryGroupByMonthPrint(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   void getSurplusMaterialInventoryGroupByMonthDownload(LocalDate yearDate, Long branchCompanyId, Long workshopId);

   List<ClassCostDTO> getInventoryCost(LocalDate yearDate, Long branchCompanyId);

   List<MonthInventoryCostDTO> getInventoryInventoryCostDetail(LocalDate yearDate, Long branchCompanyId, Integer basicClass);

   void getInventoryInventoryCostDetailDownload(LocalDate yearDate, Long branchCompanyId, Integer basicClass, HttpServletResponse response);

   List<DateCostDTO> getInventoryGroupByMonth(LocalDate yearDate, Long branchCompanyId);

   List<MonthInventoryCostDTO> getInventoryGroupByMonthDetail(LocalDate monthDate, Long branchCompanyId);

   void getInventoryGroupByMonthDetailDownload(LocalDate mouthDate, Long branchCompanyId);

   void getOutInCostGroupByMonth(Integer basicClass, Long classifyId, LocalDate yearDate, Long branchCompanyId, Long workshopId);
}
