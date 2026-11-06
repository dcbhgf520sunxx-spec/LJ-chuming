package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingSimpleInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmEnterpriseWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmEnterpriseWarehousingUpdateParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmEnterpriseWarehousingBiz extends IBiz<CrmEnterpriseWarehousing> {
   Boolean saveCrmEnterpriseWarehousing(CrmEnterpriseWarehousingSaveParam param);

   Boolean updateCrmEnterpriseWarehousing(CrmEnterpriseWarehousingUpdateParam param);

   HashMap<String, Integer> summary();

   PageVO<CrmEnterpriseWarehousingPageDTO> getCrmEnterpriseWarehousingPage(
      Integer crmCheckStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
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
      String condition,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean deleteCrmEnterpriseWarehousing(Long id);

   PrintVO<List<Map<String, Object>>> downLoadCrmEnterpriseWarehousingList(
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

   List<CrmEnterpriseWarehousingSimpleInfoDTO> getCrmEnterpriseWarehousingSimpleInfoList();

   CrmEnterpriseWarehousingDetailDTO crmEnterpriseWarehousingDetail(Long id);

   Boolean downLoadCrmEnterpriseWarehousingDetail(Long id, HttpServletResponse response);

   Boolean taskPrecheck(Long crmEnterpriseWarehousingId, Integer crmPageManagementConfigEnum);
}
