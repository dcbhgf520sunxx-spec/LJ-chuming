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
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGivingCreditBiz;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.StatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGivingCreditDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractGivingCreditDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGivingCreditMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractGivingCreditBizImpl
   extends IBizImpl<ContractGivingCreditService, ContractGivingCreditMapper, ContractGivingCredit>
   implements ContractGivingCreditBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractGivingCreditDetailService givingCreditDetailService;

   @Override
   public PageVO<ContractGivingCreditDto> pageSize(LocalDateTime date, Long userId, Long suretyId, String idNumber, Integer pageNumber, Integer pageSize) {
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractGivingCreditDto> list = this.baseMapper.pageSize(null, date, userId, suretyId, idNumber);
      list.forEach(a -> {
         a.setUsedCredit(a.getLineOfCredit().subtract(a.getRemainingSum()));
         a.setCountDown((int)ChronoUnit.DAYS.between(LocalDateTime.now(), a.getClosingDate().plusDays(1L)));
         ContractProject contractProject = projectMap.get(a.getProjectId());
         if (ObjectUtils.isNotEmpty(contractProject)) {
            a.setProjectName(contractProject.getSerialNumber() + " " + contractProject.getShortName());
         }
      });
      return new PageVO<>(list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractGivingCredit(ContractGivingCreditDtoParam param) {
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "授信项目不存在!");
      Preconditions.checkArgument(!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "该项目为自营项目!");
      Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "授信项目已结算!");
      Preconditions.checkArgument(project.getProjectManagerId().equals(param.getAccreditingPartyId()), "授信人员不是项目经理!");
      Preconditions.checkArgument(!param.getIdNumber().equals(param.getAccreditingIdNumber()), "授信人员和担保人身份证号码不能相同!");
      this.checkDate(param.getStartDate(), param.getClosingDate(), param.getProjectId(), null);
      ContractGivingCredit givingCredit = BeanUtil.copy(param, ContractGivingCredit.class);
      givingCredit.setMonthlyInterest(param.getAnnualInterest().divide(BigDecimal.valueOf(12L), 8, RoundingMode.HALF_UP));
      givingCredit.setDayInterest(param.getAnnualInterest().divide(BigDecimal.valueOf(Year.now().length()), 8, RoundingMode.HALF_UP));
      givingCredit.setUsedCredit(BigDecimal.ZERO);
      givingCredit.setRemainingSum(param.getLineOfCredit());
      givingCredit.setConstructionAgentId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId());
      givingCredit.setUserId(UserUtil.getCurrentUserId());
      givingCredit.setStatus(StatusEnum.ENABLED.getType());
      if (CollectionUtils.isNotEmpty(param.getAccessoryId())) {
         givingCredit.setAccessoryId(param.getAccessoryId().get(0));
      }

      this.baseService.save(givingCredit);
      return Boolean.TRUE;
   }

   private void checkDate(LocalDateTime startDate, LocalDateTime closingDate, Long projectId, Long id) {
      if (id != null) {
         List<ContractGivingCreditDetail> givingCreditDetailList = this.givingCreditDetailService
            .list(Wrappers.lambdaQuery(ContractGivingCreditDetail.class).eq(ContractGivingCreditDetail::getCreditId, id));
         boolean allMatch = givingCreditDetailList.stream()
            .allMatch(
               detail -> !detail.getUseDate().toLocalDate().isBefore(startDate.toLocalDate())
                  && !detail.getUseDate().toLocalDate().isAfter(closingDate.toLocalDate())
            );
         Preconditions.checkArgument(givingCreditDetailList.isEmpty() || allMatch, "已存在借款记录,修改时间段超出范围!");
      }

      List<ContractGivingCredit> givingCreditList = this.baseService
         .list(
            Wrappers.lambdaQuery(ContractGivingCredit.class)
               .eq(ContractGivingCredit::getProjectId, projectId)
               .eq(ContractGivingCredit::getStatus, StatusEnum.ENABLED.getType())
               .ne(id != null, ContractGivingCredit::getId, id)
         );
      List<ContractGivingCredit> creditList = givingCreditList.stream()
         .filter(
            gc -> !gc.getStartDate().toLocalDate().isAfter(closingDate.toLocalDate())
               && !gc.getClosingDate().toLocalDate().isBefore(startDate.toLocalDate())
         )
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isEmpty(creditList), "时间段内,该项目已存在授信!");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean putContractGivingCredit(ContractGivingCreditDtoParam param) {
      ContractGivingCredit givingCredit = this.baseService.getById(param.getId());
      Preconditions.checkArgument(givingCredit != null, "授信记录不存在!");
      Preconditions.checkArgument(!param.getIdNumber().equals(param.getAccreditingIdNumber()), "授信人员和担保人身份证号码不能相同!");
      Preconditions.checkArgument(param.getLineOfCredit().compareTo(givingCredit.getUsedCredit()) >= 0, "授信额度不能低于已使用额度!");
      Preconditions.checkArgument(param.getLineOfCredit().compareTo(BigDecimal.ZERO) > 0, "授信额度不能为0!");
      if (!param.getStartDate().toLocalDate().isEqual(givingCredit.getStartDate().toLocalDate())
         || !param.getClosingDate().toLocalDate().isEqual(givingCredit.getClosingDate().toLocalDate())) {
         this.checkDate(param.getStartDate(), param.getClosingDate(), givingCredit.getProjectId(), param.getId());
      }

      givingCredit.setStartDate(param.getStartDate());
      givingCredit.setClosingDate(param.getClosingDate());
      givingCredit.setSuretyName(param.getSuretyName());
      givingCredit.setIdNumber(param.getIdNumber());
      givingCredit.setAccreditingIdNumber(param.getAccreditingIdNumber());
      if (param.getAnnualInterest().compareTo(givingCredit.getAnnualInterest()) != 0) {
         givingCredit.setMonthlyInterest(param.getAnnualInterest().divide(BigDecimal.valueOf(12L), 8, RoundingMode.HALF_UP));
         givingCredit.setDayInterest(param.getAnnualInterest().divide(BigDecimal.valueOf(Year.now().length()), 8, RoundingMode.HALF_UP));
      }

      givingCredit.setAnnualInterest(param.getAnnualInterest());
      givingCredit.setLineOfCredit(param.getLineOfCredit());
      givingCredit.setRemainingSum(param.getLineOfCredit().subtract(givingCredit.getUsedCredit()));
      givingCredit.setConstructionAgentId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId());
      this.baseMapper.updateById(givingCredit);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delContractGivingCredit(List<Long> ids) {
      ids.forEach(id -> {
         ContractGivingCredit givingCredit = this.baseService.getById(id);
         Preconditions.checkArgument(givingCredit != null, "授信记录不存在!");
         Preconditions.checkArgument(givingCredit.getUsedCredit().compareTo(BigDecimal.ZERO) == 0, "该授信已使用，不可删除!");
         this.baseService.removeById(id);
      });
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean putContractGivingCreditStatus(Long id, Integer status) {
      Preconditions.checkArgument(Arrays.stream(StatusEnum.values()).anyMatch(e -> e.getType().equals(status)), "状态传值有误!");
      ContractGivingCredit contractGivingCredit = this.baseMapper.selectById(id);
      Preconditions.checkArgument(contractGivingCredit != null, "该授信信息不存在");
      if (contractGivingCredit.getStatus().equals(StatusEnum.DISABLED.getType()) && status.equals(StatusEnum.ENABLED.getType())) {
         this.checkDate(contractGivingCredit.getStartDate(), contractGivingCredit.getClosingDate(), contractGivingCredit.getProjectId(), id);
      }

      contractGivingCredit.setStatus(status);
      this.baseMapper.updateById(contractGivingCredit);
      return Boolean.TRUE;
   }

   @Override
   public ContractGivingCreditDto getContractGivingCredit(Long id) {
      ContractGivingCredit contractGivingCredit = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(contractGivingCredit), "该授信信息不存在");
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      ContractGivingCreditDto creditDto = BeanUtil.copy(contractGivingCredit, ContractGivingCreditDto.class);
      creditDto.setSuretyName(contractGivingCredit.getSuretyName());
      creditDto.setAccreditingPartyName(userMap.get(contractGivingCredit.getAccreditingPartyId()).getName());
      creditDto.setProjectName(projectMap.get(contractGivingCredit.getProjectId()).getName());
      creditDto.setAttachmentDTOS(this.attachmentService.getById(contractGivingCredit.getAccessoryId()));
      return creditDto;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> download(Integer year, Long userId, Long suretyId, String idNumber) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ContractGivingCredit> contractGivingCredits = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractGivingCredit.class)
               .apply(ObjectUtils.isNotEmpty(year), "year(create_time) = {0}", year)
               .eq(ObjectUtils.isNotEmpty(userId), ContractGivingCredit::getUserId, userId)
               .eq(ObjectUtils.isNotEmpty(suretyId), ContractGivingCredit::getAccreditingPartyId, suretyId)
               .like(StringUtils.isNotBlank(idNumber), ContractGivingCredit::getIdNumber, idNumber)
         );
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<ContractGivingCreditDto> dtos = new ArrayList<>();
      contractGivingCredits.forEach(credits -> {
         ContractGivingCreditDto creditDto = BeanUtil.copy(credits, ContractGivingCreditDto.class);
         creditDto.setAccreditingPartyName(userMap.get(credits.getAccreditingPartyId()).getName());
         creditDto.setUserName(userMap.get(credits.getUserId()).getName());
         creditDto.setProjectName(projectMap.get(credits.getProjectId()).getName());
         dtos.add(creditDto);
      });
      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<ProjectInfo> getProject(Long projectManagerId) {
      List<ProjectInfo> list = new ArrayList<>();
      List<ContractProject> contractProjects = Collections.unmodifiableList(
         this.projectService
            .list(
               Wrappers.lambdaQuery(ContractProject.class)
                  .apply("project_attribute != {0}", ProjectAttributeEnum.SELF_SUPPORT.getType())
                  .eq(ContractProject::getProjectManagerId, projectManagerId)
            )
      );
      if (CollectionUtils.isEmpty(contractProjects)) {
         return null;
      }

      contractProjects.forEach(
         a -> list.add(
            ProjectInfo.builder()
               .id(a.getId())
               .shortName(a.getShortName())
               .name(a.getName())
               .serialNumber(a.getSerialNumber())
               .projectAttribute(a.getProjectAttribute())
               .build()
         )
      );
      return list;
   }
}
