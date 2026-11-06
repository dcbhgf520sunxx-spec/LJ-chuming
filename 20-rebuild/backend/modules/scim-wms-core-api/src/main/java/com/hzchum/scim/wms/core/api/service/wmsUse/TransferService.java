package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferBuyInDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDetailListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferBuyInDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.TransferReviewDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface TransferService extends IService<Transfer> {
   PageVO<TransferDTO> pageInfo(QueryTransferDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<TransferDTO> pageTransferList(QueryTransferDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<TransferDTO> listInfo(QueryTransferDTOParam param);

   Boolean saveTransfer(TransferDTOParam param);

   TransferDetailListDTO queryById(Long id);

   TransferDetailListDTO queryById2(Long id);

   PrintVO<List<TransferDetailDTO>> transferPrint(Long id);

   List<Long> getIds(QueryTransferDTOParam param);

   Boolean passed(TransferReviewDTOParam param);

   Boolean returned(Long id, String approvalComments);

   ListVO<TransferBuyInDTO> getPartyATransfer(QueryTransferBuyInDTOParam param, Integer pageNum, Integer size, List<String> sort, Integer type);

   Boolean batchTransfer(BatchTransferDTOParam param, Integer basicClass);

   Boolean batchTransferApplication(BatchTransferDTOParam param, Integer basicClass);

   void returnExcel(
      QueryTransferBuyInDTOParam param, Integer transferType, HttpServletResponse response, Integer pageNumber, Integer pageSize, List<String> sort
   );
}
