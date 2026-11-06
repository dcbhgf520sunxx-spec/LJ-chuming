package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo.dto.ApplyPurchaseDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface ApplyPurchaseMapper extends BaseMapper<ApplyPurchase> {
   List<ApplyPurchaseDTO> list(
      @Param("times") List<LocalDateTime> times,
      @Param("materialType") Integer materialType,
      @Param("serialNumber") String serialNumber,
      @Param("status") Integer status,
      @Param("enabled") Boolean enabled,
      @Param("boolInitiateApprove") Boolean boolInitiateApprove
   );

   List<ApplyPurchaseDTO> applyPurchaseDTOListV2(
      @Param("times") List<LocalDateTime> times,
      @Param("materialType") Integer materialType,
      @Param("serialNumber") String serialNumber,
      @Param("status") Integer status,
      @Param("enabled") Boolean enabled,
      @Param("boolInitiateApprove") Boolean boolInitiateApprove,
      @Param("departmentName") String departmentName,
      @Param("applicantName") String applicantName,
      @Param("projectId") Long projectId,
      @Param("projectAttribute") Integer projectAttribute,
      @Param("purchaseCreationState") Integer purchaseCreationState,
      @Param("level") Integer level,
      @Param("branchCompanyId") Long branchCompanyId
   );

   ApplyPurchaseDTO getById(Long id);

   void updateInboundMete(Long applyPurchaseId, BigDecimal inboundMete);

   int getCountByDate();

   int getCountByDateV2();

   List<ApplyPurchase> selectApplyPurchaseList(
      @Param("times") List<LocalDateTime> times,
      @Param("materialType") Integer materialType,
      @Param("purchaseCreationState") Integer purchaseCreationState,
      @Param("level") Integer level,
      @Param("projectAttribute") Integer projectAttribute,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("projectId") Long projectId
   );

   Boolean updateBoolDeleteById(Long passParentId);

   Integer selectCountBySerialNumberParent(@Param("serialNumberParent") String serialNumberParent);

   List<BriefIdAndSNDTO> selectApplyPurchaseManufacturedList(
      @Param("projectId") Long projectId, @Param("materialType") Integer materialType, @Param("branchCompanyId") Long branchCompanyId
   );

   ApplyPurchase getByIdAll(Long id);
}
