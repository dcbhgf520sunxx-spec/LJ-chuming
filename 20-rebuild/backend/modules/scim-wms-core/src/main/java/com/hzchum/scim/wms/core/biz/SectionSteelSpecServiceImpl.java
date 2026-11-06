package com.hzchum.scim.wms.core.biz;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.wms.core.api.biz.SectionSteelSpecService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.DownloadSectionSteelDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecStandardDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelSpecDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.StandardDetailDTOParam;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecStandardDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SectionSteelSpecServiceImpl extends ServiceImpl<SectionSteelSpecMapper, SectionSteelSpec> implements SectionSteelSpecService {
   @Resource
   SectionSteelSpecMapper sectionSteelSpecMapper;
   @Resource
   SectionSteelConfigMapper sectionSteelConfigMapper;
   @Resource
   SectionSteelSpecStandardDetailMapper sectionSteelSpecStandardDetailMapper;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   ApplyPurchaseDetailService applyPurchaseDetailService;
   @Resource
   PurchaseOrderDetailService purchaseOrderDetailService;

   @Override
   public PageVO<SectionSteelSpecDetailDTO> listByClassificationId(Long classificationId, String specification) {
      return new PageVO<>(this.sectionSteelSpecMapper.getByConfigId(classificationId, specification));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean add(Long sectionSteelId, List<SectionSteelSpecDTOParam> dtoParams) {
      SectionSteelConfig sectionSteelConfig = this.sectionSteelConfigMapper.selectById(sectionSteelId);
      Preconditions.checkArgument(sectionSteelConfig != null, "当前型材不存在");

      for (SectionSteelSpecDTOParam dtoParam : dtoParams) {
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(dtoParam.getStandard()), "请设置国标理论重量");
         Preconditions.checkArgument(dtoParam.getSpecification().length() <= 50, "规格长度不能大于50");
         Preconditions.checkArgument(
            this.sectionSteelSpecMapper
                  .selectOne(
                     (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getSpecification, dtoParam.getSpecification()))
                        .eq(SectionSteelSpec::getClassificationId, sectionSteelConfig.getClassificationId())
                  )
               == null,
            "添加失败,当前[" + dtoParam.getSpecification() + "]规格已存在."
         );
         SectionSteelSpec sectionSteelSpec = SectionSteelSpec.builder()
            .sectionSteelId(sectionSteelId)
            .classificationId(sectionSteelConfig.getClassificationId())
            .specification(dtoParam.getSpecification())
            .build();
         this.sectionSteelSpecMapper.insert(sectionSteelSpec);
         if (CollectionUtil.isNotEmpty(dtoParam.getStandard())) {
            Integer maxCode = this.sectionSteelSpecStandardDetailMapper.getMaxCode();

            for (StandardDetailDTOParam standard : dtoParam.getStandard()) {
               Preconditions.checkArgument(standard.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "国标理论重量必须大于零");
               maxCode = maxCode + 1;
               SectionSteelSpecStandardDetail standardDetail = SectionSteelSpecStandardDetail.builder()
                  .specId(sectionSteelSpec.getId())
                  .sectionSteelId(sectionSteelId)
                  .standardId(standard.getId())
                  .code(maxCode)
                  .unitNet(standard.getUnitNet())
                  .build();
               this.sectionSteelSpecStandardDetailMapper.insert(standardDetail);
            }
         }
      }

      return true;
   }

   @Override
   public Boolean updateStandard(SectionSteelSpecDTOParam param) {
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(param.getStandard()), "规格修改请设置国标理论重量");
      SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecMapper.selectById(param.getId());
      Preconditions.checkArgument(sectionSteelSpec != null, "当前型材规格不存在");
      if (!param.getSpecification().equals(sectionSteelSpec.getSpecification())) {
         Preconditions.checkArgument(
            this.applyPurchaseDetailService
                  .count(
                     (Wrapper<ApplyPurchaseDetail>)(Wrappers.<ApplyPurchaseDetail>lambdaQuery()
                           .eq(ApplyPurchaseDetail::getBasicClass, BasicClassEnum.SECTION_STEEL.getType()))
                        .likeRight(ApplyPurchaseDetail::getSpecification, sectionSteelSpec.getSpecification() + " * ")
                  )
               <= 0,
            "修改失败,当前型材规格[" + sectionSteelSpec.getSpecification() + "]已被申购使用."
         );
         Preconditions.checkArgument(
            this.purchaseOrderDetailService
                  .count(
                     (Wrapper<PurchaseOrderDetail>)(Wrappers.<PurchaseOrderDetail>lambdaQuery()
                           .eq(PurchaseOrderDetail::getBasicClass, BasicClassEnum.SECTION_STEEL.getType()))
                        .likeRight(PurchaseOrderDetail::getSpecification, sectionSteelSpec.getSpecification() + " * ")
                  )
               <= 0,
            "修改失败,当前型材规格[" + sectionSteelSpec.getSpecification() + "]已被自合营采购使用."
         );
         Preconditions.checkArgument(
            this.inboundDetailMapper
                  .selectCount(
                     (Wrapper<InboundDetail>)(Wrappers.<InboundDetail>lambdaQuery()
                           .eq(InboundDetail::getBasicClass, BasicClassEnum.SECTION_STEEL.getType()))
                        .likeRight(InboundDetail::getSpecification, sectionSteelSpec.getSpecification() + " * ")
                  )
               <= 0,
            "修改失败,当前型材规格[" + sectionSteelSpec.getSpecification() + "]已被入库使用."
         );
         Preconditions.checkArgument(
            this.sectionSteelSpecMapper
                  .selectOne(
                     (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getSpecification, param.getSpecification()))
                        .eq(SectionSteelSpec::getClassificationId, sectionSteelSpec.getClassificationId())
                  )
               == null,
            "修改失败,当前[" + param.getSpecification() + "]规格已存在."
         );
         sectionSteelSpec.setSpecification(param.getSpecification());
         this.sectionSteelSpecMapper.updateById(sectionSteelSpec);
      }

      this.sectionSteelSpecStandardDetailMapper
         .delete(
            (Wrapper<SectionSteelSpecStandardDetail>)(Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                  .eq(SectionSteelSpecStandardDetail::getSectionSteelId, param.getSectionSteelId()))
               .eq(SectionSteelSpecStandardDetail::getSpecId, param.getId())
         );

      for (StandardDetailDTOParam standardDetailDTOParam : param.getStandard()) {
         Integer maxCode = this.sectionSteelSpecStandardDetailMapper.getMaxCode() + 1;
         this.sectionSteelSpecStandardDetailMapper
            .insert(
               SectionSteelSpecStandardDetail.builder()
                  .specId(param.getId())
                  .standardId(standardDetailDTOParam.getId())
                  .code(maxCode)
                  .sectionSteelId(param.getSectionSteelId())
                  .unitNet(standardDetailDTOParam.getUnitNet())
                  .build()
            );
      }

      return true;
   }

   @Override
   public SectionSteelSpecDTO getWeightByClassifyId(Long id, String spec) {
      SectionSteelConfig sectionSteelConfig = this.sectionSteelConfigMapper
         .selectOne((Wrapper<SectionSteelConfig>)Wrappers.<SectionSteelConfig>lambdaQuery().eq(SectionSteelConfig::getClassificationId, id));
      SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecMapper
         .selectOne(
            (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getClassificationId, id))
               .eq(SectionSteelSpec::getSpecification, spec)
         );
      Preconditions.checkArgument(sectionSteelSpec != null, "型材库中没有找到规格为[" + spec + "]的信息");
      SectionSteelSpecStandardDetail standardDetail = this.sectionSteelSpecStandardDetailMapper
         .selectOne(
            (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                     .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelConfig.getId()))
                  .eq(SectionSteelSpecStandardDetail::getStandardId, sectionSteelConfig.getStandardId()))
               .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId())
         );
      SectionSteelSpecStandardDetailDTO detailDTO = SectionSteelSpecStandardDetailDTO.builder()
         .unitNet(standardDetail.getUnitNet())
         .id(standardDetail.getId())
         .build();
      return SectionSteelSpecDTO.builder()
         .id(sectionSteelSpec.getId())
         .sectionSteelId(sectionSteelConfig.getId())
         .specification(sectionSteelSpec.getSpecification())
         .detail(detailDTO)
         .build();
   }

   @Override
   public Boolean delete(List<Long> ids) {
      for (Long id : ids) {
         SectionSteelSpec spec = this.sectionSteelSpecMapper.selectById(id);
         Preconditions.checkArgument(spec != null, "对应规格不存在");
         Preconditions.checkArgument(
            this.applyPurchaseDetailService
                  .count((Wrapper<ApplyPurchaseDetail>)Wrappers.<ApplyPurchaseDetail>lambdaQuery().eq(ApplyPurchaseDetail::getSectionSteelSpecId, spec.getId()))
               == 0,
            "删除失败,当前型材规格存在申购信息,"
         );
         Preconditions.checkArgument(
            this.purchaseOrderDetailService
                  .count((Wrapper<PurchaseOrderDetail>)Wrappers.<PurchaseOrderDetail>lambdaQuery().eq(PurchaseOrderDetail::getSectionSteelSpecId, spec.getId()))
               == 0,
            "删除失败,当前型材规格存在自合营采购信息,"
         );
         Preconditions.checkArgument(
            this.inboundDetailMapper.selectCount((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getSectionSteelSpecId, spec.getId())) == 0,
            "删除失败,当前型材规格存在入库信息,"
         );
         this.sectionSteelSpecStandardDetailMapper
            .delete(
               (Wrapper<SectionSteelSpecStandardDetail>)(Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                     .eq(SectionSteelSpecStandardDetail::getSectionSteelId, spec.getSectionSteelId()))
                  .eq(SectionSteelSpecStandardDetail::getSpecId, spec.getId())
            );
         this.sectionSteelSpecMapper.deleteById(spec);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean batchSave(Long sectionSteelId, List<SectionSteelSpecDTOParam> params) {
      SectionSteelConfig sectionSteelConfig = this.sectionSteelConfigMapper.selectById(sectionSteelId);
      Preconditions.checkArgument(sectionSteelConfig != null, "当前型材不存在");

      for (SectionSteelSpecDTOParam param : params) {
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(param.getStandard()), "请设置国标理论重量");
         Integer maxCode = this.sectionSteelSpecStandardDetailMapper.getMaxCode();
         SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecMapper
            .selectOne(
               (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getSpecification, param.getSpecification()))
                  .eq(SectionSteelSpec::getClassificationId, sectionSteelConfig.getClassificationId())
            );
         if (sectionSteelSpec == null) {
            SectionSteelSpec spec = SectionSteelSpec.builder()
               .sectionSteelId(sectionSteelId)
               .classificationId(sectionSteelConfig.getClassificationId())
               .specification(param.getSpecification())
               .build();
            this.sectionSteelSpecMapper.insert(spec);
            if (CollectionUtil.isNotEmpty(param.getStandard())) {
               for (StandardDetailDTOParam standardDetailDTOParam : param.getStandard()) {
                  Preconditions.checkArgument(standardDetailDTOParam.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "国标理论重量必须大于零");
                  maxCode = maxCode + 1;
                  SectionSteelSpecStandardDetail build = SectionSteelSpecStandardDetail.builder()
                     .specId(spec.getId())
                     .sectionSteelId(sectionSteelId)
                     .standardId(standardDetailDTOParam.getId())
                     .code(maxCode)
                     .unitNet(standardDetailDTOParam.getUnitNet())
                     .build();
                  this.sectionSteelSpecStandardDetailMapper.insert(build);
               }
            }
         } else if (CollectionUtil.isNotEmpty(param.getStandard())) {
            for (StandardDetailDTOParam standardDetailDTOParam : param.getStandard()) {
               Preconditions.checkArgument(standardDetailDTOParam.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "国标理论重量必须大于零");
               SectionSteelSpecStandardDetail sectionSteelSpecStandardDetail = this.sectionSteelSpecStandardDetailMapper
                  .selectOne(
                     (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                              .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelConfig.getId()))
                           .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId()))
                        .eq(SectionSteelSpecStandardDetail::getStandardId, standardDetailDTOParam.getId())
                  );
               Preconditions.checkArgument(sectionSteelSpecStandardDetail == null, "型材已存在国标重量设置");
               maxCode = maxCode + 1;
               SectionSteelSpecStandardDetail build = SectionSteelSpecStandardDetail.builder()
                  .specId(sectionSteelSpec.getId())
                  .sectionSteelId(sectionSteelConfig.getId())
                  .standardId(standardDetailDTOParam.getId())
                  .code(maxCode)
                  .unitNet(standardDetailDTOParam.getUnitNet())
                  .build();
               this.sectionSteelSpecStandardDetailMapper.insert(build);
            }
         }
      }

      return null;
   }

   @Override
   public PrintVO<List<DownloadSectionSteelDO>> download(Long sectionSteelId, Long standardId) {
      List<DownloadSectionSteelDO> download = this.sectionSteelSpecStandardDetailMapper.download(sectionSteelId, standardId);
      PrintVO<List<DownloadSectionSteelDO>> printVO = new PrintVO<>();
      printVO.setTable(download);
      return printVO;
   }

   @Override
   public List<SectionSteelSpecStandardDetailDTO> getStandardDetail(Long classificationId, String specification) {
      SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecMapper
         .selectOne(
            (Wrapper<SectionSteelSpec>)(new LambdaQueryWrapper<SectionSteelSpec>().eq(SectionSteelSpec::getClassificationId, classificationId))
               .eq(SectionSteelSpec::getSpecification, specification)
         );
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(sectionSteelSpec), "型材规格不存在");
      List<SectionSteelSpecStandardDetailDTO> sectionSteelSpecStandardDetailDTOS = this.sectionSteelSpecStandardDetailMapper
         .selectDetailBySpecId(sectionSteelSpec.getId());
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(sectionSteelSpecStandardDetailDTOS), "型材国标规格重量配置获取失败");
      SectionSteelConfig sectionSteelConfig = this.sectionSteelConfigMapper
         .selectOne((Wrapper<SectionSteelConfig>)new LambdaQueryWrapper<SectionSteelConfig>().eq(SectionSteelConfig::getClassificationId, sectionSteelSpec.getClassificationId()));
      boolean boolDefault = true;

      for (SectionSteelSpecStandardDetailDTO sectionSteelSpecStandardDetailDTO : sectionSteelSpecStandardDetailDTOS) {
         boolDefault = sectionSteelSpecStandardDetailDTO.getId().equals(sectionSteelConfig.getStandardId());
         sectionSteelSpecStandardDetailDTO.setBoolDefault(boolDefault);
      }

      return sectionSteelSpecStandardDetailDTOS;
   }

   @Override
   public Boolean updateStatus(List<Long> ids, Boolean status) {
      return this.sectionSteelSpecMapper
            .update(
               null,
               (Wrapper<SectionSteelSpec>)(new LambdaUpdateWrapper<SectionSteelSpec>().in(SectionSteelSpec::getId, ids))
                  .set(SectionSteelSpec::getStatus, status)
            )
         > 0;
   }
}
