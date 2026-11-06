package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmGovernmentWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmGovernmentWarehousingUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmGovernmentWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmGovernmentWarehousingUpdateVO;
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

@Api(tags = "crm-办事大厅-政府备案")
@RestController
@RequestMapping("/api/crm/government/warehousing")
public class CrmGovernmentWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(CrmGovernmentWarehousingController.class);
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;

   @ApiOperation("政府备案汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('crm_goverment_record:get','crm_goverment_list:get')")
   public ResultVO summary(Integer checkRecord) {
      log.info("API调用:政府备案汇总");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.summary(checkRecord));
   }

   @ApiOperation("政府备案列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_goverment_record:get','crm_goverment_list:get')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "crmCheckStatusEnum", value = "备案状态", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "countryId", value = "国家id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "provinceId", value = "省份id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "cityId", value = "城市id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "regionId", value = "地区id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitPropertyAllocationConfigId", value = "单位性质", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitClassConfigurationId", value = "企业性质", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "industryConfigurationId", value = "所属行业", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitReputationAllocationConfigId", value = "企业信誉", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "businessName", value = "企业名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "informantUserName", value = "填报人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
      }
   )
   public ResultVO<PageVO<CrmGovernmentWarehousingPageDTO>> getCrmGovernmentWarehousingList(
      Integer checkRecord,
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:政府备案列表");
      return ResultBuilder.success(
         this.crmGovernmentWarehousingBiz
            .getCrmGovernmentWarehousingList(
               checkRecord,
               crmCheckStatusEnum,
               startDate,
               endDate,
               countryId,
               provinceId,
               cityId,
               regionId,
               unitPropertyAllocationConfigId,
               unitClassConfigurationId,
               industryConfigurationId,
               unitReputationAllocationConfigId,
               businessName,
               creditCode,
               informantUserName,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("政府备案列表下载")
   @GetMapping("/list/down/load")
   @PreAuthorize("@permission.check('crm_goverment_record:export','crm_goverment_list:export')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> downLoadCrmGovernmentWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   ) {
      log.info("API调用:政府备案列表下载");
      return ResultBuilder.success(
         this.crmGovernmentWarehousingBiz
            .downLoadCrmGovernmentWarehousingList(
               crmCheckStatusEnum,
               startDate,
               endDate,
               countryId,
               provinceId,
               cityId,
               regionId,
               unitPropertyAllocationConfigId,
               unitClassConfigurationId,
               industryConfigurationId,
               unitReputationAllocationConfigId,
               businessName,
               creditCode,
               informantUserName
            )
      );
   }

   @ApiOperation("政府备案详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_goverment_record:detail','crm_goverment_list:detail')")
   public ResultVO crmGovernmentWarehousingDetail(Long id) {
      log.info("API调用:政府备案详情");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.crmGovernmentWarehousingDetail(id));
   }

   @ApiOperation("政府备案详情下载")
   @GetMapping("/detail/down/load")
   @PreAuthorize("@permission.check('crm_goverment_record:print','crm_goverment_list:print')")
   public ResultVO downLoadCrmGovernmentWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:政府备案详情下载");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.downLoadCrmGovernmentWarehousingDetail(id, response));
   }

   @ApiOperation("政府备案新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_goverment_record:addTask')")
   public ResultVO saveCrmGovernmentWarehousing(@RequestBody CrmGovernmentWarehousingSaveVO crmGovernmentWarehousingSaveVO) {
      log.info("API调用:政府备案新增");
      return ResultBuilder.success(
         this.crmGovernmentWarehousingBiz.saveCrmGovernmentWarehousing(BeanUtil.copy(crmGovernmentWarehousingSaveVO, CrmGovernmentWarehousingSaveParam.class))
      );
   }

   @ApiOperation("政府备案修改")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('crm_goverment_record:addTask','crm_goverment_list:save')")
   public ResultVO updateCrmGovernmentWarehousing(@RequestBody CrmGovernmentWarehousingUpdateVO crmGovernmentWarehousingUpdateVO) {
      log.info("API调用:政府备案新增");
      return ResultBuilder.success(
         this.crmGovernmentWarehousingBiz
            .updateCrmGovernmentWarehousing(BeanUtil.copy(crmGovernmentWarehousingUpdateVO, CrmGovernmentWarehousingUpdateParam.class))
      );
   }

   @ApiOperation("政府备案删除")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_goverment_record:del')")
   public ResultVO deleteCrmGovernmentWarehousing(@RequestParam Long id) {
      log.info("API调用:政府备案删除");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.deleteCrmGovernmentWarehousing(id));
   }

   @ApiOperation("政府备案任务列表")
   @GetMapping("/task/list")
   @PreAuthorize("@permission.check('crm_goverment_record:get')")
   public ResultVO getCrmGovernmentTaskPage(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      String crmEnterpriseWarehousingName,
      String createUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:政府备案任务列表");
      return ResultBuilder.success(
         this.crmGovernmentWarehousingBiz
            .getCrmGovernmentTaskPage(crmCheckStatusEnum, startDate, endDate, crmEnterpriseWarehousingName, createUserName, pageNumber, pageSize)
      );
   }

   @ApiOperation("政府备案任务汇总")
   @GetMapping("/task/sum")
   @PreAuthorize("@permission.check('crm_goverment_record:get')")
   public ResultVO getCrmGovernmentTaskSum() {
      log.info("API调用:政府备案任务汇总");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.getCrmGovernmentTaskSum());
   }

   @ApiOperation("政府备案任务列表下载")
   @GetMapping("/task/list/downLoad")
   @PreAuthorize("@permission.check('crm_goverment_record:export')")
   public ResultVO downLoadCrmGovernmentTaskList(
      Integer crmCheckStatusEnum, LocalDate startDate, LocalDate endDate, String crmEnterpriseWarehousingName, String createUserName
   ) {
      log.info("API调用:政府备案任务列表下载");
      return ResultBuilder.success(
         this.crmGovernmentWarehousingBiz.downLoadCrmGovernmentTaskList(crmCheckStatusEnum, startDate, endDate, crmEnterpriseWarehousingName, createUserName)
      );
   }

   @ApiOperation("政府备案任务驳回")
   @PostMapping("/overrule/task")
   @PreAuthorize("@permission.check('crm_goverment_record:del')")
   public ResultVO overruleTask(Long id) {
      log.info("API调用:政府备案任务驳回");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.overruleTask(id));
   }

   @ApiOperation("政府备案CA锁设定")
   @PostMapping("/ca/locked")
   @PreAuthorize("@permission.check('crm_goverment_list:save')")
   public ResultVO caLocked(@RequestBody CaLockedParam caLockedParam) {
      log.info("API调用:政府备案CA锁设定");
      return ResultBuilder.success(this.crmGovernmentWarehousingBiz.caLocked(caLockedParam));
   }
}
