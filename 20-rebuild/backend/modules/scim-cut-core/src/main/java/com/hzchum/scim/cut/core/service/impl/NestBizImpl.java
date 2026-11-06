package com.hzchum.scim.cut.core.service.impl;

import com.hzchum.scim.cut.core.api.biz.NestBiz;
import com.hzchum.scim.cut.core.api.service.WmsNestMaterialService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NestBizImpl implements NestBiz {
   private static final Logger log = LoggerFactory.getLogger(NestBizImpl.class);
   @Resource
   WmsNestMaterialService wmsNestMaterialService;

   @Override
   public Boolean generateSurplus(List<String> guids) {
      this.wmsNestMaterialService.generateSurplus(guids);
      return true;
   }

   @Override
   public Boolean passed(String childGuid) {
      return this.wmsNestMaterialService.passed(childGuid);
   }

   @Override
   public Boolean deleteNesting(String guid) {
      return this.wmsNestMaterialService.deleteNesting(guid);
   }

   @Override
   public Boolean deleteNestingByChildGuid(String ChildGuid) {
      return this.wmsNestMaterialService.deleteNestingByChildGuid(ChildGuid);
   }
}
