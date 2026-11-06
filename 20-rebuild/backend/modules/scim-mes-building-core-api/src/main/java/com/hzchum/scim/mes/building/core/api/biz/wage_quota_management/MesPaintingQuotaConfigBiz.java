package com.hzchum.scim.mes.building.core.api.biz.wage_quota_management;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesPaintingQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesPaintingQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesPaintingQuotaConfigParam;
import java.util.List;

public interface MesPaintingQuotaConfigBiz extends IBiz<MesPaintingQuotaConfig> {
   PageVO<MesPaintingQuotaConfigDTO> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesPaintingQuotaConfigDTO> listInfo();

   Boolean addInfo(MesPaintingQuotaConfigParam param);

   Boolean updateInfo(MesPaintingQuotaConfigParam param);

   Boolean deleteById(Long id);
}
