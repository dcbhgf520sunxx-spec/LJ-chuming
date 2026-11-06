package com.hzchum.scim.rest.schedule;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesBehaviorTotalScore;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesBehaviorTotalScoreService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MesBehaviorScoreSchedule {
   private static final Logger log = LoggerFactory.getLogger(MesBehaviorScoreSchedule.class);
   @Resource
   private MesBehaviorTotalScoreService totalScoreService;
   @Resource
   private MesRosterService rosterService;
   @Resource
   private UserService userService;
   @Resource
   private MesBehaviorTotalScoreService behaviorTotalScoreService;

   @Scheduled(cron = "0 0 0 1 1 ?")
   public void task() {
      log.info("-----------------  新一年的行为总分设置开始 -----------------");
      int currentYear = LocalDate.now().getYear();
      MesBehaviorTotalScore currentYearTotalScore = this.totalScoreService.getByYear(currentYear);
      if (BeanUtil.isEmpty(currentYearTotalScore)) {
         currentYearTotalScore = this.totalScoreService.getByYear(currentYear - 1);
         if (currentYearTotalScore == null) {
            throw new IllegalStateException("Previous-year behavior score configuration is missing");
         }
         currentYearTotalScore.setId(null);
         currentYearTotalScore.setCreateTime(null);
         currentYearTotalScore.setUpdateTime(null);
         currentYearTotalScore.setYear(currentYear);
         this.totalScoreService.save(currentYearTotalScore);
         List<MesRoster> rosterList = this.rosterService.list();
         List<MesRoster> updateRosters = rosterList.stream().peek(roster -> {
            Integer currentBehaviorTotalScore = this.behaviorTotalScoreService.getTotalScore(null, roster.getEntryDate(), currentYear);
            roster.setBehaviorTotalScore(currentBehaviorTotalScore);
         }).collect(Collectors.toList());
         this.rosterService.updateBatchById(updateRosters);
         List<Long> userIds = CollUtil.removeNull(CollUtil.getFieldValues(rosterList, "userId", Long.class));
         if (!userIds.isEmpty()) {
            this.userService.update(Wrappers.lambdaUpdate(User.class).set(User::getIsEnabled, true).in(User::getId, userIds));
         }
      }

      log.info("-----------------  新一年的行为总分设置结束 -----------------");
   }
}
