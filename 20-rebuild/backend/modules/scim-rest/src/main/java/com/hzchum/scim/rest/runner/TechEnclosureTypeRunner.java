package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(11)
@Component
public class TechEnclosureTypeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(TechEnclosureTypeRunner.class);
   private final SysDictionaryService dictionaryService;
   private final InitializationService initializationService;

   @Override
   public void run(String... args) throws Exception {
      List<SysDictionary> dictionaryList = new ArrayList<>();
      List<SysDictionary> enclosureList = this.dictionaryService.list(Wrappers.lambdaQuery(SysDictionary.class).eq(SysDictionary::getName, "enclosure_type"));
      if (CollectionUtils.isNotEmpty(enclosureList)) {
         if (enclosureList.get(0).getRemark().equals("围护产线类型")) {
            enclosureList.forEach(e -> e.setRemark("围护类型"));
         }

         this.dictionaryService.updateBatchById(dictionaryList);
      } else {
         dictionaryList.add(SysDictionary.builder().label("夹芯板").value("1").name("enclosure_type").remark("围护类型").sort(1).build());
         dictionaryList.add(SysDictionary.builder().label("压型彩板").value("2").name("enclosure_type").remark("围护类型").sort(2).build());
         dictionaryList.add(SysDictionary.builder().label("压型楼承板").value("3").name("enclosure_type").remark("围护类型").sort(3).build());
         dictionaryList.add(SysDictionary.builder().label("桁架楼承板").value("4").name("enclosure_type").remark("围护类型").sort(4).build());
         dictionaryList.add(SysDictionary.builder().label("折边件").value("5").name("enclosure_type").remark("围护类型").sort(5).build());
         this.dictionaryService.saveBatch(dictionaryList);
      }
   }

   public TechEnclosureTypeRunner(final SysDictionaryService dictionaryService, final InitializationService initializationService) {
      this.dictionaryService = dictionaryService;
      this.initializationService = initializationService;
   }
}
