package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import com.hzchum.scim.bid.core.api.pojo.vo.SubjectTreeVO;
import com.hzchum.scim.bid.core.api.service.SubjectService;
import com.hzchum.scim.bid.core.mapper.SubjectMapper;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
   @Resource
   private ConfigService configService;

   @Override
   public ListVO tree(Boolean configuration) {
      List<SubjectTreeVO> subjectList = this.baseMapper.getSubjectList(this.configService.getCompanyConfig().getUUID(), configuration);
      if (CollectionUtils.isEmpty(subjectList)) {
         return new ListVO();
      }

      Map<Long, List<SubjectTreeVO>> subjectMap = subjectList.stream().collect(Collectors.groupingBy(SubjectTreeVO::getPid));
      return new ListVO<>(this.buildTree(0L, subjectMap));
   }

   @Override
   public ListVO listFirst(Long subjectId) {
      Subject subject = this.baseMapper.selectOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, subjectId));
      Preconditions.checkArgument(subject != null, "科目不能为空");
      Preconditions.checkArgument(subject.getLevel().equals(1), "科目不是一级科目");
      List<SubjectTreeVO> subjectByPath = this.baseMapper.getSubjectByPath(subject.getPath());
      if (CollectionUtils.isEmpty(subjectByPath)) {
         return new ListVO();
      }

      Map<Long, List<SubjectTreeVO>> subjectMap = subjectByPath.stream().collect(Collectors.groupingBy(SubjectTreeVO::getPid));
      List<SubjectTreeVO> subjectTreeVOList = this.buildTree(0L, subjectMap);
      return new ListVO<>(subjectTreeVOList.get(0).getChildren());
   }

   @Override
   public String getFullNameBySubjectId(Long subjectId) {
      Subject subject = this.baseMapper.selectOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, subjectId));
      Preconditions.checkArgument(subject != null, "科目不存在");
      return subject.getLevel() == 1 ? subject.getName() : this.getFullNameBySubjectId(subject.getPid()) + ">" + subject.getName();
   }

   @Override
   public List<Subject> getSubject() {
      return this.baseMapper.getSubject();
   }

   private List<SubjectTreeVO> buildTree(Long pid, Map<Long, List<SubjectTreeVO>> subjectMap) {
      List<SubjectTreeVO> subjectTreeVOS = subjectMap.get(pid);
      return CollectionUtils.isEmpty(subjectTreeVOS)
         ? new ArrayList<>()
         : subjectTreeVOS.stream()
            .peek(subjectTreeVO -> subjectTreeVO.setChildren(this.buildTree(subjectTreeVO.getSubjectId(), subjectMap)))
            .collect(Collectors.toList());
   }
}
