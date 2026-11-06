package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ContractVisaService extends IService<ContractVisa> {
   List<ContractVisa> listByCondition(
      Long projectId, Integer status, String userName, String checkUerName, Integer mode, String year, Integer businessType, Integer type
   );

   int countByProject(Long projectId, Integer mode);

   int getCount(LocalDateTime now, Integer mode);

   BigDecimal sumVisaAmount(Long projectId, Integer mode, Integer type);

   List<Long> listProjectIdsWithSettle();

   Boolean checkProjectIsSettlement(Long projectId);
}
