const KC = { namespaced: true, state: xC, mutations: UC, actions: YC }, WC = Object.freeze(Object.defineProperty({ __proto__: null, default: KC }, Symbol.toStringTag, { value: "Module" }));
function jC(e) {
  return W({ module: "crm", url: "basics/config/skip/permissions", method: "get", cancelKey: false, params: e });
}
function FC(e) {
  return W({ module: "crm", url: "tender/request/config/skip/permissions", method: "get", params: e });
}
function zC(e) {
  return W({ module: "crm", url: "project/information/config/skip/permissions", method: "get", cancelKey: false, params: e });
}
function $st(e) {
  return W({ module: "crm", url: "page/management/config", method: "get", cancelKey: false, params: e });
}
function ert(e) {
  return W({ module: "crm", url: "business/license/information", method: "get", params: e });
}
function BC(e) {
  return W({ url: "/api/dept/all/simple", method: "get", params: e });
}
function trt(e) {
  return W({ module: "crm", url: "enterprise/warehousing/simple/info/list", method: "get", params: e });
}
function HC(e) {
  return W({ module: "crm", url: "project/information/warehousing/all/simple/list", method: "get", params: e });
}
function irt(e) {
  return W({ module: "crm", url: "bidding/center/getTenderList/custom", method: "get", params: e });
}
function art(e) {
  return W({ module: "crm", url: "bidding/center/getTenderListSummary/custom", method: "get", params: e });
}
function lrt(e) {
  return W({ module: "crm", url: "bidding/center/getTender/detail/custom", method: "get", params: e });
}
function ort(e) {
  return W({ module: "crm", url: "bidding/center/set/tender/head/custom", method: "post", data: e });
}
function nrt(e) {
  return W({ module: "crm", url: "bidding/center/archives/management/list/custom", method: "get", params: e });
}
function srt(e) {
  return W({ module: "crm", url: "bidding/center/project/documentation/list/custom", method: "get", params: e });
}
function rrt(e) {
  return W({ module: "crm", url: "bidding/center/downLoad/attachment", method: "get", responseType: "blob", params: e });
}
function urt(e) {
  return W({ module: "crm", url: "bidding/center/getMyTenderList/custom", method: "get", params: e });
}
function crt(e) {
  return W({ module: "crm", url: "bidding/center/getMyTenderListSummary/custom", method: "get", params: e });
}
function drt(e) {
  return W({ module: "crm", url: "bidding/center/details/of/the/project/leader/custom", method: "get", params: e });
}
function mrt(e) {
  return W({ module: "crm", url: "bidding/center/upload/tender/documents/custom", method: "post", data: e });
}
function prt(e) {
  return W({ module: "crm", url: "project/information/warehousing/can/update/project/list", method: "get", params: e });
}
function hrt(e) {
  return W({ module: "crm", url: "bidding/center/tender/detail/down/load/custom", method: "get", responseType: "blob", params: e });
}
function frt(e) {
  return W({ module: "crm", url: "bidding/center/update/bidding/status", method: "post", data: e });
}
const qC = { basicsLoaded: false, userLoaded: false, sectionLoaded: false, projectInformationLoaded: false, tenderApplicationLoaded: false, allProjectLoaded: false, basicsConfigMap: {}, userTreeList: [], sectionList: [], projectInformationMap: {}, tenderApplicationMap: {}, allProjectList: [] }, GC = { SET_BASICS_LOADED: (e, o) => {
  e.basicsLoaded = o;
}, SET_BASICS_CONFIG_MAP: (e, o) => {
  e.basicsConfigMap = o;
}, SET_USER_LOADED: (e, o) => {
  e.userLoaded = o;
}, SET_USER_TREE: (e, o) => {
  e.userTreeList = o;
}, SET_SECTION_LOADED: (e, o) => {
  e.sectionLoaded = o;
}, SET_SECTION_TREE: (e, o) => {
  e.sectionList = o;
}, SET_PROJECT_INFORMATION_LOADED: (e, o) => {
  e.projectInformationLoaded = o;
}, SET_PROJECT_INFORMATION_MAP: (e, o) => {
  e.projectInformationMap = o;
}, SET_TENDER_APPLICATION_LOADED: (e, o) => {
  e.tenderApplicationLoaded = o;
}, SET_TENDER_APPLICATION_MAP: (e, o) => {
  e.tenderApplicationMap = o;
}, SET_ALL_PROJECT_LOADED: (e, o) => {
  e.allProjectLoaded = o;
}, SET_ALL_PROJECT_LIST: (e, o) => {
  e.allProjectList = o;
} }, QC = { async fetchBasicsConfig({ commit: e }) {
  e("SET_BASICS_LOADED", false);
  const o = await jC(), n = Uo(o, "crmBasicsConfigEnum");
  e("SET_BASICS_CONFIG_MAP", n), e("SET_BASICS_LOADED", true);
}, async fetchUserTree({ commit: e }) {
  e("SET_USER_LOADED", false);
  const o = await pw();
  e("SET_USER_TREE", o), e("SET_USER_LOADED", true);
}, async fetchSectionTree({ commit: e }) {
  e("SET_SECTION_LOADED", false);
  const n = (await BC()).map((c) => (c.children.push({ id: c.id, name: c.name, children: [] }), c));
  e("SET_SECTION_TREE", n), e("SET_SECTION_LOADED", true);
}, async fetchProjectInformation({ commit: e }) {
  e("SET_PROJECT_INFORMATION_LOADED", false);
  const o = await zC(), n = Uo(o, "crmProjectInformationConfigEnum");
  e("SET_PROJECT_INFORMATION_MAP", n), e("SET_PROJECT_INFORMATION_LOADED", true);
}, async fetchTenderApplication({ commit: e }) {
  e("SET_TENDER_APPLICATION_LOADED", false);
  const o = await FC(), n = Uo(o, "crmTenderRequestConfigEnum");
  e("SET_TENDER_APPLICATION_MAP", n), e("SET_TENDER_APPLICATION_LOADED", true);
}, async fetchProjectAllList({ commit: e }) {
  e("SET_ALL_PROJECT_LOADED", false);
  const o = await HC();
  e("SET_ALL_PROJECT_LIST", o), e("SET_ALL_PROJECT_LOADED", true);
} }, ZC = { namespaced: true, state: qC, mutations: GC, actions: QC }, JC = Object.freeze(Object.defineProperty({ __proto__: null, default: ZC }, Symbol.toStringTag, { value: "Module" })), XC = { axiosCancelTokens: {} }, $C = { SET_AXIOS_CANCEL_TOKENS: (e, { cancelKey: o, source: n }) => {
  e.axiosCancelTokens[o] = n;
} }, eP = { setAxiosCancelTokens({ commit: e }, { cancelKey: o, source: n }) {
  e("SET_AXIOS_CANCEL_TOKENS", { cancelKey: o, source: n });
} }, tP = { namespaced: true, state: XC, mutations: $C, actions: eP }, iP = Object.freeze(Object.defineProperty({ __proto__: null, default: tP }, Symbol.toStringTag, { value: "Module" })), aP = { id: -2, name: "系统管理", children: [{ path: "/system", component: "Layout", hidden: false, name: "System", alwaysShow: true, redirect: "/system/dict", meta: { title: "系统配置", icon: "menu-list-SystemIcon", noCache: true }, children: [{ name: "Dict", path: "dict", hidden: false, component: "/system/dict/index", meta: { title: "字典管理", icon: "menu-list-DictIcon", noCache: true } }, { name: "Menu", path: "menu", hidden: false, component: "/system/menu/index", meta: { title: "菜单管理", icon: "menu-list-projectIcon", noCache: true } }, { name: "PermissionType", path: "permission-type", hidden: false, component: "/system/permission-type/index", meta: { title: "权限类型管理", icon: "menu-list-PermissionTypeIcon", noCache: true } }] }] }, kw = "/static/png/zhongnan-logo-white-f654e6d3.png", lP = "中南绿建", oP = kw, nP = kw, sP = { arrangement: nt.SERIAL_NUMBER_START.V, showProjectFullName: false, showSerialNumber: true }, rP = [{ component: "/bim/ifc-model-show/index", type: Ot, required: true }, { component: "/bim/model-show/index", type: Ot, required: true }, { component: "/bim/integration-model-show/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/ship-manage/pack-and-ship/warehouse-management/warehouse-induction/index", type: $e.STEEL.V, required: true }, { component: "/ship-manage/pack-and-ship/manual-pack/index", type: Ot, required: true }, { component: "/ship-manage/pack-and-ship/operation/common-operation-page/index", type: Ot, required: true }, { component: "/ship-manage/pack-and-ship/operation/structural-products/index", type: Ot, required: true }, { component: "/ship-manage/pack-and-ship/operation/enclosure-products/index", type: Ot, required: true }, { component: "/ship-manage/pack-and-ship/operation/supporting-products/index", type: Ot, required: true }, { component: "/ship-manage/pack-and-ship/ship-list/index", type: $e.STEEL.V | $e.ENCLOSURE.V | $e.BRIDGE.V, required: true }, { component: "/ship-manage/pack-and-ship/logistics-list/index", type: $e.STEEL.V | $e.ENCLOSURE.V | $e.BRIDGE.V, required: true }, { component: "/ship-manage/pack-and-ship/pack-list/index", type: Ot, required: true }, { component: "/ship-manage/pack-and-ship/receipt-status/index", type: $e.STEEL.V | $e.ENCLOSURE.V | $e.BRIDGE.V, required: true }, { component: "/ship-manage/pack-and-ship/ship-audit/index", type: $e.STEEL.V | $e.ENCLOSURE.V | $e.BRIDGE.V, required: true }, { component: "/ship-manage/pack-and-ship/ship-summary/auxiliary-material-ship-summary/index", type: $e.STEEL.V | $e.ENCLOSURE.V | $e.BRIDGE.V, required: false }, { component: "/ship-manage/pack-and-ship/product-send-receive-storage/structure/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/ship-manage/pack-and-ship/product-send-receive-storage/enclosure/index", type: $e.ENCLOSURE.V | $e.BRIDGE.V | $e.STEEL.V, required: false }, { component: "/ship-manage/pack-and-ship/product-send-receive-storage/box/index", type: $e.BRIDGE.V, required: false }, { component: "/mes/projects/index", type: Ot, required: true }, { component: "/mes/overall-plan/monomer/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/changed-manage/artifact/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/changed-manage/machine-part/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/changed-manage/assemble/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/changed-manage/common-change/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/changed-manage/simple-change-record/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/changed-manage/surplus-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/scheduling-manage/scheduling/assemble/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/artifact/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/machine-part-summary/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/enclosure/pressed-plate/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/enclosure/floor-plate/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/enclosure/truss-floor-plate/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/enclosure/sandwich-board/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/scheduling-manage/scheduling/enclosure/folding-piece/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/work-order-manage/machine-part/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/task-tracking/assistance-operate/productionLine-assistance/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/task-tracking/assistance-operate/process-assistance/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/scheduling-manage/task/artifact/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/scheduling-manage/task/machine-part/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/scheduling-manage/task/enclosure/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/report/machine-part/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/report/assemble/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/report/artifact/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/report/enclosure/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/analysis/production-statistics/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/analysis/delay-report/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/production-manage/dashboard/project-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/project-material/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/main-material-track/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/artifact-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/production-tracking/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/enclosure-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/project-report/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/assembly-match/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/painting/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/team-report/artifact-team/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/team-report/enclosure-team/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/team-report/artifact-team-wage/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/team-report/enclosure-team-wage/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/team-report/off-staff/wages-config/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/team-report/wages-adjust/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/QHSE-manage/disclosure/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/QHSE-manage/quality-inspection-report/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/label-print/artifact/index", type: Ot, required: true }, { component: "/mes/label-print/part/index", type: Ot, required: true }, { component: "/mes/label-print/auxiliary-material/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/factory-report/group-report/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-manage/dashboard/project-production-statistics/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/inbound-state/artifact-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/inbound-state/enclosure-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/outbound-state/artifact-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/outbound-state/enclosure-dashboard/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/warehouse-state/artifact/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/warehouse-state/enclosure/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/manufactures-manage/report/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/pack-and-ship/manual-pack/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/pack-and-ship/pack-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/pack-and-ship/ship-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/pack-and-ship/receipt-status/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/pack-and-ship/logistics-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/pack-and-ship/ship-audit/index", type: $e.STEEL.V | $e.BRIDGE.V, required: false }, { component: "/mes/craft-manage/artifact-specification-revise/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/production-line-wage-statistics/wage-adjust/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/work-order-manage/member-binding/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/changed-manage/finished-product-change/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/QHSE-manage/random-inspection-statistics/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/QHSE-manage/paint-film-thick-record/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/mes/group-team-report/capp-welding-record/index", type: Ot, required: true }, { component: "/mes/label-print/enclosure-products/index", type: Ot, required: true }, { component: "/mes/production-manage/dashboard/project-production-panel/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/technical-achievement/model/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/technical-achievement/drawing/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/technical-achievement/cnc/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/technical-achievement/xml/index", type: Ot, required: true }, { component: "/plan/overall-plan/monomer/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/project-list/index", type: Ot, required: true }, { component: "/plan/overall-plan/area/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/overall-plan/plan-make/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/overall-plan/plan-summary/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/overall-plan/plan-progress/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/overall-plan/plan-confirm/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/artifact-tree/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/artifact/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/machine-part/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/assembly/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/area-audit-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/enclosure-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/matching-item/index", type: Ot, required: true }, { component: "/plan/technical-manage/enclose-subitems/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/deepen/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/blueprint/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/change-file/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/model/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/other-file/index", type: Ot, required: true }, { component: "/plan/technical-data-manage/technical-achievement/process/index", type: Ot, required: false }, { component: "/plan/technical-manage/summary-list/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/steel-statistical/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/auxiliary-material/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/standard-part/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/technical-manage/auxiliary-material-summary/index", type: $e.STEEL.V | $e.BRIDGE.V, required: true }, { component: "/plan/material-preparation/project-preparation/index", type: Ot, required: false }, { component: "/plan/technical-manage/craft-manage/bind-craft/index", type: Ot, required: false }, { component: "/contract/contract-change/index", type: Ot, required: false }, { component: "/contract/contract-ledger/index", type: Ot, required: false }, { component: "/contract/collection-ledger/index", type: Ot, required: false }, { component: "/contract/collection-warn/index", type: Ot, required: false }, { component: "/contract/sales-manage/shipment-tracking/index", type: Ot, required: false }, { component: "/contract/sales-manage/price-manage/index", type: Ot, required: true }, { component: "/project-manage/progress-manage/project-progress/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/subcontract-manage/subcontract-plan/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/subcontract-manage/subcontract-progress/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/delivery-manage/homemade-delivery/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/delivery-manage/outsource-delivery/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/delivery-manage/outsourcing-return-record-old/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/delivery-manage/delivery-report/report-list/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/delivery-manage/delivery-report/report-dashboard/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/delivery-manage/delivery-install-list/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/install-manage/install-audit/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/install-manage/install-report/report-list/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/install-manage/install-report/install-dashboard/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/data-manage/image-progress/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/install-manage/handle-install/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/install-config/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/data-manage/construction-log/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/data-manage/construction-data/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/product-progress/index", type: Ot, required: true }, { component: "/project-manage/material-manage/self-made-receiving/index", type: Ot, required: true }, { component: "/project-manage/material-manage/outsourcing-receiving/index", type: Ot, required: true }, { component: "/project-manage/material-manage/outsourcing-return-record/index", type: Ot, required: true }, { component: "/project-manage/material-manage/receiving-record/index", type: Ot, required: true }, { component: "/project-manage/material-manage/send-and-receiving-report/index", type: Ot, required: true }, { component: "/project-manage/material-manage/issue-record/index", type: Ot, required: true }, { component: "/project-manage/labor-manage/roster-manage/index", type: Ot, required: true }, { component: "/project-manage/install-config/index", type: Ot, required: true }, { component: "/project-manage/labor-manage/attendance-manage/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/labor-setting/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/install-review/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/install-fill/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/install-dashboard/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/labor-install-report/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/project-install-statistics/index", type: Ot, required: true }, { component: "/project-manage/installation-manage/image-progress/index", type: Ot, required: true }, { component: "/project-manage/safety-quality-manage/security-quality-manage/index", type: Ot, required: true }, { component: "/project-manage/data-manage/construction-log/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/project-manage/install-report-config/install-report-setting/index", type: Ot, required: true }, { component: "/project-manage/data-manage/construction-data/index", type: Ot, required: true, businessType: xi.INSTALLATION.V }, { component: "/bridge/bridge-plan/box-list/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/bridge-plan/cell-part-list/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/bridge-plan/list-summary/box-summary/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/bridge-plan/list-summary/cell-summary/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/bridge-plan/list-summary/part-summary/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/work-order-manage/box/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/work-order-manage/machine-part/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/task-tracking/assistance-operate/productionLine-assistance/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/task-tracking/assistance-operate/process-assistance/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/production-manage/dashboard/project-dashboard/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/production-manage/dashboard/main-material-track/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/production-manage/dashboard/production-dashboard/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/production-manage/dashboard/assembly-match/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/production-manage/dashboard/painting/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/QHSE-manage/disclosure/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/QHSE-manage/quality-inspection-report/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/label-print/box/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/label-print/single-element/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/label-print/auxiliary-material/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/pack-and-ship/manual-pack/index", type: $e.BRIDGE.V, required: true }, { component: "/bridge/pack-and-ship/pack-list/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/pack-and-ship/ship-list/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/pack-and-ship/receipt-status/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/pack-and-ship/logistics-list/index", type: $e.BRIDGE.V, required: false }, { component: "/bridge/pack-and-ship/ship-audit/index", type: $e.BRIDGE.V, required: false }, { component: "/enclosure/enclosure-list-v2/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true, filterHasEnclosure: true }, { component: "/enclosure/enclosure-list/sandwich-board/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/enclosure/enclosure-list/profiled-plate/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/enclosure/enclosure-list/pressure-bearing-plate/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/enclosure/enclosure-list/truss-floor-plate/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/enclosure/enclosure-list/bending/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/enclosure/enclosure-list/standard-part/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true, filterHasEnclosure: true }, { component: "/enclosure/production-report/team-production/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: false }, { component: "/enclosure/production-report/type-analysis/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: false }, { component: "/enclosure/label-print/enclosure/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/enclosure/production-manage/change-approval/index", type: $e.STEEL.V | $e.BRIDGE.V | $e.ENCLOSURE.V, required: true }, { component: "/wms/mes-ship-receipt/application/index", type: Ot, required: true }], I2 = Xi.PROFILED_PLATE.V | Xi.TRUSS_FLOOR_PLATE.V | Xi.PRESSURE_BEARING_PLATE.V | Xi.SANDWICH_BOARD.V | Xi.BENDING.V, uP = [{ name: "MesSchedulingEnclosure", productType: I2 }, { name: "MesSchedulingPressedPlate", productType: Xi.PROFILED_PLATE.V }, { name: "MesSchedulingFloorPlate", productType: Xi.PRESSURE_BEARING_PLATE.V }, { name: "MesSchedulingTrussFloorPlate", productType: Xi.TRUSS_FLOOR_PLATE.V }, { name: "MesSchedulingSandwichBoard", productType: Xi.SANDWICH_BOARD.V }, { name: "MesSchedulingFoldingPiece", productType: Xi.BENDING.V }, { name: "MesTaskArtifact", productType: Xi.STRUCTURE.V, mode: ko.STRUCTURE.V | ko.STRUCTURE_ASSEMBLE.V }, { name: "MesTaskMachinePart", productType: Xi.STRUCTURE.V, mode: ko.STRUCTURE_ASSEMBLE.V }, { name: "MesTaskEnclosure", productType: I2 }, { name: "MesProductionReportMachinePart", mode: ko.STRUCTURE_ASSEMBLE.V }, { name: "MesProductionReportAssemble", mode: ko.STRUCTURE_ASSEMBLE.V | ko.STRUCTURE_ASSEMBLE.V }], cP = ["admin"];
function Ai(e) {
  if (Ae(e)) return true;
  if (e instanceof Array && e.length > 0) {
    const o = _e.getters.roles, n = [...cP, ...e];
    return !!o.some((u) => n.includes(u));
  } else throw new Error("权限解析失败，请传入数组结构");
}
function ds(e, o) {
  return am(o) ? o : am(e) ? e : dP(e, o);
}
function dP() {
  let e = "", o = false;
  for (var n = arguments.length - 1; n >= -1 && !o; n--) {
    var c = n >= 0 ? arguments[n] : process.cwd();
    if (typeof c != "string") throw new TypeError("Arguments to path.resolve must be strings");
    if (!c) continue;
    e = c + "/" + e, o = c.charAt(0) === "/";
  }
  return e = mP(pP(e.split("/"), function(u) {
    return !!u;
  }), !o).join("/"), (o ? "/" : "") + e || ".";
}
function mP(e, o) {
  for (var n = 0, c = e.length - 1; c >= 0; c--) {
    var u = e[c];
    u === "." ? e.splice(c, 1) : u === ".." ? (e.splice(c, 1), n++) : n && (e.splice(c, 1), n--);
  }
  if (o) for (; n--; n) e.unshift("..");
  return e;
}
function pP(e, o) {
  if (e.filter) return e.filter(o);
  for (var n = [], c = 0; c < e.length; c++) o(e[c], c, e) && n.push(e[c]);
  return n;
}
const $l = { APPLICATION: { L: "入库提交时填写", K: "APPLICATION", V: 1 }, REVIEWING: { L: "入库审核时填写", K: "REVIEWING", V: 2 } };
ve($l);
const J1 = { TRUE: { L: "显示", K: "TRUE", V: true }, FALSE: { L: "不显示", K: "FALSE", V: false } };
ve(J1);
const Sl = { MODIFY: { L: "显示且可修改", K: "MODIFY", V: 2 }, SHOW: { L: "显示且不可修改", K: "SHOW", V: 1 }, UNSHOW: { L: "不显示", K: "UNSHOW", V: 0 } };
ve(Sl);
const X1 = { TRUE: { L: "不合并", K: "TRUE", V: true }, FALSE: { L: "合并", K: "FALSE", V: false } };
ve(X1);
const Aa = { INVENTORY_SUBMISSION: { L: "入库提交时填写", K: "INVENTORY_SUBMISSION", V: 1 }, INVENTORY_REVIEW: { L: "入库审核时填写", K: "INVENTORY_REVIEW", V: 2 } };
ve(Aa);
const $1 = { REQUIRED: { L: "必填", K: "REQUIRED", V: true }, OPTIONAL: { L: "选填", K: "OPTIONAL", V: false } };
ve($1);
const bn = { YES: { L: "是", K: "YES", V: true }, NO: { L: "否", K: "NO", V: false } };
ve(bn);
const eE = { REVIEWING: { L: "审核后通过", K: "REVIEWING", V: 1 }, APPLICATION: { L: "提交即通过", K: "APPLICATION", V: 2 } };
ve(eE);
const kl = { RETURN_TO_ORIGINAL_LOCATION: { L: "按出库原路返回", K: "RETURN_TO_ORIGINAL_LOCATION", V: 1 }, RETURN_TO_PUBLIC_LIBRARY: { L: "直退至公共库", K: "RETURN_TO_PUBLIC_LIBRARY", V: 2 } };
ve(kl);
const tE = { WHOLE: { L: "全库加权", K: "WHOLE", V: 1 }, SINGLE: { L: "单库加权", K: "SINGLE", V: 2 } };
ve(tE);
const hi = { MEASURE: { L: "计量", K: "MEASURE", V: 1 }, ACCOUNTING: { L: "核算", K: "ACCOUNTING", V: 2 } };
