package com.hzchum.scim.mes.building.core.biz.impl.laborManagement;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.laborManagement.MesBehaviorScoreBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesBehaviorTotalScore;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesBehaviorScoreDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.ViolationRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorScoreQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorTotalScoreParam;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesBehaviorTotalScoreService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.laborManagement.MesBehaviorScoreMapper;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBehaviorScoreBizImpl implements MesBehaviorScoreBiz {
   @Autowired
   private MesBehaviorScoreMapper behaviorScoreMapper;
   @Autowired
   private MesBehaviorTotalScoreService behaviorTotalScoreService;
   @Autowired
   private MesRosterService rosterService;
   @Autowired
   private UserService userService;

   @Override
   public PageVO<MesBehaviorScoreDTO> pageInfo(MesBehaviorScoreQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesBehaviorScoreDTO> list = this.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesBehaviorScoreDTO> listInfo(MesBehaviorScoreQuery query) {
      return this.behaviorScoreMapper.listInfo(query);
   }

   @Override
   public MesBehaviorTotalScore behaviorTotalScoreInfo(Integer year) {
      return this.behaviorTotalScoreService.getByYear(year);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean setEmployeeBehaviorTotalScore(Long rosterId, Integer behaviorTotalScore) {
      MesRoster roster = this.rosterService.getById(rosterId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(roster), "当前数据不存在, 请刷新后重试");
      this.rosterService
         .update(
            Wrappers.lambdaUpdate(MesRoster.class).eq(MesRoster::getId, rosterId).setSql("behavior_total_score = behavior_total_score + " + behaviorTotalScore)
         );
      this.userService.update(Wrappers.lambdaUpdate(User.class).eq(User::getId, roster.getUserId()).set(User::getIsEnabled, true));
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOrUpdateBehaviorTotalScore(MesBehaviorTotalScoreParam param) {
      Integer year = LocalDate.now().getYear();
      MesBehaviorTotalScore behaviorTotalScore = BeanUtil.toBean(param, MesBehaviorTotalScore.class);
      behaviorTotalScore.setYear(year);
      this.behaviorTotalScoreService
         .saveOrUpdate(behaviorTotalScore, Wrappers.lambdaUpdate(MesBehaviorTotalScore.class).eq(MesBehaviorTotalScore::getYear, year));
      List<MesRoster> rosters = this.rosterService.list().stream().peek(roster -> {
         Integer currentBehaviorTotalScore = this.behaviorTotalScoreService.getTotalScore(null, roster.getEntryDate(), year);
         roster.setBehaviorTotalScore(currentBehaviorTotalScore);
      }).collect(Collectors.toList());
      this.rosterService.updateBatchById(rosters);
      return true;
   }

   @Override
   public List<ViolationRecordDTO> violationRecord(Long userId, Integer year) {
      return this.behaviorScoreMapper.violationRecord(userId, year);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> violationRecordPrint(Long userId, Integer year) {
      PrintVO<List<Map<String, Object>>> printVo = new PrintVO<>();
      MesRosterDTO roster = this.rosterService.getByUserId(userId);
      Map<String, Object> header = new HashMap<>();
      header.put("year", year);
      header.put("supplierName", roster.getSupplierName());
      header.put("name", roster.getName());
      List<ViolationRecordDTO> list = this.violationRecord(userId, year);
      BigDecimal totalPenalty = list.stream().map(ViolationRecordDTO::getPenalty).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalPenalty", totalPenalty);
      List<Map<String, Object>> dataList = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVo.setHeader(header);
      printVo.setTable(dataList);
      return printVo;
   }

   @Override
   public Integer getRemainingBehaviorScore(Long userId) {
      List<MesBehaviorScoreDTO> list = this.listInfo(MesBehaviorScoreQuery.builder().userId(userId).year(LocalDate.now().getYear()).build());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list) && list.size() == 1, "当前数据不存在, 请刷新后重试");
      return list.get(0).getRemainingBehaviorScore();
   }
}
