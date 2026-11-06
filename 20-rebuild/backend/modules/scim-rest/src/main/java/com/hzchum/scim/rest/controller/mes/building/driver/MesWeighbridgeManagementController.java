package com.hzchum.scim.rest.controller.mes.building.driver;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import com.hzchum.scim.mes.building.core.api.pojo._dto.device.MesWeighbridgeManagementDTO;
import com.hzchum.scim.mes.building.core.api.service.MesWeighbridgeManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "地磅配置")
@RestController
@RequestMapping("/weighbridge")
public class MesWeighbridgeManagementController {
   private static final Logger log = LoggerFactory.getLogger(MesWeighbridgeManagementController.class);
   @Autowired
   private MesWeighbridgeManagementService weighbridgeService;

   @ApiOperation("新增地磅配置")
   @PostMapping("/save")
   public ResultVO create(@RequestBody MesWeighbridgeManagementDTO dto) {
      log.info("API 调用 ：新增地磅配置");
      return ResultBuilder.success(this.weighbridgeService.saveConfig(dto));
   }

   @ApiOperation("删除地磅配置")
   @DeleteMapping("/{id}")
   public ResultVO delete(@PathVariable Long id) {
      log.info("API 调用 ：删除地磅配置");
      return ResultBuilder.success(this.weighbridgeService.removeById(id));
   }

   @ApiOperation("修改地磅配置")
   @PutMapping("/update")
   public ResultVO update(@RequestBody MesWeighbridgeManagement dto) {
      log.info("API 调用 ：修改地磅配置");
      return ResultBuilder.success(this.weighbridgeService.updateConfig(dto));
   }

   @ApiOperation("修改状态-地磅配置")
   @PutMapping("status")
   public ResultVO updateStatus(@RequestParam("id") Long id, @RequestParam("status") Boolean status) {
      log.info("API 调用 ：修改状态");
      return ResultBuilder.success(this.weighbridgeService.updateStatus(id, status));
   }

   @ApiOperation("根据ID查询地磅详情")
   @GetMapping("/{id}")
   public ResultVO getById(@PathVariable Long id) {
      log.info("API 调用 ：根据ID查询地磅详情");
      return ResultBuilder.success(this.weighbridgeService.getById(id));
   }

   @ApiOperation("分页查询地磅配置")
   @GetMapping("/page")
   public ResultVO page(
      @RequestParam(defaultValue = "1") int pageNum,
      @RequestParam(defaultValue = "10") int pageSize,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String status
   ) {
      log.info("API 调用 ：分页查询地磅配置");
      return ResultBuilder.success(this.weighbridgeService.pageList(name, status, pageNum, pageSize));
   }
}
