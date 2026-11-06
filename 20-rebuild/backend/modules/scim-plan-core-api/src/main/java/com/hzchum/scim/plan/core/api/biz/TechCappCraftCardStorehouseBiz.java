package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouse;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseSimpleListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseUpdateStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseDetailVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseSimpleVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseVO;
import java.util.List;

public interface TechCappCraftCardStorehouseBiz extends IBiz<TechCappCraftCardStorehouse> {
   Boolean save(CappCraftCardStorehouseSaveDTO saveDTO);

   Boolean update(CappCraftCardStorehouseUpdateDTO updateDTO);

   PageVO<CappCraftCardStorehouseVO> list(CappCraftCardStorehouseListDTO dto);

   CappCraftCardStorehouseDetailVO detail(Long id);

   Boolean delete(List<Long> ids);

   Boolean updateEnabledFlag(CappCraftCardStorehouseUpdateStatusDTO dto);

   List<CappCraftCardStorehouseSimpleVO> simpleList(CappCraftCardStorehouseSimpleListDTO dto);

   List<TechCappCraftCardStorehouse> listAll();

   List<CappCraftCardStorehouseDetailVO> detailList(List<Long> ids);
}
