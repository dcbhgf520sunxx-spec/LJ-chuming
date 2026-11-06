package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnology;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyArtifactQueryParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologySaveParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyUpdateParam;
import java.util.List;

public interface TechPaintTechnologyBiz extends IBiz<TechPaintTechnology> {
   PageVO<TechPaintTechnologyArtifactDTO> getUnPaintTechnologyArtifactList(TechPaintTechnologyArtifactQueryParam param, Integer pageNumber, Integer pageSize);

   PageVO<TechPaintTechnologyProjectGroupDTO> pageList(TechPaintTechnologyQueryParam param, Integer pageNumber, Integer pageSize);

   PageVO<TechPaintTechnologyArtifactDTO> getPaintTechnologyArtifactList(TechPaintTechnologyArtifactQueryParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<TechPaintTechnologyArtifactDTO>> printPaintTechnologyArtifactList(Long paintTechnologyId);

   List<TechPaintTechnologyDTO> getProjectPaintTechnologyList(Long projectId);

   Boolean savePaintTechnology(TechPaintTechnologySaveParam param);

   Boolean updatePaintTechnology(TechPaintTechnologyUpdateParam param);

   Boolean removePaintTechnology(Long id);
}
