package com.hzchum.scim.scm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectBranchCompanyDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubOrderMonomerDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderV2DTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SaveSubcontractOrderDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderSaveDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderUpdateDTOParam;
import java.util.List;

public interface SubcontractOrderBiz {
   PageVO<SubcontractOrderDTO> pageListOrders(SubcontractOrderQueryDTOParam param, Integer pageNumber, Integer pageSize);

   Boolean save(SubcontractOrderSaveDTOParam param);

   Boolean update(SubcontractOrderUpdateDTOParam param);

   Boolean delete(List<Long> ids);

   SubcontractOrderSummaryDTO getSumSubcontractOrder();

   List<SubOrderMonomerDTO> listByCondition(Long projectId);

   PageVO<SubcontractOrderV2DTO> getPage(SubcontractOrderQueryDtoParamV2 param, Integer pageNumber, Integer pageSize);

   Boolean saveSubcontractOrder(SaveSubcontractOrderDTOParam param);

   Boolean updateSubcontractOrder(SaveSubcontractOrderDTOParam param);

   PageVO<SupplierPaymentDetailDto> getPaymentList(Long orderId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierPaymentDetailDto>> printPaymentList(Long orderId);

   PageVO<SupplierInvoiceDetailDto> getInvoiceList(Long orderId, Integer pageNumber, Integer pageSize);

   PrintVO<List<SupplierInvoiceDetailDto>> printInvoiceList(Long orderId);

   List<SupplierSettlementDTO> listSubOrderSettle(Long orderId, Boolean boolPreSettlement);

   PrintVO<List<SupplierSettlementDTO>> printListSubOrderSettle(Long orderId, Boolean boolPreSettlement);

   SubcontractOrderDTO getSubcontractOrderDetail(Long orderId);

   Boolean deleteSubcontractOrder(List<Long> orderId);

   List<NameInfo> getProjectManagerList();

   List<ProjectBranchCompanyDTO> getProjectList();
}
