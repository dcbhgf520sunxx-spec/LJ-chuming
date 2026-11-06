package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import com.hzchum.scim.iot.core.api.service.equiment.WeighingScaleEquipmentInfoService;
import com.hzchum.scim.mes.building.core.api.enums.DockingMethodEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(88)
public class WeighingScaleEquipmentRunner implements CommandLineRunner {
   @Resource
   private WeighingScaleEquipmentInfoService scaleEquipmentInfoService;
   @Value("${chum.config.companyName}")
   private String defaultCompanyName;
   @Value("${wagonBalance.companyName}")
   private String companyName;
   @Value("${chum.config.url}")
   private String url;
   @Resource
   private MesBuildingFactoryService factoryService;

   @Override
   public void run(String... args) throws Exception {
      List<WeighingScaleEquipmentInfo> infoList = this.scaleEquipmentInfoService
         .list(Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).lt(BaseEntity::getCreateTime, LocalDate.of(2025, 8, 24)));
      if (CollectionUtils.isNotEmpty(infoList)) {
         this.scaleEquipmentInfoService.removeByIds(infoList.stream().map(e -> e.getId()).collect(Collectors.toList()));
      }

      List<MesBuildingFactory> factoryList = this.factoryService.list();
      List<WeighingScaleEquipmentInfo> newInfoList = this.scaleEquipmentInfoService
         .list(Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).gt(BaseEntity::getCreateTime, LocalDate.of(2025, 8, 24)));
      ArrayList<WeighingScaleEquipmentInfo> addList = new ArrayList<>();
      if (CollectionUtils.isEmpty(newInfoList) && CollectionUtils.isNotEmpty(factoryList)) {
         if (this.defaultCompanyName.equals("中南钢构")) {
            WeighingScaleEquipmentInfo info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(10207L)
               .deviceName("杭州顶松D822")
               .companyName("中南钢构")
               .cmc("DTU")
               .remark("二厂")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
            info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(10208L)
               .deviceName("宁波柯力D39")
               .companyName("中南钢构")
               .cmc("UDP")
               .remark("一厂")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
         } else if (this.defaultCompanyName.equals("中建三局")) {
            WeighingScaleEquipmentInfo info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(10205L)
               .deviceName("杭州顶松D822")
               .companyName("中建三局")
               .cmc("UDP")
               .remark("")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
         } else if (this.defaultCompanyName.equals("欧本钢构")) {
            WeighingScaleEquipmentInfo info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(10081L)
               .deviceName("宁波柯力D2008")
               .companyName("欧本钢构")
               .cmc("DTU")
               .remark("")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
         } else if (this.defaultCompanyName.equals("浙二建")) {
            WeighingScaleEquipmentInfo info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(null)
               .deviceName("上海耀华_XK3190-DS10")
               .companyName("浙二建")
               .cmc("DTU")
               .remark("")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
         } else if (this.defaultCompanyName.equals("安徽建工")) {
            WeighingScaleEquipmentInfo info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(10204L)
               .deviceName("上海耀华_XK3190-DS8")
               .companyName("安徽建工")
               .cmc("DTU")
               .remark("")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
         } else if (this.defaultCompanyName.equals("鑫光正")) {
            addList.add(
               WeighingScaleEquipmentInfo.builder()
                  .factoryId(factoryList.get(0).getId())
                  .workshopId(3L)
                  .deviceId(1190080401L)
                  .deviceName("鑫光正三厂地磅")
                  .companyName("鑫光正")
                  .cmc("DTU")
                  .remark("三厂")
                  .url(this.url + "floorPound/getWeighing")
                  .lastEditorUserId(1L)
                  .userId(1L)
                  .dockingMethod(DockingMethodEnum.PLATE.getType())
                  .build()
            );
            addList.add(
               WeighingScaleEquipmentInfo.builder()
                  .factoryId(factoryList.get(0).getId())
                  .workshopId(2L)
                  .deviceId(1190080094L)
                  .deviceName("鑫光正二厂地磅")
                  .companyName("鑫光正")
                  .cmc("DTU")
                  .remark("二厂")
                  .url(this.url + "floorPound/getWeighing")
                  .lastEditorUserId(1L)
                  .userId(1L)
                  .dockingMethod(DockingMethodEnum.PLATE.getType())
                  .build()
            );
            addList.add(
               WeighingScaleEquipmentInfo.builder()
                  .factoryId(factoryList.get(0).getId())
                  .workshopId(7L)
                  .deviceId(1085907819L)
                  .deviceName("鑫光正七厂地磅")
                  .companyName("鑫光正")
                  .cmc("DTU")
                  .remark("七厂")
                  .url(this.url + "floorPound/getWeighing")
                  .lastEditorUserId(1L)
                  .userId(1L)
                  .dockingMethod(DockingMethodEnum.PLATE.getType())
                  .build()
            );
         } else if (this.defaultCompanyName.equals("新疆福泰")) {
            addList.add(
               WeighingScaleEquipmentInfo.builder()
                  .factoryId(factoryList.get(0).getId())
                  .workshopId(7L)
                  .deviceId(1190080410L)
                  .deviceName("天福泰地磅")
                  .companyName("新疆福泰")
                  .cmc("DTU")
                  .remark("")
                  .url("http://100.168.30.10:1880/floorPound/getWeighing")
                  .lastEditorUserId(1L)
                  .userId(1L)
                  .dockingMethod(DockingMethodEnum.CARGO_WEIGHT.getType())
                  .build()
            );
         } else {
            WeighingScaleEquipmentInfo info = WeighingScaleEquipmentInfo.builder()
               .factoryId(factoryList.get(0).getId())
               .deviceId(null)
               .deviceName("地磅")
               .companyName(this.defaultCompanyName)
               .cmc("DTU")
               .remark("")
               .url(this.url + "floorPound/getWeighing")
               .lastEditorUserId(1L)
               .userId(1L)
               .dockingMethod(DockingMethodEnum.PLATE.getType())
               .build();
            addList.add(info);
         }

         this.scaleEquipmentInfoService.saveBatch(addList);
      }
   }
}
