package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedInstallStoreMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReceivedQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ReceivingStatementQueryDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReconciliationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import java.util.List;

public interface ProjectReceivingRecordService extends IService<ProjectReceivingRecord> {
   List<ProjectReceivingRecord> listReceivingRecord(ReceivingStatementQueryDTOParam param);

   List<ProjectReceivingRecord> listReceivingRecordV2(ReceivingStatementQueryDTOParam param);

   List<ProjectReceivedInstallStoreMeteDTO> getReceivedMete(Long project, Integer productType);

   List<ProjectReceivedInstallStoreMeteDTO> getRejectMete(Long projectId, Integer productType);

   List<ProjectReceivedInstallStoreMeteDTO> getInstallMete(Long project, Integer productType);

   List<ProjectProductDTO> getStoreDetails(String yearMonth, Long projectId, Integer productType, Integer storeType);

   List<ProjectProductDTO> getReceivedInstallDetails(String yearMonth, Long projectId, Integer productType, Integer storeType);

   List<ProjectProductDTO> getReceivedReject(String yearMonth, Long projectId, Integer productType, Integer storeType);

   PageVO<ProjectProductDTO> getOutReceivedPage(ProjectReceivedQueryDTOParam param, Integer pageNumber, Integer pageSize);

   List<ProjectProductDTO> getOutReceivedList(ProjectReceivedQueryDTOParam param);

   List<ReconciliationDetailDTO> orderReconciliationDetail(QueryPurchaseInboundDetailDTOParam queryDTOParam);
}
