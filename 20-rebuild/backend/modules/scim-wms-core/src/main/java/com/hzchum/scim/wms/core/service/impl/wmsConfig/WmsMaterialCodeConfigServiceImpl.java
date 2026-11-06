package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WmsMaterialCodeConfigDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialCodeConfigService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WmsMaterialCodeConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsMaterialCodeConfigServiceImpl extends ServiceImpl<WmsMaterialCodeConfigMapper, WmsMaterialCodeConfig> implements WmsMaterialCodeConfigService {
   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveMaterialCodeConfig(List<WmsMaterialCodeConfigDTOParam> params) {
      for (WmsMaterialCodeConfigDTOParam param : params) {
         List<WmsMaterialCodeConfig> wmsMaterialCodeConfigs = this.baseMapper
            .selectList(
               (Wrapper<WmsMaterialCodeConfig>)(new LambdaQueryWrapper<WmsMaterialCodeConfig>()
                     .eq(WmsMaterialCodeConfig::getMaterialSnNew, param.getMaterialSnNew()))
                  .ne(WmsMaterialCodeConfig::getClassifyId, param.getClassifyId())
            );
         if (CollectionUtil.isNotEmpty(wmsMaterialCodeConfigs)) {
            Preconditions.checkArgument(
               false, "新增编码失败,[" + wmsMaterialCodeConfigs.get(0).getMaterialSnNew() + "]已在[" + wmsMaterialCodeConfigs.get(0).getClassifyName() + "]中存在"
            );
         }

         List<WmsMaterialCodeConfig> wmsMaterialCodeConfigs1 = this.baseMapper
            .selectList(
               (Wrapper<WmsMaterialCodeConfig>)(new LambdaQueryWrapper<WmsMaterialCodeConfig>()
                     .eq(WmsMaterialCodeConfig::getSpecificationNew, param.getSpecificationNew()))
                  .eq(WmsMaterialCodeConfig::getClassifyId, param.getClassifyId())
            );
         if (CollectionUtil.isNotEmpty(wmsMaterialCodeConfigs1)) {
            Preconditions.checkArgument(
               false, "新增编码失败", wmsMaterialCodeConfigs1.get(0).getClassifyName() + wmsMaterialCodeConfigs1.get(0).getSpecificationNew() + "已经配置了这个第三方编码"
            );
         }

         this.baseMapper
            .insert(
               WmsMaterialCodeConfig.builder()
                  .classifyId(param.getClassifyId())
                  .classifyName(param.getClassifyName())
                  .basicClass(param.getBasicClass())
                  .materialSn(param.getMaterialSn())
                  .materialSnNew(param.getMaterialSnNew())
                  .thickness(param.getThickness())
                  .specificationNew(param.getSpecificationNew())
                  .specification(param.getSpecification())
                  .applicantId(UserUtil.getCurrentUserId())
                  .applicantName(UserUtil.getCurrentName())
                  .editorId(UserUtil.getCurrentUserId())
                  .editorName(UserUtil.getCurrentName())
                  .build()
            );
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateMaterialCodeConfig(List<WmsMaterialCodeConfigDTOParam> params) {
      for (WmsMaterialCodeConfigDTOParam param : params) {
         WmsMaterialCodeConfig wmsMaterialCodeConfig = this.baseMapper.selectById(param.getId());
         List<WmsMaterialCodeConfig> wmsMaterialCodeConfigs = this.baseMapper
            .selectList(
               (Wrapper<WmsMaterialCodeConfig>)(new LambdaQueryWrapper<WmsMaterialCodeConfig>()
                     .eq(WmsMaterialCodeConfig::getMaterialSnNew, wmsMaterialCodeConfig.getMaterialSnNew()))
                  .ne(WmsMaterialCodeConfig::getClassifyId, wmsMaterialCodeConfig.getClassifyId())
            );
         if (CollectionUtil.isNotEmpty(wmsMaterialCodeConfigs)) {
            Preconditions.checkArgument(
               false, "修改编码失败,[" + wmsMaterialCodeConfigs.get(0).getMaterialSnNew() + "]已在[" + wmsMaterialCodeConfigs.get(0).getClassifyName() + "]中存在"
            );
         }

         List<WmsMaterialCodeConfig> wmsMaterialCodeConfigs1 = this.baseMapper
            .selectList(
               (Wrapper<WmsMaterialCodeConfig>)((new LambdaQueryWrapper<WmsMaterialCodeConfig>()
                        .eq(WmsMaterialCodeConfig::getSpecificationNew, wmsMaterialCodeConfig.getSpecificationNew()))
                     .eq(WmsMaterialCodeConfig::getMaterialSnNew, param.getMaterialSnNew()))
                  .eq(WmsMaterialCodeConfig::getClassifyId, wmsMaterialCodeConfig.getClassifyId())
            );
         if (CollectionUtil.isNotEmpty(wmsMaterialCodeConfigs1)) {
            Preconditions.checkArgument(
               false, "修改编码失败", wmsMaterialCodeConfigs1.get(0).getClassifyName() + wmsMaterialCodeConfigs1.get(0).getSpecificationNew() + "已经配置了这个第三方编码"
            );
         }

         this.baseMapper
            .updateById(
               WmsMaterialCodeConfig.builder()
                  .id(param.getId())
                  .materialSnNew(param.getMaterialSnNew())
                  .editorId(UserUtil.getCurrentUserId())
                  .editorName(UserUtil.getCurrentName())
                  .build()
            );
      }

      return true;
   }

   @Override
   public PageVO<WmsMaterialCodeConfig> pageInfo(WmsMaterialCodeConfigDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WmsMaterialCodeConfig> wmsMaterialCodeConfigs = this.baseMapper
         .selectList(
            ((((new LambdaQueryWrapper<WmsMaterialCodeConfig>()
                           .eq(ObjectUtil.isNotEmpty(dtoParam.getBasicClass()), WmsMaterialCodeConfig::getBasicClass, dtoParam.getBasicClass()))
                        .eq(ObjectUtil.isNotEmpty(dtoParam.getClassifyId()), WmsMaterialCodeConfig::getClassifyId, dtoParam.getClassifyId()))
                     .like(StrUtil.isNotEmpty(dtoParam.getClassifyName()), WmsMaterialCodeConfig::getClassifyName, dtoParam.getClassifyName()))
                  .like(StrUtil.isNotEmpty(dtoParam.getSpecificationNew()), WmsMaterialCodeConfig::getSpecification, dtoParam.getSpecificationNew()))
               .like(StrUtil.isNotEmpty(dtoParam.getMaterialSnNew()), WmsMaterialCodeConfig::getMaterialSnNew, dtoParam.getMaterialSnNew())
         );
      return new PageVO<>(wmsMaterialCodeConfigs);
   }
}
