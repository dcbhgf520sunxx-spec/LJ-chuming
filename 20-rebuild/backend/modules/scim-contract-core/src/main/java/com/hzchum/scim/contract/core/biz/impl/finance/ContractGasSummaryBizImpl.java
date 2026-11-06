package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGasSummaryBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractGasSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.WmsGasClassificationDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractGasSummaryDtoParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractGasSummaryService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGasSummaryMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractGasSummaryBizImpl
   extends IBizImpl<ContractGasSummaryService, ContractGasSummaryMapper, ContractGasSummary>
   implements ContractGasSummaryBiz {
   @Resource
   private ClassificationService classificationService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private MeasureService measureService;

   @Override
   public ListVO<WmsGasClassificationDTO> listWmsGasClass() {
      List<Classification> classificationList = this.classificationService
         .list(Wrappers.lambdaQuery(Classification.builder().basicClass(BasicClassEnum.GAS.getType()).boolLastEnum(true).build()));
      List<WmsGasClassificationDTO> dtoList = classificationList.stream().map(s -> {
         WmsGasClassificationDTO gasClassificationDTO = BeanUtil.copy(s, WmsGasClassificationDTO.class);
         Measure measure = this.getMeasure(s.getId());
         if (measure != null) {
            gasClassificationDTO.setAccountingUnit(measure.getAccountingUnit());
         }

         return gasClassificationDTO;
      }).collect(Collectors.toList());
      return new ListVO<>(dtoList);
   }

   @Override
   public ListVO<ContractGasSummaryDTO> listGasSummary(Long classifyId, Integer year) {
      List<ContractGasSummaryDTO> summaryDTOList = this.baseService.listByCondition(classifyId, year);
      summaryDTOList.forEach(s -> s.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds())));
      return new ListVO<>(summaryDTOList);
   }

   @Override
   public Boolean saveList(List<ContractGasSummaryDtoParam> paramList) {
      paramList.forEach(param -> {
         if (param.getId() != null) {
            ContractGasSummary gasSummary = this.baseService.getById(param.getId());
            Preconditions.checkArgument(gasSummary != null, "记录不存在");
            Preconditions.checkArgument(gasSummary.getBoolConfirmStatus().equals(false), "记录已确认,无法修改");
            Preconditions.checkArgument(param.getYear().equals(gasSummary.getYear()), "年份不能修改");
            Preconditions.checkArgument(param.getMonth().equals(gasSummary.getMonth()), "年份不能修改");
            this.checkGasUnit(param.getClassifyId());
            BeanUtil.copy(param, gasSummary);
            Measure measure = this.getMeasure(param.getClassifyId());
            if (measure != null) {
               gasSummary.setAccountingUnit(measure.getAccountingUnit());
            }

            gasSummary.setTotalAmount(param.getTotalAmount());
            gasSummary.setRemark(param.getRemark());
            gasSummary.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            this.baseService.updateById(gasSummary);
         } else {
            Preconditions.checkArgument(!this.baseService.isExist(param.getClassifyId(), param.getYear(), param.getMonth()), "添加失败,记录已存在");
            ContractGasSummary gasSummary = BeanUtil.copy(param, ContractGasSummary.class);
            this.checkGasUnit(param.getClassifyId());
            Measure measure = this.getMeasure(param.getClassifyId());
            if (measure != null) {
               gasSummary.setAccountingUnit(measure.getAccountingUnit());
            }

            gasSummary.setYearMonthValue(param.getYear() * 100 + param.getMonth());
            gasSummary.setUserId(UserUtil.getCurrentUserId());
            gasSummary.setBoolConfirmStatus(false);
            gasSummary.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            this.baseService.save(gasSummary);
         }
      });
      return true;
   }

   void checkGasUnit(Long classifyId) {
      Classification classification = this.classificationService.getById(classifyId);
      Preconditions.checkArgument(classification != null && classification.getBasicClass().equals(BasicClassEnum.GAS.getType()), "气体类型不正确!");
   }

   private Measure getMeasure(Long classifyId) {
      Measure measure = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, classifyId));
      if (measure == null) {
         return null;
      }

      if (StringUtils.isNotBlank(measure.getAccountingUnit())) {
         return measure;
      }

      Classification classification = this.classificationService.getById(classifyId);
      return classification == null ? null : this.getMeasure(classification.getParentId());
   }

   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractGasSummary gasSummary = this.baseService.getById(id);
         Preconditions.checkArgument(gasSummary != null, "删除失败,记录不存在");
         Preconditions.checkArgument(gasSummary.getBoolConfirmStatus().equals(false), "删除失败,记录已确认");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printList(Long classifyId, Integer year) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (classifyId != null) {
         Classification classification = this.classificationService.getById(classifyId);
         header.put("classifyName", classification.getName());
      }

      if (year != null) {
         header.put("year", year);
      }

      printVO.setHeader(header);
      List<ContractGasSummaryDTO> dtoList = this.baseService.listByCondition(classifyId, year);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }
}
