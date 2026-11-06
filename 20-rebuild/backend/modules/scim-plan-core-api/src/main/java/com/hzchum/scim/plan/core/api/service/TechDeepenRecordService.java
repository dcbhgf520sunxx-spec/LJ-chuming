package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordMonthDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserMonthDTO;
import javax.validation.constraints.NotNull;

public interface TechDeepenRecordService extends IService<TechDeepenRecord> {
   ListVO<DeepenRecordMonthDTO> listDeepenMeteByYear(@NotNull Integer year);

   ListVO<DeepenRecordProjectDTO> listProjectDeepenMete(Integer year, Integer month);

   ListVO<DeepenRecordUserDTO> listUserDeepenMete(Integer year);

   ListVO<DeepenRecordUserMonthDTO> listUserMonthMete(Integer year, Integer month);

   ListVO<DeepenRecordProjectDTO> listProjectDeepen(Integer year);

   Boolean deleteDeepenRecord(Integer productType, Long productId);

   TechDeepenRecord getByProductTypeProductId(Integer productType, Long productId);

   TechDeepenRecord buildDeepenRecord(TechArtifact artifact, Integer importQuantity);
}
