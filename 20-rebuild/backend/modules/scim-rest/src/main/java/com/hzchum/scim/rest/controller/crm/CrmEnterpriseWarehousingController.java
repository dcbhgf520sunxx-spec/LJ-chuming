package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmEnterpriseWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmEnterpriseWarehousingUpdateParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmEnterpriseWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmEnterpriseWarehousingUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

@Api(tags = "crm-办事大厅-企业备案")
@RestController
@RequestMapping("/api/crm/enterprise/warehousing")
public class CrmEnterpriseWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(CrmEnterpriseWarehousingController.class);
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;

   @ApiOperation("企业备案汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('crm_business_record:get','crm_info_list:get')")
   public ResultVO summary() {
      log.info("API调用:企业备案汇总");
      return ResultBuilder.success(this.crmEnterpriseWarehousingBiz.summary());
   }

   @ApiOperation("企业备案列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_business_record:get','crm_info_list:get')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "crmCheckStatusEnum", value = "备案状态", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query", dataType = "LocalDate"),
            @ApiImplicitParam(name = "countryId", value = "国家id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "provinceId", value = "省份id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "cityId", value = "城市id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "regionId", value = "地区id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitPropertyAllocationConfigId", value = "单位类别id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitClassConfigurationId", value = "单位性质id", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "industryConfigurationId", value = "所属行业", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "unitReputationAllocationConfigId", value = "企业信誉", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "businessName", value = "企业名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "informantUserName", value = "填报人姓名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", dataType = "Integer")
      }
   )
   public ResultVO<PageVO<CrmEnterpriseWarehousingPageDTO>> getCrmEnterpriseWarehousingPage(
      Integer crmCheckStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
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
      log.info("API调用:企业备案列表");
      return ResultBuilder.success(
         this.crmEnterpriseWarehousingBiz
            .getCrmEnterpriseWarehousingPage(
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
               null,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("企业备案删除")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_business_record:del')")
   public ResultVO deleteCrmEnterpriseWarehousing(@RequestParam Long id) {
      log.info("API调用:企业备案删除");
      return ResultBuilder.success(this.crmEnterpriseWarehousingBiz.deleteCrmEnterpriseWarehousing(id));
   }

   @ApiOperation("企业备案详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_business_record:detail','crm_info_list:detail','crm_check_record:detail')")
   public ResultVO crmEnterpriseWarehousingDetail(Long id) {
      log.info("API调用:企业备案详情");
      return ResultBuilder.success(this.crmEnterpriseWarehousingBiz.crmEnterpriseWarehousingDetail(id));
   }

   @ApiOperation("企业备案详情下载")
   @GetMapping("/detail/down/load")
   @PreAuthorize("@permission.check('crm_business_record:print','crm_info_list:print')")
   public ResultVO downLoadCrmEnterpriseWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:企业备案详情下载");
      return ResultBuilder.success(this.crmEnterpriseWarehousingBiz.downLoadCrmEnterpriseWarehousingDetail(id, response));
   }

   @ApiOperation("企业备案简单信息列表")
   @GetMapping("/simple/info/list")
   @PreAuthorize("@permission.check('crm_business_record:add','crm_check_record:checkIn','crm_check_record:inbound','crm_supplier_record:addTask','crm_goverment_record:addTask','crm_registry_record:addTask','crm_qualify_supplier_list:save','crm_goverment_list:save','crm_sign_list:save')")
   public ResultVO getCrmEnterpriseWarehousingSimpleInfoList() {
      log.info("API调用:企业备案简单信息");
      return ResultBuilder.success(this.crmEnterpriseWarehousingBiz.getCrmEnterpriseWarehousingSimpleInfoList());
   }

   @ApiOperation("企业备案列表下载")
   @GetMapping("/list/down/load")
   @PreAuthorize("@permission.check('crm_business_record:export','crm_info_list:export')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> downLoadCrmEnterpriseWarehousingList(
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
      log.info("API调用:企业备案列表下载");
      return ResultBuilder.success(
         this.crmEnterpriseWarehousingBiz
            .downLoadCrmEnterpriseWarehousingList(
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

   @ApiOperation("企业备案修改")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('crm_business_record:add')")
   public ResultVO updateCrmEnterpriseWarehousing(@RequestBody CrmEnterpriseWarehousingUpdateVO crmEnterpriseWarehousingUpdateVO) {
      log.info("API调用:企业备案修改");
      return ResultBuilder.success(
         this.crmEnterpriseWarehousingBiz
            .updateCrmEnterpriseWarehousing(BeanUtil.copy(crmEnterpriseWarehousingUpdateVO, CrmEnterpriseWarehousingUpdateParam.class))
      );
   }

   @ApiOperation("企业备案新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_business_record:add')")
   public ResultVO saveCrmEnterpriseWarehousing(@RequestBody CrmEnterpriseWarehousingSaveVO crmEnterpriseWarehousingSaveVO) {
      log.info("API调用:企业备案新增");
      return ResultBuilder.success(
         this.crmEnterpriseWarehousingBiz.saveCrmEnterpriseWarehousing(BeanUtil.copy(crmEnterpriseWarehousingSaveVO, CrmEnterpriseWarehousingSaveParam.class))
      );
   }

   @ApiOperation("任务下达前置校验")
   @GetMapping("/task/precheck")
   @PreAuthorize("@permission.check('crm_check_record:inbound','crm_supplier_record:addTask','crm_goverment_record:addTask','crm_registry_record:addTask')")
   public ResultVO taskPrecheck(@RequestParam Long crmEnterpriseWarehousingId, @RequestParam Integer crmPageManagementConfigEnum) {
      log.info("API调用:任务下达前置校验");
      return ResultBuilder.success(this.crmEnterpriseWarehousingBiz.taskPrecheck(crmEnterpriseWarehousingId, crmPageManagementConfigEnum));
   }
}
