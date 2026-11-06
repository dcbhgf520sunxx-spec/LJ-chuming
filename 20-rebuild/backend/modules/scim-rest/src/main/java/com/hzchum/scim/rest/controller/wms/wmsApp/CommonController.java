package com.hzchum.scim.rest.controller.wms.wmsApp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ApproveObjectTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.CommonIdNameDTO;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.TaxRateService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-App通用接口")
@RestController
@RequestMapping("/api/app/wms/")
public class CommonController {
   private static final Logger log = LoggerFactory.getLogger(CommonController.class);
   @Resource
   WmsAppService service;
   @Resource
   TaxRateService taxRateService;
   @Resource
   WarningService warningService;
   @Resource
   DepartmentService departmentService;
   @Resource
   JobService jobService;
   @Resource
   UserService userService;

   @ApiOperation("获取全部待操作数")
   @GetMapping("/pending-quantity")
   public ResultVO getQuantity() {
      log.info("API 调用 ：获取全部待操作数");
      return ResultBuilder.success(this.service.getQuantity());
   }

   @ApiOperation("获取简单税率")
   @GetMapping("/config/material/tax-rate/all/brief")
   @PreAuthorize("@permission.check('logisticsManager','bridgeLogisticsManager')")
   public ResultVO getTaxRateBrief() {
      log.info("API 调用 ：获取简单税率");
      return ResultBuilder.success(this.taxRateService.getTaxRateBrief());
   }

   @ApiOperation("获取预警列表")
   @GetMapping("/material/inventory/reminder")
   @PreAuthorize("@permission.check('materialStockWarning')")
   public ResultVO list() {
      log.info("API 调用 ：获取预警列表");
      return ResultBuilder.success(this.warningService.getReminder());
   }

   @ApiOperation("根据所传类型获取不同的数据 1部门 2岗位 3个人 4公司")
   @GetMapping("/getDeptJobUser/{objType}")
   public ResultVO getDeptJobUser(@PathVariable("objType") Integer objType) {
      log.info("API 调用 ：根据所传类型获取不同的数据 1部门 2岗位 3个人 4公司");
      List<CommonIdNameDTO> commonIdNameDTOS = new ArrayList<>();
      if (objType.equals(ApproveObjectTypeEnum.DEPARTMENT.getType())) {
         List<Department> list = this.departmentService.list();
         if (CollectionUtils.isNotEmpty(list)) {
            commonIdNameDTOS = BeanUtil.copyToList(list, CommonIdNameDTO.class);
         }
      }

      if (objType.equals(ApproveObjectTypeEnum.JOB.getType())) {
         List<Job> list = this.jobService.list();
         if (CollectionUtils.isNotEmpty(list)) {
            commonIdNameDTOS = BeanUtil.copyToList(list, CommonIdNameDTO.class);
         }
      }

      if (objType.equals(ApproveObjectTypeEnum.PERSON.getType())) {
         List<User> list = this.userService.list();
         if (CollectionUtils.isNotEmpty(list)) {
            commonIdNameDTOS = BeanUtil.copyToList(list, CommonIdNameDTO.class);
         }
      }

      return ResultBuilder.success(commonIdNameDTOS);
   }
}
