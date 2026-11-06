package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.UnitDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements UnitService {
   @Resource
   UnitMapper unitMapper;
   @Resource
   MeasureMapper metrologyMapper;

   @Override
   public PageVO<Unit> pageInfo(Integer page, Integer size, List<String> sort, String name, Integer type, Boolean enabled) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Unit> info = PageHelper.<Unit>startPage(page, size, s).doSelectPageInfo(() -> this.listInfo(name, type, enabled));
      List<Unit> list = info.getList();
      return new PageVO<>(list);
   }

   @Override
   public List<Unit> listInfo(String name, Integer type, Boolean enabled) {
      return this.unitMapper
         .selectList(
            ((Wrappers.<Unit>lambdaQuery().eq(enabled != null, Unit::getEnabled, enabled))
                  .eq(type != null, Unit::getType, type))
               .like(name != null, Unit::getName, name)
         );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateUnitStatus(Integer id, Boolean enabled) {
      Unit unit = this.unitMapper.selectById(id);
      Preconditions.checkArgument(unit != null, "修改失败,单位不存在");
      unit.setEnabled(enabled);
      unit.setUpdateTime(LocalDateTime.now());
      return this.unitMapper.updateById(unit) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addUnit(List<UnitDTOParam> dtoParams) {
      for (UnitDTOParam dtoParam : dtoParams) {
         Preconditions.checkArgument(
            dtoParams.stream().filter(d -> d.getName().equals(dtoParam.getName())).count() == 1L, "添加失败,当前[" + dtoParam.getName() + "]单位名称重复"
         );
         if (StrUtil.isNotBlank(dtoParam.getSymbol())) {
            List<String> list = dtoParams.stream().map(UnitDTOParam::getSymbol).collect(Collectors.toList());
            Preconditions.checkArgument(Collections.frequency(list, dtoParam.getSymbol()) == 1, "添加失败,当前[" + dtoParam.getSymbol() + "]单位符号重复");
         }

         List<String> list = dtoParams.stream().map(UnitDTOParam::getName).collect(Collectors.toList());
         Preconditions.checkArgument(!list.contains(dtoParam.getSymbol()), "当前单位符号与单位名称冲突,请核对后操作.");
         Integer integer = this.unitMapper.selectCount((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, dtoParam.getName()));
         Preconditions.checkArgument(integer <= 0, "单位名称[" + dtoParam.getName() + "]已存在,请核对后操作");
         Integer count = this.unitMapper.selectCount((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getSymbol, dtoParam.getSymbol()));
         Preconditions.checkArgument(count <= 0, "单位符号[" + dtoParam.getSymbol() + "]已存在,请核对后操作");
         Unit unit = BeanUtil.copy(dtoParam, Unit.class);
         unit.setBoolSystem(false);
         this.unitMapper.insert(unit);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      for (Long id : ids) {
         Unit unit = this.unitMapper.selectById(id);
         Preconditions.checkArgument(unit != null, "删除失败,单位不存在");
         Preconditions.checkArgument(!unit.getBoolSystem(), "当前单位为系统配置,禁止删除");
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(
               this.metrologyMapper
                  .selectList(
                     (Wrapper<Measure>)((Wrappers.<Measure>lambdaQuery().eq(Measure::getMeasureUnit, unit.getName())).or())
                        .eq(Measure::getAccountingUnit, unit.getName())
                  )
            ),
            "删除失败,单位存在配置"
         );
         this.unitMapper.deleteById(id);
      }

      return true;
   }
}
