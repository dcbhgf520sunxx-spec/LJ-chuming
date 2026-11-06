package com.hzchum.scim.rest.controller.mes.building._package;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request._package.MesBuildingPackageAddVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request._package.MesBuildingPackageSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request._package.MesBuildingPackageUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES发运-打包")
@RestController
@RequestMapping("/api/app/mes/building/package")
public class AppPackageController {
   private static final Logger log = LoggerFactory.getLogger(AppPackageController.class);
   @Autowired
   private MesBuildingPackageBiz packageBiz;

   @ApiOperation("获取打包详情")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('stockLoading','pack')")
   public ResultVO getDetailsById(@PathVariable Long id) {
      log.info("API 调用 ：获取打包详情");
      return ResultBuilder.success(this.packageBiz.getDetailById(id));
   }

   @ApiOperation("获取项目下所有打包详情")
   @GetMapping("/project")
   public ResultVO getDetailByProjectId(@RequestParam Long projectId, Integer productType) {
      log.info("API 调用 ：获取项目下所有打包详情");
      return ResultBuilder.success(this.packageBiz.getDetailByProjectId(projectId, productType));
   }

   @ApiOperation("分页获取打包列表")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('pack')")
   public ResultVO getPackageListPage(MesBuildingPackageDOParam request) {
      log.info("API 调用 ：分页获取打包列表");
      return ResultBuilder.success(this.packageBiz.packagePage(request));
   }

   @ApiOperation("包信息")
   @GetMapping("/info/{id}")
   public ResultVO getPackageInfo(@PathVariable Long id) {
      log.info("API 调用 ：包信息");
      return ResultBuilder.success(this.packageBiz.getPackageInfo(id));
   }

   @ApiOperation("新增打包")
   @PostMapping
   @SignerCheck(lockKey = "#request.projectId", message = "该项目正在打包中，请稍后刷新重试")
   public ResultVO savePackageList(@RequestBody @Valid MesBuildingPackageSaveVORequest request) {
      log.info("API 调用 ：新增打包");
      return ResultBuilder.success(this.packageBiz.savePackage(request.setBoolApp(true)));
   }

   @ApiOperation("追加打包")
   @PutMapping("/add")
   @SignerCheck(lockKey = "#request.id", message = "该包单正在追加打包中，请稍后刷新重试")
   public ResultVO addPackage(@RequestBody MesBuildingPackageAddVORequest request) {
      log.info("API 调用 ：追加打包");
      return ResultBuilder.success(this.packageBiz.addPackage(request));
   }

   @ApiOperation("修改打包")
   @PutMapping("")
   @SignerCheck(lockKey = "#request.id", message = "该包单正在修改中，请稍后刷新重试")
   public ResultVO updatePackage(@RequestBody @Valid MesBuildingPackageUpdateVORequest request) {
      log.info("API 调用 ：修改打包");
      return ResultBuilder.success(this.packageBiz.updatePackage(request));
   }

   @ApiOperation("删除包")
   @DeleteMapping("")
   public ResultVO updatePackage(@RequestBody IdsVoRequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：删除包");
      return ResultBuilder.success(this.packageBiz.deletePackage(voRequest.getIds()));
   }
}
