package com.hzchum.scim.mes.building.core.client;

import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CutTaskRequestData;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.NestResultDTO;
import java.util.List;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "scim", url = "https://plm7-dev.hzchum.com")
public interface CutTaskClient {
   @PostMapping("/deviceApi/deviceLongRange/insertCuttingOrder")
   NestResultDTO insertCuttingOrder(@RequestBody CutTaskRequestData cutTaskRequestData);

   @PutMapping("/deviceApi/deviceLongRange/changeDevice")
   NestResultDTO changeDevice(@RequestBody List<CutTaskRequestData> cutTaskRequestData);

   @DeleteMapping("/deviceApi/deviceLongRange")
   NestResultDTO deleteDeviceByChildGuidList(@RequestBody List<String> guids);

   @PostMapping("/deviceApi/deviceLongRange/deleteAndInsertCuttingOrder")
   NestResultDTO deleteAndInsertCuttingOrder(@RequestBody Map<String, Object> map);
}
