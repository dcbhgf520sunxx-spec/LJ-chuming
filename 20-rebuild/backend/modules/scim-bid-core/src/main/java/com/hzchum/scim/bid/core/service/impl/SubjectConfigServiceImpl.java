package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import com.hzchum.scim.bid.core.api.pojo._do.SubjectConfig;
import com.hzchum.scim.bid.core.api.pojo.dto.SubjectDTO;
import com.hzchum.scim.bid.core.api.service.SubjectConfigService;
import com.hzchum.scim.bid.core.api.service.SubjectService;
import com.hzchum.scim.bid.core.mapper.SubjectConfigMapper;
import com.hzchum.scim.system.core.api.service.ConfigService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@DS("bidding")
@Service
public class SubjectConfigServiceImpl extends ServiceImpl<SubjectConfigMapper, SubjectConfig> implements SubjectConfigService {
   @Resource
   private SubjectService subjectService;
   @Resource
   private ConfigService configService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateConfig(SubjectDTO subjectDTO) {
      Subject subject = this.subjectService.getById(subjectDTO.getSubjectId());
      Preconditions.checkArgument(subject != null, "科目不存在");
      Preconditions.checkArgument(subject.getLevel().equals(1), "只能配置一级科目");
      String uuid = this.configService.getCompanyConfig().getUUID();
      SubjectConfig subjectConfig = this.baseMapper
         .selectOne(
            (Wrapper<SubjectConfig>)(new LambdaQueryWrapper<SubjectConfig>().eq(SubjectConfig::getSubjectId, subjectDTO.getSubjectId()))
               .eq(SubjectConfig::getUUID, uuid)
         );
      if (subjectConfig == null) {
         subjectConfig = SubjectConfig.builder()
            .code(subjectDTO.getCode())
            .number(subjectDTO.getNumber())
            .UUID(uuid)
            .subjectId(subjectDTO.getSubjectId())
            .build();
         return this.baseMapper.insert(subjectConfig) == 1;
      } else {
         subjectConfig.setCode(subjectDTO.getCode());
         subjectConfig.setNumber(subjectDTO.getNumber());
         return this.baseMapper.updateById(subjectConfig) == 1;
      }
   }
}
