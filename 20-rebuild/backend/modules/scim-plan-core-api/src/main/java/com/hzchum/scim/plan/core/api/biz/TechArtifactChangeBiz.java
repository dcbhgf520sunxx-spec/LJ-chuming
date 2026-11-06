package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactQuantityChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactChangeQueryDtoParam;
import javax.servlet.http.HttpServletResponse;

public interface TechArtifactChangeBiz extends IBiz<TechArtifactChange> {
   PageVO<TechArtifactChangeDTO> pageList(TechArtifactChangeQueryDtoParam param, Integer pageNumber, Integer pageSize);

   PageVO<TechArtifactChangeDTO> warehousingList(TechArtifactChangeQueryDtoParam param, Integer pageNumber, Integer pageSize);

   Boolean changeArtifactQuantity(ArtifactQuantityChangeDTOParam param);

   void warehousingListChangeDownload(HttpServletResponse response, TechArtifactChangeQueryDtoParam param, Integer pageNumber, Integer pageSize);
}
