package com.hzchum.scim.scm.core.biz.impl.scm;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.scm.core.api.biz.scm.ScmSupplierConfigBiz;
import com.hzchum.scim.scm.core.api.biz.scm.ScmSupplierEvaluateBiz;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierConfig;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierEvaluate;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierEvaluateDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateQueryParam;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.api.service.scm.ScmSupplierEvaluateService;
import com.hzchum.scim.scm.core.mapper.scm.ScmSupplierEvaluateMapper;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScmSupplierEvaluateBizImpl
   extends IBizImpl<ScmSupplierEvaluateService, ScmSupplierEvaluateMapper, ScmSupplierEvaluate>
   implements ScmSupplierEvaluateBiz {
   private static final Logger log = LoggerFactory.getLogger(ScmSupplierEvaluateBizImpl.class);
   @Resource
   private ScmSupplierEvaluateService scmSupplierEvaluateService;
   @Resource
   private ScmSupplierEvaluateMapper scmSupplierEvaluateMapper;
   @Resource
   private ScmSupplierConfigBiz scmSupplierConfigBiz;
   @Resource
   private SupplierService supplierService;
   @Resource
   private UserService userService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private NumberConfigService numberConfigService;

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean addEvaluate(ScmSupplierEvaluateDTOParam param) {
      Preconditions.checkArgument(param.getSupplierId() != null, "供应商id不能为空");
      Preconditions.checkArgument(param.getTemplateId() != null, "评价模板id不能为空");
      Preconditions.checkArgument(StringUtils.isNotBlank(param.getEvaluateDetailsJson()), "评价分数详情不能为空");
      Supplier supplier = this.supplierService.getById(param.getSupplierId());
      Preconditions.checkArgument(supplier != null, "供应商不存在");
      ScmSupplierConfigDTO reviewTemplate = this.scmSupplierConfigBiz.getReviewTemplate(supplier.getClassifyId());
      Preconditions.checkArgument(reviewTemplate != null, "评价模板不存在");
      List<ScmSupplierConfigDTO> scoreRatings = this.scmSupplierConfigBiz.listScoreRating();
      Preconditions.checkArgument(scoreRatings != null && !scoreRatings.isEmpty(), "分数评级不存在");
      String scoreRating = this.determineScoreRating(param.getScore(), scoreRatings);
      Preconditions.checkArgument(scoreRating != null, "未找到匹配的分数评级");
      ScmSupplierEvaluate evaluate = new ScmSupplierEvaluate();
      BeanUtil.copy(param, evaluate);
      evaluate.setEvaluateDate(LocalDateTime.now());
      evaluate.setClassifyId(supplier.getClassifyId());
      evaluate.setEvaluateJson(param.getEvaluateDetailsJson());
      Map<String, String> columnMap = param.getColumnMap();
      columnMap.put("score", "评分");
      evaluate.setColumnMapJson(JSON.toJSONString(columnMap));
      evaluate.setScore(param.getScore());
      evaluate.setScoreRating(scoreRating);
      evaluate.setUserId(UserUtil.getCurrentUserId());
      int count = this.scmSupplierEvaluateService
         .count(
            Wrappers.lambdaQuery(ScmSupplierEvaluate.class)
               .apply("DATE_FORMAT(evaluate_date,'%Y-%m-%d')={0}", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
         );
      String serialNumber = this.numberConfigService.getNumber(NumberTypeEnum.SUPPLIER_EVALUATE, count, new SimpleDateFormat("-yyyyMMdd").format(new Date()));
      evaluate.setSerialNumber(serialNumber);
      Integer approveStatus = ReviewStatusEnum.AUDITING.getType();
      evaluate.setReviewStatus(approveStatus);
      this.scmSupplierEvaluateService.save(evaluate);
      WmsApproveRecord record = this.wmsApproveRecordService
         .createRecord(evaluate.getId(), serialNumber, ApproveProcessTypeEnumV2.SUPPLIER_EVALUATE.getType(), null, null, null, false, null, null, null);
      if (ApproveRecordStatusEnum.END.getType().equals(record.getStatus())) {
         approveStatus = ReviewStatusEnum.REVIEWED.getType();
      }

      evaluate.setApproveRecordId(record.getId());
      evaluate.setReviewStatus(approveStatus);
      this.scmSupplierEvaluateService.updateById(evaluate);
      if (ReviewStatusEnum.REVIEWED.getType().equals(approveStatus)) {
         supplier.setBoolAnnualEvaluated(Boolean.TRUE);
         this.supplierService.updateById(supplier);
      }

      return true;
   }

   private String determineScoreRating(Integer scoreValue, List<ScmSupplierConfigDTO> scoreRatings) {
      if (scoreValue != null && scoreRatings != null && !scoreRatings.isEmpty()) {
         try {
            for (ScmSupplierConfigDTO rating : scoreRatings) {
               Integer minValue = rating.getMinValue();
               Integer maxValue = rating.getMaxValue();
               if (minValue != null && maxValue != null) {
                  if (scoreValue >= minValue && scoreValue <= maxValue) {
                     return rating.getName();
                  }
               } else if (minValue != null) {
                  if (scoreValue >= minValue) {
                     return rating.getName();
                  }
               } else if (maxValue != null && scoreValue <= maxValue) {
                  return rating.getName();
               }
            }

            return null;
         } catch (NumberFormatException e) {
            log.error("分数格式错误: {}", scoreValue, e);
            return null;
         }
      } else {
         return null;
      }
   }

   @Transactional
   @Override
   public Boolean checkEvaluate(Long evaluateId, Integer decision, String opinion) {
      Preconditions.checkArgument(ReviewStatusEnum.REVIEWED.getType().equals(decision) || ReviewStatusEnum.RETURNED.getType().equals(decision), "审核类型不正确！");
      ScmSupplierEvaluate evaluate = this.scmSupplierEvaluateService.getById(evaluateId);
      Preconditions.checkArgument(evaluate != null, "评价记录不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(evaluate.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "审批记录不存在");
      Boolean isEnd = this.wmsApproveRecordService.commonApproveStep(evaluateId, decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      Integer approveStatus;
      if (isEnd) {
         approveStatus = decision;
         evaluate.setReviewerId(UserUtil.getCurrentUserId());
         evaluate.setReviewerName(UserUtil.getCurrentName());
         evaluate.setReviewTime(LocalDateTime.now());
         if (ReviewStatusEnum.REVIEWED.getType().equals(decision)) {
            Supplier supplier = this.supplierService.getById(evaluate.getSupplierId());
            if (supplier != null) {
               supplier.setBoolAnnualEvaluated(Boolean.TRUE);
               this.supplierService.updateById(supplier);
            }
         }
      } else {
         approveStatus = ReviewStatusEnum.AUDITING.getType();
      }

      evaluate.setReviewStatus(approveStatus);
      this.scmSupplierEvaluateService.updateById(evaluate);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean cancelApproveEvaluate(Long evaluateId) {
      ScmSupplierEvaluate evaluate = this.scmSupplierEvaluateService.getById(evaluateId);
      Preconditions.checkArgument(evaluate != null, "评价记录不存在");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(evaluate.getUserId()), "仅创建人可以撤销");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(evaluate.getReviewStatus()), "仅审核中状态可以撤销");
      evaluate.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      if (evaluate.getApproveRecordId() != null) {
         this.wmsApproveRecordService.revocation(evaluate.getApproveRecordId());
      }

      this.scmSupplierEvaluateService.updateById(evaluate);
      return true;
   }

   @Override
   public PageVO<ScmSupplierEvaluateDTO> listEvaluateRecords(ScmSupplierEvaluateQueryParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<ScmSupplierEvaluateDTO> dtoList = this.scmSupplierEvaluateMapper.listEvaluateRecords(param);
      if (CollectionUtils.isEmpty(dtoList)) {
         return new PageVO<>();
      }

      List<Long> classifyIds = dtoList.stream().map(ScmSupplierEvaluateDTO::getClassifyId).collect(Collectors.toList());
      Map<Long, ScmSupplierConfig> configMap = this.scmSupplierConfigBiz
         .listByIds(classifyIds)
         .stream()
         .collect(Collectors.toMap(ScmSupplierConfig::getId, Function.identity()));

      for (ScmSupplierEvaluateDTO supplierEvaluateDTO : dtoList) {
         supplierEvaluateDTO.setColumnMap(JSON.parseObject(supplierEvaluateDTO.getColumnMapJson(), Map.class));
         ScmSupplierConfig scmSupplierConfig = configMap.get(supplierEvaluateDTO.getClassifyId());
         ScmSupplierConfigDTO scmSupplierConfigDTO = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
         supplierEvaluateDTO.setScmSupplierConfigDTO(scmSupplierConfigDTO);
      }

      return new PageVO<>(dtoList);
   }

   @Override
   public void listEvaluateRecordsDownload(ScmSupplierEvaluateQueryParam query, HttpServletResponse response) {
      List<ScmSupplierEvaluateDTO> list = this.scmSupplierEvaluateMapper.listEvaluateRecords(query);
      if (!CollectionUtils.isEmpty(list)) {
         List<Long> classifyIds = list.stream().map(ScmSupplierEvaluateDTO::getClassifyId).collect(Collectors.toList());
         Map<Long, ScmSupplierConfig> configMap = this.scmSupplierConfigBiz
            .listByIds(classifyIds)
            .stream()
            .collect(Collectors.toMap(ScmSupplierConfig::getId, Function.identity()));

         for (ScmSupplierEvaluateDTO supplierEvaluateDTO : list) {
            ScmSupplierConfig scmSupplierConfig = configMap.get(supplierEvaluateDTO.getClassifyId());
            ScmSupplierConfigDTO scmSupplierConfigDTO = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
            supplierEvaluateDTO.setScmSupplierConfigDTO(scmSupplierConfigDTO);
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList("序号"));
         headList.add(Arrays.asList("审核时间"));
         headList.add(Arrays.asList("评价时间"));
         headList.add(Arrays.asList("评价分类"));
         headList.add(Arrays.asList("供应商名称"));
         headList.add(Arrays.asList("供应商简称"));
         headList.add(Arrays.asList("评审结果"));
         headList.add(Arrays.asList("评级"));
         headList.add(Arrays.asList("评价人"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
         list.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            LocalDateTime createTime = ex.getEvaluateDate();
            data.add(ex.getReviewTime() != null ? ex.getReviewTime().format(formatter2) : "-");
            data.add(createTime != null ? createTime.format(formatter2) : "-");
            data.add(ex.getScmSupplierConfigDTO().getName());
            data.add(ex.getSupplierName());
            data.add(ex.getSupplierShortName());
            data.add(ex.getScore());
            data.add(ex.getScoreRating());
            data.add(ex.getEvaluatorName());
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "供应商评价信息.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("供应商评价信息")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public ScmSupplierEvaluateDTO getLatestEvaluateBySupplierId(Long supplierId) {
      Preconditions.checkArgument(supplierId != null, "供应商id不能为空");
      Integer currentYear = LocalDate.now().getYear();
      ScmSupplierEvaluateDTO evaluateDTO = this.scmSupplierEvaluateMapper.getLatestEvaluateBySupplierIdAndYear(supplierId, currentYear);
      if (evaluateDTO != null) {
         if (evaluateDTO.getClassifyId() != null) {
            ScmSupplierConfig scmSupplierConfig = this.scmSupplierConfigBiz.getById(evaluateDTO.getClassifyId());
            if (scmSupplierConfig != null) {
               ScmSupplierConfigDTO scmSupplierConfigDTO = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
               evaluateDTO.setScmSupplierConfigDTO(scmSupplierConfigDTO);
            }
         }

         evaluateDTO.setColumnMap(JSON.parseObject(evaluateDTO.getColumnMapJson(), Map.class));
      }

      return evaluateDTO;
   }

   @Override
   public ScmSupplierEvaluateDTO getEvaluateDetailById(Long evaluateId) {
      Preconditions.checkArgument(evaluateId != null, "评价记录id不能为空");
      ScmSupplierEvaluate evaluate = this.scmSupplierEvaluateService.getById(evaluateId);
      Preconditions.checkArgument(evaluate != null, "评价记录不存在");
      ScmSupplierEvaluateDTO evaluateDTO = BeanUtil.copy(evaluate, ScmSupplierEvaluateDTO.class);
      if (evaluate.getSupplierId() != null) {
         Supplier supplier = this.supplierService.getById(evaluate.getSupplierId());
         if (supplier != null) {
            evaluateDTO.setSupplierName(supplier.getName());
            evaluateDTO.setSupplierShortName(supplier.getShortName());
         }
      }

      if (evaluate.getUserId() != null) {
         User user = this.userService.getById(evaluate.getUserId());
         if (user != null) {
            evaluateDTO.setEvaluatorName(user.getName());
         }
      }

      if (evaluate.getClassifyId() != null) {
         ScmSupplierConfig scmSupplierConfig = this.scmSupplierConfigBiz.getById(evaluate.getClassifyId());
         if (scmSupplierConfig != null) {
            ScmSupplierConfigDTO scmSupplierConfigDTO = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
            evaluateDTO.setScmSupplierConfigDTO(scmSupplierConfigDTO);
         }
      }

      if (StringUtils.isNotBlank(evaluate.getColumnMapJson())) {
         evaluateDTO.setColumnMap(JSON.parseObject(evaluate.getColumnMapJson(), Map.class));
      }

      return evaluateDTO;
   }

   @Override
   public void exportEvaluateDetail(Long evaluateId, HttpServletResponse response) {
      Preconditions.checkArgument(evaluateId != null, "评价记录id不能为空");
      ScmSupplierEvaluate evaluate = this.scmSupplierEvaluateService.getById(evaluateId);
      Preconditions.checkArgument(evaluate != null, "评价记录不存在");
      Map<String, String> columnMap = StringUtils.isNotBlank(evaluate.getColumnMapJson())
         ? JSON.parseObject(evaluate.getColumnMapJson(), Map.class)
         : new HashMap<>();
      columnMap.remove("serialNumber");
      columnMap.remove("hasVeto");
      List<Map<String, Object>> evaluateDataList = new ArrayList<>();
      if (StringUtils.isNotBlank(evaluate.getEvaluateJson())) {
         for (Object obj : JSON.parseArray(evaluate.getEvaluateJson(), Map.class)) {
            if (obj instanceof Map) {
               evaluateDataList.add((Map<String, Object>)obj);
            }
         }
      }

      Supplier supplier = this.supplierService.getById(evaluate.getSupplierId());
      String supplierName = supplier != null ? supplier.getName() : "";
      ScmSupplierConfig scmSupplierConfig = this.scmSupplierConfigBiz.getById(evaluate.getClassifyId());
      User user = this.userService.getById(evaluate.getUserId());
      List<Map<String, Object>> detailList = new ArrayList<>();
      List<String> titleList = this.getColumnList(columnMap);
      int serialNumber = 1;

      for (Map<String, Object> evaluateData : evaluateDataList) {
         Map<String, Object> detailRow = new HashMap<>();
         detailRow.put("serialNumber", serialNumber++);

         for (Entry<String, String> entry : columnMap.entrySet()) {
            String englishKey = entry.getKey();
            String chineseName = entry.getValue();
            Object value = evaluateData.get(englishKey);
            detailRow.put(chineseName, value != null ? value : "");
         }

         detailList.add(detailRow);
      }

      DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      String templateFilePath = "files/template/supplier/2026供应商考核评审表.docx";
      String fileName = "供应商考核记录详情_" + supplierName + ".docx";

      try {
         Map<String, Object> params = new HashMap<>();
         params.put("supplierName", supplierName);
         params.put("userName", user.getName());
         params.put("classifyName", scmSupplierConfig.getName());
         params.put("evaluateDate", evaluate.getReviewTime() != null ? evaluate.getReviewTime().format(formatter2) : "");
         params.put("score", evaluate.getScore() != null ? evaluate.getScore() : "");
         params.put("scoreRating", evaluate.getScoreRating() != null ? evaluate.getScoreRating() : "");
         XWPFDocument document = WordExportUtil.exportWord07(templateFilePath, params);
         this.replacePlaceholderWithTable(document, titleList, detailList, "${detailsTable}");
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-word");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         document.write(response.getOutputStream());
         document.close();
      } catch (Exception e) {
         log.error("导出Word文档失败", e);
         throw new RuntimeException("导出Word文档失败", e);
      }
   }

   private List<String> getColumnList(Map<String, String> columnMap) {
      List<String> titleList = new ArrayList<>();
      titleList.add("序号");
      String assessmentProjectKey = "assessmentProject";
      String assessmentContentsKey = "assessmentContents";
      String fractionKey = "fraction";
      String scoreKey = "score";
      if (columnMap.containsKey(assessmentProjectKey)) {
         titleList.add(columnMap.get(assessmentProjectKey));
      }

      if (columnMap.containsKey(assessmentContentsKey)) {
         titleList.add(columnMap.get(assessmentContentsKey));
      }

      for (Entry<String, String> entry : columnMap.entrySet()) {
         String key = entry.getKey();
         if (!"serialNumber".equals(key)
            && !assessmentProjectKey.equals(key)
            && !assessmentContentsKey.equals(key)
            && !fractionKey.equals(key)
            && !scoreKey.equals(key)) {
            titleList.add(entry.getValue());
         }
      }

      if (columnMap.containsKey(fractionKey)) {
         titleList.add(columnMap.get(fractionKey));
      }

      if (columnMap.containsKey(scoreKey)) {
         titleList.add(columnMap.get(scoreKey));
      }

      return titleList;
   }

   private String getStatusText(Integer status) {
      if (status == null) {
         return "-";
      } else if (ReviewStatusEnum.AUDITING.getType().equals(status)) {
         return "审核中";
      } else if (ReviewStatusEnum.REVIEWED.getType().equals(status)) {
         return "通过";
      } else if (ReviewStatusEnum.RETURNED.getType().equals(status)) {
         return "驳回";
      } else {
         return ReviewStatusEnum.CANCEL.getType().equals(status) ? "已撤销" : "-";
      }
   }

   private void replacePlaceholderWithTable(XWPFDocument doc, List<String> titleList, List<Map<String, Object>> detailList, String placeholder) {
      for (int i = 0; i < doc.getParagraphs().size(); i++) {
         XWPFParagraph paragraph = doc.getParagraphs().get(i);
         String text = paragraph.getText();
         if (text != null && text.contains(placeholder)) {
            long tableWidth = this.getAdjacentTableWidth(doc, paragraph);
            int paragraphPos = doc.getPosOfParagraph(paragraph);
            int rows = detailList.size() + 1;
            int cols = titleList.size();
            XWPFTable table = doc.createTable(rows, cols);
            CTTblWidth tableWidthObj = table.getCTTbl().addNewTblPr().addNewTblW();
            tableWidthObj.setType(STTblWidth.DXA);
            tableWidthObj.setW(BigInteger.valueOf(tableWidth));
            XWPFTableRow headerRow = table.getRow(0);

            for (int j = 0; j < titleList.size(); j++) {
               XWPFTableCell cell = headerRow.getCell(j);
               cell.setText(titleList.get(j));
               this.setCellStyle(cell, true, true, null);
            }

            for (int rowIdx = 0; rowIdx < detailList.size(); rowIdx++) {
               XWPFTableRow row = table.getRow(rowIdx + 1);
               Map<String, Object> rowData = detailList.get(rowIdx);

               for (int j = 0; j < titleList.size(); j++) {
                  XWPFTableCell cell = row.getCell(j);
                  String value;
                  if (j == 0) {
                     value = rowData.get("serialNumber").toString();
                  } else {
                     String columnName = titleList.get(j);
                     Object obj = rowData.get(columnName);
                     value = obj != null ? obj.toString() : "";
                  }

                  cell.setText(value);
                  String bgColor = rowIdx % 2 == 0 ? "FFFFFF" : "F2F2F2";
                  this.setCellStyle(cell, false, true, bgColor);
               }
            }

            doc.removeBodyElement(paragraphPos);
            break;
         }
      }
   }

   private long getAdjacentTableWidth(XWPFDocument doc, XWPFParagraph paragraph) {
      int paragraphIndex = doc.getPosOfParagraph(paragraph);

      for (int i = 0; i < doc.getTables().size(); i++) {
         XWPFTable table = doc.getTables().get(i);
         int tablePos = this.getTablePosition(doc, table);
         if (tablePos < paragraphIndex) {
            try {
               if (table.getCTTbl().getTblPr() != null && table.getCTTbl().getTblPr().getTblW() != null) {
                  return table.getCTTbl().getTblPr().getTblW().getW().longValue();
               }
            } catch (Exception var9) {
            }
         }
      }

      for (int i = 0; i < doc.getTables().size(); i++) {
         XWPFTable table = doc.getTables().get(i);
         int tablePos = this.getTablePosition(doc, table);
         if (tablePos > paragraphIndex) {
            try {
               if (table.getCTTbl().getTblPr() != null && table.getCTTbl().getTblPr().getTblW() != null) {
                  return table.getCTTbl().getTblPr().getTblW().getW().longValue();
               }
            } catch (Exception var8) {
            }
         }
      }

      return 9072L;
   }

   private int getTablePosition(XWPFDocument doc, XWPFTable table) {
      for (int i = 0; i < doc.getBodyElements().size(); i++) {
         if (doc.getBodyElements().get(i) == table) {
            return i;
         }
      }

      return -1;
   }

   private void setCellStyle(XWPFTableCell cell, boolean bold, boolean center, String bgColor) {
      cell.setVerticalAlignment(XWPFVertAlign.CENTER);
      XWPFParagraph paragraph = cell.getParagraphs().get(0);
      if (center) {
         paragraph.setAlignment(ParagraphAlignment.CENTER);
      }

      for (XWPFRun run : paragraph.getRuns()) {
         if (bold) {
            run.setBold(true);
         }

         run.setFontSize(10);
      }

      if (bgColor != null && !bgColor.isEmpty()) {
         cell.setColor(bgColor);
      }
   }
}
