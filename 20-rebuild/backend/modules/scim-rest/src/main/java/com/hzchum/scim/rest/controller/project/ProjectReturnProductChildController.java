package com.hzchum.scim.rest.controller.project;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ReturnProductStatusEnum;
import com.hzchum.scim.project.core.api.biz.ProjectReturnProductBiz;
import com.hzchum.scim.project.core.api.biz.ProjectWasteProductBiz;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductChildQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductQueryDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project/returnProductChild")
@Api(tags = "制成品退货子表")
public class ProjectReturnProductChildController {
   private static final Logger log = LoggerFactory.getLogger(ProjectReturnProductChildController.class);
   @Resource
   private ProjectReturnProductBiz projectReturnProductBiz;
   @Resource
   private ProjectWasteProductBiz projectWasteProductBiz;

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目ID", required = true, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "relationType", value = "关联类型", required = false, dataTypeClass = Integer.class)
      }
   )
   @GetMapping("/getReturnAndWaste")
   @ApiOperation("获取回收和报废的物品信息")
   @ApiImplicitParam(name = "id", value = "主键", required = true, dataTypeClass = Long.class)
   public ResultVO<PageVO<ProjectReturnProductChildDO>> getReturnAndWaste(
      ProjectReturnProductChildQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "2") Integer pageSize
   ) {
      log.info("Api调用:获取回收和报废的物品信息");
      return ResultBuilder.success(this.projectWasteProductBiz.listReturnAndWaste(param, pageNumber, pageSize));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "relationType", value = "关联类型", required = false, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "projectId", value = "项目id", required = true, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "monomerId", value = "单体id", required = false, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "areaId", value = "区域id", required = false, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "name", value = "名称", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "serialNumber", value = "编号", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "specification", value = "规格", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "material", value = "材质", required = false, dataTypeClass = String.class)
      }
   )
   @GetMapping("/projectReturnChildsByType")
   @ApiOperation("根据类型查询需要退货的产品")
   public ResultVO<PageVO<ProjectReturnProductChildDO>> projectReturnChildsByType(
      @Valid ProjectReturnProductQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:根据类型查询需要退货的产品");
      if (param.getStatus().equals(ReturnProductStatusEnum.SHIPPED.getType())) {
         return ResultBuilder.success(this.projectReturnProductBiz.listShipCanReturnProduct(param, pageNumber, pageSize));
      } else {
         return param.getStatus().equals(ReturnProductStatusEnum.WAREHOUSED.getType())
            ? ResultBuilder.success(this.projectReturnProductBiz.listWarehouseCanReturnProduct(param, pageNumber, pageSize))
            : ResultBuilder.success(this.projectReturnProductBiz.listSchedulingCanReturnProduct(param, pageNumber, pageSize));
      }
   }
}
