package com.hzchum.scim.mes.building.core.api.biz.laborManagement;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesBehaviorTotalScore;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesBehaviorScoreDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.ViolationRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorScoreQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorTotalScoreParam;
import java.util.List;
import java.util.Map;

public interface MesBehaviorScoreBiz {
   PageVO<MesBehaviorScoreDTO> pageInfo(MesBehaviorScoreQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesBehaviorScoreDTO> listInfo(MesBehaviorScoreQuery query);

   Boolean saveOrUpdateBehaviorTotalScore(MesBehaviorTotalScoreParam param);

   List<ViolationRecordDTO> violationRecord(Long userId, Integer year);

   PrintVO<List<Map<String, Object>>> violationRecordPrint(Long userId, Integer year);

   MesBehaviorTotalScore behaviorTotalScoreInfo(Integer year);

   Boolean setEmployeeBehaviorTotalScore(Long rosterId, Integer behaviorTotalScore);

   Integer getRemainingBehaviorScore(Long userId);
}
