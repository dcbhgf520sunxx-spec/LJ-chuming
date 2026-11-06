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
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmRecordTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBasicsConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmGovernmentWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentTaskPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentTaskPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmGovernmentWarehousingPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.param.CaLockedParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmGovernmentWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmGovernmentWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmGovernmentWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmGovernmentWarehousingMapper;
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
public class CrmGovernmentWarehousingBizImpl
   extends IBizImpl<CrmGovernmentWarehousingService, CrmGovernmentWarehousingMapper, CrmGovernmentWarehousing>
   implements CrmGovernmentWarehousingBiz {
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private UserService userService;

   @Transactional
   @Override
   public Boolean saveCrmGovernmentWarehousing(CrmGovernmentWarehousingSaveParam copy) {
      CrmGovernmentWarehousing crmGovernmentWarehousing = BeanUtil.copy(copy, CrmGovernmentWarehousing.class);
      crmGovernmentWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      crmGovernmentWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.RECORD.getType());
      crmGovernmentWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         crmGovernmentWarehousing.setAttachmentIds(
            StringUtils.join(copy.getAttachmentIds().stream().map(item -> item.getId()).collect(Collectors.toList()), ",")
         );
      }

      this.baseService.save(crmGovernmentWarehousing);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean deleteCrmGovernmentWarehousing(Long id) {
      CrmGovernmentWarehousing governmentWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(governmentWarehousing != null, "政府备案不存在");
      return this.baseService.removeById(id);
   }

   @Transactional
   @Override
   public Boolean updateCrmGovernmentWarehousing(CrmGovernmentWarehousingUpdateParam copy) {
      CrmGovernmentWarehousing crmGovernmentWarehousing = this.baseService.getById(copy.getId());
      Preconditions.checkArgument(crmGovernmentWarehousing != null, "政府备案不存在");
      BeanUtil.copy(copy, crmGovernmentWarehousing);
      crmGovernmentWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      crmGovernmentWarehousing.setCrmRecordTypeEnum(CrmRecordTypeEnum.RECORD.getType());
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         crmGovernmentWarehousing.setAttachmentIds(
            StringUtils.join(copy.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
         );
      }

      AddressSimpleInfoDTO addressSimpleInfoDTO = this.sysCountryService.regionalCascadeSplit(copy.getRegionList());
      crmGovernmentWarehousing.setCountryId(addressSimpleInfoDTO.getCountryId());
      crmGovernmentWarehousing.setProvinceId(addressSimpleInfoDTO.getProvinceId());
      crmGovernmentWarehousing.setCityId(addressSimpleInfoDTO.getCityId());
      crmGovernmentWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
      crmGovernmentWarehousing.setRegionId(addressSimpleInfoDTO.getRegionId());
      crmGovernmentWarehousing.setRegionName(addressSimpleInfoDTO.getRegionName());
      crmGovernmentWarehousing.setCountryName(addressSimpleInfoDTO.getCountryName());
      crmGovernmentWarehousing.setCityName(addressSimpleInfoDTO.getCityName());
      crmGovernmentWarehousing.setProvinceName(addressSimpleInfoDTO.getProvinceName());
      this.baseService.updateById(crmGovernmentWarehousing);
      return Boolean.TRUE;
   }

   @Override
   public HashMap<String, Integer> summary(Integer checkRecord) {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.baseService
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getCrmRecordTypeEnum, checkRecord));
      if (CollectionUtils.isNotEmpty(crmGovernmentWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmGovernmentWarehousings.stream().map(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
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
   public PageVO<CrmGovernmentWarehousingPageDTO> getCrmGovernmentWarehousingList(
      Integer checkRecord,
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
      String informantUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmGovernmentWarehousingPageDTO> crmGovernmentWarehousingPageDTOS = this.baseMapper
         .getList(
            checkRecord,
            crmCheckStatusEnum,
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
      crmGovernmentWarehousingPageDTOS.forEach(
         item -> {
            if (StringUtils.isNotBlank(item.getAttachmentIds())) {
               item.setAttachmentDTOS(this.attachmentService.listByIds(item.getAttachmentIds()));
            }

            List<Long> regionIds = Arrays.asList(item.getCountryId(), item.getProvinceId(), item.getCityId(), item.getRegionId())
               .stream()
               .filter(Objects::nonNull)
               .collect(Collectors.toList());
            item.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
         }
      );
      return new PageVO<>(objects, crmGovernmentWarehousingPageDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmGovernmentWarehousingList(
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
      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.baseService
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).orderByDesc(BaseEntity::getCreateTime));
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
                  crmGovernmentWarehousings.stream().map(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
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
      List<CrmGovernmentWarehousingPageDownLoadDTO> crmGovernmentWarehousingPageDownLoadDTOS = new ArrayList<>();
      crmEnterpriseWarehousings.forEach(
         item -> {
            CrmGovernmentWarehousingPageDownLoadDTO crmGovernmentWarehousingPageDownLoadDTO = BeanUtil.copy(item, CrmGovernmentWarehousingPageDownLoadDTO.class);
            if (item.getUnitPropertyAllocationConfigId() != null) {
               crmGovernmentWarehousingPageDownLoadDTO.setUnitPropertyAllocationConfigName(
                  basicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName()
               );
            }

            if (item.getUnitClassConfigurationId() != null) {
               crmGovernmentWarehousingPageDownLoadDTO.setUnitClassConfigurationName(basicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
            }

            if (item.getIndustryConfigurationId() != null) {
               crmGovernmentWarehousingPageDownLoadDTO.setIndustryConfigurationName(basicsConfigMap.get(item.getIndustryConfigurationId()).getName());
            }

            if (item.getUnitReputationAllocationConfigId() != null) {
               crmGovernmentWarehousingPageDownLoadDTO.setUnitReputationAllocationConfigName(
                  basicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName()
               );
            }

            if (item.getCountryId() == 1L) {
               StringBuilder set = new StringBuilder();
               set.append(StringUtils.isNotBlank(item.getProvinceName()) ? item.getProvinceName() : "");
               set.append(StringUtils.isNotBlank(item.getCityName()) ? item.getCityName() : "");
               crmGovernmentWarehousingPageDownLoadDTO.setProvinceNameAndCityName(set.toString());
            }

            if (item.getCrmCheckStatusEnum() != null) {
               crmGovernmentWarehousingPageDownLoadDTO.setCrmCheckStatusEnumName(CrmCheckStatusEnum.getNameByType(item.getCrmCheckStatusEnum()));
            }

            if (item.getCreateUserId() != null) {
               crmGovernmentWarehousingPageDownLoadDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
            }

            crmGovernmentWarehousingPageDownLoadDTOS.add(crmGovernmentWarehousingPageDownLoadDTO);
         }
      );
      List<Map<String, Object>> collect = crmGovernmentWarehousingPageDownLoadDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public CrmGovernmentWarehousingDetailDTO crmGovernmentWarehousingDetail(Long id) {
      CrmGovernmentWarehousing governmentWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(governmentWarehousing != null, "政府备案不存在");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(governmentWarehousing.getCrmEnterpriseWarehousingId());
      CrmGovernmentWarehousingDetailDTO warehousingDetailDTO = BeanUtil.copy(governmentWarehousing, CrmGovernmentWarehousingDetailDTO.class);
      warehousingDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      warehousingDetailDTO.setRecordBindProject(governmentWarehousing.getCrmProjectInformationWarehousingId() != null);
      warehousingDetailDTO.setInformantDateTime(governmentWarehousing.getInformantDateTime());
      if (StringUtils.isNotBlank(crmEnterpriseWarehousing.getAddress())) {
         warehousingDetailDTO.setAddress(crmEnterpriseWarehousing.getAddress());
      }

      if (crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId() != null) {
         warehousingDetailDTO.setUnitPropertyAllocationConfigId(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId());
         warehousingDetailDTO.setUnitPropertyAllocationConfigName(
            this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName()
         );
      }

      if (crmEnterpriseWarehousing.getUnitClassConfigurationId() != null) {
         warehousingDetailDTO.setUnitClassConfigurationId(crmEnterpriseWarehousing.getUnitClassConfigurationId());
         warehousingDetailDTO.setUnitClassConfigurationName(this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitClassConfigurationId()).getName());
      }

      List<Long> regionIds = Arrays.asList(
            governmentWarehousing.getCountryId(), governmentWarehousing.getProvinceId(), governmentWarehousing.getCityId(), governmentWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      warehousingDetailDTO.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
      if (governmentWarehousing.getCrmProjectInformationWarehousingId() != null) {
         CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz
            .getById(governmentWarehousing.getCrmProjectInformationWarehousingId());
         warehousingDetailDTO.setCrmProjectInformationWarehousingId(projectInformationWarehousing.getId());
         warehousingDetailDTO.setCrmProjectInformationWarehousingName(projectInformationWarehousing.getProjectName());
      }

      if (StringUtils.isNotBlank(governmentWarehousing.getAttachmentIds())) {
         warehousingDetailDTO.setAttachmentIds(this.attachmentService.listByIds(governmentWarehousing.getAttachmentIds()));
      }

      return warehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmGovernmentWarehousingDetail(Long id, HttpServletResponse response) {
      CrmGovernmentWarehousing crmGovernmentWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmGovernmentWarehousing != null, "政府备案不存在");
      String resourcePath = "files/CrmGovernmentWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmGovernmentWarehousingDetailTemplate";
      String exportFileName = crmGovernmentWarehousing.getSerialNumber() + "政府备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmGovernmentWarehousing);
      Map<Long, CrmBasicsConfig> configMap = this.crmBasicsConfigBiz.list().stream().collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      if (crmGovernmentWarehousing.getCrmEnterpriseWarehousingId() != null) {
         CrmEnterpriseWarehousing warehousingBizById = this.crmEnterpriseWarehousingBiz.getById(crmGovernmentWarehousing.getCrmEnterpriseWarehousingId());
         map.put("biddingPlatformName", warehousingBizById.getBusinessName());
         if (warehousingBizById.getUnitPropertyAllocationConfigId() != null) {
            if (warehousingBizById.getUnitPropertyAllocationConfigId() != null) {
               map.put("reasonForRegistration", configMap.get(warehousingBizById.getUnitPropertyAllocationConfigId()).getName());
            }

            if (warehousingBizById.getUnitClassConfigurationId() != null) {
               map.put("unitClassConfigurationName", configMap.get(warehousingBizById.getUnitPropertyAllocationConfigId()).getName());
            }

            if (StringUtils.isNotBlank(warehousingBizById.getAddress())) {
               map.put("address", warehousingBizById.getAddress());
            }
         }
      }

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

   @Transactional
   @Override
   public Boolean overruleTask(Long id) {
      CrmGovernmentWarehousing crmGovernmentWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmGovernmentWarehousing != null, "招标备案任务不存在");
      Preconditions.checkArgument(crmGovernmentWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.TO_BE_CLAIMED.getType()), "招标备案任务不为待领取不可驳回");
      crmGovernmentWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
      crmGovernmentWarehousing.setOverruleUserName(UserUtil.getCurrentName());
      return this.baseService.updateById(crmGovernmentWarehousing);
   }

   @Override
   public PageVO<CrmGovernmentTaskPageDTO> getCrmGovernmentTaskPage(
      Integer crmCheckStatusEnum,
      LocalDate startDate,
      LocalDate endDate,
      String crmEnterpriseWarehousingName,
      String createUserName,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> crmEnterpriseWarehousingIds = new ArrayList<>();
      if (StringUtils.isNotBlank(crmEnterpriseWarehousingName)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class).like(CrmEnterpriseWarehousing::getBusinessName, crmEnterpriseWarehousingName));
         if (CollectionUtils.isEmpty(crmEnterpriseWarehousings)) {
            return new PageVO<>();
         }

         crmEnterpriseWarehousingIds = crmEnterpriseWarehousings.stream().map(CrmEnterpriseWarehousing::getId).collect(Collectors.toList());
      }

      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .in(
                  CollectionUtils.isNotEmpty(crmEnterpriseWarehousingIds), CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousingIds
               )
               .like(crmCheckStatusEnum != null, CrmGovernmentWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .eq(StringUtils.isNotBlank(createUserName), CrmGovernmentWarehousing::getCreateUserName, createUserName)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      List<CrmGovernmentTaskPageDTO> crmGovernmentTaskPageDTOS = crmGovernmentWarehousings.stream().map(item -> {
         CrmGovernmentTaskPageDTO crmGovernmentTaskPageDTO = BeanUtil.copy(item, CrmGovernmentTaskPageDTO.class);
         crmGovernmentTaskPageDTO.setAttachmentDTOList(this.attachmentService.listByIds(item.getAttachmentIds()));
         return crmGovernmentTaskPageDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(objects, crmGovernmentTaskPageDTOS);
   }

   @Override
   public HashMap<String, Integer> getCrmGovernmentTaskSum() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .eq(CrmGovernmentWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.TO_BE_CLAIMED.getType())
               .or()
               .eq(CrmGovernmentWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.FAIL.getType())
         );
      if (CollectionUtils.isNotEmpty(crmGovernmentWarehousings)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .in(
                     CrmEnterpriseWarehousing::getId,
                     crmGovernmentWarehousings.stream().map(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId).collect(Collectors.toList())
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
   public List<CrmGovernmentTaskPageDownLoadDTO> downLoadCrmGovernmentTaskList(
      Integer crmCheckStatusEnum, LocalDate startDate, LocalDate endDate, String crmEnterpriseWarehousingName, String createUserName
   ) {
      List<Long> crmEnterpriseWarehousingIds = new ArrayList<>();
      if (StringUtils.isNotBlank(crmEnterpriseWarehousingName)) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.crmEnterpriseWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class).like(CrmEnterpriseWarehousing::getBusinessName, crmEnterpriseWarehousingName));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(crmEnterpriseWarehousings), "查询无数据不可下载");
         crmEnterpriseWarehousingIds = crmEnterpriseWarehousings.stream().map(CrmEnterpriseWarehousing::getId).collect(Collectors.toList());
      }

      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
               .in(
                  CollectionUtils.isNotEmpty(crmEnterpriseWarehousingIds), CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousingIds
               )
               .like(crmCheckStatusEnum != null, CrmGovernmentWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .eq(StringUtils.isNotBlank(createUserName), CrmGovernmentWarehousing::getCreateUserName, createUserName)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
         );
      return crmGovernmentWarehousings.stream().map(item -> BeanUtil.copy(item, CrmGovernmentTaskPageDownLoadDTO.class)).collect(Collectors.toList());
   }

   @Transactional
   @Override
   public Boolean caLocked(CaLockedParam caLockedParam) {
      CrmGovernmentWarehousing crmGovernmentWarehousing = this.baseService.getById(caLockedParam.getId());
      Preconditions.checkArgument(crmGovernmentWarehousing != null, "备案信息不存在");
      crmGovernmentWarehousing.setCaLockDate(caLockedParam.getCaDate());
      return this.baseService.updateById(crmGovernmentWarehousing);
   }
}
