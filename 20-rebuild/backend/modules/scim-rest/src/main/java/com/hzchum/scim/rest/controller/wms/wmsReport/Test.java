package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.cut.core.api.service.WmsNestMaterialService;
import com.hzchum.scim.wms.core.api.biz.MaterialScheduleBiz;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-测试")
@RestController
@RequestMapping("/api/wms/report/test")
public class Test {
   private static final Logger log = LoggerFactory.getLogger(Test.class);
   @Resource
   ReportService reportService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   MaterialScheduleBiz materialScheduleBiz;
   @Resource
   WmsNestMaterialService wmsNestMaterialService;

   @ApiOperation("测试加权")
   @GetMapping("/calculateAveragePrice")
   public void detailList(@RequestParam(required = false) List<LocalDateTime> dateTimeList) {
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      MonthTimeRange monthTimeRange = new MonthTimeRange();
      monthTimeRange.setStartTime(dateTimeList.get(0));
      monthTimeRange.setEndTime(dateTimeList.get(1));
      this.materialScheduleBiz.calculateAveragePrice(monthTimeRange, weightedPriceConf);
      this.materialScheduleBiz.virtualOutbound();
   }

   @ApiOperation("测试制成品")
   @GetMapping("/testManufactured")
   public void detailList(LocalDateTime dateTime) {
      this.materialScheduleBiz.manufacturedStatistics(dateTime);
   }

   @ApiOperation("切割上报")
   @GetMapping("/testOutbound")
   public void detailList(String Guid) {
      this.wmsNestMaterialService.testOutbound(Guid);
   }
}
