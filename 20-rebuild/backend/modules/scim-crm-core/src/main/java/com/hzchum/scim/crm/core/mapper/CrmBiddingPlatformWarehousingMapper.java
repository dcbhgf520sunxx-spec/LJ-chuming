package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBiddingPlatformWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmBiddingPlatformWarehousingMapper extends BaseMapper<CrmBiddingPlatformWarehousing> {
   List<CrmBiddingPlatformWarehousingPageDTO> getCrmBiddingPlatformWarehousingPage(
      @Param("crmCheckStatusEnum") Integer crmCheckStatusEnum,
      @Param("checkRecord") Integer checkRecord,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("countryId") Long countryId,
      @Param("provinceId") Long provinceId,
      @Param("cityId") Long cityId,
      @Param("regionId") Long regionId,
      @Param("unitPropertyAllocationConfigId") Long unitPropertyAllocationConfigId,
      @Param("unitClassConfigurationId") Long unitClassConfigurationId,
      @Param("industryConfigurationId") Long industryConfigurationId,
      @Param("unitReputationAllocationConfigId") Long unitReputationAllocationConfigId,
      @Param("biddingPlatformName") String biddingPlatformName,
      @Param("informantUserName") String informantUserName
   );
}
