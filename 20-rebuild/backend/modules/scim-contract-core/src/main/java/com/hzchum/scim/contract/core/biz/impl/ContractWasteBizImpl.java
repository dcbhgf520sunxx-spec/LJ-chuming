package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.biz.ContractWasteBiz;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteSaleDetailLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteLedgerQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteQueryDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractWasteService;
import com.hzchum.scim.contract.core.mapper.ContractWasteMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSale;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleDetailService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWasteBizImpl extends IBizImpl<ContractWasteService, ContractWasteMapper, ContractWaste> implements ContractWasteBiz {
   private final WasteSaleService wasteSaleService;
   private final WasteSaleDetailService wasteSaleDetailService;
   private final ContractCollectionService collectionService;
   private final ContractInvoiceService invoiceService;

   @Override
   public List<ContractWasteDTO> listAll(ContractWasteQueryDtoParam param) {
      return this.baseService.listByCondition(param);
   }

   @Override
   public PageVO<ContractWasteDTO> pageList(ContractWasteQueryDtoParam param, Integer pageNUmber, Integer pageSize) {
      PageHelper.startPage(pageNUmber, pageSize);
      List<ContractWasteDTO> wasteDTOList = this.baseService.listByCondition(param);
      return new PageVO<>(wasteDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<ContractWasteDtoParam> paramList) {
      paramList.forEach(param -> {
         int count = this.baseService.count(Wrappers.lambdaQuery(ContractWaste.builder().serialNumber(param.getSerialNumber()).build()));
         Preconditions.checkArgument(count == 0, "合同编号已存在!");
         count = this.baseService.count(Wrappers.lambdaQuery(ContractWaste.builder().purchaser(param.getPurchaser()).build()));
         Preconditions.checkArgument(count == 0, "购买方已添加!");
         ContractWaste contractWaste = BeanUtil.copy(param, ContractWaste.class);
         contractWaste.setUserId(UserUtil.getCurrentUserId());
         this.baseService.save(contractWaste);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateList(List<ContractWasteDtoParam> paramList) {
      paramList.forEach(param -> {
         Preconditions.checkArgument(param.getId() != null, "合同id不能为空!");
         ContractWaste contractWaste = this.baseService.getById(param.getId());
         Preconditions.checkArgument(contractWaste != null, "废料合同不存在!");
         if (!param.getSerialNumber().equals(contractWaste.getSerialNumber())) {
            int count = this.baseService.count(Wrappers.lambdaQuery(ContractWaste.builder().serialNumber(param.getSerialNumber()).build()));
            Preconditions.checkArgument(count == 0, "合同编号已存在!");
         }

         if (!param.getPurchaser().equals(contractWaste.getPurchaser())) {
            int count = this.baseService.count(Wrappers.lambdaQuery(ContractWaste.builder().purchaser(param.getPurchaser()).build()));
            Preconditions.checkArgument(count == 0, "购买方已添加!");
         }

         BeanUtil.copy(param, contractWaste);
         contractWaste.setLastEditUserId(UserUtil.getCurrentUserId());
         contractWaste.setLastEditTime(LocalDateTime.now());
         this.baseService.updateById(contractWaste);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractWaste contractWaste = this.baseService.getById(id);
         Preconditions.checkArgument(contractWaste != null, "废料合同不存在!");
         int count = this.wasteSaleService.count(Wrappers.lambdaQuery(WasteSale.builder().contractWasteId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,购买单位已存在购买记录!");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public BigDecimal getSumTotalAmount(ContractWasteLedgerQueryDtoParam param) {
      WasteSaleDetailQueryDtoParam dtoParam = BeanUtil.copy(param, WasteSaleDetailQueryDtoParam.class);
      dtoParam.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
      List<WasteSaleDetailWholeInfoDTO> saleDetailWholeInfoDTOS = this.wasteSaleDetailService.listWasteSaleDetailWholeInfo(dtoParam);
      return saleDetailWholeInfoDTOS.stream().map(WasteSaleDetailWholeInfoDTO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public PageVO<ContractWasteLedgerDTO> pageListWasteLedger(ContractWasteLedgerQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractWasteLedgerDTO> wasteLedgerDTOList = this.baseService.listWasteLedger(param);
      return new PageVO<>(wasteLedgerDTOList);
   }

   @Override
   public PrintVO<List<ContractWasteLedgerDTO>> printWasteLedger(ContractWasteLedgerQueryDtoParam param) {
      PrintVO<List<ContractWasteLedgerDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<ContractWasteLedgerDTO> wasteLedgerDTOList = this.baseService.listWasteLedger(param);
      printVO.setTable(wasteLedgerDTOList);
      return printVO;
   }

   @Override
   public PageVO<ContractWasteSaleDetailLedgerDTO> pageListWasteSaleDetailLedger(ContractWasteLedgerQueryDtoParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      WasteSaleDetailQueryDtoParam dtoParam = BeanUtil.copy(param, WasteSaleDetailQueryDtoParam.class);
      dtoParam.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
      List<WasteSaleDetailWholeInfoDTO> saleDetailWholeInfoDTOList = this.wasteSaleDetailService.listWasteSaleDetailWholeInfo(dtoParam);
      List<ContractWasteSaleDetailLedgerDTO> wasteSaleDetailLedgerDTOS = saleDetailWholeInfoDTOList.stream()
         .map(s -> BeanUtil.copy(s, ContractWasteSaleDetailLedgerDTO.class))
         .collect(Collectors.toList());
      PageInfo<ContractWasteSaleDetailLedgerDTO> pageInfo = PageUtils.getPageInfo(wasteSaleDetailLedgerDTOS, saleDetailWholeInfoDTOList);
      return new PageVO<>(pageInfo);
   }

   @Override
   public PrintVO<List<ContractWasteSaleDetailLedgerDTO>> printListWasteSaleDetailLedger(ContractWasteLedgerQueryDtoParam param) {
      WasteSaleDetailQueryDtoParam dtoParam = BeanUtil.copy(param, WasteSaleDetailQueryDtoParam.class);
      dtoParam.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
      List<WasteSaleDetailWholeInfoDTO> saleDetailWholeInfoDTOList = this.wasteSaleDetailService.listWasteSaleDetailWholeInfo(dtoParam);
      List<ContractWasteSaleDetailLedgerDTO> wasteSaleDetailLedgerDTOS = saleDetailWholeInfoDTOList.stream()
         .map(s -> BeanUtil.copy(s, ContractWasteSaleDetailLedgerDTO.class))
         .collect(Collectors.toList());
      PrintVO<List<ContractWasteSaleDetailLedgerDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(wasteSaleDetailLedgerDTOS);
      return printVO;
   }

   @Override
   public ContractInvoiceCollectionDTO getWasteCollectionInvoiceInfo(Long contractWasteId, Long branchCompanyId) {
      List<ContractCollection> collectionList = this.collectionService
         .list(
            Wrappers.lambdaQuery(
               ContractCollection.builder()
                  .type(CollectionTypeEnum.WASTE_COLLECTION.getType())
                  .contractWasteId(contractWasteId)
                  .collectionUnitId(branchCompanyId)
                  .auditStatus(AuditStatusEnum.SUCCEED.getType())
                  .build()
            )
         );
      BigDecimal collectionAmount = collectionList.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ContractInvoice> invoiceList = this.invoiceService
         .list(
            Wrappers.lambdaQuery(
               ContractInvoice.builder()
                  .type(CreateInvoiceTypeEnum.WASTE_COLLECTION.getType())
                  .contractWasteId(contractWasteId)
                  .invoiceUnitId(branchCompanyId)
                  .auditStatus(AuditStatusEnum.SUCCEED.getType())
                  .build()
            )
         );
      BigDecimal invoiceAmount = invoiceList.stream().map(ContractInvoice::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      return ContractInvoiceCollectionDTO.builder().collectionAmount(collectionAmount).invoiceAmount(invoiceAmount).build();
   }

   public ContractWasteBizImpl(
      final WasteSaleService wasteSaleService,
      final WasteSaleDetailService wasteSaleDetailService,
      final ContractCollectionService collectionService,
      final ContractInvoiceService invoiceService
   ) {
      this.wasteSaleService = wasteSaleService;
      this.wasteSaleDetailService = wasteSaleDetailService;
      this.collectionService = collectionService;
      this.invoiceService = invoiceService;
   }
}
