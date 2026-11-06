package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanySaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanySimpleVO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyUpdateDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.BranchProjectVO;
import java.util.List;

public interface BranchCompanyService extends IService<BranchCompany> {
   PageVO<BranchCompanyDTO> pageByCondition(String name, String socialCode, Integer enabled, Integer pageNumber, Integer pageSize);

   PageVO<BranchCompanyDTO> pageByCondition(String name, String socialCode, Integer enabled, Integer level, Integer pageNumber, Integer pageSize);

   ListVO<BranchCompanySimpleVO> listSimple();

   ListVO<BranchCompanySimpleVO> purchaseByLevelList(Integer level);

   Long save(BranchCompanySaveDTOParam saveDTOParam);

   Boolean update(BranchCompanyUpdateDTOParam requestVO);

   Boolean delete(List<Long> ids);

   Boolean updateEnabled(Long id, Integer enabled);

   ListVO<BankAccountDTO> listBlankAccount();

   List<BankAccountDTO> listCompanyAccount();

   String getNameById(Long id);

   String getShortNameById(Long id);

   List<BranchProjectVO> getBranchProjectList();
}
