package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOtherApportionmentLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectOtherApportionmentLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectOtherApportionmentLinkMapper extends BaseMapper<MesContractProjectOtherApportionmentLink> {
   List<MesContractProjectOtherApportionmentLinkDTO> listInfo(@Param("projectId") Long projectId);
}
