package com.hzchum.scim.mes.building.core.service.impl.screen;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.iot.core.api.enums.equipment.EquimentTypeEnum;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.CorporationStructrure;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentType;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics.AmeterStatisticsVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead.DeviceCurrentTypeVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead.DeviceTypeReadVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.GasMeterStatisticsVo;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTAllProductDTO;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTLineIDNameDTO;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTProducterDTO;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTWeatherDTO;
import com.hzchum.scim.iot.core.api.service.equiment.CorporationStructrureService;
import com.hzchum.scim.iot.core.api.service.equiment.EquimentService;
import com.hzchum.scim.iot.core.api.service.equiment.EquipmentInfoService;
import com.hzchum.scim.iot.core.api.service.equiment.EquipmentTypeService;
import com.hzchum.scim.mes.building.core.api.service.screen.ScreenUpService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class ScreenUpServiceImpl implements ScreenUpService {
   private static final Logger log = LoggerFactory.getLogger(ScreenUpServiceImpl.class);
   @Value("${spring.datasource.dynamic.datasource.master.username}")
   private String username;
   @Value("${spring.datasource.dynamic.datasource.master.password}")
   private String password;
   @Resource
   private EquimentService equimentService;
   @Resource
   private EquipmentTypeService equipmentTypeService;
   @Resource
   private CorporationStructrureService corporationStructrureService;
   @Value("${spring.profiles.active}")
   private String env;
   private static final String ENVIRONMENT_LOCAL = "local";
   private static final String ENVIRONMENT_COMPANY = "company";
   private volatile boolean exportInProgress = false;
   @Resource
   private EquipmentInfoService equipmentInfoService;
   @Value("${weatherkey}")
   private String key;
   @Value("${weathersig}")
   private String sig;

   @Override
   public IOTProducterDTO overview() {
      List<IOTAllProductDTO> iotAllProductDTOS = this.deviceOverview();
      return IOTProducterDTO.builder()
         .debugQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getDebugNum).sum())
         .deviceQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getDeviceNum).sum())
         .freeQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getFreeNum).sum())
         .offLineQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getOfflineNum).sum())
         .onLineQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getOnlineNum).sum())
         .runQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getRunNum).sum())
         .warningQuantity((int)iotAllProductDTOS.stream().mapToDouble(IOTAllProductDTO::getWarnNum).sum())
         .build();
   }

   @Override
   public List<IOTAllProductDTO> deviceOverview() {
      Map<String, CorporationStructrure> corporMap = this.corporationStructrureService
         .list(Wrappers.lambdaQuery(CorporationStructrure.class).eq(CorporationStructrure::getType, 4))
         .stream()
         .collect(Collectors.toMap(CorporationStructrure::getName, Function.identity()));
      List<DeviceTypeReadVos> allvos = this.equimentService.deviceTypeRead();
      Map<String, DeviceTypeReadVos> lineMap = allvos.stream().collect(Collectors.toMap(DeviceTypeReadVos::getProdLineName, Function.identity()));
      List<IOTAllProductDTO> lines = new ArrayList<>();

      for (String name : lineMap.keySet()) {
         List<DeviceCurrentTypeVos> vos = lineMap.get(name).getDeviceCurrentTypeVos();

         for (DeviceCurrentTypeVos vo : vos) {
            vo.setType(vo.getType() == null ? 1 : vo.getType());
         }

         IOTAllProductDTO line = IOTAllProductDTO.builder()
            .deviceNum(vos.size())
            .productionLine(IOTLineIDNameDTO.builder().id(corporMap.get(name).getId()).name(name).build())
            .onlineNum(Math.toIntExact(vos.stream().filter(s -> s.getType() == null || s.getType().equals(EquimentTypeEnum.OFF_LINE.getType())).count()))
            .offlineNum(Math.toIntExact(vos.stream().filter(s -> s.getType() != null && !s.getType().equals(EquimentTypeEnum.OFF_LINE.getType())).count()))
            .runNum(Math.toIntExact(vos.stream().filter(s -> s.getType().equals(EquimentTypeEnum.RUNNING.getType())).count()))
            .freeNum(Math.toIntExact(vos.stream().filter(s -> s.getType().equals(EquimentTypeEnum.IDLE.getType())).count()))
            .warnNum(Math.toIntExact(vos.stream().filter(s -> s.getType().equals(EquimentTypeEnum.WARNING.getType())).count()))
            .debugNum(Math.toIntExact(vos.stream().filter(s -> s.getType().equals(EquimentTypeEnum.SAKEDOWN_TEST.getType())).count()))
            .build();
         lines.add(line);
      }

      return lines;
   }

   @Override
   public Map electricSummary() {
      int currentYear = LocalDate.now().getYear();
      LocalDate startOfYear = LocalDate.of(currentYear, 1, 1);
      long startTimestamp = startOfYear.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000L;
      LocalDate endOfYear = LocalDate.of(currentYear, 12, 31);
      long endTimestamp = endOfYear.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L;
      List<AmeterStatisticsVos> ameterStatisticsVos = this.equimentService.ameterFindStatistics(null, null, startTimestamp, endTimestamp, 1);
      double sum = ameterStatisticsVos.stream().mapToDouble(AmeterStatisticsVos::getAllPowerExpend).sum();
      HashMap<String, Double> map = new HashMap<>();
      map.put("electricMeasure", sum);
      return map;
   }

   @Override
   public List<BigDecimal> electricAnalysis(Integer timeState) {
      List<BigDecimal> dtos = new ArrayList<>();
      LocalDateTime endDate = LocalDateTime.now();
      LocalDateTime startDate = null;
      if (timeState.equals(1)) {
         startDate = endDate.minusMonths(1L);
      }

      if (timeState.equals(2)) {
         startDate = endDate.minusMonths(12L);
      }

      if (timeState.equals(3)) {
         startDate = endDate.minusYears(10L);
      }

      Integer abscissa = timeState == 1 ? 0 : (timeState == 2 ? 1 : 2);
      List<AmeterStatisticsVos> ameterStatisticsVos = this.equimentService
         .ameterFindStatistics(
            null,
            null,
            startDate.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L,
            endDate.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L,
            abscissa
         );
      Map<String, Double> dateMap = ameterStatisticsVos.stream()
         .collect(Collectors.toMap(AmeterStatisticsVos::getYearAndMonthAndDay, AmeterStatisticsVos::getAllPowerExpend));
      if (timeState.equals(1)) {
         for (String day : this.getDays(30)) {
            if (dateMap.containsKey(day)) {
               dtos.add(new BigDecimal(dateMap.get(day)).setScale(5, RoundingMode.HALF_UP));
            } else {
               dtos.add(BigDecimal.ZERO);
            }
         }
      }

      if (timeState.equals(2)) {
         for (String month : this.getMonths(12)) {
            if (dateMap.containsKey(month)) {
               dtos.add(new BigDecimal(dateMap.get(month)).setScale(5, RoundingMode.HALF_UP));
            } else {
               dtos.add(BigDecimal.ZERO);
            }
         }
      }

      if (timeState.equals(3)) {
         for (String year : this.getYears(10)) {
            if (dateMap.containsKey(year)) {
               dtos.add(new BigDecimal(dateMap.get(year)).setScale(5, RoundingMode.HALF_UP));
            } else {
               dtos.add(BigDecimal.ZERO);
            }
         }
      }

      return dtos;
   }

   @Override
   public List<BigDecimal> gasAnalysis(Integer timeState) {
      List<BigDecimal> dtos = new ArrayList<>();
      LocalDateTime endDate = LocalDateTime.now();
      LocalDateTime startDate = null;
      if (timeState.equals(1)) {
         LocalDate date = LocalDate.now();
         startDate = date.minusMonths(1L).atTime(0, 0, 0);
      }

      if (timeState.equals(2)) {
         LocalDate date = LocalDate.now();
         startDate = date.minusMonths(12L).atTime(0, 0, 0);
      }

      if (timeState.equals(3)) {
         LocalDate date = LocalDate.now();
         startDate = date.minusYears(10L).atTime(0, 0, 0);
      }

      Integer abscissa = timeState == 1 ? 0 : (timeState == 2 ? 1 : 2);
      List<GasMeterStatisticsVo> trVos = this.equimentService
         .gasFindStatistics(
            null,
            null,
            startDate.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L,
            endDate.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L,
            null,
            abscissa
         );
      Map<String, Double> dateMap = trVos.stream()
         .collect(Collectors.toMap(GasMeterStatisticsVo::getYearAndMonthAndDay, GasMeterStatisticsVo::getAllPowerExpend));
      if (timeState.equals(1)) {
         for (String day : this.getDays(30)) {
            if (dateMap.containsKey(day)) {
               dtos.add(BigDecimal.valueOf(dateMap.get(day)).setScale(5, RoundingMode.HALF_UP));
            } else {
               dtos.add(BigDecimal.ZERO);
            }
         }
      }

      if (timeState.equals(2)) {
         for (String month : this.getMonths(12)) {
            if (dateMap.containsKey(month)) {
               dtos.add(BigDecimal.valueOf(dateMap.get(month)).setScale(5, RoundingMode.HALF_UP));
            } else {
               dtos.add(BigDecimal.ZERO);
            }
         }
      }

      if (timeState.equals(3)) {
         for (String year : this.getYears(10)) {
            if (dateMap.containsKey(year)) {
               dtos.add(BigDecimal.valueOf(dateMap.get(year)).setScale(5, RoundingMode.HALF_UP));
            } else {
               dtos.add(BigDecimal.ZERO);
            }
         }
      }

      return dtos;
   }

   @Override
   public IOTWeatherDTO getWeather() {
      String str = "https://restapi.amap.com/v3/weather/weatherInfo?";
      String param = "city=370600&key=" + this.key;
      String s = param + this.sig;
      String s1 = DigestUtils.md5DigestAsHex(s.getBytes());
      String a = str + param + "&sig=" + s1;
      SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
      RestTemplate client = new RestTemplate(requestFactory);
      return client.getForObject(a, IOTWeatherDTO.class);
   }

   List<String> getDays(Integer days) {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      List<String> lsDate = new ArrayList<>();

      for (int i = 0; i < days; i++) {
         c.setTime(new Date());
         c.add(5, -i);
         Date d = c.getTime();
         lsDate.add(sdf.format(d));
         Collections.sort(lsDate);
      }

      return lsDate;
   }

   List<String> getMonths(Integer months) {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
      List<String> lsDate = new ArrayList<>();

      for (int i = 0; i < months; i++) {
         c.setTime(new Date());
         c.add(2, -i);
         Date d = c.getTime();
         lsDate.add(sdf.format(d));
         Collections.sort(lsDate);
      }

      return lsDate;
   }

   List<String> getYears(Integer years) {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
      List<String> lsDate = new ArrayList<>();

      for (int i = 0; i < years; i++) {
         c.setTime(new Date());
         c.add(1, -i);
         Date d = c.getTime();
         lsDate.add(sdf.format(d));
         Collections.sort(lsDate);
      }

      return lsDate;
   }

   @Scheduled(cron = "0 0 0 * * ? ")
   @Transactional(rollbackFor = Exception.class)
   @Override
   public void syncCorporationStructrureInfo() {
      if ("company".equals(this.env)) {
         List<CorporationStructrure> structrures = this.equimentService.syncCorporationStructrureInfo();
         this.corporationStructrureService.deletetUnBoolen();
         structrures = structrures.stream().map(s -> s.setIotId(s.getId())).collect(Collectors.toList());
         this.corporationStructrureService.saveOrUpdateBatch(structrures);
      }
   }

   @Scheduled(cron = "0 0 0 * * ? ")
   @Transactional(rollbackFor = Exception.class)
   @Override
   public void syncDeviceInfo() {
      if ("company".equals(this.env)) {
         List<EquipmentInfo> equipmentInfos = this.equimentService.syncDeviceInfo();
         equipmentInfos = equipmentInfos.stream().map(s -> s.setIotId(s.getId())).collect(Collectors.toList());
         this.equipmentInfoService.deletetUnBoolen();
         this.equipmentInfoService.saveBatch(equipmentInfos);
      }
   }

   @Scheduled(cron = "0 0 0 * * ? ")
   @Transactional(rollbackFor = Exception.class)
   @Override
   public void syncEquipmentTypeInfo() {
      if ("company".equals(this.env)) {
         List<EquipmentType> equipmentTypes = this.equimentService.syncEquipmentTypeInfo();
         equipmentTypes = equipmentTypes.stream().map(s -> s.setIotId(s.getId())).collect(Collectors.toList());
         this.equipmentTypeService.deletetUnBoolen();
         this.equipmentTypeService.saveBatch(equipmentTypes);
      }
   }

   @Override
   public void export(String serverHost, String dataBaseName) {
      if (this.exportInProgress) {
         log.info("正在执行导出任务，请稍后再试");
      } else {
         this.exportInProgress = true;
         ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
         CompletableFuture<Void> exportTask = CompletableFuture.runAsync(() -> this.exportDatabase(serverHost, dataBaseName), threadExecutor);
         exportTask.thenRun(() -> {
            threadExecutor.shutdown();
            this.exportInProgress = false;
         });
      }
   }

   public void exportDatabase(String serverHost, String dataBaseName) {
      try {
         Path paths1 = Paths.get("./database/ok.txt");
         if (Files.exists(paths1)) {
            Files.delete(paths1);
         }

         ProcessBuilder processBuilder = new ProcessBuilder(
            "docker", "exec", "-i", "mysql", "mysqldump", "-h", serverHost, "-u", this.username, "-p" + this.password, "--databases", dataBaseName
         );
         Path paths = Paths.get("./database/all_tables.sql");
         Files.createDirectories(paths.getParent());
         processBuilder.redirectOutput(Redirect.to(new File(paths.toString())));
         Process process = processBuilder.start();
         int exitCode = process.waitFor();
         if (exitCode == 0) {
            log.info("Database export successful. File saved to " + paths.toString());
            Path path = Paths.get("./database/ok.txt");
            Files.createFile(path);
         } else {
            log.info("Database export failed. Exit code: " + exitCode);
         }
      } catch (IOException | InterruptedException e) {
         e.printStackTrace();
      }
   }

   @Override
   public ResultVO<String> downloadSql(HttpServletResponse response) throws IOException {
      Path paths1 = Paths.get("./database/ok.txt");
      if (!Files.exists(paths1)) {
         return ResultBuilder.failed("数据库SQL文件未导出");
      }

      Path paths = Paths.get("./database/all_tables.sql");
      File file = paths.toFile();
      response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
      response.setHeader("Content-Type", "application/octet-stream");
      OutputStream outputStream = response.getOutputStream();

      try (FileInputStream fis = new FileInputStream(file)) {
         byte[] buffer = new byte[1024];

         int bytesRead;
         while ((bytesRead = fis.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
         }
      }

      outputStream.close();
      return ResultBuilder.success("导出成功");
   }
}
