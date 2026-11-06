package com.hzchum.scim.cut.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlatePart;
import com.hzchum.scim.cut.core.api.service.CutPlatePartService;
import com.hzchum.scim.cut.core.mapper.CutPlatePartMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CutPlatePartMapperImpl extends ServiceImpl<CutPlatePartMapper, CutPlatePart> implements CutPlatePartService {
   @Resource
   private CutPlatePartService cutPlatePartService;
   @Resource
   private TechMachinePartService techMachinePartService;

   @Override
   public List<TechMachinePart> getCutPart(String taskId) {
      List<CutPlatePart> list = this.cutPlatePartService.list((Wrapper<CutPlatePart>)new LambdaQueryWrapper<CutPlatePart>().eq(CutPlatePart::getTaskId, taskId));
      List<String> newlist = list.stream().map(CutPlatePart::getPartId).collect(Collectors.toList());
      if (CollUtil.isNotEmpty(newlist)) {
         ArrayList<TechMachinePart> objects = new ArrayList<>();
         list.forEach(cutPlatePart -> {
            TechMachinePart techMachinePart1 = this.techMachinePartService.getById(cutPlatePart.getPartId());
            techMachinePart1.setQuantity(Integer.valueOf(cutPlatePart.getQuantity()));
            techMachinePart1.setTotalNetWeight(BigDecimal.valueOf(Long.parseLong(cutPlatePart.getQuantity())).multiply(techMachinePart1.getNetWeight()));
            objects.add(techMachinePart1);
         });
         return objects;
      } else {
         return null;
      }
   }
}
