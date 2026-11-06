package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.NumberUtils;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.pojo.dto.NumberConfigDTOParam;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.mapper.NumberConfigMapper;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NumberConfigServiceImpl extends ServiceImpl<NumberConfigMapper, NumberConfig> implements NumberConfigService {
   @Override
   public ListVO listConfig() {
      Map<Integer, NumberConfig> numberConfigMap = this.baseMapper
         .selectList(null)
         .stream()
         .collect(Collectors.toMap(NumberConfig::getType, e -> (NumberConfig)e));
      return new ListVO(Arrays.stream(NumberTypeEnum.values()).map(e -> {
         NumberConfig config = numberConfigMap.get(e.getType());
         if (config == null) {
            config = new NumberConfig();
            config.setType(e.getType());
         }

         return config;
      }).collect(Collectors.toList()));
   }

   public NumberConfig getByType(Integer type) {
      return this.baseMapper.selectOne((Wrapper<NumberConfig>)new LambdaQueryWrapper<NumberConfig>().eq(NumberConfig::getType, type));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateConfig(ValidList<NumberConfigDTOParam> ros) {
      ros.forEach(
         ro -> {
            Preconditions.checkArgument(NumberTypeEnum.isExist(ro.getType()), "类型不存在");
            NumberConfig config = this.getByType(ro.getType());
            config.setNumber(ro.getNumber());
            config.setCode(ro.getCode().trim().toUpperCase());
            this.baseMapper.updateById(config);
            Preconditions.checkArgument(
               this.baseMapper.selectCount((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getCode, ro.getCode())) <= 1,
               "修改失败,[" + ro.getCode() + "]代号已存在"
            );
         }
      );
      return true;
   }

   @Override
   public String getNumber(NumberTypeEnum typeEnum, String contractNo, int count) {
      NumberConfig config = this.getByType(typeEnum.getType());
      Preconditions.checkArgument(config != null, "未配置" + typeEnum.getName() + "的编号配置");
      return contractNo == null
         ? config.getCode() + NumberUtils.getDigitsNumber(count + 1, config.getNumber())
         : contractNo + "-" + config.getCode() + NumberUtils.getDigitsNumber(count + 1, config.getNumber());
   }

   @Override
   public String getNumber(NumberTypeEnum typeEnum, int count) {
      NumberConfig config = this.getByType(typeEnum.getType());
      Preconditions.checkArgument(config != null, "未配置" + typeEnum.getName() + "的编号配置");
      return config.getCode() + "-" + DateTimeUtils.getCurrentDateOfYYMMDD() + "-" + NumberUtils.getDigitsNumber(count + 1, config.getNumber());
   }

   @Override
   public String getNumber(NumberTypeEnum typeEnum, int count, String dateFormat) {
      NumberConfig config = this.getByType(typeEnum.getType());
      Preconditions.checkArgument(config != null, "未配置" + typeEnum.getName() + "的编号配置");
      return config.getCode() + dateFormat + "-" + (count + 1);
   }
}
