package com.hzchum.scim.rest.controller.wms.wmsReport;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.SupplementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-红冲记录")
@RestController
@RequestMapping("/api/wms/report/raw-materials/supplement")
public class SupplementController {
   private static final Logger log = LoggerFactory.getLogger(SupplementController.class);
   @Resource
   SupplementService supplementService;

   @ApiOperation("报表-红冲记录查询")
   @GetMapping("/details")
   @PreAuthorize("@permission.check('wms_report_rawMat_supplement_details:get')")
   public ResultVO detailList(
      QueryDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：报表-红冲记录查询");
      return ResultBuilder.success(this.supplementService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID查询红冲记录")
   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('wms_report_rawMat_supplement_details:detail')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查询红冲记录");
      return ResultBuilder.success(this.supplementService.selectById(id));
   }
}
