package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCatalogueQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCatalogueDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCatalogueDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractCatalogueService extends IService<ContractCatalogue> {
   PageVO<ContractCatalogueDTO> getList(ContractCatalogueQueryDTOParam param, Integer pageNumber, Integer pageSize);

   ContractCatalogueDTO selectById(Long id);

   Boolean edit(ContractCatalogueDTOParam dtoParam);

   Boolean export(ContractCatalogueQueryDTOParam param, HttpServletResponse response);

   Boolean editContractNumber(List<ContractCatalogueDTOParam> dtoParams);

   ContractCatalogue saveDate(ContractCatalogue contractCatalogue, Boolean boolSave);

   List<ContractCatalogueDTO> convertDTO(List<ContractCatalogue> contractCatalogues);

   List<ContractCatalogueDTO> getNoSupplementAndNumber();

   Boolean cancellation(Long id, Integer reviewStatus);
}
