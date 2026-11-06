package com.hzchum.scim.rest.controller.crm;

import cn.hutool.core.bean.BeanUtil;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.crm.core.api.biz.CrmTechEntrustLinkBiz;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsApproveDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSpecialProgramsDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustLinkSaveDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTechEntrustProjectInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSpecialProgramsSaveParam;
import com.hzchum.scim.rest.pojo.vo.crm.CrmSpecialProgramsSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "crm-运营中心-技术委托")
@RestController
@RequestMapping("/api/crm/tech/entrust")
public class CrmTechEntrustLinkController {
   private static final Logger log = LoggerFactory.getLogger(CrmTechEntrustLinkController.class);
   @Resource
   private CrmTechEntrustLinkBiz crmTechEntrustLinkBiz;

   @ApiOperation("剩余可分配项目列表")
   @GetMapping("/remain/projet/list")
   @PreAuthorize("@permission.check('crm_technical_commission_design:add')")
   public ResultVO<List<CrmTechEntrustProjectInfoDTO>> remainProjectList() {
      log.info("API 调用 ：剩余可分配项目列表");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.listRemain());
   }

   @ApiOperation("可筛选项目列表")
   @GetMapping("/filterable/project/list")
   @PreAuthorize("@permission.check('crm_technical_commission_design:get','crm_specifical_program_manage:get')")
   public ResultVO<List<CrmTechEntrustProjectInfoDTO>> filterableProjectList() {
      log.info("API 调用 ：可筛选项目列表");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.filterableProjectList());
   }

   @ApiOperation("技术委托指定")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('crm_technical_commission_design:add')")
   public ResultVO<Boolean> save(@RequestBody CrmTechEntrustLinkSaveDTO crmTechEntrustLinkSaveDTO) {
      log.info("API 调用 ：技术委托指定");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.save(crmTechEntrustLinkSaveDTO));
   }

   @ApiOperation("技术委托删除")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('crm_technical_commission_design:del')")
   public ResultVO<Boolean> delete(@RequestBody List<Long> id) {
      log.info("API 调用 ：技术委托删除");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.delete(id));
   }

   @ApiOperation("技术委托列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('crm_technical_commission_design:get')")
   public ResultVO<PageVO<CrmTechEntrustLinkListDTO>> list(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer crmSettlementBusinessTypeEnum,
      Long crmProjectInformationWarehousingId,
      String userName,
      String createUserName,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：技术委托列表");
      return ResultBuilder.success(
         this.crmTechEntrustLinkBiz
            .list(startDate, endDate, crmSettlementBusinessTypeEnum, crmProjectInformationWarehousingId, userName, createUserName, pageNumber, pageSize)
      );
   }

   @ApiOperation("技术服务委托列表")
   @GetMapping("/get/tech/entrust/list")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:get')")
   public ResultVO<PageVO<CrmTechEntrustListDTO>> getTechEntrustList(
      Integer crmSubmissionStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String projectName,
      String projectNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:技术服务委托列表");
      return ResultBuilder.success(
         this.crmTechEntrustLinkBiz.getTechEntrustList(crmSubmissionStatusEnum, startDate, endDate, projectName, projectNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("技术服务委托详情")
   @GetMapping("/get/special/programs/detail")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:detail','crm_specifical_program_manage:report')")
   public ResultVO<List<CrmSpecialProgramsDetailDTO>> getSpecialProgramsDetail(@RequestParam("id") Long id) {
      log.info("API调用:技术服务委托详情");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.getSpecialProgramsDetail(id));
   }

   @ApiOperation("技术服务委托提报")
   @PostMapping("/save/special/programs")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:report')")
   public ResultVO saveSpecialPrograms(@RequestBody List<CrmSpecialProgramsSaveVO> crmSpecialProgramsSaveVO) {
      log.info("API调用:技术服务委托提报");
      return ResultBuilder.success(
         this.crmTechEntrustLinkBiz.saveSpecialPrograms(BeanUtil.copyToList(crmSpecialProgramsSaveVO, CrmSpecialProgramsSaveParam.class))
      );
   }

   @ApiOperation("技术服务委托提报详情(审批)")
   @GetMapping("/get/special/programs/approve/detail/{id}")
   @PreAuthorize("@permission.check('crm_specifical_program_manage:detail') or @crmAccess.readRecord(#id,120010,120011)")
   public ResultVO<CrmSpecialProgramsApproveDetailDTO> getSpecialProgramsApproveDetail(@PathVariable("id") Long id) {
      log.info("API调用:技术服务委托提报详情(审批)");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.getSpecialProgramsApproveDetail(id));
   }

   @ApiOperation("技术服务委托提报审批")
   @PostMapping("/special/programs/approve")
   @PreAuthorize("@crmAccess.approve(#crmAuditCommonDTO,120010,120011)")
   public ResultVO<Boolean> specialProgramsApprove(@RequestBody CrmAuditCommonDTO crmAuditCommonDTO) {
      log.info("API调用:技术服务委托提报审批");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.specialProgramsApprove(crmAuditCommonDTO));
   }

   @ApiOperation("技术服务委托提报撤销")
   @PostMapping("/special/programs/cancel")
   @PreAuthorize("@crmAccess.ownRecord(#id,120010,120011)")
   public ResultVO<Boolean> specialProgramsCancel(Long id) {
      log.info("API调用:技术服务委托提报撤销");
      return ResultBuilder.success(this.crmTechEntrustLinkBiz.specialProgramsCancel(id));
   }
}
