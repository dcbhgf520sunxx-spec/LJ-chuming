package com.hzchum.scim.rest.controller.crm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.crm.core.api.biz.CrmWinningContractWarehousingBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmRemainderCanEstablishProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmWinningContractWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CrmUpLoadStampContractParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmNonDirectSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSpecialProgramsSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmWinningContractWarehousingSaveParamV2;
import com.hzchum.scim.rest.pojo.vo.crm.CrmNonDirectSpecialProgramsSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmSpecialProgramsSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmWinningContractWarehousingSaveVO;
import com.hzchum.scim.rest.pojo.vo.crm.CrmWinningContractWarehousingSaveVOV2;
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

@Api(tags = "crm-商务中心-中标项目管理")
@RestController
@RequestMapping("/api/crm/winning/contract/warehousing")
public class CrmWinningContractWarehousingController {
   private static final Logger log = LoggerFactory.getLogger(CrmWinningContractWarehousingController.class);
   @Resource
   private CrmWinningContractWarehousingBiz crmWinningContractWarehousingBiz;

   @ApiOperation("剩余可立项项目备案列表")
   @GetMapping("")
   @PreAuthorize("@permission.check('contract_project:add','crm_win_bid_project:add')")
   public ResultVO<List<CrmRemainderCanEstablishProjectInfoDTO>> getRemainderCanEstablishProjectInfo(Long id) {
      log.info("API调用:剩余可立项项目备案列表");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getRemainderCanEstablishProjectInfo(id));
   }

   @ApiOperation("简单中标项目信息")
   @GetMapping("/get/simple/list")
   @PreAuthorize("@permission.check('crm_win_bid_project:get','contract_project:add')")
   public ResultVO getSimpleList() {
      log.info("API调用:简单中标项目信息");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getSimpleList());
   }

   @ApiOperation("获取合同管理立项回填信息")
   @GetMapping("/get/backfill/details")
   @PreAuthorize("@permission.check('contract_project:add')")
   public ResultVO backfillTheDetails(Long id) {
      log.info("API调用:获取合同管理立项回填信息");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.backfillTheDetails(id));
   }

   @ApiOperation("剩余可立项项目备案详情")
   @GetMapping("/project/detail")
   @PreAuthorize("@permission.check('contract_project:add','crm_win_bid_project:detail')")
   public ResultVO getRemainderCanEstablishProjectDetail(@RequestParam Long id) {
      log.info("API调用:剩余可立项项目备案详情");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getRemainderCanEstablishProjectDetail(id));
   }

   @ApiOperation("中标管理项目列表")
   @GetMapping("/contract/list")
   @PreAuthorize("@permission.check('crm_win_bid_project:get')")
   public ResultVO<PageVO<CrmWinningContractWarehousingPageDTO>> getContractList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum,
      @RequestParam(required = false) List<Integer> tenderRequirements,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:中标管理项目列表");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .getContractList(
               startDate,
               endDate,
               projectName,
               serialNumber,
               crmEnterpriseWarehousingName,
               crmProjectScheduleTypeEnum,
               null,
               tenderRequirements,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("中标管理项目汇总")
   @GetMapping("/contract/summary")
   @PreAuthorize("@permission.check('crm_win_bid_project:get')")
   public ResultVO getContractSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      String crmEnterpriseWarehousingName,
      Integer crmProjectScheduleTypeEnum
   ) {
      log.info("API调用:中标管理项目汇总");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .getContractSummary(startDate, endDate, projectName, serialNumber, crmEnterpriseWarehousingName, crmProjectScheduleTypeEnum)
      );
   }

   @ApiOperation("中标管理项目列表下载")
   @GetMapping("/contract/list/down/load")
   @PreAuthorize("@permission.check('crm_win_bid_project:print')")
   public ResultVO getContractListDownLoad(
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String serialNumber,
      Integer crmProjectScheduleTypeEnum,
      String crmEnterpriseWarehousingName
   ) {
      log.info("API调用:中标管理项目列表下载");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .getContractListDownLoad(startDate, endDate, projectName, serialNumber, crmProjectScheduleTypeEnum, crmEnterpriseWarehousingName)
      );
   }

   @ApiOperation("中标项目新增")
   @PostMapping("/save/contract")
   @PreAuthorize("@permission.check('crm_win_bid_project:add')")
   @SignerCheck(lockKey = "#crmWinningContractWarehousingSaveVO.crmProjectInformationWarehousingId", message = "该项目正在进行中标创建请稍后再试!!!")
   public ResultVO saveCrmWinningContractWarehousing(@RequestBody CrmWinningContractWarehousingSaveVO crmWinningContractWarehousingSaveVO) {
      log.info("API调用:中标项目新增");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .saveCrmWinningContractWarehousing(BeanUtil.copy(crmWinningContractWarehousingSaveVO, CrmWinningContractWarehousingSaveParam.class))
      );
   }

   @ApiOperation("中标项目新增(中南定制)")
   @PostMapping("/save/contract/custom")
   @PreAuthorize("@permission.check('crm_win_bid_project:add')")
   @SignerCheck(lockKey = "#crmWinningContractWarehousingSaveVOV2.crmProjectInformationWarehousingId", message = "该项目正在进行中标创建请稍后再试!!!")
   public ResultVO saveCrmWinningContractWarehousingCustom(@RequestBody CrmWinningContractWarehousingSaveVOV2 crmWinningContractWarehousingSaveVOV2) {
      log.info("API调用:中标项目新增(中南定制)");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .saveCrmWinningContractWarehousingCustom(BeanUtil.copy(crmWinningContractWarehousingSaveVOV2, CrmWinningContractWarehousingSaveParamV2.class))
      );
   }

   @ApiOperation("中标项目详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('crm_win_bid_project:detail')")
   public ResultVO<CrmWinningContractWarehousingDetailDTO> getContractDetail(@RequestParam("id") Long id) {
      log.info("API调用:中标项目详情");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getContractDetail(id));
   }

   @ApiOperation("中标项目详情下载")
   @GetMapping("/detail/down/load")
   @PreAuthorize("@permission.check('crm_win_bid_project:print')")
   public ResultVO getContractDetailDownLoad(@RequestParam("id") Long id, HttpServletResponse response) {
      log.info("API调用:中标项目详情下载");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getContractDetailDownLoad(id, response));
   }

   @ApiOperation("上传盖章合同")
   @PostMapping("/up/load/stamp/contract")
   @PreAuthorize("@permission.check('crm_win_bid_project:save')")
   public ResultVO upLoadStampContract(@RequestBody CrmUpLoadStampContractParam crmUpLoadStampContractParam) {
      log.info("API调用:上传盖章合同");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.upLoadStampContract(crmUpLoadStampContractParam));
   }

   @ApiOperation("专项方案管理列表(中南定制)")
   @GetMapping("/get/special/programs/list")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:get')")
   public ResultVO getSpecialProgramsList(
      Boolean reportingStatus,
      Integer crmSubmissionStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String projectNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:专项方案管理列表(中南定制)");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .getSpecialProgramsList(reportingStatus, crmSubmissionStatusEnum, startDate, endDate, projectName, projectNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("专案提报(中南定制)")
   @PostMapping("/save/special/programs")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:report')")
   public ResultVO saveSpecialPrograms(@RequestBody List<CrmSpecialProgramsSaveVO> crmSpecialProgramsSaveVO) {
      log.info("API调用:专案提报(中南定制)");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .saveSpecialPrograms(cn.hutool.core.bean.BeanUtil.copyToList(crmSpecialProgramsSaveVO, CrmSpecialProgramsSaveParam.class))
      );
   }

   @ApiOperation("专案提报详情(中南定制)")
   @GetMapping("/get/special/programs/detail")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:detail','crm_specifical_program_manage:report')")
   public ResultVO getSpecialProgramsDetail(@RequestParam("id") Long id) {
      log.info("API调用:专案提报详情(中南定制)");
      return ResultBuilder.success(this.crmWinningContractWarehousingBiz.getSpecialProgramsDetail(id));
   }

   @ApiOperation("非直营业务专案提报新增(中南定制)")
   @PostMapping("/save/non/direct/special/programs")
   @PreAuthorize("@permission.check('crm_technology_center_organize_list:add')")
   public ResultVO saveNonDirectSpecialPrograms(@RequestBody CrmNonDirectSpecialProgramsSaveVO crmNonDirectSpecialProgramsSaveVO) {
      log.info("API调用:非直营业务专案提报新增(中南定制)");
      return ResultBuilder.success(
         this.crmWinningContractWarehousingBiz
            .saveNonDirectSpecialPrograms(BeanUtil.copy(crmNonDirectSpecialProgramsSaveVO, CrmNonDirectSpecialProgramsSaveParam.class))
      );
   }
}
