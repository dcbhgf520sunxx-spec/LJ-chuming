package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.system.core.api.pojo._do.SysProjectPersonnel;
import com.hzchum.scim.system.core.api.pojo._do.SysTemplateUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectPersonnelSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectPersonnelUpdateDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysProjectPersonnelDTO;
import com.hzchum.scim.system.core.api.service.SysProjectPersonnelService;
import com.hzchum.scim.system.core.mapper.SysProjectPersonnelMapper;
import com.hzchum.scim.system.core.mapper.SysTemplateUserLinkMapper;
import com.hzchum.scim.system.core.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysProjectPersonnelServiceImpl extends ServiceImpl<SysProjectPersonnelMapper, SysProjectPersonnel> implements SysProjectPersonnelService {
   private final SysProjectPersonnelMapper projectPersonnelMapper;
   private final UserMapper userMapper;
   private final SysTemplateUserLinkMapper templateUserLinkMapper;

   @Override
   public PageVO<SysProjectPersonnelDTO> listAllTemplate(String templateName, Integer status, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SysProjectPersonnel> perSonNels = this.projectPersonnelMapper
         .selectList(
            Wrappers.lambdaQuery(SysProjectPersonnel.class)
               .eq(templateName != null, SysProjectPersonnel::getTemplateName, templateName)
               .eq(status != null, SysProjectPersonnel::getStatus, status)
               .orderByDesc(SysProjectPersonnel::getIsDefault)
               .orderByDesc(SysProjectPersonnel::getStatus)
               .orderByDesc(SysProjectPersonnel::getId)
         );
      List<SysProjectPersonnelDTO> collect = perSonNels.stream().map(p -> BeanUtil.copy(p, SysProjectPersonnelDTO.class)).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(collect, perSonNels));
   }

   @Override
   public ListVO<ProjectUserLinkDTO> detailsTemplate(Long id) {
      SysProjectPersonnel personnel = this.projectPersonnelMapper.selectById(id);
      Preconditions.checkArgument(personnel != null, "该模板信息不存在");
      List<ProjectUserLinkDTO> responseVOS = this.projectPersonnelMapper.listByProjectIdAndUserName(id);
      return new ListVO<>(responseVOS);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateStatus(Long id, Integer status) {
      SysProjectPersonnel personnel = this.projectPersonnelMapper.selectById(id);
      Preconditions.checkArgument(personnel != null, "该模板信息不存在");
      personnel.setStatus(status);
      if (EnableEnum.DISABLE.getType().equals(status)) {
         personnel.setIsDefault(false);
      }

      return this.projectPersonnelMapper.updateById(personnel) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveTemplate(ProjectPersonnelSaveDTOParam saveDTOParam) {
      Integer count = this.baseMapper
         .selectCount((Wrapper<SysProjectPersonnel>)Wrappers.<SysProjectPersonnel>lambdaQuery().eq(SysProjectPersonnel::getTemplateName, saveDTOParam.getTemplateName()));
      Preconditions.checkArgument(count == 0, "保存失败,该模板名称已存在");
      if (saveDTOParam.getIsDefault().equals(Boolean.TRUE)) {
         SysProjectPersonnel selectOne = this.baseMapper
            .selectOne((Wrapper<SysProjectPersonnel>)Wrappers.<SysProjectPersonnel>lambdaQuery().eq(SysProjectPersonnel::getIsDefault, Boolean.TRUE));
         if (selectOne != null) {
            selectOne.setIsDefault(Boolean.FALSE);
            this.baseMapper.updateById(selectOne);
         }
      }

      SysProjectPersonnel personnel = BeanUtil.copy(saveDTOParam, SysProjectPersonnel.class);
      personnel.setStatus(EnableEnum.ENABLE.getType());
      this.baseMapper.insert(personnel);
      return this.setTemplateUser(saveDTOParam.getUserIdList(), personnel);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean removeTemplate(Long id) {
      SysProjectPersonnel personnel = this.projectPersonnelMapper.selectById(id);
      Preconditions.checkArgument(personnel != null, "该模板不存在");
      this.projectPersonnelMapper.deleteById(id);
      this.templateUserLinkMapper.delete((Wrapper<SysTemplateUserLink>)Wrappers.<SysTemplateUserLink>lambdaQuery().eq(SysTemplateUserLink::getTemplateId, id));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateTemplate(ProjectPersonnelUpdateDTOParam updateDTOParam) {
      SysProjectPersonnel personnel = this.projectPersonnelMapper.selectById(updateDTOParam.getId());
      Preconditions.checkArgument(personnel != null, "保存失败,该模板不存在");
      Preconditions.checkArgument(
         !personnel.getStatus().equals(EnableEnum.DISABLE.getType()) || !updateDTOParam.getIsDefault().equals(true), "该模板已被禁用，无法设为默认模板"
      );
      if (updateDTOParam.getTemplateName() != null && !updateDTOParam.getTemplateName().equals(personnel.getTemplateName())) {
         Integer count = this.projectPersonnelMapper
            .selectCount((Wrapper<SysProjectPersonnel>)Wrappers.<SysProjectPersonnel>lambdaQuery().eq(SysProjectPersonnel::getTemplateName, updateDTOParam.getTemplateName()));
         Preconditions.checkArgument(count == 0, "保存失败,该模板名称已存在");
      }

      if (updateDTOParam.getIsDefault().equals(Boolean.TRUE) && personnel.getIsDefault().equals(Boolean.FALSE)) {
         SysProjectPersonnel sysProjectPersonnel = this.baseMapper
            .selectOne((Wrapper<SysProjectPersonnel>)Wrappers.<SysProjectPersonnel>lambdaQuery().eq(SysProjectPersonnel::getIsDefault, Boolean.TRUE));
         if (sysProjectPersonnel != null) {
            sysProjectPersonnel.setIsDefault(Boolean.FALSE);
            this.baseMapper.updateById(sysProjectPersonnel);
         }
      }

      BeanUtil.copy(updateDTOParam, personnel);
      this.baseMapper.updateById(personnel);
      List<SysTemplateUserLink> templateUserLinkList = this.templateUserLinkMapper
         .selectList((Wrapper<SysTemplateUserLink>)Wrappers.<SysTemplateUserLink>lambdaQuery().eq(SysTemplateUserLink::getTemplateId, updateDTOParam.getId()));
      if (CollectionUtils.isNotEmpty(templateUserLinkList)) {
         templateUserLinkList.forEach(link -> this.templateUserLinkMapper.deleteById(link.getId()));
      }

      return this.setTemplateUser(updateDTOParam.getUserIdList(), personnel);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setDefault(Long id, Boolean isDefault) {
      SysProjectPersonnel personnel = this.projectPersonnelMapper.selectById(id);
      Preconditions.checkArgument(personnel != null, "该模板不存在");
      Preconditions.checkArgument(!EnableEnum.DISABLE.getType().equals(personnel.getStatus()), "该模板已被禁用，无法切换默认状态");
      personnel.setIsDefault(isDefault);
      if (isDefault && personnel.getIsDefault().equals(Boolean.FALSE)) {
         SysProjectPersonnel sysProjectPersonnel = this.baseMapper
            .selectOne((Wrapper<SysProjectPersonnel>)Wrappers.<SysProjectPersonnel>lambdaQuery().eq(SysProjectPersonnel::getIsDefault, Boolean.TRUE));
         if (sysProjectPersonnel != null) {
            sysProjectPersonnel.setIsDefault(Boolean.FALSE);
            this.baseMapper.updateById(sysProjectPersonnel);
         }
      }

      personnel.setIsDefault(isDefault);
      return this.projectPersonnelMapper.updateById(personnel) == 1;
   }

   private Boolean setTemplateUser(List<Long> userIdList, SysProjectPersonnel personnel) {
      if (CollectionUtils.isNotEmpty(userIdList)) {
         userIdList.forEach(userId -> {
            SysTemplateUserLink link = SysTemplateUserLink.builder().templateId(personnel.getId()).userId(userId).build();
            this.templateUserLinkMapper.insert(link);
         });
         return Boolean.TRUE;
      } else {
         return Boolean.FALSE;
      }
   }

   public SysProjectPersonnelServiceImpl(
      final SysProjectPersonnelMapper projectPersonnelMapper, final UserMapper userMapper, final SysTemplateUserLinkMapper templateUserLinkMapper
   ) {
      this.projectPersonnelMapper = projectPersonnelMapper;
      this.userMapper = userMapper;
      this.templateUserLinkMapper = templateUserLinkMapper;
   }
}
