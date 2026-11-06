package com.hzchum.scim.rest.controller.cut.lantek;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.service.NestCutPlateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "切割兰特")
@RestController
@RequestMapping("/api/nesting")
public class NestingController {
   private static final Logger log = LoggerFactory.getLogger(NestingController.class);
   @Resource
   private NestCutPlateService nestCutPlateService;

   @ApiOperation("接收钢板信息报告")
   @PostMapping("/setPlantReport")
   public ResultVO setPlateReport(@RequestBody String plateReport) {
      return this.nestCutPlateService.getPlateReport(plateReport);
   }

   @ApiOperation("上传零件")
   @GetMapping("/uploadJobPart/{id}")
   public ResultVO uploadJobPart(Long id) {
      ArrayList<Long> list = new ArrayList<>();
      list.add(id);
      return this.nestCutPlateService.uploadJobPart(list);
   }

   @ApiOperation("上传任务")
   @GetMapping("/uploadJob/{id}")
   public ResultVO uploadJob(Long id) {
      ArrayList<Long> list = new ArrayList<>();
      list.add(id);
      return this.nestCutPlateService.uploadJob(list);
   }

   @ApiOperation("解锁排样图")
   @GetMapping("/updateNestsStates/{ncCode}")
   public ResultVO updateNestsStates(String ncCode) {
      return this.nestCutPlateService.updateNestsStates(ncCode);
   }

   @ApiOperation("扫码上报")
   @GetMapping("/getPlatePartList")
   @ApiImplicitParam(name = "barcode", value = "条形码内容", required = true, dataType = "String")
   public ResultVO getPlatePartList(String barcode) {
      return this.nestCutPlateService.getPlatePartList(barcode);
   }
}
