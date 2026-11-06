package com.hzchum.scim.contract.core.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ContractInfoSourceEnum;
import com.hzchum.scim.contract.core.api.enums.IssueTimeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import com.hzchum.scim.contract.core.api.pojo._do.ContractPreRegistration;
import com.hzchum.scim.contract.core.api.pojo._do.ContractRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCatalogueQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCatalogueDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCatalogueDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCatalogueService;
import com.hzchum.scim.contract.core.api.service.ContractFieldConfigService;
import com.hzchum.scim.contract.core.api.service.ContractPreRegistrationService;
import com.hzchum.scim.contract.core.api.service.ContractRegistrationService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.api.utils.VersionGenerator;
import com.hzchum.scim.contract.core.mapper.ContractCatalogueMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo._do.SysLocation;
import com.hzchum.scim.system.core.api.pojo._do.SysProvinceNew;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysLocationService;
import com.hzchum.scim.system.core.api.service.SysProvinceNewService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractCatalogueServiceImpl extends ServiceImpl<ContractCatalogueMapper, ContractCatalogue> implements ContractCatalogueService {
   @Resource
   private ContractFieldConfigService contractFieldConfigService;
   @Resource
   private SysLocationService sysLocationService;
   @Resource
   private SysCountryService sysCountryService;
   @Resource
   private SysProvinceNewService sysProvinceNewService;
   @Resource
   private SysCityService sysCityService;
   @Resource
   private SysRegionService sysRegionService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractPreRegistrationService contractPreRegistrationService;
   @Resource
   private ContractRegistrationService contractRegistrationService;

   @Override
   public PageVO<ContractCatalogueDTO> getList(ContractCatalogueQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Page<ContractCatalogue> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractCatalogue> contractCatalogues = this.baseMapper.listInfo(param);
      if (CollectionUtil.isEmpty(contractCatalogues)) {
         return new PageVO<>();
      }

      List<ContractCatalogueDTO> contractCatalogueDTOS = this.convertDTO(contractCatalogues);
      return new PageVO<>(page, contractCatalogueDTOS);
   }

   @Override
   public List<ContractCatalogueDTO> convertDTO(List<ContractCatalogue> contractCatalogues) {
      if (CollectionUtil.isEmpty(contractCatalogues)) {
         return new ArrayList<>();
      }

      List<ContractCatalogueDTO> contractCatalogueDTOS = new ArrayList<>();
      Map<Long, String> fieldValueMap = this.contractFieldConfigService
         .list(null)
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));
      Map<Long, SysLocation> locationMap = this.sysLocationService.list().stream().collect(Collectors.toMap(SysLocation::getId, item -> (SysLocation)item));
      List<Long> countryIds = contractCatalogues.stream().map(ContractCatalogue::getCountryId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysCountry> countryMap = this.sysCountryService.listMapByIds(countryIds);
      List<Long> provinceIds = contractCatalogues.stream().map(ContractCatalogue::getProvinceId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysProvinceNew> provinceNewMap = this.sysProvinceNewService.listMapByIds(provinceIds);
      List<Long> cityIds = contractCatalogues.stream().map(ContractCatalogue::getCityId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysCity> cityMap = this.sysCityService.listMapByIds(cityIds);
      List<Long> regionIds = contractCatalogues.stream().map(ContractCatalogue::getRegionId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysRegion> regionMap = this.sysRegionService.listMapByIds(regionIds);

      for (ContractCatalogue contractCatalogue : contractCatalogues) {
         ContractCatalogueDTO copy = BeanUtil.toBean(contractCatalogue, ContractCatalogueDTO.class);
         if (contractCatalogue.getPartyType() != null) {
            copy.setPartyTypeValue(fieldValueMap.get(contractCatalogue.getPartyType()));
         }

         if (contractCatalogue.getStructureType() != null) {
            copy.setStructureTypeValue(fieldValueMap.get(contractCatalogue.getStructureType()));
         }

         if (contractCatalogue.getContractualNature() != null) {
            copy.setContractualNatureValue(fieldValueMap.get(contractCatalogue.getContractualNature()));
         }

         if (contractCatalogue.getBiddingMethod() != null) {
            copy.setBiddingMethodValue(fieldValueMap.get(contractCatalogue.getBiddingMethod()));
         }

         if (contractCatalogue.getContractType() != null) {
            copy.setContractTypeValue(fieldValueMap.get(contractCatalogue.getContractType()));
         }

         if (contractCatalogue.getFirstLevelDept() != null) {
            copy.setFirstLevelDeptValue(fieldValueMap.get(contractCatalogue.getFirstLevelDept()));
         }

         if (contractCatalogue.getSecondLevelDept() != null) {
            copy.setSecondLevelDeptValue(fieldValueMap.get(contractCatalogue.getSecondLevelDept()));
         }

         if (contractCatalogue.getLocationId() != null) {
            copy.setLocationValue(locationMap.get(contractCatalogue.getLocationId()).getName());
         }

         if (contractCatalogue.getCountryId() != null) {
            copy.setCountryValue(countryMap.get(contractCatalogue.getCountryId()).getName());
         }

         if (contractCatalogue.getProvinceId() != null) {
            copy.setProvinceValue(provinceNewMap.get(contractCatalogue.getProvinceId()).getName());
         }

         if (contractCatalogue.getCityId() != null) {
            copy.setCityValue(cityMap.get(contractCatalogue.getCityId()).getName());
         }

         if (contractCatalogue.getRegionId() != null) {
            copy.setRegionValue(regionMap.get(contractCatalogue.getRegionId()).getName());
         }

         if (StringUtils.isNotBlank(contractCatalogue.getAttachments())) {
            List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(contractCatalogue.getAttachments());
            copy.setAttachmentList(attachmentDTOS);
         }

         contractCatalogueDTOS.add(copy);
      }

      return contractCatalogueDTOS;
   }

   @Override
   public List<ContractCatalogueDTO> getNoSupplementAndNumber() {
      List<ContractCatalogue> contractCatalogues = this.baseMapper
         .selectList(
            (Wrapper<ContractCatalogue>)((new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getBoolSupplement, false))
                  .isNotNull(ContractCatalogue::getContractNumber))
               .eq(ContractCatalogue::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         );
      return this.convertDTO(contractCatalogues);
   }

   @Override
   public Boolean cancellation(Long id, Integer reviewStatus) {
      List<ContractRegistration> list = this.contractRegistrationService
         .list(
            (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getContractCatalogueId, id))
               .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType())
         );
      if (CollectionUtil.isNotEmpty(list)) {
         Preconditions.checkArgument(false, "合同目录下有审核中的评审登记信息");
      }

      return this.baseMapper
            .update(
               null,
               (Wrapper<ContractCatalogue>)(new LambdaUpdateWrapper<ContractCatalogue>().eq(ContractCatalogue::getId, id))
                  .set(ContractCatalogue::getReviewStatus, reviewStatus)
            )
         > 0;
   }

   @Override
   public ContractCatalogueDTO selectById(Long id) {
      ContractCatalogue contractCatalogue = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractCatalogue), "合同目录信息不存在");
      return this.convertDTO(ListUtil.toList(contractCatalogue)).get(0);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(ContractCatalogueDTOParam dtoParam) {
      ContractCatalogue contractCatalogue = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractCatalogue), "合同目录不存在");
      List<ContractRegistration> contractRegistrations = this.contractRegistrationService
         .list(
            (Wrapper<ContractRegistration>)(new LambdaQueryWrapper<ContractRegistration>()
                  .eq(ContractRegistration::getContractCatalogueId, contractCatalogue.getId()))
               .eq(ContractRegistration::getReviewStatus, ReviewStatusEnum.AUDITING.getType())
         );
      if (CollectionUtil.isNotEmpty(contractRegistrations)) {
         Preconditions.checkArgument(false, contractRegistrations.get(0).getRegistrationNo() + "评审单已绑定该合同目录，且正在审核中");
      }

      this.baseMapper.deleteById(contractCatalogue.getId());
      List<ContractCatalogue> contractCatalogues = this.baseMapper
         .selectList((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getContractNumber, dtoParam.getContractNumber()));
      Preconditions.checkArgument(CollectionUtil.isEmpty(contractCatalogues), "合同目录编号已存在");
      ContractCatalogue bean = BeanUtil.toBean(dtoParam, ContractCatalogue.class);
      bean.setInitDataId(contractCatalogue.getInitDataId());
      bean.setApplicantId(contractCatalogue.getApplicantId());
      bean.setApplicantName(contractCatalogue.getApplicantName());
      bean.setApplicationDate(contractCatalogue.getApplicationDate());
      bean.setApplicantDeptId(contractCatalogue.getApplicantDeptId());
      bean.setContractType(contractCatalogue.getContractType());
      bean.setLastEditTime(LocalDateTime.now());
      bean.setLastEditUserId(UserUtil.getCurrentUserId());
      bean.setLastEditUserName(UserUtil.getCurrentName());
      ContractCatalogue contractCatalogueNew = this.saveDate(bean, false);
      this.baseMapper
         .update(
            null,
            (Wrapper<ContractCatalogue>)(new LambdaUpdateWrapper<ContractCatalogue>().eq(ContractCatalogue::getParentId, contractCatalogue.getId()))
               .set(ContractCatalogue::getParentId, contractCatalogueNew.getId())
         );
      return true;
   }

   @Override
   public Boolean export(ContractCatalogueQueryDTOParam param, HttpServletResponse response) {
      List<ContractCatalogue> contractCatalogues = this.baseMapper.listInfo(param);
      List<ContractCatalogueDTO> contractCatalogueDTOS = this.convertDTO(contractCatalogues);
      Map<String, Object> hashMap = new HashMap<>();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < contractCatalogueDTOS.size(); i++) {
         ContractCatalogueDTO dto = contractCatalogueDTOS.get(i);
         Map<String, Object> map = new HashMap<>();
         map.put("id", i + 1);
         map.put("contractNumber", dto.getContractNumber());
         map.put("registerDate", ObjectUtil.isNotEmpty(dto.getRegisterDate()) ? DateUtil.format(dto.getRegisterDate(), "yyyy-MM-dd HH:mm:ss") : "");
         map.put("transferDate", ObjectUtil.isNotEmpty(dto.getTransferDate()) ? DateUtil.format(dto.getTransferDate(), "yyyy-MM-dd HH:mm:ss") : "");
         map.put("signStatus", ObjectUtil.isNotEmpty(dto.getSignStatus()) ? (dto.getSignStatus() ? "是" : "否") : "");
         map.put("signDate", ObjectUtil.isNotEmpty(dto.getSignDate()) ? DateUtil.format(dto.getSignDate(), "yyyy-MM-dd HH:mm:ss") : "");
         map.put("issueTime", ObjectUtil.isNotEmpty(dto.getIssueTime()) ? IssueTimeEnum.getNameByType(dto.getInfoSource()) : "");
         map.put("partyA", dto.getPartyA());
         map.put("projectName", dto.getProjectName());
         map.put("contractAmount", dto.getContractAmount());
         map.put("originalContractAmount", dto.getOriginalContractAmount());
         map.put("signerName", dto.getSignerName());
         map.put("firstLevelDept", dto.getFirstLevelDeptValue());
         map.put("secondLevelDept", dto.getSecondLevelDeptValue());
         map.put("infoSource", ObjectUtil.isNotEmpty(dto.getInfoSource()) ? ContractInfoSourceEnum.getNameByType(dto.getInfoSource()) : "");
         map.put("boolCoordinate", ObjectUtil.isNotEmpty(dto.getBoolCoordinate()) ? (dto.getBoolCoordinate() ? "是" : "否") : "");
         map.put("projectManager", dto.getProjectManager());
         map.put("structureType", dto.getStructureTypeValue());
         map.put("structureArea", dto.getStructureArea());
         map.put("mainStructureSteelMete", dto.getMainStructureSteelMete());
         map.put("subfabricSteelMete", dto.getSubfabricSteelMete());
         map.put("maximumSpan", dto.getMaximumSpan());
         map.put("location", dto.getLocationValue());
         map.put("address", this.projectFinanceUtils.getAddress(dto.getCountryId(), dto.getProvinceId(), dto.getCityId(), dto.getRegionId(), "/"));
         map.put(
            "startAndEndTime",
            (ObjectUtil.isNotEmpty(dto.getContractStartDate()) ? DateUtil.format(dto.getContractStartDate(), "yyyy-MM-dd") : "")
               + "~"
               + (ObjectUtil.isNotEmpty(dto.getContractEndDate()) ? DateUtil.format(dto.getContractEndDate(), "yyyy-MM-dd") : "")
         );
         map.put("contractualNature", dto.getContractualNatureValue());
         map.put("biddingMethod", dto.getBiddingMethodValue());
         map.put("partyType", dto.getPartyTypeValue());
         map.put("boolFabricatedStructure", ObjectUtil.isNotEmpty(dto.getBoolFabricatedStructure()) ? (dto.getBoolFabricatedStructure() ? "是" : "否") : "");
         map.put("boolModelContract", ObjectUtil.isNotEmpty(dto.getBoolModelContract()) ? (dto.getBoolModelContract() ? "是" : "否") : "");
         map.put("pooledAnalysisYear", ObjectUtil.isNotEmpty(dto.getRegisterDate()) ? DateUtil.format(dto.getRegisterDate(), "yyyy") : "");
         map.put("performanceAppraisalYear", ObjectUtil.isNotEmpty(dto.getRegisterDate()) ? DateUtil.format(dto.getRegisterDate(), "yyyy") : "");
         map.put("contractVersion", dto.getContractVersion());
         map.put("remark", dto.getRemark());
         map.put("applicationDate", DateUtil.format(dto.getApplicationDate(), "yyyy-MM-dd HH:mm:ss"));
         map.put("applicantName", dto.getApplicantName());
         map.put("lastEditTime", DateUtil.format(dto.getLastEditTime(), "yyyy-MM-dd HH:mm:ss"));
         map.put("lastEditUserName", dto.getLastEditUserName());
         mapList.add(map);
      }

      hashMap.put("mapList", mapList);
      String resourcePath = "files/ContractCatalogue.xlsx";
      String tempFileName = "ContractCatalogue";
      String exportFileName = "合同目录.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, hashMap);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editContractNumber(List<ContractCatalogueDTOParam> dtoParams) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      LocalDateTime now = LocalDateTime.now();

      for (ContractCatalogueDTOParam dtoParam : dtoParams) {
         List<ContractCatalogue> contractCatalogues = this.baseMapper
            .selectList((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getContractNumber, dtoParam.getContractNumber()));
         Preconditions.checkArgument(CollectionUtil.isEmpty(contractCatalogues), "合同编号已存在");
         ContractCatalogue contractCatalogue = this.baseMapper.selectById(dtoParam.getId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractCatalogue), "合同不存在");
         Preconditions.checkArgument(ObjectUtil.isEmpty(contractCatalogue.getContractNumber()), "合同编号已存在");
         this.baseMapper.deleteById(dtoParam.getId());
         contractCatalogue.setContractNumber(dtoParam.getContractNumber());
         contractCatalogue.setTransferDate(dtoParam.getTransferDate());
         contractCatalogue.setSignStatus(dtoParam.getSignStatus());
         contractCatalogue.setSignDate(dtoParam.getSignDate());
         contractCatalogue.setLastEditUserId(currentUser.getId());
         contractCatalogue.setLastEditUserName(currentUser.getName());
         contractCatalogue.setLastEditTime(now);
         this.baseMapper.insert(contractCatalogue);
         this.contractPreRegistrationService
            .update(
               null,
               (Wrapper<ContractPreRegistration>)(new LambdaUpdateWrapper<ContractPreRegistration>()
                     .eq(ContractPreRegistration::getId, contractCatalogue.getPreRegistrationId()))
                  .set(ContractPreRegistration::getContractNumber, contractCatalogue.getContractNumber())
            );
      }

      return true;
   }

   @Override
   public ContractCatalogue saveDate(ContractCatalogue contractCatalogue, Boolean boolSave) {
      int i = ObjectUtil.isEmpty(contractCatalogue.getContractVersion()) ? 0 : VersionGenerator.getNumberByVersion(contractCatalogue.getContractVersion());
      String versionByNumber = VersionGenerator.getVersionByNumber(i + 1);
      contractCatalogue.setContractVersion(versionByNumber);
      this.baseMapper.insert(contractCatalogue);
      if (boolSave) {
         contractCatalogue.setInitDataId(contractCatalogue.getId());
         this.baseMapper.updateById(contractCatalogue);
      }

      return contractCatalogue;
   }
}
