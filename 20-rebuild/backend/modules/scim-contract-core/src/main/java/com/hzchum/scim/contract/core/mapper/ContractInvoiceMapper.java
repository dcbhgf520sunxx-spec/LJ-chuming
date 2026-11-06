package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractInvoiceQueryDoParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractInvoiceMapper extends BaseMapper<ContractInvoice> {
   List<ContractInvoiceDTO> listByCondition(ContractInvoiceQueryDoParam param);

   BigDecimal selectInvoiceAmount(@Param("projectId") Long projectId, @Param("auditStatus") Integer auditStatus);

   BigDecimal selectSumOutTax(Long projectId, Integer auditStatus);

   List<ContractInvoice> selectIncomeAndExpenses(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate);
}
