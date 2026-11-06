package com.hzchum.scim.mes.building.core.biz.impl.abnormal;

import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.abnormal.MesBuildingProduceSurplusBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.abnormal.ProduceSurplusDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal.ProduceSurplusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.ProduceSurplusDTOParam;
import com.hzchum.scim.mes.building.core.api.service.surplus.MesBuildingProduceSurplusService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceSurplusBizImpl implements MesBuildingProduceSurplusBiz {
   @Autowired
   private MesBuildingProduceSurplusService produceSurplusService;

   @Override
   public List<ProduceSurplusDTO> surplusList(ProduceSurplusDTOParam dtoParam) {
      return this.produceSurplusService
         .surplusList(BeanUtil.copy(dtoParam, ProduceSurplusDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, ProduceSurplusDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProduceSurplusDTO> surplusPage(ProduceSurplusDTOParam copy, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.surplusList(copy));
   }
}
