package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Specification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SpecificationDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SpecificationDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SpecificationDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SpecificationDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SpecificationDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SpecificationDetailsMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SpecificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpecificationServiceImpl extends ServiceImpl<SpecificationMapper, Specification> implements SpecificationService {
   @Resource
   SpecificationMapper specificationMapper;
   @Resource
   SpecificationDetailsMapper specificationDetailsMapper;
   @Resource
   private ClassificationMapper classificationMapper;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   ApplyPurchaseDetailService applyPurchaseDetailService;
   @Resource
   PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;

   @Override
   public PageVO<SpecificationDTO> getByClassificationId(Long classificationId) {
      List<SpecificationDTO> specificationDTOS = this.specificationMapper.selectBySubjectId(classificationId);
      return new PageVO<>(specificationDTOS);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean batchSave(SpecificationDTOParam specificationDTOParam) {
      Classification classification = this.classificationMapper.selectById(specificationDTOParam.getClassificationId());
      Preconditions.checkArgument(classification != null, "规格配置失败，科目不存在");
      Preconditions.checkArgument(BasicClassEnum.checkMaterialByType(classification.getBasicClass()), "非材料科目禁止添加规格");
      Preconditions.checkArgument(classification.getBoolLastEnum(), "规格配置失败，不能对非末级科目设置规格");
      Specification specifications = this.specificationMapper
         .selectOne(
            (Wrapper<Specification>)(Wrappers.<Specification>lambdaQuery().eq(Specification::getClassificationId, classification.getId()))
               .eq(Specification::getName, specificationDTOParam.getName())
         );
      Preconditions.checkArgument(specifications == null, "规格配置失败，存在相同名称的规格配置");
      Preconditions.checkArgument(
         this.applyPurchaseDetailService
               .count(
                  (Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getClassifyId, specificationDTOParam.getClassificationId())
               )
            == 0,
         "该材料已存在于申购单明细中，新增规格配置失败"
      );
      Preconditions.checkArgument(
         this.purchaseOrderDetailService
               .count(
                  (Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getClassifyId, specificationDTOParam.getClassificationId())
               )
            == 0,
         "该材料已存在于采购单明细中，新增规格配置失败"
      );
      Preconditions.checkArgument(
         this.inboundDetailMapper
               .selectCount((Wrapper<InboundDetail>)new LambdaQueryWrapper<InboundDetail>().eq(InboundDetail::getClassifyId, specificationDTOParam.getClassificationId()))
            == 0,
         "该材料已存在于入库单明细中，新增规格配置失败"
      );
      Integer maxSort = this.specificationMapper.getMaxSort(specificationDTOParam.getClassificationId());
      Specification specification = Specification.builder().build();
      specification.setName(specificationDTOParam.getName());
      specification.setSort(maxSort + 1);
      specification.setClassificationId(specificationDTOParam.getClassificationId());
      specification.setBoolWeightedAverage(specificationDTOParam.getBoolWeightedAverage());
      this.specificationMapper.insert(specification);
      int sort = 0;
      Long specificationId = specification.getId();
      List<SpecificationDetailDTOParam> details = specificationDTOParam.getList();
      if (CollectionUtils.isNotEmpty(details)) {
         for (SpecificationDetailDTOParam detail : details) {
            this.checkDetail(details, detail);
            List<SpecificationDetail> list = this.specificationDetailsMapper
               .selectList((Wrapper<SpecificationDetail>)Wrappers.<SpecificationDetail>lambdaQuery().eq(SpecificationDetail::getSpecificationId, specification.getId()))
               .stream()
               .filter(
                  specificationDetailx -> specificationDetailx.getCode().equals(detail.getCode()) || specificationDetailx.getValue().equals(detail.getValue())
               )
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtil.isEmpty(list), "操作失败,当前规格编号或规格重复");
            SpecificationDetail specificationDetail = BeanUtil.copy(detail, SpecificationDetail.class);
            Preconditions.checkArgument(!detail.getValue().contains(" * "), "规格中不能包含[ * ]");
            specificationDetail.setSpecificationId(specificationId);
            specificationDetail.setSort(++sort);
            specificationDetail.setBoolUsed(false);
            this.specificationDetailsMapper.insert(specificationDetail);
         }
      }

      return true;
   }

   private void checkDetail(List<SpecificationDetailDTOParam> details, SpecificationDetailDTOParam detail) {
      Preconditions.checkArgument(details.stream().filter(d -> d.getCode().equals(detail.getCode())).count() == 1L, "操作失败,当前[" + detail.getCode() + "]编号重复");
      Preconditions.checkArgument(details.stream().filter(d -> d.getValue().equals(detail.getValue())).count() == 1L, "操作失败,当前[" + detail.getValue() + "]规格重复");
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteByIds(List<Long> ids) {
      for (Long id : ids) {
         Specification specification = this.specificationMapper.selectById(id);
         Preconditions.checkArgument(specification != null, "规格配置不存在");

         for (SpecificationDetail detail : this.specificationDetailsMapper
            .selectList((Wrapper<SpecificationDetail>)Wrappers.<SpecificationDetail>lambdaQuery().eq(SpecificationDetail::getSpecificationId, id))) {
            Preconditions.checkArgument(
               this.applyPurchaseDetailService
                     .count(
                        (Wrapper<ApplyPurchaseDetail>)(Wrappers.<ApplyPurchaseDetail>lambdaQuery()
                              .eq(ApplyPurchaseDetail::getClassifyId, specification.getClassificationId()))
                           .last("and find_in_set(" + detail.getId() + ",specification_ids)")
                     )
                  == 0,
               "删除失败,当前规格已被申购使用"
            );
            Preconditions.checkArgument(
               this.purchaseOrderDetailService
                     .count(
                        (Wrapper<PurchaseOrderDetail>)(Wrappers.<PurchaseOrderDetail>lambdaQuery()
                              .eq(PurchaseOrderDetail::getClassifyId, specification.getClassificationId()))
                           .last("and find_in_set(" + detail.getId() + ",specification_ids)")
                     )
                  == 0,
               "删除失败,当前规格已被自合营采购使用"
            );
            Preconditions.checkArgument(
               this.inboundDetailMapper
                     .selectCount(
                        (Wrapper<InboundDetail>)(Wrappers.<InboundDetail>lambdaQuery()
                              .eq(InboundDetail::getClassifyId, specification.getClassificationId()))
                           .last("and find_in_set(" + detail.getId() + ",specification_ids)")
                     )
                  == 0,
               "删除失败,当前规格已被入库使用"
            );
         }

         this.specificationDetailsMapper.delete((Wrapper<SpecificationDetail>)Wrappers.<SpecificationDetail>lambdaQuery().eq(SpecificationDetail::getSpecificationId, id));
         this.specificationMapper.deleteById(id);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateSpecification(SpecificationDTOParam specificationDTOParam) {
      Specification specification = this.specificationMapper.selectById(specificationDTOParam.getId());
      Preconditions.checkArgument(specification != null, "当前规格信息不存在");
      List<Specification> specifications = this.specificationMapper
         .selectList(
            (Wrapper<Specification>)(Wrappers.<Specification>lambdaQuery()
                  .eq(Specification::getClassificationId, specificationDTOParam.getClassificationId()))
               .eq(Specification::getName, specificationDTOParam.getName())
         );
      Preconditions.checkArgument(CollectionUtil.isEmpty(specifications) || specifications.size() == 1, "当前[" + specificationDTOParam.getName() + "]规格名称已存在");
      if (!specification.getBoolWeightedAverage().equals(specificationDTOParam.getBoolWeightedAverage())) {
         List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWeightedAveragePriceMapper
            .selectList(
               (Wrapper<MonthWeightedAveragePrice>)new LambdaQueryWrapper<MonthWeightedAveragePrice>().eq(MonthWeightedAveragePrice::getClassifyId, specification.getClassificationId())
            );
         Preconditions.checkArgument(CollectionUtil.isEmpty(monthWeightedAveragePriceList), "当前规格已使用,不允许修改加权平均价类型");
      }

      BeanUtils.copyProperties(specificationDTOParam, specification);
      specification.setBoolWeightedAverage(specificationDTOParam.getBoolWeightedAverage());
      specification.setUpdateTime(LocalDateTime.now());
      this.specificationMapper.updateById(specification);
      Integer maxSort = this.specificationDetailsMapper.getMaxSort(specification.getId());
      List<Long> detailIds = this.specificationDetailsMapper.getBySpecificationId(specification.getId());
      List<Long> applyPurchaseIds = new ArrayList<>();
      List<Long> scmLumpSumSystemPurchaseOrderIds = new ArrayList<>();
      List<Long> purchaseOrderIds = new ArrayList<>();
      List<Long> inboundIds = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(specificationDTOParam.getList())) {
         for (SpecificationDetailDTOParam param : specificationDTOParam.getList()) {
            Preconditions.checkArgument(!param.getValue().contains(" * "), "规格中不能包含[ * ]");
            this.checkDetail(specificationDTOParam.getList(), param);
            Preconditions.checkArgument(
               this.specificationDetailsMapper
                     .selectList(
                        (Wrapper<SpecificationDetail>)(Wrappers.<SpecificationDetail>lambdaQuery()
                              .eq(SpecificationDetail::getSpecificationId, specification.getId()))
                           .eq(SpecificationDetail::getCode, param.getCode())
                     )
                     .size()
                  <= 1,
               "修改失败,编号[" + param.getCode() + "]已存在"
            );
            Preconditions.checkArgument(
               this.specificationDetailsMapper
                     .selectList(
                        (Wrapper<SpecificationDetail>)(Wrappers.<SpecificationDetail>lambdaQuery()
                              .eq(SpecificationDetail::getSpecificationId, specification.getId()))
                           .eq(SpecificationDetail::getValue, param.getValue())
                     )
                     .size()
                  <= 1,
               "修改失败,规格[" + param.getValue() + "]已存在"
            );
            if (param.getId() == null) {
               SpecificationDetail detail = SpecificationDetail.builder().build();
               BeanUtils.copyProperties(param, detail);
               detail.setSpecificationId(specification.getId());
               detail.setSort(maxSort = maxSort + 1);
               detail.setBoolUsed(false);
               this.specificationDetailsMapper.insert(detail);
            } else {
               for (ApplyPurchaseDetail applyPurchaseDetail : this.applyPurchaseDetailService
                  .list((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getClassifyId, specification.getClassificationId()))) {
                  if (StrUtil.isNotBlank(applyPurchaseDetail.getSpecificationIds())) {
                     List<Long> l = CommonUtil.spilt(applyPurchaseDetail.getSpecificationIds(), ",");
                     l.removeAll(applyPurchaseIds);
                     applyPurchaseIds.addAll(l);
                  }
               }

               for (PurchaseOrderDetail orderDetail : this.purchaseOrderDetailService
                  .list((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getClassifyId, specification.getClassificationId()))) {
                  if (StrUtil.isNotBlank(orderDetail.getSpecificationIds())) {
                     List<Long> l = CommonUtil.spilt(orderDetail.getSpecificationIds(), ",");
                     l.removeAll(purchaseOrderIds);
                     purchaseOrderIds.addAll(l);
                  }
               }

               for (InboundDetail inboundDetail : this.inboundDetailMapper
                  .selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getClassifyId, specification.getClassificationId()))) {
                  if (StrUtil.isNotBlank(inboundDetail.getSpecificationIds())) {
                     List<Long> l = CommonUtil.spilt(inboundDetail.getSpecificationIds(), ",");
                     l.removeAll(inboundIds);
                     inboundIds.addAll(l);
                  }
               }

               SpecificationDetail detail = this.specificationDetailsMapper.selectById(param.getId());
               Preconditions.checkArgument(detail != null, "规格不存在");
               if (!detail.getValue().equals(param.getValue()) || !detail.getCode().equals(param.getCode())) {
                  Preconditions.checkArgument(!applyPurchaseIds.contains(detail.getId()), "修改失败, 规格" + detail.getValue() + "已产生申购记录.");
                  Preconditions.checkArgument(!scmLumpSumSystemPurchaseOrderIds.contains(detail.getId()), "修改失败, 规格" + detail.getValue() + "已产生包干制采购记录.");
                  Preconditions.checkArgument(!purchaseOrderIds.contains(detail.getId()), "修改失败, 规格" + detail.getValue() + "已产生自合营采购记录.");
                  Preconditions.checkArgument(!inboundIds.contains(detail.getId()), "修改失败, 规格" + detail.getValue() + "已产生入库记录.");
                  detail.setCode(param.getCode());
                  detail.setValue(param.getValue());
                  detail.setUpdateTime(LocalDateTime.now());
                  this.specificationDetailsMapper.updateById(detail);
               }

               detailIds.remove(param.getId());
            }
         }

         if (CollectionUtil.isNotEmpty(detailIds)) {
            applyPurchaseIds.retainAll(detailIds);
            Preconditions.checkArgument(applyPurchaseIds.size() == 0, "删除失败, 当前删除的详情存在申购");
            scmLumpSumSystemPurchaseOrderIds.retainAll(detailIds);
            Preconditions.checkArgument(scmLumpSumSystemPurchaseOrderIds.size() == 0, "删除失败, 当前删除的详情存在包干制采购");
            purchaseOrderIds.retainAll(detailIds);
            Preconditions.checkArgument(purchaseOrderIds.size() == 0, "删除失败, 当前删除的详情存在自合营采购");
            inboundIds.retainAll(detailIds);
            Preconditions.checkArgument(inboundIds.size() == 0, "删除失败, 当前删除的详情存在入库");
            this.specificationDetailsMapper.deleteBatchIds(detailIds);
         }
      }

      return true;
   }

   @Override
   public Map<String, String> checkClassifySpec(Long subjectId, String spec) {
      List<String> specArray = new ArrayList<>();
      List<SpecificationDTO> specificationDTOS;
      if (StrUtil.isNotBlank(spec)) {
         specArray = Arrays.asList(spec.split(" \\* "));
         specificationDTOS = this.specificationMapper.selectBySubjectId(subjectId);
         Preconditions.checkArgument(specificationDTOS.size() == specArray.size(), "当前规格与科目规格不匹配");
      } else {
         specificationDTOS = this.specificationMapper.selectBySubjectId(subjectId);
         Preconditions.checkArgument(CollectionUtil.isEmpty(specificationDTOS), "请核对科目规格");
      }

      Map<String, String> map = new HashMap<>();
      StringBuilder sb = new StringBuilder();
      StringBuilder ids = new StringBuilder();

      for (int i = 0; i < specificationDTOS.size(); i++) {
         String spe = specArray.get(i);
         SpecificationDTO specificationDTO = specificationDTOS.get(i);
         List<SpecificationDetailDTO> list = specificationDTO.getList().stream().filter(detail -> detail.getValue().equals(spe)).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(list)) {
            sb.append(list.get(0).getCode());
            if (specificationDTOS.size() - 1 == i) {
               ids.append(list.get(0).getId());
            } else {
               ids.append(list.get(0).getId()).append(",");
            }
         } else {
            Preconditions.checkArgument(false, "规格配置不存在[" + spe + "]");
         }
      }

      map.put("code", sb.toString());
      map.put("ids", ids.toString());
      return map;
   }

   @Override
   public String getJoinSpec(Long classifyId, String spec) {
      String[] split = spec.split(" \\* ");
      List<SpecificationDTO> list = this.specificationMapper.selectBySubjectId(classifyId);
      Preconditions.checkArgument(split.length == list.size(), "当前[" + spec + "]规格与规格配置不匹配");
      List<String> spl = new ArrayList<>();

      for (int i = 0; i < list.size(); i++) {
         if (!list.get(i).getBoolWeightedAverage()) {
            spl.add(split[i]);
         }
      }

      return StrUtil.isNotBlank(StrUtil.join("*", spl)) ? StrUtil.join("*", spl) : null;
   }
}
