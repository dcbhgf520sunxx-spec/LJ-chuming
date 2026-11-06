package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectMeteInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.biz.finance.ContractTestingFeeBiz;
import com.hzchum.scim.contract.core.api.biz.finance.FinanceFillFeeUtils;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.CheckFeeDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractTestingFeeSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.TestingFeeMonthDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractTestingFeeDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractTestingFeeMapper;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractTestingFeeBizImpl
   extends IBizImpl<ContractTestingFeeService, ContractTestingFeeMapper, ContractTestingFee>
   implements ContractTestingFeeBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private FinanceFillFeeUtils financeFillFeeUtils;

   @Override
   public ListVO<ContractTestingFeeSummaryDTO> listSummary(Integer year, Long projectId, Long testingFeeTypeId) {
      List<ContractTestingFee> testingFeeList = this.baseService
         .list(
            Wrappers.lambdaQuery(ContractTestingFee.class)
               .eq(year != null, ContractTestingFee::getYear, year)
               .eq(projectId != null, ContractTestingFee::getProjectId, projectId)
               .eq(testingFeeTypeId != null, ContractTestingFee::getTestingFeeTypeId, testingFeeTypeId)
         );
      if (testingFeeList.isEmpty()) {
         return new ListVO<>();
      }

      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService
         .listByIds(testingFeeList.stream().map(ContractTestingFee::getTestingFeeTypeId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      Map<Long, List<ContractTestingFee>> projectListMap = testingFeeList.stream()
         .collect(Collectors.groupingBy(s -> s.getProjectId() != null ? s.getProjectId() : 0L));
      List<ContractTestingFeeSummaryDTO> summaryList = new ArrayList<>(projectListMap.keySet().size());
      projectListMap.forEach(
         (cpId, testingFees) -> {
            ContractTestingFeeSummaryDTO summaryDTO = new ContractTestingFeeSummaryDTO();
            summaryDTO.setProject(this.projectService.getSimpleById(cpId));
            Set<Long> testingFeeTypeIds = testingFees.stream().map(ContractTestingFee::getTestingFeeTypeId).collect(Collectors.toSet());
            if (testingFeeTypeIds.size() == 1) {
               Long typeId = testingFeeTypeIds.iterator().next();
               SysDictionary dictionary = dictionaryMap.get(typeId);
               summaryDTO.setTestingFeeTypeId(typeId);
               summaryDTO.setTestingFeeTypeName(dictionary != null ? dictionary.getLabel() : null);
            }

            Map<Integer, List<ContractTestingFee>> monthFeeListMap = testingFees.stream().collect(Collectors.groupingBy(ContractTestingFee::getMonth));
            List<TestingFeeMonthDTO> feeMonthList = new ArrayList<>(16);
            monthFeeListMap.forEach(
               (month, feeList) -> {
                  BigDecimal reduce = feeList.stream()
                     .filter(s -> s.getAuditStatusEnum().equals(AuditStatusEnum.SUCCEED.getType()))
                     .map(ContractTestingFee::getFeeAmount)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  feeMonthList.add(TestingFeeMonthDTO.builder().month(month).feeAmount(reduce).build());
               }
            );
            summaryDTO.setTestingFeeList(feeMonthList);
            summaryList.add(summaryDTO);
         }
      );
      return new ListVO<>(summaryList);
   }

   @Override
   public PageVO<ContractTestingFeeDTO> listByCondition(
      Integer year, Integer month, Long projectId, Long testingFeeTypeId, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractTestingFeeDTO> feeDTOList = this.baseService.selectByCondition(year, month, projectId, testingFeeTypeId);
      feeDTOList.forEach(dto -> dto.setAttachments(this.attachmentService.listByIds(dto.getAttachmentIds())));
      return new PageVO<>(feeDTOList);
   }

   @Override
   public Boolean saveList(List<ContractTestingFeeDtoParam> paramList) {
      paramList.forEach(
         param -> {
            ContractProject project = this.checkParam(param);
            ContractTestingFee testingFee = BeanUtil.copy(param, ContractTestingFee.class);
            testingFee.setYear(param.getPayDate().getYear());
            testingFee.setMonth(param.getPayDate().getMonth().getValue());
            testingFee.setYearMonthValue(testingFee.getYear() * 100 + testingFee.getMonth());
            testingFee.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            testingFee.setUserId(UserUtil.getCurrentUserId());
            testingFee.setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
            this.baseService.save(testingFee);
            if (project != null) {
               Integer reviewStatus = this.financeFillFeeUtils
                  .addApproveData(
                     testingFee.getId(),
                     AuditPaymentEnum.TESTING_FEE.getType(),
                     ApproveProcessTypeEnumV2.CONTRACT_TESTING_AUDIT.getType(),
                     testingFee.getBranchCompanyId(),
                     testingFee.getFeeAmount(),
                     project
                  );
               if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
                  testingFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
                  testingFee.setAuditTime(LocalDateTime.now());
                  testingFee.setAuditorId(testingFee.getUserId());
                  testingFee.setAuditorName(UserUtil.getCurrentName());
                  this.baseService.updateById(testingFee);
               }
            }
         }
      );
      return true;
   }

   private ContractProject checkParam(ContractTestingFeeDtoParam param) {
      if (param.getTestingFeeTypeId() != null) {
         SysDictionary dictionary = this.dictionaryService.getById(param.getTestingFeeTypeId());
         Preconditions.checkArgument(dictionary != null, "检测费类型字典不存在");
         Preconditions.checkArgument(dictionary.getName().equals(DictionaryEnum.TESTING_FEE_TYPE.getName()), "检测费类型有误!");
      }

      if (param.getBranchCompanyId() != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
         Preconditions.checkArgument(branchCompany != null, "费用归属不存在!");
      }

      if (param.getProjectId() != null) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在");
         List<ProjectBranchCompanyLink> projectBranchCompanyLinkList = this.projectBranchCompanyLinkService
            .list(
               Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                  .eq(ProjectBranchCompanyLink::getBranchCompanyId, param.getBranchCompanyId())
                  .eq(ProjectBranchCompanyLink::getProjectId, param.getProjectId())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectBranchCompanyLinkList), "项目选择有误!");
         return project;
      } else {
         return null;
      }
   }

   @Override
   public Boolean updateList(List<ContractTestingFeeDtoParam> paramList) {
      paramList.forEach(
         param -> {
            ContractTestingFee testingFee = this.baseService.getById(param.getId());
            Preconditions.checkArgument(testingFee != null, "记录不存在");
            Preconditions.checkArgument(testingFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "检测费用已审批,不可修改!");
            ContractProject project = this.checkParam(param);
            BeanUtil.copy(param, testingFee);
            testingFee.setYear(param.getPayDate().getYear());
            testingFee.setMonth(param.getPayDate().getMonth().getValue());
            testingFee.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            this.baseService.updateById(testingFee);
            this.financeFillFeeUtils
               .removeApproveData(param.getId(), AuditPaymentEnum.TESTING_FEE.getType(), ApproveProcessTypeEnumV2.CONTRACT_TESTING_AUDIT.getType());
            if (project != null) {
               Integer reviewStatus = this.financeFillFeeUtils
                  .addApproveData(
                     param.getId(),
                     AuditPaymentEnum.TESTING_FEE.getType(),
                     ApproveProcessTypeEnumV2.CONTRACT_TESTING_AUDIT.getType(),
                     param.getBranchCompanyId(),
                     param.getFeeAmount(),
                     project
                  );
               if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
                  testingFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
                  testingFee.setAuditTime(LocalDateTime.now());
                  testingFee.setAuditorId(testingFee.getUserId());
                  testingFee.setAuditorName(UserUtil.getCurrentName());
                  this.baseService.updateById(testingFee);
               }
            }
         }
      );
      return true;
   }

   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractTestingFee testingFee = this.baseService.getById(id);
         Preconditions.checkArgument(testingFee != null, "记录不存在");
         Preconditions.checkArgument(testingFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "检测费上报已审批!");
         this.baseService.removeById(id);
         this.financeFillFeeUtils.removeApproveData(id, AuditPaymentEnum.TESTING_FEE.getType(), ApproveProcessTypeEnumV2.CONTRACT_TESTING_AUDIT.getType());
      });
      return true;
   }

   @Override
   public void exportTestingFeeExcel(Long projectId, Integer year, HttpServletResponse response) {
      List<CheckFeeDto> checkFeeDtoList = this.findAll(projectId, year);
      if (CollectionUtils.isNotEmpty(checkFeeDtoList)) {
         List<Long> typeIdList = new ArrayList<>(16);
         checkFeeDtoList.forEach(c -> typeIdList.addAll(c.getCheckType().keySet()));
         List<SysDictionary> dictionaryList = this.dictionaryService.listByIds(typeIdList);
         List<ExcelExportEntity> columnList = new ArrayList<>();
         ExcelExportEntity colEntity = new ExcelExportEntity("项目", "project", 30);
         colEntity.setNeedMerge(true);
         columnList.add(colEntity);
         colEntity = new ExcelExportEntity("产量(吨)", "output", 15);
         colEntity.setNeedMerge(true);
         columnList.add(colEntity);
         dictionaryList.forEach(item -> {
            ExcelExportEntity dynamicColEntity = new ExcelExportEntity(item.getLabel() + "(元)", item.getId(), 15);
            dynamicColEntity.setNeedMerge(true);
            columnList.add(dynamicColEntity);
         });
         colEntity = new ExcelExportEntity("合计(元)", "countAmount", 15);
         colEntity.setNeedMerge(true);
         columnList.add(colEntity);
         colEntity = new ExcelExportEntity("平均检测费(元/吨)", "avgCheckFee", 20);
         colEntity.setNeedMerge(true);
         columnList.add(colEntity);
         List<Map<Object, Object>> exportData = new ArrayList<>(16);
         Map<Long, BigDecimal> typeFeeSumMap = new HashMap<>(16);
         List<Map<Object, Object>> mapList = new ArrayList<>(16);
         checkFeeDtoList.forEach(
            s -> {
               Map<Object, Object> map = new HashMap<>(8);
               map.put("project", s.getProject() != null ? s.getProject().getSerialNumber() + " " + s.getProject().getShortName() : "-");
               map.put("output", s.getCapacity() != null ? s.getCapacity() : "-");
               typeIdList.forEach(typeId -> {
                  map.put(typeId, s.getCheckType().getOrDefault(typeId, BigDecimal.ZERO));
                  if (s.getCheckType().containsKey(typeId)) {
                     BigDecimal amount = s.getCheckType().get(typeId);
                     if (typeFeeSumMap.containsKey(typeId)) {
                        typeFeeSumMap.put(typeId, typeFeeSumMap.get(typeId).add(amount));
                     } else {
                        typeFeeSumMap.put(typeId, amount);
                     }
                  }
               });
               BigDecimal projectTotalFee = s.getCheckType().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
               map.put("countAmount", projectTotalFee);
               map.put(
                  "avgCheckFee",
                  s.getCapacity() != null && s.getCapacity().compareTo(BigDecimal.ZERO) > 0
                     ? projectTotalFee.divide(s.getCapacity(), 0, RoundingMode.HALF_UP)
                     : projectTotalFee
               );
               mapList.add(map);
            }
         );
         exportData.addAll(mapList);
         Map<Object, Object> totalValMap = new HashMap<>();
         BigDecimal totalOutput = checkFeeDtoList.stream().map(CheckFeeDto::getCapacity).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal countAmount = checkFeeDtoList.stream()
            .map(c -> c.getCheckType().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         totalValMap.put("project", "合计");
         typeFeeSumMap.forEach(totalValMap::put);
         totalValMap.put("output", totalOutput);
         totalValMap.put("countAmount", countAmount);
         totalValMap.put("avgCheckFee", totalOutput.compareTo(BigDecimal.ZERO) > 0 ? countAmount.divide(totalOutput, 0, RoundingMode.HALF_UP) : countAmount);
         exportData.add(totalValMap);
         String fileName = year + "年检测费统计报表.xlsx";
         String title = year + "年 - 检测费统计报表";
         String sheetName = "检测费统计报表";
         Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName, ExcelType.XSSF), columnList, exportData);
         PoiUtils.downLoadExcel(fileName, response, workbook);
      }
   }

   @Override
   public List<CheckFeeDto> findAll(Long projectId, Integer year) {
      List<ContractTestingFee> testingFeeList = this.baseService
         .list(
            Wrappers.lambdaQuery(ContractTestingFee.class)
               .eq(year != null, ContractTestingFee::getYear, year)
               .eq(projectId != null, ContractTestingFee::getProjectId, projectId)
         );
      List<CheckFeeDto> checkFeeDtoList = new ArrayList<>(16);
      Map<Long, List<ContractTestingFee>> projectListMap = testingFeeList.stream()
         .filter(t -> t.getProjectId() != null)
         .collect(Collectors.groupingBy(ContractTestingFee::getProjectId));
      if (CollectionUtils.isNotEmpty(projectListMap)) {
         Map<Long, ProjectInfo> projectInfoMap = this.projectService
            .listSimpleByIdList(projectListMap.keySet())
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         projectListMap.forEach(
            (pId, list) -> {
               Map<Long, BigDecimal> typeFeeSumMapx = list.stream()
                  .collect(
                     Collectors.groupingBy(
                        ContractTestingFee::getTestingFeeTypeId,
                        Collectors.mapping(ContractTestingFee::getFeeAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                     )
                  );
               Map<Long, BigDecimal> projectMeteMap = this.mesBuildingCompleteService
                  .listProjectMete(year)
                  .stream()
                  .collect(Collectors.toMap(ProjectMeteInfo::getProjectId, ProjectMeteInfo::getMete));
               CheckFeeDto checkFeeDtox = CheckFeeDto.builder()
                  .project(projectInfoMap.getOrDefault(pId, null))
                  .checkType(typeFeeSumMapx)
                  .capacity(projectMeteMap.getOrDefault(pId, BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L)))
                  .build();
               checkFeeDtoList.add(checkFeeDtox);
            }
         );
      }

      List<ContractTestingFee> testingFeeNullProjectList = testingFeeList.stream().filter(t -> t.getProjectId() == null).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(testingFeeNullProjectList)) {
         Map<Long, BigDecimal> typeFeeSumMap = testingFeeNullProjectList.stream()
            .collect(
               Collectors.groupingBy(
                  ContractTestingFee::getTestingFeeTypeId,
                  Collectors.mapping(ContractTestingFee::getFeeAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         CheckFeeDto checkFeeDto = CheckFeeDto.builder().checkType(typeFeeSumMap).build();
         checkFeeDtoList.add(checkFeeDto);
      }

      return checkFeeDtoList;
   }
}
