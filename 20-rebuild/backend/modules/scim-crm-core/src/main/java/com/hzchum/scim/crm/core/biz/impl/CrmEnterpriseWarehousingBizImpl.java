package com.hzchum.scim.crm.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseInformationBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmNumberPrefixConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmNumberPrefixConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmPageManagementConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBasicsConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBiddingPlatformWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmGovernmentWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmSupplierWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingPageDownLoadDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmEnterpriseWarehousingSimpleInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmEnterpriseWarehousingSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmEnterpriseWarehousingUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmEnterpriseWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmEnterpriseWarehousingMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class CrmEnterpriseWarehousingBizImpl
   extends IBizImpl<CrmEnterpriseWarehousingService, CrmEnterpriseWarehousingMapper, CrmEnterpriseWarehousing>
   implements CrmEnterpriseWarehousingBiz {
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private UserService userService;
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmNumberPrefixConfigBiz crmNumberPrefixConfigBiz;
   @Resource
   private CrmBusinessLicenseInformationBiz crmBusinessLicenseInformationBiz;

   @Transactional
   @Override
   public Boolean saveCrmEnterpriseWarehousing(CrmEnterpriseWarehousingSaveParam param) {
      if (StringUtils.isNotBlank(param.getCreditCode())) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
            .list(Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class).eq(CrmEnterpriseWarehousing::getCreditCode, param.getCreditCode()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(crmEnterpriseWarehousings), "当前信用代码已被使用");
      }

      if (StringUtils.isNotBlank(param.getBusinessName())) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
            .list(Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class).eq(CrmEnterpriseWarehousing::getBusinessName, param.getBusinessName()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(crmEnterpriseWarehousings), "当前企业名称已被使用");
      }

      CrmEnterpriseWarehousing crmEnterpriseWarehousing = BeanUtil.copy(param, CrmEnterpriseWarehousing.class);
      crmEnterpriseWarehousing.setInformantUserName(
         crmEnterpriseWarehousing.getInformantUserId() != null ? this.userService.getById(crmEnterpriseWarehousing.getInformantUserId()).getName() : null
      );
      AddressSimpleInfoDTO addressSimpleInfoDTO = this.sysCountryService.regionalCascadeSplit(param.getRegionList());
      crmEnterpriseWarehousing.setCountryId(addressSimpleInfoDTO.getCountryId());
      crmEnterpriseWarehousing.setProvinceId(addressSimpleInfoDTO.getProvinceId());
      crmEnterpriseWarehousing.setCityId(addressSimpleInfoDTO.getCityId());
      crmEnterpriseWarehousing.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
      crmEnterpriseWarehousing.setRegionId(addressSimpleInfoDTO.getRegionId());
      crmEnterpriseWarehousing.setRegionName(addressSimpleInfoDTO.getRegionName());
      crmEnterpriseWarehousing.setCountryName(addressSimpleInfoDTO.getCountryName());
      crmEnterpriseWarehousing.setCityName(addressSimpleInfoDTO.getCityName());
      crmEnterpriseWarehousing.setProvinceName(addressSimpleInfoDTO.getProvinceName());
      crmEnterpriseWarehousing.setCreateUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         crmEnterpriseWarehousing.setAttachmentIds(
            StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
         );
      }

      crmEnterpriseWarehousing.setSerialNumber(this.crmNumberPrefixConfigBiz.generateSerialNumber(CrmNumberPrefixConfigEnum.ENTERPRISE_FILING.getType()));
      this.baseService.save(crmEnterpriseWarehousing);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateCrmEnterpriseWarehousing(CrmEnterpriseWarehousingUpdateParam param) {
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.baseService.getById(param.getId());
      Preconditions.checkArgument(crmEnterpriseWarehousing != null, "对应企业不存在");
      if (StringUtils.isNotBlank(param.getCreditCode())) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
            .list(
               Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                  .eq(CrmEnterpriseWarehousing::getCreditCode, param.getCreditCode())
                  .ne(CrmEnterpriseWarehousing::getId, param.getId())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(crmEnterpriseWarehousings), "当前信用代码已被使用");
      }

      if (StringUtils.isNotBlank(param.getBusinessName())) {
         List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
            .list(Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(CrmEnterpriseWarehousing::getBusinessName, param.getBusinessName())
               .ne(CrmEnterpriseWarehousing::getId, param.getId()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(crmEnterpriseWarehousings), "当前企业名称已被使用");
      }

      // Editing must preserve the filing identity and existing approval state used by related records.
      BeanUtil.copy(param, crmEnterpriseWarehousing, "crmCheckStatusEnum");
      if (param.getInformantUserId() != null) {
         User informant = this.userService.getById(param.getInformantUserId());
         Preconditions.checkArgument(informant != null, "填报人不存在");
         crmEnterpriseWarehousing.setInformantUserName(informant.getName());
      }
      if (param.getAttachmentIds() != null) {
         crmEnterpriseWarehousing.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      }
      return this.baseService.updateById(crmEnterpriseWarehousing);
   }

   @Override
   public HashMap<String, Integer> summary() {
      HashMap<String, Integer> map = new HashMap<>();
      map.put("enterprisesCount", 0);
      map.put("domesticEnterprisesCount", 0);
      map.put("foreignEnterprisesCount", 0);
      map.put("unauditedCount", 0);
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService.list();
      map.put("enterprisesCount", crmEnterpriseWarehousings.size());
      map.put(
         "domesticEnterprisesCount",
         (int)crmEnterpriseWarehousings.stream()
            .filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != null && crmEnterpriseWarehousing.getCountryId() == 1L)
            .count()
      );
      map.put(
         "foreignEnterprisesCount",
         (int)crmEnterpriseWarehousings.stream()
            .filter(crmEnterpriseWarehousing -> crmEnterpriseWarehousing.getCountryId() != null && crmEnterpriseWarehousing.getCountryId() != 1L)
            .count()
      );
      return map;
   }

   @Override
   public PageVO<CrmEnterpriseWarehousingPageDTO> getCrmEnterpriseWarehousingPage(
      Integer crmCheckStatusEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
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
      String condition,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmEnterpriseWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .apply(endDate != null, "DATE_FORMAT(informant_date_time, '%Y-%m-%d') <= {0}", endDate)
               .apply(startDate != null, "DATE_FORMAT(informant_date_time, '%Y-%m-%d') >= {0}", startDate)
               .eq(countryId != null, CrmEnterpriseWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmEnterpriseWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmEnterpriseWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmEnterpriseWarehousing::getRegionId, regionId)
               .eq(unitPropertyAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitPropertyAllocationConfigId, unitPropertyAllocationConfigId)
               .eq(unitClassConfigurationId != null, CrmEnterpriseWarehousing::getUnitClassConfigurationId, unitClassConfigurationId)
               .eq(industryConfigurationId != null, CrmEnterpriseWarehousing::getIndustryConfigurationId, industryConfigurationId)
               .eq(unitReputationAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitReputationAllocationConfigId, unitReputationAllocationConfigId)
               .like(StringUtils.isNotBlank(businessName), CrmEnterpriseWarehousing::getBusinessName, businessName)
               .like(StringUtils.isNotBlank(creditCode), CrmEnterpriseWarehousing::getCreditCode, creditCode)
               .like(StringUtils.isNotBlank(informantUserName), CrmEnterpriseWarehousing::getInformantUserName, informantUserName)
               .and(
                  condition != null,
                  q -> {
                     LambdaQueryWrapper var10000 = q.like(CrmEnterpriseWarehousing::getCreditCode, condition)
                        .or()
                        .like(CrmEnterpriseWarehousing::getBusinessName, condition)
                        .or()
                        .like(CrmEnterpriseWarehousing::getInformantUserName, condition);
                  }
               )
               .orderByDesc(CrmEnterpriseWarehousing::getInformantDateTime)
         );
      Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, CrmBasicsConfig> basicsConfigMap = this.crmBasicsConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      return new PageVO<>(
         objects,
         crmEnterpriseWarehousings.stream()
            .map(
               item -> {
                  CrmEnterpriseWarehousingPageDTO crmEnterpriseWarehousingPageDTO = BeanUtil.copy(item, CrmEnterpriseWarehousingPageDTO.class);
                  if (item.getUnitPropertyAllocationConfigId() != null) {
                     crmEnterpriseWarehousingPageDTO.setUnitPropertyAllocationConfigName(
                        basicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName()
                     );
                  }

                  if (item.getUnitClassConfigurationId() != null) {
                     crmEnterpriseWarehousingPageDTO.setUnitClassConfigurationName(basicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
                  }

                  if (item.getIndustryConfigurationId() != null) {
                     crmEnterpriseWarehousingPageDTO.setIndustryConfigurationName(basicsConfigMap.get(item.getIndustryConfigurationId()).getName());
                  }

                  if (item.getUnitReputationAllocationConfigId() != null) {
                     crmEnterpriseWarehousingPageDTO.setUnitReputationAllocationConfigName(
                        basicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName()
                     );
                  }

                  if (item.getInformantUserId() != null) {
                     crmEnterpriseWarehousingPageDTO.setInformantUserName(
                        userMap.get(item.getInformantUserId()) != null ? userMap.get(item.getInformantUserId()).getName() : null
                     );
                  }

                  if (item.getCreateUserId() != null) {
                     crmEnterpriseWarehousingPageDTO.setCreateUserName(
                        userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null
                     );
                  }

                  return crmEnterpriseWarehousingPageDTO;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Transactional
   @Override
   public Boolean deleteCrmEnterpriseWarehousing(Long id) {
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmEnterpriseWarehousing != null, "未找到该企业备案信息");
      List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId, id));
      Preconditions.checkArgument(CollectionUtils.isEmpty(crmSupplierWarehousings), "企业备案已挂载供应商备案不可删除");
      List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.crmGovernmentWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId, id));
      Preconditions.checkArgument(CollectionUtils.isEmpty(crmGovernmentWarehousings), "企业备案已挂载政府备案不可删除");
      List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class).eq(CrmBiddingPlatformWarehousing::getCrmEnterpriseWarehousingId, id));
      Preconditions.checkArgument(CollectionUtils.isEmpty(crmBiddingPlatformWarehousings), "企业备案已挂载招标平台备案不可删除");
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingBiz
         .list(Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class).eq(CrmProjectInformationWarehousing::getCrmEnterpriseWarehousingId, id));
      Preconditions.checkArgument(CollectionUtils.isEmpty(crmProjectInformationWarehousings), "企业备案已挂载项目信息不可删除");
      this.baseService.removeById(id);
      return Boolean.TRUE;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> downLoadCrmEnterpriseWarehousingList(
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
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(crmCheckStatusEnum != null, CrmEnterpriseWarehousing::getCrmCheckStatusEnum, crmCheckStatusEnum)
               .apply(startDate != null, "informant_date_time >= {0}", startDate)
               .apply(endDate != null, "informant_date_time <= {0}", endDate)
               .eq(countryId != null, CrmEnterpriseWarehousing::getCountryId, countryId)
               .eq(provinceId != null, CrmEnterpriseWarehousing::getProvinceId, provinceId)
               .eq(cityId != null, CrmEnterpriseWarehousing::getCityId, cityId)
               .eq(regionId != null, CrmEnterpriseWarehousing::getRegionId, regionId)
               .eq(unitPropertyAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitPropertyAllocationConfigId, unitPropertyAllocationConfigId)
               .eq(unitClassConfigurationId != null, CrmEnterpriseWarehousing::getUnitClassConfigurationId, unitClassConfigurationId)
               .eq(industryConfigurationId != null, CrmEnterpriseWarehousing::getIndustryConfigurationId, industryConfigurationId)
               .eq(unitReputationAllocationConfigId != null, CrmEnterpriseWarehousing::getUnitReputationAllocationConfigId, unitReputationAllocationConfigId)
               .like(StringUtils.isNotBlank(businessName), CrmEnterpriseWarehousing::getBusinessName, businessName)
               .like(StringUtils.isNotBlank(creditCode), CrmEnterpriseWarehousing::getCreditCode, creditCode)
               .like(StringUtils.isNotBlank(informantUserName), CrmEnterpriseWarehousing::getInformantUserName, informantUserName)
               .orderByDesc(BaseEntity::getCreateTime)
         );
      Map<Long, CrmBasicsConfig> basicsConfigMap = this.crmBasicsConfigBiz
         .list()
         .stream()
         .collect(Collectors.toMap(CrmBasicsConfig::getId, Function.identity()));
      List<CrmEnterpriseWarehousingPageDownLoadDTO> crmEnterpriseWarehousingPageDownLoadDTOS = new ArrayList<>();
      crmEnterpriseWarehousings.forEach(
         item -> {
            CrmEnterpriseWarehousingPageDownLoadDTO crmEnterpriseWarehousingPageDownLoadDTO = BeanUtil.copy(item, CrmEnterpriseWarehousingPageDownLoadDTO.class);
            if (item.getUnitPropertyAllocationConfigId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setUnitPropertyAllocationConfigName(
                  basicsConfigMap.get(item.getUnitPropertyAllocationConfigId()).getName()
               );
            }

            if (item.getUnitClassConfigurationId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setUnitClassConfigurationName(basicsConfigMap.get(item.getUnitClassConfigurationId()).getName());
            }

            if (item.getIndustryConfigurationId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setIndustryConfigurationName(basicsConfigMap.get(item.getIndustryConfigurationId()).getName());
            }

            if (item.getUnitReputationAllocationConfigId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setUnitReputationAllocationConfigName(
                  basicsConfigMap.get(item.getUnitReputationAllocationConfigId()).getName()
               );
            }

            if (item.getCountryId() == 1L) {
               StringBuilder set = new StringBuilder();
               set.append(StringUtils.isNotBlank(item.getProvinceName()) ? item.getProvinceName() : "");
               set.append(StringUtils.isNotBlank(item.getCityName()) ? item.getCityName() : "");
               crmEnterpriseWarehousingPageDownLoadDTO.setProvinceNameAndCityName(set.toString());
            }

            if (item.getCreateUserId() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setCreateUserName(this.userService.getById(item.getCreateUserId()).getName());
            }

            if (item.getCrmCheckStatusEnum() != null) {
               crmEnterpriseWarehousingPageDownLoadDTO.setCrmCheckStatusEnumName(CrmCheckStatusEnum.getNameByType(item.getCrmCheckStatusEnum()));
            }

            crmEnterpriseWarehousingPageDownLoadDTOS.add(crmEnterpriseWarehousingPageDownLoadDTO);
         }
      );
      List<Map<String, Object>> collect = crmEnterpriseWarehousingPageDownLoadDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(collect);
      return printVO;
   }

   @Override
   public List<CrmEnterpriseWarehousingSimpleInfoDTO> getCrmEnterpriseWarehousingSimpleInfoList() {
      List<CrmEnterpriseWarehousing> crmEnterpriseWarehousings = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
               .eq(CrmEnterpriseWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .orderByDesc(BaseEntity::getCreateTime)
         );
      return crmEnterpriseWarehousings.stream()
         .map(
            crmEnterpriseWarehousing -> {
               CrmEnterpriseWarehousingSimpleInfoDTO crmEnterpriseWarehousingSimpleInfoDTO = BeanUtil.copy(
                  crmEnterpriseWarehousing, CrmEnterpriseWarehousingSimpleInfoDTO.class
               );
               List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.crmGovernmentWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmGovernmentWarehousing.class)
                        .eq(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousing.getId())
                  );
               crmEnterpriseWarehousingSimpleInfoDTO.setHaveCrmGovernment(!CollectionUtil.isEmpty(crmGovernmentWarehousings));
               List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
                        .eq(CrmBiddingPlatformWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousing.getId())
                  );
               crmEnterpriseWarehousingSimpleInfoDTO.setHaveCrmBiddingPlatform(!CollectionUtil.isEmpty(crmBiddingPlatformWarehousings));
               List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
                  .list(
                     Wrappers.lambdaQuery(CrmSupplierWarehousing.class)
                        .eq(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousing.getId())
                  );
               crmEnterpriseWarehousingSimpleInfoDTO.setHaveCrmSupplier(!CollectionUtil.isEmpty(crmSupplierWarehousings));
               return crmEnterpriseWarehousingSimpleInfoDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public CrmEnterpriseWarehousingDetailDTO crmEnterpriseWarehousingDetail(Long id) {
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmEnterpriseWarehousing != null, "企业备案信息不存在");
      CrmEnterpriseWarehousingDetailDTO crmEnterpriseWarehousingDetailDTO = BeanUtil.copy(crmEnterpriseWarehousing, CrmEnterpriseWarehousingDetailDTO.class);
      if (crmEnterpriseWarehousingDetailDTO.getDepartmentId() != null) {
         Department department = this.departmentService.getById(crmEnterpriseWarehousingDetailDTO.getDepartmentId());
         crmEnterpriseWarehousingDetailDTO.setDepartmentName(department != null ? department.getName() : null);
      }

      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmEnterpriseWarehousing.getAttachmentIds())) {
         crmEnterpriseWarehousingDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmEnterpriseWarehousing.getAttachmentIds()));
         crmEnterpriseWarehousingDetailDTO.setAttachmentIds(this.attachmentService.listByIds(crmEnterpriseWarehousing.getAttachmentIds()));
      }

      List<Long> regionIds = Arrays.asList(
            crmEnterpriseWarehousing.getCountryId(),
            crmEnterpriseWarehousing.getProvinceId(),
            crmEnterpriseWarehousing.getCityId(),
            crmEnterpriseWarehousing.getRegionId()
         )
         .stream()
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      crmEnterpriseWarehousingDetailDTO.setRegionList(CollectionUtils.isNotEmpty(regionIds) ? regionIds : null);
      return crmEnterpriseWarehousingDetailDTO;
   }

   @Override
   public Boolean downLoadCrmEnterpriseWarehousingDetail(Long id, HttpServletResponse response) {
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.baseService.getById(id);
      Preconditions.checkArgument(crmEnterpriseWarehousing != null, "企业备案不存在");
      String resourcePath = "files/CrmEnterpriseWarehousingDetailTemplate.xlsx";
      String tempFileName = "CrmEnterpriseWarehousingDetailTemplate";
      String exportFileName = crmEnterpriseWarehousing.getBusinessName() + "企业备案.xlsx";
      Map<String, Object> map = BeanUtil.beanToMap(crmEnterpriseWarehousing);
      if (crmEnterpriseWarehousing.getDepartmentId() != null) {
         map.put("departmentName", this.departmentService.getDepartmentById(crmEnterpriseWarehousing.getDepartmentId()).getName());
      }

      if (crmEnterpriseWarehousing.getCountryId() == 1L) {
         StringBuilder set = new StringBuilder();
         set.append(StringUtils.isNotBlank(crmEnterpriseWarehousing.getProvinceName()) ? crmEnterpriseWarehousing.getProvinceName() : "");
         set.append(StringUtils.isNotBlank(crmEnterpriseWarehousing.getCityName()) ? crmEnterpriseWarehousing.getCityName() : "");
         map.put("provinceNameAndCityName", set.toString());
      }

      if (crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId() != null) {
         map.put("unitPropertyAllocationConfigName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitPropertyAllocationConfigId()).getName());
      }

      if (crmEnterpriseWarehousing.getUnitClassConfigurationId() != null) {
         map.put("unitClassConfigurationName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitClassConfigurationId()).getName());
      }

      if (crmEnterpriseWarehousing.getIndustryConfigurationId() != null) {
         map.put("industryConfigurationName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getIndustryConfigurationId()).getName());
      }

      if (crmEnterpriseWarehousing.getUnitReputationAllocationConfigId() != null) {
         map.put(
            "unitReputationAllocationConfigName", this.crmBasicsConfigBiz.getById(crmEnterpriseWarehousing.getUnitReputationAllocationConfigId()).getName()
         );
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

   @Override
   public Boolean taskPrecheck(Long crmEnterpriseWarehousingId, Integer crmPageManagementConfigEnum) {
      if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.SUPPLIER_WAREHOUSING_RECORD_PAGE_MANAGEMENT.getType())) {
         List<CrmSupplierWarehousing> crmSupplierWarehousings = this.crmSupplierWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmSupplierWarehousing.class).eq(CrmSupplierWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousingId));
         return CollectionUtil.isEmpty(crmSupplierWarehousings);
      } else if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.GOVERNMENT_RECORD_PAGE_MANAGEMENT.getType())) {
         List<CrmGovernmentWarehousing> crmGovernmentWarehousings = this.crmGovernmentWarehousingBiz
            .list(Wrappers.lambdaQuery(CrmGovernmentWarehousing.class).eq(CrmGovernmentWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousingId));
         return CollectionUtil.isEmpty(crmGovernmentWarehousings);
      } else if (crmPageManagementConfigEnum.equals(CrmPageManagementConfigEnum.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.getType())) {
         List<CrmBiddingPlatformWarehousing> crmBiddingPlatformWarehousings = this.crmBiddingPlatformWarehousingBiz
            .list(
               Wrappers.lambdaQuery(CrmBiddingPlatformWarehousing.class)
                  .eq(CrmBiddingPlatformWarehousing::getCrmEnterpriseWarehousingId, crmEnterpriseWarehousingId)
            );
         return CollectionUtil.isEmpty(crmBiddingPlatformWarehousings);
      } else {
         return Boolean.FALSE;
      }
   }
}
