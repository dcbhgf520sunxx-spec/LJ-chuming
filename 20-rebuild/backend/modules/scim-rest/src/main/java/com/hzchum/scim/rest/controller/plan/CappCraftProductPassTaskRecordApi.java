package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskRecordBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldCountDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardBimVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCurrentVoltageVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingGatherVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingVO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "计划管理 - CAPP 焊接工艺产品任务记录")
@RequestMapping("api/plan/CappCraftProductPassTaskRecord")
public class CappCraftProductPassTaskRecordApi {
   private static final Logger log = LoggerFactory.getLogger(CappCraftProductPassTaskRecordApi.class);
   @Resource
   private TechCappCraftProductPassTaskRecordBiz techCappCraftProductPassTaskRecordBiz;

   @ApiOperation("焊接工艺产品焊缝数量")
   @GetMapping("/product/weld/count")
   public ResultVO<Integer> productWeldCount(CappCraftCardProductWeldCountDTO dto) {
      log.info("API调用:焊接工艺产品焊缝数量");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.productWeldCount(dto));
   }

   @ApiOperation("焊接工艺bim产品焊缝列表")
   @GetMapping("/product/bim/list")
   public ResultVO<CappCraftCardBimVO> productBimList(CappCraftCardProductListDTO dto) {
      log.info("API调用:焊接工艺bim产品焊缝列表");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.productBimList(dto));
   }

   @ApiOperation("焊接工艺产品列表")
   @GetMapping("/product/list")
   public ResultVO<List<CappCraftCardProductVO>> productList(CappCraftCardProductListDTO dto) {
      log.info("API调用:焊接工艺产品列表");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.productList(dto));
   }

   @ApiOperation("焊接工艺产品码号列表")
   @GetMapping("/product/code/number/list")
   public ResultVO<List<CappCraftCardProductCodeNumberVO>> productCodeNumberList(CappCraftCardProductCodeNumberListDTO dto) {
      log.info("API调用:焊接工艺焊缝列表");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.productCodeNumberList(dto));
   }

   @ApiOperation("焊接工艺焊缝列表")
   @GetMapping("/welding/list")
   public ResultVO<List<CappCraftCardWeldingVO>> weldingList(CappCraftCardWeldingListDTO dto) {
      log.info("API调用:焊接工艺焊缝列表");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.weldingList(dto));
   }

   @ApiOperation("焊接工艺道次电流电压信息")
   @GetMapping("/product/current/voltage")
   public ResultVO<List<CappCraftCardProductCurrentVoltageVO>> productCurrentVoltageList(@RequestParam Long passId) {
      log.info("API调用:焊接工艺道次电流电压信息");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.productCurrentVoltageList(passId));
   }

   @ApiOperation("焊接数据采集记录列表")
   @GetMapping("/welding/gather/list")
   public ResultVO<PageVO<CappCraftCardWeldingGatherVO>> weldingGatherList(CappCraftCardWeldingGatherListDTO dto) {
      log.info("API调用:焊接数据采集记录列表");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.weldingGatherList(dto));
   }

   @ApiOperation("焊接数据采集记录详情")
   @GetMapping("/welding/gather/detail")
   public ResultVO<List<CappCraftCardProductCurrentVoltageVO>> weldingGatherDetail(CappCraftCardWeldingGatherDetailDTO dto) {
      log.info("API调用:焊接数据采集记录详情");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.weldingGatherDetail(dto));
   }

   @ApiOperation("焊接数据采集记录修改")
   @PostMapping("/welding/gather/update")
   public ResultVO<Boolean> weldingGatherUpdate(@RequestBody List<CappCraftCardWeldingGatherUpdateDTO> dto) {
      log.info("API调用:焊接数据采集记录修改");
      return ResultBuilder.success(this.techCappCraftProductPassTaskRecordBiz.weldingGatherUpdate(dto));
   }
}
