package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Barcode;

public interface BarcodeMapper extends BaseMapper<Barcode> {
   Barcode getByMaterial(Barcode param);
}
