package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessProjectInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dto.ShipmentInfoDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessShipListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionV2DTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceV2DTO;
import java.util.List;

public interface BusinessProjectTrackingBiz {
   BusinessProjectInfoDTO getOrderTrackingProjectInfo(Long projectId, Long branchCompanyId);

   PageVO<ContractCollectionV2DTO> projectCollectionList(Long projectId, Long branchCompanyId, Integer monthType, Integer pageNumber, Integer pageSize);

   PrintVO<List<ContractCollectionV2DTO>> projectCollectionListPrint(Long projectId, Long branchCompanyId, Integer monthType);

   PageVO<ContractInvoiceV2DTO> projectInvoiceList(Long projectId, Long branchCompanyId, Integer monthType, Integer pageNumber, Integer pageSize);

   PrintVO<List<ContractInvoiceV2DTO>> projectInvoiceListPrint(Long projectId, Long branchCompanyId, Integer monthType);

   PageVO<ShipmentInfoDTO> projectShipPageList(BusinessShipListQueryParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<ShipmentInfoDTO>> projectShipPageListPrint(BusinessShipListQueryParam param);
}
