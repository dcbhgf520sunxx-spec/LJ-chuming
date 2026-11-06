package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineTypeLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineTypeLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureProductionLineTypeLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureProductionLineTypeLinkServiceImpl
   extends ServiceImpl<MesEnclosureProductionLineTypeLinkMapper, MesEnclosureProductionLineTypeLink>
   implements MesEnclosureProductionLineTypeLinkService {
   public List<MesEnclosureProductionLineTypeLink> findTypeLinkByProductionLineId(Long ProductionLineId) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesEnclosureProductionLineTypeLink.class).eq(MesEnclosureProductionLineTypeLink::getProductionLineId, ProductionLineId)
         );
   }
}
