package com.hzchum.scim.rest.controller.mes.building._package;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.ProductPackageDOParam;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request._package.MesBuildingPackageAddVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request._package.MesBuildingPackageSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request._package.MesBuildingPackageUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES发运-打包")
@RestController
@RequestMapping("/api/mes/building/package")
public class PackageController {
   private static final Logger log = LoggerFactory.getLogger(PackageController.class);
   @Resource
   private MesBuildingPackageBiz packageBiz;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseRecordService;

   @ApiOperation("分页获取打包列表")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('mes_pack:get')")
   public ResultVO getPackageListPage(MesBuildingPackageDOParam param) {
      log.info("API 调用 ：分页获取打包列表");
      return ResultBuilder.success(this.packageBiz.packagePage(param));
   }

   @ApiOperation("获取打包详情")
   @GetMapping("/{id}")
   public ResultVO getDetailsById(@PathVariable Long id) {
      log.info("API 调用 ：获取打包详情");
      return ResultBuilder.success(this.packageBiz.getDetailById(id));
   }

   @ApiOperation("打印打包清单详情")
   @GetMapping("/{id}/print")
   public ResultVO printPackListById(@PathVariable Long id) {
      log.info("API 调用 ：打印打包清单详情");
      return ResultBuilder.success(this.packageBiz.printDetailById(id));
   }

   @ApiOperation("新增打包")
   @SignerCheck(lockKey = "#request.projectId", message = "该项目正在打包中，请稍后刷新重试")
   @PostMapping
   public ResultVO savePackageList(@RequestBody @Valid MesBuildingPackageSaveVORequest request) {
      log.info("API 调用 ：新增打包");
      return ResultBuilder.success(this.packageBiz.savePackage(request.setBoolApp(false)));
   }

   @ApiOperation("追加打包")
   @SignerCheck(lockKey = "#request.id", message = "该包单正在追加打包中，请稍后刷新重试")
   @PutMapping("/add")
   public ResultVO addPackage(@RequestBody @Valid MesBuildingPackageAddVORequest request) {
      log.info("API 调用 ：追加打包");
      return ResultBuilder.success(this.packageBiz.addPackage(request));
   }

   @ApiOperation("修改打包")
   @PutMapping("")
   @PreAuthorize("@permission.check('mes_manual_pack:pack')")
   @SignerCheck(lockKey = "#request.id", message = "该包单正在修改中，请稍后刷新重试")
   public ResultVO updatePackage(@RequestBody @Valid MesBuildingPackageUpdateVORequest request) {
      log.info("API 调用 ：修改打包");
      return ResultBuilder.success(this.packageBiz.updatePackage(request));
   }

   @ApiOperation("删除包")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('mes_pack:del')")
   public ResultVO updatePackage(@RequestBody @Valid IdsVoRequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：删除包");
      return ResultBuilder.success(this.packageBiz.deletePackage(voRequest.getIds()));
   }

   @ApiOperation("获取构件可打包使用列表")
   @GetMapping("/artifact/use")
   public ResultVO getArtifactPackageList(ProductPackageDOParam request) {
      log.info("API 调用 ：获取构件可打包列表");
      return ResultBuilder.success(this.warehouseRecordService.listArtifactPackageByCondition(request));
   }

   @ApiOperation("获取直发件可打包列表")
   @GetMapping("/part/use")
   public ResultVO getPartPackageList(ProductPackageDOParam request) {
      log.info("API 调用 ：获取直发件可打包列表");
      return ResultBuilder.success(this.warehouseRecordService.listPartPackageByCondition(request));
   }

   @ApiOperation("分页查询围护可打包使用列表")
   @GetMapping("/enclosure/use")
   public ResultVO getEnclosurePackageList(ProductPackageDOParam param) {
      log.info("API 调用 ：分页查询围护可打包使用列表");
      return ResultBuilder.success(new PageVO<>(this.warehouseRecordService.listEnclosurePackageByCondition(param)));
   }

   @ApiOperation("获取配套件可打包使用列表")
   @GetMapping("/auxiliary_material/use")
   public ResultVO listTechStandardPartPackageByCondition(ProductPackageDOParam param) {
      log.info("API 调用 ：获取配套件可打包列表");
      return ResultBuilder.success(this.warehouseRecordService.listTechStandardPartPackageByCondition(param));
   }
}
