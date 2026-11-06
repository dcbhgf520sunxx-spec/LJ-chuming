package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedInstallStoreMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReceivedQueryDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectReceivingRecordMapper extends BaseMapper<ProjectReceivingRecord> {
   List<ProjectReceivedInstallStoreMeteDTO> getReceivedMete(@Param("projectId") Long projectId, @Param("productType") Integer productType);

   List<ProjectReceivedInstallStoreMeteDTO> getInstallMete(@Param("projectId") Long projectId, @Param("productType") Integer productType);

   List<ProjectProductDTO> getStoreDetails(
      @Param("yearMonth") String yearMonth,
      @Param("projectId") Long projectId,
      @Param("productType") Integer productType,
      @Param("storeType") Integer storeType
   );

   List<ProjectProductDTO> getReceivedInstallDetails(
      @Param("yearMonth") String yearMonth,
      @Param("projectId") Long projectId,
      @Param("productType") Integer productType,
      @Param("storeType") Integer storeType
   );

   List<ProjectProductDTO> getReceivedReject(
      @Param("yearMonth") String yearMonth,
      @Param("projectId") Long projectId,
      @Param("productType") Integer productType,
      @Param("storeType") Integer storeType
   );

   List<ProjectProductDTO> getOutReceivedPage(ProjectReceivedQueryDTOParam param);

   List<ProjectReceivedInstallStoreMeteDTO> getRejectMete(Long projectId, Integer productType);

   List<ReconciliationDetailDTO> orderReconciliationDetail(@Param("query") QueryPurchaseInboundDetailDTOParam queryDTOParam);
}
