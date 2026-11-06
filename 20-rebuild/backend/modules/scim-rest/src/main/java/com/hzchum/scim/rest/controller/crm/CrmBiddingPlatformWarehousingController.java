package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmBiddingPlatformWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmBiddingPlatformWarehousingUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmBiddingPlatformWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmBiddingPlatformWarehousingUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-办事大厅-招标平台注册")
@RestController
@RequestMapping("/api/crm/bidding/platform/warehousing")
public class CrmBiddingPlatformWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(CrmBiddingPlatformWarehousingController.class);
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;

   @ApiOperation("招标备案新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_registry_record:addTask')")
   public ResultVO saveCrmBiddingPlatformWarehousing(@RequestBody CrmBiddingPlatformWarehousingSaveVO crmBiddingPlatformWarehousingSaveVO) {
      log.info("API调用:招标备案新增");
      return ResultBuilder.success(
         this.crmBiddingPlatformWarehousingBiz
            .saveCrmBiddingPlatformWarehousing(BeanUtil.copy(crmBiddingPlatformWarehousingSaveVO, CrmBiddingPlatformWarehousingSaveParam.class))
      );
   }

   @ApiOperation("招标备案修改")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('crm_registry_record:addTask','crm_sign_list:save')")
   public ResultVO updateCrmBiddingPlatformWarehousing(@RequestBody CrmBiddingPlatformWarehousingUpdateVO crmBiddingPlatformWarehousingUpdateVO) {
      log.info("API调用:招标备案修改");
      return ResultBuilder.success(
         this.crmBiddingPlatformWarehousingBiz
            .updateCrmBiddingPlatformWarehousing(BeanUtil.copy(crmBiddingPlatformWarehousingUpdateVO, CrmBiddingPlatformWarehousingUpdateParam.class))
      );
   }

   @ApiOperation("招标备案删除")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_registry_record:del')")
   public ResultVO deleteCrmBiddingPlatformWarehousing(Long id) {
      log.info("API调用:招标备案删除");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.deleteCrmBiddingPlatformWarehousing(id));
   }

   @ApiOperation("招标备案汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('crm_registry_record:get','crm_sign_list:get')")
   public ResultVO summary(Integer checkRecord) {
      log.info("API调用:招标备案汇总");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.summary(checkRecord));
   }

   @ApiOperation("招标备案列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_registry_record:get','crm_sign_list:get')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "crmCheckStatusEnum", value = "备案状态", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "countryId", value = "国家id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "provinceId", value = "省份id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "cityId", value = "城市id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "regionId", value = "地区id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "businessName", value = "企业名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "informantUserName", value = "填报人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unitClassConfigurationId", value = "企业性质", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitPropertyAllocationConfigId", value = "企业类别", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "industryConfigurationId", value = "所属行业", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitReputationAllocationConfigId", value = "企业信誉", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
      }
   )
   public ResultVO<PageVO<CrmBiddingPlatformWarehousingPageDTO>> getCrmBiddingPlatformWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitClassConfigurationId,
      Long unitPropertyAllocationConfigId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String biddingPlatformName,
      String informantUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:招标备案列表");
      return ResultBuilder.success(
         this.crmBiddingPlatformWarehousingBiz
            .getCrmBiddingPlatformWarehousingPage(
               crmCheckStatusEnum,
               checkRecord,
               startDate,
               endDate,
               countryId,
               provinceId,
               cityId,
               regionId,
               unitClassConfigurationId,
               unitPropertyAllocationConfigId,
               industryConfigurationId,
               unitReputationAllocationConfigId,
               biddingPlatformName,
               informantUserName,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("招标备案列表下载")
   @GetMapping("/list/down/load")
   @PreAuthorize("@permission.check('crm_registry_record:export','crm_sign_list:export')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> downLoadCrmBiddingPlatformWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      String biddingPlatformName,
      String informantUserName
   ) {
      log.info("API调用:招标备案列表下载");
      return ResultBuilder.success(
         this.crmBiddingPlatformWarehousingBiz
            .downLoadCrmBiddingPlatformWarehousingList(
               crmCheckStatusEnum, startDate, endDate, countryId, provinceId, cityId, regionId, biddingPlatformName, informantUserName
            )
      );
   }

   @ApiOperation("招标备案详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_registry_record:detail','crm_sign_list:detail')")
   public ResultVO crmBiddingPlatformWarehousingDetail(Long id) {
      log.info("API调用:招标备案详情");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.crmBiddingPlatformWarehousingDetail(id));
   }

   @ApiOperation("招标备案详情下载")
   @GetMapping("/detail/down/load")
   @PreAuthorize("@permission.check('crm_registry_record:print','crm_sign_list:print')")
   public ResultVO downLoadCrmBiddingPlatformWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:招标备案详情下载");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.downLoadCrmBiddingPlatformWarehousingDetail(id, response));
   }

   @ApiOperation("招标备案任务汇总")
   @GetMapping("/task/sum")
   @PreAuthorize("@permission.check('crm_registry_record:get')")
   public ResultVO getCrmBiddingPlatformTaskSum() {
      log.info("API调用:招标备案任务汇总");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.getCrmBiddingPlatformTaskSum());
   }

   @ApiOperation("招标备案任务驳回")
   @PostMapping("/overrule/task")
   @PreAuthorize("@permission.check('crm_registry_record:del')")
   public ResultVO overruleTask(Long id) {
      log.info("API调用:招标备案任务驳回");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.overruleTask(id));
   }

   @ApiOperation("招标备案CA锁设定")
   @PostMapping("/ca/locked")
   @PreAuthorize("@permission.check('crm_sign_list:save')")
   public ResultVO caLocked(@RequestBody CaLockedParam caLockedParam) {
      log.info("API调用:招标备案CA锁设定");
      return ResultBuilder.success(this.crmBiddingPlatformWarehousingBiz.caLocked(caLockedParam));
   }
}
