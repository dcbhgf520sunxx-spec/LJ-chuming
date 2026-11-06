package com.hzchum.scim.wms.core.biz.wmsReport;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.system.core.api.common.enums.WastePriceEntryTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.biz.wmsReport.WasteSaleBiz;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteClassification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSale;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSaleDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleCheckDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailCheckDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleQueryDtoParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WasteClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleDetailService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleService;
import com.hzchum.scim.wms.core.mapper.wmsReport.WasteSaleMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WasteSaleBizImpl extends IBizImpl<WasteSaleService, WasteSaleMapper, WasteSale> implements WasteSaleBiz {
   private final BranchCompanyService branchCompanyService;
   private final ConfigService configService;
   private final UserService userService;
   private final WasteClassificationService wasteClassificationService;
   private final ContractWasteService contractWasteService;
   private final WasteSaleDetailService wasteSaleDetailService;

   @Override
   public PageVO<WasteSaleDTO> pageList(WasteSaleQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WasteSaleDTO> wasteSaleDTOList = this.baseService.listByCondition(param);
      if (CollectionUtils.isNotEmpty(wasteSaleDTOList)) {
         List<Long> wasteSaleIds = wasteSaleDTOList.stream().map(WasteSaleDTO::getId).collect(Collectors.toList());
         List<WasteSaleDetailDTO> wasteSaleDetailDTOList = this.wasteSaleDetailService.listByWasteSaleIds(wasteSaleIds);
         Map<Long, List<WasteSaleDetailDTO>> wasteSaleIdGroupDetailListMap = wasteSaleDetailDTOList.stream()
            .sorted(Comparator.comparing(WasteSaleDetailDTO::getId))
            .collect(Collectors.groupingBy(WasteSaleDetailDTO::getWasteSaleId));
         wasteSaleDTOList.forEach(w -> w.setWasteSaleDetailList(wasteSaleIdGroupDetailListMap.get(w.getId())));
      }

      return new PageVO<>(wasteSaleDTOList);
   }

   @Override
   public PrintVO<List<WasteSaleDTO>> printList(WasteSaleQueryDtoParam param) {
      List<WasteSaleDTO> wasteSaleDTOList = this.baseService.listByCondition(param);
      PrintVO<List<WasteSaleDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(wasteSaleDTOList);
      return printVO;
   }

   @Override
   public Boolean downLoadWasteSale(Long id, HttpServletResponse response) {
      WasteSale wasteSale = this.baseService.getById(id);
      Preconditions.checkArgument(wasteSale != null, "出售单不存在!");
      ContractWaste contractWaste = this.contractWasteService.getById(wasteSale.getContractWasteId());
      BranchCompany branchCompany = this.branchCompanyService.getById(wasteSale.getBranchCompanyId());
      User createUser = this.userService.getById(wasteSale.getCreateUserId());
      User auditUser = wasteSale.getAuditUserId() != null ? this.userService.getById(wasteSale.getAuditUserId()) : null;
      CompanyConfigVO companyConfig = this.configService.getCompanyConfig();
      List<WasteSaleDetailDTO> detailDTOList = this.wasteSaleDetailService.listByWasteSaleIds(Collections.singletonList(id));
      AtomicInteger orderNo = new AtomicInteger(1);
      List<Map<String, Object>> detailMapList = detailDTOList.stream().map(s -> {
         Map<String, Object> mapx = BeanUtil.beanToMap(s);
         mapx.put("orderNo", orderNo.getAndIncrement());
         return mapx;
      }).collect(Collectors.toList());
      WasteSaleDTO wasteSaleDto = BeanUtil.copy(wasteSale, WasteSaleDTO.class);
      wasteSaleDto.setBranchCompanyName(branchCompany != null ? branchCompany.getName() : "");
      wasteSaleDto.setPurchaser(contractWaste != null ? contractWaste.getPurchaser() : "");
      wasteSaleDto.setSerialNumber(contractWaste != null ? contractWaste.getSerialNumber() : "");
      wasteSaleDto.setCreateUserName(createUser != null ? createUser.getName() : "");
      wasteSaleDto.setAuditUserName(auditUser != null ? auditUser.getName() : "");
      Map<String, Object> map = BeanUtil.beanToMap(wasteSaleDto);
      map.put("companyName", companyConfig.getCompanyName());
      map.put("saleDate", DateTimeUtil.localDateToString(wasteSale.getSaleDate(), "yyyy-MM-dd"));
      String resourcePath = "files/template/WasteSaleDocument.xlsx";
      String exportFileName = "废料出售单.xlsx";
      Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      ExcelWriter writer = EasyExcel.write().withTemplate(inputStream).build();
      WriteSheet sheet0 = EasyExcel.writerSheet(0).build();
      writer.fill(new FillWrapper("details", detailMapList), FillConfig.builder().forceNewRow(false).build(), sheet0);
      writer.fill(map, sheet0);
      Workbook workbook = writer.writeContext().writeWorkbookHolder().getWorkbook();
      workbook.setForceFormulaRecalculation(true);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return true;
   }

   @Override
   public PageVO<WasteSaleDetailWholeInfoDTO> pageListDetail(WasteSaleDetailQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WasteSaleDetailWholeInfoDTO> detailDTOList = this.wasteSaleDetailService.listWasteSaleDetailWholeInfo(param);
      return new PageVO<>(detailDTOList);
   }

   @Override
   public PrintVO<List<WasteSaleDetailWholeInfoDTO>> printListDetail(WasteSaleDetailQueryDtoParam param) {
      List<WasteSaleDetailWholeInfoDTO> detailDtoList = this.wasteSaleDetailService.listWasteSaleDetailWholeInfo(param);
      PrintVO<List<WasteSaleDetailWholeInfoDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(detailDtoList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<WasteSaleDtoParam> paramList) {
      Integer wastePriceEntryType = this.configService.getWastePriceEntryType();
      paramList.forEach(param -> {
         this.checkWasteSaleDtoParam(param, wastePriceEntryType);
         WasteSale wasteSale = BeanUtil.copy(param, WasteSale.class);
         if (wastePriceEntryType.equals(WastePriceEntryTypeEnum.CREATE_ENTRY_PRICE.getType())) {
            BigDecimal totalAmount = param.getWasteSaleDetailList().stream().map(WasteSaleDetailDtoParam::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            wasteSale.setTotalAmount(totalAmount);
         }

         wasteSale.setCreateUserId(UserUtil.getCurrentUserId());
         wasteSale.setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
         this.baseService.save(wasteSale);
         this.wasteSaleDetailService.saveList(wasteSale.getId(), param.getWasteSaleDetailList());
      });
      return true;
   }

   private void checkWasteSaleDtoParam(WasteSaleDtoParam param, Integer wastePriceEntryType) {
      BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
      Preconditions.checkArgument(branchCompany != null, "出售单位不存在!");
      ContractWaste contractWaste = this.contractWasteService.getById(param.getContractWasteId());
      Preconditions.checkArgument(contractWaste != null, "出售合同不存在!");
      this.checkDetails(param.getWasteSaleDetailList(), wastePriceEntryType);
   }

   private void checkDetails(List<WasteSaleDetailDtoParam> wasteSaleDetailDtoParamList, Integer wastePriceEntryType) {
      Map<Long, WasteClassification> wasteClassificationMap = this.wasteClassificationService
         .listByIds(wasteSaleDetailDtoParamList.stream().map(WasteSaleDetailDtoParam::getWasteClassificationId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(WasteClassification::getId, Function.identity()));
      wasteSaleDetailDtoParamList.forEach(detailDtoParam -> {
         WasteClassification wasteClassification = wasteClassificationMap.get(detailDtoParam.getWasteClassificationId());
         Preconditions.checkArgument(wasteClassification != null, "废料类型不存在!");
         if (wastePriceEntryType.equals(WastePriceEntryTypeEnum.CREATE_ENTRY_PRICE.getType())) {
            Preconditions.checkArgument(detailDtoParam.getPrice() != null && detailDtoParam.getAmount() != null, "废料价格和金额不能为空!");
         } else {
            detailDtoParam.setPrice(null);
            detailDtoParam.setAmount(null);
         }
      });
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateList(List<WasteSaleDtoParam> paramList) {
      Integer wastePriceEntryType = this.configService.getWastePriceEntryType();
      paramList.forEach(param -> {
         WasteSale wasteSale = this.baseService.getById(param.getId());
         Preconditions.checkArgument(wasteSale != null, "废料出售记录不存在!");
         Preconditions.checkArgument(!wasteSale.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()), "废料出售单已通过审核!");
         this.checkWasteSaleDtoParam(param, wastePriceEntryType);
         BeanUtil.copy(param, wasteSale);
         if (wastePriceEntryType.equals(WastePriceEntryTypeEnum.CREATE_ENTRY_PRICE.getType())) {
            BigDecimal totalAmount = param.getWasteSaleDetailList().stream().map(WasteSaleDetailDtoParam::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            wasteSale.setTotalAmount(totalAmount);
         }

         wasteSale.setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
         this.baseService.updateById(wasteSale);
         this.wasteSaleDetailService.remove(Wrappers.lambdaQuery(WasteSaleDetail.builder().wasteSaleId(param.getId()).build()));
         this.wasteSaleDetailService.saveList(param.getId(), param.getWasteSaleDetailList());
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditWasteSale(WasteSaleCheckDtoParam param) {
      WasteSale wasteSale = this.baseService.getById(param.getId());
      Preconditions.checkArgument(wasteSale != null, "废料出售记录不存在!");
      Preconditions.checkArgument(wasteSale.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "废料出售单已审核!");
      List<WasteSaleDetail> detailList = this.wasteSaleDetailService.list(Wrappers.lambdaQuery(WasteSaleDetail.builder().wasteSaleId(param.getId()).build()));
      Preconditions.checkArgument(detailList.size() > 0 && detailList.size() == param.getWasteSaleDetailList().size(), "废料出售明细列表有误!");
      Map<Long, WasteSaleDetail> wasteSaleDetailMap = detailList.stream().collect(Collectors.toMap(WasteSaleDetail::getId, Function.identity()));
      Integer wastePriceEntryType = this.configService.getWastePriceEntryType();
      boolean status = param.getAuditStatusEnum().equals(ReviewStatusEnum.REVIEWED.getType());
      param.getWasteSaleDetailList()
         .forEach(
            checkDtoParam -> {
               if (status && (ObjectUtil.isEmpty(checkDtoParam.getPrice()) || ObjectUtil.isEmpty(checkDtoParam.getAmount()))) {
                  Preconditions.checkArgument(false, "金额不能为空!");
               }

               WasteSaleDetail wasteSaleDetail = wasteSaleDetailMap.get(checkDtoParam.getId());
               Preconditions.checkArgument(wasteSaleDetail != null, "废料出售明细有误!");
               if (wastePriceEntryType.equals(WastePriceEntryTypeEnum.CREATE_ENTRY_PRICE.getType()) && wasteSaleDetail.getPrice() != null) {
                  Preconditions.checkArgument(
                     checkDtoParam.getPrice().compareTo(wasteSaleDetail.getPrice()) == 0
                        && checkDtoParam.getAmount().compareTo(wasteSaleDetail.getAmount()) == 0,
                     "审核失败,您无权修改当前价格!"
                  );
               }

               BeanUtil.copy(checkDtoParam, wasteSaleDetail);
               wasteSaleDetail.setAuditStatusEnum(param.getAuditStatusEnum());
               this.wasteSaleDetailService.updateById(wasteSaleDetail);
            }
         );
      BeanUtil.copy(param, wasteSale);
      BigDecimal totalAmount = param.getWasteSaleDetailList()
         .stream()
         .filter(wasteSaleDetailCheckDtoParam -> wasteSaleDetailCheckDtoParam.getAmount() != null)
         .map(WasteSaleDetailCheckDtoParam::getAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      wasteSale.setTotalAmount(totalAmount);
      wasteSale.setAuditUserId(UserUtil.getCurrentUserId());
      wasteSale.setAuditTime(LocalDateTime.now());
      this.baseService.updateById(wasteSale);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         WasteSale wasteSale = this.baseService.getById(id);
         Preconditions.checkArgument(wasteSale != null, "废料出售记录不存在!");
         Preconditions.checkArgument(!wasteSale.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()), "删除失败,废料出售单已通过审核!");
         this.baseService.removeById(id);
         this.wasteSaleDetailService.remove(Wrappers.lambdaQuery(WasteSaleDetail.builder().wasteSaleId(id).build()));
      });
      return true;
   }

   @Override
   public List<BasicClassMeteAndAmountDTO> getAmountByMonth(Long sysBranchCompanyByProjectId, LocalDateTime startTime, LocalDateTime endTime) {
      if (ObjectUtil.isNotEmpty(startTime)) {
         startTime = startTime.with(TemporalAdjusters.firstDayOfMonth());
      }

      if (ObjectUtil.isNotEmpty(endTime)) {
         endTime = endTime.with(TemporalAdjusters.lastDayOfMonth());
      }

      List<WasteSale> wasteSaleList = this.baseService
         .list(
            (Wrapper<WasteSale>)(((new LambdaQueryWrapper<WasteSale>()
                        .ge(ObjectUtil.isNotEmpty(startTime), WasteSale::getAuditTime, startTime))
                     .eq(WasteSale::getBranchCompanyId, sysBranchCompanyByProjectId))
                  .le(ObjectUtil.isNotEmpty(endTime), WasteSale::getAuditTime, endTime))
               .eq(WasteSale::getAuditStatusEnum, ReviewStatusEnum.REVIEWED.getType())
         );
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      Calendar cal = Calendar.getInstance();
      Map<String, List<WasteSale>> collect = wasteSaleList.stream().collect(Collectors.groupingBy(w -> formatter.format(w.getAuditTime())));
      List<BasicClassMeteAndAmountDTO> basicClassMeteAndAmountDTOS = new ArrayList<>();

      for (String key : collect.keySet()) {
         BasicClassMeteAndAmountDTO basicClassMeteAndAmountDTO = new BasicClassMeteAndAmountDTO();
         basicClassMeteAndAmountDTO.setTime(key);
         List<WasteSale> wasteSaleListYearMonth = collect.get(key);
         BigDecimal sumAmount = wasteSaleListYearMonth.stream()
            .map(WasteSale::getTotalAmount)
            .filter(ObjectUtil::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         basicClassMeteAndAmountDTO.setAmount(sumAmount);
         basicClassMeteAndAmountDTOS.add(basicClassMeteAndAmountDTO);
      }

      return basicClassMeteAndAmountDTOS;
   }

   public WasteSaleBizImpl(
      final BranchCompanyService branchCompanyService,
      final ConfigService configService,
      final UserService userService,
      final WasteClassificationService wasteClassificationService,
      final ContractWasteService contractWasteService,
      final WasteSaleDetailService wasteSaleDetailService
   ) {
      this.branchCompanyService = branchCompanyService;
      this.configService = configService;
      this.userService = userService;
      this.wasteClassificationService = wasteClassificationService;
      this.contractWasteService = contractWasteService;
      this.wasteSaleDetailService = wasteSaleDetailService;
   }
}
