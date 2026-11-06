package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmNumberPrefixConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmNumberPrefixConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmRecordTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBasicsConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmSupplierWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierTaskPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierTaskPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmSupplierWarehousingPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmSupplierWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmSupplierWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmSupplierWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmSupplierWarehousingMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmSupplierWarehousingBizImpl
   extends IBizImpl<CrmSupplierWarehousingService, CrmSupplierWarehousingMapper, CrmSupplierWarehousing>
   implements CrmSupplierWarehousingBiz {
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private UserService userService;
   @Resource
   private CrmNumberPrefixConfigBiz crmNumberPrefixConfigBiz;

   @Transactional
   @Override
   public Boolean deleteCrmSupplierWarehousing(Long id) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmSupplierWarehousing != null, "供应商备案不存在");
      return this.baseService.removeById(id);
   }

   @Override
   public HashMap<String, Integer> summary(Integer checkRecord) {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.baseService
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getCrmRecordTypeEnum, checkRecord));
      if (CollectionUtils.isNotEmpty(crmSupplierWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
                  )
            );
         map.put("enterprisesCount", crmEnterpriseWarehousings.size());
         map.put(
            "domesticEnterprisesCount",
            (int)crmEnterpriseWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() == 1L).count()
         );
         map.put(
            "foreignEnterprisesCount",
            (int)crmEnterpriseWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != 1L).count()
         );
      }

      return map;
   }

   @Override
   public PageVO<CrmSupplierWarehousingPageDTO> getCrmSupplierWarehousingPage(
      Integer crmCheckStatusEnum,
      Integer checkRecord,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmSupplierWarehousingPageDTO> crmSupplierWarehousingPageDTOS = this.baseMapper
         .getCrmSupplierWarehousingPage(
            crmCheckStatusEnum,
            checkRecord,
            startDate,
            endDate,
            countryId,
            provinceId,
            cityId,
            regionId,
            unitPropertyAllocationConfigId,
            unitClassConfigurationId,
            industryConfigurationId,
            unitReputationAllocationConfigId,
            businessName,
            creditCode,
            informantUserName
         );
      crmSupplierWarehousingPageDTOS.stream()
         .forEach(
            item -> {
               List<Long> regionIds = Arrays.asList(item.getCountryId(), item.getProvinceId(), item.getCityId(), item.getRegionId())
                  .stream()
                  .filter(Objects::nonNull)
                  .collect(Collectors.toList());
               item.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
               if (StringUtils.isNotBlank(item.getAttachmentIdsByString())) {
                  item.setAttachmentIds(this.attachmentService.listByIds(item.getAttachmentIdsByString()));
               }
            }
         );
      return new PageVO<>(objects, crmSupplierWarehousingPageDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmSupplierWarehousingList(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      Long countryId,
      Long provinceId,
      Long cityId,
      Long regionId,
      Long unitPropertyAllocationConfigId,
      Long unitClassConfigurationId,
      Long industryConfigurationId,
      Long unitReputationAllocationConfigId,
      String businessName,
      String creditCode,
      String informantUserName
   ) {
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.baseService
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).orderByDesc(BaseEntity::getCreateTime));
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
         .list(
            Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmEnterpriseWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmEnterpriseWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmEnterpriseWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmEnterpriseWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmEnterpriseWarehousing::getRegionId, regionId)
               .in(
                  CrmEnterpriseWarehousing::getId,
                  crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
               )
               .eq(unitPropertyAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitPropertyAllocationConfigId, unitPropertyAllocationConfigId)
               .eq(unitClassConfigurationId != null, CrmEnterpriseWarehousing::getUnitClassConfigurationId, unitClassConfigurationId)
               .eq(industryConfigurationId != null, CrmEnterpriseWarehousing::getIndustryConfigurationId, industryConfigurationId)
               .eq(unitReputationAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitReputationAllocationConfigId, unitReputationAllocationConfigId)
               .like(StringUtils.isNotBlank(businessName), CrmEnterpriseWarehousing::getBusinessName, businessName)
               .like(StringUtils.isNotBlank(creditCode), CrmEnterpriseWarehousing::getCreditCode, creditCode)
               .like(StringUtils.isNotBlank(informantUserName), CrmEnterpriseWarehousing::getInformantUserName, informantUserName)
         );
      Map<Long, CrmBasicsConfig> basicsConfigMap = this.crmBasicsConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      List<CrmSupplierWarehousingPageDownLoadDTO> crmSupplierWarehousingPageDownLoadDTOS = new ArrayList<>();
      crmEnterpriseWarehousings.forEach(
         item -> {
            CrmSupplierWarehousingPageDownLoadDTO crmSupplierWarehousingPageDownLoadDTO = BeanUtil.copy(item, CrmSupplierWarehousingPageDownLoadDTO.class);
            if (item.getUnitPropertyAllocationConfigId() != null) {
               crmSupplierWarehousingPageDownLoadDTO.setUnitPropertyAllocationConfigName(
                  basicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName()
               );
            }

            if (item.getUnitClassConfigurationId() != null) {
               crmSupplierWarehousingPageDownLoadDTO.setUnitClassConfigurationName(basicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
            }

            if (item.getIndustryConfigurationId() != null) {
               crmSupplierWarehousingPageDownLoadDTO.setIndustryConfigurationName(basicsConfigMap.get(item.getIndustryConfigurationId()).getName());
            }

            if (item.getUnitReputationAllocationConfigId() != null) {
               crmSupplierWarehousingPageDownLoadDTO.setUnitReputationAllocationConfigName(
                  basicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName()
               );
            }

            if (item.getCountryId() == 1L) {
               StringBuilder set = new StringBuilder();
               set.append(StringUtils.isNotBlank(item.getProvinceName()) ? item.getProvinceName() : "");
               set.append(StringUtils.isNotBlank(item.getCityName()) ? item.getCityName() : "");
               crmSupplierWarehousingPageDownLoadDTO.setProvinceNameAndCityName(set.toString());
            }

            if (item.getCreateUserId() != null) {
               crmSupplierWarehousingPageDownLoadDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
            }

            if (item.getCrmCheckStatusEnum() != null) {
               crmSupplierWarehousingPageDownLoadDTO.setCrmCheckStatusEnumName(CrmCheckStatusEnum.getNameByType(item.getCrmCheckStatusEnum()));
            }

            crmSupplierWarehousingPageDownLoadDTOS.add(crmSupplierWarehousingPageDownLoadDTO);
         }
      );
      List<Map<String, Object>> collect = crmSupplierWarehousingPageDownLoadDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Transactional
   @Override
   public Boolean saveCrmSupplierWarehousing(CrmSupplierWarehousingSaveParam crmSupplierWarehousingSafeParam) {
      CrmSupplierWarehousing supplierWarehousing = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .eq(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId, crmSupplierWarehousingSafeParam.getCrmEnterpriseWarehousingId())
         );
      Preconditions.checkArgument(supplierWarehousing == null, "该企业备案已呗绑定不可重复绑定多个供应商备案");
      supplierWarehousing = BeanUtil.copy(crmSupplierWarehousingSafeParam, CrmSupplierWarehousing.class);
      supplierWarehousing.setSerialNumber(this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.SUPPLIER_FILING.getType()));
      supplierWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      supplierWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.RECORD.getType());
      supplierWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
      if (CollectionUtils.isNotEmpty(crmSupplierWarehousingSafeParam.getAttachmentIds())) {
         supplierWarehousing.setAttachmentIds(
            StringUtils.join(crmSupplierWarehousingSafeParam.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
         );
      }

      this.baseService.save(supplierWarehousing);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateCrmSupplierWarehousing(CrmSupplierWarehousingUpdateParam copy) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.baseService.getById(copy.getId());
      Preconditions.checkArgument(crmSupplierWarehousing != null);
      BeanUtil.copy(copy, crmSupplierWarehousing);
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         crmSupplierWarehousing.setAttachmentIds(StringUtils.join(copy.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ","));
      }

      crmSupplierWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.RECORD.getType());
      AddressSimpleInfoDTO addressSimpleInfoDTO = this.sysCountryService.regionalCascadeSplit(copy.getRegionList());
      crmSupplierWarehousing.setCountryId(addressSimpleInfoDTO.getCountryId());
      crmSupplierWarehousing.setProvinceId(addressSimpleInfoDTO.getProvinceId());
      crmSupplierWarehousing.setCityId(addressSimpleInfoDTO.getCityId());
      crmSupplierWarehousing.setRegionId(addressSimpleInfoDTO.getRegionId());
      crmSupplierWarehousing.setRegionName(addressSimpleInfoDTO.getRegionName());
      crmSupplierWarehousing.setCountryName(addressSimpleInfoDTO.getCountryName());
      crmSupplierWarehousing.setCityName(addressSimpleInfoDTO.getCityName());
      crmSupplierWarehousing.setProvinceName(addressSimpleInfoDTO.getProvinceName());
      return this.baseService.updateById(crmSupplierWarehousing);
   }

   @Override
   public CrmSupplierWarehousingDetailDTO crmSupplierWarehousingDetail(Long id) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmSupplierWarehousing != null, "供应商备案不存在");
      CrmSupplierWarehousingDetailDTO crmSupplierWarehousingDetailDTO = BeanUtil.copy(crmSupplierWarehousing, CrmSupplierWarehousingDetailDTO.class);
      Map<Long, CrmBasicsConfig> configMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(crmSupplierWarehousing.getCrmEnterpriseWarehousingId());
      if (crmEnterpriseWarehousing != null) {
         crmSupplierWarehousingDetailDTO.setCrmEnterpriseWarehousingId(crmEnterpriseWarehousing.getId());
         crmSupplierWarehousingDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         crmSupplierWarehousingDetailDTO.setCreditCode(crmEnterpriseWarehousing.getCreditCode());
         crmSupplierWarehousingDetailDTO.setQualificationAndAbility(crmEnterpriseWarehousing.getQualificationAndAbility());
         crmSupplierWarehousingDetailDTO.setBusinessPhone(crmEnterpriseWarehousing.getBusinessPhone());
         crmSupplierWarehousingDetailDTO.setBusinessEmail(crmEnterpriseWarehousing.getBusinessEmail());
         crmSupplierWarehousingDetailDTO.setAddress(crmEnterpriseWarehousing.getAddress());
         crmSupplierWarehousingDetailDTO.setLiaisons(crmEnterpriseWarehousing.getLiaisons());
         if (crmEnterpriseWarehousing.getUnitClassConfigurationId() != null) {
            crmSupplierWarehousingDetailDTO.setUnitClassConfigurationId(crmEnterpriseWarehousing.getUnitClassConfigurationId());
            crmSupplierWarehousingDetailDTO.setUnitClassConfigurationName(configMap.get(crmEnterpriseWarehousing.getUnitClassConfigurationId()).getName());
         }

         if (crmEnterpriseWarehousing.getIndustryConfigurationId() != null) {
            crmSupplierWarehousingDetailDTO.setIndustryConfigurationId(crmEnterpriseWarehousing.getIndustryConfigurationId());
            crmSupplierWarehousingDetailDTO.setIndustryConfigurationName(configMap.get(crmEnterpriseWarehousing.getIndustryConfigurationId()).getName());
         }

         if (crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId() != null) {
            crmSupplierWarehousingDetailDTO.setUnitPropertyAllocationConfigId(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId());
            crmSupplierWarehousingDetailDTO.setUnitPropertyAllocationConfigName(
               configMap.get(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName()
            );
         }
      }

      List<Long> regionIds = Arrays.asList(
            crmSupplierWarehousing.getCountryId(),
            crmSupplierWarehousing.getProvinceId(),
            crmSupplierWarehousing.getCityId(),
            crmSupplierWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      crmSupplierWarehousingDetailDTO.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
      if (StringUtils.isNotBlank(crmSupplierWarehousing.getAttachmentIds())) {
         crmSupplierWarehousingDetailDTO.setAttachmentIds(this.attachmentService.listByIds(crmSupplierWarehousing.getAttachmentIds()));
      }

      return crmSupplierWarehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmSupplierWarehousingDetail(Long id, HttpServletResponse response) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmSupplierWarehousing != null, "供应商备案不存在");
      CrmEnterpriseWarehousing enterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(crmSupplierWarehousing.getCrmEnterpriseWarehousingId());
      String resourcePath = "files/CrmSupplierWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmSupplierWarehousingDetailTemplate";
      String exportFileName = enterpriseWarehousing.getBusinessName() + "供应商备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmSupplierWarehousing);
      map.put("crmEnterpriseWarehousingName", enterpriseWarehousing.getBusinessName());
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<CrmSupplierTaskPageDTO> getCrmSupplierTaskPage(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      String crmEnterpriseWarehousingName,
      String createUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> crmProjectInformationWarehousingIds = null;
      if (StringUtils.isNotBlank(crmEnterpriseWarehousingName)) {
         List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .like(CrmProjectInformationWarehousing::getProjectName, crmEnterpriseWarehousingName)
            );
         if (CollectionUtils.isEmpty(crmProjectInformationWarehousings)) {
            return new PageVO<>();
         }

         crmProjectInformationWarehousingIds = crmProjectInformationWarehousings.stream()
            .map(CrmProjectInformationWarehousing::getId)
            .collect(Collectors.toList());
      }

      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .in(
                  CollectionUtils.isNotEmpty(crmProjectInformationWarehousingIds),
                  CrmSupplierWarehousing::getCrmProjectInformationWarehousingId,
                  crmProjectInformationWarehousingIds
               )
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .like(StringUtils.isNotBlank(createUserName), CrmSupplierWarehousing::getCreateUserName, createUserName)
               .eq(crmCheckStatusEnum != null, CrmSupplierWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
         );
      List<CrmSupplierTaskPageDTO> crmSupplierTaskPageDTOS = crmSupplierWarehousings.stream()
         .map(item -> BeanUtil.copy(item, CrmSupplierTaskPageDTO.class))
         .collect(Collectors.toList());
      return new PageVO<>(objects, crmSupplierTaskPageDTOS);
   }

   @Override
   public HashMap<String, Integer> getCrmSupplierTaskSum() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .eq(CrmSupplierWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.TO_BE_CLAIMED.getType())
               .or()
               .eq(CrmSupplierWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.FAIL.getType())
         );
      if (CollectionUtils.isNotEmpty(crmSupplierWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmSupplierWarehousings.stream().map(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
                  )
            );
         map.put("enterprisesCount", crmEnterpriseWarehousings.size());
         map.put(
            "domesticEnterprisesCount",
            (int)crmEnterpriseWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() == 1L).count()
         );
         map.put(
            "foreignEnterprisesCount",
            (int)crmEnterpriseWarehousings.stream().filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != 1L).count()
         );
      }

      return map;
   }

   @Override
   public Boolean overruleTask(Long id) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmSupplierWarehousing != null, "招标备案任务不存在");
      Preconditions.checkArgument(crmSupplierWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.TO_BE_CLAIMED.getType()), "招标备案任务不为待领取不可驳回");
      crmSupplierWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
      crmSupplierWarehousing.setOverruleUserName(UserUtil.getCurrentName());
      return this.baseService.updateById(crmSupplierWarehousing);
   }

   @Override
   public List<CrmSupplierTaskPageDownLoadDTO> downLoadCrmSupplierTaskList(
      Integer crmCheckStatusEnum, LocalDate startDate, LocalDate endDate, String crmEnterpriseWarehousingName, String createUserName
   ) {
      List<Long> crmProjectInformationWarehousingIds = null;
      if (StringUtils.isNotBlank(crmEnterpriseWarehousingName)) {
         List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
                  .like(CrmProjectInformationWarehousing::getProjectName, crmEnterpriseWarehousingName)
            );
         if (CollectionUtils.isEmpty(crmProjectInformationWarehousings)) {
            return new ArrayList<>();
         }

         crmProjectInformationWarehousingIds = crmProjectInformationWarehousings.stream()
            .map(CrmProjectInformationWarehousing::getId)
            .collect(Collectors.toList());
      }

      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
               .in(
                  CollectionUtils.isNotEmpty(crmProjectInformationWarehousingIds),
                  CrmSupplierWarehousing::getCrmProjectInformationWarehousingId,
                  crmProjectInformationWarehousingIds
               )
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .like(StringUtils.isNotBlank(createUserName), CrmSupplierWarehousing::getCreateUserName, createUserName)
               .eq(crmCheckStatusEnum != null, CrmSupplierWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
         );
      return crmSupplierWarehousings.stream().map(item -> BeanUtil.copy(item, CrmSupplierTaskPageDownLoadDTO.class)).collect(Collectors.toList());
   }

   @Transactional
   @Override
   public Boolean caLocked(CaLockedParam caLockedParam) {
      CrmSupplierWarehousing crmSupplierWarehousing = this.baseService.getById(caLockedParam.getId());
      Preconditions.checkArgument(crmSupplierWarehousing != null, "备案信息不存在");
      crmSupplierWarehousing.setCaLockDate(caLockedParam.getCaDate());
      return this.baseService.updateById(crmSupplierWarehousing);
   }
}
