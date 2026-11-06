package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectDisburseDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectDisburseDetailDto;
import java.util.List;
import java.util.Map;

public interface ContractProjectDisburseDetailBiz extends IBiz<ContractProjectDisburseDetail> {
   PageVO<ContractProjectDisburseDetailDto> detailList(Long projectId, Integer pageNumber, Integer pageSize);

   List<ContractProjectDisburseDetailDto> getContractProjectDisburseDetailDtoPageVO(Long projectId);

   PrintVO<List<Map<String, Object>>> getSupplierInvoiceDownload(Long projectId);

   PrintVO detailListDownload(Long projectId);
}
