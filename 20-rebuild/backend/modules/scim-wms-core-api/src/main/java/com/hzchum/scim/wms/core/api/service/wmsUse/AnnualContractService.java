package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.AnnualContract;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AnnualContractDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AnnualContractDTOParam;
import java.util.List;

public interface AnnualContractService extends IService<AnnualContract> {
   PageVO<AnnualContractDTO> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort, Boolean status, Long supplierId);

   Boolean updateAnnualContract(AnnualContractDTOParam param);

   Boolean addAnnualContract(AnnualContractDTOParam param);

   Boolean deleteAnnualContract(Long id);

   Boolean updateAnnualContractStatus(Long id, Boolean status);
}
