package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.PrintMaterialTypeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Barcode;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TypeAndNumberDO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.LabelPrintMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.LabelPrintReceiptDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.NotPrintedNumberDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PrintDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryLabelPrintDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsUse.BarcodeMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.PrintMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrintServiceImpl extends ServiceImpl<PrintMapper, Print> implements PrintService {
   @Resource
   PrintMapper printMapper;
   @Resource
   PrintDetailMapper printDetailMapper;
   @Resource
   ContractProjectService projectService;
   @Resource
   BarcodeMapper barcodeMapper;

   @Override
   public PageVO<LabelPrintReceiptDTO> receiptList(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      if (CollectionUtil.isNotEmpty(param.getCreateDate())) {
         param.getCreateDate().add(1, CommonUtil.getDayLastTime(param.getCreateDate().get(1)));
      }

      return new PageVO<>(page, this.printMapper.list(param).stream().map(lp -> {
         LabelPrintReceiptDTO dto = BeanUtil.copy(lp, LabelPrintReceiptDTO.class);
         dto.setSerialNumber(lp.getReceiptSerialNumber());
         dto.setBasicClass(lp.getContainBasicClass());
         dto.setReviewerName(lp.getReceiptReviewer());
         dto.setPendingPrintedMaterialNumber(lp.getTotalNotPrintNumber());
         dto.setReceipt(BriefIdAndSNDTO.builder().id(lp.getReceiptId()).serialNumber(lp.getReceiptSerialNumber()).receiptType(lp.getReceiptType()).build());
         if (lp.getProjectIds() != null) {
            dto.setProjects(this.projectService.listByIds(lp.getProjectIds()));
         }

         return dto;
      }).collect(Collectors.toList()));
   }

   @Override
   public PageVO<LabelPrintReceiptDTO> receiptListV2(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      if (CollectionUtil.isNotEmpty(param.getCreateDate())) {
         param.getCreateDate().add(1, CommonUtil.getDayLastTime(param.getCreateDate().get(1)));
      }

      return new PageVO<>(page, this.printMapper.listV2(param).stream().map(lp -> {
         LabelPrintReceiptDTO dto = BeanUtil.copy(lp, LabelPrintReceiptDTO.class);
         dto.setSerialNumber(lp.getReceiptSerialNumber());
         dto.setBasicClass(lp.getContainBasicClass());
         dto.setReviewerName(lp.getReceiptReviewer());
         dto.setPendingPrintedMaterialNumber(lp.getTotalNotPrintNumber());
         dto.setReceipt(BriefIdAndSNDTO.builder().id(lp.getReceiptId()).serialNumber(lp.getReceiptSerialNumber()).receiptType(lp.getReceiptType()).build());
         if (lp.getProjectIds() != null) {
            dto.setProjects(this.projectService.listByIds(lp.getProjectIds()));
         }

         return dto;
      }).collect(Collectors.toList()));
   }

   @Override
   public PageVO<LabelPrintMaterialDTO> materialList(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.printDetailMapper.list(param));
   }

   @Override
   public PageVO<LabelPrintMaterialDTO> materialListV2(QueryLabelPrintDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.printDetailMapper.listV2(param));
   }

   @Override
   public NotPrintedNumberDTO getNumberV2(Boolean boolPartyA) {
      List<TypeAndNumberDO> dos = this.printMapper.countNotPrintedNumberV2(boolPartyA);
      NotPrintedNumberDTO dto = new NotPrintedNumberDTO();

      for (TypeAndNumberDO t : dos) {
         if (MaterialLabelPrintTypeEnum.INBOUND.getType().equals(t.getType())) {
            dto.setInboundMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.OUTBOUND.getType().equals(t.getType())) {
            dto.setOutboundMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.RETURN.getType().equals(t.getType())) {
            dto.setReturnMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.TRANSFER.getType().equals(t.getType())) {
            dto.setTransferMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.SURPLUS.getType().equals(t.getType())) {
            dto.setSurplusMaterial(t.getNotPrinted());
         }

         dto.setTotalMaterial(t.getNotPrinted() + dto.getTotalMaterial());
      }

      return dto;
   }

   @Override
   public NotPrintedNumberDTO getNumber() {
      List<TypeAndNumberDO> dos = this.printMapper.countNotPrintedNumber();
      NotPrintedNumberDTO dto = new NotPrintedNumberDTO();

      for (TypeAndNumberDO t : dos) {
         if (MaterialLabelPrintTypeEnum.INBOUND.getType().equals(t.getType())) {
            dto.setInboundMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.OUTBOUND.getType().equals(t.getType())) {
            dto.setOutboundMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.RETURN.getType().equals(t.getType())) {
            dto.setReturnMaterial(t.getNotPrinted());
         } else if (MaterialLabelPrintTypeEnum.TRANSFER.getType().equals(t.getType())) {
            dto.setTransferMaterial(t.getNotPrinted());
         }

         dto.setTotalMaterial(t.getNotPrinted() + dto.getTotalMaterial());
      }

      return dto;
   }

   @Override
   public LabelPrintReceiptDTO selectById(Long id) {
      Print print = this.printMapper.selectById(id);
      Preconditions.checkArgument(print != null, "当前单据不存在");
      LabelPrintReceiptDTO dto = BeanUtil.copy(print, LabelPrintReceiptDTO.class);
      dto.setSerialNumber(print.getReceiptSerialNumber());
      dto.setBasicClass(print.getContainBasicClass());
      dto.setReviewerName(print.getReceiptReviewer());
      dto.setPendingPrintedMaterialNumber(print.getTotalNotPrintNumber());
      if (print.getProjectIds() != null) {
         dto.setProjects(this.projectService.listByIds(print.getProjectIds()));
      }

      dto.setMaterialList(this.printDetailMapper.getByLabelPrintId(print.getId()));
      return dto;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean savePrintNumber(PrintDTOParam param) {
      PrintDetail printDetail = this.printDetailMapper.selectById(param.getReceiptMaterialId());
      Preconditions.checkArgument(printDetail != null, "当前物料标签信息不存在");
      printDetail.setPrintNumber(param.getNumber() + printDetail.getPrintNumber());
      printDetail.setNotPrintNumber(Math.max(printDetail.getNotPrintNumber() - param.getNumber(), 0));
      printDetail.setBoolPrinted(printDetail.getNotPrintNumber() == 0);
      this.printDetailMapper.updateById(printDetail);
      Print print = this.printMapper.selectById(printDetail.getPrintId());
      print.setTotalPrintNumber(print.getTotalPrintNumber() + param.getNumber());
      print.setTotalNotPrintNumber(Math.max(print.getTotalNotPrintNumber() - param.getNumber(), 0));
      print.setBoolPrinted(print.getTotalNotPrintNumber() == 0);
      this.printMapper.updateById(print);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public String savePrint(PrintDetail printDetail) {
      printDetail.setPrinterId(UserUtil.getCurrentUserId());
      printDetail.setPrinterName(UserUtil.getCurrentName());
      printDetail.setPrintTime(LocalDateTime.now());
      printDetail.setStandardId(printDetail.getStandardId());
      printDetail.setStandardName(printDetail.getStandardName());
      printDetail.setPrintNumber(0);
      Barcode param = BeanUtil.copy(printDetail, Barcode.class);
      if (BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass())) {
         param.setBasicClass(3);
      }

      if (printDetail.getProjectId() != null) {
         int type;
         if (printDetail.getBoolPartyA()) {
            type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
               ? PrintMaterialTypeEnum.A_COMPLETE.getType()
               : PrintMaterialTypeEnum.A_SURPLUS.getType();
         } else {
            type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
               ? PrintMaterialTypeEnum.PROJECT_COMPLETE.getType()
               : PrintMaterialTypeEnum.PROJECT_SURPLUS.getType();
         }

         param.setType(type);
         Barcode barcode = this.barcodeMapper.getByMaterial(param);
         if (barcode != null) {
            printDetail.setBarcode(barcode.getValue());
         } else {
            Barcode copy = BeanUtil.copy(printDetail, Barcode.class);
            List<Barcode> bs = this.barcodeMapper
               .selectList(
                  (Wrapper<Barcode>)(((Wrappers.<Barcode>lambdaQuery()
                              .eq(
                                 Barcode::getBasicClass,
                                 BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass()
                              ))
                           .eq(Barcode::getType, type))
                        .eq(Barcode::getProjectId, printDetail.getProjectId()))
                     .orderByDesc(Barcode::getAfterSerialNumber)
               );
            if (CollectionUtil.isNotEmpty(bs)) {
               copy.setAfterSerialNumber(bs.get(0).getAfterSerialNumber() + 1L);
               copy.setFrontSerialNumber(bs.get(0).getFrontSerialNumber());
            } else {
               List<Barcode> ps = this.barcodeMapper.selectList((Wrapper<Barcode>)Wrappers.<Barcode>lambdaQuery().eq(Barcode::getProjectId, printDetail.getProjectId()));
               if (CollectionUtil.isNotEmpty(ps)) {
                  copy.setFrontSerialNumber(ps.get(0).getFrontSerialNumber());
               } else {
                  List<Barcode> barcodes = this.barcodeMapper
                     .selectList(
                        (Wrapper<Barcode>)(Wrappers.<Barcode>lambdaQuery().isNotNull(Barcode::getProjectId))
                           .orderByDesc(Barcode::getFrontSerialNumber)
                     );
                  copy.setFrontSerialNumber(CollectionUtil.isNotEmpty(barcodes) ? barcodes.get(0).getFrontSerialNumber() + 1L : 1L);
               }

               copy.setAfterSerialNumber(1L);
            }

            copy.setType(type);
            copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass());
            copy.setValue(
               ""
                  + copy.getBasicClass()
                  + type
                  + CommonUtil.getProjectZeroStr(copy.getFrontSerialNumber())
                  + CommonUtil.getProjectZeroStr(copy.getAfterSerialNumber())
            );
            this.barcodeMapper.insert(copy);
            printDetail.setBarcode(copy.getValue());
         }
      } else {
         int type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
            ? PrintMaterialTypeEnum.PUBLIC_COMPLETE.getType()
            : PrintMaterialTypeEnum.PUBLIC_SURPLUS.getType();
         param.setType(type);
         Barcode barcode = this.barcodeMapper.getByMaterial(param);
         if (barcode != null) {
            printDetail.setBarcode(barcode.getValue());
         } else {
            Barcode copy = BeanUtil.copy(printDetail, Barcode.class);
            List<Barcode> bs = this.barcodeMapper
               .selectList(
                  (Wrapper<Barcode>)((Wrappers.<Barcode>lambdaQuery()
                           .eq(
                              Barcode::getBasicClass, BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass()
                           ))
                        .eq(Barcode::getType, type))
                     .orderByDesc(Barcode::getPublicSerialNumber)
               );
            if (CollectionUtil.isNotEmpty(bs)) {
               copy.setPublicSerialNumber(bs.get(0).getPublicSerialNumber() + 1L);
            } else {
               copy.setPublicSerialNumber(1L);
            }

            copy.setType(type);
            copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass());
            copy.setValue("" + copy.getBasicClass() + type + CommonUtil.getZeroStr(copy.getPublicSerialNumber()));
            this.barcodeMapper.insert(copy);
            printDetail.setBarcode(copy.getValue());
         }
      }

      this.printDetailMapper.insert(printDetail);
      return printDetail.getBarcode();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public String savePrint1(PrintDetail printDetail, Outbound outbound) {
      printDetail.setPrinterId(outbound.getApplicantId());
      printDetail.setPrinterName(outbound.getApplicantName());
      printDetail.setPrintTime(LocalDateTime.now());
      printDetail.setStandardId(printDetail.getStandardId());
      printDetail.setStandardName(printDetail.getStandardName());
      printDetail.setPrintNumber(0);
      Barcode param = BeanUtil.copy(printDetail, Barcode.class);
      if (BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass())) {
         param.setBasicClass(3);
      }

      if (printDetail.getProjectId() != null) {
         int type;
         if (printDetail.getBoolPartyA()) {
            type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
               ? PrintMaterialTypeEnum.A_COMPLETE.getType()
               : PrintMaterialTypeEnum.A_SURPLUS.getType();
         } else {
            type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
               ? PrintMaterialTypeEnum.PROJECT_COMPLETE.getType()
               : PrintMaterialTypeEnum.PROJECT_SURPLUS.getType();
         }

         param.setType(type);
         Barcode barcode = this.barcodeMapper.getByMaterial(param);
         if (barcode != null) {
            printDetail.setBarcode(barcode.getValue());
         } else {
            Barcode copy = BeanUtil.copy(printDetail, Barcode.class);
            List<Barcode> bs = this.barcodeMapper
               .selectList(
                  (Wrapper<Barcode>)(((Wrappers.<Barcode>lambdaQuery()
                              .eq(
                                 Barcode::getBasicClass,
                                 BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass()
                              ))
                           .eq(Barcode::getType, type))
                        .eq(Barcode::getProjectId, printDetail.getProjectId()))
                     .orderByDesc(Barcode::getAfterSerialNumber)
               );
            if (CollectionUtil.isNotEmpty(bs)) {
               copy.setAfterSerialNumber(bs.get(0).getAfterSerialNumber() + 1L);
               copy.setFrontSerialNumber(bs.get(0).getFrontSerialNumber());
            } else {
               List<Barcode> ps = this.barcodeMapper.selectList((Wrapper<Barcode>)Wrappers.<Barcode>lambdaQuery().eq(Barcode::getProjectId, printDetail.getProjectId()));
               if (CollectionUtil.isNotEmpty(ps)) {
                  copy.setFrontSerialNumber(ps.get(0).getFrontSerialNumber());
               } else {
                  List<Barcode> barcodes = this.barcodeMapper
                     .selectList(
                        (Wrapper<Barcode>)(Wrappers.<Barcode>lambdaQuery().isNotNull(Barcode::getProjectId))
                           .orderByDesc(Barcode::getFrontSerialNumber)
                     );
                  copy.setFrontSerialNumber(CollectionUtil.isNotEmpty(barcodes) ? barcodes.get(0).getFrontSerialNumber() + 1L : 1L);
               }

               copy.setAfterSerialNumber(1L);
            }

            copy.setType(type);
            copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass());
            copy.setValue(
               ""
                  + copy.getBasicClass()
                  + type
                  + CommonUtil.getProjectZeroStr(copy.getFrontSerialNumber())
                  + CommonUtil.getProjectZeroStr(copy.getAfterSerialNumber())
            );
            this.barcodeMapper.insert(copy);
            printDetail.setBarcode(copy.getValue());
         }
      } else {
         int type = MaterialIsWholeEnum.WHOLE.getType().equals(printDetail.getMaterialIsWhole())
            ? PrintMaterialTypeEnum.PUBLIC_COMPLETE.getType()
            : PrintMaterialTypeEnum.PUBLIC_SURPLUS.getType();
         param.setType(type);
         Barcode barcode = this.barcodeMapper.getByMaterial(param);
         if (barcode != null) {
            printDetail.setBarcode(barcode.getValue());
         } else {
            Barcode copy = BeanUtil.copy(printDetail, Barcode.class);
            List<Barcode> bs = this.barcodeMapper
               .selectList(
                  (Wrapper<Barcode>)((Wrappers.<Barcode>lambdaQuery()
                           .eq(
                              Barcode::getBasicClass, BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass()
                           ))
                        .eq(Barcode::getType, type))
                     .orderByDesc(Barcode::getPublicSerialNumber)
               );
            if (CollectionUtil.isNotEmpty(bs)) {
               copy.setPublicSerialNumber(bs.get(0).getPublicSerialNumber() + 1L);
            } else {
               copy.setPublicSerialNumber(1L);
            }

            copy.setType(type);
            copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(printDetail.getBasicClass()) ? 3 : printDetail.getBasicClass());
            copy.setValue("" + copy.getBasicClass() + type + CommonUtil.getZeroStr(copy.getPublicSerialNumber()));
            this.barcodeMapper.insert(copy);
            printDetail.setBarcode(copy.getValue());
         }
      }

      this.printDetailMapper.insert(printDetail);
      return printDetail.getBarcode();
   }

   @Override
   public Boolean isHave(MaterialInventory materialInventory) {
      if (!MaterialIsWholeEnum.ODDMENT.getType().equals(materialInventory.getMaterialIsWhole())
         && !BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         Integer count = this.printDetailMapper
            .selectCount(
               ((((((((((((Wrappers.<PrintDetail>lambdaQuery()
                                                      .eq(PrintDetail::getBasicClass, materialInventory.getBasicClass()))
                                                   .eq(PrintDetail::getClassifyId, materialInventory.getClassifyId()))
                                                .eq(PrintDetail::getWorkshopId, materialInventory.getWorkshopId()))
                                             .eq(PrintDetail::getWarehouseId, materialInventory.getWarehouseId()))
                                          .eq(PrintDetail::getBoolPartyA, materialInventory.getBoolPartyA()))
                                       .eq(materialInventory.getProjectId() != null, PrintDetail::getProjectId, materialInventory.getProjectId()))
                                    .eq(materialInventory.getSpecification() != null, PrintDetail::getSpecification, materialInventory.getSpecification()))
                                 .eq(materialInventory.getLength() != null, PrintDetail::getLength, materialInventory.getLength()))
                              .eq(materialInventory.getWidth() != null, PrintDetail::getWidth, materialInventory.getWidth()))
                           .eq(materialInventory.getThickness() != null, PrintDetail::getThickness, materialInventory.getThickness()))
                        .eq(materialInventory.getBrand() != null, PrintDetail::getBrand, materialInventory.getBrand()))
                     .eq(materialInventory.getColor() != null, PrintDetail::getColor, materialInventory.getColor()))
                  .eq(materialInventory.getHeatNoAndBatchNo() != null, PrintDetail::getHeatNoAndBatchNo, materialInventory.getHeatNoAndBatchNo())
            );
         return count > 0;
      } else {
         return false;
      }
   }

   @Override
   public void updateByInboundId(Long inboundId) {
      Print print = this.printMapper
         .selectOne(
            (Wrapper<Print>)(Wrappers.<Print>lambdaQuery().eq(Print::getReceiptId, inboundId))
               .eq(Print::getReceiptType, ReceiptTypeEnum.INBOUND.getType())
         );
      if (print != null) {
         this.printDetailMapper.updatePrinted(print.getId());
         print.setBoolPrinted(true);
         this.printMapper.updateById(print);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void savePrintNews(Print print, List<PrintDetail> printDetailList) {
      if (!CollectionUtil.isEmpty(printDetailList)) {
         print.setTotalNotPrintNumber(0);
         print.setTotalPrintNumber(0);
         print.setBoolPrinted(false);
         this.printMapper.insert(print);
         Map<String, List<PrintDetail>> groupedMap = printDetailList.stream()
            .collect(
               Collectors.groupingBy(
                  detail -> String.format(
                     "%s_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s",
                     detail.getBasicClass(),
                     detail.getClassifyId(),
                     detail.getLength(),
                     detail.getWidth(),
                     detail.getThickness(),
                     detail.getBrand(),
                     detail.getHeatNoAndBatchNo(),
                     detail.getWarehouseId(),
                     detail.getBoolPartyA(),
                     detail.getColor(),
                     detail.getSpecification(),
                     detail.getProjectId()
                  )
               )
            );
         int totalNotPrintNumber = 0;

         for (Entry<String, List<PrintDetail>> entry : groupedMap.entrySet()) {
            List<PrintDetail> group = entry.getValue();
            PrintDetail mergedDetail;
            if (group.size() == 1) {
               mergedDetail = group.get(0);
            } else {
               mergedDetail = this.mergePrintDetails(group);
            }

            mergedDetail.setPrintId(print.getId());
            mergedDetail.setPrinterId(UserUtil.getCurrentUserId());
            mergedDetail.setPrinterName(UserUtil.getCurrentName());
            mergedDetail.setPrintTime(LocalDateTime.now());
            mergedDetail.setStandardId(group.get(0).getStandardId());
            mergedDetail.setStandardName(group.get(0).getStandardName());
            if (mergedDetail.getNotPrintNumber() != null) {
               totalNotPrintNumber += mergedDetail.getNotPrintNumber();
            }

            this.printDetailMapper.insert(mergedDetail);
         }

         print.setTotalNotPrintNumber(totalNotPrintNumber);
         this.printMapper.updateById(print);
      }
   }

   private PrintDetail mergePrintDetails(List<PrintDetail> details) {
      if (CollectionUtil.isEmpty(details)) {
         return null;
      }

      PrintDetail template = details.get(0);
      int totalNotPrintNumber = 0;
      BigDecimal totalQuantity = BigDecimal.ZERO;
      BigDecimal totalMete = BigDecimal.ZERO;

      for (PrintDetail detail : details) {
         if (detail.getNotPrintNumber() != null) {
            totalNotPrintNumber += detail.getNotPrintNumber();
         }

         if (detail.getQuantity() != null) {
            totalQuantity = totalQuantity.add(detail.getQuantity());
         }

         if (detail.getMete() != null) {
            totalMete = totalMete.add(detail.getMete());
         }
      }

      return PrintDetail.builder()
         .printId(template.getPrintId())
         .basicClass(template.getBasicClass())
         .classifyId(template.getClassifyId())
         .classifyName(template.getClassifyName())
         .specification(template.getSpecification())
         .mete(totalMete)
         .quantity(totalQuantity)
         .brand(template.getBrand())
         .heatNoAndBatchNo(template.getHeatNoAndBatchNo())
         .workshopId(template.getWorkshopId())
         .warehouseId(template.getWarehouseId())
         .type(template.getType())
         .boolPartyA(template.getBoolPartyA())
         .length(template.getLength())
         .width(template.getWidth())
         .thickness(template.getThickness())
         .color(template.getColor())
         .notPrintNumber(totalNotPrintNumber)
         .standardId(template.getStandardId())
         .standardName(template.getStandardName())
         .materialIsWhole(template.getMaterialIsWhole())
         .monomerId(template.getMonomerId())
         .areaId(template.getAreaId())
         .projectId(template.getProjectId())
         .barcode(template.getBarcode())
         .build();
   }
}
