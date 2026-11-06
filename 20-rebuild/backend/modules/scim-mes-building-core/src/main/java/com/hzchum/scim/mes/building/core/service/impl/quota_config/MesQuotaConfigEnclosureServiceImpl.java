package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigEnclosure;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigEnclosureParam;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigEnclosureService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigEnclosureMapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigEnclosureServiceImpl
   extends ServiceImpl<MesQuotaConfigEnclosureMapper, MesQuotaConfigEnclosure>
   implements MesQuotaConfigEnclosureService {
   @Autowired
   private Validator validator;

   @Override
   public List<MesQuotaConfigEnclosureDTO> listInfo(MesQuotaConfigConditionQuery query) {
      return this.baseMapper.listInfo(query);
   }

   private void verifyParam(MesQuotaConfigEnclosureParam param, Class<?>... var2) {
      Set<ConstraintViolation<MesQuotaConfigEnclosureParam>> validate = this.validator.validate(param, var2);
      Preconditions.checkArgument(CollUtil.isEmpty(validate), validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      List<MesQuotaConfigEnclosure> list = this.list(
         (Wrapper<MesQuotaConfigEnclosure>)(new LambdaQueryWrapper<MesQuotaConfigEnclosure>()
               .ne(param.getId() != null, MesQuotaConfigEnclosure::getId, param.getId()))
            .eq(MesQuotaConfigEnclosure::getEnclosureTypeDictionaryId, param.getEnclosureTypeDictionaryId())
      );
      Preconditions.checkArgument(CollUtil.isEmpty(list), "围护类型重复");
   }

   private String getSerialNumber() {
      String prefix = "W";
      int num = this.baseMapper.getMaxSerialNumber(prefix);
      return prefix + String.format("%02d", num + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigEnclosureParam param) {
      this.verifyParam(param, Add.class);
      MesQuotaConfigEnclosure entity = BeanUtil.toBean(param, MesQuotaConfigEnclosure.class);
      entity.setSerialNumber(this.getSerialNumber());
      this.save(entity);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigEnclosureParam param) {
      this.verifyParam(param, Update.class);
      MesQuotaConfigEnclosure oldEntity = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      MesQuotaConfigEnclosure entity = BeanUtil.toBean(param, MesQuotaConfigEnclosure.class);
      entity.setSerialNumber(this.getSerialNumber());
      this.updateById(entity);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesQuotaConfigEnclosure oldEntity = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      this.removeById(id);
      return true;
   }
}
