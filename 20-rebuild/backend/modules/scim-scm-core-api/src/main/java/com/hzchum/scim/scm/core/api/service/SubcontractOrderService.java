package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import java.util.List;
import java.util.Map;

public interface SubcontractOrderService extends IService<SubcontractOrder> {
   List<SubcontractOrderDTO> listSubcontractOrder(SubcontractOrderQueryDTOParam param);

   List<SubcontractOrder> getPageList(SubcontractOrderQueryDtoParamV2 param);

   ListVO<ProjectInfo> getProjectLedger(Long projectManagerId);

   List<SupplierInfo> getSupplierInfo(Long projectManagerId, Long projectId);

   Map<Long, String> getContractNumber(Long projectManagerId, Long projectId, Long supplierId);

   List<SubcontractOrder> pageList(SubcontractOrderQueryDtoParamV2 param);
}
