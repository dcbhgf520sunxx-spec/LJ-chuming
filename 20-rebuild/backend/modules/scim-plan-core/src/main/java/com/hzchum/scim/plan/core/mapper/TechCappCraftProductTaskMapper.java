package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppWeldListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppWeldVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechCappCraftProductTaskMapper extends BaseMapper<TechCappCraftProductTask> {
   List<CappCraftCardProductAppVO> productList(@Param("dto") CappCraftCardProductAppListDTO dto, @Param("taskIds") List<Long> taskIds);

   List<CappCraftCardProductAppCodeNumberVO> productCodeNumberList(CappCraftCardProductAppCodeNumberListDTO dto);

   List<CappCraftCardProductAppWeldVO> productWeldList(CappCraftCardProductAppWeldListDTO dto);

   List<CappCraftCardProductAppPassVO> productPassList(CappCraftCardProductAppPassListDTO dto);
}
