package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.ContractExpenseTypeBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseDictionaryLink;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseTypeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ExpenseTypeSaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ExpenseTypeUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseDictionaryLinkService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseReimburseService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractExpenseTypeMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractExpenseTypeBizImpl
   extends IBizImpl<ContractExpenseTypeService, ContractExpenseTypeMapper, ContractExpenseType>
   implements ContractExpenseTypeBiz {
   @Resource
   private ContractExpenseDictionaryLinkService linkService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ContractExpenseReimburseService expenseReimburseService;

   @Override
   public PageVO<ContractExpenseTypeDTO> listByCondition(String name, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractExpenseTypeDTO> typeDTOList = this.baseService.listByCondition(name);
      typeDTOList.forEach(s -> s.setLinks(this.linkService.listByExpenseType(s.getId())));
      return new PageVO<>(typeDTOList);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteExpenseType(List<Long> ids) {
      ids.forEach(id -> {
         ContractExpenseType expenseType = this.baseMapper.selectById(id);
         Preconditions.checkArgument(expenseType != null, "费用类型不存在");
         Boolean exist = this.expenseReimburseService.isExist(id, null);
         Preconditions.checkArgument(!exist, "删除失败,该费用类型已存在报销记录");
         this.baseMapper.deleteById(id);
         this.linkService.remove(Wrappers.lambdaQuery(ContractExpenseDictionaryLink.builder().expenseTypeId(id).build()));
      });
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateExpenseType(ExpenseTypeUpdateDTOParam param) {
      ContractExpenseType expenseType = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(expenseType != null, "更新失败,费用类型不存在");
      if (!expenseType.getName().equals(param.getName())) {
         int count = this.baseMapper.selectCount((Wrapper<ContractExpenseType>)new LambdaQueryWrapper<ContractExpenseType>().eq(ContractExpenseType::getName, param.getName()));
         Preconditions.checkArgument(count == 0, "更新失败,该费用类型已存在");
      }

      List<ContractExpenseDictionaryLink> linkList = this.linkService
         .list(Wrappers.lambdaQuery(ContractExpenseDictionaryLink.builder().expenseTypeId(param.getId()).build()));
      Map<Long, ContractExpenseDictionaryLink> oldLinkMap = linkList.stream()
         .collect(Collectors.toMap(ContractExpenseDictionaryLink::getDictionaryId, Function.identity()));
      Set<Long> dictionaryIdSet = new HashSet<>(param.getDictionaryIdList());
      dictionaryIdSet.forEach(
         dictionaryId -> {
            if (!oldLinkMap.containsKey(dictionaryId)) {
               SysDictionary dictionary = this.dictionaryService.getById(dictionaryId);
               Preconditions.checkArgument(dictionary != null, "修改失败,字典中不存在,无法添加该明细");
               ContractExpenseDictionaryLink link = ContractExpenseDictionaryLink.builder()
                  .expenseTypeId(param.getId())
                  .dictionaryId(dictionaryId)
                  .dictionaryValue(dictionary.getValue())
                  .dictionaryLabel(dictionary.getLabel())
                  .build();
               this.linkService.save(link);
            }
         }
      );
      oldLinkMap.forEach((dictionaryId, link) -> {
         if (!dictionaryIdSet.contains(dictionaryId)) {
            Boolean exist = this.expenseReimburseService.isExist(param.getId(), dictionaryId);
            Preconditions.checkArgument(!exist, "修改失败,该费用明细已存在报销记录,不能删除");
            this.linkService.removeById(link.getId());
         }
      });
      BeanUtil.copy(param, expenseType);
      this.baseMapper.updateById(expenseType);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveExpenseType(ExpenseTypeSaveDtoParam param) {
      ContractExpenseType expenseType = this.baseMapper
         .selectOne((Wrapper<ContractExpenseType>)new LambdaQueryWrapper<ContractExpenseType>().eq(ContractExpenseType::getName, param.getName()));
      Preconditions.checkArgument(expenseType == null, "添加失败，费用类型已存在");
      ContractExpenseType copy = BeanUtil.copy(param, ContractExpenseType.class);
      this.baseMapper.insert(copy);
      this.saveExpenseTypeDictionaryLink(copy.getId(), param.getDictionaryIdList());
      return Boolean.TRUE;
   }

   private void saveExpenseTypeDictionaryLink(Long expenseTypeId, List<Long> dictionaryIdList) {
      dictionaryIdList.forEach(
         id -> {
            SysDictionary dictionary = this.dictionaryService.getById(id);
            Preconditions.checkArgument(dictionary != null, "对应的字典不存在!");
            ContractExpenseDictionaryLink link = ContractExpenseDictionaryLink.builder()
               .expenseTypeId(expenseTypeId)
               .dictionaryId(id)
               .dictionaryValue(dictionary.getValue())
               .dictionaryLabel(dictionary.getLabel())
               .build();
            this.linkService.save(link);
         }
      );
   }
}
