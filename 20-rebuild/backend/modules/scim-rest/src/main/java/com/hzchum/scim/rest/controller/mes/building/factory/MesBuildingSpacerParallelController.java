package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.plan.core.api.biz.TechMachinePartBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.MachinePartSpacerParallelDTOParam;
import com.hzchum.scim.plan.core.api.pojo.vo.TechMachinePartSpacerParallelSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "MES垫块配置")
@RestController
@RequestMapping("/api/mes/building/spacer/parallel")
public class MesBuildingSpacerParallelController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingSpacerParallelController.class);
   @Resource
   private TechMachinePartBiz techMachinePartBiz;

   @ApiOperation("获取MES垫块清单列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "thick", value = "厚度", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query")
      }
   )
   @GetMapping
   public ResultVO listByCondition(
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String thick,
      @RequestParam(required = false) String material
   ) {
      log.info("API 调用 ：获取MES垫块清单列表");
      return ResultBuilder.success(new ListVO<>(this.techMachinePartBiz.listSpacerByCondition(serialNumber, specification, thick, material)));
   }

   @ApiOperation("获取MES垫块配置分页列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "serialNumber", value = "编号", paramType = "query"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query"),
            @ApiImplicitParam(name = "thick", value = "厚度", paramType = "query"),
            @ApiImplicitParam(name = "material", value = "材质", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", defaultValue = "1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", defaultValue = "20", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", paramType = "query")
      }
   )
   @GetMapping("/page")
   public ResultVO listByConditionPage(
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) String specification,
      @RequestParam(required = false) String thick,
      @RequestParam(required = false) String material,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API 调用 ：获取MES垫块配置分页列表");
      return ResultBuilder.success(this.techMachinePartBiz.listSpacerByConditionPage(serialNumber, specification, thick, material, pageNumber, pageSize, sort));
   }

   @ApiOperation("获取MES垫块清单筛选条件")
   @GetMapping("/wait/condition")
   public ResultVO getScreeningCondition() {
      log.info("API 调用 ：获取MES垫块清单筛选条件");
      return ResultBuilder.success(this.techMachinePartBiz.getScreeningCondition());
   }

   @ApiOperation("批量新增MES垫块配置")
   @PostMapping
   public ResultVO saveSpacerParallelList(@RequestBody @Validated(Add.class) List<TechMachinePartSpacerParallelSaveVO> saveVOList) {
      log.info("API 调用 ：批量新增MES垫块配置");
      return ResultBuilder.success(
         this.techMachinePartBiz
            .saveSpacerParallelList(saveVOList.stream().map(e -> BeanUtil.copy(e, MachinePartSpacerParallelDTOParam.class)).collect(Collectors.toList()))
      );
   }

   @ApiOperation("批量删除MES垫块配置")
   @DeleteMapping
   public ResultVO removeSpacerParallel(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除MES垫块配置");
      return ResultBuilder.success(this.techMachinePartBiz.removeSpacerParallel(ids));
   }

   @ApiOperation(value = "上传垫块dxf文件", notes = "上传垫块dxf文件")
   @PostMapping("/struct/upload")
   public ResultVO uploadFileAndUnzip(@RequestPart MultipartFile file, @RequestParam Long id, @RequestParam Integer dataType) {
      log.info("API 调用 ：上传垫块dxf文件");
      return ResultBuilder.success(this.techMachinePartBiz.uploadFileAndUnzip(file, id, dataType));
   }

   @ApiOperation(value = "上传垫块dxf临时文件", notes = "上传垫块dxf临时文件")
   @PostMapping("/upload/temporary/files")
   public ResultVO uploadTemporaryFiles(@RequestPart MultipartFile file, @RequestParam Integer dataType) {
      log.info("API 调用 ： 上传垫块dxf临时文件");
      return ResultBuilder.success(this.techMachinePartBiz.uploadTemporaryFiles(file, dataType));
   }
}
