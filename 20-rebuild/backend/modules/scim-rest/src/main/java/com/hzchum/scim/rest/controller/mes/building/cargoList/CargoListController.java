package com.hzchum.scim.rest.controller.mes.building.cargoList;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.contract.core.api.enums.ProjectContentNoEnum;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListShipEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListShipDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.MesBuildingCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListLogisticsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListPriceChangeDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListReceiptDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListReviewDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListShipDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListReceiptUpdateDTOParam;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES发运-装车")
@RestController
@RequestMapping("/api/mes/building/cargo")
public class CargoListController {
   private static final Logger log = LoggerFactory.getLogger(CargoListController.class);
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;

   @ApiOperation("发运记录-列表")
   @GetMapping("/ship")
   @PreAuthorize("@permission.check('mes_ship:get')")
   public ResultVO<PageVO<CargoListShipDTO>> ship(CargoListShipDTOParam param) {
      log.info("API 调用 ：发运记录-列表");
      return ResultBuilder.success(this.cargoListBiz.pageShip(param));
   }

   @ApiOperation("当年/当月发运记录汇总")
   @GetMapping("/yearAndMonth/summary")
   public ResultVO cargoListMeteSummary(
      LocalDateTime dateTime,
      Long projectId,
      Integer projectType,
      @RequestParam(required = false) LocalDateTime auditStartDate,
      @RequestParam(required = false) LocalDateTime auditEndDate
   ) {
      log.info("API 调用 ：查询发运记录汇总");
      return ResultBuilder.success(this.cargoListBiz.cargoListMeteSummary(dateTime, projectId, projectType, auditStartDate, auditEndDate));
   }

   @ApiOperation("发运记录-详情")
   @GetMapping("/ship/{id}")
   @PreAuthorize("@permission.check('mes_ship:detail')")
   public ResultVO getShipList(@PathVariable Long id) {
      log.info("API 调用 ：发运记录-详情");
      return ResultBuilder.success(this.cargoListBiz.getShipDetail(id));
   }

   @ApiOperation("下载发运按日或月汇总")
   @GetMapping("/day_or_month/summary/print")
   public ResultVO printShipDayOrMonthSummary(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate,
      @RequestParam Integer type
   ) {
      log.info("API 调用 ：下载发运按日或月汇总");
      return ResultBuilder.success(this.cargoListBiz.printShipDayOrMonthSummary(projectId, startDate, endDate, type));
   }

   @ApiOperation("发运记录-发运量汇总")
   @GetMapping("/ship/summary")
   public ResultVO getShipMeteByCondition(CargoListShipDTOParam requestVO) {
      log.info("API 调用 ：发运记录-发运量汇总");
      return ResultBuilder.success(this.cargoListBiz.getShipMeteByCondition(requestVO));
   }

   @ApiOperation("发运记录-列表打印")
   @GetMapping("/ship/print")
   @PreAuthorize("@permission.check('mes_ship:print')")
   public ResultVO printShip(CargoListShipDTOParam param) {
      log.info("API 调用 ：发运记录-列表打印");
      return ResultBuilder.success(this.cargoListBiz.printShip(param));
   }

   @ApiOperation("发运记录-详情打印")
   @GetMapping("/ship/{id}/print")
   @PreAuthorize("@permission.check('mes_ship:detailPrint')")
   public ResultVO printShipDetail(@PathVariable Long id) {
      log.info("API 调用 ：发运记录-详情打印");
      return ResultBuilder.success(this.cargoListBiz.printShipDetail(id));
   }

   @ApiOperation("收货状态-列表")
   @GetMapping("/receipt")
   @PreAuthorize("@permission.check('mes_receipt_status:get')")
   public ResultVO receipt(CargoListReceiptDTOParam param) {
      log.info("API 调用 ：收货状态-列表");
      return ResultBuilder.success(this.cargoListBiz.pageReceipt(param));
   }

   @ApiOperation("收货状态-详情")
   @GetMapping("/receipt/{id}")
   @PreAuthorize("@permission.check('mes_receipt_status:detail')")
   public ResultVO getReceipt(@PathVariable Long id) {
      log.info("API 调用 ：收货状态-详情");
      return ResultBuilder.success(this.cargoListBiz.getShipDetail(id));
   }

   @ApiOperation("收货状态-列表打印")
   @GetMapping("/receipt/print")
   @PreAuthorize("@permission.check('mes_receipt_status:print')")
   public ResultVO printReceipt(CargoListReceiptDTOParam param) {
      log.info("API 调用 ：收货状态-列表打印");
      return ResultBuilder.success(this.cargoListBiz.printReceipt(param));
   }

   @ApiOperation("收货状态-详情打印")
   @GetMapping("/receipt/{id}/print")
   @PreAuthorize("@permission.check('mes_receipt_status:detailPrint')")
   public ResultVO printReceiptDetail(@PathVariable Long id) {
      log.info("API 调用 ：收货状态-详情打印");
      return ResultBuilder.success(this.cargoListBiz.printShipDetail(id));
   }

   @ApiOperation("物流详情-列表")
   @GetMapping("/logistics")
   @PreAuthorize("@permission.check('mes_logistics:get')")
   public ResultVO logistics(CargoListLogisticsDTOParam param) {
      log.info("API 调用 ：物流详情-列表");
      return ResultBuilder.success(this.cargoListBiz.pageLogistics(param));
   }

   @ApiOperation("物流详情-列表修改")
   @PutMapping("/{id}/change")
   @PreAuthorize("@permission.check('mes_logistics:edit')")
   public ResultVO cargoListPriceChange(@RequestBody CargoListPriceChangeDTOParam param) {
      log.info("API 调用 ：物流详情-列表修改");
      return ResultBuilder.success(this.cargoListBiz.cargoListPriceChange(param));
   }

   @ApiOperation("物流详情-修改详情")
   @GetMapping("/{id}/change/log")
   public ResultVO cargoListPriceChangeLog(@PathVariable(name = "id") Long id) {
      log.info("API 调用 ：物流详情-列表");
      return ResultBuilder.success(this.cargoListBiz.cargoListPriceChangeLog(id));
   }

   @ApiOperation("打印收货汇总")
   @GetMapping("/logistics/print")
   @PreAuthorize("@permission.check('mes_logistics:print')")
   public ResultVO printLogistics(CargoListLogisticsDTOParam param) {
      log.info("API 调用 ：打印收货汇总");
      return ResultBuilder.success(this.cargoListBiz.printLogistics(param));
   }

   @ApiOperation("发运审核-列表")
   @GetMapping("/review")
   @PreAuthorize("@permission.check('mes_ship_audit:get')")
   public ResultVO review(CargoListReviewDTOParam param) {
      log.info("API 调用 ：发运审核-列表");
      return ResultBuilder.success(this.cargoListBiz.pageReview(param));
   }

   @ApiOperation("打印-发运审核")
   @GetMapping("/review/print")
   @PreAuthorize("@permission.check('mes_ship_audit:print')")
   public ResultVO printReview(CargoListReviewDTOParam param) {
      log.info("API 调用 ：打印-发运审核");
      return ResultBuilder.success(this.cargoListBiz.printReview(param));
   }

   @ApiOperation("发运审核-详情")
   @GetMapping("/review/{id}")
   @PreAuthorize("@permission.check('mes_ship_audit:detail')")
   public ResultVO reviewDetail(@PathVariable Long id) {
      log.info("API 调用 ：发运审核-详情");
      return ResultBuilder.success(this.cargoListBiz.reviewDetailV2(id));
   }

   @ApiOperation("发运审核-详情-下载")
   @GetMapping("/review/{id}/download")
   @PreAuthorize("@permission.check('mes_ship_audit:download')")
   public ResultVO reviewDetailDownload(@PathVariable(name = "id") Long id, HttpServletResponse response) {
      log.info("API 调用 ：发运审核-详情");
      return ResultBuilder.success(this.cargoListBiz.reviewDetailDownloadV2(id, response));
   }

   @ApiOperation("发运审核-详情-打印")
   @GetMapping("/review/{id}/print")
   public ResultVO reviewDetailPrint(@PathVariable Long id) {
      log.info("API 调用 ：打印发运审核-详情");
      return ResultBuilder.success(this.cargoListBiz.reviewDetailPrint(id));
   }

   @ApiOperation("发运审核-审核")
   @PutMapping("/review")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   @PreAuthorize("@permission.check('mes_ship_audit:audit')")
   public ResultVO review(@RequestBody @Valid CheckDTOParam param) {
      log.info("API 调用 ： 发运审核-审核");
      return ResultBuilder.success(this.cargoListBiz.review(param));
   }

   @ApiOperation("取消收货")
   @PutMapping("/cancel")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#param.id", message = "该发运车次正在操作中,请稍后刷新重试")
   @PreAuthorize("@permission.check('mes_receipt_status:cancelDelivery')")
   public ResultVO cancelReceiving(@RequestBody @Valid CargoListReceiptUpdateDTOParam param) {
      log.info("API 调用 ：取消收货");
      return ResultBuilder.success(this.cargoListBiz.cancelReceiving(param));
   }

   @ApiOperation("到场签收")
   @PutMapping("/sign/{id}")
   @SignerCheck(constantKey = "MesBuildingCargoList", lockKey = "#id", message = "该发运车次正在操作中,请稍后刷新重试")
   public ResultVO signIn(@PathVariable Long id, @RequestParam(required = false) Long attachmentId) {
      log.info("API 调用 ：到场签收");
      return ResultBuilder.success(this.cargoListBiz.signIn(id, attachmentId));
   }

   @ApiOperation("查询项目发运信息-构件")
   @GetMapping("/project/summary")
   public ResultVO projectCargoListMeteSummary(CargoListStatisticsQueryParam param) {
      log.info("API 调用 ：查询项目构件发运信息");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListMeteSummaryV2(param));
   }

   @ApiOperation("查询项目发运信息-围护")
   @GetMapping("/project/enclosure/summary")
   public ResultVO projectCargoListEnclosureProjectSummary(CargoListStatisticsQueryParam param) {
      log.info("API 调用 ：查询项目发运信息-围护");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListEnclosureProjectSummaryV2(param));
   }

   @ApiOperation("查询项目发运信息-分页")
   @GetMapping("/project/summary/page")
   public ResultVO projectCargoListMeteSummaryPage(
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Integer sendStatus,
      @RequestParam(required = false) Boolean settled,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) String projectName,
      @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer projectStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：查询项目发运信息-分页");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectCargoListMeteSummaryPage(
               dateTime,
               sendStatus,
               settled,
               workshopId,
               projectName,
               productionLineTypeEnum,
               projectType,
               lumpSumSystemType,
               projectStatus,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("查询项目发运信息(围护)-分页")
   @GetMapping("/project/enclosure/summary/page")
   public ResultVO projectCargoListEnclosureSummaryPage(
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Integer sendStatus,
      @RequestParam(required = false) Boolean settled,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) String projectName,
      @RequestParam(required = false) Integer projectStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：查询项目发运信息(围护)-分页");
      return ResultBuilder.success(
         this.cargoListBiz.projectCargoListEnclosureSummaryPage(dateTime, sendStatus, settled, workshopId, projectName, projectStatus, pageNumber, pageSize)
      );
   }

   @ApiOperation("(构件)查询指定项目发运数据汇总")
   @GetMapping("/project/detail/summary")
   public ResultVO<ProjectCargoListSumDetailDTO> projectDetailSummary(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime
   ) {
      log.info("API 调用 ：(构件)查询指定项目发运数据汇总");
      return ResultBuilder.success(this.cargoListBiz.projectDetailSummary(projectId, monomerId, areaId, workshopId, dateTime));
   }

   @ApiOperation("(构件-直发件)查询指定项目发运数据汇总")
   @GetMapping("/project/detail/directShipment/summary")
   public ResultVO directShipmentProjectDetailSummary(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime
   ) {
      log.info("API 调用 ：(构件-直发件)查询指定项目发运数据汇总");
      return ResultBuilder.success(this.cargoListBiz.directShipmentProjectDetailSummary(projectId, monomerId, areaId, workshopId, dateTime));
   }

   @ApiOperation("查询指定项目发运数据汇总-围护")
   @GetMapping("/project/detail/enclosure/summary")
   public ResultVO projectEnclosureDetailSummary(
      @RequestParam Long projectId,
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime
   ) {
      log.info("API 调用 ：查询指定项目发运数据汇总-围护");
      return ResultBuilder.success(this.cargoListBiz.projectEnclosureDetailSummary(projectId, category, enclosurePlanId, workshopId, dateTime));
   }

   @ApiOperation("(构件)发运统计-查询项目各类数据详情")
   @GetMapping("/project/detail/type")
   public ResultVO projectDetailType(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：(构件)发运统计-查询项目各类数据详情");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectDetailType(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, pageNumber, pageSize)
      );
   }

   @ApiOperation("(构件-直发件)发运统计-查询项目各类数据详情")
   @GetMapping("/project/detail/directShipment/type")
   public ResultVO directShipmentProjectDetailType(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：(构件-直发件)发运统计-查询项目各类数据详情");
      return ResultBuilder.success(
         this.cargoListBiz
            .directShipmentProjectDetailType(
               projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("发运统计-查询项目各类数据详情-围护")
   @GetMapping("/project/enclosure/detail/type")
   public ResultVO projectEnclosureDetailType(
      @RequestParam Long projectId,
      @RequestParam(required = false) Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：发运统计-查询项目各类数据详情-围护");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectEnclosureDetailType(
               projectId, category, enclosurePlanId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("(构件)发运统计-打印项目各类数据详情")
   @GetMapping("/project/detail/type/print")
   public ResultVO projectDetailTypePrint(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      @RequestParam(required = false) Integer weightStatus,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：(构件)发运统计-打印项目各类数据详情");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectDetailTypePrint(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, weightStatus, response)
      );
   }

   @ApiOperation("(构件-直发件)发运统计-打印项目各类数据详情")
   @GetMapping("/project/detail/directShipment/type/print")
   public ResultVO directShipmentProjectDetailTypePrint(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：(构件-直发件)发运统计-打印项目各类数据详情");
      return ResultBuilder.success(
         this.cargoListBiz
            .directShipmentProjectDetailTypePrint(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, response)
      );
   }

   @ApiOperation("发运统计-打印项目各类数据详情(围护)")
   @GetMapping("/project/enclosure/detail/type/print")
   public ResultVO projectEnclosureDetailTypePrint(
      @RequestParam Long projectId,
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：发运统计-打印项目各类数据详情(围护)");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectEnclosureDetailTypePrint(
               projectId, category, enclosurePlanId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, response
            )
      );
   }

   @ApiOperation("发运统计-下载项目各类数据详情")
   @GetMapping("/project/detail/type/down")
   public void projectDetailTypeDown(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Integer productSourceType,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam @EnumValidator(value = CargoListShipEnum.class, message = "查询类型不存在!!") Integer shipEnumType,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：发运统计-下载项目各类数据详情");
      this.cargoListBiz.projectDetailTypeDown(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, shipEnumType, response);
   }

   @ApiOperation("当年发运信息")
   @GetMapping("/year/summary")
   public ResultVO getYearCargoListMeteSummary(
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum,
      @RequestParam(required = false, defaultValue = "1") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("API 调用 ：查询项目发运信息");
      return ResultBuilder.success(
         this.cargoListBiz.getYearCargoListMeteSummary(dateTime, workshopId, productionLineTypeEnum, projectType, lumpSumSystemType, projectStatus)
      );
   }

   @ApiOperation("围护当年发运汇总")
   @GetMapping("/year/enclosure/summary")
   public ResultVO getYearCargoListEnclosureSummary(
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false, defaultValue = "8") Integer projectType,
      @RequestParam(required = false, defaultValue = "25") Integer lumpSumSystemType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("API 调用 ：查询围护发运汇总");
      return ResultBuilder.success(this.cargoListBiz.getYearCargoListEnclosureSummary(dateTime, workshopId, projectType, lumpSumSystemType, projectStatus));
   }

   @ApiOperation("查询项目发运详情")
   @GetMapping("/project/cargoList/details")
   @PreAuthorize("@permission.check('mes_ship_summary:get')")
   public ResultVO projectCargoListMeteDetail(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum
   ) {
      log.info("API 调用 ：查询项目发运详情");
      return ResultBuilder.success(
         this.cargoListBiz.projectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, null, productionLineTypeEnum, null, null)
      );
   }

   @ApiOperation("查询项目发运详情-围护")
   @GetMapping("/project/cargoList/enclosure/details")
   public ResultVO projectCargoListEnclosureDetail(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) Long workshopId
   ) {
      log.info("API 调用 ：查询项目发运详情-围护");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListEnclosureDetail(projectId, category, enclosurePlanId, workshopId, null));
   }

   @ApiOperation("查询项目发运详情-配套件")
   @GetMapping("/project/cargoList/auxiliary/details")
   public ResultVO projectCargoListAuxiliaryDetail(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      @RequestParam(required = false) Integer relationType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("API 调用 ：查询项目发运详情-配套件");
      return ResultBuilder.success(
         this.cargoListBiz.projectCargoListAuxiliaryDetail(projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType, projectStatus)
      );
   }

   @ApiOperation("(构件)查询项目发运详情-分页")
   @GetMapping("/project/cargoList/details/page")
   @PreAuthorize("@permission.check('mes_ship_summary:get')")
   public ResultVO projectCargoListMeteDetailPage(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：(构件)查询项目发运详情-分页");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectCargoListMeteDetailPage(projectId, monomerId, areaId, workshopId, productionLineTypeEnum, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("（构件-直发件）查询项目发运详情-分页")
   @GetMapping("/project/cargoList/directShipment/details/page")
   @PreAuthorize("@permission.check('mes_ship_summary:get')")
   public ResultVO directShipmentProjectCargoListMeteDetailPage(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：（构件-直发件）查询项目发运详情-分页");
      return ResultBuilder.success(
         this.cargoListBiz
            .directShipmentProjectCargoListMeteDetailPage(
               projectId, monomerId, areaId, workshopId, productionLineTypeEnum, startDate, endDate, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("查询项目发运详情(围护)-分页")
   @GetMapping("/project/cargoList/enclosure/details/page")
   public ResultVO projectCargoListEnclosureDetailPage(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：查询项目发运详情(围护)-分页");
      return ResultBuilder.success(
         this.cargoListBiz.projectCargoListEnclosureDetailPage(projectId, category, enclosurePlanId, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("查询项目发运详情(配套件)-分页")
   @GetMapping("/project/cargoList/auxiliary/details/page")
   @PreAuthorize("@permission.check('aux_ship_summary:get')")
   public ResultVO projectCargoListAuxiliaryDetailPage(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      @RequestParam(required = false) Integer relationType,
      @RequestParam(required = false) Integer projectStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：查询项目发运详情(配套件)-分页");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectCargoListAuxiliaryDetailPage(
               projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType, projectStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("查询项目发运详情(配套件)-汇总")
   @GetMapping("/project/cargoList/auxiliary/details/sum")
   public ResultVO projectCargoListAuxiliaryDetailSum(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Integer relationType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("API 调用 ：查询项目发运详情(配套件)-汇总");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListAuxiliaryDetailSum(projectId, monomerId, areaId, relationType, projectStatus));
   }

   @ApiOperation("(构件)打印项目发运详情")
   @GetMapping("/project/cargoList/details/print")
   @PreAuthorize("@permission.check('mes_ship_summary:print')")
   public ResultVO projectCargoListMeteDetailPrint(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate
   ) {
      log.info("API 调用 ：(构件)打印项目发运详情");
      return ResultBuilder.success(
         this.cargoListBiz.projectCargoListMeteDetailPrint(projectId, monomerId, areaId, workshopId, productionLineTypeEnum, startDate, endDate)
      );
   }

   @ApiOperation("(构件-直发件)打印项目发运详情")
   @GetMapping("/project/cargoList/directShipment/details/print")
   @PreAuthorize("@permission.check('mes_ship_summary:print')")
   public ResultVO directShipmentProjectCargoListMeteDetailPrint(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Long workshopId,
      @RequestParam(required = false) @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误") Integer productionLineTypeEnum,
      @RequestParam(required = false) LocalDateTime startDate,
      @RequestParam(required = false) LocalDateTime endDate
   ) {
      log.info("API 调用 ：(构件-直发件)打印项目发运详情");
      return ResultBuilder.success(
         this.cargoListBiz.directShipmentProjectCargoListMeteDetailPrint(projectId, monomerId, areaId, workshopId, productionLineTypeEnum, startDate, endDate)
      );
   }

   @ApiOperation("打印项目发运详情(围护)")
   @GetMapping("/project/cargoList/details/enclosure/print")
   public ResultVO projectCargoListEnclosureDetailPrint(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) @EnumValidator(value = ProjectContentNoEnum.class, message = "围护类型不存在") Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) Long workshopId
   ) {
      log.info("API 调用 ：打印项目发运详情(围护)");
      return ResultBuilder.success(this.cargoListBiz.projectCargoListEnclosureDetailPrint(projectId, category, enclosurePlanId, workshopId));
   }

   @ApiOperation("打印项目发运详情(配套件)")
   @GetMapping("/project/cargoList/details/auxiliary/print")
   public ResultVO projectCargoListAuxiliaryDetailPrint(
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam(required = false) Integer category,
      @RequestParam(required = false) Long enclosurePlanId,
      @RequestParam(required = false) String serialNumber,
      @RequestParam Integer relationType,
      @RequestParam(required = false) Integer projectStatus
   ) {
      log.info("API 调用 ：打印项目发运详(配套件)");
      return ResultBuilder.success(
         this.cargoListBiz
            .projectCargoListAuxiliaryDetailPrint(projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType, projectStatus)
      );
   }

   @ApiOperation("获取查询项目发运记录")
   @GetMapping("/shipment/list/{id}")
   public ResultVO<List<MesBuildingCargoListDTO>> shipmentByProject(@PathVariable Long id) {
      log.info("API 调用 ： 获取查询项目发运记录");
      return ResultBuilder.success(this.cargoListBiz.shipmentByProject(id));
   }

   @ApiOperation("获取查询项目发运记录")
   @GetMapping("/shipment/list/page")
   public ResultVO shipmentByProjectPage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ： 获取查询项目发运记录");
      return ResultBuilder.success(this.cargoListBiz.shipmentByProjectPage(projectId, pageNumber, pageSize));
   }

   @ApiOperation("打印:获取查询项目发运记录")
   @GetMapping("/shipment/list/print/{id}")
   public ResultVO shipmentByProjectPrint(@PathVariable Long id) {
      log.info("API 调用 ： 打印:获取查询项目发运记录");
      return ResultBuilder.success(this.cargoListBiz.shipmentByProjectPrint(id));
   }

   @ApiOperation("获取查询项目发运记录汇总信息")
   @GetMapping("/shipment/summary/{id}")
   public ResultVO<Map> shipmentSummary(@PathVariable Long id) {
      log.info("API 调用 ： 获取查询项目发运记录");
      return ResultBuilder.success(this.cargoListBiz.shipmentSummary(id));
   }
}
