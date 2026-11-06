package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChange;
import com.hzchum.scim.plan.core.api.pojo.dto.change.EnclosureChangeExamineDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.EnclosureQuantityChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.vo.change.EnclosureChangeVo;
import com.hzchum.scim.plan.core.api.pojo.voParam.EnclosureChangeVoParam;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface TechEnclosureChangeService extends IService<TechEnclosureChange> {
   Boolean changeEnclosure(EnclosureQuantityChangeDTOParam param);

   Boolean handleChange(EnclosureChangeExamineDTO examineDTO);

   List<EnclosureChangeVo> findAllEnclosureList(EnclosureChangeVoParam voParam, Integer pageNumber, Integer pageSize);

   @Transactional(rollbackFor = Exception.class)
   Boolean deleteEnclosureTask(Long orderId, List<Long> taskIds);
}
