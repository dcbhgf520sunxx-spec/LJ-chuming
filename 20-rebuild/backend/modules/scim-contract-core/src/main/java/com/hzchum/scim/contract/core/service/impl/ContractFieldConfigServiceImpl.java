package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import com.hzchum.scim.contract.core.api.service.ContractFieldConfigService;
import com.hzchum.scim.contract.core.mapper.ContractFieldConfigMapper;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ContractFieldConfigServiceImpl extends ServiceImpl<ContractFieldConfigMapper, ContractFieldConfig> implements ContractFieldConfigService {
   @Override
   public void checkField(List<Long> ids) {
      ids = ids.stream().filter(Objects::nonNull).collect(Collectors.toList());
      Preconditions.checkArgument(ids != null && !ids.isEmpty(), "请选择字段");
      List<ContractFieldConfig> contractFieldConfigs = this.baseMapper.selectBatchIds(ids);
      Preconditions.checkArgument(contractFieldConfigs.size() == ids.size(), "配置存在变化，请刷新页面重试");
   }
}
