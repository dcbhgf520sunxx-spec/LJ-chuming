package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSale;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleQueryDtoParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleService;
import com.hzchum.scim.wms.core.mapper.wmsReport.WasteSaleMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WasteSaleServiceImpl extends ServiceImpl<WasteSaleMapper, WasteSale> implements WasteSaleService {
   @Override
   public List<WasteSaleDTO> listByCondition(WasteSaleQueryDtoParam queryDtoParam) {
      return this.baseMapper.selectByCondition(queryDtoParam);
   }
}
