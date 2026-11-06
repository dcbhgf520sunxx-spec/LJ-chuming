package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmGovernmentWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentTaskPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentTaskPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmGovernmentWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmGovernmentWarehousingUpdateParam;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmGovernmentWarehousingBiz extends IBiz<CrmGovernmentWarehousing> {
   Boolean saveCrmGovernmentWarehousing(CrmGovernmentWarehousingSaveParam copy);

   Boolean deleteCrmGovernmentWarehousing(Long id);

   Boolean updateCrmGovernmentWarehousing(CrmGovernmentWarehousingUpdateParam copy);

   HashMap<String, Integer> summary(Integer checkRecord);

   PageVO<CrmGovernmentWarehousingPageDTO> getCrmGovernmentWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> downLoadCrmGovernmentWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   );

   CrmGovernmentWarehousingDetailDTO crmGovernmentWarehousingDetail(Long id);

   Boolean downLoadCrmGovernmentWarehousingDetail(Long id, HttpServletResponse response);

   Boolean overruleTask(Long id);

   PageVO<CrmGovernmentTaskPageDTO> getCrmGovernmentTaskPage(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      String crmEnterpriseWarehousingName,
      String createUserName,
      Integer pageNumber,
      Integer pageSize
   );

   HashMap<String, Integer> getCrmGovernmentTaskSum();

   List<CrmGovernmentTaskPageDownLoadDTO> downLoadCrmGovernmentTaskList(
      Integer crmCheckStatusEnum, LocalDate startDate, LocalDate endDate, String crmEnterpriseWarehousingName, String createUserName
   );

   Boolean caLocked(CaLockedParam caLockedParam);
}
