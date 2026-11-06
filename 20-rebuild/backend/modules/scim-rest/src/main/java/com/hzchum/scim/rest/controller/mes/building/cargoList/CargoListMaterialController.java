package com.hzchum.scim.rest.controller.mes.building.cargoList;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.EquimentrepVO;
import com.hzchum.scim.iot.core.api.service.equiment.WeighingScaleEquipmentInfoService;
import com.hzchum.scim.mes.building.core.api.enums.DockingMethodEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoPlateWeightDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES发运-采集过磅信息")
@RestController
@RequestMapping("/api/app/material")
public class CargoListMaterialController {
   private static final Logger log = LoggerFactory.getLogger(CargoListMaterialController.class);
   @Resource
   private WeighingScaleEquipmentInfoService scaleEquipmentInfoService;

   @ApiOperation("获取地磅(包括车牌)近三天列表")
   @GetMapping("/license/plate/list")
   public ResultVO<ListVO<CargoPlateWeightDTO>> licensePlateList(
      @RequestParam(required = false) String deviceId, @RequestParam(required = false) String inOutType
   ) {
      HashMap<String, Object> objectObjectHashMap = new HashMap<>(16);
      WeighingScaleEquipmentInfo one = new WeighingScaleEquipmentInfo();
      if (StringUtils.isNotBlank(deviceId)) {
         one = this.scaleEquipmentInfoService
            .getOne(Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).eq(WeighingScaleEquipmentInfo::getDeviceId, deviceId));
         Preconditions.checkArgument(one != null, "设备不存在，无法请求地磅数据");
      }

      String type;
      if (one.getDockingMethod().equals(DockingMethodEnum.WEIGHT.getType())) {
         type = "weight";
      } else if (inOutType.equals(WarehouseTypeEnum.INTO.getType().toString())) {
         type = "tareWeight";
      } else {
         type = "roughWeight";
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
      LocalDateTime now = LocalDateTime.now();
      objectObjectHashMap.put("deviceId", one.getDeviceId());
      objectObjectHashMap.put("startTime", formatter.format(now.plusDays(-3L)));
      objectObjectHashMap.put("endTime", formatter.format(now));
      objectObjectHashMap.put("type", type);
      String str = HttpUtil.post(one.getUrl(), objectObjectHashMap);
      EquimentrepVO<List<CargoPlateWeightDTO>> vo = JSON.parseObject(str, new TypeReference<EquimentrepVO<List<CargoPlateWeightDTO>>>() {});
      Preconditions.checkArgument("0".equals(vo.getCode()), vo.getMsg());
      List<CargoPlateWeightDTO> dtos = Optional.ofNullable(vo.getData()).orElse(Collections.emptyList());
      if (dtos.isEmpty()) {
         CargoPlateWeightDTO weightDTO = JSON.parseObject(JSON.toJSONString(vo.getData()), CargoPlateWeightDTO.class);
         dtos = Collections.singletonList(weightDTO);
      }

      dtos.forEach(dto -> dto.setPlateNum(dto.getCarNumber()));
      return ResultBuilder.success(new ListVO<>(dtos));
   }

   @ApiOperation("获取过磅信息最近一次")
   @ApiImplicitParams(@ApiImplicitParam(name = "plateNum", value = "车牌", paramType = "query"))
   @GetMapping("/input/list")
   public ResultVO<CargoPlateWeightDTO> materialInput(
      @RequestParam(required = false) String deviceId, @RequestParam(required = false) String plateNum, @RequestParam(required = false) String inOutType
   ) {
      HashMap<String, Object> objectObjectHashMap = new HashMap<>(16);
      WeighingScaleEquipmentInfo one = new WeighingScaleEquipmentInfo();
      if (StringUtils.isNotBlank(deviceId)) {
         one = this.scaleEquipmentInfoService
            .getOne(Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).eq(WeighingScaleEquipmentInfo::getDeviceId, deviceId));
         Preconditions.checkArgument(one != null, "设备不存在，无法请求地磅数据");
      }

      String type;
      if (one.getDockingMethod().equals(DockingMethodEnum.WEIGHT.getType())) {
         type = "weight";
      } else if (inOutType.equals(WarehouseTypeEnum.INTO.getType().toString())) {
         type = "tareWeight";
      } else {
         type = "roughWeight";
      }

      objectObjectHashMap.put("deviceId", one.getDeviceId());
      if (!one.getDockingMethod().equals(DockingMethodEnum.WEIGHT.getType()) && StringUtils.isNotBlank(plateNum)) {
         objectObjectHashMap.put("plateNum", plateNum);
      }

      objectObjectHashMap.put("type", type);
      String str = HttpUtil.post(one.getUrl(), objectObjectHashMap);
      EquimentrepVO<CargoPlateWeightDTO> vo = JSON.parseObject(str, new TypeReference<EquimentrepVO<CargoPlateWeightDTO>>() {});
      Preconditions.checkArgument("0".equals(vo.getCode()), vo.getMsg());
      CargoPlateWeightDTO dto = vo.getData();
      dto.setRoughWeight(dto.getWeight());
      dto.setTareWeight(dto.getWeight());
      dto.setPlateNum(dto.getCarNumber());
      return ResultBuilder.success(dto);
   }

   @ApiOperation("获取过磅设备列表")
   @GetMapping("/device/list")
   public ResultVO materialDeviceList() {
      return ResultBuilder.success(new ListVO<>(this.scaleEquipmentInfoService.findMaterialDeviceList()));
   }

   @ApiOperation("分页查询地磅配置")
   @GetMapping("/page")
   public ResultVO page(
      @RequestParam(defaultValue = "1") int pageNum,
      @RequestParam(defaultValue = "10") int pageSize,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String status
   ) {
      log.info("API 调用 ：分页查询地磅配置");
      return ResultBuilder.success(this.scaleEquipmentInfoService.pageList(name, status, pageNum, pageSize));
   }

   @ApiOperation("修改状态-地磅配置")
   @PutMapping("/status")
   public ResultVO updateStatus(@RequestParam("id") Long id, @RequestParam("status") Boolean status) {
      log.info("API 调用 ：修改状态");
      return ResultBuilder.success(this.scaleEquipmentInfoService.updateStatus(id, status));
   }
}
