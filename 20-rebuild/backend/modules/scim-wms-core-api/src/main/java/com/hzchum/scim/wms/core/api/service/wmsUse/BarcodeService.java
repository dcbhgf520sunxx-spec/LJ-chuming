package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Barcode;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;

public interface BarcodeService extends IService<Barcode> {
   String generateBarcodeByMaterial(MaterialInventory materialInventory);
}
