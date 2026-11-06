package com.hzchum.scim.contract.core.api.service.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ManagementFeeDto;
import javax.servlet.http.HttpServletResponse;

public interface ManagementFeeService {
   ListVO<ManagementFeeDto> findAll(Integer year);

   void export(Integer year, HttpServletResponse response);
}
