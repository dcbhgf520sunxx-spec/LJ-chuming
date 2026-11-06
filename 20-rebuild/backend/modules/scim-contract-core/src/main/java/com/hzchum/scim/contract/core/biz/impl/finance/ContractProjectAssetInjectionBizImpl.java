package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectAssetInjectionBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AssetTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectAssetInjectionPutDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.InjectionExpendituresDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractProjectAssetInjectionDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectManagerMoneyInterestsService;
import com.hzchum.scim.contract.core.mapper.finance.ContractProjectAssetInjectionMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractProjectAssetInjectionBizImpl
   extends IBizImpl<ContractProjectAssetInjectionService, ContractProjectAssetInjectionMapper, ContractProjectAssetInjection>
   implements ContractProjectAssetInjectionBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private UserService userService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private SupplierPaymentService paymentService;
   @Resource
   private PurchaseOrderService orderService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ContractProjectManagerMoneyInterestsService moneyInterestsService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractSupplierPaymentBiz supplierPaymentBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveAssetInjection(ContractProjectAssetInjectionDTOParam param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "自营项目不支持注资!");
      Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算!");
      Preconditions.checkArgument(
         param.getProjectManagerId() != null && param.getProjectManagerScale() != null
            || param.getContractSignBodyId() != null && param.getContractSignBodyScale() != null,
         "数据传值有误!"
      );
      Preconditions.checkArgument(
         param.getContractSignBodyId() != null && param.getProjectManagerId() == null
            || param.getContractSignBodyId() == null && param.getProjectManagerId() != null,
         "数据传值有误!"
      );
      Preconditions.checkArgument(
         project.getContractSignBodyId().equals(param.getContractSignBodyId()) || project.getProjectManagerId().equals(param.getProjectManagerId()), "数据传值有误!"
      );
      ContractProjectAssetInjection injection = BeanUtil.copy(param, ContractProjectAssetInjection.class);
      injection.setAssetType(param.getContractSignBodyId() != null ? AssetTypeEnum.COMPANY_INJECTION.getType() : AssetTypeEnum.MANAGER_INJECTION.getType());
      injection.setAssetAmount(param.getContractSignBodyId() != null ? param.getContractSignBodyScale() : param.getProjectManagerScale());
      injection.setAssetOwnerId(param.getContractSignBodyId() != null ? param.getContractSignBodyId() : param.getProjectManagerId());
      injection.setIncomeOrDisburse(Boolean.TRUE);
      injection.setUserId(UserUtil.getCurrentUserId());
      injection.setAttachmentId(StringUtils.join(param.getAttachmentId(), ","));
      List<ContractProjectAssetInjection> contractProjectAssetInjections = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getProjectId, param.getProjectId())
               .eq(ContractProjectAssetInjection::getAssetType, injection.getAssetType())
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, true)
         );
      injection.setRemark(CollectionUtils.isNotEmpty(contractProjectAssetInjections) ? "收入" : "期初注资款");

      try {
         Object number = this.redisUtils.get("supplierPaymentNumber");
         if (ObjectUtils.isEmpty(number)) {
            this.projectSerialNumberUtils.redisSaveSerialNumber();
            number = this.redisUtils.get("supplierPaymentNumber");
         }

         String supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
         injection.setVoucherNumber("I" + supplierPaymentNumber);
         this.redisUtils.incr("supplierPaymentNumber", 1L);
      } catch (Exception e) {
         throw new IllegalArgumentException("获取流水号失败");
      }

      this.baseMapper.insert(injection);
      if (injection.getAssetType().equals(AssetTypeEnum.COMPANY_INJECTION.getType())) {
         project.setContractSignBodyInjectionBalance(project.getContractSignBodyInjectionBalance().add(injection.getAssetAmount()));
         project.setContractSignBodyAmount(project.getContractSignBodyAmount().add(injection.getAssetAmount()));
      } else {
         project.setProjectManagerInjectionBalance(project.getProjectManagerInjectionBalance().add(injection.getAssetAmount()));
         project.setProjectManagerAmount(project.getProjectManagerAmount().add(injection.getAssetAmount()));
      }

      project.setCollectionSummary(project.getCollectionSummary().add(injection.getAssetAmount()));
      this.projectService.updateById(project);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateAssetInjection(ContractProjectAssetInjectionDTOParam param) {
      ContractProjectAssetInjection injection = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection), "注资信息不存在");
      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection.getProjectManagerId())) {
         Preconditions.checkArgument(injection.getProjectManagerId().equals(param.getProjectManagerId()), "项目经理不能修改");
      } else {
         Preconditions.checkArgument(injection.getContractSignBodyId().equals(param.getContractSignBodyId()), "注资信息不能修改");
      }

      ContractProject project = this.projectService.getById(injection.getProjectId());
      Preconditions.checkArgument(
         org.apache.commons.lang3.ObjectUtils.isNotEmpty(project) && !project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()),
         "自营不存在注资信息"
      );
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection), "注资信息不存在");
      Preconditions.checkArgument(
         param.getProjectManagerId() != null && param.getProjectManagerScale() != null
            || param.getContractSignBodyId() != null && param.getContractSignBodyScale() != null,
         "项目id和签约主体id不能同时为空"
      );
      if (param.getContractSignBodyId() != null && param.getContractSignBodyScale() != null) {
         Preconditions.checkArgument(param.getContractSignBodyScale().compareTo(BigDecimal.ZERO) > 0, "签约主体注资不能为0");
         BigDecimal projectContractSignBodyInjectionBalance = project.getContractSignBodyInjectionBalance()
            .add(param.getContractSignBodyScale())
            .subtract(injection.getContractSignBodyScale());
         Preconditions.checkArgument(projectContractSignBodyInjectionBalance.compareTo(BigDecimal.ZERO) >= 0, "修改失败,签订主体注资余额不足!");
         project.setContractSignBodyInjectionBalance(projectContractSignBodyInjectionBalance);
         project.setContractSignBodyAmount(
            project.getContractSignBodyAmount().add(param.getContractSignBodyScale()).subtract(injection.getContractSignBodyScale())
         );
         project.setCollectionSummary(project.getCollectionSummary().add(param.getContractSignBodyScale()).subtract(injection.getContractSignBodyScale()));
      }

      if (param.getProjectManagerId() != null && param.getProjectManagerScale() != null) {
         Preconditions.checkArgument(param.getProjectManagerScale().compareTo(BigDecimal.ZERO) > 0, "项目经理注资不能为0");
         BigDecimal projectManagerInjectionBalance = project.getProjectManagerInjectionBalance()
            .add(param.getProjectManagerScale())
            .subtract(injection.getProjectManagerScale());
         Preconditions.checkArgument(projectManagerInjectionBalance.compareTo(BigDecimal.ZERO) >= 0, "修改失败,项目经理注资余额不足!");
         project.setProjectManagerInjectionBalance(projectManagerInjectionBalance);
         project.setProjectManagerAmount(project.getProjectManagerAmount().add(param.getProjectManagerScale()).subtract(injection.getProjectManagerScale()));
         project.setCollectionSummary(project.getCollectionSummary().add(param.getProjectManagerScale()).subtract(injection.getProjectManagerScale()));
      }

      BeanUtil.copy(param, injection);
      injection.setUserId(UserUtil.getCurrentUserId());
      this.baseMapper.updateById(injection);
      this.projectService.updateById(project);
      return Boolean.TRUE;
   }

   private void assetInjectionCheck(ContractProjectAssetInjectionDTOParam param, Boolean controls) {
      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(param.getProjectManagerId())) {
         List<ContractProjectAssetInjection> projectManager = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
                  .eq(ContractProjectAssetInjection::getProjectManagerId, param.getProjectManagerId())
                  .eq(ContractProjectAssetInjection::getProjectId, param.getProjectId())
            );
         BigDecimal disburse = projectManager.stream()
            .filter(a -> a.getIncomeOrDisburse().equals(false))
            .map(ContractProjectAssetInjection::getProjectManagerScale)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         if (controls) {
            Preconditions.checkArgument(disburse.compareTo(param.getProjectManagerScale()) <= 0, "修改注资不能小于已使用的注资金额");
         } else {
            Preconditions.checkArgument(disburse.compareTo(BigDecimal.ZERO) > 0, "注资已使用，不可删除");
         }
      }

      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(param.getContractSignBodyScale())) {
         List<ContractProjectAssetInjection> projectManager = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
                  .eq(ContractProjectAssetInjection::getContractSignBodyScale, param.getContractSignBodyScale())
            );
         BigDecimal disburse = projectManager.stream()
            .filter(a -> a.getIncomeOrDisburse().equals(false))
            .map(ContractProjectAssetInjection::getContractSignBodyScale)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(param.getContractSignBodyScale().compareTo(disburse) >= 0, "修改注资不能小于已使用的注资金额");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteAssetInjection(Long id) {
      ContractProjectAssetInjection injection = this.baseMapper.selectById(id);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection) && injection.getIncomeOrDisburse(), "注资信息不存在!");
      ContractProject project = this.projectService.getById(injection.getProjectId());
      if (injection.getAssetType().equals(AssetTypeEnum.COMPANY_INJECTION.getType())) {
         Preconditions.checkArgument(project.getContractSignBodyInjectionBalance().compareTo(injection.getContractSignBodyScale()) >= 0, "签订主体注资已使用,无法删除!");
         project.setContractSignBodyInjectionBalance(project.getContractSignBodyInjectionBalance().subtract(injection.getContractSignBodyScale()));
         project.setContractSignBodyAmount(project.getContractSignBodyAmount().subtract(injection.getContractSignBodyScale()));
         project.setCollectionSummary(project.getCollectionSummary().subtract(injection.getContractSignBodyScale()));
      } else {
         Preconditions.checkArgument(project.getProjectManagerInjectionBalance().compareTo(injection.getProjectManagerScale()) >= 0, "项目经理注资已使用,无法删除!");
         project.setProjectManagerInjectionBalance(project.getProjectManagerInjectionBalance().subtract(injection.getProjectManagerScale()));
         project.setProjectManagerAmount(project.getProjectManagerAmount().subtract(injection.getProjectManagerScale()));
         project.setCollectionSummary(project.getCollectionSummary().subtract(injection.getProjectManagerScale()));
      }

      this.baseMapper.deleteById(id);
      this.projectService.updateById(project);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<ContractProjectAssetInjectionDTO> getAssetInjectionPage(
      Long contractSignBodyId, Long projectManagerId, Long projectId, Integer pageNumber, Integer pageSize
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(
         org.apache.commons.lang3.ObjectUtils.isNotEmpty(project) && !project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()),
         "自营没有注资信息"
      );
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProjectAssetInjection> injectionList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(contractSignBodyId != null, ContractProjectAssetInjection::getContractSignBodyId, contractSignBodyId)
               .eq(projectManagerId != null, ContractProjectAssetInjection::getProjectManagerId, projectManagerId)
               .eq(ContractProjectAssetInjection::getProjectId, projectId)
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, Boolean.TRUE)
               .orderByDesc(ContractProjectAssetInjection::getAssetInjectionTime)
         );
      List<ContractProjectAssetInjectionDTO> dtos = new ArrayList<>();
      if (CollectionUtils.isEmpty(injectionList)) {
         return new PageVO<>(dtos);
      }

      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService
         .list(Wrappers.lambdaQuery(SysDictionary.class).eq(SysDictionary::getName, DictionaryEnum.INJECTION_TYPE.getName()))
         .stream()
         .collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      Map<Long, Attachment> attachmentMap = this.attachmentService.list().stream().collect(Collectors.toMap(Attachment::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Object, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      injectionList.forEach(
         list -> {
            ContractProject contractProject = projectMap.get(list.getProjectId());
            ContractProjectAssetInjectionDTO dto = BeanUtil.copy(list, ContractProjectAssetInjectionDTO.class);
            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(contractProject)) {
               dto.setProject(
                  ProjectInfo.builder()
                     .id(contractProject.getId())
                     .shortName(contractProject.getShortName())
                     .serialNumber(contractProject.getSerialNumber())
                     .name(contractProject.getName())
                     .build()
               );
            }

            User user = userMap.get(list.getCreatorUserId());
            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(user)) {
               dto.setCreatorUser(NameInfo.builder().id(user.getId()).name(user.getName()).build());
            }

            if (list.getProjectManagerId() != null && org.apache.commons.lang3.ObjectUtils.isNotEmpty(userMap.get(list.getProjectManagerId()))) {
               User projectManager = userMap.get(list.getProjectManagerId());
               dto.setCapitalContributor(NameInfo.builder().id(projectManager.getId()).name(projectManager.getName()).build());
               dto.setCapitalContributorAmount(list.getProjectManagerScale());
            }

            if (list.getContractSignBodyId() != null && org.apache.commons.lang3.ObjectUtils.isNotEmpty(branchCompanyMap.get(list.getContractSignBodyId()))) {
               BranchCompany projectManager = branchCompanyMap.get(list.getContractSignBodyId());
               dto.setCapitalContributor(NameInfo.builder().id(projectManager.getId()).name(projectManager.getName()).build());
               dto.setCapitalContributorAmount(list.getContractSignBodyScale());
            }

            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(dictionaryMap.get(Long.valueOf(list.getAssetInjectionEnum())))) {
               dto.setAssetInjectionName(dictionaryMap.get(Long.valueOf(list.getAssetInjectionEnum())).getLabel());
            }

            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(list.getAttachmentId())) {
               List<Long> longList = Arrays.stream(list.getAttachmentId().split(",")).map(Long::valueOf).collect(Collectors.toList());
               List<AttachmentDTO> attachmentDTOS = attachmentMap.values()
                  .stream()
                  .filter(attachment -> longList.contains(attachment.getId()))
                  .map(attachment -> BeanUtil.copy(attachment, AttachmentDTO.class))
                  .collect(Collectors.toList());
               dto.setAttachment(attachmentDTOS);
            }

            dto.setPutUserName(userMap.get(list.getUserId()).getName());
            dto.setUpdateTime(list.getUpdateTime());
            dtos.add(dto);
         }
      );
      return new PageVO<>(dtos);
   }

   @Override
   public Map<String, Map<Long, String>> getAssetInjection(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "自营没有项目注资");
      BranchCompany company = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(company), "项目主体不存在");
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         Preconditions.checkArgument(
            org.apache.commons.lang3.ObjectUtils.isNotEmpty(project.getProjectManagerScale())
               || org.apache.commons.lang3.ObjectUtils.isNotEmpty(project.getContractSignBodyScale()),
            "项目注资比例为空"
         );
      }

      User user = this.userService.getById(project.getProjectManagerId());
      Map<String, Map<Long, String>> result = new HashMap<>();
      HashMap<Long, String> projectManagerMap = new HashMap<>();
      projectManagerMap.put(project.getProjectManagerId(), user.getName());
      result.put("projectManagerId", projectManagerMap);
      HashMap<Long, String> contractSignBodyMap = new HashMap<>();
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         contractSignBodyMap.put(project.getContractSignBodyId(), company.getName());
         result.put("contractSignBodyId", contractSignBodyMap);
      }

      return result;
   }

   @Override
   public ContractProjectAssetInjectionPutDTO getPutAssetInjection(Long id) {
      ContractProjectAssetInjection injection = this.baseMapper.selectById(id);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection), "注资信息不存在");
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      ContractProjectAssetInjectionPutDTO injectionDTO = BeanUtil.copy(injection, ContractProjectAssetInjectionPutDTO.class);
      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService
         .list(Wrappers.lambdaQuery(SysDictionary.class).eq(SysDictionary::getName, DictionaryEnum.INJECTION_TYPE.getName()))
         .stream()
         .collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection.getAttachmentId())) {
         List<Long> longList = Arrays.stream(injection.getAttachmentId().split(",")).map(Long::valueOf).collect(Collectors.toList());
         List<Attachment> byId = this.attachmentService.list(Wrappers.lambdaQuery(Attachment.class).in(Attachment::getId, longList));
         if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(byId)) {
            List<AttachmentDTO> dtos = new ArrayList<>();
            byId.forEach(attachment -> dtos.add(BeanUtil.copy(attachment, AttachmentDTO.class)));
            injectionDTO.setAttachment(dtos);
         }
      }

      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection.getProjectManagerId())) {
         injectionDTO.setProjectManager(
            NameInfo.builder().id(injection.getProjectManagerId()).name(userMap.get(injection.getProjectManagerId()).getName()).build()
         );
         injectionDTO.setProjectManagerScale(injection.getProjectManagerScale());
      } else {
         BranchCompany company = this.branchCompanyService.getById(injection.getContractSignBodyId());
         injectionDTO.setContractSignBody(NameInfo.builder().id(injection.getContractSignBodyId()).name(company.getName()).build());
         injectionDTO.setContractSignBodyScale(injection.getContractSignBodyScale());
      }

      injectionDTO.setUser(NameInfo.builder().id(injection.getCreatorUserId()).name(userMap.get(injection.getCreatorUserId()).getName()).build());
      ContractProject project = this.projectService.getById(injection.getProjectId());
      injectionDTO.setCollectionDepositBank(injection.getCollectionDepositBank());
      injectionDTO.setProject(
         ProjectInfo.builder()
            .id(injection.getProjectId())
            .name(project.getName())
            .shortName(project.getShortName())
            .serialNumber(project.getSerialNumber())
            .build()
      );
      injectionDTO.setAssetInjectionEnum(injection.getAssetInjectionEnum());
      return injectionDTO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProjectDownload(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(project), "项目不存在");
      Preconditions.checkArgument(project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType()), "该项目不是合营项目");
      List<ContractProjectAssetInjection> injectionList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getProjectId, projectId)
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, Boolean.TRUE)
         );
      List<ContractProjectAssetInjectionDTO> dtos = new ArrayList<>();
      Map<Long, SysDictionary> dictionaryMap = this.dictionaryService
         .list(Wrappers.lambdaQuery(SysDictionary.class).eq(SysDictionary::getName, DictionaryEnum.INJECTION_TYPE.getName()))
         .stream()
         .collect(Collectors.toMap(SysDictionary::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Object, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      injectionList.forEach(
         list -> {
            ContractProject contractProject = projectMap.get(list.getProjectId());
            ContractProjectAssetInjectionDTO dto = BeanUtil.copy(list, ContractProjectAssetInjectionDTO.class);
            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(contractProject)) {
               dto.setProject(
                  ProjectInfo.builder()
                     .id(contractProject.getId())
                     .shortName(contractProject.getShortName())
                     .serialNumber(contractProject.getSerialNumber())
                     .name(contractProject.getName())
                     .build()
               );
            }

            User user = userMap.get(list.getCreatorUserId());
            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(user)) {
               dto.setCreatorUser(NameInfo.builder().id(user.getId()).name(user.getName()).build());
            }

            if (list.getProjectManagerId() != null && org.apache.commons.lang3.ObjectUtils.isNotEmpty(userMap.get(list.getProjectManagerId()))) {
               User projectManager = userMap.get(list.getProjectManagerId());
               dto.setCapitalContributor(NameInfo.builder().id(projectManager.getId()).name(projectManager.getName()).build());
               dto.setCapitalContributorAmount(list.getProjectManagerScale());
            }

            if (list.getContractSignBodyId() != null && org.apache.commons.lang3.ObjectUtils.isNotEmpty(branchCompanyMap.get(list.getContractSignBodyId()))) {
               BranchCompany projectManager = branchCompanyMap.get(list.getContractSignBodyId());
               dto.setCapitalContributor(NameInfo.builder().id(projectManager.getId()).name(projectManager.getName()).build());
               dto.setCapitalContributorAmount(list.getContractSignBodyScale());
            }

            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(dictionaryMap.get(Long.valueOf(list.getAssetInjectionEnum())))) {
               dto.setAssetInjectionName(dictionaryMap.get(Long.valueOf(list.getAssetInjectionEnum())).getLabel());
            }

            dtos.add(dto);
         }
      );
      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public Map<String, String> getInjectionAmount(Long projectId) {
      Map<String, String> map = new HashMap<>();
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(project), "项目不存在");
      BranchCompany company = this.branchCompanyService.getById(project.getContractSignBodyId());
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(company), "项目主体不存在");
      map.put("projectManagerName", this.userService.getById(project.getProjectManagerId()).getName());
      map.put("contractSignBodyName", org.apache.commons.lang3.ObjectUtils.isNotEmpty(company.getShortName()) ? company.getShortName() : company.getName());
      map.put("injectionSum", String.valueOf(BigDecimal.ZERO));
      map.put("projectManagerAmount", String.valueOf(BigDecimal.ZERO));
      map.put("contractSignBodyAmount", String.valueOf(BigDecimal.ZERO));
      List<ContractProjectAssetInjection> list = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, projectId));
      if (CollectionUtils.isEmpty(list)) {
         return map;
      }

      Map<Boolean, List<ContractProjectAssetInjection>> projectManager = list.stream()
         .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getProjectManagerId()))
         .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
      Map<Boolean, List<ContractProjectAssetInjection>> contractSignBody = list.stream()
         .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
         .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
      List<ContractProjectAssetInjection> income = list.stream().filter(a -> a.getIncomeOrDisburse().equals(Boolean.TRUE)).collect(Collectors.toList());
      List<ContractProjectAssetInjection> disburse = list.stream().filter(a -> a.getIncomeOrDisburse().equals(Boolean.FALSE)).collect(Collectors.toList());
      BigDecimal pro1 = income.stream()
         .map(ContractProjectAssetInjection::getProjectManagerScale)
         .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal pro2 = income.stream()
         .map(ContractProjectAssetInjection::getContractSignBodyScale)
         .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal add = pro1.add(pro2);
      BigDecimal dis1 = disburse.stream()
         .map(ContractProjectAssetInjection::getProjectManagerScale)
         .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal dis2 = disburse.stream()
         .map(ContractProjectAssetInjection::getContractSignBodyScale)
         .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal add1 = dis1.add(dis2);
      map.put("injectionSum", String.valueOf(add));
      map.put("paymentSum", String.valueOf(add1));
      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(projectManager)) {
         Map<String, BigDecimal> projectManagerMap = new HashMap<>();
         projectManager.forEach(
            (k, v) -> {
               if (k.equals(Boolean.TRUE)) {
                  BigDecimal incomeAmountx = v.stream()
                     .map(ContractProjectAssetInjection::getProjectManagerScale)
                     .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  projectManagerMap.put("incomeAmount", org.apache.commons.lang3.ObjectUtils.isNotEmpty(incomeAmountx) ? incomeAmountx : BigDecimal.ZERO);
               } else {
                  BigDecimal disburseAmountx = v.stream()
                     .map(ContractProjectAssetInjection::getProjectManagerScale)
                     .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  projectManagerMap.put("disburseAmount", org.apache.commons.lang3.ObjectUtils.isNotEmpty(disburseAmountx) ? disburseAmountx : BigDecimal.ZERO);
               }
            }
         );
         BigDecimal incomeAmount = org.apache.commons.lang3.ObjectUtils.isNotEmpty(projectManagerMap.get("incomeAmount"))
            ? projectManagerMap.get("incomeAmount")
            : BigDecimal.ZERO;
         BigDecimal disburseAmount = org.apache.commons.lang3.ObjectUtils.isNotEmpty(projectManagerMap.get("disburseAmount"))
            ? projectManagerMap.get("disburseAmount")
            : BigDecimal.ZERO;
         BigDecimal projectManagerAmount = incomeAmount.subtract(disburseAmount).compareTo(BigDecimal.ZERO) >= 0
            ? incomeAmount.subtract(disburseAmount)
            : BigDecimal.ZERO;
         map.put("projectManagerAmount", String.valueOf(projectManagerAmount));
      }

      if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(contractSignBody)) {
         Map<String, BigDecimal> projectManagerMap = new HashMap<>();
         contractSignBody.forEach(
            (k, v) -> {
               if (k.equals(Boolean.TRUE)) {
                  BigDecimal incomeAmountx = v.stream()
                     .map(ContractProjectAssetInjection::getContractSignBodyScale)
                     .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  projectManagerMap.put("incomeAmount", org.apache.commons.lang3.ObjectUtils.isNotEmpty(incomeAmountx) ? incomeAmountx : BigDecimal.ZERO);
               } else {
                  BigDecimal disburseAmountx = v.stream()
                     .map(ContractProjectAssetInjection::getContractSignBodyScale)
                     .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  projectManagerMap.put("disburseAmount", org.apache.commons.lang3.ObjectUtils.isNotEmpty(disburseAmountx) ? disburseAmountx : BigDecimal.ZERO);
               }
            }
         );
         BigDecimal incomeAmount = org.apache.commons.lang3.ObjectUtils.isNotEmpty(projectManagerMap.get("incomeAmount"))
            ? projectManagerMap.get("incomeAmount")
            : BigDecimal.ZERO;
         BigDecimal disburseAmount = org.apache.commons.lang3.ObjectUtils.isNotEmpty(projectManagerMap.get("disburseAmount"))
            ? projectManagerMap.get("disburseAmount")
            : BigDecimal.ZERO;
         map.put("contractSignBodyAmount", String.valueOf(incomeAmount.subtract(disburseAmount)));
      }

      return map;
   }

   @Override
   public List<ContractProjectAssetInjectionDetailDTO> getAssetInjectionDetail(Long projectId, Long supplierId) {
      List<ContractProjectAssetInjectionDetailDTO> dtos = new ArrayList<>();
      ContractProject project = this.projectService.getById(projectId);
      List<PurchaseOrder> orderList = this.orderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(org.apache.commons.lang3.ObjectUtils.isNotEmpty(supplierId), PurchaseOrder::getSupplierId, supplierId)
               .apply("project_attribute != {0}", ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(orderList)) {
         return dtos;
      }

      List<Long> longList = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      List<SupplierPayment> paymentList = this.paymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getProjectId, projectId)
               .in(SupplierPayment::getOrderId, longList)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      if (CollectionUtils.isEmpty(paymentList)) {
         return dtos;
      }

      List<ContractProjectAssetInjection> injections = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getProjectId, projectId)
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, Boolean.FALSE)
         );
      Map<Long, ContractProjectAssetInjection> injectionMap = injections.stream()
         .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getPaymentId()))
         .collect(Collectors.toMap(ContractProjectAssetInjection::getPaymentId, Function.identity()));
      Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      paymentList.forEach(
         payment -> {
            if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(injectionMap.get(payment.getId()))) {
               dtos.add(
                  ContractProjectAssetInjectionDetailDTO.builder()
                     .assetInjectionTime(payment.getPaymentDate().atStartOfDay())
                     .supplier(
                        SupplierInfo.builder()
                           .supplierId(payment.getSupplierId())
                           .supplierName(supplierMap.get(payment.getSupplierId()).getName())
                           .supplierNumber(supplierMap.get(payment.getSupplierId()).getSupplierNumber())
                           .build()
                     )
                     .type(Integer.valueOf(payment.getPaymentReasonId()))
                     .amount(payment.getActuallyPaymentAmount())
                     .contractSignBodyId(payment.getPaymentUnitId())
                     .contractSignBodyName(branchCompanyMap.get(project.getContractSignBodyId()).getName())
                     .contractSignBodyPayAmount(injectionMap.get(payment.getId()).getContractSignBodyScale())
                     .projectManagerId(project.getProjectManagerId())
                     .projectManagerName(userMap.get(project.getProjectManagerId()).getName())
                     .projectManagerPayAmount(injectionMap.get(payment.getId()).getProjectManagerScale())
                     .build()
               );
            }
         }
      );
      return dtos;
   }

   @Override
   public List<SupplierInfo> getPurchaseOrder(Long projectId) {
      ContractProject byId = this.projectService.getById(projectId);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(byId), "合同不存在");
      List<SupplierInfo> mapList = new ArrayList<>();
      List<PurchaseOrder> orderList = this.orderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .isNotNull(PurchaseOrder::getProjectIds)
               .eq(PurchaseOrder::getProjectAttribute, byId.getProjectAttribute())
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .filter(order -> Arrays.asList(order.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(orderList)) {
         List<Long> supplierId = orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toList());
         List<Supplier> supplierList = this.supplierService.list(Wrappers.lambdaQuery(Supplier.class).in(Supplier::getId, supplierId));
         supplierList.forEach(
            supplier -> mapList.add(
               SupplierInfo.builder().supplierId(supplier.getId()).supplierName(supplier.getName()).supplierNumber(supplier.getSupplierNumber()).build()
            )
         );
      }

      return mapList;
   }

   @Override
   public PrintVO getInjectionDetailDownload(Long projectId, Long supplierId) {
      ContractProject project = this.projectService
         .getOne(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getId, projectId)
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.JOINT_VENTURE.getType())
         );
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectManagerScale", project.getProjectManagerScale());
      header.put("contractSignBodyScale", project.getContractSignBodyScale());
      header.put("contractSignBodyName", this.branchCompanyService.getById(project.getContractSignBodyId()).getName());
      header.put("projectManagerName", this.userService.getById(project.getProjectManagerId()).getName());
      printVO.setHeader(header);
      List<ContractProjectAssetInjectionDetailDTO> assetInjectionDetail = this.getAssetInjectionDetail(projectId, supplierId);
      printVO.setTable(assetInjectionDetail.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public ContractProjectAssetInjectionDetailDTO getProjectDetail(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(project), "合同不存在");
      List<ContractProjectAssetInjection> contractProjectAssetInjections = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractProjectAssetInjection.class).eq(ContractProjectAssetInjection::getProjectId, projectId));
      BranchCompany company = this.branchCompanyService.getById(project.getContractSignBodyId());
      String companyName = org.apache.commons.lang3.ObjectUtils.isNotEmpty(company.getShortName()) ? company.getShortName() : company.getName();
      ContractProjectAssetInjectionDetailDTO build = ContractProjectAssetInjectionDetailDTO.builder()
         .contractSignBodyId(project.getContractSignBodyId())
         .contractSignBodyName(companyName)
         .project(
            ProjectInfo.builder()
               .id(projectId)
               .shortName(project.getShortName())
               .name(project.getName())
               .projectAttribute(project.getProjectAttribute())
               .serialNumber(project.getSerialNumber())
               .build()
         )
         .contractSignBodyPayAmount(BigDecimal.ZERO)
         .contractSignBodyRemainAmount(BigDecimal.ZERO)
         .projectManagerId(project.getProjectManagerId())
         .projectManagerName(this.userService.getNameById(project.getProjectManagerId()))
         .projectManagerRemainAmount(BigDecimal.ZERO)
         .projectManagerPayAmount(BigDecimal.ZERO)
         .build();
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         build.setContractSignBodyRatio(project.getContractSignBodyScale());
         build.setProjectManagerRatio(project.getProjectManagerScale());
      } else {
         build.setProjectManagerRatio(BigDecimal.valueOf(100L));
      }

      if (CollectionUtils.isEmpty(contractProjectAssetInjections)) {
         return build;
      }

      Map<Boolean, List<ContractProjectAssetInjection>> incomeOrDisburse = contractProjectAssetInjections.stream()
         .collect(Collectors.groupingBy(ContractProjectAssetInjection::getIncomeOrDisburse));
      BigDecimal projectManagerIncome = CollectionUtils.isNotEmpty(incomeOrDisburse.get(true))
         ? incomeOrDisburse.get(true)
            .stream()
            .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getProjectManagerId()))
            .map(ContractProjectAssetInjection::getProjectManagerScale)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
         : BigDecimal.ZERO;
      BigDecimal projectManagerDisburse = CollectionUtils.isNotEmpty(incomeOrDisburse.get(false))
         ? incomeOrDisburse.get(false)
            .stream()
            .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getProjectManagerId()))
            .map(ContractProjectAssetInjection::getProjectManagerScale)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
         : BigDecimal.ZERO;
      BigDecimal contractSignIncome = CollectionUtils.isNotEmpty(incomeOrDisburse.get(true))
         ? incomeOrDisburse.get(true)
            .stream()
            .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
            .map(ContractProjectAssetInjection::getContractSignBodyScale)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
         : BigDecimal.ZERO;
      BigDecimal contractSignDisburse = CollectionUtils.isNotEmpty(incomeOrDisburse.get(false))
         ? incomeOrDisburse.get(false)
            .stream()
            .filter(a -> org.apache.commons.lang3.ObjectUtils.isNotEmpty(a.getContractSignBodyId()))
            .map(ContractProjectAssetInjection::getContractSignBodyScale)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
         : BigDecimal.ZERO;
      build.setContractSignBodyPayAmount(contractSignDisburse);
      build.setContractSignBodyRemainAmount(contractSignIncome);
      build.setProjectManagerRemainAmount(projectManagerIncome);
      build.setProjectManagerPayAmount(projectManagerDisburse);
      return build;
   }

   @Override
   public PageVO<InjectionExpendituresDetailDTO> getUseDetail(
      Long projectId, Long supplierId, Long orderId, LocalDateTime startTime, LocalDateTime endTime, Integer pageNumber, Integer pageSize
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(org.apache.commons.lang3.ObjectUtils.isNotEmpty(project), "合同不存在");
      List<PurchaseOrder> orders = this.orderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .like(org.apache.commons.lang3.ObjectUtils.isNotEmpty(orderId), PurchaseOrder::getId, orderId)
               .eq(org.apache.commons.lang3.ObjectUtils.isNotEmpty(supplierId), PurchaseOrder::getSupplierId, supplierId)
               .isNotNull(PurchaseOrder::getProjectIds)
         )
         .stream()
         .filter(a -> Arrays.asList(a.getProjectIds().split(",")).contains(projectId.toString()))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(orders)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ContractProjectAssetInjection> contractProjectAssetInjections = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractProjectAssetInjection.class)
               .eq(ContractProjectAssetInjection::getProjectId, projectId)
               .eq(ContractProjectAssetInjection::getIncomeOrDisburse, false)
               .apply(
                  org.apache.commons.lang3.ObjectUtils.isNotEmpty(startTime),
                  "date_format(create_time,'%Y-%m-%d') >= date_format('" + startTime + "','%Y-%m-%d')"
               )
               .apply(
                  org.apache.commons.lang3.ObjectUtils.isNotEmpty(endTime), "date_format(create_time,'%Y-%m-%d') <= date_format('" + endTime + "','%Y-%m-%d')"
               )
               .orderByDesc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isEmpty(contractProjectAssetInjections)) {
         return new PageVO<>();
      }

      Map<Long, PurchaseOrder> orderMap = orders.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      List<InjectionExpendituresDetailDTO> dto = new ArrayList<>();

      for (ContractProjectAssetInjection injection : contractProjectAssetInjections) {
         if (org.apache.commons.lang3.ObjectUtils.isNotEmpty(injection.getPaymentId())) {
            SupplierPayment byId = this.paymentService.getById(injection.getPaymentId());
            PurchaseOrder purchaseOrder = orderMap.get(byId.getOrderId());
            Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
            InjectionExpendituresDetailDTO build = InjectionExpendituresDetailDTO.builder()
               .date(injection.getAssetInjectionTime())
               .supplier(SupplierInfo.builder().supplierId(purchaseOrder.getId()).supplierName(supplier.getName()).build())
               .supplierNumber(purchaseOrder.getSerialNumber())
               .voucherNumber(injection.getVoucherNumber())
               .approvalNumber(byId.getApprovalSerialNumber())
               .build();
            if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
               build.setAmount(injection.getProjectManagerScale().add(injection.getContractSignBodyScale()));
               build.setProjectManagerPayAmount(injection.getProjectManagerScale());
               build.setSignBodyPayAmount(injection.getContractSignBodyScale());
            } else {
               build.setAmount(injection.getProjectManagerScale());
               build.setProjectManagerPayAmount(injection.getProjectManagerScale());
            }

            dto.add(build);
         } else {
            InjectionExpendituresDetailDTO build = InjectionExpendituresDetailDTO.builder()
               .date(injection.getAssetInjectionTime())
               .voucherNumber(injection.getVoucherNumber())
               .build();
            if (project.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
               build.setProjectManagerPayAmount(injection.getProjectManagerScale());
               build.setSignBodyPayAmount(injection.getContractSignBodyScale());
            } else {
               build.setAmount(injection.getProjectManagerScale());
               build.setProjectManagerPayAmount(injection.getProjectManagerScale());
            }

            dto.add(build);
         }
      }

      return new PageVO<>(dto);
   }
}
