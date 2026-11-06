package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicCheck;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ConvertConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.DeficitConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.InventoryUseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.OutboundUpdateConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PartyABorrowReturnConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.PriceAbnormalConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReportDownload;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ReturnConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SteelInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.StuffTypeConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.TransferConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import java.util.List;
import java.util.Map;

public interface BasicConfigService extends IService<BasicConfig> {
   BasicInbound getInboundBasicConf();

   BasicInbound getInboundBasicConfV2();

   Boolean setInboundBasicConf(BasicInbound basicInbound);

   ReportDownload getReportDownload();

   Boolean setReportDownload(ReportDownload reportDownload);

   SteelInbound getInboundSteelConf();

   Boolean setInboundSteelConf(SteelInbound steelInbound);

   BasicOutbound getOutboundBasicConf();

   Boolean setOutboundBasicConf(BasicOutbound basicOutbound);

   Map<String, Object> getAllConfig();

   WasteConfig getSteelScrapDefinitionConf();

   Boolean setSteelScrapDefinitionConf(WasteConfig wasteConfig);

   PartyABorrowReturnConf getPartyABorrowReturnConf();

   Boolean setPartyABorrowReturnConf(PartyABorrowReturnConf partyABorrowReturnConf);

   WeightedPriceConf getWeightedPriceConf();

   Boolean setWeightedPriceConf(WeightedPriceConf conf);

   ReturnConfig getReturnConf();

   Boolean setReturnConf(ReturnConfig conf);

   TransferConfig getTransferConfig();

   Boolean setTransferConfig(TransferConfig conf);

   BasicInbound getPurchaseSpecBasicConf();

   Boolean setPurchaseSpecBasicConf(BasicInbound basicInbound);

   StuffTypeConf getStuffTypeConf();

   Boolean setStuffTypeConf(StuffTypeConf conf);

   BasicCheck getCheckBasicConf();

   Boolean setCheckBasicConf(BasicCheck basicCheck);

   DeficitConfig getInventoryConfig();

   Boolean setInventoryConfig(DeficitConfig conf);

   MaterialConfig getInventoryTypeConfig();

   Boolean setInventoryTypeConfig(MaterialConfig conf);

   MaterialWarehouseConfig getMaterialWarehouseConfig();

   Boolean setMaterialWarehouseConfig(MaterialWarehouseConfig conf);

   BasicShowConfig getBasicShowConfig();

   Boolean setBasicShowConfig(BasicShowConfig config);

   InventoryUseConfig getInventoryBasicConf();

   Boolean setInventoryBasicConf(InventoryUseConfig conf);

   List<ConvertConfig> getConvertConfig();

   Boolean setConvertConfig(List<ConvertConfig> list);

   OutboundUpdateConfig getOutboundUpdateConfig();

   Boolean setOutboundUpdateConfig(OutboundUpdateConfig conf);

   List<PriceAbnormalConfig> getPriceAbnormalConfig();

   Boolean setPriceAbnormalConfig(List<PriceAbnormalConfig> conf);

   WeightedExecutionPriceConf getWeightedExecutionTypeConfig();

   Boolean setWeightedExecutionTypeConfig(WeightedExecutionPriceConf conf);
}
