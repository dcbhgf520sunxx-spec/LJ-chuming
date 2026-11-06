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
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ContractInfoSourceEnum;
import com.hzchum.scim.contract.core.api.enums.ContractNumberEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import com.hzchum.scim.contract.core.api.pojo._do.ContractPreRegistration;
import com.hzchum.scim.contract.core.api.pojo._do.ContractRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractRegistrationQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRegistrationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractRegistrationDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCatalogueService;
import com.hzchum.scim.contract.core.api.service.ContractFieldConfigService;
import com.hzchum.scim.contract.core.api.service.ContractPreRegistrationService;
import com.hzchum.scim.contract.core.api.service.ContractRegistrationService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.mapper.ContractRegistrationMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo._do.SysLocation;
import com.hzchum.scim.system.core.api.pojo._do.SysProvinceNew;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysLocationService;
import com.hzchum.scim.system.core.api.service.SysProvinceNewService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
public class ContractRegistrationServiceImpl extends ServiceImpl<ContractRegistrationMapper, ContractRegistration> implements ContractRegistrationService {
   @Resource
   private ContractPreRegistrationService contractPreRegistrationService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private ContractCatalogueService contractCatalogueService;
   @Resource
   private ContractFieldConfigService contractFieldConfigService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;
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
   private AttachmentService attachmentService;
   @Resource
   private DepartmentService departmentService;

   @Override
   public PageVO<ContractRegistrationDTO> getList(ContractRegistrationQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Page<ContractRegistration> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractRegistration> contractRegistrations = this.baseMapper.listInfo(param);
      if (CollectionUtil.isEmpty(contractRegistrations)) {
         return new PageVO<>();
      }

      List<ContractRegistrationDTO> contractRegistrationDTOS = this.convertDTO(contractRegistrations);
      return new PageVO<>(page, contractRegistrationDTOS);
   }

   private List<ContractRegistrationDTO> convertDTO(List<ContractRegistration> contractRegistrations) {
      List<ContractRegistrationDTO> contractRegistrationDTOS = new ArrayList<>();
      Map<Long, String> fieldValueMap = this.contractFieldConfigService
         .list(null)
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));
      Map<Long, SysLocation> locationMap = this.sysLocationService.list().stream().collect(Collectors.toMap(SysLocation::getId, item -> (SysLocation)item));
      List<Long> countryIds = contractRegistrations.stream().map(ContractRegistration::getCountryId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysCountry> countryMap = this.sysCountryService.listMapByIds(countryIds);
      List<Long> provinceIds = contractRegistrations.stream().map(ContractRegistration::getProvinceId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysProvinceNew> provinceNewMap = this.sysProvinceNewService.listMapByIds(provinceIds);
      List<Long> cityIds = contractRegistrations.stream().map(ContractRegistration::getCityId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysCity> cityMap = this.sysCityService.listMapByIds(cityIds);
      List<Long> regionIds = contractRegistrations.stream().map(ContractRegistration::getRegionId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysRegion> regionMap = this.sysRegionService.listMapByIds(regionIds);
      List<Long> departmentIds = contractRegistrations.stream()
         .map(ContractRegistration::getApplicantDeptId)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      Map<Long, Department> departmentMap = this.departmentService
         .listByIds(departmentIds)
         .stream()
         .collect(Collectors.toMap(Department::getId, Function.identity()));
      List<Long> preRegistrationIds = contractRegistrations.stream()
         .map(ContractRegistration::getPreRegistrationId)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      Map<Long, ContractPreRegistration> preRegistrationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(preRegistrationIds)) {
         preRegistrationMap = this.contractPreRegistrationService
            .listByIds(preRegistrationIds)
            .stream()
            .collect(Collectors.toMap(ContractPreRegistration::getId, Function.identity()));
      }

      for (ContractRegistration contractRegistration : contractRegistrations) {
         ContractRegistrationDTO copy = BeanUtil.toBean(contractRegistration, ContractRegistrationDTO.class);
         if (contractRegistration.getPartyType() != null) {
            copy.setPartyTypeValue(fieldValueMap.get(contractRegistration.getPartyType()));
         }

         if (contractRegistration.getStructureType() != null) {
            copy.setStructureTypeValue(fieldValueMap.get(contractRegistration.getStructureType()));
         }

         if (contractRegistration.getContractualNature() != null) {
            copy.setContractualNatureValue(fieldValueMap.get(contractRegistration.getContractualNature()));
         }

         if (contractRegistration.getBiddingMethod() != null) {
            copy.setBiddingMethodValue(fieldValueMap.get(contractRegistration.getBiddingMethod()));
         }

         if (contractRegistration.getContractType() != null) {
            copy.setContractTypeValue(fieldValueMap.get(contractRegistration.getContractType()));
         }

         if (contractRegistration.getFirstLevelDept() != null) {
            copy.setFirstLevelDeptValue(fieldValueMap.get(contractRegistration.getFirstLevelDept()));
         }

         if (contractRegistration.getSecondLevelDept() != null) {
            copy.setSecondLevelDeptValue(fieldValueMap.get(contractRegistration.getSecondLevelDept()));
         }

         if (contractRegistration.getLocationId() != null) {
            copy.setLocationValue(locationMap.get(contractRegistration.getLocationId()).getName());
         }

         if (contractRegistration.getCountryId() != null) {
            copy.setCountryValue(countryMap.get(contractRegistration.getCountryId()).getName());
         }

         if (contractRegistration.getProvinceId() != null) {
            copy.setProvinceValue(provinceNewMap.get(contractRegistration.getProvinceId()).getName());
         }

         if (contractRegistration.getCityId() != null) {
            copy.setCityValue(cityMap.get(contractRegistration.getCityId()).getName());
         }

         if (contractRegistration.getRegionId() != null) {
            copy.setRegionValue(regionMap.get(contractRegistration.getRegionId()).getName());
         }

         if (StringUtils.isNotBlank(contractRegistration.getAttachments())) {
            List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(contractRegistration.getAttachments());
            copy.setAttachmentList(attachmentDTOS);
         }

         if (contractRegistration.getPreRegistrationId() != null) {
            ContractPreRegistration contractPreRegistration = preRegistrationMap.get(contractRegistration.getPreRegistrationId());
            IdAndNameDTO build = IdAndNameDTO.builder()
               .id(contractPreRegistration.getId())
               .name(contractPreRegistration.getProjectName())
               .serialNumber(contractPreRegistration.getPreRegistrationNo())
               .build();
            copy.setPreRegistration(build);
         }

         copy.setApplicantDeptName(departmentMap.get(contractRegistration.getApplicantDeptId()).getName());
         contractRegistrationDTOS.add(copy);
      }

      return contractRegistrationDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractRegistration(ContractRegistrationDTOParam dtoParam) {
      this.contractFieldConfigService
         .checkField(
            ListUtil.toList(
               dtoParam.getStructureType(),
               dtoParam.getContractualNature(),
               dtoParam.getBiddingMethod(),
               dtoParam.getPartyType(),
               dtoParam.getContractType(),
               dtoParam.getFirstLevelDept(),
               dtoParam.getSecondLevelDept()
            )
         );
      if (dtoParam.getPreRegistrationId() != null) {
         ContractPreRegistration contractPreRegistration = this.contractPreRegistrationService.getById(dtoParam.getPreRegistrationId());
         Preconditions.checkArgument(contractPreRegistration != null, "合同预登记信息不存在");
         Preconditions.checkArgument(!contractPreRegistration.getBoolQuote(), "合同预登记信息已被引用");
         Preconditions.checkArgument(contractPreRegistration.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()), "合同预登记信息未审核通过");
         List<ContractCatalogue> list = this.contractCatalogueService
            .list(
               (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>()
                     .eq(ContractCatalogue::getPreRegistrationId, contractPreRegistration.getId()))
                  .eq(ContractCatalogue::getReviewStatus, ReviewStatusEnum.RETURNED.getType())
            );
         Preconditions.checkArgument(list.isEmpty(), "合同目录信息已作废");
         this.contractPreRegistrationService
            .update(
               null,
               (Wrapper<ContractPreRegistration>)(new LambdaUpdateWrapper<ContractPreRegistration>()
                     .eq(ContractPreRegistration::getId, contractPreRegistration.getId()))
                  .set(ContractPreRegistration::getBoolQuote, true)
            );
      }

      ContractRegistration contractRegistration = BeanUtil.toBean(dtoParam, ContractRegistration.class);
      String registrationNo = "";
      if (ObjectUtil.isNotEmpty(dtoParam.getInitDataId())) {
         List<ContractRegistration> contractRegistrations = this.baseMapper
            .selectList((Wrapper<ContractRegistration>)new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getInitDataId, dtoParam.getInitDataId()));
         registrationNo = dtoParam.getRegistrationNo() + "-" + contractRegistrations.size();
      } else {
         Integer count = this.baseMapper.getCountByDay(LocalDateTime.now(), dtoParam.getRegistrationType());
         String yyyy_mm_dd = new SimpleDateFormat("yyyyMMdd").format(new Date());
         registrationNo = (
               dtoParam.getRegistrationType() == 1
                  ? ContractNumberEnum.CONTRACT_REVIEW_REGISTRATION.getPrefix()
                  : ContractNumberEnum.CONTRACT_IMMEDIATE_REGISTRATION.getPrefix()
            )
            + "-"
            + yyyy_mm_dd
            + "-"
            + (count + 1);
      }

      if (dtoParam.getBoolSupplement()) {
         contractRegistration.setContractNumber(null);
         contractRegistration.setApproveRecordId(null);
         contractRegistration.setReviewPassTime(null);
         contractRegistration.setInitDataId(null);
      }

      contractRegistration.setRegistrationNo(registrationNo);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      contractRegistration.setApplicantId(currentUser.getId());
      contractRegistration.setApplicantName(currentUser.getName());
      contractRegistration.setApplicantDeptId(currentUser.getDepartment().getId());
      contractRegistration.setApplicationDate(LocalDateTime.now());
      this.baseMapper.insert(contractRegistration);
      Integer reviewStatus = ReviewStatusEnum.AUDITING.getType();
      if (dtoParam.getRegistrationType() == 1) {
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
            .createRecord(
               contractRegistration.getId(),
               contractRegistration.getRegistrationNo(),
               ApproveProcessTypeEnumV2.CONTRACT_REVIEW_REGISTRATION.getType(),
               null,
               null,
               null,
               false,
               null,
               null,
               null
            );
         contractRegistration.setApproveRecordId(wmsApproveRecord.getId());
         contractRegistration.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      } else if (dtoParam.getRegistrationType() == 2) {
         reviewStatus = ReviewStatusEnum.REVIEWED.getType();
      }

      contractRegistration.setInitDataId(ObjectUtil.isNotEmpty(dtoParam.getInitDataId()) ? dtoParam.getInitDataId() : contractRegistration.getId());
      this.baseMapper.updateById(contractRegistration);
      if (Objects.equals(reviewStatus, ReviewStatusEnum.REVIEWED.getType())) {
         this.passed(contractRegistration.getId());
      }

      return true;
   }

   @Override
   public ContractRegistrationDTO selectById(Long id) {
      ContractRegistration contractRegistration = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractRegistration), "合同登记信息不存在");
      ContractRegistrationDTO dto = this.convertDTO(ListUtil.toList(contractRegistration)).get(0);
      if (ObjectUtil.isNotEmpty(contractRegistration.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(contractRegistration.getApproveRecordId());
         dto.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      ContractRegistration contractRegistration = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(contractRegistration.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passed(contractRegistration.getId());
         } else {
            this.returned(contractRegistration.getId());
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ContractRegistration contractRegistration = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(contractRegistration.getApplicantId()), "仅创建此合同登记单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(contractRegistration.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      this.wmsApproveRecordService.revocation(contractRegistration.getApproveRecordId());
      if (contractRegistration.getPreRegistrationId() != null) {
         this.contractPreRegistrationService
            .update(
               null,
               (Wrapper<ContractPreRegistration>)(new LambdaUpdateWrapper<ContractPreRegistration>()
                     .eq(ContractPreRegistration::getId, contractRegistration.getPreRegistrationId()))
                  .set(ContractPreRegistration::getBoolQuote, false)
            );
      }

      this.updateBoolRewrite(contractRegistration.getInitDataId(), true);
      contractRegistration.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      return this.baseMapper.updateById(contractRegistration) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(ContractRegistrationDTOParam dtoParam) {
      ContractRegistration contractRegistration = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractRegistration), "合同登记单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(contractRegistration.getReviewStatus()), "此登记单已审核通过");
      Preconditions.checkArgument(!ReviewStatusEnum.AUDITING.getType().equals(contractRegistration.getReviewStatus()), "此登记单正在审核中");
      if (contractRegistration.getContractCatalogueId() != null && this.contractCatalogueService.getById(dtoParam.getContractCatalogueId()) == null) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_EXPIRE, "合同目录版本发生变化，请重新选择项目");
      }

      Long rootId = ObjectUtil.defaultIfNull(contractRegistration.getInitDataId(), contractRegistration.getId());
      ContractRegistration root = this.baseMapper.selectById(rootId);
      dtoParam.setInitDataId(rootId);
      dtoParam.setRegistrationNo(root != null ? root.getRegistrationNo() : contractRegistration.getRegistrationNo());
      this.updateBoolRewrite(rootId, false);
      return this.saveContractRegistration(dtoParam);
   }

   @Override
   public Boolean export(ContractRegistrationQueryDTOParam param, HttpServletResponse response) {
      List<ContractRegistration> contractRegistrations = this.baseMapper.listInfo(param);
      List<ContractRegistrationDTO> contractRegistrationDTOS = this.convertDTO(contractRegistrations);
      Map<String, Object> hashMap = new HashMap<>();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < contractRegistrationDTOS.size(); i++) {
         ContractRegistrationDTO dto = contractRegistrationDTOS.get(i);
         Map<String, Object> map = new HashMap<>();
         map.put("id", i + 1);
         map.put("registrationNo", dto.getRegistrationNo());
         map.put("contractNumber", dto.getContractNumber());
         map.put("partyA", dto.getPartyA());
         map.put("projectName", dto.getProjectName());
         map.put("signerName", dto.getSignerName());
         map.put("firstLevelDept", dto.getFirstLevelDeptValue());
         map.put("secondLevelDept", dto.getSecondLevelDeptValue());
         map.put("contractAmount", dto.getContractAmount());
         map.put("taxRate", dto.getTaxRate());
         map.put("contractType", dto.getContractTypeValue());
         map.put("infoSource", ObjectUtil.isNotEmpty(dto.getInfoSource()) ? ContractInfoSourceEnum.getNameByType(dto.getInfoSource()) : "");
         map.put("projectManager", dto.getProjectManager());
         map.put("boolCoordinate", ObjectUtil.isNotEmpty(dto.getBoolCoordinate()) ? (dto.getBoolCoordinate() ? "是" : "否") : "");
         map.put("boolBidWinningNotice", ObjectUtil.isNotEmpty(dto.getBoolBidWinningNotice()) ? (dto.getBoolBidWinningNotice() ? "是" : "否") : "");
         map.put("drawing", ObjectUtil.isNotEmpty(dto.getDrawing()) ? (dto.getDrawing() == 1 ? "有" : (dto.getDrawing() == 2 ? "无" : "电子版")) : "");
         map.put("boolBidProposals", ObjectUtil.isNotEmpty(dto.getBoolBidProposals()) ? (dto.getBoolBidProposals() ? "是" : "否") : "");
         map.put("boolBidDocument", ObjectUtil.isNotEmpty(dto.getBoolBidDocument()) ? (dto.getBoolBidDocument() ? "是" : "否") : "无");
         map.put("contractualNature", dto.getContractualNatureValue());
         map.put("biddingMethod", dto.getBiddingMethodValue());
         map.put("partyType", dto.getPartyTypeValue());
         map.put("boolFabricatedStructure", ObjectUtil.isNotEmpty(dto.getBoolFabricatedStructure()) ? (dto.getBoolFabricatedStructure() ? "是" : "否") : "");
         map.put("boolModelContract", ObjectUtil.isNotEmpty(dto.getBoolModelContract()) ? (dto.getBoolModelContract() ? "是" : "否") : "");
         map.put("location", dto.getLocationValue());
         map.put("address", this.projectFinanceUtils.getAddress(dto.getCountryId(), dto.getProvinceId(), dto.getCityId(), dto.getRegionId(), "/"));
         map.put("structureType", dto.getStructureTypeValue());
         map.put("structureArea", dto.getStructureArea());
         map.put("mainStructureSteelMete", dto.getMainStructureSteelMete());
         map.put("subfabricSteelMete", dto.getSubfabricSteelMete());
         map.put("maximumSpan", dto.getMaximumSpan());
         map.put(
            "startAndEndTime",
            (ObjectUtil.isNotEmpty(dto.getContractStartDate()) ? DateUtil.format(dto.getContractStartDate(), "yyyy-MM-dd") : "")
               + "~"
               + (ObjectUtil.isNotEmpty(dto.getContractEndDate()) ? DateUtil.format(dto.getContractEndDate(), "yyyy-MM-dd") : "")
         );
         map.put("allDays", dto.getAllDays());
         map.put("prepaymentRatio", dto.getPrepaymentRatio());
         map.put("warrantyRatio", dto.getWarrantyRatio());
         map.put(
            "boolPeasantWorkerWageAccount",
            ObjectUtil.isNotEmpty(dto.getBoolPeasantWorkerWageAccount()) ? (dto.getBoolPeasantWorkerWageAccount() ? "是" : "否") : ""
         );
         map.put("peasantWorkerWageRatio", dto.getPeasantWorkerWageRatio());
         map.put("progressPayment", dto.getProgressPayment());
         map.put("materialInspection", dto.getMaterialInspection());
         map.put("remark", dto.getRemark());
         map.put("applicationDate", ObjectUtil.isNotEmpty(dto.getApplicationDate()) ? DateUtil.format(dto.getApplicationDate(), "yyyy-MM-dd") : "");
         map.put("applicantName", dto.getApplicantName());
         map.put("deptName", dto.getApplicantDeptName());
         map.put("applicationNumber", dto.getApplicationNumber());
         map.put("reviewStatus", ReviewStatusEnum.getNameByType(dto.getReviewStatus()));
         map.put("reviewPassTime", ObjectUtil.isNotEmpty(dto.getReviewPassTime()) ? DateUtil.format(dto.getReviewPassTime(), "yyyy-MM-dd HH:mm:ss") : "");
         mapList.add(map);
      }

      hashMap.put("mapList", mapList);
      String resourcePath = param.getRegistrationType().equals(1) ? "files/ContractRegistrationJudge.xlsx" : "files/ContractRegistrationDirect.xlsx";
      String tempFileName = param.getRegistrationType().equals(1) ? "ContractRegistrationJudge" : "ContractRegistrationDirect";
      String exportFileName = param.getRegistrationType().equals(1) ? "合同评审登记.xlsx" : "合同直接登记.xlsx";
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

   public Boolean passed(Long id) {
      ContractRegistration contractRegistration = this.baseMapper.selectById(id);
      if (contractRegistration.getBoolSupplement()) {
         ContractCatalogue contractCatalogue = BeanUtil.toBean(contractRegistration, ContractCatalogue.class);
         contractCatalogue.setRegistrationId(id);
         contractCatalogue.setCreateSource(2);
         contractCatalogue.setRegisterDate(contractRegistration.getApplicationDate());
         contractCatalogue.setLastEditUserId(contractRegistration.getApplicantId());
         contractCatalogue.setLastEditUserName(contractRegistration.getApplicantName());
         contractCatalogue.setLastEditTime(contractRegistration.getApplicationDate());
         contractCatalogue.setParentId(contractRegistration.getContractCatalogueId());
         contractCatalogue.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         this.contractCatalogueService.saveDate(contractCatalogue, true);
      } else if (contractRegistration.getPreRegistrationId() != null) {
         ContractCatalogue contractCatalogue = this.contractCatalogueService
            .getOne(
               (Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().eq(ContractCatalogue::getPreRegistrationId, contractRegistration.getPreRegistrationId())
            );
         ContractCatalogue bean = BeanUtil.toBean(contractRegistration, ContractCatalogue.class);
         bean.setId(contractCatalogue.getId());
         bean.setVersion(contractCatalogue.getVersion());
         bean.setCreateTime(contractCatalogue.getCreateTime());
         bean.setInitDataId(contractCatalogue.getInitDataId());
         bean.setApplicantId(contractCatalogue.getApplicantId());
         bean.setApplicantName(contractCatalogue.getApplicantName());
         bean.setApplicantDeptId(contractCatalogue.getApplicantDeptId());
         bean.setApplicationDate(contractCatalogue.getApplicationDate());
         bean.setPreRegistrationId(contractRegistration.getPreRegistrationId());
         bean.setRegistrationId(id);
         bean.setLastEditUserId(contractRegistration.getApplicantId());
         bean.setLastEditUserName(contractRegistration.getApplicantName());
         bean.setLastEditTime(contractRegistration.getApplicationDate());
         this.contractCatalogueService.updateById(bean);
      } else {
         ContractCatalogue contractCatalogue = BeanUtil.toBean(contractRegistration, ContractCatalogue.class);
         contractCatalogue.setRegistrationId(id);
         contractCatalogue.setCreateSource(contractRegistration.getRegistrationType().equals(1) ? 1 : 2);
         contractCatalogue.setRegisterDate(contractRegistration.getApplicationDate());
         contractCatalogue.setLastEditUserId(contractRegistration.getApplicantId());
         contractCatalogue.setLastEditUserName(contractRegistration.getApplicantName());
         contractCatalogue.setLastEditTime(contractRegistration.getApplicationDate());
         contractCatalogue.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         this.contractCatalogueService.saveDate(contractCatalogue, true);
      }

      contractRegistration.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      contractRegistration.setReviewPassTime(LocalDateTime.now());
      return this.baseMapper.updateById(contractRegistration) > 0;
   }

   public Boolean returned(Long id) {
      ContractRegistration contractRegistration = this.baseMapper.selectById(id);
      if (contractRegistration.getPreRegistrationId() != null) {
         this.contractPreRegistrationService
            .update(
               null,
               (Wrapper<ContractPreRegistration>)(new LambdaUpdateWrapper<ContractPreRegistration>()
                     .eq(ContractPreRegistration::getId, contractRegistration.getPreRegistrationId()))
                  .set(ContractPreRegistration::getBoolQuote, false)
            );
      }

      this.updateBoolRewrite(contractRegistration.getInitDataId(), true);
      contractRegistration.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      return this.baseMapper.updateById(contractRegistration) > 0;
   }

   private void updateBoolRewrite(Long initDataId, Boolean boolRewrite) {
      List<ContractRegistration> contractRegistrations = this.baseMapper
         .selectList((Wrapper<ContractRegistration>)new LambdaQueryWrapper<ContractRegistration>().eq(ContractRegistration::getInitDataId, initDataId));
      List<Long> approveIds = contractRegistrations.stream()
         .map(ContractRegistration::getApproveRecordId)
         .filter(ObjectUtil::isNotEmpty)
         .collect(Collectors.toList());
      this.wmsApproveRecordService
         .update(
            null,
            (Wrapper<WmsApproveRecord>)(new LambdaUpdateWrapper<WmsApproveRecord>().in(WmsApproveRecord::getId, approveIds))
               .set(WmsApproveRecord::getBoolRewrite, boolRewrite)
         );
   }
}
