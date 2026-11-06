package com.hzchum.scim.mes.building.core.service.impl.craft;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraftDetail;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintingCraftDetailService;
import com.hzchum.scim.mes.building.core.mapper.craft.MesPaintingCraftDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class MesPaintingCraftDetailServiceImpl
   extends ServiceImpl<MesPaintingCraftDetailMapper, MesPaintingCraftDetail>
   implements MesPaintingCraftDetailService {
}
