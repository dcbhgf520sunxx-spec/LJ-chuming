"""Apply source-reviewed judgments to the preserved 48-pattern baseline; no app edits."""
from pathlib import Path
import json,hashlib,datetime,re
p=Path(__file__).resolve().parent.parent;root=p.parent.parent
ledger=json.loads((p/'route-resolution-ledger.json').read_text())
graph={m['file']:m for m in json.loads((root/'20-rebuild/recovery-tools/generated/module-graph.json').read_text())['modules']}
source={m['original_chunk']:m for m in json.loads((p/'source-map.json').read_text())['modules']}
runtime_path=root/'20-rebuild/local/runtime/verification/runtime-registration.json';runtime_bytes=runtime_path.read_bytes();runtime=json.loads(runtime_bytes)
# A witness in an import graph is deliberately not treated as a click or request.
reviews={
1:('inactive-mode-branch','构件工单明细k初始TASK_LIST=1，打开时只重置为1，原界面无赋值2/切换入口；nesting请求仅在k!==TASK_LIST。','src/views/mes/work-order-manage/artifact/module/detail.vue.js','按当前真实可选模式关闭；不凭空新增套料Tab，不将套料协议改成普通工单。'),
2:('inactive-legacy-crud','当前构零件清单add/edit/del/download均false；实际行备注用updateRemark。','src/views/plan/technical-manage/artifact-tree/index.vue.js','保留原不可操作CRUD残留；不替换成不同业务的备注接口。'),
3:('unselected-export','当前菜单选定组件没有到临时变更函数d的绑定路径。','src/modules/artifact-tree-bcd3b733.js','见selected-export-route-reachability.json；不是当前菜单真实请求。'),
4:('inactive-legacy-crud','当前部件清单optShow.edit=false，无原edit表单入口。','src/views/plan/technical-manage/assembly/index.vue.js','不凭邻近enclosure/update制造部件编辑实现。'),
5:('inactive-legacy-crud','型材规格当前crud只取header.get和实际specification新增；旧编辑被新规格接口替代。','src/views/config-manage/classification-manage/section-steel-specification-config/index.vue.js','保留不可触发旧classification/material/section-steel编辑。'),
6:('inactive-legacy-crud','同一型材规格页旧crud.del无启用按钮；实际删除用独立specification接口。','src/views/config-manage/classification-manage/section-steel-specification-config/index.vue.js','不把不同实体删除混为一个接口。'),
7:('inactive-return-type-branch','前端R仅productType=NESTING32调用旧link；当前看板ASSEMBLE入口由Service固定16查询，Mapper SELECT固定16 productType。','src/views/mes/production-manage/dashboard/artifact-dashboard/index.vue.js','完整Service→Mapper→前端链证明当前列表不返回32；不是因只查缺Controller推断。保留无入口旧分支。'),
8:('overridden-legacy-crud','当前BG采购crudApi {...Ke,add:Ge}明确覆盖旧_ot.add=v5；Ge=fw走原v2 innerSourcingSubmitReviewOrder。','src/views/supply-chain/purchase-order-bg/index.vue.js','旧LumpSum createPurchase不应重新启用。'),
9:('source-contract-repaired','BG当前详情PS无条件渲染I5下载，原误用已退役LumpSum实体；现代同语义详情ks使用K5。','src/shared/segments/044.fragment.js','I5委托现K5→GET /api/v2/scm/purchase-order/PurchaseExcel/{id}。现Service按同一PurchaseOrder主键+全部PurchaseOrderDetail非分页导出、金额/单位转换/合计，绝不传现代ID给旧实体。原模板存在但旧表scm_lump_sum_system_purchase_order不在当前683表；真实工作簿QA由SCM执行。'),
10:('inactive-legacy-crud','Cot.save=aL仅旧CRUD定义；分类页自定义编辑走Iot的classification/update。','src/views/config-manage/classification-manage/classification-config/index.vue.js','原get/batchAdd/del仍用有效路径，未接入失效save。'),
11:('inactive-response-field-branch','入库common-header.re仅o.requisitionsSN存在才na；实际Noe选择器→zS→config.fetchUnclosedPurchaseOrder→listBrief返回BriefPurchaseOrderDTO，仅applyPurchase，无requisitionsSN字段。','src/views/wms/material-inbound/raw-material/application/components/common-header.vue.js','完整当前数据链排除旧字段条件；当前申购关联使用applyPurchase和明细applyPurchaseId/编号，未调用已退役serial-number。不因只查URL缺失推断业务缺失。'),
12:('inactive-type-branch','共享退库表单只有edit且OUTSOURCE才eO；当前菜单记录页show-edit仅PRODUCE，条件相斥。','src/views/wms/material-return/raw-material/record/index.vue.js','正常生产退库编辑用Nn现有v2 record接口；不把编辑换成需审批记录的sourcingReturnApproval。'),
13:('inactive-legacy-dialog','旧移库review.vue使用Fe；父index的k=false从未设true，真实操作走CRUD detail d8。','src/views/wms/material-moving-inventory/raw-material/review/index.vue.js','新fde.v沿用g.approveRecordId/decision/opinion→qU现有审核流，12项workflow分支测试含此证据。'),
14:('inactive-legacy-dialog','同上，旧passed对话框无打开赋值。','src/views/wms/material-moving-inventory/raw-material/review/index.vue.js','真实新审核组件在056.fde，不能新增旧passed绕审批。'),
15:('inactive-legacy-dialog','旧退货review.vue已挂但父v=false从未置true；实际CRUD detail为W_。','src/views/wms/material-reject/raw-material/review/index.vue.js','047.lF.N用g.approveRecordId/decision/opinion→JU现有v2审核，已执行拒绝意见/服务失败测试。'),
16:('inactive-legacy-dialog','同上，旧passed方法只能从从未打开的旧对话框执行。','src/views/wms/material-reject/raw-material/review/index.vue.js','不新增旧端点。'),
17:('backend-original-service-reconnected','型材零件排产库存抽屉真实读取总长度；当前MaterialInventoryService.getCountLength及Impl原方法完整保留，全量sum(length*quantity)。','src/views/mes/scheduling-manage/section-machine-part/module/stock.vue.js','纠正先前仅搜countLength遗漏get前缀的结论；backend补原Controller连接既有服务，不用重量或当前分页代替全量长度。'),
18:('unwired-unselected-print-catalog','四空URL handler最终key为projectManagementFee/innerCostMaterials/innerCostOther/innerCostManage；AST全views/modules及shared inline api-key无该按钮绑定。','src/shared/segments/062.fragment.js','原未提供数据的catalog保留，未对当前363补造报表。若以后启用必须显式补数据源或明确不可用；当前不发GET根页面。完整别名/字面调用见print-route-bindings.json。'),
19:('source-contract-repaired','AssetInjectionController原GET /getInjectionDetailDownload/{projectId}/{supplierId}要求第二路径段；原前端误放query。','src/shared/segments/062.fragment.js','TTe已补supplierId路径段，实际函数参数捕获测试通过；未伪造报表内容。'),
20:('inactive-dynamic-component','WNe.selfCollectionAndInvoiceInfo→PTe只在3个旧fund-account；当前闭包仅second-unit/self-healing，但父按钮全部g(record)，未选择fundAccount。','src/views/contract/standing-book/second-unit/self-healing/module/table.vue.js','与#46同一未打开分支，不能把目录存在当当前能点击。全alias→组件绑定见print-route-bindings.json，不接不同财务下载。'),
21:('outside-current-menu-print','WNe.mesStructureTeamWage/mesEnclosureTeamWage→V2e；真实动态key只由旧team-report/components/team-wage/header返回，chunk不在当前363菜单import闭包。','src/views/mes/team-report/components/team-wage/header.vue.js','当前新班组报表为group-team-report，不能将旧工资核算接口视为当前按钮缺口。别名AST及字面见print-route-bindings.json。'),
22:('outside-current-menu-print','WNe.mesStructureTeamWageDetail/mesEnclosureTeamWageDetail→w2e只在旧team-wage/detail，原chunk不在当前菜单闭包。','src/views/mes/team-report/components/team-wage/detail.vue.js','保留旧页扩展边界，不把全局catalog引用当当前请求。'),
23:('unselected-print-api-key','L2e经mt.schedulingDetail→WNe.mesSchedulingDetail；全业务文件和inline api-key无此最终key，当前计划详情schedulingDetailPrint为另一有效API。','src/views/plan/project-execution-dynamics/detail/scheduling-detail.vue.js','未改当前有效计划打印；原catalog名相似不证明业务请求。'),
24:('inactive-mode-print-branch','O2e套料工单打印只由#1同一k!==TASK_LIST条件引用；当前k始终1，无切换入口。','src/views/mes/work-order-manage/artifact/module/detail.vue.js','原通用catalog不是当前实际操作；不将普通工单打印冒充套料。'),
25:('outside-current-menu-print','WNe.mesWipStatisticsList→Wbe只由旧mes/task-tracking/wip-statistics/header绑定；该原chunk及父index都不在当前363菜单闭包。','src/views/mes/task-tracking/wip-statistics/module/header.vue.js','当前已配置semi-finished-statistics等是不同原页面/API，不新增旧progressing打印映射。'),
26:('controlled-extra-original-service','WNe.wagesReport→iVe只由旧production-wage-manage/wages-report/header绑定；该页及header均不在当前363菜单闭包。','src/views/mes/production-wage-manage/wages-report/module/header.vue.js','原MesYieldConfirmBizImpl.auditedWorkshopProcessTeamListPrint完整，后端按原mes_yield_confirm_audited_list:print恢复为额外受控服务；明确非363菜单必要缺口，不能声称当前菜单已点验此功能。'),
27:('inactive-legacy-crud','退货记录index中del:false且操作不暴露删除；仅CRUD定义q遗留。','src/views/wms/material-reject/raw-material/record/index.vue.js','不把删除改为撤销，业务语义不同。'),
28:('backend-original-service-reconnected','BG发票/付款结算真实选择合同回显get-inner；历史Controller与当前SupplierSettlementServiceImpl.getSupplierSettlementInner(737)协议一致。','src/views/supply-chain/purchase-order-bg/module/invoice-entry/header.vue.js','纠正只查Biz漏查完整Service的结论。backend恢复原GET映射及原pay_application或invoice_entry权限，保留原分页/筛选协议，不改为getSelfEmployed。'),
29:('backend-original-service-reconnected','自动领料冻结明细按钮按taskOrderId请求，原MaterialFreezeService完整但Controller漏映射。','src/views/wms/mes-receipt-review/module/auto-detail.vue.js','backend agent已补精确wms_mes_receipt_review:detail映射；前端null→[]已测试。最终4810运行映射已确认；具体冻结明细动作验收以独立后端QA报告为准。'),
30:('inactive-menu-integration-mode','当前BIM菜单model-show组件showMonomerModel默认为true；项目级集成分支要求false。','src/modules/bim-model-view-dbf77a11.js','原备份没有该项目集成GET路由；现有monomer/fileId分支不能冒充projectId集成。BIM转换引擎属于独立部署依赖。'),
31:('inactive-menu-integration-mode','着色状态只有showMonomerModel=false才调用getIntegrationArtifactStatus。','src/modules/bim-model-view-dbf77a11.js','true分支getArtifactStatus现有路由；不替换对象ID。'),
32:('inactive-menu-integration-mode','集成模型项目树getIntegrateMonomer只在集成分支。','src/modules/bim-model-view-dbf77a11.js','现有project/tree按fileId，不等价projectId模型集成。'),
33:('inactive-menu-integration-mode','构件信息false分支getIntegrateArtifactInfo。','src/modules/bim-model-view-dbf77a11.js','原无项目集成API，单体fileId正常分支另有接口。'),
34:('inactive-menu-integration-mode','编号搜索false分支getIntegrateArtifactSearch。','src/modules/bim-model-view-dbf77a11.js','原无项目集成搜索，保留外部BIM依赖边界。'),
35:('inactive-menu-integration-mode','构件生产信息false分支getIntegrateArtifactProduction。','src/modules/bim-model-view-dbf77a11.js','不能把projectId传给fileId端点。'),
36:('inactive-menu-integration-mode','状态明细false分支getIntegrateStatusDetail。','src/modules/bim-model-view-dbf77a11.js','原缺集成模式Controller；正常单体模式已有。'),
37:('inactive-menu-integration-mode','物流false分支getIntegrateLogistics。','src/modules/bim-model-view-dbf77a11.js','原缺集成模式Controller；不联网外部补取。'),
38:('conditional-original-bim-gap','图纸预览只有boolBim真才调用Ne(productId,productType)获取转换状态/viewToken。','src/modules/drawing-preview-fullscreen-dialog-60155503.js','当前恢复的37模块无product/bim映射；普通下载附件不能生成BIM viewToken。外部转换引擎缺失必须明确。'),
39:('unselected-export','parallel配置模块l编辑函数不在选定菜单导出绑定闭包。','src/modules/parallel-config-554d8028.js','现有GET/POST/DELETE配置正常，不新增未暴露编辑。'),
40:('backend-original-service-reconnected','当前行级及合并结算POST save-inner，原当前Service.addOaSupplierSettlement(SubOrderSettlementAddParam)240已保留。','src/modules/payment-settlement-e8e799d8.js','backend恢复历史原Controller映射/原pay_application权限。前端严格nested code+ledgerId后只打开原getFixedData(dataId,businessType=3)预览，草稿不等于OA提交；实际提交检查真实requestid及本地关联响应，草稿结果/OA提交及payload变更均有真实handler用例。'),
41:('overridden-legacy-crud','production-CreateProcess beforeRefresh每次用type选择有效v2 get替代旧get。','src/views/mes/production-config/workshopLine-config/production-CreateProcess/index.vue.js','原productProcess/page不会作为当前刷新请求。'),
42:('inactive-legacy-crud','同页optShow.add=false，实际创建/更新工序用独立已有API。','src/views/mes/production-config/workshopLine-config/production-CreateProcess/index.vue.js','保留旧CRUD定义，不当作真实新增缺口。'),
43:('inactive-legacy-crud','同页optShow.del=false；没有旧productProcess删除入口。','src/views/mes/production-config/workshopLine-config/production-CreateProcess/index.vue.js','不替换成不同partProcess/config/delete。'),
44:('source-contract-repaired','SysKitWmsCommonConfigController原@DeleteMapping /delete/{id}，前端m误用GET。','src/modules/project-config-5f01cdbc.js','已改DELETE并捕获实际请求验证。当前页面通常本地删行再整体保存，旧独立del即使复用也能正确匹配。'),
45:('inactive-menu-type-branch','当前菜单是purchase/partyA新版出库确认；旧raw review页未配置。原current-user-list中只有制成品才选择旧manuf-list，当前制成品仓库为独立V2。','src/views/wms/material-purchase/warehouse-management/material-outbound/raw-material/components/current-user-outbound-list/index.vue.js','气体/钢材/辅材/办公用品走新版list已有审批提交。不能接回旧passed绕新审批流。'),
46:('inactive-dynamic-component','三处旧CollectionInvoicing父fundAccount未有真正打开调用；二级self父表组件查表虽列fundAccount，但所有g按钮字面值均record。','src/views/contract/standing-book/second-unit/self-healing/module/table.vue.js','原collectionAndInvoiceDetail服务存在也不等于页面实际触发；已暂停增加财务接口。原basicinfoArray未定义位于同死分支，未编造配置。'),
47:('unselected-export','ship-list模块旧导出函数o不在当前菜单选定导出绑定闭包。','src/modules/ship-list-822ce00f.js','当前发运记录用新打印/下载接口；不恢复未开放旧导出。'),
48:('backend-original-service-reconnected','真实批量调拨表单basicClass OTHER分支be；原5类批量Controller遗漏办公用品，而原batchTransfer通用事务已支持。','src/views/wms/material-transfer/raw-material/components/transfer-batch-handling-form/index.vue.js','backend agent按原办公用品3权限+原BatchTransferDTOParam→batchTransfer(OTHER)补接，未前端循环单条。最终4810运行映射已确认；具体批量事务/权限动作验收以独立后端QA报告为准。')}
assert set(reviews)==set(range(1,49))
for item in ledger['items']:
 status,trigger,evidence,action=reviews[item['id']]
 proofs=[]
 for record in item['records']:
  original=source[record['original_chunk']];b=(root/'10-reverse/private/server/home/plm7/dist/static/js'/record['original_chunk']).read_bytes()
  assert hashlib.sha256(b).hexdigest()==original['original_sha256']
  normal=lambda x:re.sub(r'\s+','',x or '')
  api=[a for a in graph[record['original_chunk']]['api_calls'] if (a['method'] or '').upper()==record['method'] and normal(a.get('url_expression'))==normal(record['url_expression'])]
  proofs.append({'original_chunk':record['original_chunk'],'original_sha256':original['original_sha256'],'original_expression_match':bool(api),'original_expression_offsets':[a['source_offset'] for a in api]})
 item.update(status=status,trigger_analysis=trigger,evidence_source=evidence,action_and_boundary=action,original_artifact_proofs=proofs,browser_workflow_verified=False)
 item.pop('nearest',None) # Similar strings are not contract evidence.
 current_request=item['request']
 if item['id']==9:current_request='GET /api/v2/scm/purchase-order/PurchaseExcel/<dynamic>'
 if item['id']==19:current_request += '/<dynamic>'
 if item['id']==44:current_request=current_request.replace('GET ','DELETE ',1)
 method,url=current_request.split(' ',1);example=url.replace('<dynamic>','1')
 current_matches=[]
 for route in runtime['routes']:
  for route_path in route['paths']:
   pattern='^'+re.sub(r'\\\{[^}]+\\\}',r'[^/]+',re.escape(route_path))+'/?$'
   if (not route['methods'] or method in route['methods']) and re.match(pattern,example):current_matches.append({k:route.get(k) for k in ['paths','methods','controller','java_method','pre_authorize','params','headers','consumes','produces']})
 paths=[str((p/evidence).relative_to(root))]
 for match in current_matches:
  name=match['controller'].split('.')[-1] if match.get('controller') else ''
  paths.extend(str(f.relative_to(root)) for f in (root/'20-rebuild/backend/modules').rglob(name+'.java') if name)
 extra={
 1:['frontend-recovered/src/views/mes/work-order-manage/artifact/module/detail.vue.js'],
 7:['backend/modules/scim-mes-building-core/src/main/java/com/hzchum/scim/mes/building/core/service/impl/task/MesBuildingTaskServiceImpl.java','backend/modules/scim-mes-building-core/src/main/resources/mapper/task/MesBuildingTaskMapper.xml'],
 9:['frontend-recovered/src/shared/segments/016.fragment.js','frontend-recovered/src/shared/segments/017.fragment.js','frontend-recovered/src/views/supply-chain/purchase-order-bg/index.vue.js','backend/modules/scim-scm-core/src/main/java/com/hzchum/scim/scm/core/service/PurchaseOrderServiceImpl.java','acceptance/runtime/historical-source/recovered/com/hzchum/scim/scm/core/service/ScmLumpSumSystemPurchaseOrderServiceImpl.java'],
 11:['frontend-recovered/src/shared/segments/054.fragment.js','frontend-recovered/src/shared/segments/044.fragment.js','frontend-recovered/src/shared/segments/023.fragment.js','backend/modules/scim-scm-core/src/main/java/com/hzchum/scim/scm/core/service/PurchaseOrderServiceImpl.java','backend/modules/scim-scm-core-api/src/main/java/com/hzchum/scim/scm/core/api/pojo/dto/BriefPurchaseOrderDTO.java'],
 17:['backend/modules/scim-wms-core/src/main/java/com/hzchum/scim/wms/core/service/impl/wmsUse/MaterialInventoryServiceImpl.java','backend/modules/scim-wms-core-api/src/main/java/com/hzchum/scim/wms/core/api/service/wmsUse/MaterialInventoryService.java'],
 28:['backend/modules/scim-contract-core/src/main/java/com/hzchum/scim/contract/core/service/impl/SupplierSettlementServiceImpl.java'],
 40:['frontend-recovered/src/views/supply-chain/purchase-order-bg/module/line/index.vue.js','frontend-recovered/src/views/supply-chain/purchase-order-bg/module/payment-settlement/oa-approval/index.vue.js']}
 for rel in extra.get(item['id'],[]):
  if (root/'20-rebuild'/rel).is_file():paths.append('20-rebuild/'+rel)
 if item['id'] in [18,20,21,22,23,24,25,26]:paths.append('20-rebuild/frontend-recovered/print-route-bindings.json')
 item['source_evidence_paths']=sorted(set(paths))
 item['source_evidence_files']=[{'path':f,'sha256':hashlib.sha256((root/f).read_bytes()).hexdigest()} for f in item['source_evidence_paths']]

 item.update(records_scope='Preserved initial 48-pattern review baseline; repaired/current registration is tracked separately.',current_request=current_request,current_runtime_matches=current_matches)

ledger.update(status='final-runtime-source-reviewed-with-explicit-external-dependency-and-acceptance-boundaries',verified_at=datetime.datetime.now(datetime.timezone.utc).isoformat(),runtime_registration_sha256=hashlib.sha256(runtime_bytes).hexdigest(),runtime_registered_mappings=runtime['registered_mappings'],browser_acceptance_scope='See docs/full-menu-browser-smoke.json. Page loading does not verify these conditional actions.',classification_counts={s:sum(i['status']==s for i in ledger['items']) for s in sorted(set(i['status'] for i in ledger['items']))},limitations=['Type branches and disabled dialogs were reviewed in source; no new browser session was launched.','No nearby URL was substituted solely by spelling similarity.','Source reviews distinguish active buttons, inactive type/mode branches, and external dependencies. Source presence is not browser or workbook acceptance.'])
(p/'route-resolution-ledger.json').write_text(json.dumps(ledger,ensure_ascii=False,indent=2)+'\n')
lines=['# 当前菜单48项历史请求逐项核查','',f"运行快照：{runtime['registered_mappings']}条；SHA256 {ledger['runtime_registration_sha256']}。",'', '导入可达不等于用户能触发。下表保留原缺口和未验收动作，不能把363页加载通过解释为所有写入流程通过。','', '|序号|原请求|结论|实际触发条件/证据|处理与边界|','|---|---|---|---|---|']
for i in ledger['items']:lines.append('|'+str(i['id'])+'|`'+i['request']+'`|'+i['status']+'|'+i['trigger_analysis']+' `'+i['evidence_source']+'`|'+i['action_and_boundary']+'|')
(root/'20-rebuild/docs/current-menu-route-resolution.md').write_text('\n'.join(lines)+'\n')
print(json.dumps({'items':len(ledger['items']),'counts':ledger['classification_counts'],'original_expression_matches':sum(all(p['original_expression_match'] for p in i['original_artifact_proofs']) for i in ledger['items'])},ensure_ascii=False))
