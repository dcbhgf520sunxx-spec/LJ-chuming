package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechAuxiliaryPartQueryDTOParam;
import java.util.List;
import java.util.Map;

public interface TechAuxiliaryPartBiz extends IBiz<TechAuxiliaryPart> {
   PageVO<TechAuxiliaryPartDTO> listAuxiliaryPart(TechAuxiliaryPartQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> printListAuxiliaryPart(TechAuxiliaryPartQueryDTOParam param);

   ListVO<TechAuxiliaryPartSummaryDTO> listSummary(Long projectId, Long monomerId, Long areaId);

   PrintVO<List<Map<String, Object>>> printListSummary(Long projectId, Long monomerId, Long areaId);
}
