package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysTablePrintTemplate;
import com.hzchum.scim.system.core.api.pojo.dto.TablePrintTemplateRequestDTOParam;
import com.hzchum.scim.system.core.api.service.SysTablePrintTemplateService;
import com.hzchum.scim.system.core.mapper.SysTablePrintTemplateMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysTablePrintTemplateServiceImpl extends ServiceImpl<SysTablePrintTemplateMapper, SysTablePrintTemplate> implements SysTablePrintTemplateService {
   @Resource
   private SysTablePrintTemplateMapper tablePrintTemplateMapper;

   @Override
   public PageVO<SysTablePrintTemplate> list(String name, String type, Boolean enabled, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.tablePrintTemplateMapper.list(name, type, enabled));
   }

   @Override
   public Boolean save(TablePrintTemplateRequestDTOParam request) {
      List<SysTablePrintTemplate> templates = this.tablePrintTemplateMapper.listByType(request.getType());
      templates.forEach(template -> {
         Preconditions.checkArgument(!request.getName().equals(template.getName()), "添加失败，名称不能重复");
         if (request.getIsDefault() && template.getIsDefault()) {
            template.setIsDefault(Boolean.FALSE);
            this.tablePrintTemplateMapper.updateById(template);
         }
      });
      SysTablePrintTemplate tablePrintTemplate = BeanUtil.copy(request, SysTablePrintTemplate.class);
      tablePrintTemplate.setEnabled(true);
      return this.tablePrintTemplateMapper.insert(tablePrintTemplate) == 1;
   }

   @Override
   public Boolean update(Long id, TablePrintTemplateRequestDTOParam requestVO) {
      SysTablePrintTemplate tablePrintTemplate = this.tablePrintTemplateMapper.selectById(id);
      if (requestVO.getIsDefault() && !tablePrintTemplate.getIsDefault()) {
         List<SysTablePrintTemplate> templates = this.tablePrintTemplateMapper.listByType(requestVO.getType());
         templates.forEach(template -> {
            if (!requestVO.getName().equals(tablePrintTemplate.getName())) {
               Preconditions.checkArgument(!requestVO.getName().equals(template.getName()), "更新失败，名称不能重复");
            }

            if (template.getIsDefault()) {
               template.setIsDefault(Boolean.FALSE);
               this.tablePrintTemplateMapper.updateById(template);
            }
         });
      }

      BeanUtil.copy(requestVO, tablePrintTemplate);
      tablePrintTemplate.setEnabled(tablePrintTemplate.getEnabled() == null ? tablePrintTemplate.getEnabled() : requestVO.getEnabled());
      return this.tablePrintTemplateMapper.updateById(tablePrintTemplate) == 1;
   }

   @Override
   public Boolean updateEnabled(Long id, Boolean enabled) {
      SysTablePrintTemplate tablePrintTemplate = this.tablePrintTemplateMapper.selectById(id);
      tablePrintTemplate.setEnabled(enabled);
      if (!enabled) {
         tablePrintTemplate.setIsDefault(Boolean.FALSE);
      }

      return this.tablePrintTemplateMapper.updateById(tablePrintTemplate) == 1;
   }

   @Override
   public Boolean delete(List<Long> ids) {
      return this.tablePrintTemplateMapper.deleteBatchIds(ids) == ids.size();
   }

   @Override
   public ListVO<SysTablePrintTemplate> listByType(String type) {
      List<SysTablePrintTemplate> templateList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(SysTablePrintTemplate.builder().type(type).enabled(true).build()));
      return new ListVO<>(templateList);
   }

   @Override
   public Boolean setDefault(Integer id, Boolean isDefault) {
      SysTablePrintTemplate tablePrintTemplate = this.tablePrintTemplateMapper.selectById(id);
      if (java.util.Objects.equals(tablePrintTemplate.getIsDefault(), isDefault)) {
         return Boolean.TRUE;
      }

      if (isDefault) {
         List<SysTablePrintTemplate> templates = this.tablePrintTemplateMapper.listByType(tablePrintTemplate.getType());
         templates.forEach(template -> {
            if (template.getIsDefault()) {
               template.setIsDefault(Boolean.FALSE);
               this.tablePrintTemplateMapper.updateById(template);
            }
         });
      }

      tablePrintTemplate.setIsDefault(isDefault);
      return this.tablePrintTemplateMapper.updateById(tablePrintTemplate) == 1;
   }

   @Override
   public ListVO<SysTablePrintTemplate> listByTypes(List<String> types) {
      return new ListVO<>(this.tablePrintTemplateMapper.listByTypes(types));
   }
}
