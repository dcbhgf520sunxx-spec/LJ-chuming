package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppEquipmentDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassBindEquipmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassCodeScanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppWeldListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppEquipmentVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassRecordVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppWeldVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "计划管理 - CAPP APP焊接工艺作工")
@RequestMapping("api/plan/app/CappCraftProductTask")
public class CappCraftProductTaskAppApi {
   private static final Logger log = LoggerFactory.getLogger(CappCraftProductTaskAppApi.class);
   @Resource
   private TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;

   @ApiOperation("app焊接任务产品列表")
   @GetMapping("/product/list")
   public ResultVO<PageVO<CappCraftCardProductAppVO>> productList(CappCraftCardProductAppListDTO dto) {
      log.info("API调用:app焊接任务产品列表");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productList(dto));
   }

   @ApiOperation("app根据产品id获取码号列表")
   @GetMapping("/product/code/number/list")
   public ResultVO<List<CappCraftCardProductAppCodeNumberVO>> productCodeNumberList(CappCraftCardProductAppCodeNumberListDTO dto) {
      log.info("API调用:app根据产品id获取码号列表");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productCodeNumberList(dto));
   }

   @ApiOperation("app根据产品码号id获取焊缝任务列表")
   @GetMapping("/product/weld/list")
   public ResultVO<List<CappCraftCardProductAppWeldVO>> prductWeldList(CappCraftCardProductAppWeldListDTO dto) {
      log.info("API调用:app根据产品码号id获取焊缝任务列表");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productWeldList(dto));
   }

   @ApiOperation("app根据产品焊缝id获取焊道任务列表")
   @GetMapping("/product/pass/list")
   public ResultVO<List<CappCraftCardProductAppPassVO>> prductPassList(CappCraftCardProductAppPassListDTO dto) {
      log.info("API调用:app根据产品焊缝id获取焊道任务列表");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassList(dto));
   }

   @ApiOperation("app根据设备id获取设备详情")
   @GetMapping("/product/equipment/detail")
   public ResultVO<CappCraftCardProductAppEquipmentVO> productEquipmentDetail(CappCraftCardProductAppEquipmentDetailDTO dto) {
      log.info("API调用:app根据设备id获取设备详情");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productEquipmentDetail(dto));
   }

   @ApiOperation("app焊道任务设备绑定")
   @PostMapping("/product/pass/bind/equipment")
   public ResultVO<Boolean> productPassBindEquipment(@RequestBody CappCraftCardProductAppPassBindEquipmentDTO dto) {
      log.info("API调用:app焊道任务设备绑定");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassBindEquipment(dto));
   }

   @ApiOperation("app产品任务扫码")
   @GetMapping("/product/pass/code/scan")
   public ResultVO<CappCraftCardProductAppVO> productPassCodeScan(CappCraftCardProductAppPassCodeScanDTO dto) {
      log.info("API调用:app产品任务扫码");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassCodeScan(dto));
   }

   @ApiOperation("app开始焊接")
   @PostMapping("/product/pass/start")
   public ResultVO<Boolean> productPassStart(@RequestBody CappCraftCardProductAppPassDTO dto) {
      log.info("API调用:app开始焊接");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassStart(dto.getId()));
   }

   @ApiOperation("app获取焊接电流电压数据")
   @GetMapping("/product/pass/record")
   public ResultVO<CappCraftCardProductAppPassRecordVO> productPassRecord(CappCraftCardProductAppPassDTO dto) {
      log.info("API调用:app获取焊接电流电压数据");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassRecord(dto.getId()));
   }

   @ApiOperation("app暂停焊接")
   @PostMapping("/product/pass/stop")
   public ResultVO<Boolean> productPassStop(@RequestBody CappCraftCardProductAppPassDTO dto) {
      log.info("API调用:app暂停焊接");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassStop(dto.getId()));
   }

   @ApiOperation("app焊接完成")
   @PostMapping("/product/pass/complete")
   public ResultVO<Boolean> productPassComplete(@RequestBody CappCraftCardProductAppPassDTO dto) {
      log.info("API调用:app焊接完成");
      return ResultBuilder.success(this.techCappCraftProductTaskBiz.productPassComplete(dto.getId()));
   }
}
