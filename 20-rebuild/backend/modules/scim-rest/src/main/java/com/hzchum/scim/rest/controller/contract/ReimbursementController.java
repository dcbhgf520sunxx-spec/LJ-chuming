package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementConfirmDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ReimbursementEditDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractReimbursementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-报销")
@RestController
@RequestMapping("/api/contract/reimbursement")
public class ReimbursementController {
   private static final Logger log = LoggerFactory.getLogger(ReimbursementController.class);
   @Resource
   private ContractReimbursementService reimbursementService;

   @ApiOperation("分页查询 报销列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "dateType", value = "日期类型 1填报日期 2确认日期 3申请日期 ", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "报销种类", paramType = "query"),
            @ApiImplicitParam(name = "applyDepartName", value = "申请部门", paramType = "query"),
            @ApiImplicitParam(name = "applyUserName", value = "申请人", paramType = "query"),
            @ApiImplicitParam(name = "writtenByName", value = "填报人", paramType = "query"),
            @ApiImplicitParam(name = "confirmStatus", value = "确认状态 1确认中 2通过 4驳回", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.desc")
      }
   )
   @GetMapping("/listPage")
   public ResultVO<PageVO<ReimbursementDTO>> listReimbursements(
      @RequestParam(defaultValue = "1") Integer dateType,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer type,
      @RequestParam(required = false) String applyDepartName,
      @RequestParam(required = false) String applyUserName,
      @RequestParam(required = false) String writtenByName,
      @RequestParam(required = false) Integer confirmStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(value = "sort", defaultValue = "id.desc") List<String> sort
   ) {
      log.info("Api调用: 查询报销列表");
      return ResultBuilder.success(
         this.reimbursementService
            .listReimbursements(
               dateType, startDate, endDate, projectId, type, applyDepartName, applyUserName, writtenByName, confirmStatus, pageNumber, pageSize, sort
            )
      );
   }

   @ApiOperation("打印报销列表")
   @GetMapping("/listPage/print")
   public ResultVO listReimbursements(
      @RequestParam(defaultValue = "1") Integer dateType,
      @RequestParam(required = false) LocalDate startDate,
      @RequestParam(required = false) LocalDate endDate,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer type,
      @RequestParam(required = false) String applyDepartName,
      @RequestParam(required = false) String applyUserName,
      @RequestParam(required = false) String writtenByName,
      @RequestParam(required = false) Integer confirmStatus
   ) {
      log.info("Api调用: 打印报销列表");
      return ResultBuilder.success(
         this.reimbursementService
            .printReimbursements(dateType, startDate, endDate, projectId, type, applyDepartName, applyUserName, writtenByName, confirmStatus)
      );
   }

   @ApiOperation("查询报销总额")
   @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query")
   @GetMapping("/getSumPayAmount")
   public ResultVO getSumPayAmount(@RequestParam(required = false) Long projectId) {
      log.info("Api调用: 查询报销总额");
      return ResultBuilder.success(this.reimbursementService.getSumActuallyPayAmount(projectId));
   }

   @ApiOperation("新增报销填报")
   @PostMapping("/save")
   public ResultVO saveReimbursement(@RequestBody @Valid ReimbursementSaveDTOParam saveDTOParam) {
      log.info("Api调用: 新增报销");
      return ResultBuilder.success(this.reimbursementService.saveReimbursement(saveDTOParam));
   }

   @ApiOperation("修改(重新编辑)报销填报")
   @PutMapping("/update")
   public ResultVO updateReimbursement(@RequestBody @Valid ReimbursementEditDTOParam updateDTOParam) {
      log.info("Api调用: 重新编辑-报销填报");
      return ResultBuilder.success(this.reimbursementService.updateReimbursement(updateDTOParam));
   }

   @ApiOperation("确认报销")
   @PutMapping("/confirm")
   public ResultVO confirmReimbursement(@RequestBody @Valid ReimbursementConfirmDTOParam confirmDTOParam) {
      log.info("Api调用: 确认报销");
      return ResultBuilder.success(this.reimbursementService.confirmReimbursement(confirmDTOParam));
   }
}
