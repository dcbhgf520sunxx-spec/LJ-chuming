package com.hzchum.scim.mes.building.core.api.service.temp_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWork;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkQuery;
import java.time.LocalDate;
import java.util.List;

public interface MesTempWorkService extends IService<MesTempWork> {
   List<MesTempWorkDTO> listInfo(MesTempWorkQuery query);

   MesTempWorkDTO detailById(Long id);

   PageVO<MesTempWorkDTO> myTempWork(LocalDate startDate, LocalDate endDate, Long reporterId, Integer pageNumber, Integer pageSize, List<String> sort);

   MesTempWorkDTO tempWorkDetail(Long id);

   Boolean add(MesTempWorkParam param);

   PageVO<MesTempWorkDTO> myTempWorkApproval(Long approverId, Integer pageNumber, Integer pageSize, List<String> sort);

   MesTempWorkDTO tempWorkApprovalDetail(Long id);

   PageVO<MesTempWorkDTO> approvalRecord(Long approverId, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean approval(MesTempWorkApprovalParam param);
}
