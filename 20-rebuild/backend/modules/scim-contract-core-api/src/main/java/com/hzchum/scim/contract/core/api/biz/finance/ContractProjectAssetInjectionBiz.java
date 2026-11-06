package com.hzchum.scim.contract.core.api.biz.finance;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionPutDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.InjectionExpendituresDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractProjectAssetInjectionDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ContractProjectAssetInjectionBiz extends IBiz<ContractProjectAssetInjection> {
   Boolean saveAssetInjection(ContractProjectAssetInjectionDTOParam param);

   Boolean updateAssetInjection(ContractProjectAssetInjectionDTOParam param);

   Boolean deleteAssetInjection(Long id);

   PageVO<ContractProjectAssetInjectionDTO> getAssetInjectionPage(
      Long contractSignBodyId, Long projectManagerId, Long projectId, Integer pageNumber, Integer pageSize
   );

   Map<String, Map<Long, String>> getAssetInjection(Long projectId);

   ContractProjectAssetInjectionPutDTO getPutAssetInjection(Long id);

   PrintVO<List<Map<String, Object>>> getProjectDownload(Long projectId);

   Map<String, String> getInjectionAmount(Long projectId);

   List<ContractProjectAssetInjectionDetailDTO> getAssetInjectionDetail(Long projectId, Long supplierId);

   List<SupplierInfo> getPurchaseOrder(Long projectId);

   PrintVO getInjectionDetailDownload(Long projectId, Long supplierId);

   ContractProjectAssetInjectionDetailDTO getProjectDetail(Long projectId);

   PageVO<InjectionExpendituresDetailDTO> getUseDetail(
      Long projectId, Long supplierId, Long orderId, LocalDateTime startTime, LocalDateTime endTime, Integer pageNumber, Integer pageSize
   );
}
