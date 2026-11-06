package com.hzchum.scim.cut.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlate;
import java.time.LocalDateTime;
import java.util.List;

public interface CutPlateService extends IService<CutPlate> {
   ResultVO getPlant(
      Long projectId,
      String projectName,
      String thick,
      String plateType,
      String importTime,
      String mac,
      String plateState,
      String material,
      String machineName,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort,
      Long plateID
   );

   ResultVO getNestingList(
      Integer pageNumber, Integer pageSize, String projectNo, String projectName, String date, List<String> sort, Integer nestingState, Integer cutState
   );

   ResultVO getMachinePlateList(
      Integer pageNumber,
      Integer pageSize,
      String mac,
      String machineName,
      Long factoryId,
      Long workshopInfId,
      LocalDateTime startTime,
      LocalDateTime endTime,
      List<String> sort
   );

   ResultVO getMachinePartList(Integer pageNumber, Integer pageSize, String mac, List<String> sort);

   ResultVO getPartListByMac(String mac);

   ResultVO contrastPlant(String taskId, String barcode, String mac);

   ResultVO getProjectGuide(Long projectId);
}
