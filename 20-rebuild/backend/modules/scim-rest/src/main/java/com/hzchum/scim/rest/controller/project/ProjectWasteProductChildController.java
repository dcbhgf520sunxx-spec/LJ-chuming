package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.project.core.api.biz.ProjectWasteProductBiz;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductChildDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "退货管理-废品库子表 ")
@RestController
@RequestMapping("/api/project/wasteProductChild")
public class ProjectWasteProductChildController {
   private static final Logger log = LoggerFactory.getLogger(ProjectWasteProductChildController.class);
   @Resource
   private final ProjectWasteProductBiz projectWasteProductBiz;

   @ApiOperation("出库详情列表")
   @GetMapping("/getWasteProductChild")
   @PreAuthorize("@permission.check('waste_storage_record:detail')")
   public ResultVO<List<ProjectWasteProductChildDTO>> getWasteProductChild(@RequestParam("id") Long id) {
      log.info("Api调用:根据废品库主表id查询废品库子表查询, 查询参数id：{}", id);
      return ResultBuilder.success(this.projectWasteProductBiz.listWasteChildByMainId(id));
   }

   @ApiOperation("出库详情列表-打印")
   @GetMapping("/printById")
   @PreAuthorize("@permission.check('waste_storage_record:detailPrint')")
   public ResultVO<PrintVO<List<ProjectWasteProductChildDTO>>> printById(@RequestParam("id") Long id) {
      log.info("Api调用:根据废品库主表id打印废品库子表查询, 查询参数id：{}", id);
      return ResultBuilder.success(this.projectWasteProductBiz.printListWasteChild(id));
   }

   public ProjectWasteProductChildController(final ProjectWasteProductBiz projectWasteProductBiz) {
      this.projectWasteProductBiz = projectWasteProductBiz;
   }
}
