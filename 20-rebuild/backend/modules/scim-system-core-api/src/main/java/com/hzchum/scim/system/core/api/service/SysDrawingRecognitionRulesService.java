package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.DrawingRecognitionRules;
import com.hzchum.scim.system.core.api.pojo.dto.SysDrawingRecognitionRulesDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysDrawingRecognitionRulesVO;

public interface SysDrawingRecognitionRulesService extends IService<DrawingRecognitionRules> {
   Boolean saveDrawingRules(SysDrawingRecognitionRulesDTO rulesDTO);

   SysDrawingRecognitionRulesVO getDrawingRules();
}
