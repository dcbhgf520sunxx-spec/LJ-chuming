package com.hzchum.scim.rest.controller.mes.building.config;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import com.hzchum.scim.system.core.api.pojo.request.MesProcessConversionRateDTO;
import com.hzchum.scim.system.core.api.service.MesProcessConversionRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/mes_process_conversion_rate")
@Api(tags = "工序折合完工率")
public class MesProcessConversionRateController {
   private static final Logger log = LoggerFactory.getLogger(MesProcessConversionRateController.class);
   @Autowired
   private MesProcessConversionRateService mesProcessConversionRateService;

   @GetMapping("/page")
   @PreAuthorize("@permission.check('conversion_rate_config:get')")
   @ApiOperation("工序折合完工率分页查询")
   public ResultVO page(@RequestParam Long artifactClassId) {
      List<MesProcessConversionRate> list = this.mesProcessConversionRateService
         .list((Wrapper<MesProcessConversionRate>)new LambdaQueryWrapper<MesProcessConversionRate>().eq(MesProcessConversionRate::getArtifactClassId, artifactClassId));
      return ResultBuilder.success(list);
   }

   @GetMapping("/listAll")
   @PreAuthorize("@permission.check('conversion_rate_config:get')")
   @ApiOperation("工序折合完工率分页查询")
   public ResultVO listAllMesProcessConversionRate(@RequestParam Long artifactClassId) {
      return ResultBuilder.success(this.mesProcessConversionRateService.listAllMesProcessConversionRate(artifactClassId));
   }

   @PostMapping("/add")
   @PreAuthorize("@permission.check('conversion_rate_config:add')")
   @ApiOperation("保存")
   public ResultVO saveMesProcessConversionRate(@RequestBody @Valid MesProcessConversionRateDTO mesProcessConversionRateDTO) {
      log.info("保存工序折合完工率：mesProcessConversionRateDTO:{}", mesProcessConversionRateDTO);
      return ResultBuilder.success(this.mesProcessConversionRateService.saveMesProcessConversionRate(mesProcessConversionRateDTO));
   }

   @PutMapping("/update")
   @PreAuthorize("@permission.check('conversion_rate_config:edit')")
   @ApiOperation("修改")
   public ResultVO update(@RequestBody @Valid MesProcessConversionRate mesProcessConversionRate) {
      log.info("修改工序折合完工率：mesProcessConversionRate:{}", mesProcessConversionRate);
      return ResultBuilder.success(this.mesProcessConversionRateService.updateMesProcessConversionRate(mesProcessConversionRate));
   }

   @DeleteMapping("/delete")
   @PreAuthorize("@permission.check('conversion_rate_config:del')")
   @ApiOperation("删除")
   public ResultVO delete(@RequestBody List<Long> idList) {
      log.info("删除工序折合完工率：idList:{}", idList);
      this.mesProcessConversionRateService.removeMesProcessConversionRate(idList);
      return ResultBuilder.success("删除成功");
   }

   public MesProcessConversionRateController(final MesProcessConversionRateService mesProcessConversionRateService) {
      this.mesProcessConversionRateService = mesProcessConversionRateService;
   }
}
