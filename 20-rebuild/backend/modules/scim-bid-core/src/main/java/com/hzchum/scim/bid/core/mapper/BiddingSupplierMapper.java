package com.hzchum.scim.bid.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingSupplier;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingSupplierVO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BiddingSupplierMapper extends BaseMapper<BiddingSupplier> {
   List<BiddingSupplierVO> getList(
      @Param("name") String name,
      @Param("code") String code,
      @Param("subjectIds") Set<Long> subjectIds,
      @Param("regionIds") Set<Long> regionIds,
      @Param("black") Integer black,
      @Param("uuid") String uuid
   );

   BiddingSupplierVO getBiddingSupplierOne(@Param("id") Long id, @Param("uuid") String uuid);

   List<BiddingSupplierVO> listByCondition(
      @Param("name") String name,
      @Param("socialCreditCode") String socialCreditCode,
      @Param("subjectIds") Set<Long> subjectIds,
      @Param("regionIds") Set<Long> regionIds,
      @Param("boolEnableEnum") Boolean boolEnableEnum,
      @Param("uuid") String uuid
   );
}
