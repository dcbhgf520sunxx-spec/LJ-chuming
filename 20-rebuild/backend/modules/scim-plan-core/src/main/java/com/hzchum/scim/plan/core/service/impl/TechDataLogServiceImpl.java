package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.plan.core.api.pojo._do.TechDataLog;
import com.hzchum.scim.plan.core.api.pojo.dto.TechDataLogDTO;
import com.hzchum.scim.plan.core.api.service.TechDataLogService;
import com.hzchum.scim.plan.core.mapper.TechDataLogMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TechDataLogServiceImpl extends ServiceImpl<TechDataLogMapper, TechDataLog> implements TechDataLogService {
   @Override
   public PageVO<TechDataLogDTO> listDataLogs(
      LocalDate startDate, LocalDate endDate, String userName, Integer operationType, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechDataLog> techDataLogList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(TechDataLog.class)
               .ge(startDate != null, BaseEntity::getCreateTime, startDate)
               .le(endDate != null, BaseEntity::getCreateTime, endDate)
               .like(StringUtils.isNotBlank(userName), TechDataLog::getUserName, userName)
               .eq(operationType != null, TechDataLog::getOperationType, operationType)
               .orderByDesc(TechDataLog::getId)
         );
      if (techDataLogList.isEmpty()) {
         return new PageVO<>();
      }

      List<TechDataLogDTO> dataLogDTOList = techDataLogList.stream().map(log -> BeanUtil.copy(log, TechDataLogDTO.class)).collect(Collectors.toList());
      return new PageVO<>(dataLogDTOList);
   }
}
