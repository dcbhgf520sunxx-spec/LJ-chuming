package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.SpringUtil;
import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.crm.core.api.biz.CrmBasicsConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmBasicsConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectInformationConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmTenderRequestConfigEnum;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo.dto.SysDictionaryDTO;
import com.hzchum.scim.system.core.api.pojo.request.DictionarySaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.DictionaryUpdateRequestVO;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.mapper.SysDictionaryMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames = "dictionary")
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {
   @Resource
   private SysDictionaryMapper dictionaryMapper;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private CrmBasicsConfigBiz crmBasicsConfigBiz;
   @Resource
   private CrmTenderRequestConfigBiz crmTenderRequestConfigBiz;

   @Override
   public ListVO<SysDictionaryDTO> listAllDictionary(String blurry) {
      List<SysDictionaryDTO> dictionaryDTOS = DictionaryEnum.listAll();
      if (StringUtils.isBlank(blurry)) {
         return new ListVO<>(dictionaryDTOS);
      }

      List<SysDictionaryDTO> responseList = new ArrayList<>();
      dictionaryDTOS.forEach(d -> {
         if (d.getName().contains(blurry) || d.getRemark().contains(blurry)) {
            responseList.add(d);
         }
      });
      return new ListVO<>(responseList);
   }

   @Override
   public PageVO<SysDictionaryDTO> pageInfo(String blurry, Integer pageNumber, Integer pageSize) {
      List<SysDictionaryDTO> list = DictionaryEnum.listAll()
         .stream()
         .filter(
            d -> StrUtil.isBlank(blurry)
               ? true
               : d.getName() != null && d.getName().contains(blurry) || d.getRemark() != null && d.getRemark().contains(blurry)
         )
         .collect(Collectors.toList());
      Page<SysDictionaryDTO> page = PageUtils.getPageVO(list, pageNumber, pageSize);
      return new PageVO<>(page);
   }

   @Override
   public ListVO<SysDictionaryDTO> listMoreDictionary(List<String> blurrys) {
      List<SysDictionaryDTO> dictionaryDTOS = DictionaryEnum.listAll();
      if (CollectionUtils.isNotEmpty(blurrys)) {
         return new ListVO<>(dictionaryDTOS);
      }

      List<SysDictionaryDTO> responseList = new ArrayList<>();
      dictionaryDTOS.forEach(d -> {
         if (blurrys.contains(d.getName()) || blurrys.contains(d.getRemark())) {
            responseList.add(d);
         }
      });
      return new ListVO<>(responseList);
   }

   @Override
   public List<SysDictionary> moreDistNameAndLabelLike(List<String> names) {
      return this.dictionaryMapper.moreDistNameAndLabelLike(names);
   }

   @Override
   public PageVO<SysDictionary> pageByNameAndLabelLike(String name, String label, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SysDictionary> dictionaries = this.dictionaryMapper.listByNameAndLabelLike(name, label);
      return new PageVO<>(dictionaries);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long saveDictionary(DictionarySaveDTOParam saveDTOParam) {
      Preconditions.checkArgument(DictionaryEnum.checkName(saveDTOParam.getName()), "保存失败，传入的字典名称错误");
      this.checkLabel(saveDTOParam.getName(), saveDTOParam.getLabel());
      SysDictionary checkLabel = this.dictionaryMapper.getByNameAndLabel(saveDTOParam.getName(), saveDTOParam.getLabel());
      Preconditions.checkArgument(checkLabel == null, "保存失败，该字典名称下已有对应的字典详细");
      if (StringUtils.isBlank(saveDTOParam.getValue())) {
         List<SysDictionary> sysDictionaryList = this.baseMapper
            .selectList((Wrapper<SysDictionary>)Wrappers.<SysDictionary>lambdaQuery().eq(SysDictionary::getName, saveDTOParam.getName()));
         if (sysDictionaryList.isEmpty()) {
            saveDTOParam.setValue(String.valueOf(1));
         } else {
            List<Integer> valueList = sysDictionaryList.stream().map(SysDictionary::getValue).map(Integer::parseInt).collect(Collectors.toList());
            saveDTOParam.setValue(String.valueOf(Collections.max(valueList) + 1));
         }
      }

      SysDictionary checkValue = this.dictionaryMapper.getByNameAndValue(saveDTOParam.getName(), saveDTOParam.getValue());
      Preconditions.checkArgument(checkValue == null, "保存失败，该字典名称下已有对应的字典值");
      SysDictionary save = BeanUtil.copy(saveDTOParam, SysDictionary.class);
      save.setRemark(DictionaryEnum.getRemarkByName(saveDTOParam.getName()));
      SpringUtil.getBean(SysDictionaryService.class).saveWithCache(save);
      this.synchronousCrmProjectInformation(saveDTOParam);
      return save.getId();
   }

   private void synchronousCrmProjectInformation(DictionarySaveDTOParam saveDTOParam) {
      if ("structure_status".equals(saveDTOParam.getName())) {
         this.crmProjectInformationConfigBiz
            .syncProjectInformation(CrmProjectInformationConfigEnum.STRUCTURE_TYPE_CONFIGURATION.getType(), saveDTOParam.getName());
      }

      if ("info_source".equals(saveDTOParam.getName())) {
         this.crmProjectInformationConfigBiz
            .syncProjectInformation(CrmProjectInformationConfigEnum.PROJECT_MANAGER_COOPERATION.getType(), saveDTOParam.getName());
      }

      if ("margin_type".equals(saveDTOParam.getName())) {
         this.crmTenderRequestConfigBiz.syncTenderRequestConfig(CrmTenderRequestConfigEnum.TYPE_OF_PERFORMANCE_BOND.getType(), saveDTOParam.getName());
      }

      if ("party_type".equals(saveDTOParam.getName())) {
         this.crmBasicsConfigBiz.syncBasicsConfigInformation(CrmBasicsConfigEnum.UNIT_PROPERTY_ALLOCATION.getType(), saveDTOParam.getName());
      }
   }

   private void checkLabel(String name, String label) {
      if (DictionaryEnum.INVOICE_TAX_RATE.getName().equals(name)) {
         Preconditions.checkArgument(NumberUtils.isNumber(label), "请直接输入税率数值!");
      }

      if (DictionaryEnum.ENCLOSURE_TYPE.getName().equals(name)) {
         Boolean boolContain = EnclosureCategoryEnum.boolContain(label);
         Preconditions.checkArgument(boolContain, "围护类型不可配置该字典值!");
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateDictionary(DictionaryUpdateRequestVO requestVO) {
      SysDictionary dictionary = this.dictionaryMapper.selectById(requestVO.getId());
      Preconditions.checkArgument(dictionary != null, "更新失败，字典不存在!");
      if (!Objects.equals(requestVO.getLabel(), dictionary.getLabel())) {
         this.checkLabel(dictionary.getName(), requestVO.getLabel());
         SysDictionary checkLabel = this.dictionaryMapper.getByNameAndLabel(dictionary.getName(), requestVO.getLabel());
         Preconditions.checkArgument(checkLabel == null, "保存失败，该字典名称下已有对应的字典详细");
         dictionary.setLabel(requestVO.getLabel());
      }

      if (!Objects.equals(requestVO.getValue(), dictionary.getValue())) {
         SysDictionary checkValue = this.dictionaryMapper.getByNameAndValue(dictionary.getName(), requestVO.getValue());
         Preconditions.checkArgument(checkValue == null, "保存失败，该字典名称下已有对应的字典值");
         dictionary.setValue(requestVO.getValue());
      }

      dictionary.setSort(requestVO.getSort());
      SpringUtil.getBean(SysDictionaryService.class).updateWithCache(dictionary);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteDictionary(Long id) {
      List<ContractProject> contractProjects = this.contractProjectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getStructureStatus, id)
               .or()
               .eq(ContractProject::getPartyType, id)
               .or()
               .eq(ContractProject::getSendingMode, id)
               .or()
               .eq(ContractProject::getInfoSource, id)
               .or()
               .eq(ContractProject::getProjectManagerId, id)
               .or()
               .eq(ContractProject::getCurrencyType, id)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(contractProjects), "字典已被项目引用不可删除");
      SysDictionary dictionary = this.dictionaryMapper.selectById(id);
      Preconditions.checkArgument(dictionary != null, "删除失败，字典不存在!");
      SpringUtil.getBean(SysDictionaryService.class).deleteWithCache(dictionary.getName(), dictionary.getValue());
      return this.dictionaryMapper.deleteById(id) == 1;
   }

   @Override
   public Map<String, String> getValueLabelByName(String name) {
      List<SysDictionary> dictionaryList = this.dictionaryMapper.listByNameAndLabelLike(name, null);
      return dictionaryList.stream().collect(Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel, (s1, s2) -> s1));
   }

   @Override
   public List<String> listLabelsByCondition(String name, String values) {
      if (!StringUtils.isBlank(name) && !StringUtils.isBlank(values)) {
         String[] valueList = StringUtils.split(values, ",");
         return this.dictionaryMapper.selectByConditions(name, Arrays.asList(valueList));
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public List<SysDictionary> listByName(String name) {
      return StringUtils.isBlank(name) ? new ArrayList<>() : this.dictionaryMapper.listByNameAndValue(name, null);
   }

   @Override
   public ListVO<DictionaryInfo> listDictionaryInfo(String name) {
      List<SysDictionary> dictionaryList = this.baseMapper
         .selectList((Wrapper<SysDictionary>)(new LambdaQueryWrapper<SysDictionary>().eq(SysDictionary::getName, name)).orderByAsc(SysDictionary::getSort));
      if (dictionaryList.isEmpty()) {
         return new ListVO<>(new ArrayList<>());
      }

      List<DictionaryInfo> infoList = dictionaryList.stream().map(d -> BeanUtil.copy(d, DictionaryInfo.class)).collect(Collectors.toList());
      return new ListVO<>(infoList);
   }

   @Override
   public SysDictionary getByNameAndValue(String name, String value) {
      return this.baseMapper.getByNameAndValue(name, value);
   }

   @Cacheable(key = "#name + ':' + #value", unless = "#result == null")
   @Override
   public SysDictionary getByNameAndValueFromCache(String name, String value) {
      return this.getByNameAndValue(name, value);
   }

   @CachePut(key = "#dictionary.name + ':' + #dictionary.value")
   @Override
   public SysDictionary saveWithCache(SysDictionary dictionary) {
      this.baseMapper.insert(dictionary);
      return dictionary;
   }

   @CachePut(key = "#dictionary.name + ':' + #dictionary.value")
   @Override
   public SysDictionary updateWithCache(SysDictionary dictionary) {
      this.baseMapper.updateById(dictionary);
      return dictionary;
   }

   @CacheEvict(key = "#name + ':' + #value")
   @Override
   public Boolean deleteWithCache(String name, String value) {
      SysDictionary dictionary = this.getByNameAndValue(name, value);
      this.baseMapper.deleteById(dictionary);
      return true;
   }

   @Override
   public SysDictionary getByNameAndValueV2(String currencyType, String value) {
      return this.baseMapper.getByNameAndValueV2(currencyType, value);
   }
}
