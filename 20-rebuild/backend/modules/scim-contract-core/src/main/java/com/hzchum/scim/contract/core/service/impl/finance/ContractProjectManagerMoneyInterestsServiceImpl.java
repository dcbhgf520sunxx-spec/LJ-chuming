package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCredit;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectManagerMoneyInterests;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectInterestFundsDto;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectManagerMoneyInterestsDto;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditService;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectManagerMoneyInterestsService;
import com.hzchum.scim.contract.core.mapper.finance.ContractProjectManagerMoneyInterestsMapper;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectManagerMoneyInterestsServiceImpl
   extends ServiceImpl<ContractProjectManagerMoneyInterestsMapper, ContractProjectManagerMoneyInterests>
   implements ContractProjectManagerMoneyInterestsService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private UserService userService;
   @Resource
   private ContractGivingCreditService givingCreditService;
   private final Integer one = 1;
   private final Integer two = 2;
   private final Integer three = 3;
   private final Integer four = 4;
   private final Integer six = 6;
   private final Integer seven = 7;
   private final Integer nine = 9;
   private final Integer ten = 10;
   private final Integer twelve = 12;

   @Override
   public PageVO<ContractProjectManagerMoneyInterestsDto> getProjectInterest(
      Long projectId, Integer pageNumber, Integer pageSize, LocalDateTime startDate, LocalDateTime endDate
   ) {
      List<ContractProjectManagerMoneyInterests> moneyInterests = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractProjectManagerMoneyInterests.class)
               .eq(ContractProjectManagerMoneyInterests::getProjectId, projectId)
               .apply(startDate != null, "date_format(create_time,'%Y-%m-%d') >= date_format('" + startDate + "','%Y-%m-%d')")
               .apply(startDate != null, "date_format(create_time,'%Y-%m-%d') <= date_format('" + endDate + "','%Y-%m-%d')")
         );
      if (moneyInterests.isEmpty()) {
         return new PageVO<>();
      }

      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<ContractProjectManagerMoneyInterestsDto> dto = new ArrayList<>();
      moneyInterests.forEach(a -> {
         ContractProjectManagerMoneyInterestsDto interestsDto = BeanUtil.copy(a, ContractProjectManagerMoneyInterestsDto.class);
         interestsDto.setProjectManagerName(userMap.get(a.getProjectManagerId()).getName());
         interestsDto.setUserName(userMap.get(a.getUserId()).getName());
         interestsDto.setProjectName(projectMap.get(a.getProjectId()).getSerialNumber() + "-" + projectMap.get(a.getProjectId()).getShortName());
         if (a.getLiabilities() != null) {
            interestsDto.setLiabilities(a.getLiabilities());
         }

         dto.add(interestsDto);
      });
      PageVO<ContractProjectManagerMoneyInterestsDto> dtoPageVO = new PageVO<>(PageUtils.getPage(dto, pageNumber, pageSize));
      dtoPageVO.setTotalElements(dto.size());
      return dtoPageVO;
   }

   @Override
   public List<ContractProjectInterestFundsDto> getProjectQuarterInterest(Long projectId) {
      List<ContractProjectInterestFundsDto> interestFundsDtos = new ArrayList<>();
      List<ContractProjectManagerMoneyInterests> moneyInterests = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractProjectManagerMoneyInterests.class).eq(ContractProjectManagerMoneyInterests::getProjectId, projectId));
      if (CollectionUtils.isNotEmpty(moneyInterests)) {
         ContractGivingCredit credit = this.givingCreditService
            .getOne(
               Wrappers.lambdaQuery(ContractGivingCredit.class)
                  .eq(ContractGivingCredit::getProjectId, projectId)
                  .eq(ContractGivingCredit::getAccreditingPartyId, moneyInterests.get(0).getProjectManagerId())
            );
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(credit), "此项目没有设置授信");
         Preconditions.checkArgument(!LocalDateTime.now().isAfter(credit.getClosingDate()), "此项目设置授信已过期");
         Map<Integer, List<ContractProjectManagerMoneyInterests>> years = moneyInterests.stream()
            .collect(Collectors.groupingBy(event -> event.getCreateTime().getYear()));
         years.forEach(
            (year, events) -> {
               Map<Integer, List<ContractProjectManagerMoneyInterests>> months = events.stream()
                  .collect(Collectors.groupingBy(event -> this.getQuarter(event.getCreateTime())));
               months.forEach(
                  (month, objs) -> {
                     List<ContractProjectManagerMoneyInterests> managerMoneyInterests = new ArrayList<>();
                     ContractProjectInterestFundsDto fundsDto = new ContractProjectInterestFundsDto();
                     if (month == this.one) {
                        LocalDate startDate = LocalDate.of(year, this.one, this.one);
                        LocalDate endDate = LocalDate.of(year, this.three, YearMonth.of(year, this.three).lengthOfMonth());
                        managerMoneyInterests = objs.stream()
                           .filter(obj -> obj.getCreateTime().isAfter(startDate.atStartOfDay()) || obj.getCreateTime().isBefore(endDate.atStartOfDay()))
                           .collect(Collectors.toList());
                        fundsDto.setInterestTime(startDate.atStartOfDay());
                        fundsDto.setExpireTime(endDate.atStartOfDay());
                     }

                     if (month == this.two) {
                        LocalDate startDate = LocalDate.of(year, this.four, this.one);
                        LocalDate endDate = LocalDate.of(year, this.six, YearMonth.of(year, this.six).lengthOfMonth());
                        managerMoneyInterests = objs.stream()
                           .filter(obj -> obj.getCreateTime().isAfter(startDate.atStartOfDay()) || obj.getCreateTime().isBefore(endDate.atStartOfDay()))
                           .collect(Collectors.toList());
                        fundsDto.setInterestTime(startDate.atStartOfDay());
                        fundsDto.setExpireTime(endDate.atStartOfDay());
                     }

                     if (month == this.three) {
                        LocalDate startDate = LocalDate.of(year, this.seven, this.one);
                        LocalDate endDate = LocalDate.of(year, this.nine, YearMonth.of(year, this.nine).lengthOfMonth());
                        managerMoneyInterests = objs.stream()
                           .filter(obj -> obj.getCreateTime().isAfter(startDate.atStartOfDay()) || obj.getCreateTime().isBefore(endDate.atStartOfDay()))
                           .collect(Collectors.toList());
                        fundsDto.setInterestTime(startDate.atStartOfDay());
                        fundsDto.setExpireTime(endDate.atStartOfDay());
                     }

                     if (month == this.four) {
                        LocalDate startDate = LocalDate.of(year, this.ten, this.one);
                        LocalDate endDate = LocalDate.of(year, this.twelve, YearMonth.of(year, this.twelve).lengthOfMonth());
                        managerMoneyInterests = objs.stream()
                           .filter(obj -> obj.getCreateTime().isAfter(startDate.atStartOfDay()) || obj.getCreateTime().isBefore(endDate.atStartOfDay()))
                           .collect(Collectors.toList());
                        fundsDto.setInterestTime(startDate.atStartOfDay());
                        fundsDto.setExpireTime(endDate.atStartOfDay());
                     }

                     if (!managerMoneyInterests.isEmpty()) {
                        List<ContractProjectManagerMoneyInterests> collect = managerMoneyInterests.stream()
                           .filter(obj -> obj.getLiabilities() != null)
                           .filter(obj -> obj.getLiabilitiesDay() != null)
                           .collect(Collectors.toList());
                        BigDecimal dailyAmount = collect.stream()
                           .map(obj -> obj.setDailyAmount(obj.getLiabilities().multiply(new BigDecimal(obj.getLiabilitiesDay()))))
                           .map(ContractProjectManagerMoneyInterests::getDailyAmount)
                           .reduce(BigDecimal.ZERO, BigDecimal::add);
                        fundsDto.setDailyAmount(dailyAmount);
                        BigDecimal incomeSum = managerMoneyInterests.stream()
                           .filter(obj -> obj.getIncome() != null)
                           .map(ContractProjectManagerMoneyInterests::getIncome)
                           .reduce(BigDecimal.ZERO, BigDecimal::add);
                        BigDecimal dayInterest = credit.getDayInterest().divide(new BigDecimal("100"));
                        BigDecimal settledInterest = incomeSum.multiply(dayInterest);
                        fundsDto.setSettlementInterest(settledInterest);
                        BigDecimal liabilities = dailyAmount.multiply(dayInterest);
                        fundsDto.setLiabilities(liabilities);
                        BigDecimal negativeAmount = managerMoneyInterests.stream()
                           .filter(obj -> obj.getDailyAmount() != null)
                           .map(ContractProjectManagerMoneyInterests::getDailyAmount)
                           .reduce(BigDecimal.ZERO, BigDecimal::add);
                        fundsDto.setNegativeAmount(negativeAmount);
                        fundsDto.setSettlementDay(
                           managerMoneyInterests.stream()
                              .filter(obj -> obj.getLiabilitiesDay() != null)
                              .map(ContractProjectManagerMoneyInterests::getLiabilitiesDay)
                              .reduce(0, Integer::sum)
                        );
                        fundsDto.setProjectId(managerMoneyInterests.get(0).getProjectId());
                        fundsDto.setAnnualInterest(credit.getDayInterest().toString());
                        interestFundsDtos.add(fundsDto);
                     }
                  }
               );
            }
         );
      }

      return interestFundsDtos;
   }

   private int getQuarter(LocalDateTime date) {
      Month month = date.getMonth();
      if (month.equals(Month.JANUARY) || month.equals(Month.FEBRUARY) || month.equals(Month.MARCH)) {
         return this.one;
      } else if (month.equals(Month.APRIL) || month.equals(Month.MAY) || month.equals(Month.JUNE)) {
         return this.two;
      } else {
         return !month.equals(Month.JULY) && !month.equals(Month.AUGUST) && !month.equals(Month.SEPTEMBER) ? this.four : this.three;
      }
   }
}
