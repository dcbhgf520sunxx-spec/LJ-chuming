package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailCreateDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailQureyDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailUpdateDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanTechDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureTechQureyDto;
import java.util.List;

public interface EnclosurePlanBiz {
   ResultVO<PageVO<EnclosurePlanDetailDto>> findAll(EnclosurePlanDetailQureyDto dto);

   ResultVO<List<EnclosurePlanTechDto>> findByProjectId(Long projectId);

   ResultVO addEnclosurePlan(EnclosurePlanDetailCreateDto dto);

   ResultVO<PageVO<EnclosurePlan>> findBytechId(EnclosureTechQureyDto dto, Integer pageNumber, Integer pageSize);

   ResultVO deleteById(Long id);

   ResultVO modifyById(EnclosurePlanDetailUpdateDto dto);

   ResultVO<List<EnclosurePlan>> findAllPlan(Long id);
}
