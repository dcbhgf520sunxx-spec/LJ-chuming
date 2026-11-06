package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmSupplierWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierTaskPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierTaskPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSupplierWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmSupplierWarehousingUpdateParam;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmSupplierWarehousingBiz extends IBiz<CrmSupplierWarehousing> {
   Boolean deleteCrmSupplierWarehousing(Long id);

   HashMap<String, Integer> summary(Integer checkRecord);

   PageVO<CrmSupplierWarehousingPageDTO> getCrmSupplierWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
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

   PrintVO<List<Map<String, Object>>> downLoadCrmSupplierWarehousingList(
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

   Boolean saveCrmSupplierWarehousing(CrmSupplierWarehousingSaveParam crmSupplierWarehousingSafeParam);

   Boolean updateCrmSupplierWarehousing(CrmSupplierWarehousingUpdateParam copy);

   CrmSupplierWarehousingDetailDTO crmSupplierWarehousingDetail(Long id);

   Boolean downLoadCrmSupplierWarehousingDetail(Long id, HttpServletResponse response);

   PageVO<CrmSupplierTaskPageDTO> getCrmSupplierTaskPage(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      String crmEnterpriseWarehousingName,
      String createUserName,
      Integer pageNumber,
      Integer pageSize
   );

   HashMap<String, Integer> getCrmSupplierTaskSum();

   Boolean overruleTask(Long id);

   List<CrmSupplierTaskPageDownLoadDTO> downLoadCrmSupplierTaskList(
      Integer crmCheckStatusEnum, LocalDate startDate, LocalDate endDate, String crmEnterpriseWarehousingName, String createUserName
   );

   Boolean caLocked(CaLockedParam caLockedParam);
}
