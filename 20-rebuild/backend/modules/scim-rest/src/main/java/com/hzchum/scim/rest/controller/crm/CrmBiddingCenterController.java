package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingCenterBiz;
import com.hzchum.scim.crm.core.api.pojo.param.CrmSetTenderHeadParam;
import com.hzchum.scim.crm.core.api.pojo.param.CrmSetTenderHeadParamV2;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUploadTenderDocumentsParam;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUploadTenderDocumentsParamV2;
import com.hzchum.scim.rest.pojo.vo.crm.CrmSetTenderHeadVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmSetTenderHeadVOV2;
import com.hzchum.scim.rest.pojo.vo.crm.CrmUploadTenderDocumentsVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmUploadTenderDocumentsVOV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "crm-投标中心")
@RestController
@RequestMapping("/api/crm/bidding/center")
public class CrmBiddingCenterController {
   private static final Logger log = LoggerFactory.getLogger(CrmBiddingCenterController.class);
   @Resource
   private CrmBiddingCenterBiz crmBiddingCenterBiz;

   @ApiOperation("投标列表(根据类型查询)")
   @GetMapping("/getTenderList")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'get','list')")
   public ResultVO getCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      @RequestParam Integer crmTenderRequirementTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:投标列表(根据类型查询)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .getCrmTenderList(
               startDate,
               endDate,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("投标列表（根据类型下载）")
   @GetMapping("/list/down/load")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'export','list')")
   public ResultVO downLoadCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      @RequestParam Integer crmTenderRequirementTypeEnum
   ) {
      log.info("API调用:投标列表（根据类型下载）");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .downLoadCrmTenderList(
               startDate,
               endDate,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum
            )
      );
   }

   @ApiOperation("投标列表汇总(根据类型查询)")
   @GetMapping("/getTenderListSummary")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'get','list')")
   public ResultVO getTenderListSummary(Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:投标列表汇总(根据类型查询)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.getTenderListSummary(crmTenderRequirementTypeEnum));
   }

   @ApiOperation("项目投标详情")
   @GetMapping("/getTender/detail")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'detail','detail')")
   public ResultVO getTenderDetail(Long id, Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:项目投标详情");
      return ResultBuilder.success(this.crmBiddingCenterBiz.getTenderDetail(id, crmTenderRequirementTypeEnum));
   }

   @ApiOperation("项目投标负责人填写文件详情")
   @GetMapping("/get/head/fill/out/detail")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'detail','mine')")
   public ResultVO getHeadFillOutDetail(Long id, Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:项目投标负责人填写文件详情");
      return ResultBuilder.success(this.crmBiddingCenterBiz.getHeadFillOutDetail(id, crmTenderRequirementTypeEnum));
   }

   @ApiOperation("项目设置投标负责人")
   @PostMapping("/set/tender/head")
   @PreAuthorize("@crmAccess.tender(#crmSetTenderHeadVO.crmTenderRequirementTypeEnum,null,null,'save','list')")
   public ResultVO setTenderHead(@RequestBody CrmSetTenderHeadVO crmSetTenderHeadVO) {
      log.info("API调用:项目设置投标负责人");
      return ResultBuilder.success(this.crmBiddingCenterBiz.setTenderHead(BeanUtil.copy(crmSetTenderHeadVO, CrmSetTenderHeadParam.class)));
   }

   @ApiOperation("投标列表(我的项目列表)")
   @GetMapping("/getMyTenderList")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'get','mine')")
   public ResultVO getMyCrmTenderList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:投标列表(我的项目列表)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .getMyCrmTenderList(
               startDate,
               endDate,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("投标列表(我的项目列表)下载")
   @GetMapping("/my/tender/list/down/load")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'export','mine')")
   public ResultVO myTenderListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   ) {
      log.info("投标列表(我的项目列表)下载");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .myTenderListDownLoad(
               startDate,
               endDate,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum
            )
      );
   }

   @ApiOperation("投标列表汇总(我的项目列表汇总)")
   @GetMapping("/getMyTenderListSummary")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'get','mine')")
   public ResultVO getMyTenderListSummary(@RequestParam Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:投标列表汇总(我的项目列表汇总)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.getMyTenderListSummary(crmTenderRequirementTypeEnum));
   }

   @ApiOperation("根据类型上传投标文件")
   @PostMapping("/upload/tender/documents")
   @PreAuthorize("@crmAccess.tender(#crmUploadTenderDocumentsVO.crmTenderRequirementTypeEnum,null,null,'save','mine')")
   @SignerCheck(lockKey = "#crmUploadTenderDocumentsVO.crmProjectInformationWarehousingId", message = "该项目正在投标文件上传中，请稍后刷新重试")
   public ResultVO uploadTenderDocuments(@RequestBody CrmUploadTenderDocumentsVO crmUploadTenderDocumentsVO) {
      log.info("API调用:根据类型上传投标文件");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz.uploadTenderDocuments(BeanUtil.copy(crmUploadTenderDocumentsVO, CrmUploadTenderDocumentsParam.class))
      );
   }

   @ApiOperation("档案管理列表")
   @GetMapping("/archives/management/list")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'get','archive')")
   public ResultVO archivesManagementList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:档案管理列表");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .archivesManagementList(startDate, endDate, crmTenderRequirementTypeEnum, serialNumber, applyForBidReporterName, headUserName, pageNumber, pageSize)
      );
   }

   @ApiOperation("档案管理列表下载")
   @GetMapping("/archives/management/list/down/load")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'export','archive')")
   public ResultVO archivesManagementListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName
   ) {
      log.info("API调用:档案管理列表下载");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .archivesManagementListDownLoad(startDate, endDate, crmTenderRequirementTypeEnum, serialNumber, applyForBidReporterName, headUserName)
      );
   }

   @ApiOperation("项目文档列表")
   @GetMapping("/project/documentation/list")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'detail','detail')")
   public ResultVO projectDocumentationList(@RequestParam Integer crmTenderRequirementTypeEnum, @RequestParam Long crmProjectInformationWarehousingId) {
      log.info("API调用:项目文档列表");
      return ResultBuilder.success(this.crmBiddingCenterBiz.projectDocumentationList(crmTenderRequirementTypeEnum, crmProjectInformationWarehousingId));
   }

   @ApiOperation("项目文档下载")
   @GetMapping("/downLoad/attachment")
   @PreAuthorize("@permission.check('crm_business_document:export','crm_technology_center_document:export','crm_design_center_document:export','crm_bid_list:detail','crm_business_my_project:detail','crm_business_document:detail','crm_technology_center_tender_list:detail','crm_technology_center_specifical_list:detail','crm_technology_center_organize_list:detail','crm_technology_center_my_project:detail','crm_technology_center_document:detail','crm_design_center_tender_list:detail','crm_design_center_my_project:detail','crm_design_center_document:detail')")
   public void downLoadAttachment(Long id) {
      log.info("API调用:项目文档下载");
      this.crmBiddingCenterBiz.downLoadAttachment(id);
   }

   @ApiOperation("项目负责人详情(根据类型筛选)")
   @GetMapping("/details/of/the/project/leader")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'detail','detail')")
   public ResultVO detailsOfTheProjectLeader(@RequestParam Integer crmTenderRequirementTypeEnum, @RequestParam Long crmProjectInformationWarehousingId) {
      log.info("API调用:项目负责人详情(根据类型筛选)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.detailsOfTheProjectLeader(crmTenderRequirementTypeEnum, crmProjectInformationWarehousingId));
   }

   @ApiOperation("投标详情下载")
   @GetMapping("/tender/detail/down/load")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'print','list')")
   public void crmTenderDetailDownLoad(Long id, Integer crmTenderRequirementTypeEnum, HttpServletResponse response) {
      log.info("API调用:投标详情下载");
      this.crmBiddingCenterBiz.crmTenderDetailDownLoad(id, crmTenderRequirementTypeEnum, response);
   }

   @ApiOperation("投标列表(根据类型查询)(定制)")
   @GetMapping("/getTenderList/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,#crmSettlementBusinessTypeEnum,'get','list')")
   public ResultVO getCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime cEndDate,
      LocalDateTime cStartDate,
      Integer crmSpecialBubmissionStatusEnum,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      @RequestParam Integer crmTenderRequirementTypeEnum,
      Integer crmSettlementBusinessTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:投标列表(根据类型查询)(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .getCrmTenderListCustom(
               startDate,
               endDate,
               cStartDate,
               cEndDate,
               crmSpecialBubmissionStatusEnum,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum,
               crmSettlementBusinessTypeEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("投标列表(我的项目列表)(定制)")
   @GetMapping("/getMyTenderList/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,null,'get','mine')")
   public ResultVO getMyCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:投标列表(我的项目列表)(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .getMyCrmTenderListCustom(
               startDate,
               endDate,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum,
               crmSpecialBubmissionStatusEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("投标列表（根据类型下载）(定制)")
   @GetMapping("/list/down/load/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,#crmSettlementBusinessTypeEnum,'export','list')")
   public ResultVO downLoadCrmTenderListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime cStartDate,
      LocalDateTime cEndDate,
      Integer crmSpecialBubmissionStatusEnum,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmSettlementBusinessTypeEnum,
      @RequestParam Integer crmTenderRequirementTypeEnum
   ) {
      log.info("API调用:投标列表（根据类型下载）(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .downLoadCrmTenderListCustom(
               startDate,
               endDate,
               cStartDate,
               cEndDate,
               crmSpecialBubmissionStatusEnum,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmSettlementBusinessTypeEnum,
               crmTenderRequirementTypeEnum
            )
      );
   }

   @ApiOperation("项目投标详情(定制)")
   @GetMapping("/getTender/detail/custom")
   @PreAuthorize("@crmAccess.tenderRecord(#crmApplyTechnologyBiddingRecordId,#id,#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,'detail','detail')")
   public ResultVO getTenderDetailCustom(
      Long id,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer crmSettlementBusinessTypeEnum,
      Long crmApplyTechnologyBiddingRecordId
   ) {
      log.info("API调用:项目投标详情(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .getTenderDetailCustom(
               id, crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum, crmApplyTechnologyBiddingRecordId
            )
      );
   }

   @ApiOperation("项目设置投标负责人(定制)")
   @PostMapping("/set/tender/head/custom")
   @PreAuthorize("@crmAccess.tenderRecord(#crmSetTenderHeadVOV2.crmApplyTechnologyBiddingRecordId,#crmSetTenderHeadVOV2.crmProjectInformationWarehousingId,#crmSetTenderHeadVOV2.crmTenderRequirementTypeEnum,#crmSetTenderHeadVOV2.crmSpecialBubmissionStatusEnum,'save','list')")
   public ResultVO setTenderHeadCustom(@RequestBody CrmSetTenderHeadVOV2 crmSetTenderHeadVOV2) {
      log.info("API调用:项目设置投标负责人(定制)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.setTenderHeadCustom(BeanUtil.copy(crmSetTenderHeadVOV2, CrmSetTenderHeadParamV2.class)));
   }

   @ApiOperation("项目修改投标状态(定制)")
   @PostMapping("/update/bidding/status")
   @PreAuthorize("@crmAccess.tenderRecord(#crmSetTenderHeadVOV2.crmApplyTechnologyBiddingRecordId,#crmSetTenderHeadVOV2.crmProjectInformationWarehousingId,#crmSetTenderHeadVOV2.crmTenderRequirementTypeEnum,#crmSetTenderHeadVOV2.crmSpecialBubmissionStatusEnum,'finish','list')")
   public ResultVO updateBiddingStatus(@RequestBody CrmSetTenderHeadVOV2 crmSetTenderHeadVOV2) {
      log.info("API调用:项目设置投标负责人(定制)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.updateBiddingStatus(BeanUtil.copy(crmSetTenderHeadVOV2, CrmSetTenderHeadParamV2.class)));
   }

   @ApiOperation("投标列表(我的项目列表)下载(定制)")
   @GetMapping("/my/tender/list/down/load/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'export','mine')")
   public ResultVO myTenderListDownLoadCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(name = "regionIds", required = false) List<Long> regionIds,
      Long structureTypeConfigurationId,
      Long departmentId,
      String projectName,
      String crmEnterpriseWarehousingName,
      String projectInformantUserName,
      Integer crmTenderRequirementTypeEnum
   ) {
      log.info("投标列表(我的项目列表)下载(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .myTenderListDownLoadCustom(
               startDate,
               endDate,
               regionIds,
               structureTypeConfigurationId,
               departmentId,
               projectName,
               crmEnterpriseWarehousingName,
               projectInformantUserName,
               crmTenderRequirementTypeEnum
            )
      );
   }

   @ApiOperation("根据类型上传投标文件(定制)")
   @PostMapping("/upload/tender/documents/custom")
   @PreAuthorize("@crmAccess.tenderRecord(#vov2.crmApplyTechnologyBiddingRecordId,#vov2.crmProjectInformationWarehousingId,#vov2.crmTenderRequirementTypeEnum,#vov2.crmSpecialBubmissionStatusEnum,'save','mine')")
   @SignerCheck(lockKey = "#vov2.crmProjectInformationWarehousingId", message = "该项目正在投标文件上传中，请稍后刷新重试")
   public ResultVO uploadTenderDocumentsCustom(@RequestBody CrmUploadTenderDocumentsVOV2 vov2) {
      log.info("API调用:根据类型上传投标文件(定制)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.uploadTenderDocumentsCustom(BeanUtil.copy(vov2, CrmUploadTenderDocumentsParamV2.class)));
   }

   @ApiOperation("档案管理列表(定制)")
   @GetMapping("/archives/management/list/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,#crmSettlementBusinessTypeEnum,'get','archive')")
   public ResultVO archivesManagementListCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      String headUserName,
      Integer crmSettlementBusinessTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:档案管理列表(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .archivesManagementListCustom(
               startDate,
               endDate,
               crmTenderRequirementTypeEnum,
               serialNumber,
               applyForBidReporterName,
               headUserName,
               crmSettlementBusinessTypeEnum,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("档案管理列表下载(定制)")
   @GetMapping("/archives/management/list/down/load/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,#crmSettlementBusinessTypeEnum,'export','archive')")
   public ResultVO archivesManagementListDownLoadCustom(
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam Integer crmTenderRequirementTypeEnum,
      String serialNumber,
      String applyForBidReporterName,
      Integer crmSettlementBusinessTypeEnum,
      String headUserName
   ) {
      log.info("API调用:档案管理列表下载(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .archivesManagementListDownLoadCustom(
               startDate, endDate, crmTenderRequirementTypeEnum, serialNumber, applyForBidReporterName, crmSettlementBusinessTypeEnum, headUserName
            )
      );
   }

   @ApiOperation("项目文档列表(定制)")
   @GetMapping("/project/documentation/list/custom")
   @PreAuthorize("@crmAccess.tenderRecord(#crmApplyTechnologyBiddingRecordId,#crmProjectInformationWarehousingId,#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,'detail','detail')")
   public ResultVO projectDocumentationListCustom(
      @RequestParam Integer crmTenderRequirementTypeEnum,
      @RequestParam Long crmProjectInformationWarehousingId,
      Integer crmSettlementBusinessTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Long crmApplyTechnologyBiddingRecordId
   ) {
      log.info("API调用:项目文档列表(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .projectDocumentationListCustom(
               crmTenderRequirementTypeEnum,
               crmProjectInformationWarehousingId,
               crmSettlementBusinessTypeEnum,
               crmSpecialBubmissionStatusEnum,
               crmApplyTechnologyBiddingRecordId
            )
      );
   }

   @ApiOperation("项目负责人详情(根据类型筛选)(定制)")
   @GetMapping("/details/of/the/project/leader/custom")
   @PreAuthorize("@crmAccess.tenderRecord(#crmApplyTechnologyBiddingRecordId,#crmProjectInformationWarehousingId,#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,'detail','detail')")
   public ResultVO detailsOfTheProjectLeaderCustom(
      @RequestParam Integer crmTenderRequirementTypeEnum,
      @RequestParam Long crmProjectInformationWarehousingId,
      Integer crmSpecialBubmissionStatusEnum,
      Long crmApplyTechnologyBiddingRecordId
   ) {
      log.info("API调用:项目负责人详情(根据类型筛选)(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz
            .detailsOfTheProjectLeaderCustom(
               crmTenderRequirementTypeEnum, crmProjectInformationWarehousingId, crmSpecialBubmissionStatusEnum, crmApplyTechnologyBiddingRecordId
            )
      );
   }

   @ApiOperation("投标详情下载(定制)")
   @GetMapping("/tender/detail/down/load/custom")
   @PreAuthorize("@crmAccess.tenderRecord(#crmApplyTechnologyBiddingRecordId,#id,#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,'print','list')")
   public void crmTenderDetailDownLoadCustom(
      Long id,
      Integer crmTenderRequirementTypeEnum,
      Integer crmSpecialBubmissionStatusEnum,
      Integer crmSettlementBusinessTypeEnum,
      Long crmApplyTechnologyBiddingRecordId,
      HttpServletResponse response
   ) {
      log.info("API调用:投标详情下载(定制)");
      this.crmBiddingCenterBiz
         .crmTenderDetailDownLoadCustom(
            id, crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum, crmApplyTechnologyBiddingRecordId, response
         );
   }

   @ApiOperation("投标列表汇总(根据类型查询)(定制)")
   @GetMapping("/getTenderListSummary/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,#crmSpecialBubmissionStatusEnum,#crmSettlementBusinessTypeEnum,'get','list')")
   public ResultVO getTenderListSummaryCustom(
      Integer crmTenderRequirementTypeEnum, Integer crmSpecialBubmissionStatusEnum, Integer crmSettlementBusinessTypeEnum
   ) {
      log.info("API调用:投标列表汇总(根据类型查询)(定制)");
      return ResultBuilder.success(
         this.crmBiddingCenterBiz.getTenderListSummaryCustom(crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum)
      );
   }

   @ApiOperation("投标列表汇总(我的项目列表汇总)(定制)")
   @GetMapping("/getMyTenderListSummary/custom")
   @PreAuthorize("@crmAccess.tender(#crmTenderRequirementTypeEnum,null,null,'get','mine')")
   public ResultVO getMyTenderListSummaryCustom(@RequestParam Integer crmTenderRequirementTypeEnum) {
      log.info("API调用:投标列表汇总(我的项目列表汇总)(定制)");
      return ResultBuilder.success(this.crmBiddingCenterBiz.getMyTenderListSummaryCustom(crmTenderRequirementTypeEnum));
   }
}
