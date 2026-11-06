package com.hzchum.scim.scm.core.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.scm.core.api.biz.scm.ScmSupplierEvaluateBiz;
import com.hzchum.scim.scm.core.api.enums.SupplierClassEnum;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo._do.SupplierContacts;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierConfig;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierAllBriefDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierEvaluateDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.BatchSaveSupplierDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierEvaluateQueryParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierImportDTOParam;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.api.service.scm.ScmSupplierConfigService;
import com.hzchum.scim.scm.core.mapper.PurchaseOrderMapper;
import com.hzchum.scim.scm.core.mapper.SupplierContactsMapper;
import com.hzchum.scim.scm.core.mapper.SupplierMapper;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.SysProvinceService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AnnualContract;
import com.hzchum.scim.wms.core.api.service.wmsUse.AnnualContractService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
   private static final Logger log = LoggerFactory.getLogger(SupplierServiceImpl.class);
   @Resource
   private SupplierMapper supplierMapper;
   @Resource
   private SupplierContactsMapper supplierContactsMapper;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SysCityService sysCityService;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private SysProvinceService sysProvinceService;
   @Resource
   private SysRegionService sysRegionService;
   @Resource
   private PurchaseOrderMapper purchaseOrderMapper;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private LogisticsOrderService logisticsOrderService;
   @Resource
   private MesBuildingSupplierPriceService mesBuildingSupplierPriceService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private UserService userService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   AnnualContractService annualContractService;
   @Resource
   @Lazy
   private ScmSupplierEvaluateBiz scmSupplierEvaluateBiz;
   @Resource
   private ScmSupplierConfigService scmSupplierConfigService;

   @Override
   public PageVO<SupplierDTO> pageInfo(Integer page, Integer size, List<String> sort, Boolean boolHide, String name) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Supplier> pageInfo = PageHelper.<Supplier>startPage(page, size, s).doSelectPageInfo(() -> this.listInfo(boolHide, name));
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               supplier -> {
                  SupplierDTO supplierDTO = SupplierDTO.builder()
                     .id(supplier.getId())
                     .name(supplier.getName())
                     .shortName(supplier.getShortName())
                     .supplierClassification(supplier.getSupplierClassification())
                     .area(this.getRegionById(supplier).get("join"))
                     .supplierNumber(supplier.getSupplierNumber())
                     .enabled(supplier.getBoolHide())
                     .createTime(supplier.getCreateTime())
                     .build();
                  ScmSupplierEvaluateDTO supplierEvaluateDTO = this.scmSupplierEvaluateBiz.getLatestEvaluateBySupplierId(supplier.getId());
                  if (supplierEvaluateDTO != null) {
                     supplierDTO.setScoreRating(supplierEvaluateDTO.getScoreRating());
                  }

                  if (supplier.getClassifyId() != null) {
                     ScmSupplierConfig scmSupplierConfig = this.scmSupplierConfigService.getById(supplier.getClassifyId());
                     ScmSupplierConfigDTO scmSupplierConfigDTO = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
                     supplierDTO.setScmSupplierConfigDTO(scmSupplierConfigDTO);
                  }

                  return supplierDTO;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<Supplier> listInfo(Boolean boolHide, String name) {
      return this.supplierMapper
         .selectList(
            (((Wrappers.<Supplier>lambdaQuery().orderByDesc(BaseEntity::getCreateTime))
                     .eq(Supplier::getBoolPersonalEnum, Boolean.FALSE))
                  .eq(boolHide != null, Supplier::getBoolHide, boolHide))
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(name), Supplier::getName, name)
         );
   }

   @Override
   public SupplierDetailDTO listById(Long id) {
      Supplier supplier = this.supplierMapper.selectById(id);
      Preconditions.checkArgument(supplier != null, "供应商不存在");
      List<SupplierContacts> supplierContacts = this.supplierContactsMapper
         .selectList((Wrapper<SupplierContacts>)Wrappers.<SupplierContacts>lambdaQuery().eq(SupplierContacts::getSupplierId, supplier.getId()));
      SupplierDetailDTO supplierDetailDTO = BeanUtil.copy(supplier, SupplierDetailDTO.class);
      Map<String, String> map = this.getRegionById(supplier);
      supplierDetailDTO.setCountryName(map.get("country"));
      supplierDetailDTO.setProvinceName(map.get("province"));
      supplierDetailDTO.setCityName(map.get("city"));
      supplierDetailDTO.setRegionName(map.get("region"));
      if (CollectionUtil.isNotEmpty(supplierContacts)) {
         supplierDetailDTO.setContacts(supplierContacts);
      } else {
         supplierDetailDTO.setContacts(new ArrayList<>());
      }

      supplierDetailDTO.setAttachments(this.attachmentService.listByIds(supplier.getAttachments()));
      ScmSupplierEvaluateDTO supplierEvaluateDTO = this.scmSupplierEvaluateBiz.getLatestEvaluateBySupplierId(supplier.getId());
      if (supplierEvaluateDTO != null) {
         supplierDetailDTO.setScoreRating(supplierEvaluateDTO.getScoreRating());
      }

      if (supplier.getClassifyId() != null) {
         ScmSupplierConfig scmSupplierConfig = this.scmSupplierConfigService.getById(supplier.getClassifyId());
         ScmSupplierConfigDTO scmSupplierConfigDTO = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
         supplierDetailDTO.setScmSupplierConfigDTO(scmSupplierConfigDTO);
      }

      return supplierDetailDTO;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveSupplier(SupplierDTOParam supplierDTOParam) {
      Preconditions.checkArgument(
         CollectionUtils.isEmpty(this.supplierMapper.selectList((Wrapper<Supplier>)Wrappers.<Supplier>lambdaQuery().eq(Supplier::getName, supplierDTOParam.getName()))),
         "保存失败，供应商名称已存在"
      );
      Supplier supplier = BeanUtil.copy(supplierDTOParam, Supplier.class);
      this.checkSupplier(supplier);
      NumberConfig numberConfig = this.numberConfigService
         .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.SUPPLIER.getType()));
      Integer count = this.supplierMapper.getCountByDate();
      supplier.setSupplierNumber(CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count));
      if (StrUtil.isNotBlank(supplierDTOParam.getEnterpriseType())) {
         SysDictionary enterpriseType = this.dictionaryService.getByNameAndValue("enterprise_type", supplierDTOParam.getEnterpriseType());
         Preconditions.checkArgument(enterpriseType != null, "保存失败，传入的企业类型不存在");
         supplier.setEnterpriseType(enterpriseType.getValue());
      } else {
         supplier.setEnterpriseType(null);
      }

      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(supplierDTOParam.getAttachments())) {
         supplier.setAttachments(StrUtil.join(",", supplierDTOParam.getAttachments()));
      }

      supplier.setRegistrationDate(supplierDTOParam.getRegistrationDate());
      supplier.setBoolHide(false);
      this.supplierMapper.insert(supplier);

      for (SupplierContacts contact : supplierDTOParam.getContacts()) {
         contact.setSupplierId(supplier.getId());
         this.supplierContactsMapper.insert(contact);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean batchSaveSupplier(List<BatchSaveSupplierDTOParam> dtoParams) {
      for (BatchSaveSupplierDTOParam param : dtoParams) {
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(this.supplierMapper.selectList((Wrapper<Supplier>)Wrappers.<Supplier>lambdaQuery().eq(Supplier::getName, param.getName()))),
            "保存失败，供应商名称已存在"
         );
         Supplier supplier = Supplier.builder().name(param.getName()).shortName(param.getShortName()).socialCode(param.getSocialCode()).build();
         NumberConfig numberConfig = this.numberConfigService
            .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.SUPPLIER.getType()));
         Integer count = this.supplierMapper.getCountByDate();
         supplier.setSupplierNumber(CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count));
         supplier.setBoolHide(false);
         supplier.setSupplierClassification(param.getSupplierClassification());
         supplier.setClassifyId(param.getClassifyId());
         supplier.setQualificationsId(param.getQualificationsId());
         this.supplierMapper.insert(supplier);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateSupplier(SupplierDTOParam supplierDTOParam) {
      Supplier supplier = this.supplierMapper.selectById(supplierDTOParam.getId());
      Preconditions.checkArgument(supplier != null, "修改失败，供应商不存在");
      String oldName = supplier.getName();
      if (!supplierDTOParam.getName().equals(supplier.getName())) {
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(this.supplierMapper.selectList((Wrapper<Supplier>)Wrappers.<Supplier>lambdaQuery().eq(Supplier::getName, supplierDTOParam.getName()))),
            "保存失败，供应商名称已存在"
         );
      }

      ScmSupplierEvaluateDTO supplierEvaluateDTO = this.scmSupplierEvaluateBiz.getLatestEvaluateBySupplierId(supplier.getId());
      if (supplierEvaluateDTO != null) {
         Preconditions.checkArgument(supplierEvaluateDTO.getClassifyId().equals(supplierDTOParam.getClassifyId()), "今年评价记录已存在！无法切换评价分类!");
      }

      BeanUtil.copy(supplierDTOParam, supplier);
      this.checkSupplier(supplier);
      supplier.setSupplierClassification(supplierDTOParam.getSupplierClassification());
      this.supplierContactsMapper.delete((Wrapper<SupplierContacts>)Wrappers.<SupplierContacts>lambdaQuery().eq(SupplierContacts::getSupplierId, supplier.getId()));

      for (SupplierContacts contact : supplierDTOParam.getContacts()) {
         contact.setSupplierId(supplier.getId());
         this.supplierContactsMapper.insert(contact);
      }

      supplier.setAttachments(
         com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(supplierDTOParam.getAttachments())
            ? StrUtil.join(",", supplierDTOParam.getAttachments())
            : null
      );
      supplier.setUpdateTime(LocalDateTime.now());
      if (!supplierDTOParam.getName().equals(oldName)) {
         this.updateSupplierName(supplier);
      }

      return this.supplierMapper.updateById(supplier) == 1;
   }

   private void updateSupplierName(Supplier supplier) {
      ProjectSupplierAccount supplierAccount = this.supplierAccountService
         .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getSupplierId, supplier.getId()));
      if (supplierAccount != null) {
         supplierAccount.setSupplierName(supplier.getName());
         this.supplierAccountService.updateById(supplierAccount);
         User user = this.userService.getById(supplierAccount.getUserId());
         user.setName(supplier.getName());
         user.setPhone(supplier.getCompanyPhone());
         this.userService.updateById(user);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateSupplier(Long id, Boolean boolHide) {
      Supplier supplier = this.supplierMapper.selectById(id);
      Preconditions.checkArgument(supplier != null, "修改失败，供应商不存在");
      supplier.setBoolHide(boolHide);
      supplier.setUpdateTime(LocalDateTime.now());
      return this.supplierMapper.updateById(supplier) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      for (Long id : ids) {
         Supplier supplier = this.supplierMapper.selectById(id);
         Preconditions.checkArgument(supplier != null, "删除失败，传入的供应商id对应的供应商不存在");
         if (SupplierClassEnum.checkPurchaseSupplier(supplier.getSupplierClassification())) {
            Preconditions.checkArgument(
               this.purchaseOrderService.count((Wrapper<PurchaseOrder>)Wrappers.<PurchaseOrder>lambdaQuery().eq(PurchaseOrder::getSupplierId, id)) == 0, "删除失败,当前供应商已被使用"
            );
         }

         if (SupplierClassEnum.LOGISTICS.getType().equals(supplier.getSupplierClassification())) {
            Preconditions.checkArgument(
               this.logisticsOrderService.count(Wrappers.lambdaQuery(LogisticsOrder.class).eq(LogisticsOrder::getSupplierId, id)) == 0, "删除失败,当前供应商已被使用"
            );
            Preconditions.checkArgument(
               this.mesBuildingSupplierPriceService.count(Wrappers.lambdaQuery(MesBuildingSupplierPrice.class).eq(MesBuildingSupplierPrice::getSupplierId, id))
                  == 0,
               "删除失败,当前供应商已被使用"
            );
         }

         int count = this.subcontractOrderService.count(Wrappers.lambdaQuery(SubcontractOrder.class).eq(SubcontractOrder::getSupplierId, id));
         Preconditions.checkArgument(count == 0, "删除失败,当前供应商已被使用");
         this.supplierMapper.deleteById(id);
      }

      return true;
   }

   @Override
   public ListVO<SupplierAllBriefDTO> getAllBrief() {
      return new ListVO<>(this.getBriefSupplier(null));
   }

   @Override
   public ListVO<SupplierAllBriefDTO> getByType(Integer basicClass) {
      return new ListVO<>(this.getBriefSupplier(basicClass));
   }

   @Override
   public String getNameById(Long id) {
      if (id == null) {
         return null;
      }

      Supplier supplier = this.baseMapper.selectById(id);
      return supplier != null ? supplier.getName() : null;
   }

   @Override
   public String getShortNameById(Long id) {
      if (id == null) {
         return null;
      } else {
         Supplier supplier = this.baseMapper.selectById(id);
         if (supplier == null) {
            return null;
         } else {
            return org.apache.commons.lang3.StringUtils.isNotBlank(supplier.getShortName()) ? supplier.getShortName() : supplier.getName();
         }
      }
   }

   @Override
   public ListVO<SupplierAllBriefDTO> getBoolAnnual(Integer boolAnnual) {
      List<SupplierAllBriefDTO> supplierAllBriefDTOS = new ArrayList<>();
      if (boolAnnual == 1) {
         LocalDateTime now = LocalDateTime.now();

         for (AnnualContract annualContract : this.annualContractService
            .list((Wrapper<AnnualContract>)new LambdaQueryWrapper<AnnualContract>().eq(AnnualContract::getStatus, Boolean.FALSE))
            .stream()
            .filter(
               annualContractx -> annualContractx.getTimeStart().minusSeconds(1L).isBefore(now) && annualContractx.getTimeEnd().plusSeconds(1L).isAfter(now)
            )
            .collect(Collectors.toList())) {
            Supplier supplier = this.supplierMapper
               .selectOne(new LambdaQueryWrapper<Supplier>().eq(annualContract.getSupplierId() != null, Supplier::getId, annualContract.getSupplierId()));
            if (supplier != null) {
               SupplierAllBriefDTO supplierAllBriefDTO = BeanUtil.copy(supplier, SupplierAllBriefDTO.class);
               Integer classification = supplier.getSupplierClassification();
               int a = 0;
               if (SupplierClassEnum.checkMaterial(classification)) {
                  a |= 1;
               }

               if (SupplierClassEnum.checkManufactured(classification)) {
                  a |= 2;
               }

               if ((SupplierClassEnum.LOGISTICS.getType() & classification) != 0) {
                  a |= 4;
               }

               if ((SupplierClassEnum.PRO_SUB.getType() & classification) > 0 || (SupplierClassEnum.LABOR_SUB.getType() & classification) > 0) {
                  a |= 8;
               }

               if ((SupplierClassEnum.OTHER.getType() & classification) > 0) {
                  a |= 16;
               }

               supplierAllBriefDTO.setAnnualContractId(annualContract.getId());
               supplierAllBriefDTO.setType(a);
               supplierAllBriefDTO.setBasicClass(annualContract.getBasicClass());
               supplierAllBriefDTOS.add(supplierAllBriefDTO);
            }
         }
      }

      return new ListVO<>(supplierAllBriefDTOS);
   }

   @Override
   public List<SupplierAllBriefDTO> getListBriefByIds(List<Long> ids) {
      return this.supplierMapper
         .selectBatchIds(ids)
         .stream()
         .map(
            supplier -> {
               SupplierAllBriefDTO allBriefDTO = SupplierAllBriefDTO.builder()
                  .id(supplier.getId())
                  .name(supplier.getName())
                  .shortName(supplier.getShortName())
                  .basicClass(supplier.getSupplierClassification())
                  .boolHide(supplier.getBoolHide())
                  .build();
               Integer classification = supplier.getSupplierClassification();
               int a = 0;
               if (SupplierClassEnum.checkMaterial(classification)) {
                  a |= 1;
               }

               if (SupplierClassEnum.checkManufactured(classification)) {
                  a |= 2;
               }

               if ((SupplierClassEnum.LOGISTICS.getType() & classification) != 0) {
                  a |= 4;
               }

               if ((SupplierClassEnum.PRO_SUB.getType() & classification) > 0 || (SupplierClassEnum.LABOR_SUB.getType() & classification) > 0) {
                  a |= 8;
               }

               if ((SupplierClassEnum.OTHER.getType() & classification) > 0) {
                  a |= 16;
               }

               allBriefDTO.setType(a);
               return allBriefDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public void exportSupplierTemplate(HttpServletResponse response) {
      String resourcePath = "files/template/supplier/SupplierTemplate.xlsx";
      String exportFileName = "供应商导入模版.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         log.error("文件下载异常，请联系管理员, {}", e.getMessage());
      }

      assert file != null;
      FileUtil.downloadFile(file, exportFileName);
   }

   @Override
   public void importSupplier(MultipartFile file, HttpServletResponse response) {
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);
      List<SupplierImportDTOParam> importDTOS = null;

      try {
         importDTOS = PoiUtils.importExcel(file, 1, 1, 0, SupplierImportDTOParam.class);
      } catch (Exception e) {
         mistakeExportDTOList.add(this.buildMistakeDTO("导入失败,Excel文件格式出现异常!"));
         this.exportMistakeList(mistakeExportDTOList, response);
      }

      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isEmpty(importDTOS)) {
         mistakeExportDTOList.add(this.buildMistakeDTO("导入失败,导入的表单不能为空!"));
         this.exportMistakeList(mistakeExportDTOList, response);
      }

      if (!importDTOS.stream().allMatch(importDTO -> importDTO.getOrderNo() != null)) {
         mistakeExportDTOList.add(this.buildMistakeDTO("清单序号不能为空!"));
         this.exportMistakeList(mistakeExportDTOList, response);
      }

      if (importDTOS.stream().map(SupplierImportDTOParam::getOrderNo).distinct().count() != importDTOS.size()) {
         mistakeExportDTOList.add(this.buildMistakeDTO("清单序号重复!"));
         this.exportMistakeList(mistakeExportDTOList, response);
      }

      if (importDTOS.stream().map(SupplierImportDTOParam::getName).distinct().count() != importDTOS.size()) {
         mistakeExportDTOList.add(this.buildMistakeDTO("清单供应商名称重复!"));
         this.exportMistakeList(mistakeExportDTOList, response);
      }

      this.checkAddSupplier(importDTOS, mistakeExportDTOList);
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         this.exportMistakeList(mistakeExportDTOList, response);
      }

      for (SupplierImportDTOParam param : importDTOS) {
         Supplier supplier = Supplier.builder().name(param.getName()).shortName(param.getShortName()).socialCode(param.getSocialCode()).build();
         NumberConfig numberConfig = this.numberConfigService
            .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.SUPPLIER.getType()));
         Integer count = this.supplierMapper.getCountByDate();
         supplier.setSupplierNumber(CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count));
         supplier.setBoolHide(false);
         List<String> typeNameList = Arrays.asList(param.getTypeStr().split("/"));
         Integer supplierClassification = 0;

         for (String typeName : typeNameList) {
            Integer type = SupplierClassEnum.getTypeByName(typeName);
            supplierClassification = supplierClassification | type;
         }

         supplier.setSupplierClassification(supplierClassification);
         this.supplierMapper.insert(supplier);
      }

      this.exportMistakeList(mistakeExportDTOList, response);
   }

   @Override
   public void supplierExcel(Boolean boolHide, String name, HttpServletResponse response) {
      List<Supplier> suppliers = this.listInfo(boolHide, name);
      Map<String, Object> map = new HashMap<>();
      List<Map<String, Object>> mapList = new ArrayList<>();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

      for (int i = 0; i < suppliers.size(); i++) {
         Map<String, Object> mapObject = new HashMap<>();
         Supplier supplier = suppliers.get(i);
         mapObject.put("id", i + 1);
         mapObject.put("name", supplier.getName());
         mapObject.put("shortName", supplier.getShortName());
         mapObject.put("area", this.getRegionById(supplier).get("join"));
         mapObject.put("supplierType", BasicClassEnum.getNameStr1(supplier.getSupplierClassification()));
         mapObject.put("enabled", supplier.getBoolHide() ? "禁用" : "启用");
         mapObject.put("createTime", dateTimeFormatter.format(supplier.getCreateTime()));
         mapList.add(mapObject);
      }

      map.put("mapList", mapList);
      String resourcePath = "files/template/supplier/supplierDownload.xlsx";
      String tempFileName = "supplierDownload";
      String exportFileName = "供应商信息.xlsx";
      InputStream inputStream = null;
      File file = null;

      try {
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (Exception e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.wmsDownLoadExcel(exportFileName, response, workbook, null);
   }

   @Override
   public PageVO<SupplierAllBriefDTO> getEvaluateSupplierList(SupplierEvaluateQueryParam param) {
      LambdaQueryWrapper<Supplier> queryWrapper = (LambdaQueryWrapper<Supplier>)(((((Wrappers.<Supplier>lambdaQuery()
                        .and(
                           wrapper -> {
                              LambdaQueryWrapper var10000 = ((wrapper.ne(
                                       Supplier::getBoolPersonalEnum, Boolean.TRUE
                                    ))
                                    .or())
                                 .isNull(Supplier::getBoolPersonalEnum);
                           }
                        ))
                     .isNotNull(Supplier::getClassifyId))
                  .eq(param.getClassifyId() != null, Supplier::getClassifyId, param.getClassifyId()))
               .eq(param.getBoolAnnualEvaluated() != null, Supplier::getBoolAnnualEvaluated, param.getBoolAnnualEvaluated()))
            .and(
               param.getName() != null && !param.getName().isEmpty(),
               wrapper -> {
                  LambdaQueryWrapper var10000 = ((wrapper.like(Supplier::getName, param.getName()))
                        .or())
                     .like(Supplier::getShortName, param.getName());
               }
            ))
         .orderByDesc(BaseEntity::getCreateTime);
      Page<Object> objects = PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<Supplier> suppliers = this.supplierMapper.selectList(queryWrapper);
      List<SupplierAllBriefDTO> dtoList = suppliers.stream().map(supplier -> BeanUtil.copy(supplier, SupplierAllBriefDTO.class)).collect(Collectors.toList());
      return new PageVO<>(objects, dtoList);
   }

   private void checkAddSupplier(List<SupplierImportDTOParam> importDTOS, List<MistakeExportDTO> mistakeExportDTOList) {
      importDTOS.forEach(
         importDTO -> {
            importDTO.setTypeStr(org.apache.commons.lang3.StringUtils.deleteWhitespace(importDTO.getTypeStr()));
            Integer orderNo = importDTO.getOrderNo();
            if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getName())) {
               mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "供应商名称不能为空！"));
            } else {
               if (importDTO.getName().length() > 45) {
                  mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "供应商名称不能超过45个字符！"));
               }

               if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(
                  this.supplierMapper.selectList((Wrapper<Supplier>)Wrappers.<Supplier>lambdaQuery().eq(Supplier::getName, importDTO.getName()))
               )) {
                  mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "供应商名称已经存在！"));
               }
            }

            if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getShortName())) {
               mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "供应商简称不能为空！"));
            } else if (importDTO.getShortName().length() > 45) {
               mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "项目特征不能超过45个字符！"));
            }

            if (org.apache.commons.lang3.StringUtils.isBlank(importDTO.getTypeStr())) {
               mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "供应商分类不能为空！"));
            } else {
               String[] split = importDTO.getTypeStr().split("/");
               if (split.length == 0) {
                  mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "未解析出供应商分类！"));
               } else {
                  List<String> typeNameList = new ArrayList<>(Arrays.asList(split));
                  List<String> allName = SupplierClassEnum.getAllName();
                  if (!allName.containsAll(typeNameList)) {
                     typeNameList.removeAll(allName);
                     mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "系统中供应商分类包含：" + allName + ",未获取到：" + typeNameList));
                  }
               }
            }

            if (org.apache.commons.lang3.StringUtils.isNotBlank(importDTO.getSocialCode()) && importDTO.getSocialCode().length() > 255) {
               mistakeExportDTOList.add(this.buildMistakeDTO(orderNo, "社会统一码长度超出最大范围(255个字符)!"));
            }
         }
      );
   }

   private MistakeExportDTO buildMistakeDTO(String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(null);
      mistake.setErrorMessage(message);
      return mistake;
   }

   private MistakeExportDTO buildMistakeDTO(Integer orderNo, String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(orderNo);
      mistake.setErrorMessage(message);
      return mistake;
   }

   public void exportMistakeList(List<MistakeExportDTO> mistakeExportDTOList, HttpServletResponse response) {
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         String title = "供应商导入出错表";
         String sheetName = "供应商导入出错表";
         String fileName = "供应商导入出错表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.annotatedExportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, ExcelType.XSSF, response);

         try {
            if (response.getOutputStream() != null) {
               response.getOutputStream().close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }

         throw new BusinessException("导入失败,具体信息请查看错误表格!");
      } else {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   private List<SupplierAllBriefDTO> getBriefSupplier(Integer type) {
      return this.supplierMapper
         .getList(type)
         .stream()
         .map(
            supplier -> {
               SupplierAllBriefDTO allBriefDTO = SupplierAllBriefDTO.builder()
                  .id(supplier.getId())
                  .name(supplier.getName())
                  .shortName(supplier.getShortName())
                  .basicClass(supplier.getSupplierClassification())
                  .boolHide(supplier.getBoolHide())
                  .build();
               Integer classification = supplier.getSupplierClassification();
               int a = 0;
               if (SupplierClassEnum.checkMaterial(classification)) {
                  a |= 1;
               }

               if (SupplierClassEnum.checkManufactured(classification)) {
                  a |= 2;
               }

               if ((SupplierClassEnum.LOGISTICS.getType() & classification) != 0) {
                  a |= 4;
               }

               if ((SupplierClassEnum.PRO_SUB.getType() & classification) > 0 || (SupplierClassEnum.LABOR_SUB.getType() & classification) > 0) {
                  a |= 8;
               }

               if ((SupplierClassEnum.OTHER.getType() & classification) > 0) {
                  a |= 16;
               }

               allBriefDTO.setType(a);
               return allBriefDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private void checkSupplier(Supplier supplier) {
      if (supplier.getCountryId() != null) {
         Preconditions.checkArgument(this.sysCountryService.getById(supplier.getCountryId()) != null, "操作失败,国家不存在");
         if (supplier.getProvinceId() != null) {
            Preconditions.checkArgument(this.sysProvinceService.getById(supplier.getProvinceId()) != null, " 操作失败,省级不存在");
            if (supplier.getCityId() != null) {
               Preconditions.checkArgument(this.sysCityService.getById(supplier.getCityId()) != null, "操作失败,市级不存在");
               if (supplier.getRegionId() != null) {
                  Preconditions.checkArgument(this.sysRegionService.getById(supplier.getRegionId()) != null, "操作失败,区/县级不存在");
               }
            }
         }
      }
   }

   private Map<String, String> getRegionById(Supplier supplier) {
      Map<String, String> map = new HashMap<>();
      StringBuilder sb = new StringBuilder("");
      if (supplier.getCountryId() != null) {
         String country = this.sysCountryService.getById(supplier.getCountryId()).getName();
         map.put("country", country);
         sb.append(country);
      }

      if (supplier.getProvinceId() != null) {
         String province = this.sysProvinceService.getById(supplier.getProvinceId()).getName();
         map.put("province", province);
         sb.append(province);
      }

      if (supplier.getCityId() != null) {
         String city = this.sysCityService.getById(supplier.getCityId()).getName();
         map.put("city", city);
         sb.append(city);
      }

      if (supplier.getRegionId() != null) {
         String region = this.sysRegionService.getById(supplier.getRegionId()).getName();
         map.put("region", region);
         sb.append(region);
      }

      map.put("join", sb.toString());
      return map;
   }
}
