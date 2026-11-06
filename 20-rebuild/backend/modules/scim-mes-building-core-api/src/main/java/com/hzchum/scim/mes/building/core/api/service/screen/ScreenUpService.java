package com.hzchum.scim.mes.building.core.api.service.screen;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTAllProductDTO;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTProducterDTO;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTWeatherDTO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ScreenUpService {
   IOTProducterDTO overview();

   List<IOTAllProductDTO> deviceOverview();

   Map electricSummary();

   List<BigDecimal> electricAnalysis(Integer timeState);

   List<BigDecimal> gasAnalysis(Integer timeState);

   IOTWeatherDTO getWeather();

   void syncCorporationStructrureInfo();

   void syncDeviceInfo();

   void syncEquipmentTypeInfo();

   void export(String serverHost, String dataBaseName) throws IOException;

   ResultVO downloadSql(HttpServletResponse response) throws IOException;
}
