package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAuxiliaryMaterial;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAuxiliaryMaterialDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAuxiliaryMaterialParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigAuxiliaryMaterialService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigAuxiliaryMaterialMapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigAuxiliaryMaterialServiceImpl
   extends ServiceImpl<MesQuotaConfigAuxiliaryMaterialMapper, MesQuotaConfigAuxiliaryMaterial>
   implements MesQuotaConfigAuxiliaryMaterialService {
   @Autowired
   private Validator validator;

   @Override
   public List<MesQuotaConfigAuxiliaryMaterialDTO> listInfo(MesQuotaConfigConditionQuery query) {
      return this.baseMapper.listInfo(query);
   }

   private void verifyParam(MesQuotaConfigAuxiliaryMaterialParam param, Class<?>... var2) {
      Set<ConstraintViolation<MesQuotaConfigAuxiliaryMaterialParam>> validate = this.validator.validate(param, var2);
      Preconditions.checkArgument(CollUtil.isEmpty(validate), validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      List<MesQuotaConfigAuxiliaryMaterial> list = this.list(
         (Wrapper<MesQuotaConfigAuxiliaryMaterial>)(new LambdaQueryWrapper<MesQuotaConfigAuxiliaryMaterial>()
               .ne(param.getId() != null, MesQuotaConfigAuxiliaryMaterial::getId, param.getId()))
            .eq(MesQuotaConfigAuxiliaryMaterial::getTypeName, param.getTypeName())
      );
      Preconditions.checkArgument(CollUtil.isEmpty(list), "类型重复");
   }

   private String getSerialNumber() {
      String prefix = "F";
      int num = this.baseMapper.getMaxSerialNumber(prefix);
      return prefix + String.format("%02d", num + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigAuxiliaryMaterialParam param) {
      this.verifyParam(param, Add.class);
      MesQuotaConfigAuxiliaryMaterial entity = BeanUtil.toBean(param, MesQuotaConfigAuxiliaryMaterial.class);
      entity.setSerialNumber(this.getSerialNumber());
      this.save(entity);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigAuxiliaryMaterialParam param) {
      this.verifyParam(param, Update.class);
      MesQuotaConfigAuxiliaryMaterial oldEntity = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      MesQuotaConfigAuxiliaryMaterial entity = BeanUtil.toBean(param, MesQuotaConfigAuxiliaryMaterial.class);
      this.updateById(entity);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesQuotaConfigAuxiliaryMaterial oldEntity = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      this.removeById(id);
      return true;
   }
}
