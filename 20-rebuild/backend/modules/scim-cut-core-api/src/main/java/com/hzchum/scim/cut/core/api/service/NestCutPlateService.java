package com.hzchum.scim.cut.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutPlate;
import java.util.List;
import java.util.Map;

public interface NestCutPlateService extends IService<NestCutPlate> {
   ResultVO getPlateReport(String plateReport);

   ResultVO uploadJobPart(List ids);

   ResultVO updateNestsStates(String ncCode);

   ResultVO uploadJob(List ids);

   ResultVO addJobPart(Map<Long, Integer> map);

   ResultVO getPlatePartList(String barcode);
}
