package com.hzchum.scim.business.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessArtifactDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactFindVOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactMergeAreaDTOParam;
import java.util.List;
import java.util.Map;

public interface BusinessArtifactBiz {
   PageVO<BusinessArtifactDTO> listByCondition(ArtifactFindVOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListByCondition(ArtifactFindVOParam param);

   List<BusinessArtifactDTO> listMergeArea(ArtifactMergeAreaDTOParam param);

   Boolean mergeArtifactArea(ArtifactMergeAreaDTOParam param);
}
