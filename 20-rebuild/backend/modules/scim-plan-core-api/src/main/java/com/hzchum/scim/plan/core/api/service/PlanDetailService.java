package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailTraceDTO;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;

public interface PlanDetailService extends IService<PlanDetail> {
   Boolean setCompleteDate(@NotNull Long areaId, @NotNull Integer planDetailType, @NotNull LocalDate date);

   PlanDetailTraceDTO getMaxMInDate(Long monomerId, Integer areaProductType, Long areaId, Integer planType);

   List<PlanDetailResponseDTO> listDetailByConditions(Long projectId, Long monomerId, Integer areaProductType, Integer type);

   List<PlanDetailTraceDTO> listDetailTrace(Long monomerId, Integer areaProductType);
}
