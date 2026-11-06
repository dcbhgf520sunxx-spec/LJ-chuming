package com.hzchum.scim.rest.runner.wms;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(999)
@Component
public class MoveOutboundTheoryWeightInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MoveOutboundTheoryWeightInitRunner.class);
   @Resource
   private MoveOutboundDetailService outboundDetailService;

   @Override
   public void run(String... args) throws Exception {
      List<MoveOutboundDetail> details = this.outboundDetailService
         .list(
            Wrappers.lambdaQuery(MoveOutboundDetail.class)
               .eq(MoveOutboundDetail::getBasicClass, BasicClassEnum.STEEL_PLATE.getType())
               .isNull(MoveOutboundDetail::getActualTheoryWeight)
               .in(
                  MoveOutboundDetail::getOutboundTypeSelection,
                  Arrays.asList(OutboundTypeEnum.PRODUCTION_USE.getType(), OutboundTypeEnum.SCHEDULING_OUTBOUND.getType())
               )
         );
      if (CollectionUtils.isNotEmpty(details)) {
         details.forEach(e -> e.setActualTheoryWeight(e.getMete()));
         this.outboundDetailService.updateBatchById(details);
      }
   }

   public MoveOutboundTheoryWeightInitRunner(final MoveOutboundDetailService outboundDetailService) {
      this.outboundDetailService = outboundDetailService;
   }
}
