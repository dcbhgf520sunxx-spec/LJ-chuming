package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppEquipmentDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassBindEquipmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassCodeScanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppPassListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppWeldListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftProductTaskSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppEquipmentVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassRecordVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppPassVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppWeldVO;
import java.util.List;

public interface TechCappCraftProductTaskBiz extends IBiz<TechCappCraftProductTask> {
   void generateCappTaksRecord(
      List<TechAssembleExt> neeUpdateAssexts,
      List<TechArtifactExt> needUpdateExts,
      List<CappCraftProductTaskSaveDTO> cappCraftProductTaskSaveDTOS,
      Integer productType
   );

   void deleteCappTaksRecord(List<TechAssembleExt> removeAssnumbers, List<TechArtifactExt> removeArtifactNumbers, Integer productType);

   PageVO<CappCraftCardProductAppVO> productList(CappCraftCardProductAppListDTO dto);

   List<CappCraftCardProductAppCodeNumberVO> productCodeNumberList(CappCraftCardProductAppCodeNumberListDTO dto);

   List<CappCraftCardProductAppWeldVO> productWeldList(CappCraftCardProductAppWeldListDTO dto);

   List<CappCraftCardProductAppPassVO> productPassList(CappCraftCardProductAppPassListDTO dto);

   Boolean productPassBindEquipment(CappCraftCardProductAppPassBindEquipmentDTO dto);

   Boolean productPassStart(Long id);

   CappCraftCardProductAppPassRecordVO productPassRecord(Long id);

   Boolean productPassStop(Long id);

   Boolean productPassComplete(Long id);

   CappCraftCardProductAppVO productPassCodeScan(CappCraftCardProductAppPassCodeScanDTO dto);

   CappCraftCardProductAppEquipmentVO productEquipmentDetail(CappCraftCardProductAppEquipmentDetailDTO dto);

   void reissuedCappTask(Long productId, Integer productType);
}
