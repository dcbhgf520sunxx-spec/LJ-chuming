package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBiddingPlatformWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmBiddingPlatformWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBiddingPlatformWarehousingUpdateParam;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface CrmBiddingPlatformWarehousingBiz extends IBiz<CrmBiddingPlatformWarehousing> {
   HashMap<String, Integer> summary(Integer checkRecord);

   Boolean deleteCrmBiddingPlatformWarehousing(Long id);

   PageVO<CrmBiddingPlatformWarehousingPageDTO> getCrmBiddingPlatformWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitClassConfigurationId,
      Long unitPropertyAllocationConfigId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String biddingPlatformName,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> downLoadCrmBiddingPlatformWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      String biddingPlatformName,
      String informantUserName
   );

   Boolean saveCrmBiddingPlatformWarehousing(CrmBiddingPlatformWarehousingSaveParam copy);

   Boolean updateCrmBiddingPlatformWarehousing(CrmBiddingPlatformWarehousingUpdateParam copy);

   CrmBiddingPlatformWarehousingDetailDTO crmBiddingPlatformWarehousingDetail(Long id);

   Boolean downLoadCrmBiddingPlatformWarehousingDetail(Long id, HttpServletResponse response);

   HashMap<String, Integer> getCrmBiddingPlatformTaskSum();

   Boolean overruleTask(Long id);

   Boolean caLocked(CaLockedParam caLockedParam);
}
