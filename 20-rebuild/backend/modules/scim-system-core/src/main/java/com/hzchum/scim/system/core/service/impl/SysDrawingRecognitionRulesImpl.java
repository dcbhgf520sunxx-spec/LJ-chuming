package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.common.enums.SysDrawingRecognitionRulesEnums;
import com.hzchum.scim.system.core.api.pojo._do.DrawingRecognitionRules;
import com.hzchum.scim.system.core.api.pojo.dto.SysDrawingRecognitionRulesDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysDrawingRecognitionRulesVO;
import com.hzchum.scim.system.core.api.service.SysDrawingRecognitionRulesService;
import com.hzchum.scim.system.core.mapper.SysDrawingRecognitionRulesMapper;
import org.springframework.stereotype.Service;

@Service
public class SysDrawingRecognitionRulesImpl
   extends ServiceImpl<SysDrawingRecognitionRulesMapper, DrawingRecognitionRules>
   implements SysDrawingRecognitionRulesService {
   @Override
   public Boolean saveDrawingRules(SysDrawingRecognitionRulesDTO rulesDTO) {
      DrawingRecognitionRules recognitionRules = this.baseMapper.selectOne(new LambdaQueryWrapper<>());
      if (recognitionRules == null) {
         DrawingRecognitionRules rules = DrawingRecognitionRules.builder()
            .type(rulesDTO.getType())
            .name(SysDrawingRecognitionRulesEnums.getNameByType(rulesDTO.getType()))
            .build();
         this.baseMapper.insert(rules);
      }

      if (recognitionRules != null && !recognitionRules.getType().equals(rulesDTO.getType())) {
         recognitionRules.setType(rulesDTO.getType());
         recognitionRules.setName(SysDrawingRecognitionRulesEnums.getNameByType(rulesDTO.getType()));
         this.baseMapper.updateById(recognitionRules);
      }

      return true;
   }

   @Override
   public SysDrawingRecognitionRulesVO getDrawingRules() {
      DrawingRecognitionRules recognitionRules = this.baseMapper.selectOne(new LambdaQueryWrapper<>());
      return recognitionRules == null ? null : BeanUtil.copy(recognitionRules, SysDrawingRecognitionRulesVO.class);
   }
}
