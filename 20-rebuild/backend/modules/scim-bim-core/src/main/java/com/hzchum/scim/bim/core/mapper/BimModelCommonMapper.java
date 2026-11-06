package com.hzchum.scim.bim.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimModelCommonResponseVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BimModelCommonMapper extends BaseMapper<BimModelCommonDO> {
   BimModelCommonResponseVO getBimByMonomer(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("importMode") Integer importMode);

   List<BimModelCommonResponseVO> getBimByArea(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaIds") List<Long> areaIds, @Param("importMode") Integer importMode
   );

   Integer selectSuccessQuantity(@Param("importMode") Integer importMode, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);
}
