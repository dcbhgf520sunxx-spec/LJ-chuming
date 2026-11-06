package com.hzchum.scim.rest.controller.mes.building.cargoList;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.OldCheckStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.common.core.api.pojo.dto.OldCheckDTOParam;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.AppShipTimeDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.AppCargoListDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.AppShipDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListCheckDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListLogisticsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListWeighSMSDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.AppEmptyCarsWeighingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListLogisticsUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListUpdateConcertDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES发运-装车")
@RestController
@RequestMapping("/api/app/mes/building/cargo")
public class AppCargoListController {
   private static final Logger log = LoggerFactory.getLogger(AppCargoListController.class);
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Autowired
   private MesBuildingCargoListService mesBuildingCargoListService;

   @ApiOperation("获取发运清单列表")
   @GetMapping
   public ResultVO pageAppCargoList(AppCargoListDTOParam param) {
      log.info("API 调用 ：获取发运清单列表");
      return ResultBuilder.success(this.cargoListBiz.pageAppCargoList(param));
   }

   @ApiOperation("获取发运清单详情")
   @GetMapping("{id}")
   public ResultVO getCargoListListDetail(@PathVariable Long id) {
      log.info("API 调用 ：获取发运清单详情");
      return ResultBuilder.success(this.cargoListBiz.getDetailById(id));
   }

   @ApiOperation("获取构件未发运的直发件列表")
   @GetMapping("/directly")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "id", paramType = "发运id"), @ApiImplicitParam(name = "productId", value = "productId", paramType = "构件产品id")}
   )
   public ResultVO getDirectlyNoCartList(@RequestParam Long id, @RequestParam(required = false) Long productId) {
      log.info("API 调用 ：获取构件未发运的直发件列表");
      return ResultBuilder.success(this.cargoListBiz.getDirectlyNoCartList(id, productId));
   }

   @ApiOperation("获取车牌和司机信息(非地磅)")
   @ApiImplicitParam(name = "licensePlate", value = "车牌信息(模糊查询)", paramType = "query")
   @GetMapping("/driver")
   public ResultVO getDriverCargoList(@RequestParam(required = false) String licensePlate) {
      log.info("API 调用 ：获取车牌的司机信息");
      return ResultBuilder.success(this.mesBuildingCargoListService.getDriverCargoList(licensePlate));
   }

   @ApiOperation("获取空车列表")
   @GetMapping("/empty")
   public ResultVO getEmptyCargoList() {
      log.info("API 调用 ：获取空车列表");
      return ResultBuilder.success(this.mesBuildingCargoListService.getEmptyCargoList());
   }

   @ApiOperation("新增空车过磅信息)")
   @PostMapping("/empty")
   @SignerCheck(lockKey = "#param.licensePlate", message = "该车牌正在新增中,请勿重复提交!")
   public ResultVO saveEmptyCargoList(@Validated(Add.class) @RequestBody AppEmptyCarsWeighingDTOParam param) {
      log.info("API 调用 ：新增空车过磅信息)");
      return ResultBuilder.success(this.mesBuildingCargoListService.saveEmptyCargoList(param));
   }

   @ApiOperation("修改空车过磅信息)")
   @PutMapping("/empty")
   @PreAuthorize("@permission.check('vehicleWeighting','stockLoading')")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   public ResultVO updateEmptyCargoList(@Validated(Update.class) @RequestBody AppEmptyCarsWeighingDTOParam param) {
      log.info("API 调用 ：修改空车过磅信息)");
      return ResultBuilder.success(this.mesBuildingCargoListService.updateEmptyCargoList(param));
   }

   @ApiOperation("修改发运(装车时调用)")
   @PutMapping("")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   public ResultVO updateCargoList(@RequestBody @Valid CargoListUpdateDTOParam param) {
      log.info("API 调用 ：修改发运(装车时调用)");
      return ResultBuilder.success(this.cargoListBiz.updateCargoList(param));
   }

   @ApiOperation("修改发运(装车时调用(单个办理)")
   @PutMapping("concert")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   public ResultVO updateConcertCargoList(@RequestBody @Valid CargoListUpdateConcertDTOParam param) {
      log.info("API 调用 ：修改发运(装车时调用(单个办理)");
      return ResultBuilder.success(this.cargoListBiz.updateConcertCargoList(param));
   }

   @ApiOperation("修改物流信息(过磅时调用)")
   @PutMapping("logistics")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   @PreAuthorize("@permission.check('logisticsManager')")
   public ResultVO updateCargoListLogistics(@RequestBody CargoListLogisticsUpdateDTOParam param) {
      log.info("API 调用 ：修改物流信息(过磅时调用)");
      return ResultBuilder.success(this.cargoListBiz.updateCargoListLogistics(param));
   }

   @ApiOperation("删除发运")
   @DeleteMapping
   public ResultVO deleteByIds(@RequestBody IdsVoRequest ids) {
      log.info("API 调用 ：删除发运");
      return ResultBuilder.success(this.cargoListBiz.deleteByIds(ids.getIds()));
   }

   @ApiOperation("货物过磅")
   @PostMapping("/weigh/check")
   @PreAuthorize("@permission.check('vehicleWeighting')")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#requestVO.id", message = "该发运车次正在操作中,请稍后刷新重试")
   public ResultVO checkCargoList(@Valid @RequestBody CargoListCheckDTOParam requestVO) {
      log.info("API 调用 ：货物过磅");
      return ResultBuilder.success(this.cargoListBiz.checkCargoList(requestVO));
   }

   @ApiOperation("发送过磅短信")
   @PostMapping("/weigh/send/sms")
   @PreAuthorize("@permission.check('vehicleWeighting')")
   public ResultVO checkCargoList(@Valid @RequestBody CargoListWeighSMSDTOParam requestVO) {
      log.info("API 调用 ：发送过磅短信");
      return ResultBuilder.success(this.cargoListBiz.sendWeighSms(requestVO));
   }

   @ApiOperation("过磅复核短信验证码验证")
   @PostMapping("/weigh/check/sms")
   @PreAuthorize("@permission.check('vehicleWeighting')")
   public ResultVO checkCaptcha(@RequestParam Long id, @RequestParam String verifyCode) {
      log.info("API 调用 ：过磅复核短信验证码验证");
      return ResultBuilder.success(this.cargoListBiz.checkCaptcha(id, verifyCode));
   }

   @ApiOperation("获取审核信息")
   @GetMapping("/audit/{id}")
   @PreAuthorize("@permission.check('stockOutReview')")
   public ResultVO getAuditInfo(@PathVariable Long id) {
      log.info("API 调用 ： 获取审核信息");
      return ResultBuilder.success(this.cargoListBiz.getAuditInfoV2(id));
   }

   @ApiOperation("发运清单审核")
   @PutMapping("/audit")
   @PreAuthorize("@permission.check('stockOutReview')")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   public ResultVO review(@RequestBody @Valid OldCheckDTOParam param) {
      log.info("API 调用 ： 发运清单审核");
      CheckDTOParam dto = new CheckDTOParam();
      dto.setId(param.getId());
      if (param.getStatus().equals(OldCheckStatusEnum.PENDING.getType())) {
         dto.setStatus(CheckStatusEnum.PENDING.getType());
      } else if (param.getStatus().equals(OldCheckStatusEnum.PASS.getType())) {
         dto.setStatus(CheckStatusEnum.PASS.getType());
      } else {
         dto.setStatus(CheckStatusEnum.FAIL.getType());
      }

      return ResultBuilder.success(this.cargoListBiz.review(dto));
   }

   @ApiOperation("发运记录-项目汇总")
   @GetMapping("/shipment/summary")
   public ResultVO pageShipmentSummary(@Valid AppShipTimeDOParam param) {
      log.info("API 调用 ：发运记录-构件");
      return ResultBuilder.success(this.cargoListProductLinkService.sumShipmentGroupByProject(param));
   }

   @ApiOperation("发运记录-构件")
   @GetMapping("/shipment/artifact")
   public ResultVO pageArtifactShipment(AppShipDTOParam param) {
      log.info("API 调用 ：发运记录-构件");
      return ResultBuilder.success(this.cargoListProductLinkService.pageArtifactShipment(param));
   }

   @ApiOperation("发运记录-围护")
   @GetMapping("/shipment/enclosure")
   public ResultVO pageEnclosureShipment(AppShipDTOParam param) {
      log.info("API 调用 ：发运记录-围护");
      return ResultBuilder.success(this.cargoListProductLinkService.pageEnclosureShipment(param));
   }

   @ApiOperation("物流详情-列表")
   @GetMapping("/logistics")
   @PreAuthorize("@permission.check('logisticsManager')")
   public ResultVO logistics(CargoListLogisticsDTOParam param) {
      log.info("API 调用 ：物流详情-列表");
      return ResultBuilder.success(this.cargoListBiz.listLogistics(param));
   }
}
