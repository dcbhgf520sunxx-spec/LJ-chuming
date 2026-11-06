package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingSupplier;
import com.hzchum.scim.bid.core.api.pojo.dto.BiddingSupplierDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingSupplierVO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface BiddingSupplierService extends IService<BiddingSupplier> {
   PageVO<BiddingSupplierVO> getSupplierList(
      String name, String socialCreditCode, Set<Long> subjectIds, Set<Long> regionIds, Boolean boolEnableEnum, Integer page, Integer size
   );

   Boolean saveSupplier(List<BiddingSupplierDTO> supplierDTOS);

   PageVO<BiddingSupplierVO> querySupplier(String name, String code, Set<Long> subjectIds, Set<Long> regionIds, Integer black, Integer page, Integer size);

   List<BiddingSupplierVO> getInvite(Set<Long> subjectIds);

   BiddingSupplierVO getDetail(Long id);

   Boolean deleteSupplier(List<Long> ids);

   Boolean setBlacklist(List<Long> ids, Integer black);

   ListVO getSupplier(Long id);

   List<BiddingSupplierVO> getList(
      @Param("name") String name,
      @Param("code") String code,
      @Param("subjectIds") Set<Long> subjectIds,
      @Param("regionIds") Set<Long> regionIds,
      @Param("black") Integer black,
      @Param("uuid") String uuid
   );
}
