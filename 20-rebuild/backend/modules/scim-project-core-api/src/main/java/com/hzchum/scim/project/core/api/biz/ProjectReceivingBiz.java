package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectPurchaseOrderSimpleDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectPurchaseProductDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedInstallStoreSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedOperateRecordDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallSumDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingRecordDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubAppReceivingDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListProductDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListReceivingDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.CargoListQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingStatementQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectConfirmCargoListReceivingDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectConfirmCargoListReceivingDTOParamV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectPurchaseReceivingDTOParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProjectReceivingBiz {
   PageVO<ProjectCargoListReceivingDTO> listProjectSelfReceiving(CargoListQueryDTOParam param, Integer pageNumber, Integer pageSize);

   ListVO<ProjectCargoListProductDTO> listCargoListProduct(Long cargoListId, Long projectId);

   ListVO<ProjectCargoListProductDTO> listCargoListProductUp(Long cargoListId, Long projectId);

   PrintVO<List<Map<String, Object>>> printListCargoListProduct(Long cargoListId, Long projectId);

   PrintVO<List<Map<String, Object>>> printListCargoListProductUp(Long cargoListId, Long projectId);

   Boolean confirmCargoListReceiving(ProjectConfirmCargoListReceivingDTOParam param);

   ListVO<ProjectCargoListProductDTO> listCargoListProductV2(Long cargoListId);

   Boolean confirmCargoListReceivingV2(ProjectConfirmCargoListReceivingDTOParamV2 param);

   List<ProjectPurchaseOrderSimpleDTO> getPurchaseOrderSimpleInfo(Long projectId, Long supplierId);

   List<SupplierInfo> getPurchaseOrderSupplier(Long projectId);

   List<ProjectPurchaseProductDetailsDTO> getPurchaseProductDetailsInfo(
      Long contractId, String name, String serialNumber, String specification, String material
   );

   Boolean purchaseReceiving(ProjectPurchaseReceivingDTOParam param);

   PageVO<ProjectReceivedOperateRecordDTO> getOperateRecordPage(Long projectId, Long supplierId, Integer pageNumber, Integer pageSize);

   List<ProjectPurchaseProductDetailsDTO> getOperateRecordDetails(Long operateId);

   PrintVO<List<Map<String, Object>>> operateRecordDetailsPrint(Long operateId);

   PrintVO<List<Map<String, Object>>> listCargoListCanReceiveProductPrint(Long cargoListId, Long projectId);

   void saveReceiving(Long cargoListId, Integer projectType);

   PageVO<ProjectReceivingRecordDTO> listReceivingRecord(ReceivingStatementQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectReceivingRecordDTO> listReceivingRecordV2(ReceivingStatementQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListReceivingRecord(ReceivingStatementQueryDTOParam param);

   PrintVO<List<Map<String, Object>>> printListReceivingRecordV2(ReceivingStatementQueryDTOParam param);

   PageVO<ProjectReceivingBoardDTO> listReceivingBoard(ReceivingBoardQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectReceivingInstallDTO> listReceivingInstall(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListReceivingInstall(ProjectBaseQueryDTOParam param);

   ProjectReceivingInstallSumDTO getReceivingInstallSum(ProjectBaseQueryDTOParam param);

   PageVO<ProjectReceivingInstallDTO> listCanInstall(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectReceivingInstallDTO> listCanInstallV2(ProjectBaseQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectSubAppReceivingDTO> listSubAppAbleInstall(
      Integer productType, Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize
   );

   PageVO<ProjectSubAppReceivingDTO> listSubAppAbleInstallV2(
      Integer productType, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   List<ProjectReceivedInstallStoreSummaryDTO> getReceivedInstallStore(LocalDate year, Long projectId, Integer productType);

   PageVO<ProjectProductDTO> getReceivedInstallStoreDetails(
      String yearMonth, Long projectId, Integer productType, Integer storeType, Integer pageNumber, Integer pageSize
   );

   PageVO<ProjectProductDTO> getReceivedPage(
      Long projectId,
      Integer sourceType,
      Integer productType,
      Long supplierId,
      String name,
      String serialNumber,
      LocalDate startTime,
      LocalDate endTime,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getReceivedPrint(
      Long projectId, Integer sourceType, Integer productType, Long supplierId, String name, String serialNumber, LocalDate startTime, LocalDate endTime
   );
}
