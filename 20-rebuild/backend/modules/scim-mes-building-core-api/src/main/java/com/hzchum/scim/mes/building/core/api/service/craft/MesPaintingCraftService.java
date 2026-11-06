package com.hzchum.scim.mes.building.core.api.service.craft;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dtoParam.ApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintingCraftDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import java.util.List;

public interface MesPaintingCraftService extends IService<MesPaintingCraft> {
   List<MesPaintingCraftDTO> listInfo(MesPaintingCraftQuery query);

   Boolean add(MesPaintingCraftParam param);

   Boolean edit(MesPaintingCraftParam param);

   Boolean approval(ApprovalParam param);

   Boolean cancelApproval(Long id);

   Boolean invalid(Long id);

   MesPaintingCraftDTO detailById(Long id, Boolean boolApprovalQuery);
}
