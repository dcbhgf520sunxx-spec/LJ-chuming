package com.hzchum.scim.rest.controller.plan;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.IdsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.WeldMapDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.AreaDrawingDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.DownloadDrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.ProductDrawingsSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mark.WeldDetailsDTO;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "计划管理-技术资料")
@RestController
@RequestMapping("/api/plan/drawing")
public class DrawingApi {
   private static final Logger log = LoggerFactory.getLogger(DrawingApi.class);
   @Resource
   private TechDrawingService drawingService;

   @ApiOperation("根据条件获取图纸列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "文件编号", paramType = "query"),
            @ApiImplicitParam(name = "fileName", value = "文件名称", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = " 产品类型 1零件 2构件 16组立(深化图纸必传)", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query", defaultValue = "id.asc")
      }
   )
   @GetMapping("/struct")
   @PreAuthorize("@permission.check('plan_change_file:get','plan_blueprint:get')")
   public ResultVO<PageVO<DrawingDTO>> listDrawingByCondition(
      @RequestParam Long projectId,
      Long monomerId,
      String serialNumber,
      String fileName,
      @RequestParam Integer dataType,
      Integer productType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(defaultValue = "id.asc") List<String> sort
   ) {
      log.info("API 调用 ：根据条件获取图纸列表");
      PageVO<DrawingDTO> pageVO = this.drawingService
         .listDrawingByCondition(projectId, monomerId, serialNumber, fileName, dataType, productType, pageNumber, pageSize, sort);
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation(value = "上传技术资料(.zip,单个文件)", notes = "上传技术资料(.zip,单个文件)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "  产品类型 (建钢项目) 1零件 2构件 16组立 (桥梁项目)1分段件 2单元件 4零件 (深化图纸必传)", paramType = "query")
      }
   )
   @PostMapping("/struct/upload")
   @PreAuthorize(
      "@permission.check('plan_blueprint:import','plan_change_file:import','plan_model_file:import','plan_drawing_file:import','plan_cnc_file:import','plan_xml_file:import')"
   )
   @SignerCheck(lockKey = "#projectId", boolMethodAndClassName = true, message = "该项目正在上传图纸中,请稍后刷新重试!", timeout = 200L)
   public ResultVO uploadFileAndUnzip(
      @RequestParam Long projectId,
      @RequestPart MultipartFile file,
      Long monomerId,
      @RequestParam Integer dataType,
      Integer productType,
      String fileName,
      @RequestParam(required = false) Long areaId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：上传构件/零件或者围护的图纸并解压");
      return ResultBuilder.success(this.drawingService.uploadFileAndUnzip(file, projectId, monomerId, dataType, productType, fileName, null, areaId, response));
   }

   @ApiOperation(value = "上传技术资料(.zip,单个文件)", notes = "上传技术资料(.zip,单个文件)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "  产品类型 (建钢项目) 1零件 2构件 16组立 (桥梁项目)1分段件 2单元件 4零件 (深化图纸必传)", paramType = "query")
      }
   )
   @PostMapping("/struct/upload/all")
   @SignerCheck(lockKey = "#projectId", boolMethodAndClassName = true, message = "该项目正在上传图纸中,请稍后刷新重试!", timeout = 200L)
   public ResultVO uploadAllFileAndUnzip(
      @RequestParam Long projectId,
      @RequestPart MultipartFile file,
      Long monomerId,
      @RequestParam Integer dataType,
      Integer productType,
      String fileName,
      @RequestParam(required = false) Long areaId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：上传构件/零件或者围护的图纸并解压");
      return ResultBuilder.success(
         this.drawingService.uploadAllFileAndUnzip(file, projectId, monomerId, dataType, productType, fileName, null, areaId, response)
      );
   }

   @ApiOperation(value = "上传技术资料(.zip,单个文件)套料使用", notes = "上传技术资料(.zip,单个文件)套料使用")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "  产品类型 (建钢项目) 1零件 2构件 16组立 (桥梁项目)1分段件 2单元件 4零件 (深化图纸必传)", paramType = "query")
      }
   )
   @PostMapping("/struct/nestingUpload")
   @PreAuthorize(
      "@permission.check('plan_blueprint:import','plan_change_file:import','plan_model_file:import','plan_drawing_file:import','plan_cnc_file:import','plan_xml_file:import')"
   )
   @SignerCheck(lockKey = "#projectId", boolMethodAndClassName = true, message = "该项目正在上传图纸中,请稍后刷新重试!", timeout = 200L)
   public ResultVO nestingUploadFileAndUnzip(
      @RequestParam Long projectId,
      @RequestPart MultipartFile file,
      Long monomerId,
      Long areaId,
      @RequestParam Integer dataType,
      Integer productType,
      String fileName,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：上传构件/零件或者围护的图纸并解压");
      return ResultBuilder.success(this.drawingService.nestingUploadFileAndUnzip(file, projectId, monomerId, areaId, dataType, productType, fileName, response));
   }

   @ApiOperation(value = "上传技术资料zip自动筛选", notes = "上传技术资料zip自动筛选")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "  产品类型 (建钢项目) 1零件 2构件 16组立 (桥梁项目)1分段件 2单元件 4零件 (深化图纸必传)", paramType = "query")
      }
   )
   @PostMapping("/struct/upload/choose")
   @PreAuthorize(
      "@permission.check('plan_blueprint:import','plan_change_file:import','plan_model_file:import','plan_drawing_file:import','plan_cnc_file:import','plan_xml_file:import')"
   )
   @SignerCheck(lockKey = "#projectId", boolMethodAndClassName = true, message = "该项目正在上传图纸中,请稍后刷新重试!", timeout = 200L)
   public ResultVO uploadZipFileChoose(
      @RequestParam Long projectId,
      @RequestPart MultipartFile file,
      Long monomerId,
      Long areaId,
      @RequestParam Integer dataType,
      Integer productType,
      String fileName,
      HttpServletResponse response
   ) throws Exception {
      log.info("API 调用 ：上传技术资料zip自动筛选");
      return ResultBuilder.success(
         this.drawingService.newUploadZipFileChoose(file, projectId, monomerId, areaId, dataType, productType, fileName, null, response)
      );
   }

   @ApiOperation("修改(替换)技术资料")
   @PutMapping("/struct/compile")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "技术资料id", paramType = "query", required = true),
            @ApiImplicitParam(name = "fileName", value = "文件命名", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('plan_blueprint:edit','plan_change_file:edit')")
   public ResultVO compileFileAndUnzip(@RequestParam Long id, @RequestPart MultipartFile multipartFile, String fileName, Long monomerId) {
      log.info("API 调用 ：修改(替换)技术资料或图纸");
      return ResultBuilder.success(this.drawingService.newUpdateDrawing(id, multipartFile, fileName, null));
   }

   @ApiOperation(value = "删除技术资料", notes = "删除技术资料")
   @DeleteMapping("/struct")
   @PreAuthorize("@permission.check('plan_blueprint:edit','plan_change_file:edit')")
   public ResultVO deleteDrawings(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除技术资料(图纸)");
      return ResultBuilder.success(this.drawingService.deleteDrawings(ids));
   }

   @ApiOperation(value = "根据产品id和产品类型,下载(预览)深化图纸", notes = "根据产品id下载(预览)深化图纸")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型 (建钢) 1零件 2构件 16组立 (桥梁) 1分段 2单元 4零件", paramType = "query", required = true),
            @ApiImplicitParam(name = "number", value = "构件序列号", paramType = "query")
      }
   )
   @GetMapping("/product")
   public void downloadFileByProduct(
      @RequestParam(defaultValue = "1") Integer projectType,
      @RequestParam(required = false) Long productId,
      @RequestParam Integer productType,
      @RequestParam(required = false) Integer number,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId
   ) {
      log.info("API 调用 ：根据产品id下载图纸");
      this.drawingService.downloadFileByProduct(projectType, productId, productType, number, serialNumber, monomerId, areaId);
   }

   @ApiOperation(value = "根据产品编号和产品类型,下载(预览)深化图纸", notes = "根据产品id下载(预览)深化图纸")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "serialNumber", value = "产品编号", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型 (建钢) 1零件 2构件 16组立 (桥梁) 1分段 2单元 4零件", paramType = "query", required = true),
            @ApiImplicitParam(name = "number", value = "构件序列号", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体Id", paramType = "query")
      }
   )
   @GetMapping("/product/serialNumber")
   @PreAuthorize("@permission.check('plan_drawing_file:detail')")
   public void downloadFileByProduct(
      @RequestParam(defaultValue = "1") Integer projectType,
      @RequestParam String serialNumber,
      @RequestParam Integer productType,
      @RequestParam(required = false) Integer number,
      @RequestParam Long monomerId,
      @RequestParam(required = false) Long areaId
   ) {
      log.info("API 调用 ：根据产品编号下载图纸");
      this.drawingService.downloadFileBySerialNumber(projectType, serialNumber, productType, number, monomerId, areaId);
   }

   @ApiOperation(value = "根据资料id下载图纸", notes = "根据图纸id下载图纸")
   @ApiImplicitParam(name = "id", value = "资料id", paramType = "path", required = true)
   @GetMapping("/struct/{id}/export")
   @PreAuthorize("@permission.check('plan_blueprint:download','plan_change_file:download')")
   public void downloadFileByDrawing(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据资料id下载资料");
      this.drawingService.downloadFileByDrawing(id);
   }

   @ApiOperation(value = "app图纸预览", notes = "图纸预览")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "number", value = "构件序列号", paramType = "query")
      }
   )
   @GetMapping("/app/pdf/preview")
   public void downloadAppFilePreview(
      @RequestParam(defaultValue = "1") Integer projectType, @RequestParam Long productId, @RequestParam Integer productType, Integer number
   ) {
      log.info("API 调用 ：图纸预览");
      this.drawingService.downloadFileByProduct(projectType, productId, productType, number, null, null, null);
   }

   @ApiOperation("根据项目id或单体id下载资料")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = " (深化图时必传)产品类型 1零件 2构件 16组立", paramType = "query")
      }
   )
   @GetMapping("/struct/export")
   public void downloadFileByProjectId(@RequestParam Long projectId, Long monomerId, Long areaId, @RequestParam Integer dataType, Integer productType) {
      log.info("API 调用 ：根据单体id下载图纸");
      this.drawingService.downloadFileByMonomerId(projectId, monomerId, areaId, dataType, productType);
   }

   @ApiOperation(value = "根据产品id校验深化图纸是否存在", notes = "根据产品id校验深化图纸是否存在")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型 【1：零件 2：构件 16 组立】【1：分段 2：单元件 16 零件】 ", paramType = "query", required = true)
      }
   )
   @GetMapping("/product/check")
   public ResultVO<Map<String, Object>> checkDrawingExist(
      @RequestParam(defaultValue = "1") Integer projectType, @RequestParam Long productId, @RequestParam Integer productType
   ) {
      log.info("API 调用 ：根据产品id校验深化图纸是否存在");
      return ResultBuilder.success(this.drawingService.checkDrawingExist(projectType, productId, productType));
   }

   @ApiOperation(value = "app获取构件图纸的序列号", notes = "app获取构件图纸的序列号")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true)
      }
   )
   @GetMapping("/app/num")
   public ResultVO getArtifactDwgNum(@RequestParam Long productId, @RequestParam Integer productType, @RequestParam(defaultValue = "1") Integer projectType) {
      log.info("API 调用 ：app获取构件图纸的序列号");
      return ResultBuilder.success(this.drawingService.getArtifactDwgNum(projectType, productId, productType));
   }

   @ApiOperation(value = "pc获取构件图纸的序列号", notes = "pc获取构件图纸的序列号")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true)
      }
   )
   @GetMapping("/pc/num")
   public ResultVO getArtifactDwgNumByPc(@RequestParam Long productId, @RequestParam Integer productType, @RequestParam(defaultValue = "1") Integer projectType) {
      log.info("API 调用 ：pc获取构件图纸的序列号");
      return ResultBuilder.success(this.drawingService.getArtifactDwgNum(projectType, productId, productType));
   }

   @ApiOperation(value = "根据项目获取单体下文件总数", notes = "根据项目获取单体下文件总数")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @GetMapping("/drawing/data")
   @PreAuthorize("@permission.check('plan_drawing_file:get','plan_cnc_file:get','plan_xml_file:get')")
   public ResultVO<PageVO<ProductDrawingsSummaryDTO>> getArtifactDwg(
      @RequestParam Long projectId,
      @RequestParam Integer productType,
      @RequestParam Integer pageSize,
      @RequestParam Integer pageNumber,
      @RequestParam Integer dataType,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId
   ) {
      log.info("API 调用 ：根据项目获取单体下文件总数");
      return ResultBuilder.success(
         this.drawingService.getArtifactDwg(projectId, productType, dataType, steelPlateTypeEnum, monomerId, areaId, pageSize, pageNumber)
      );
   }

   @ApiOperation("下载零件DXF压缩包")
   @GetMapping("/download/dxfzip")
   @PreAuthorize("@permission.check('plan_cnc_file:download')")
   public void downloadMachinePartDxfFile(Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：下载零件DXF压缩包");
      this.drawingService.downloadMachinePartDxfFile(projectId, monomerId, areaId);
   }

   @ApiOperation("下载深化PDF")
   @GetMapping("/download/pdf")
   @PreAuthorize("@permission.check('plan_drawing_file:drawingZipDownload')")
   public void downloadDrawingPDF(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException {
      log.info("API 调用 ：下载深化PDF");
      this.drawingService.downloadDrawingPDF(projectId, monomerId, serialNumber, taskTypeEnum, response);
   }

   @ApiOperation("下载深化PDF焊缝MARK压缩包")
   @GetMapping("/download/pdfzip")
   @PreAuthorize("@permission.check('plan_drawing_file:drawingZipDownload')")
   public void downloadDrawingPDFFile(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, DownloadDrawingDTO drawingDTO, Integer taskTypeEnum, HttpServletResponse response
   ) throws IOException {
      log.info("API 调用 ：下载深化PDF焊缝MARK压缩包");
      this.drawingService.downloadDrawingPDFFile(projectId, monomerId, areaId, areaBatchId, drawingDTO, taskTypeEnum, response);
   }

   @ApiOperation("下载深化PDF压缩包")
   @GetMapping("/all/download/pdfzip")
   public void downloadAllDrawingPDFFile(
      Long projectId, Long monomerId, Long areaId, Long areaBatchId, DownloadDrawingDTO drawingDTO, Integer taskTypeEnum, HttpServletResponse response
   ) throws IOException {
      log.info("API 调用 ：下载深化PDF焊缝MARK压缩包");
      this.drawingService.downloadAllDrawingPDFFile(projectId, monomerId, areaId, areaBatchId, drawingDTO, taskTypeEnum, response);
   }

   @ApiOperation(value = "根据项目获取产品文件列表比对", notes = "根据项目获取产品图纸列表比对")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @PreAuthorize("@permission.check('plan_xml_file:detail','plan_cnc_file:detail','plan_drawing_file:detail')")
   @GetMapping("/drawing/contrast")
   public ResultVO<PageVO<AreaDrawingDetailsDTO>> contrast(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      Long areaBatchId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      Boolean sign,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      String userName
   ) {
      log.info("API 调用 ：根据项目获取产品图纸列表比对");
      return ResultBuilder.success(
         this.drawingService
            .contrast(projectId, monomerId, areaId, areaBatchId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, pageNumber, pageSize)
      );
   }

   @ApiOperation(value = "根据项目获取产品文件列表比对（下载）", notes = "根据项目获取产品图纸列表比对（下载）")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @PreAuthorize("@permission.check('plan_drawing_file:download')")
   @GetMapping(value = "/drawing/contrast/download", produces = "application/octet-stream")
   public void contrastDownload(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      Long areaBatchId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      Boolean sign,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      String userName
   ) {
      log.info("API 调用 ：根据项目获取产品图纸列表比对（下载）");
      this.drawingService
         .contrastDownload(
            projectId, monomerId, areaId, areaBatchId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, pageNumber, pageSize
         );
   }

   @ApiOperation(value = "批量删除技术资料", notes = "批量删除技术资料")
   @DeleteMapping("/delete")
   @PreAuthorize("@permission.check('plan_xml_file:del','plan_cnc_file:del','plan_drawing_file:del')")
   public ResultVO deleteDrawing(@RequestBody IdsDTO ids) {
      log.info("API 调用 ：批量删除技术资料(图纸)");
      return ResultBuilder.success(this.drawingService.deleteDrawing(ids));
   }

   @ApiOperation(value = "批量删除深化技术资料", notes = "批量删除深化技术资料")
   @DeleteMapping("/deepen/delete")
   @PreAuthorize("@permission.check('plan_xml_file:del','plan_cnc_file:del','plan_drawing_file:del')")
   public ResultVO deleteDeepenDrawing(@RequestBody IdsDTO ids) {
      log.info("API 调用 ：批量删除深化技术资料(图纸)");
      return ResultBuilder.success(this.drawingService.deleteDrawing(ids));
   }

   @ApiOperation(value = "工艺文件关联信息查询", notes = "工艺文件关联信息查询")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "drawingid", value = "图纸id"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @GetMapping("/drawing/InstructionLink")
   public ResultVO<PageVO<AreaDrawingDetailsDTO>> InstructionLink(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      @RequestParam Integer drawingid,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：工艺文件关联信息查询");
      return ResultBuilder.success(
         this.drawingService.InstructionLink(projectId, monomerId, areaId, productType, serialNumber, dataType, drawingid, pageNumber, pageSize)
      );
   }

   @ApiOperation("修改(替换)技术资料")
   @PutMapping("/struct/update")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "fileName", value = "文件命名", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML 32技术指导书", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = " 产品类型 1零件 2构件 16组立", paramType = "query")
      }
   )
   public ResultVO updateFile(
      @RequestParam Long productId,
      @RequestParam Integer productType,
      @RequestParam Integer dataType,
      @RequestPart MultipartFile file,
      Long projectId,
      Long monomerId,
      Long areaId
   ) throws Exception {
      log.info("API 调用 ：修改(替换)技术资料或图纸");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultBuilder.success(this.drawingService.updateFile(productId, productType, dataType, file, projectId, monomerId, areaId, null));
   }

   @ApiOperation("修改(替换)技术资料(套料)")
   @PutMapping("/struct/nestingUpdate")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "fileName", value = "文件命名", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "projectid", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML 32技术指导书", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = " 产品类型 1零件 2构件 16组立", paramType = "query")
      }
   )
   public ResultVO nestingUpdateFile(
      @RequestParam Long productId,
      @RequestParam Integer productType,
      @RequestParam Integer dataType,
      @RequestPart MultipartFile file,
      Long projectId,
      Long monomerId,
      Long areaId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：修改(替换)技术资料或图纸");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultBuilder.success(this.drawingService.nestingUpdateFile(productId, productType, dataType, file, projectId, monomerId, areaId, response));
   }

   @ApiOperation(value = "capp 焊缝匹配信息列表", notes = "capp 焊缝匹配信息列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @GetMapping("/weld/contrast")
   public ResultVO<PageVO<WeldDetailsDTO>> weldContrast(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      Boolean sign,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      String userName
   ) {
      log.info("API 调用 ：capp 焊缝匹配信息");
      return ResultBuilder.success(
         this.drawingService
            .weldContrast(projectId, monomerId, areaId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, pageNumber, pageSize)
      );
   }

   @ApiOperation("下载焊缝Mark文件")
   @GetMapping("/download/mark")
   public void downloadWeldMark(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException {
      log.info("API 调用 ：下载焊缝Mark文件");
      this.drawingService.downloadWeldMark(projectId, monomerId, serialNumber, taskTypeEnum, response);
   }

   @ApiOperation(value = "批量删除焊缝Mark资料", notes = "批量删除焊缝Mark资料")
   @DeleteMapping("/deepen/mark/delete")
   public ResultVO deleteDeepenMark(@RequestBody IdsDTO ids) {
      log.info("API 调用 ：批量删除焊缝Mark资料");
      return ResultBuilder.success(this.drawingService.deleteDeepenMark(Arrays.asList(ids)));
   }

   @ApiOperation("修改(替换)焊缝Mark资料")
   @PutMapping("/struct/mark/update")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "fileName", value = "文件命名", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML 32技术指导书", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = " 产品类型 1零件 2构件 16组立", paramType = "query")
      }
   )
   public ResultVO updateMarkFile(
      @RequestParam Long productId,
      @RequestParam Integer productType,
      @RequestParam Integer dataType,
      @RequestPart MultipartFile file,
      Long projectId,
      Long monomerId,
      Long areaId
   ) throws Exception {
      log.info("API 调用 ：修改(替换)焊缝Mark资料");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultBuilder.success(this.drawingService.updateMarkFile(productId, productType, dataType, file, projectId, monomerId, areaId));
   }

   @ApiOperation(value = "根据项目获取产品焊缝列表比对（下载）", notes = "根据项目获取产品焊缝列表比对（下载）")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @GetMapping(value = "/weld/contrast/download", produces = "application/octet-stream")
   public void weldContrastDownload(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      Boolean sign,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      String userName
   ) {
      log.info("API 调用 ：根据项目获取产品焊缝列表比对（下载）");
      this.drawingService
         .weldContrastDownload(projectId, monomerId, areaId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, pageNumber, pageSize);
   }

   @ApiOperation(value = "上传焊缝地图技术资料(.zip,单个文件)", notes = "上传焊缝地图技术资料(.zip,单个文件)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "  产品类型 (建钢项目) 1零件 2构件 16组立 (桥梁项目)1分段件 2单元件 4零件 (深化图纸必传)", paramType = "query")
      }
   )
   @PostMapping("weld/map/struct/upload")
   @SignerCheck(lockKey = "#projectId", boolMethodAndClassName = true, message = "该项目正在上传焊缝地图中,请稍后刷新重试!", timeout = 200L)
   public ResultVO uploadWeldMapFileAndUnzip(
      @RequestParam Long projectId,
      @RequestPart MultipartFile file,
      Long monomerId,
      @RequestParam Integer dataType,
      Integer productType,
      String fileName,
      @RequestParam(required = false) Long areaId,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：上传构件/部件的焊缝地图并解压");
      return ResultBuilder.success(
         this.drawingService.newUploadWeldMapFileAndUnzip(file, projectId, monomerId, dataType, productType, fileName, null, areaId, response)
      );
   }

   @ApiOperation(value = "capp 焊缝地图匹配信息", notes = "capp 焊缝地图匹配信息")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @GetMapping("/weld/map/contrast")
   public ResultVO<PageVO<WeldMapDetailsDTO>> weldMapContrast(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      Boolean sign,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      String userName
   ) {
      log.info("API 调用 ：capp 焊缝地图匹配信息");
      return ResultBuilder.success(
         this.drawingService
            .weldMapContrast(projectId, monomerId, areaId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, pageNumber, pageSize)
      );
   }

   @ApiOperation("下载焊缝地图文件")
   @GetMapping("/download/weld/map")
   public void downloadWeldMap(Long projectId, Long monomerId, String serialNumber, Integer taskTypeEnum, HttpServletResponse response) throws UnsupportedEncodingException {
      log.info("API 调用 ：下载焊缝地图文件");
      this.drawingService.downloadWeldMap(projectId, monomerId, serialNumber, taskTypeEnum, response);
   }

   @ApiOperation(value = "批量删除焊缝地图资料", notes = "批量删除焊缝地图资料")
   @DeleteMapping("/deepen/weld/map/delete")
   public ResultVO deleteDeepenWeldMap(@RequestBody IdsDTO ids) {
      log.info("API 调用 ：批量删除焊缝地图资料");
      return ResultBuilder.success(this.drawingService.deleteDeepenWeldMap(Arrays.asList(ids)));
   }

   @ApiOperation("修改(替换)焊缝地图资料")
   @PutMapping("/struct/mark/map/update")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "fileName", value = "文件命名", paramType = "query"),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16XML 32技术指导书", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = " 产品类型 1零件 2构件 16组立", paramType = "query")
      }
   )
   public ResultVO updateMarkMapFile(
      @RequestParam Long productId,
      @RequestParam Integer productType,
      @RequestParam Integer dataType,
      @RequestPart MultipartFile file,
      Long projectId,
      Long monomerId,
      Long areaId
   ) throws Exception {
      log.info("API 调用 ：修改(替换)焊缝地图资料");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultBuilder.success(this.drawingService.updateMarkMapFile(productId, productType, dataType, file, projectId, monomerId, areaId));
   }

   @ApiOperation(value = "根据项目获取产品焊缝地图列表比对（下载）", notes = "根据项目获取产品焊缝列表地图比对（下载）")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "areaId", value = "区域id"),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true),
            @ApiImplicitParam(name = "serialNumber", value = "编号"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件 32工艺文件", paramType = "query", required = true)
      }
   )
   @GetMapping(value = "/weld/map/contrast/download", produces = "application/octet-stream")
   public void weldMapContrastDownload(
      @RequestParam Long projectId,
      @RequestParam Long monomerId,
      Long areaId,
      @RequestParam Integer productType,
      String serialNumber,
      @RequestParam Integer dataType,
      Boolean sign,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize,
      @RequestParam(required = false) Integer steelPlateTypeEnum,
      String userName
   ) {
      log.info("API 调用 ：根据项目获取产品焊缝地图列表比对（下载）");
      this.drawingService
         .weldMapContrastDownload(projectId, monomerId, areaId, productType, serialNumber, dataType, sign, steelPlateTypeEnum, userName, pageNumber, pageSize);
   }

   @ApiOperation(value = "根据产品id和产品类型,下载(预览)焊缝地图图纸", notes = "根据产品id下载(预览)焊缝地图图纸")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型 (建钢) 1零件 2构件 16组立 (桥梁) 1分段 2单元 4零件", paramType = "query", required = true),
            @ApiImplicitParam(name = "number", value = "构件序列号", paramType = "query")
      }
   )
   @GetMapping("/map/product")
   public void downloadFileByMapProduct(
      @RequestParam(defaultValue = "1") Integer projectType,
      @RequestParam(required = false) Long productId,
      @RequestParam Integer productType,
      @RequestParam(required = false) Integer number,
      @RequestParam(required = false) String serialNumber,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId
   ) {
      log.info("API 调用 ：根据产品id下载(预览)焊缝地图图纸");
      this.drawingService.downloadFileByMapProduct(projectType, productId, productType, number, serialNumber, monomerId, areaId);
   }

   @ApiOperation(value = "app获取构件焊缝地图图纸的序列号", notes = "app获取构件焊缝地图图纸的序列号")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "类型 2构件 1零件 16组立", paramType = "query", required = true)
      }
   )
   @GetMapping("/map/app/num")
   public ResultVO getArtifactMapDwgNum(@RequestParam Long productId, @RequestParam Integer productType, @RequestParam(defaultValue = "1") Integer projectType) {
      log.info("API 调用 ：app获取构件焊缝地图图纸的序列号");
      return ResultBuilder.success(this.drawingService.getArtifactMapDwgNum(projectType, productId, productType));
   }
}
