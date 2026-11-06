package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSupplierWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmSupplierWarehousingUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmSupplierWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmSupplierWarehousingUpdateVO;
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

@Api(tags = "crm-配置管理-供应商备案")
@RestController
@RequestMapping("/api/crm/supplier/warehousing")
public class CrmSupplierWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(CrmSupplierWarehousingController.class);
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;

   @ApiOperation("供应商备案汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('crm_supplier_record:get','crm_qualify_supplier_list:get')")
   public ResultVO summary(Integer checkRecord) {
      log.info("API调用:供应商备案汇总");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.summary(checkRecord));
   }

   @ApiOperation("供应商备案列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_supplier_record:get','crm_qualify_supplier_list:get')")
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
   public ResultVO<PageVO<CrmSupplierWarehousingPageDTO>> getCrmSupplierWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
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
      log.info("API调用:供应商备案列表");
      return ResultBuilder.success(
         this.crmSupplierWarehousingBiz
            .getCrmSupplierWarehousingPage(
               crmCheckStatusEnum,
               checkRecord,
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

   @ApiOperation("供应商备案列表下载")
   @GetMapping("/list/down/load")
   @PreAuthorize("@permission.check('crm_supplier_record:export','crm_qualify_supplier_list:export')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> downLoadCrmSupplierWarehousingList(
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
      log.info("API调用:供应商备案列表下载");
      return ResultBuilder.success(
         this.crmSupplierWarehousingBiz
            .downLoadCrmSupplierWarehousingList(
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

   @ApiOperation("供应商备案删除")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_supplier_record:del')")
   public ResultVO deleteCrmSupplierWarehousing(@RequestParam Long id) {
      log.info("API调用:供应商备案删除");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.deleteCrmSupplierWarehousing(id));
   }

   @ApiOperation("供应商备案新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_supplier_record:addTask')")
   public ResultVO saveCrmSupplierWarehousing(@RequestBody CrmSupplierWarehousingSaveVO crmSupplierWarehousingSafeVO) {
      log.info("API调用:供应商备案新增");
      return ResultBuilder.success(
         this.crmSupplierWarehousingBiz.saveCrmSupplierWarehousing(BeanUtil.copy(crmSupplierWarehousingSafeVO, CrmSupplierWarehousingSaveParam.class))
      );
   }

   @ApiOperation("供应商备案修改")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('crm_supplier_record:addTask','crm_qualify_supplier_list:save')")
   public ResultVO updateCrmSupplierWarehousing(@RequestBody CrmSupplierWarehousingUpdateVO crmSupplierWarehousingUpdateVO) {
      log.info("API调用:供应商备案修改");
      return ResultBuilder.success(
         this.crmSupplierWarehousingBiz.updateCrmSupplierWarehousing(BeanUtil.copy(crmSupplierWarehousingUpdateVO, CrmSupplierWarehousingUpdateParam.class))
      );
   }

   @ApiOperation("供应商备案详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_supplier_record:detail','crm_qualify_supplier_list:detail')")
   public ResultVO crmSupplierWarehousingDetail(Long id) {
      log.info("API调用:供应商备案详情");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.crmSupplierWarehousingDetail(id));
   }

   @ApiOperation("供应商备案详情下载")
   @GetMapping("/detail/down/load")
   @PreAuthorize("@permission.check('crm_supplier_record:print','crm_qualify_supplier_list:print')")
   public ResultVO downLoadCrmSupplierWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:供应商备案详情下载");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.downLoadCrmSupplierWarehousingDetail(id, response));
   }

   @ApiOperation("供应商备案任务列表")
   @GetMapping("/task/list")
   @PreAuthorize("@permission.check('crm_supplier_record:get')")
   public ResultVO getCrmSupplierTaskPage(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      String crmEnterpriseWarehousingName,
      String createUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:供应商备案任务列表");
      return ResultBuilder.success(
         this.crmSupplierWarehousingBiz
            .getCrmSupplierTaskPage(crmCheckStatusEnum, startDate, endDate, crmEnterpriseWarehousingName, createUserName, pageNumber, pageSize)
      );
   }

   @ApiOperation("供应商备案任务汇总")
   @GetMapping("/task/sum")
   @PreAuthorize("@permission.check('crm_supplier_record:get')")
   public ResultVO getCrmSupplierTaskSum() {
      log.info("API调用:供应商备案任务汇总");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.getCrmSupplierTaskSum());
   }

   @ApiOperation("供应商备案任务列表下载")
   @GetMapping("/task/list/downLoad")
   @PreAuthorize("@permission.check('crm_supplier_record:export')")
   public ResultVO downLoadCrmSupplierTaskList(
      Integer crmCheckStatusEnum, LocalDate startDate, LocalDate endDate, String crmEnterpriseWarehousingName, String createUserName
   ) {
      log.info("API调用:供应商备案任务列表下载");
      return ResultBuilder.success(
         this.crmSupplierWarehousingBiz.downLoadCrmSupplierTaskList(crmCheckStatusEnum, startDate, endDate, crmEnterpriseWarehousingName, createUserName)
      );
   }

   @ApiOperation("供应商备案任务驳回")
   @PostMapping("/overrule/task")
   @PreAuthorize("@permission.check('crm_supplier_record:del')")
   public ResultVO overruleTask(Long id) {
      log.info("API调用:供应商备案任务驳回");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.overruleTask(id));
   }

   @ApiOperation("供应商备案CA锁设定")
   @PostMapping("/ca/locked")
   @PreAuthorize("@permission.check('crm_qualify_supplier_list:save')")
   public ResultVO caLocked(@RequestBody CaLockedParam caLockedParam) {
      log.info("API调用:供应商备案CA锁设定");
      return ResultBuilder.success(this.crmSupplierWarehousingBiz.caLocked(caLockedParam));
   }
}
