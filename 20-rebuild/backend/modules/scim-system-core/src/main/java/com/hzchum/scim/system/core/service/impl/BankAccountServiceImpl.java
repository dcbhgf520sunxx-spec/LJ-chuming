package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountVO;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.mapper.BankAccountMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl extends ServiceImpl<BankAccountMapper, BankAccount> implements BankAccountService {
   @Override
   public ListVO<BankAccountVO> listByCompanyId(Long companyId) {
      List<BankAccount> bankAccountList = this.baseMapper
         .selectList((Wrapper<BankAccount>)Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getBranchCompanyId, companyId));
      if (bankAccountList.isEmpty()) {
         return new ListVO<>();
      }

      List<BankAccountVO> accountVOList = bankAccountList.stream().map(b -> BeanUtil.copy(b, BankAccountVO.class)).collect(Collectors.toList());
      return new ListVO<>(accountVOList);
   }
}
