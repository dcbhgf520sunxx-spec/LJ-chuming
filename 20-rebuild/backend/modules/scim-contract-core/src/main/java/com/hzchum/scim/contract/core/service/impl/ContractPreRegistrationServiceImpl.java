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
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ContractInfoSourceEnum;
import com.hzchum.scim.contract.core.api.enums.ContractNumberEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import com.hzchum.scim.contract.core.api.pojo._do.ContractPreRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractPreRegistrationQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCatalogueDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractPreRegistrationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractPreRegistrationDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractCatalogueService;
import com.hzchum.scim.contract.core.api.service.ContractFieldConfigService;
import com.hzchum.scim.contract.core.api.service.ContractPreRegistrationService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.mapper.ContractPreRegistrationMapper;
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
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractPreRegistrationServiceImpl
   extends ServiceImpl<ContractPreRegistrationMapper, ContractPreRegistration>
   implements ContractPreRegistrationService {
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   ContractCatalogueService contractCatalogueService;
   @Resource
   ContractFieldConfigService contractFieldConfigService;
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

   @Override
   public PageVO<ContractPreRegistrationDTO> getList(ContractPreRegistrationQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      Page<ContractPreRegistration> page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractPreRegistration> contractPreRegistrations = this.baseMapper.listInfo(param);
      if (CollectionUtil.isEmpty(contractPreRegistrations)) {
         return new PageVO<>();
      }

      List<ContractPreRegistrationDTO> contractPreRegistrationDTOS = this.convertDTO(contractPreRegistrations);
      if (CollectionUtil.isNotEmpty(contractPreRegistrationDTOS)) {
         List<Long> preIds = contractPreRegistrationDTOS.stream().map(ContractPreRegistrationDTO::getId).collect(Collectors.toList());
         List<ContractCatalogue> contractCatalogues = this.contractCatalogueService
            .list(
               (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>().in(ContractCatalogue::getPreRegistrationId, preIds))
                  .isNotNull(ContractCatalogue::getContractNumber)
            );
         Map<Long, ContractCatalogueDTO> catalogueDTOMap = this.contractCatalogueService
            .convertDTO(contractCatalogues)
            .stream()
            .collect(Collectors.toMap(ContractCatalogueDTO::getPreRegistrationId, Function.identity()));
         contractPreRegistrationDTOS.forEach(dto -> {
            ContractCatalogueDTO contractCatalogueDTO = catalogueDTOMap.get(dto.getId());
            if (contractCatalogueDTO != null) {
               dto.setContractCatalogueDTO(contractCatalogueDTO);
               dto.setContractCatalogueStatus(contractCatalogueDTO.getReviewStatus());
               dto.setContractNumber(contractCatalogueDTO.getContractNumber());
            }
         });
      }

      return new PageVO<>(page, contractPreRegistrationDTOS);
   }

   private List<ContractPreRegistrationDTO> convertDTO(List<ContractPreRegistration> contractPreRegistrations) {
      if (CollectionUtil.isEmpty(contractPreRegistrations)) {
         return new ArrayList<>();
      }

      List<ContractPreRegistrationDTO> contractPreRegistrationDTOS = new ArrayList<>();
      Map<Long, String> fieldValueMap = this.contractFieldConfigService
         .list(null)
         .stream()
         .collect(Collectors.toMap(ContractFieldConfig::getId, ContractFieldConfig::getFieldValue));
      Map<Long, SysLocation> locationMap = this.sysLocationService.list().stream().collect(Collectors.toMap(SysLocation::getId, item -> (SysLocation)item));
      List<Long> countryIds = contractPreRegistrations.stream()
         .map(ContractPreRegistration::getCountryId)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      Map<Long, SysCountry> countryMap = this.sysCountryService.listMapByIds(countryIds);
      List<Long> provinceIds = contractPreRegistrations.stream()
         .map(ContractPreRegistration::getProvinceId)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      Map<Long, SysProvinceNew> provinceNewMap = this.sysProvinceNewService.listMapByIds(provinceIds);
      List<Long> cityIds = contractPreRegistrations.stream().map(ContractPreRegistration::getCityId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysCity> cityMap = this.sysCityService.listMapByIds(cityIds);
      List<Long> regionIds = contractPreRegistrations.stream().map(ContractPreRegistration::getRegionId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, SysRegion> regionMap = this.sysRegionService.listMapByIds(regionIds);
      List<Long> ids = contractPreRegistrations.stream().map(ContractPreRegistration::getId).collect(Collectors.toList());
      Map<Long, ContractCatalogue> contractCatalogueMap = this.contractCatalogueService
         .list((Wrapper<ContractCatalogue>)new LambdaQueryWrapper<ContractCatalogue>().in(ContractCatalogue::getPreRegistrationId, ids))
         .stream()
         .collect(Collectors.toMap(ContractCatalogue::getPreRegistrationId, item -> (ContractCatalogue)item));

      for (ContractPreRegistration contractPreRegistration : contractPreRegistrations) {
         ContractPreRegistrationDTO copy = BeanUtil.toBean(contractPreRegistration, ContractPreRegistrationDTO.class);
         if (contractPreRegistration.getPartyType() != null) {
            copy.setPartyTypeValue(fieldValueMap.get(contractPreRegistration.getPartyType()));
         }

         if (contractPreRegistration.getStructureType() != null) {
            copy.setStructureTypeValue(fieldValueMap.get(contractPreRegistration.getStructureType()));
         }

         if (contractPreRegistration.getContractualNature() != null) {
            copy.setContractualNatureValue(fieldValueMap.get(contractPreRegistration.getContractualNature()));
         }

         if (contractPreRegistration.getLocationId() != null) {
            copy.setLocationValue(locationMap.get(contractPreRegistration.getLocationId()).getName());
         }

         if (contractPreRegistration.getCountryId() != null) {
            copy.setCountryValue(countryMap.get(contractPreRegistration.getCountryId()).getName());
         }

         if (contractPreRegistration.getProvinceId() != null) {
            copy.setProvinceValue(provinceNewMap.get(contractPreRegistration.getProvinceId()).getName());
         }

         if (contractPreRegistration.getCityId() != null) {
            copy.setCityValue(cityMap.get(contractPreRegistration.getCityId()).getName());
         }

         if (contractPreRegistration.getRegionId() != null) {
            copy.setRegionValue(regionMap.get(contractPreRegistration.getRegionId()).getName());
         }

         ContractCatalogue contractCatalogue = contractCatalogueMap.get(contractPreRegistration.getId());
         copy.setContractNumber(contractCatalogue != null ? contractCatalogue.getContractNumber() : "");
         contractPreRegistrationDTOS.add(copy);
      }

      return contractPreRegistrationDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractFiledConfig(ContractPreRegistrationDTOParam dtoParam) {
      this.contractFieldConfigService.checkField(ListUtil.toList(dtoParam.getPartyType(), dtoParam.getStructureType(), dtoParam.getContractualNature()));
      ContractPreRegistration contractPreRegistration = BeanUtil.toBean(dtoParam, ContractPreRegistration.class);
      String preRegistrationNo = "";
      if (ObjectUtil.isNotEmpty(dtoParam.getInitDataId())) {
         List<ContractPreRegistration> contractPreRegistrations = this.baseMapper
            .selectList((Wrapper<ContractPreRegistration>)new LambdaQueryWrapper<ContractPreRegistration>().eq(ContractPreRegistration::getInitDataId, dtoParam.getInitDataId()));
         preRegistrationNo = dtoParam.getPreRegistrationNo() + "-" + contractPreRegistrations.size();
      } else {
         Integer count = this.baseMapper.getCountByDay(LocalDateTime.now());
         String yyyy_mm_dd = new SimpleDateFormat("yyyyMMdd").format(new Date());
         preRegistrationNo = ContractNumberEnum.CONTRACT_PRE_REGISTRATION.getPrefix() + "-" + yyyy_mm_dd + "-" + count;
      }

      contractPreRegistration.setPreRegistrationNo(preRegistrationNo);
      SecurityUser currentUser = UserUtil.getCurrentUser();
      contractPreRegistration.setApplicantId(currentUser.getId());
      contractPreRegistration.setApplicantName(currentUser.getName());
      contractPreRegistration.setApplicantDeptId(currentUser.getDepartment().getId());
      contractPreRegistration.setApplicationDate(LocalDateTime.now());
      this.baseMapper.insert(contractPreRegistration);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            contractPreRegistration.getId(),
            contractPreRegistration.getPreRegistrationNo(),
            ApproveProcessTypeEnumV2.CONTRACT_PRE_REGISTRATION.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      contractPreRegistration.setApproveRecordId(wmsApproveRecord.getId());
      contractPreRegistration.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      contractPreRegistration.setInitDataId(ObjectUtil.isNotEmpty(dtoParam.getInitDataId()) ? dtoParam.getInitDataId() : contractPreRegistration.getId());
      this.baseMapper.updateById(contractPreRegistration);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(contractPreRegistration.getId());
      }

      return true;
   }

   @Override
   public ContractPreRegistrationDTO selectById(Long id) {
      ContractPreRegistration contractPreRegistration = this.baseMapper.selectById(id);
      ContractPreRegistrationDTO dto = this.convertDTO(ListUtil.toList(contractPreRegistration)).get(0);
      if (ObjectUtil.isNotEmpty(contractPreRegistration.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(contractPreRegistration.getApproveRecordId());
         dto.setWmsApproveRecordFlowDTO(approveRecordFlowDTO);
      }

      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      ContractPreRegistration contractPreRegistration = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(contractPreRegistration.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passed(contractPreRegistration.getId());
         } else {
            this.returned(contractPreRegistration.getId());
         }
      }

      return true;
   }

   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ContractPreRegistration contractPreRegistration = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(contractPreRegistration.getApplicantId()), "仅创建此合同预登记单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(contractPreRegistration.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      this.wmsApproveRecordService.revocation(contractPreRegistration.getApproveRecordId());
      this.updateBoolRewrite(contractPreRegistration.getInitDataId(), true);
      contractPreRegistration.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      return this.baseMapper.updateById(contractPreRegistration) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(ContractPreRegistrationDTOParam dtoParam) {
      ContractPreRegistration contractPreRegistration = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(contractPreRegistration), "合同预登记单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(contractPreRegistration.getReviewStatus()), "此合同预登记单已审核通过");
      Preconditions.checkArgument(!ReviewStatusEnum.AUDITING.getType().equals(contractPreRegistration.getReviewStatus()), "此合同预登记单正在审核中");
      Long rootId = ObjectUtil.defaultIfNull(contractPreRegistration.getInitDataId(), contractPreRegistration.getId());
      ContractPreRegistration root = this.baseMapper.selectById(rootId);
      dtoParam.setInitDataId(rootId);
      dtoParam.setPreRegistrationNo(root != null ? root.getPreRegistrationNo() : contractPreRegistration.getPreRegistrationNo());
      this.updateBoolRewrite(rootId, false);
      return this.saveContractFiledConfig(dtoParam);
   }

   @Override
   public Boolean export(ContractPreRegistrationQueryDTOParam param, HttpServletResponse response) {
      List<ContractPreRegistration> contractPreRegistrations = this.baseMapper.listInfo(param);
      List<ContractPreRegistrationDTO> contractPreRegistrationDTOS = this.convertDTO(contractPreRegistrations);
      Map<String, Object> hashMap = new HashMap<>();
      List<Map<String, Object>> mapList = new ArrayList<>();

      for (int i = 0; i < contractPreRegistrationDTOS.size(); i++) {
         ContractPreRegistrationDTO dto = contractPreRegistrationDTOS.get(i);
         Map<String, Object> map = new HashMap<>();
         map.put("id", i + 1);
         map.put("preRegistrationNo", dto.getPreRegistrationNo());
         map.put("partyName", dto.getPartyName());
         map.put("projectName", dto.getProjectName());
         map.put("signerName", dto.getSignerName());
         map.put("contractAmount", dto.getContractAmount());
         map.put("address", this.projectFinanceUtils.getAddress(dto.getCountryId(), dto.getProvinceId(), dto.getCityId(), dto.getRegionId(), "/"));
         map.put("boolBidWinningNotice", ObjectUtil.isNotEmpty(dto.getBoolBidWinningNotice()) ? (dto.getBoolBidWinningNotice() ? "是" : "否") : "");
         map.put("partyType", dto.getPartyTypeValue());
         map.put("structureType", dto.getStructureTypeValue());
         map.put("structureArea", dto.getStructureArea());
         map.put("contractualNature", dto.getContractualNatureValue());
         map.put("infoSource", ObjectUtil.isNotEmpty(dto.getInfoSource()) ? ContractInfoSourceEnum.getNameByType(dto.getInfoSource()) : "");
         map.put("remark", dto.getRemark());
         map.put("applicationDate", DateUtil.format(dto.getApplicationDate(), "yyyy-MM-dd HH:mm:ss"));
         map.put("applicantName", dto.getApplicantName());
         map.put("reviewStatus", ReviewStatusEnum.getNameByType(dto.getReviewStatus()));
         map.put("reviewPassTime", ObjectUtil.isNotEmpty(dto.getReviewPassTime()) ? DateUtil.format(dto.getReviewPassTime(), "yyyy-MM-dd HH:mm:ss") : "");
         mapList.add(map);
      }

      hashMap.put("mapList", mapList);
      String resourcePath = "files/ContractPreRegistration.xlsx";
      String tempFileName = "ContractPreRegistration";
      String exportFileName = "合同预登记.xlsx";
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

   @Override
   public List<ContractPreRegistrationDTO> getUnQuoteList() {
      List<ContractPreRegistration> contractPreRegistrations = this.baseMapper
         .selectList((Wrapper<ContractPreRegistration>)new LambdaQueryWrapper<ContractPreRegistration>().eq(ContractPreRegistration::getBoolQuote, false));
      if (CollectionUtil.isEmpty(contractPreRegistrations)) {
         return new ArrayList<>();
      }

      List<ContractPreRegistrationDTO> contractPreRegistrationDTOS = this.convertDTO(contractPreRegistrations);
      List<Long> preIds = contractPreRegistrationDTOS.stream().map(ContractPreRegistrationDTO::getId).collect(Collectors.toList());
      List<ContractCatalogue> contractCatalogues = this.contractCatalogueService
         .list(
            (Wrapper<ContractCatalogue>)(new LambdaQueryWrapper<ContractCatalogue>().in(ContractCatalogue::getPreRegistrationId, preIds))
               .isNotNull(ContractCatalogue::getContractNumber)
         );
      Map<Long, ContractCatalogueDTO> catalogueDTOMap = this.contractCatalogueService
         .convertDTO(contractCatalogues)
         .stream()
         .collect(Collectors.toMap(ContractCatalogueDTO::getPreRegistrationId, Function.identity()));
      contractPreRegistrationDTOS = contractPreRegistrationDTOS.stream()
         .filter(
            dto -> ObjectUtil.isNotEmpty(catalogueDTOMap.get(dto.getId()))
               && catalogueDTOMap.get(dto.getId()).getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())
         )
         .collect(Collectors.toList());
      contractPreRegistrationDTOS.forEach(dto -> dto.setContractCatalogueDTO(catalogueDTOMap.get(dto.getId())));
      return contractPreRegistrationDTOS;
   }

   public Boolean passed(Long id) {
      ContractPreRegistration contractPreRegistration = this.baseMapper.selectById(id);
      ContractCatalogue contractCatalogue = BeanUtil.toBean(contractPreRegistration, ContractCatalogue.class);
      contractCatalogue.setPreRegistrationId(id);
      contractCatalogue.setCreateSource(0);
      contractCatalogue.setLastEditUserId(contractPreRegistration.getApplicantId());
      contractCatalogue.setLastEditUserName(contractPreRegistration.getApplicantName());
      contractCatalogue.setLastEditTime(contractPreRegistration.getApplicationDate());
      contractCatalogue.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      this.contractCatalogueService.saveDate(contractCatalogue, true);
      contractPreRegistration.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      contractPreRegistration.setReviewPassTime(LocalDateTime.now());
      return this.baseMapper.updateById(contractPreRegistration) > 0;
   }

   public Boolean returned(Long id) {
      ContractPreRegistration contractPreRegistration = this.baseMapper.selectById(id);
      this.updateBoolRewrite(contractPreRegistration.getInitDataId(), true);
      contractPreRegistration.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      return this.baseMapper.updateById(contractPreRegistration) > 0;
   }

   private void updateBoolRewrite(Long initDataId, Boolean boolRewrite) {
      List<ContractPreRegistration> contractPreRegistrations = this.baseMapper
         .selectList((Wrapper<ContractPreRegistration>)new LambdaQueryWrapper<ContractPreRegistration>().eq(ContractPreRegistration::getInitDataId, initDataId));
      List<Long> approveIds = contractPreRegistrations.stream()
         .map(ContractPreRegistration::getApproveRecordId)
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
