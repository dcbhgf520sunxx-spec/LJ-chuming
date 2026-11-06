package com.hzchum.scim.iot.core.api.service.equiment;

import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.CorporationStructrure;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentType;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics.AmeterStatisticsVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead.DeviceTypeReadVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.CappEquipmentCurrentVoltageIofo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.CappEquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.GasMeterStatisticsVo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.plc.PlcData;
import java.math.BigDecimal;
import java.util.List;

public interface EquimentService {
   List<DeviceTypeReadVos> deviceTypeRead();

   List<AmeterStatisticsVos> ameterFindStatistics(Long equipmentId, Long prodLineId, Long startTime, Long endTime, Integer abscissa);

   List<GasMeterStatisticsVo> gasFindStatistics(Long equipmentId, Long prodLineId, Long startTime, Long endTime, Integer gasType, Integer abscissa);

   List<CorporationStructrure> syncCorporationStructrureInfo();

   List<EquipmentInfo> syncDeviceInfo();

   List<PlcData> findNow(Long prodLineId, Long deviceId);

   List<EquipmentType> syncEquipmentTypeInfo();

   CappEquipmentInfo cappFindEquipmentInfo(String deviceId);

   String cappAddWeldTask(
      String bizId,
      Integer bizType,
      BigDecimal currentLowerLimit,
      BigDecimal currentUpperLimit,
      Long deviceId,
      BigDecimal voltageLowerLimit,
      BigDecimal voltageUpperLimit,
      String weldingGunCode
   );

   CappEquipmentCurrentVoltageIofo cappFindEquipmentCurrentVoltageInfo(Long bizId);
}
