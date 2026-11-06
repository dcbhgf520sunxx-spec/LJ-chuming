package com.hzchum.scim.rest.runner.mes;

import cn.hutool.core.collection.CollUtil;
import com.hzchum.scim.system.core.api.pojo.dto.PartDrawingLayerSettingDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Order(555)
@Component
public class PartNestingRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(PartNestingRunner.class);
   @Resource
   private ConfigService configService;

   @Override
   public void run(String... args) throws Exception {
      log.info("PartNestingRunner-START");
      StopWatch pnrStopWatch = new StopWatch();
      pnrStopWatch.start();
      List<PartDrawingLayerSettingDTO> partDrawingLayerSettingDTOList = this.configService
         .getPartDrawingLayerSetting()
         .stream()
         .filter(i -> i.getObjectType() == null)
         .peek(i -> i.setObjectType(0))
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(partDrawingLayerSettingDTOList)) {
         this.configService.editPartDrawingLayerSetting(partDrawingLayerSettingDTOList);
      }

      pnrStopWatch.stop();
      log.info("PartNestingRunner-FINISH(耗时: " + pnrStopWatch.getTotalTimeMillis() + "毫秒)");
   }
}
