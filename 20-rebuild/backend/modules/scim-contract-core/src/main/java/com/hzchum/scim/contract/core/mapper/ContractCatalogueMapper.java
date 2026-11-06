package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCatalogue;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCatalogueQueryDTOParam;
import java.util.List;

public interface ContractCatalogueMapper extends BaseMapper<ContractCatalogue> {
   List<ContractCatalogue> listInfo(ContractCatalogueQueryDTOParam param);
}
