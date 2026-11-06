package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessMachinePartDTO;
import com.hzchum.scim.business.core.api.pojo.dto.SummaryDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import java.util.List;
import java.util.Map;

public interface BusinessMachinePartBiz extends IBiz<BusinessMachinePart> {
   PageVO<BusinessMachinePartDTO> pageListBusinessMachinePart(
      Long monomerId, Long areaId, String specification, String material, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> printListBusinessMachinePart(Long monomerId, Long areaId, String specification, String material, List<Long> ids);

   SummaryDTO summaryMachinePart(Long monomerId);

   ListVO<TechMachinePart> listMachinePartByBusinessId(Long id);

   PrintVO<List<Map<String, Object>>> printMachinePartByBusinessId(Long id);
}
