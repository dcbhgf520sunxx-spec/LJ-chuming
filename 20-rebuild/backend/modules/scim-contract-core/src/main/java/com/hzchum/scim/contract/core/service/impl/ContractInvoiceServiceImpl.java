package com.hzchum.scim.contract.core.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCollectionQueryDoParam;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractInvoiceQueryDoParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAnalysisOpenUpDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.mapper.ContractCollectionMapper;
import com.hzchum.scim.contract.core.mapper.ContractInvoiceMapper;
import com.hzchum.scim.contract.core.mapper.ContractProjectMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Service;

@Service
public class ContractInvoiceServiceImpl extends ServiceImpl<ContractInvoiceMapper, ContractInvoice> implements ContractInvoiceService {
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractCollectionMapper contractCollectionMapper;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private ContractProjectMapper contractProjectMapper;
   @Resource
   private ContractCollectionService collectionService;

   @Override
   public List<ContractInvoiceDTO> listInvoice(ContractInvoiceQueryDtoParam param) {
      if (param.getType() == null) {
         param.setContractWasteId(null);
      } else if (param.getType().equals(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType())) {
         param.setContractWasteId(null);
      } else {
         param.setProjectId(null);
         param.setBusinessType(null);
      }

      SecurityUser user = UserUtil.getCurrentUser();
      ContractInvoiceQueryDoParam doParam = BeanUtil.copy(param, ContractInvoiceQueryDoParam.class);
      doParam.setUserId(user.isAdmin() ? null : user.getId());
      List<ContractInvoiceDTO> invoiceDTOS = this.baseMapper.listByCondition(doParam);
      invoiceDTOS.forEach(
         i -> {
            i.setAttachmentList(this.attachmentService.listByIds(i.getAttachments()));
            i.setTax(i.getInvoiceAmount().multiply(i.getTaxRate()).divide(BigDecimal.valueOf(100L).add(i.getTaxRate()), 2, RoundingMode.HALF_UP));
            i.setAmountExcludingTax(
               i.getInvoiceAmount().multiply(BigDecimal.valueOf(100L)).divide(BigDecimal.valueOf(100L).add(i.getTaxRate()), 2, RoundingMode.HALF_UP)
            );
         }
      );
      return invoiceDTOS;
   }

   @Override
   public BigDecimal getInvoiceAmount(Long projectId) {
      return this.baseMapper.selectInvoiceAmount(projectId, AuditStatusEnum.SUCCEED.getType());
   }

   @Override
   public BigDecimal getSumInvoiceTax(Long projectId) {
      return this.baseMapper.selectSumOutTax(projectId, AuditStatusEnum.SUCCEED.getType());
   }

   @Override
   public List<ContractInvoice> listPageLedger(Long projectId, Long invoiceUnitId) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractInvoice.class)
               .eq(ContractInvoice::getProjectId, projectId)
               .eq(invoiceUnitId != null, ContractInvoice::getInvoiceUnitId, invoiceUnitId)
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(ContractInvoice::getInvoiceDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
   }

   @Override
   public List<ContractInvoice> selectIncomeAndExpenses(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.selectIncomeAndExpenses(projectId, remark, collectionMode, startDate, endDate);
   }

   @Override
   public List<ProjectLedgerDetailDTO> collectionAndInvoiceDetail(Long projectId) {
      List<ProjectLedgerDetailDTO> detailDTOS = new ArrayList<>();
      List<ContractInvoice> contractInvoices = this.baseMapper
         .selectList(
            (Wrapper<ContractInvoice>)(Wrappers.<ContractInvoice>lambdaQuery().eq(ContractInvoice::getProjectId, projectId))
               .eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      contractInvoices.forEach(i -> {
         ProjectLedgerDetailDTO detailDTO = new ProjectLedgerDetailDTO();
         detailDTO.setInvoiceAmount(i.getActualInvoiceAmount());
         detailDTO.setDate(i.getAuditTime().toLocalDate());
         detailDTO.setProjectId(projectId);
         detailDTO.setRemark(i.getRemark());
         detailDTOS.add(detailDTO);
      });
      List<ContractCollection> collection = this.collectionService
         .list(
            (Wrapper<ContractCollection>)(Wrappers.<ContractCollection>lambdaQuery().eq(ContractCollection::getProjectId, projectId))
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      collection.forEach(i -> {
         ProjectLedgerDetailDTO detailDTO = new ProjectLedgerDetailDTO();
         detailDTO.setCollectionAmount(i.getCollectionAmount());
         detailDTO.setDate(i.getCreateTime().toLocalDate());
         detailDTO.setProjectId(projectId);
         detailDTO.setRemark(i.getRemark());
         detailDTOS.add(detailDTO);
      });
      detailDTOS.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
      return detailDTOS;
   }

   @Override
   public List<ProjectAnalysisOpenUpDTO> getAnalysisOpenUpDetails(Long project, Long branchCompanyId) {
      ContractInvoiceQueryDtoParam param = ContractInvoiceQueryDtoParam.builder()
         .projectId(project)
         .type(1)
         .invoiceUnitId(branchCompanyId)
         .auditStatus(2)
         .build();
      ContractInvoiceQueryDoParam doParam = BeanUtil.copy(param, ContractInvoiceQueryDoParam.class);
      List<ContractInvoiceDTO> invoiceDTOS = this.baseMapper.listByCondition(doParam);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      Map<String, BigDecimal> result1 = invoiceDTOS.stream()
         .collect(
            Collectors.groupingBy(
               invoice -> invoice.getCreateTime().format(formatter),
               Collectors.reducing(BigDecimal.ZERO, ContractInvoiceDTO::getInvoiceAmount, BigDecimal::add)
            )
         );
      ContractCollectionQueryDoParam cParam = ContractCollectionQueryDoParam.builder()
         .projectId(project)
         .type(1)
         .auditStatus(2)
         .collectionUnitId(branchCompanyId)
         .build();
      List<ContractCollectionDTO> contractCollectionDTOS = this.contractCollectionMapper.listByCondition(cParam);
      Map<String, BigDecimal> result2 = contractCollectionDTOS.stream()
         .collect(
            Collectors.groupingBy(
               collection -> collection.getCreateTime().format(formatter),
               Collectors.reducing(BigDecimal.ZERO, ContractCollectionDTO::getHaveCollectionAmount, BigDecimal::add)
            )
         );
      List<ProjectAnalysisOpenUpDTO> resultList = new ArrayList<>();
      result1.forEach((key, value) -> {
         ProjectAnalysisOpenUpDTO build = ProjectAnalysisOpenUpDTO.builder().dateTime(key).invoiceAmount(value).build();
         if (result2.containsKey(key)) {
            build.setCollectionAmount(result2.get(key));
            result2.remove(key);
         }

         resultList.add(build);
      });
      result2.forEach((key, value) -> {
         ProjectAnalysisOpenUpDTO build = ProjectAnalysisOpenUpDTO.builder().dateTime(key).collectionAmount(value).build();
         resultList.add(build);
      });
      resultList.sort(Comparator.comparing(ProjectAnalysisOpenUpDTO::getDateTime));
      return resultList;
   }

   @Override
   public void getAnalysisOpenUpDetailsDownload(Long projectId, Long branchCompanyId, HttpServletResponse response) {
      List<ProjectAnalysisOpenUpDTO> openUpList = this.getAnalysisOpenUpDetails(projectId, branchCompanyId);
      if (!CollectionUtil.isEmpty(openUpList)) {
         String title = "";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         if (projectId != null) {
            ProjectInfo projectInfo = this.contractProjectMapper.getProjectInfoById(projectId);
            if (projectInfo != null) {
               title = title + "项目：" + projectInfo.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "日期"));
         headList.add(Arrays.asList(title, "收款（元）"));
         headList.add(Arrays.asList(title, "开票（元）"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         openUpList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getDateTime());
            data.add(ex.getCollectionAmount());
            data.add(ex.getInvoiceAmount());
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "合同收款开票详情表.xlsx");
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
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
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
               .sheet("合同收款开票详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
}
