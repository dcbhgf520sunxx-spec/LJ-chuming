package com.hzchum.scim.contract.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractWaste;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteSaleDetailLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteLedgerQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteQueryDtoParam;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public interface ContractWasteBiz extends IBiz<ContractWaste> {
   List<ContractWasteDTO> listAll(ContractWasteQueryDtoParam param);

   PageVO<ContractWasteDTO> pageList(ContractWasteQueryDtoParam param, Integer pageNUmber, Integer pageSize);

   Boolean saveList(List<ContractWasteDtoParam> paramList);

   Boolean updateList(List<ContractWasteDtoParam> paramList);

   Boolean deleteList(List<Long> ids);

   BigDecimal getSumTotalAmount(ContractWasteLedgerQueryDtoParam param);

   PageVO<ContractWasteLedgerDTO> pageListWasteLedger(ContractWasteLedgerQueryDtoParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<ContractWasteLedgerDTO>> printWasteLedger(ContractWasteLedgerQueryDtoParam param);

   PageVO<ContractWasteSaleDetailLedgerDTO> pageListWasteSaleDetailLedger(ContractWasteLedgerQueryDtoParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<ContractWasteSaleDetailLedgerDTO>> printListWasteSaleDetailLedger(ContractWasteLedgerQueryDtoParam param);

   ContractInvoiceCollectionDTO getWasteCollectionInvoiceInfo(@NotNull Long contractWasteId, @NotNull Long branchCompanyId);
}
