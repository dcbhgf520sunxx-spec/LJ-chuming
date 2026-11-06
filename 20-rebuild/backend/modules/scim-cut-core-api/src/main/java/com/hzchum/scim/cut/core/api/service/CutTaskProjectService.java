package com.hzchum.scim.cut.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.pojo._do.CutTaskProject;
import java.util.List;

public interface CutTaskProjectService extends IService<CutTaskProject> {
   ResultVO deleteTask(String cutTaskId);

   ResultVO deletePlate(String plateId);

   ResultVO setPlateReport(String plateReport);

   ResultVO uploadTask(String cutTaskId);

   ResultVO getPartByCutTaskId(Integer pageNumber, Integer pageSize, String cutTaskId);

   ResultVO getTaskByProjectId(Long projectId, Long monomerId, Long areaId);

   ResultVO getPartByProjectId(Integer pageNumber, Integer pageSize, Long projectId, String projectName, List<String> sort, Long nestingState, String year);

   ResultVO feedingOperation(
      Integer pageNumber,
      Integer pageSize,
      List<Long> areaIdList,
      Long projectId,
      String thick,
      String material,
      Integer relationType,
      String serialNumber,
      List<String> sort
   );

   ResultVO createOrder(List<Long> techMachinePartIds, Long projectId);

   ResultVO updateOrder(String cutTaskId);

   ResultVO getPartByAreaId(Integer pageNumber, Integer pageSize, String areaId, List<String> sort);

   ResultVO addPartFromOrder(List<Long> techMachinePartIds, String cutTaskId);

   ResultVO deletePartFromOrder(List<Long> techMachinePartIds, String cutTaskId);

   ResultVO getProjectInfo();

   void partInspection(Long partId);

   PrintVO printPartByCutTaskId(String cutTaskId);
}
