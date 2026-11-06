package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessCenterBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBiddingPlatformWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmCenterProjectListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.ProjectAssignmentParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmProjectTerminatedUpdateDTO;
import com.hzchum.scim.rest.pojo.vo.crm.ProjectAssignmentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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

@Api(tags = "crm-商务中心")
@RestController
@RequestMapping("/api/crm/business/center")
public class CrmBusinessCenterController {
   private static final Logger log = LoggerFactory.getLogger(CrmBusinessCenterController.class);
   @Resource
   private CrmBusinessCenterBiz crmBusinessCenterBiz;

   @ApiOperation("商务中心-项目公共池")
   @GetMapping("/get/project/public/pool")
   @PreAuthorize("@permission.check('crm_common_pool:get')")
   public ResultVO getProjectPublicPool(
      Long projectLevelConfigId,
      LocalDate startDate,
      LocalDate endDate,
      String projectName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:商务中心-项目公共池");
      return ResultBuilder.success(this.crmBusinessCenterBiz.getProjectPublicPool(projectLevelConfigId, startDate, endDate, projectName, pageNumber, pageSize));
   }

   @ApiOperation("商务中心-项目重新分配")
   @PostMapping("/assignment/project")
   @PreAuthorize("@permission.check('crm_common_pool:confirm')")
   public ResultVO assignmentProject(@RequestBody ProjectAssignmentVO projectAssignmentDTO) {
      log.info("API调用:商务中心-项目重新分配");
      return ResultBuilder.success(this.crmBusinessCenterBiz.assignmentProject(BeanUtil.copy(projectAssignmentDTO, ProjectAssignmentParam.class)));
   }

   @ApiOperation("商务中心-项目信息列表汇总")
   @GetMapping("/summary")
   @PreAuthorize("@permission.check('crm_project_info_list:get')")
   public ResultVO summary() {
      log.info("API调用:商务中心-项目信息列表汇总");
      return ResultBuilder.success(this.crmBusinessCenterBiz.summary());
   }

   @ApiOperation("商务中心-项目信息列表")
   @GetMapping("/project/list")
   @PreAuthorize("@permission.check('crm_project_info_list:get')")
   public ResultVO<PageVO<CrmCenterProjectListDTO>> centerProjectList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long structureTypeConfigurationId,
      @RequestParam(required = false) List<Long> departmentIds,
      String projectName,
      String crmEnterpriseWarehousingName,
      String informantUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:商务中心-项目信息列表");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
            .centerProjectList(
               startDate,
               endDate,
               countryId,
               provinceId,
               cityId,
               regionId,
               structureTypeConfigurationId,
               departmentIds,
               projectName,
               crmEnterpriseWarehousingName,
               informantUserName,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("商务中心-项目信息列表下载")
   @GetMapping("/project/list/down/load")
   @PreAuthorize("@permission.check('crm_project_info_list:print')")
   public ResultVO centerProjectListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long structureTypeConfigurationId,
      @RequestParam(required = false) List<Long> departmentIds,
      String projectName,
      String crmEnterpriseWarehousingName,
      String informantUserName
   ) {
      log.info("API调用:商务中心-项目信息列表下载");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
            .centerProjectListDownLoad(
               startDate,
               endDate,
               countryId,
               provinceId,
               cityId,
               regionId,
               structureTypeConfigurationId,
               departmentIds,
               projectName,
               crmEnterpriseWarehousingName,
               informantUserName
            )
      );
   }

   @ApiOperation("商务中心-项目跟进记录")
   @GetMapping("/followUp/record")
   @PreAuthorize("@permission.check('crm_check_record:detail','crm_project_info_list:detail','crm_common_pool:detail','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail','crm_specifical_program_manage:detail','crm_win_bid_project:detail','crm_business_summary_statistics:detail')")
   public ResultVO getFollowUpRecord(@RequestParam Long crmProjectInformationWarehousingId) {
      log.info("API调用:商务中心-项目跟进记录");
      return ResultBuilder.success(this.crmBusinessCenterBiz.getFollowUpRecord(crmProjectInformationWarehousingId));
   }

   @ApiOperation("商务中心-企业备案汇总")
   @GetMapping("/enterprise/summary")
   @PreAuthorize("@permission.check('crm_info_list:get')")
   public ResultVO getEnterpriseSummary() {
      log.info("API调用:商务中心企业备案汇总");
      return ResultBuilder.success(this.crmBusinessCenterBiz.getEnterpriseSummary());
   }

   @ApiOperation("商务中心-企业备案列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_info_list:get')")
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
      log.info("API调用:商务中心-企业备案列表");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
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
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("商务中心-企业备案详情")
   @GetMapping("/enterprise/detail")
   @PreAuthorize("@permission.check('crm_info_list:detail')")
   public ResultVO crmEnterpriseWarehousingDetail(Long id) {
      log.info("API调用:商务中心-企业备案详情");
      return ResultBuilder.success(this.crmBusinessCenterBiz.crmEnterpriseWarehousingDetail(id));
   }

   @ApiOperation("商务中心-企业备案详情下载")
   @GetMapping("/enterprise/detail/downLoad")
   @PreAuthorize("@permission.check('crm_info_list:print')")
   public ResultVO downLoadCrmEnterpriseWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:商务中心-企业备案详情下载");
      return ResultBuilder.success(this.crmBusinessCenterBiz.downLoadCrmEnterpriseWarehousingDetail(id, response));
   }

   @ApiOperation("商务中心-企业备案列表下载")
   @GetMapping("/enterprise/list/down/load")
   @PreAuthorize("@permission.check('crm_info_list:export')")
   public ResultVO downLoadCrmEnterpriseWarehousingList(
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
      log.info("API调用:商务中心-企业备案列表下载");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
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

   @ApiOperation("商务中心-供应商备案汇总")
   @GetMapping("/supplier/summary")
   @PreAuthorize("@permission.check('crm_qualify_supplier_list:get')")
   public ResultVO supplierSummary() {
      log.info("API调用:商务中心-供应商备案汇总");
      return ResultBuilder.success(this.crmBusinessCenterBiz.supplierSummary());
   }

   @ApiOperation("商务中心-供应商备案列表")
   @GetMapping("/supplier/list")
   @PreAuthorize("@permission.check('crm_qualify_supplier_list:get')")
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
      log.info("API调用:商务中心-供应商备案列表");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
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

   @ApiOperation("商务中心-供应商备案列表下载")
   @GetMapping("/supplier/list/down/load")
   @PreAuthorize("@permission.check('crm_qualify_supplier_list:export')")
   public ResultVO downLoadCrmSupplierWarehousingList(
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
      String informantUserName
   ) {
      log.info("API调用:商务中心-供应商备案列表下载");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
            .downLoadCrmSupplierWarehousingList(
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
               informantUserName
            )
      );
   }

   @ApiOperation("商务中心-供应商备案详情")
   @GetMapping("/supplier/detail")
   @PreAuthorize("@permission.check('crm_qualify_supplier_list:detail')")
   public ResultVO crmSupplierWarehousingDetail(Long id) {
      log.info("API调用:商务中心-供应商备案详情");
      return ResultBuilder.success(this.crmBusinessCenterBiz.crmSupplierWarehousingDetail(id));
   }

   @ApiOperation("商务中心-供应商备案详情下载")
   @GetMapping("/supplier/detail/downLoad")
   @PreAuthorize("@permission.check('crm_qualify_supplier_list:print')")
   public ResultVO downLoadCrmSupplierWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:商务中心-供应商备案详情下载");
      return ResultBuilder.success(this.crmBusinessCenterBiz.downLoadCrmSupplierWarehousingDetail(id, response));
   }

   @ApiOperation("商务中心-政府备案汇总")
   @GetMapping("/government/summary")
   @PreAuthorize("@permission.check('crm_goverment_list:get')")
   public ResultVO governmentSummary() {
      log.info("API调用:商务中心-政府备案汇总");
      return ResultBuilder.success(this.crmBusinessCenterBiz.governmentSummary());
   }

   @ApiOperation("商务中心-政府备案列表")
   @GetMapping("/government/list")
   @PreAuthorize("@permission.check('crm_goverment_list:get')")
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
      log.info("API调用:商务中心-政府备案列表");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
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

   @ApiOperation("商务中心-政府备案列表下载")
   @GetMapping("/government/list/down/load")
   @PreAuthorize("@permission.check('crm_goverment_list:export')")
   public ResultVO downLoadCrmGovernmentWarehousingList(
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
      String informantUserName
   ) {
      log.info("API调用:商务中心-政府备案列表下载");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
            .downLoadCrmGovernmentWarehousingList(
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
               informantUserName
            )
      );
   }

   @ApiOperation("商务中心-政府备案详情")
   @GetMapping("/government/detail")
   @PreAuthorize("@permission.check('crm_goverment_list:detail')")
   public ResultVO crmGovernmentWarehousingDetail(Long id) {
      log.info("API调用:商务中心-政府备案详情");
      return ResultBuilder.success(this.crmBusinessCenterBiz.crmGovernmentWarehousingDetail(id));
   }

   @ApiOperation("商务中心-政府备案详情下载")
   @GetMapping("/government/detail/downLoad")
   @PreAuthorize("@permission.check('crm_goverment_list:print')")
   public ResultVO downLoadCrmGovernmentWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:商务中心-政府备案详情下载");
      return ResultBuilder.success(this.crmBusinessCenterBiz.downLoadCrmGovernmentWarehousingDetail(id, response));
   }

   @ApiOperation("商务中心-招标备案汇总")
   @GetMapping("/platform/summary")
   @PreAuthorize("@permission.check('crm_sign_list:get')")
   public ResultVO platformSummary() {
      log.info("API调用:商务中心-招标备案汇总");
      return ResultBuilder.success(this.crmBusinessCenterBiz.platformSummary());
   }

   @ApiOperation("商务中心-招标备案列表")
   @GetMapping("/platform/list")
   @PreAuthorize("@permission.check('crm_sign_list:get')")
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
      String biddingPlatformName,
      String informantUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:商务中心-招标备案列表");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
            .getCrmBiddingPlatformWarehousingPage(
               crmCheckStatusEnum,
               checkRecord,
               startDate,
               endDate,
               countryId,
               provinceId,
               cityId,
               regionId,
               biddingPlatformName,
               informantUserName,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("商务中心-招标备案列表下载")
   @GetMapping("/platform/list/down/load")
   @PreAuthorize("@permission.check('crm_sign_list:export')")
   public ResultVO downLoadCrmBiddingPlatformWarehousingList(
      Integer checkRecord,
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
      log.info("API调用:商务中心-招标备案列表下载");
      return ResultBuilder.success(
         this.crmBusinessCenterBiz
            .downLoadCrmBiddingPlatformWarehousingList(
               checkRecord, crmCheckStatusEnum, startDate, endDate, countryId, provinceId, cityId, regionId, biddingPlatformName, informantUserName
            )
      );
   }

   @ApiOperation("商务中心-项目终止")
   @PostMapping("/project/terminated")
   @PreAuthorize("@permission.check('crm_bid_list:finish','crm_technology_center_tender_list:save','crm_technology_center_specifical_list:save','crm_technology_center_organize_list:save','crm_design_center_tender_list:save')")
   public ResultVO projectTerminated(@RequestBody CrmProjectTerminatedUpdateDTO dto) {
      log.info("API调用：商务中心-项目终止");
      return ResultBuilder.success(this.crmBusinessCenterBiz.projectTerminated(dto));
   }

   @ApiOperation("商务中心-招标备案详情")
   @GetMapping("/platform/detail")
   @PreAuthorize("@permission.check('crm_sign_list:detail')")
   public ResultVO crmBiddingPlatformWarehousingDetail(Long id) {
      log.info("API调用:商务中心-招标备案详情");
      return ResultBuilder.success(this.crmBusinessCenterBiz.crmBiddingPlatformWarehousingDetail(id));
   }

   @ApiOperation("商务中心-招标备案详情下载")
   @GetMapping("/platform/detail/downLoad")
   @PreAuthorize("@permission.check('crm_sign_list:print')")
   public ResultVO downLoadCrmBiddingPlatformWarehousingDetail(Long id, HttpServletResponse response) {
      log.info("API调用:商务中心-招标备案详情下载");
      return ResultBuilder.success(this.crmBusinessCenterBiz.downLoadCrmBiddingPlatformWarehousingDetail(id, response));
   }
}
