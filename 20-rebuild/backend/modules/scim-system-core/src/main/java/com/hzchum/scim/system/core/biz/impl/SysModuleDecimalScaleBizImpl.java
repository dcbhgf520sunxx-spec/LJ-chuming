package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.biz.SysModuleDecimalScaleBiz;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.SysModuleDecimalScale;
import com.hzchum.scim.system.core.api.pojo.dto.ModuleDecimalScaleSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysModuleDecimalScaleDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysModuleDecimalScaleDtoParam;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.SysModuleDecimalScaleService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysModuleDecimalScaleBizImpl implements SysModuleDecimalScaleBiz {
   private static final Logger log = LoggerFactory.getLogger(SysModuleDecimalScaleBizImpl.class);
   private final SysModuleDecimalScaleService moduleDecimalScaleService;
   private final MenuService menuService;
   private final RedisUtils redisUtils;
   private static final String DECIMAL_SCALE = "decimal_scale";

   @Override
   public List<ModuleDecimalScaleSimpleDTO> listModuleDecimalScale() {
      Object ob = this.redisUtils.get("decimal_scale");
      List<ModuleDecimalScaleSimpleDTO> simpleDTOList;
      if (ob == null) {
         Map<Long, String> menuMap = this.menuService
            .list(Wrappers.lambdaQuery(Menu.builder().pid(11111L).build()))
            .stream()
            .collect(Collectors.toMap(Menu::getId, Menu::getName));
         simpleDTOList = this.moduleDecimalScaleService.list().stream().filter(s -> menuMap.containsKey(s.getMenuId())).map(s -> {
            ModuleDecimalScaleSimpleDTO simpleDTO = BeanUtil.copy(s, ModuleDecimalScaleSimpleDTO.class);
            simpleDTO.setMenuName(menuMap.get(s.getMenuId()));
            return simpleDTO;
         }).collect(Collectors.toList());
         this.redisUtils.set("decimal_scale", simpleDTOList);
      } else {
         List<ModuleDecimalScaleSimpleDTO> moduleDecimalScaleSimpleDTOS = Convert.toList(ModuleDecimalScaleSimpleDTO.class, ob);
         simpleDTOList = (List<ModuleDecimalScaleSimpleDTO>)ob;
      }

      return simpleDTOList;
   }

   @Override
   public List<SysModuleDecimalScaleDTO> list() {
      List<SysModuleDecimalScale> list = this.moduleDecimalScaleService.list();
      List<SysModuleDecimalScaleDTO> dtoList = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(list)) {
         Map<Long, NameInfo> nameInfoMap = this.menuService.listModuleMenu(null).stream().collect(Collectors.toMap(NameInfo::getId, Function.identity()));
         dtoList = list.stream().filter(s -> nameInfoMap.containsKey(s.getMenuId())).map(s -> {
            SysModuleDecimalScaleDTO dto = BeanUtil.copy(s, SysModuleDecimalScaleDTO.class);
            dto.setMenuName(nameInfoMap.get(s.getMenuId()).getName());
            return dto;
         }).collect(Collectors.toList());
      }

      return dtoList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean save(List<SysModuleDecimalScaleDtoParam> paramList) {
      paramList.forEach(
         param -> {
            Menu menu = this.menuService.getById(param.getMenuId());
            Preconditions.checkArgument(menu != null && menu.getPid().equals(11111L), "模块菜单不存在!");
            SysModuleDecimalScale moduleDecimalScale = this.moduleDecimalScaleService
               .getOne(Wrappers.lambdaQuery(SysModuleDecimalScale.builder().menuId(param.getMenuId()).build()));
            if (moduleDecimalScale != null) {
               moduleDecimalScale.setScale(param.getScale());
               this.moduleDecimalScaleService.updateById(moduleDecimalScale);
            } else {
               moduleDecimalScale = SysModuleDecimalScale.builder().menuId(param.getMenuId()).scale(param.getScale()).build();
               this.moduleDecimalScaleService.save(moduleDecimalScale);
            }
         }
      );
      this.redisUtils.del("decimal_scale");
      return true;
   }

   @Override
   public Boolean remove(List<Long> ids) {
      ids.forEach(id -> {
         SysModuleDecimalScale moduleDecimalScale = this.moduleDecimalScaleService.getById(id);
         Preconditions.checkArgument(moduleDecimalScale != null, "配置不存在!");
         this.moduleDecimalScaleService.removeById(id);
      });
      this.redisUtils.del("decimal_scale");
      return true;
   }

   public SysModuleDecimalScaleBizImpl(final SysModuleDecimalScaleService moduleDecimalScaleService, final MenuService menuService, final RedisUtils redisUtils) {
      this.moduleDecimalScaleService = moduleDecimalScaleService;
      this.menuService = menuService;
      this.redisUtils = redisUtils;
   }
}
