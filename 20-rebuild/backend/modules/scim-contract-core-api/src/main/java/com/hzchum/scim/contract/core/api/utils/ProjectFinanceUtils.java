package com.hzchum.scim.contract.core.api.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public interface ProjectFinanceUtils {
   Boolean getBoolTwoLevelUnit();

   Boolean getBoolMakeVersion();

   Boolean getBoolProjectVersion();

   Boolean getBoolManyFactory();

   Boolean checkVersion();

   Map<Long, BigDecimal> getProjectFirstLevelUnitCost(Collection<Long> projectIds);

   String getAddress(Long countryId, Long provinceId, Long cityId, Long regionId, String joint);
}
