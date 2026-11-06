package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckDetail;
import com.hzchum.scim.project.core.api.pojo.dto.SubBusinessCheckDetailDO;
import com.hzchum.scim.project.core.api.pojo.dto.SubBusinessCheckDetailDTO;
import com.hzchum.scim.project.core.api.service.SubBusinessCheckDetailService;
import com.hzchum.scim.project.core.mapper.SubBusinessCheckDetailMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SubBusinessCheckDetailServiceImpl
   extends ServiceImpl<SubBusinessCheckDetailMapper, SubBusinessCheckDetail>
   implements SubBusinessCheckDetailService {
   @Override
   public ListVO<SubBusinessCheckDetailDTO> listByCheckId(Long id) {
      List<SubBusinessCheckDetailDO> businessList = this.baseMapper.listByCheckId(id);
      return new ListVO<>(businessList.stream().map(e -> {
         SubBusinessCheckDetailDTO copy = BeanUtil.copy(e, SubBusinessCheckDetailDTO.class);
         if (ProductTypeEnum.ARTIFACT.getType().equals(e.getType())) {
            copy.setNuclear("t");
            copy.setMeasure("件");
         } else if (ProductTypeEnum.ENCLOSURE.getType().equals(e.getType())) {
            Integer method = 1;
            copy.setTotalMete(method == 1 ? e.getTotalMete() : e.getTotalArea());
            copy.setNuclear(method == 1 ? "m" : "㎡");
            copy.setMeasure("张");
         }

         return copy;
      }).collect(Collectors.toList()));
   }
}
