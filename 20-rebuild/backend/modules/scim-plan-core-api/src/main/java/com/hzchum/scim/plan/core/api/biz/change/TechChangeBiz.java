package com.hzchum.scim.plan.core.api.biz.change;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactInfoChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ChangeDetailDO;

public interface TechChangeBiz {
   PageVO listChange(Integer page, Integer size);

   ChangeDetailDO getChange(Long id);

   Boolean changeArtifactInfo(ArtifactInfoChangeDTOParam param);
}
