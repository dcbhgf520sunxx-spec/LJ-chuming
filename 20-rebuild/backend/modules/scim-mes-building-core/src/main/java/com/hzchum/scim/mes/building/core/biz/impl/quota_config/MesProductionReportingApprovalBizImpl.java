package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesProductionReportingApprovalBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassed;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalTeamReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovedParam;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalPassedService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesProductionReportingApprovalBizImpl implements MesProductionReportingApprovalBiz {
   @Autowired
   private MesProductionReportingApprovalPassedService passedService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesQuotaConfigArtifactService quotaConfigArtifactService;

   @Override
   public List<MesProductionReportingApprovalDateDTO> dateExistsUnapprovedDataList(MesProductionReportingApprovalQuery query) {
      return this.passedService.dateExistsUnapprovedDataList(query);
   }

   @Override
   public List<MesProductionReportingApprovalDateDTO> dateExistsApprovedDataList(MesProductionReportingApprovalQuery query) {
      return this.passedService.dateExistsApprovedDataList(query);
   }

   @Override
   public List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportSummaryList(MesProductionReportingApprovalQuery query) {
      return this.passedService.teamReportSummaryList(query);
   }

   @Override
   public List<MesProductionReportingApprovalTeamReportSummaryDTO> teamReportApprovedSummaryList(MesProductionReportingApprovalQuery query) {
      return this.passedService.teamReportApprovedSummaryList(query);
   }

   @Override
   public PageVO<MesProductionReportingApprovalReportSummaryDTO> unapprovedPage(
      MesProductionReportingApprovalQuery query, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesProductionReportingApprovalReportSummaryDTO> list = this.passedService.unapprovedList(query);
      return new PageVO<>(page, list);
   }

   @Override
   public PageVO<MesProductionReportingApprovalReportSummaryDTO> approvedPage(
      MesProductionReportingApprovalQuery query, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesProductionReportingApprovalReportSummaryDTO> list = this.passedService.approvedList(query);
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalPassed(MesProductionReportingApprovalPassedParam param) {
      return this.passedService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchApprovalPassed(List<MesProductionReportingApprovalPassedParam> paramList) {
      paramList.forEach(this.passedService::add);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvedEdit(MesProductionReportingApprovedParam param) {
      MesProductionReportingApprovalPassed passed = this.passedService.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(passed), "数据不存在, 请刷新后重试");
      MesProductionReportingApprovalPassed newPassed = BeanUtil.toBean(param, MesProductionReportingApprovalPassed.class);
      this.passedService.updateById(newPassed);
      return true;
   }

   @Override
   public void approvedRecordExport(MesProductionReportingApprovalQuery query, HttpServletResponse response) {
      try {
         List<Map<String, Object>> list = new ArrayList<>();

         try {
            for (MesProductionReportingApprovalTeamReportSummaryDTO summaryDTO : this.teamReportApprovedSummaryList(query)) {
               MesProductionReportingApprovalQuery approvedListQuery = new MesProductionReportingApprovalQuery();
               approvedListQuery.setYearMonth(query.getYearMonth());
               approvedListQuery.setDate(query.getDate());
               approvedListQuery.setWorkshopId(summaryDTO.getWorkshop().getId());
               approvedListQuery.setProductTypeEnum(summaryDTO.getProductTypeEnum());
               approvedListQuery.setProcessId(summaryDTO.getProcess().getId());
               approvedListQuery.setTeamId(summaryDTO.getTeam().getId());
               List<MesProductionReportingApprovalReportSummaryDTO> approvedList = this.passedService.approvedList(approvedListQuery);
               List<Map<String, Object>> mapList = approvedList.stream()
                  .map(
                     i -> {
                        Map<String, Object> map = BeanUtil.beanToMap(i);
                        String productTypeEnumName = ProductTypeEnum.getNameByType(summaryDTO.getProductTypeEnum());
                        if (Objects.equals(ProductTypeEnum.ASSEMBLE.getType(), summaryDTO.getProductTypeEnum())) {
                           productTypeEnumName = "部件";
                        }

                        map.put("productTypeEnumName", productTypeEnumName);
                        if (Objects.equals(ProductTypeEnum.MACHINE_PART.getType(), summaryDTO.getProductTypeEnum())) {
                           String partTypeName = "";
                           if (Objects.equals(ProductClassificationEnum.SECTION_PRODUCT.getType(), i.getProduct().getProductClassificationEnum())) {
                              partTypeName = "型材零件";
                           }

                           if (Objects.equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType(), i.getProduct().getProductClassificationEnum())) {
                              partTypeName = "板材零件";
                           }

                           map.put("partTypeName", partTypeName);
                        }

                        map.put(
                           "projectShow",
                           StrUtil.blankToDefault(i.getProject().getSerialNumber(), "") + " - " + StrUtil.blankToDefault(i.getProject().getShortName(), "")
                        );
                        return map;
                     }
                  )
                  .collect(Collectors.toList());
               list.addAll(mapList);
            }
         } catch (Exception e) {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8.toString()));
            response.setHeader("Access-Control-Expose-Headers", "result");
         }

         Map<String, Object> exportMap = new HashMap<>();
         exportMap.put("reviewTime", query.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(EEEE)")));
         exportMap.put("downloadTime", LocalDateTime.now().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER));
         exportMap.put("downloaderName", UserUtil.getCurrentName());
         exportMap.put("list", list);
         String resourcePath = "files/ReportingApprovalRecord.xlsx";
         String tempFileName = "ReportingApprovalRecord";
         String exportFileName = "报工审核记录.xlsx";
         Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, ".xlsx");

         try {
            FileUtil.copyInputStreamToFile(inputStream, file);
            TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
            params.setColForEach(true);
            Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
            PoiUtils.downLoadExcel(exportFileName, response, workbook, Arrays.asList(0));
         } finally {
            if (file.exists()) {
               file.delete();
            }

            if (inputStream != null) {
               inputStream.close();
            }
         }
      } catch (Throwable $ex) {
         throw MesProductionReportingApprovalBizImpl.<RuntimeException>rethrow($ex);
      }
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
