package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmWinningContractWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRemainderCanEstablishProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParamV2;
import com.hzchum.scim.rest.pojo.vo.crm.CrmWinningContractWarehousingSaveVOV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
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

@Api(tags = "crm-商务中心-中标项目管理")
@RestController
@RequestMapping("/api/app/crm/winning/contract/warehousing")
public class AppCrmWinningContractWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(AppCrmWinningContractWarehousingController.class);
   @Resource
   private CrmWinningContractWarehousingBiz crmWinningContractWarehousingBiz;

   @ApiOperation("app-剩余可立项项目备案列表")
   @GetMapping("")
   public ResultVO<List<CrmRemainderCanEstablishProjectInfoDTO>> getRemainderCanEstablishProjectInfo(Long id) {
      log.info("API调用:app-剩余可立项项目备案列表");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getRemainderCanEstablishProjectInfo(id));
   }

   @ApiOperation("app-剩余可立项项目备案详情")
   @GetMapping("/project/detail")
   public ResultVO getRemainderCanEstablishProjectDetail(@RequestParam Long id) {
      log.info("API调用:app-剩余可立项项目备案详情");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getRemainderCanEstablishProjectDetail(id));
   }

   @ApiOperation("app-中标项目新增(中南定制)")
   @PostMapping("/save/contract/custom")
   public ResultVO saveCrmWinningContractWarehousingCustom(@RequestBody CrmWinningContractWarehousingSaveVOV2 crmWinningContractWarehousingSaveVOV2) {
      log.info("API调用:app-中标项目新增(中南定制)");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .saveCrmWinningContractWarehousingCustom(BeanUtil.copy(crmWinningContractWarehousingSaveVOV2, CrmWinningContractWarehousingSaveParamV2.class))
      );
   }

   @ApiOperation("app-中标管理项目汇总")
   @GetMapping("/contract/summary")
   public ResultVO getContractSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum
   ) {
      log.info("API调用:app-中标管理项目汇总");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .getContractSummary(startDate, endDate, projectName, serialNumber, crmEnterpriseWarehousingName, crmProjectScheduleTypeEnum)
      );
   }

   @ApiOperation("app-中标管理项目列表")
   @GetMapping("/contract/list")
   public ResultVO<PageVO<CrmWinningContractWarehousingPageDTO>> getContractList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum,
      String condition,
      @RequestParam(required = false) List<Integer> tenderRequirements,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:app-中标管理项目列表");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .getContractList(
               startDate,
               endDate,
               projectName,
               serialNumber,
               crmEnterpriseWarehousingName,
               crmProjectScheduleTypeEnum,
               condition,
               tenderRequirements,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("app-中标项目详情")
   @GetMapping("/detail")
   public ResultVO<CrmWinningContractWarehousingDetailDTO> getContractDetail(@RequestParam("id") Long id) {
      log.info("API调用:app-中标项目详情");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getContractDetail(id));
   }
}
