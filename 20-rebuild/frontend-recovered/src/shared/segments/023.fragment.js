function Lst(e, o, n) {
  return W({ module: "contract", url: `project/${e}/status/${o}?isCheckOutFinishStatus=${n}`, method: "put" });
}
function Ist(e, o) {
  return W({ module: "contract", url: `project/${e}/users`, method: "put", data: o });
}
function Cst(e) {
  return W({ url: "/api/project/listByType/" + e, method: "get", cancelKey: false });
}
function Pst(e) {
  return W({ module: "contract", url: `user/project/${e}/all/simple`, method: "get" });
}
function Ost(e) {
  return W({ module: "contract", url: `project/${e}/base`, method: "get" });
}
function kst(e) {
  return W({ module: "contract", url: `project/v2/${e}/business`, method: "get" });
}
function Dst(e) {
  return W({ module: "contract", url: `project/${e}/customer`, method: "get" });
}
function xst(e) {
  return W({ module: "contract", url: `project/techDisclosure/${e}`, method: "get" });
}
function pC() {
  return W({ module: "contract", url: "branchCompany/all/simple", method: "get" });
}
function Pw() {
  return W({ url: "/api/branchCompany/purchaseByLevelList", method: "get" });
}
function Ust({ id: e }) {
  return W({ module: "contract", url: `common/attachment/download/${e}`, method: "get", timeout: 6e6, responseType: "blob" });
}
function Yst() {
  return W({ module: "contract", url: "project/getOutFinishCount", method: "get" });
}
function Kst({ projectId: e }) {
  return W({ module: "contract", url: `project/${e}/export`, method: "get", timeout: 6e6, responseType: "blob" });
}
function Wst(e) {
  return W({ module: "contract", url: "project/projectStatistics", method: "get" });
}
function hC(e) {
  return W({ module: "scm_V2", url: "purchase-order/selectProjectName", method: "get", params: e });
}
function jst(e) {
  return W({ module: "contract", url: "project/get/contract/amount/sum", method: "get", params: e });
}
function Fst(e) {
  return W({ url: "/api/project/down/load/import/project/template", responseType: "blob", method: "get", params: e });
}
function zst(e) {
  return W({ url: "/api/project/import/project", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
const Bst = { get: rC, add: cC, del: mC, edit: dC, detail: uC };
function Hst() {
  return W({ url: "/api/menu/list-module", method: "get" });
}
function fC() {
  return W({ url: "/api/system/module-decimal-scale/all", method: "get" });
}
function gC() {
  return W({ url: "/api/system/module-decimal-scale", method: "get" });
}
function EC(e) {
  return W({ url: "/api/system/module-decimal-scale", method: "post", data: e.list });
}
function yC(e) {
  return W({ url: "/api/system/module-decimal-scale", method: "post", data: e });
}
function TC(e) {
  return W({ url: "/api/system/module-decimal-scale", method: "delete", data: e });
}
const qst = { get: gC, batchAdd: yC, add: EC, del: TC };
function Ow() {
  return W({ url: "/api/contract/config/filedConfig", method: "get", cancelKey: false });
}
function _C(e) {
  return W({ url: "/api/contract/config/filedConfig", method: "post", data: e });
}
function bC(e) {
  return W({ url: "/api/contract/config/filedConfig", method: "post", data: e });
}
function VC(e) {
  return W({ url: "/api/contract/config/filedConfig", method: "put", data: e });
}
function wC(e) {
  return W({ url: "/api/contract/config/filedConfig", method: "delete", data: e });
}
const Gst = { get: Ow, add: _C, batchAdd: bC, edit: VC, del: wC };
function SC(e) {
  return W({ module: "bridge", url: "workshop", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function vC(e) {
  return W({ url: "/api/mes/bridge/process", method: "get", params: e });
}
function RC(e) {
  return W({ module: "bridge", url: "team", method: "get", params: e });
}
function MC(e) {
  return W({ module: "bridge", url: "inspectionTeam", method: "get", params: e });
}
function AC(e) {
  return W({ module: "bridge", url: "productionLine", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function NC(e) {
  return W({ module: "bridge", url: "factory/production_line_group", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function LC() {
  return W({ module: "bridge", url: "cut/list/cut", method: "get" });
}
function Qst(e) {
  return W({ module: "bridge", url: "package/list", method: "get", params: e });
}
function Zst({ areaId: e, monomerId: o, productType: n }) {
  return W({ module: "bridge", url: "task/productionLine/hasTask", method: "get", params: { areaId: e, monomerId: o, productType: n } });
}
function IC(e) {
  return W({ url: "/api/enclosure/dictionary", method: "get", params: e });
}
function CC(e) {
  return W({ module: "plan", url: "cappCraftCardDictItem/list", method: "get", params: e });
}
function PC(e) {
  return W({ module: "plan", url: "cappCraftCardDictItem/add", method: "post", data: e });
}
function OC(e) {
  return W({ module: "plan", url: "cappCraftCardDictItem/update", method: "post", data: e });
}
function kC(e) {
  return W({ module: "plan", url: `cappCraftCardDictItem/delete?id=${e}`, method: "post" });
}
function DC() {
  return W({ module: "plan", cancleKey: false, url: "cappCraftCardDictItem/options", method: "get" });
}
function Jst(e) {
  return W({ module: "plan", url: "cappCraftCardDictItem/updateEnabledFlag", method: "post", params: e });
}
const Xst = { get: CC, batchAdd: PC, edit: OC, del: kC }, xC = { clsTree: [], matClsTree: [], firstLevelSubjectTree: [], rawMatClsTree: [], manufClsTree: [], matClsList: [], rawMatClsList: [], manufClsList: [], rawMatClsKV: {}, matClsLeafList: [], rawMatClsLeafList: [], manufClsLeafList: [], getTreeClickTime: void 0, classifySpec: { specKV: {} }, dict: {}, cappDict: {}, cappDictMap: {}, company: { companyName: "", companyNo: "", telephone: "", website: "", logo: "" }, watermark: { boolEnableWatermark: void 0, fontSize: 4, spacing: 35, transparency: 0.2, angle: -30 }, approvalCfg: {}, unit: { ALL: [], GROUP: [], MAP: /* @__PURE__ */ new Map(), KS: /* @__PURE__ */ new Map() }, mesWarehouseConfig: {}, factories: [], factoryKV: {}, manufWarehouse: [], warehouse: [], workshopName: [], workshopNameKV: {}, mesWorkShopName: [], warehouseV2: [], workshopNameV2: [], workshopNameV2KV: {}, workshopNameV3: [], workshopNameV3KV: {}, workshops: [], workshopKV: {}, purchaseWorkshop: [], bridgeWorkshops: [], productLines: [], bridgeProductLines: [], productionTeam: [], productionTeamKV: {}, bridgeProductionTeam: [], bridgeProductionTeamKV: {}, inspectionTeam: [], inspectionTeamKV: {}, bridgeInspectionTeam: [], bridgeInspectionTeamKV: {}, onlyProductLines: [], enclosureProductLines: [], bridgeOnlyProductLines: [], cutConfigs: [], cutConfigKV: {}, bridgeCutConfigs: [], bridgeCutConfigKV: {}, process: [], bridgeProcess: [], users: [], dept: [], userDeptTree: [], regional: [], catalogRegional: [], annualSupplier: [], annualSupplierKV: {}, suppliers: [], supplierKV: {}, wmsSuppliers: [], wmsSupplierKV: {}, taxRateKV: {}, unclosedRequisitions: [], unclosedPurchaseOrder: [], purchaseOrders: [], purchaseOrderKV: {}, monomers: {}, changeReasonConfig: [], steelClassifyConf: [], steelClassifyConfICKV: {}, subcontractType: [], qualityProblemType: [], visaReason: [], decimalPrecision: {}, steelMinLengthConfig: {}, sectionAll: {}, filterItemsEnum: {}, BusinessModuleEnum: {}, branchCompanyEnum: [], supplyUsedProject: [], enclosureList: [], catalogContentConfig: {}, closeTimes: [], closeTimeConfig: fr(), loaded: { company: false, watermark: false, factories: false, warehouse: false, warehouseV2: false, workshops: false, purchaseWorkshop: false, bridgeWorkshops: false, productionTeam: false, bridgeProductionTeam: false, inspectionTeam: false, bridgeInspectionTeam: false, productLines: false, enclosureProductLines: false, bridgeProductLines: false, onlyProductLines: false, bridgeOnlyProductLines: false, cutConfigs: false, bridgeCutConfigs: false, process: false, bridgeProcess: false, mesWarehouseConfig: false, manufWarehouse: false, users: false, dept: false, unit: false, userDeptTree: false, matClsTree: false, clsTree: false, suppliers: false, wmsSuppliers: false, taxRate: false, approvalCfg: false, unclosedRequisitions: false, unclosedPurchaseOrder: false, purchaseOrders: false, changeReasonConfig: false, steelClassifyConf: false, subcontractType: false, qualityProblemType: false, visaReason: false, workshopName: false, workshopNameV2: false, workshopNameV3: false, decimalPrecision: false, steelMinLengthConfig: false, sectionAll: false, filterItemsEnum: false, cappDict: false, BusinessModuleEnum: false, branchCompanyEnum: false, supplyUsedProject: false, enclosureList: false, catalogContentConfig: false, catalogRegional: false, closeTimes: false } }, UC = { SET_LOADED(e, { key: o, loaded: n = true }) {
  e.loaded[o] = n;
}, SET_COMPANY: (e, o = {}) => {
  e.company = Object.assign(e.company, o);
}, SET_WATERMARK: (e, o = {}) => {
  e.watermark = Object.assign(e.watermark, o);
}, SET_TAX_RATE(e, o = []) {
  e.taxRateKV = {}, o.forEach((n) => {
    e.taxRateKV[n.classification] = n.taxRateList;
  });
}, SET_CLICK_TIME(e, o) {
  e.getTreeClickTime = o;
}, SET_MAT_CLS_TREE(e, o = []) {
  e.matClsTree = o, e.firstLevelSubjectTree = o.map((u) => ({ basicClass: u.basicClass, id: u.id, name: u.name, boolStatus: u.boolStatus })), e.rawMatClsTree = o.filter((u) => ![Ge.STRUC_MANUFACTURED.V, Ge.ENCL_MANUFACTURED.V].includes(u.basicClass)), e.manufClsTree = o.filter((u) => [Ge.STRUC_MANUFACTURED.V, Ge.ENCL_MANUFACTURED.V].includes(u.basicClass));
  const n = Rw(o);
  e.matClsList = n, e.rawMatClsList = n.filter((u) => ![Ge.STRUC_MANUFACTURED.V, Ge.ENCL_MANUFACTURED.V].includes(u.basicClass)), e.manufClsList = n.filter((u) => [Ge.STRUC_MANUFACTURED.V, Ge.ENCL_MANUFACTURED.V].includes(u.basicClass)), e.rawMatClsKV = Uo(n, "id");
  const c = vw(o);
  e.matClsLeafList = c, e.rawMatClsLeafList = c.filter((u) => ![Ge.STRUC_MANUFACTURED.V, Ge.ENCL_MANUFACTURED.V].includes(u.basicClass)), e.manufClsLeafList = c.filter((u) => [Ge.STRUC_MANUFACTURED.V, Ge.ENCL_MANUFACTURED.V].includes(u.basicClass)), e.getTreeClickTime = (/* @__PURE__ */ new Date()).getTime();
}, SET_APPROVAL_CFG(e, o) {
  e.approvalCfg = o;
}, SET_CLS_TREE(e, o = []) {
  e.clsTree = o;
}, SET_UNIT(e, o) {
  e.unit = o;
}, SET_FACTORIES(e, o = []) {
  e.factories = o, e.factoryKV = {}, o.forEach((n) => {
    e.factoryKV[n.id] = n;
  });
}, SET_WORKSHOPS(e, o) {
  e.workshops = o, e.workshopKV = {}, o.forEach((n) => {
    e.workshopKV[n.id] = n;
  });
}, SET_PURCHASE_WORKSHOP(e, o) {
  e.purchaseWorkshop = o;
}, SET_BRIDGE_WORKSHOPS(e, o) {
  e.bridgeWorkshops = o;
}, SET_WAREHOUSE(e, o) {
  e.warehouse = o;
}, SET_MANUF_WAREHOUSE(e, o) {
  e.manufWarehouse = o;
}, SET_MES_WAREHOUSE_CONFIG(e, o) {
  e.mesWarehouseConfig = o;
}, SET_WORKSHOP_NAME(e, o) {
  e.workshopName = o, e.workshopNameKV = {}, e.mesWorkShopName = [], o.forEach((n) => {
    n.tagColor = n.workshopId ? "#409eff" : "#e6a23c", e.workshopNameKV[n.id] = n, n.workshopId && e.mesWorkShopName.push(n);
  });
}, SET_WAREHOUSE_V2(e, o) {
  e.warehouseV2 = o;
}, SET_WORKSHOP_NAME_V2(e, o) {
  e.workshopNameV2 = o, e.workshopNameV2KV = {}, e.mesWorkShopName = [], o.forEach((n) => {
    e.workshopNameV2KV[n.id] = n;
  });
}, SET_WORKSHOP_NAME_V3(e, o) {
  e.workshopNameV3 = o, e.workshopNameV3KV = {}, e.mesWorkShopName = [], o.forEach((n) => {
    e.workshopNameV3KV[n.id] = n;
  });
}, SET_PRODUCTION_TEAM(e, o) {
  e.productionTeam = o, e.productionTeamKV = {}, o.forEach((n) => {
    e.productionTeamKV[n.id] = n;
  });
}, SET_BRIDGE_PRODUCTION_TEAM(e, o) {
  e.bridgeProductionTeam = o, e.bridgeProductionTeamKV = {}, o.forEach((n) => {
    e.bridgeProductionTeamKV[n.id] = n;
  });
}, SET_INSPECTION_TEAM(e, o) {
  e.inspectionTeam = o, e.inspectionTeamKV = {}, o.forEach((n) => {
    e.inspectionTeamKV[n.id] = n;
  });
}, SET_BRIDGE_INSPECTION_TEAM(e, o) {
  e.bridgeInspectionTeam = o, e.bridgeInspectionTeamKV = {}, o.forEach((n) => {
    e.bridgeInspectionTeamKV[n.id] = n;
  });
}, SET_PRODUCT_LINES(e, o) {
  e.productLines = o;
}, SET_ENCLOSURE_PRODUCT_LINES(e, o) {
  e.enclosureProductLines = o;
}, SET_BRIDGE_PRODUCT_LINES(e, o) {
  e.bridgeProductLines = o;
}, SET_ONLY_PRODUCT_LINES(e, o) {
  e.onlyProductLines = o;
}, SET_BRIDGE_ONLY_PRODUCT_LINES(e, o) {
  e.bridgeOnlyProductLines = o;
}, SET_CUT_CONFIGS(e, o) {
  e.cutConfigs = o, e.cutConfigKV = {};
}, SET_BRIDGE_CUT_CONFIGS(e, o) {
  e.bridgeCutConfigs = o, e.bridgeCutConfigKV = {};
}, SET_PROCESS(e, o) {
  e.process = o;
}, SET_BRIDGE_PROCESS(e, o) {
  e.bridgeProcess = o;
}, SET_USERS(e, o) {
  e.users = o;
}, SET_SUPPLIERS(e, o) {
  e.suppliers = o, e.supplierKV = {}, o.forEach((n) => {
    e.supplierKV[n.id] = n;
  });
}, SET_ANNUAL_SUPPLIERS(e, o) {
  e.annualSuppliers = o, e.annualSupplierKV = {}, o.forEach((n) => {
    e.annualSupplierKV[n.id] = n;
  });
}, SET_WMS_SUPPLIERS(e, o) {
  e.wmsSuppliers = o, e.wmsSupplierKV = {}, o.forEach((n) => {
    e.wmsSupplierKV[n.id] = n;
  });
}, SET_DEPT(e, o) {
  e.dept = o;
}, SET_USER_DEPT_TREE(e, o) {
  e.userDeptTree = o;
}, SET_REGIONAL(e, o) {
  e.regional = o;
}, SET_CATALOG_REGIONAL(e, o) {
  e.catalogRegional = o || [];
}, SET_UNCLOSED_REQUISITIONS(e, o) {
  e.unclosedRequisitions = o;
}, SET_UNCLOSED_PURCHASE_ORDER(e, o) {
  e.unclosedPurchaseOrder = o;
}, SET_PURCHASE_ORDERS(e, o) {
  e.purchaseOrders = o, e.purchaseOrderKV = {}, o.forEach((n) => {
    e.purchaseOrderKV[n.id] = n;
  });
}, SET_CHANGE_REASON_CONFIG(e, o) {
  e.changeReasonConfig = o;
}, SET_STEEL_CLASSIFY_CONF(e, o) {
  e.steelClassifyConf = o, e.steelClassifyConfKV = {}, e.steelClassifyConfICKV = {}, o.forEach((n) => {
    e.steelClassifyConfKV[n.id] = n, e.steelClassifyConfICKV[n.id] = n.boundFinalClassifyIds;
  });
}, SET_SUBCONTRACT_TYPE(e, o) {
  e.subcontractType = o;
}, SET_QUALITY_PROBLEM_TYPE(e, o) {
  e.qualityProblemType = o;
}, SET_VISA_REASON(e, o) {
  e.visaReason = o;
}, SET_DECIMAL_PRECISION(e, o) {
  e.decimalPrecision = o;
}, SET_STEEL_MINLENGTH_CONFIG(e, o) {
  e.steelMinLengthConfig = o;
}, SET_CLASS_ALL(e, o) {
  e.classAll = o;
}, FILTER_ITEMS_ENUM(e, o) {
  e.filterItemsEnum = o;
}, BUSINESS_MODULE_ENUM(e, o) {
  e.BusinessModuleEnum = o;
}, SET_BRANCH_COMPANY_ENUM(e, o) {
  e.branchCompanyEnum = o;
}, SET_SUPPLY_USED_PROJECT(e, o) {
  e.supplyUsedProject = o;
}, SET_SECTION_ALL(e, o) {
  e.sectionAll = o;
}, SET_ENCLOSURE_LIST(e, o) {
  e.enclosureList = o;
}, SET_CLOSE_TIMES(e, o) {
  e.closeTimes = o;
}, SET_CLOSE_TIME_CONFIG(e, o) {
  e.closeTimeConfig = o;
}, SET_CAPP_DICT(e, o, n) {
  e.cappDict = o, e.cappDictMap = n;
}, SET_CATALOG_CONTENT_CONFIG(e, o) {
  e.catalogContentConfig = o;
} }, YC = { async fetchConfigInfo({ dispatch: e, commit: o }) {
  console.log("TODO：加载配置文件");
  const n = await $N();
  await e("settings/changeSetting", /* @__PURE__ */ new Map([["projectNameShowConfig", n]]), { root: true });
  const c = await e5();
  o("SET_WATERMARK", c);
}, async fetchCompany({ commit: e }) {
  var u;
  const o = await WL() || {};
  e("SET_COMPANY", o);
  const { content: n = [] } = await jL(), c = n.findIndex((r) => r.isDefault);
  c !== -1 && e("SET_COMPANY", { logo: (u = n[c]) == null ? void 0 : u.path });
}, setCompany({ commit: e }, o = {}) {
  e("SET_COMPANY", o);
}, async fetchTaxRate({ commit: e }) {
  const { content: o = [] } = await xL();
  return e("SET_TAX_RATE", o), e("SET_LOADED", { key: "taxRate" }), o;
}, async fetchApprovalCfg({ commit: e }) {
  const o = await KL();
  return e("SET_APPROVAL_CFG", { requisition: o }), e("SET_LOADED", { key: "approvalCfg" }), { requisition: o };
}, async fetchTreeClickTime({ commit: e }) {
  const o = (/* @__PURE__ */ new Date()).getTime();
  return e("SET_CLICK_TIME", o), o;
}, async fetchMatClsTree({ commit: e }) {
  const o = await $5(), n = L2(o);
  return e("SET_MAT_CLS_TREE", n), e("SET_LOADED", { key: "matClsTree" }), n;
}, async fetchClassificationTree({ commit: e }) {
  const o = await tL(), n = L2(o);
  return e("SET_CLS_TREE", n), e("SET_LOADED", { key: "clsTree" }), n;
}, async fetchDict({ state: e }, o = []) {
  const n = [], c = e.dict;
  "dict" in c || (c.dict = {}), "label" in c || (c.label = {});
  for (const u of o) {
    const r = sL(u).then((E) => {
      const y = E.content || [];
      c[u] = [...y], c.dict[u] = {}, c.label[u] = {}, y.forEach((b) => {
        c.dict[u][b.value] = b, c.label[u][b.value] = b.label;
      });
    });
    n.push(r);
  }
  await Promise.all(n);
}, async fetchUnit({ commit: e }) {
  const o = await mL() || [], n = { ALL: [], GROUP: [], MAP: /* @__PURE__ */ new Map(), KS: /* @__PURE__ */ new Map() };
  Object.keys(Ka.ENUM).forEach((c) => {
    n[c] = [];
  }), o.forEach((c) => {
    const u = { id: c.id, name: c.name, type: c.type, symbol: c.symbol, enabled: c.enabled };
    n.ALL.push(u), n.MAP.set(u.name, u), u.symbol && n.MAP.set(u.symbol, u), n.KS.set(u.name, u.symbol || u.name), n[Ka.VK[u.type]].push(u);
  }), Object.keys(Ka.ENUM).forEach((c) => {
    n.GROUP.push({ name: Ka[c].L, type: c, options: n[c] });
  }), n.symbol = (c) => n.KS.get(c), e("SET_UNIT", n), e("SET_LOADED", { key: "unit" });
}, async fetchFactories({ commit: e }) {
  const { content: o = [] } = await gL();
  return e("SET_FACTORIES", o), e("SET_LOADED", { key: "factories" }), o;
}, async fetchWorkshopName({ commit: e }) {
  const o = await aI() || [];
  return e("SET_WORKSHOP_NAME", o), e("SET_LOADED", { key: "workshopName" }), o;
}, async fetchMesWarehouseConfig({ commit: e }) {
  const o = await vL() || [];
  return e("SET_MES_WAREHOUSE_CONFIG", o), e("SET_LOADED", { key: "mesWarehouseConfig" }), o;
}, async fetchManufWarehouse({ commit: e }) {
  const { content: o } = await SL() || [];
  return e("SET_MANUF_WAREHOUSE", o), e("SET_LOADED", { key: "manufWarehouse" }), o;
}, async fetchWarehouse({ commit: e }) {
  const o = await JL() || [];
  return e("SET_WAREHOUSE", o), e("SET_LOADED", { key: "warehouse" }), o;
}, async fetchWorkshopNameV2({ commit: e }) {
  const o = await uI() || [];
  return e("SET_WORKSHOP_NAME_V2", o), e("SET_LOADED", { key: "workshopNameV2" }), o;
}, async fetchWorkshopNameV3({ commit: e }) {
  const o = await cI() || [];
  return e("SET_WORKSHOP_NAME_V3", o), e("SET_LOADED", { key: "workshopNameV3" }), o;
}, async fetchWarehouseV2({ commit: e }) {
  const o = await dI() || [];
  return e("SET_WAREHOUSE_V2", o), e("SET_LOADED", { key: "warehouseV2" }), o;
}, async fetchWorkshops({ commit: e }) {
  const { content: o = [] } = await EL();
  return e("SET_WORKSHOPS", o), e("SET_LOADED", { key: "workshops" }), o;
}, async fetchPurchaseWorkshop({ commit: e }) {
  const o = await D5() || [];
  return e("SET_PURCHASE_WORKSHOP", o), e("SET_LOADED", { key: "purchaseWorkshop" }), o;
}, async fetchBridgeWorkshops({ commit: e }) {
  const { content: o = [] } = await SC();
  return e("SET_BRIDGE_WORKSHOPS", o), e("SET_LOADED", { key: "bridgeWorkshops" }), o;
}, async fetchProductionTeam({ commit: e }) {
  const { content: o = [] } = await TL(), n = o.map((c) => {
    var u, r, E, y;
    return c.leaderName = (u = c.userLinkList.find((b) => b.boolLeaderEnum)) == null ? void 0 : u.userName, c.memberNames = (y = (E = (r = c.userLinkList) == null ? void 0 : r.filter((b) => !b.boolLeaderEnum)) == null ? void 0 : E.map((b) => b.userName)) == null ? void 0 : y.join(", "), c.label = `${c.leaderName} - ${c.processName}`, c;
  });
  return e("SET_PRODUCTION_TEAM", n), e("SET_LOADED", { key: "productionTeam" }), o;
}, async fetchBridgeProductionTeam({ commit: e }) {
  const { content: o = [] } = await RC(), n = o.map((c) => {
    var u, r, E, y;
    return c.leaderName = (u = c.userLinkList.find((b) => b.boolLeaderEnum)) == null ? void 0 : u.userName, c.memberNames = (y = (E = (r = c.userLinkList) == null ? void 0 : r.filter((b) => !b.boolLeaderEnum)) == null ? void 0 : E.map((b) => b.userName)) == null ? void 0 : y.join(", "), c.label = `${c.leaderName} - ${c.processName}`, c;
  });
  return e("SET_BRIDGE_PRODUCTION_TEAM", n), e("SET_LOADED", { key: "bridgeProductionTeam" }), o;
}, async fetchInspectionTeam({ commit: e }) {
  const { content: o = [] } = await _L(), n = o.map((c) => {
    var u, r;
    return c.inspectorNames = (r = (u = c.userLinkList) == null ? void 0 : u.map((E) => E.userName)) == null ? void 0 : r.join(", "), c;
  });
  return e("SET_INSPECTION_TEAM", n), e("SET_LOADED", { key: "inspectionTeam" }), o;
}, async fetchBridgeInspectionTeam({ commit: e }) {
  const { content: o = [] } = await MC(), n = o.map((c) => {
    var u, r;
    return c.inspectorNames = (r = (u = c.userLinkList) == null ? void 0 : u.map((E) => E.userName)) == null ? void 0 : r.join(", "), c;
  });
  return e("SET_BRIDGE_INSPECTION_TEAM", n), e("SET_LOADED", { key: "bridgeInspectionTeam" }), o;
}, async fetchProductLines({ commit: e }) {
  const { content: o = [] } = await VL();
  return e("SET_PRODUCT_LINES", o), e("SET_LOADED", { key: "productLines", loaded: true }), o;
}, async fetchBridgeProductLines({ commit: e }) {
  const { content: o = [] } = await NC();
  return e("SET_BRIDGE_PRODUCT_LINES", o), e("SET_LOADED", { key: "bridgeProductLines", loaded: true }), o;
}, async fetchEnclosureProductLines({ commit: e }) {
  const { content: o = [] } = await Tw();
  return e("SET_ENCLOSURE_PRODUCT_LINES", o), e("SET_LOADED", { key: "enclosureProductLines", loaded: true }), o;
}, async fetchOnlyProductLines({ commit: e }) {
  const { content: o = [] } = await bL();
  return e("SET_ONLY_PRODUCT_LINES", o), e("SET_LOADED", { key: "onlyProductLines", loaded: true }), o;
}, async fetchBridgeOnlyProductLines({ commit: e }) {
  const { content: o = [] } = await AC();
  return e("SET_BRIDGE_ONLY_PRODUCT_LINES", o), e("SET_LOADED", { key: "bridgeOnlyProductLines", loaded: true }), o;
}, async fetchCutConfig({ commit: e }) {
  const o = await wL({ boolNestCutEnum: false }) || [];
  return e("SET_CUT_CONFIGS", o), e("SET_LOADED", { key: "cutConfigs", loaded: true }), o;
}, async fetchBridgeCutConfig({ commit: e }) {
  const o = await LC() || [];
  return e("SET_BRIDGE_CUT_CONFIGS", o), e("SET_LOADED", { key: "bridgeCutConfigs", loaded: true }), o;
}, async fetchProcess({ commit: e }) {
  const o = await yL() || [];
  return e("SET_PROCESS", o), e("SET_LOADED", { key: "process" }), o;
}, async fetchBridgeProcess({ commit: e }) {
  const o = await vC() || [];
  return e("SET_BRIDGE_PROCESS", o), e("SET_LOADED", { key: "bridgeProcess" }), o;
}, async fetchUsers({ commit: e }) {
  const { content: o = [] } = await XN();
  return e("SET_USERS", o), e("SET_LOADED", { key: "users" }), o;
}, async fetchSuppliers({ commit: e }) {
  const { content: o = [] } = await a5();
  return e("SET_SUPPLIERS", o), e("SET_LOADED", { key: "suppliers" }), o;
}, async fetchWmsSuppliers({ commit: e }) {
  const o = await l5({ orderPlace: Bt.FACTORY.V, level: Bt.FACTORY.V, dataStatus: Lt.PASS.V });
  return e("SET_WMS_SUPPLIERS", o || []), e("SET_LOADED", { key: "wmsSuppliers" }), o;
}, async fetchAnnualSupplier({ commit: e }) {
  const { content: o = [] } = await DL({ boolAnnual: 1 });
  return e("SET_ANNUAL_SUPPLIERS", o), e("SET_LOADED", { key: "annualSuppliers" }), o;
}, async fetchDept({ commit: e }) {
  const o = await i5();
  return zr(o), e("SET_DEPT", o), e("SET_LOADED", { key: "dept" }), o;
}, async fetchUserDeptTree({ commit: e }) {
  const n = await pw();
  return zr(n), e("SET_USER_DEPT_TREE", n), e("SET_LOADED", { key: "userDeptTree" }), n;
}, async fetchRegional({ commit: e }) {
  const o = await t5() || [];
  return zr(o), e("SET_REGIONAL", o), e("SET_LOADED", { key: "regional" }), o;
}, async fetchCatalogRegional({ commit: e }) {
  const o = await r5() || [];
  return zr(o), e("SET_CATALOG_REGIONAL", o), e("SET_LOADED", { key: "catalogRegional" }), o;
}, async fetchUnclosedRequisitions({ commit: e }) {
  const { content: o = [] } = await FL();
  return e("SET_UNCLOSED_REQUISITIONS", o), e("SET_LOADED", { key: "unclosedRequisitions" }), o;
}, async fetchUnclosedPurchaseOrder({ commit: e }) {
  const { content: o = [] } = await zL();
  return o.forEach((n) => {
    n.projects && (n.projectIds = n.projects.map((c) => c.id)), n.materialType & va.STEEL.V && (n.inboundTotalMete = St(n.inboundTotalMete, "g", ei.weight.unit));
  }), e("SET_UNCLOSED_PURCHASE_ORDER", o), e("SET_LOADED", { key: "unclosedPurchaseOrder" }), o;
}, async fetchPurchaseOrder({ commit: e }) {
  const { content: o = [] } = await BL();
  return e("SET_PURCHASE_ORDERS", o.reverse().map((n) => (n.createYear = $a(n.createTime).format("YYYY"), n))), e("SET_LOADED", { key: "purchaseOrders" }), o;
}, async fetchSteelClassifyConf({ commit: e }) {
  const { content: o = [] } = await mI();
  return e("SET_STEEL_CLASSIFY_CONF", o), e("SET_LOADED", { key: "steelClassifyConf" }), o;
}, async fetchMarClsSpec({ state: e }, o = []) {
  const n = [], c = e.classifySpec;
  for (const u of o) {
    const r = {}, E = oL(u).then((y) => {
      var V;
      const b = { id: u, name: y.name, serialNumber: y.serialNumber, measureUnit: y.measureUnit, accountingUnit: y.accountingUnit, accountingPrecision: y.accountingPrecision || 0, measurePrecision: y.measurePrecision || 0, outboundUnitType: y.outboundUnitType, basicClass: y.basicClass, hasUnitConfig: !!y.accountingUnit };
      if (b.fullPathId = y.fullPathId, b.fullPathName = y.fullName.split(">"), b.fullName = b.fullPathName.join(" > "), b.name = b.fullPathName[b.fullPathName.length - 1], b.parentPathName = b.fullPathName.slice(0, -1), b.parentFullName = b.parentPathName.join(" > "), y.basicClass === Ge.SECTION_STEEL.V) (y.nationalStandard || []).forEach((g) => {
        var T;
        const S = { ...b, specConfig: [], specKV: {} };
        A(y.specConfig) && (g.list.map((_) => {
          _.unitWeight && (A(r[_.name]) ? r[_.name].push({ code: _.code || _.id, name: g.name, standardId: g.standardId, unitWeight: _.unitWeight, boolDefault: g.boolDefault, status: _.status }) : r[_.name] = [{ code: _.code || _.id, name: g.name, standardId: g.standardId, unitWeight: _.unitWeight, boolDefault: g.boolDefault, status: _.status }]);
        }), S.specConfig = (T = y.specConfig) == null ? void 0 : T.map((_, f) => ({ id: _.id, name: _.name, index: f + 1, list: _.list.map((m, R) => ({ index: R, code: m.code, name: m.name })) }))), S.specConfig.unshift({ id: `standard_${g.id}`, name: g.name, index: 0, list: g.list.map((_, f) => ({ index: f, code: _.code || _.id, name: _.name, unitWeight: _.unitWeight, boolStandard: true, status: _.status })) });
        const h = `${u}_${g.name}`;
        c[h] = {}, g.boolDefault ? c[h] = c[u] || {} : c[h] = {}, c[h].fullSpecKV = /* @__PURE__ */ new Map(), c[h].specList = Iu(b, S.specConfig, r), c[h].fullSpecMap = new Map(c[h].specList.map((_) => [_.spec, _])), Object.assign(S.specKV, Uo(c[h].specList, "sn")), Object.assign(c[h], S), Object.assign(c.specKV, S.specKV);
      });
      else {
        const M = { ...b, specConfig: [], specKV: {} };
        y.specConfig && (M.specConfig = (V = y.specConfig) == null ? void 0 : V.map((g, S) => ({ id: g.id, name: g.name, index: S, list: g.list.map((h, T) => ({ index: T, code: h.code, name: h.name })) }))), c[u] = {}, c[u].fullSpecKV = /* @__PURE__ */ new Map(), c[u].specList = Iu(b, M.specConfig), c[u].fullSpecMap = new Map(c[u].specList.map((g) => [g.spec, g])), Object.assign(M.specKV, Uo(c[u].specList, "sn")), Object.assign(c[u], M), Object.assign(c.specKV, M.specKV);
      }
    });
    n.push(E);
  }
  await Promise.all(n);
}, async fetchFinalMatClsByIdList({ state: e }, o = []) {
  const n = [], c = e.classifySpec, u = [];
  for (let r = 0; r < o.length; r++) Ae(c[o[r]]) && u.push(o[r]);
  if (A(u)) {
    const r = {};
    (await nL({ ids: u })).forEach((y) => {
      var M;
      const b = y.id, V = { id: b, name: y.name, serialNumber: y.serialNumber, measureUnit: y.measureUnit, accountingUnit: y.accountingUnit, accountingPrecision: y.accountingPrecision || 0, measurePrecision: y.measurePrecision || 0, outboundUnitType: y.outboundUnitType, basicClass: y.basicClass, hasUnitConfig: !!y.accountingUnit };
      if (V.fullPathId = y.fullPathId, V.fullPathName = y.fullName.split(">"), V.fullName = V.fullPathName.join(" > "), V.name = V.fullPathName[V.fullPathName.length - 1], V.parentPathName = V.fullPathName.slice(0, -1), V.parentFullName = V.parentPathName.join(" > "), y.basicClass === Ge.SECTION_STEEL.V) (y.nationalStandard || []).forEach((S) => {
        var _;
        const h = { ...V, specConfig: [], specKV: {} };
        A(y.specConfig) && (S.list.map((f) => {
          f.unitWeight && (A(r[f.name]) ? r[f.name].push({ code: f.code || f.id, name: S.name, standardId: S.standardId, unitWeight: f.unitWeight, boolDefault: S.boolDefault }) : r[f.name] = [{ code: f.code || f.id, name: S.name, standardId: S.standardId, unitWeight: f.unitWeight, boolDefault: S.boolDefault }]);
        }), h.specConfig = (_ = y.specConfig) == null ? void 0 : _.map((f, m) => ({ id: f.id, name: f.name, index: m + 1, list: f.list.map((R, v) => ({ index: v, code: R.code, name: R.name })) }))), h.specConfig.unshift({ id: `standard_${S.id}`, name: S.name, index: 0, list: S.list.map((f, m) => ({ index: m, code: f.code || f.id, name: f.name, unitWeight: f.unitWeight, boolStandard: true, status: f.status })) });
        const T = `${b}_${S.name}`;
        c[T] = {}, S.boolDefault ? c[T] = c[b] || {} : c[T] = {}, c[T].fullSpecKV = /* @__PURE__ */ new Map(), c[T].specList = Iu(V, h.specConfig, r), c[T].fullSpecMap = new Map(c[T].specList.map((f) => [f.spec, f])), Object.assign(h.specKV, Uo(c[T].specList, "sn")), Object.assign(c[T], h), Object.assign(c.specKV, h.specKV);
      });
      else {
        c[b] = {};
        const g = { ...V, specConfig: [], specKV: {} };
        y.specConfig && (g.specConfig = (M = y.specConfig) == null ? void 0 : M.map((S, h) => ({ id: S.id, name: S.name, index: h, list: S.list.map((T, _) => ({ index: _, code: T.code, name: T.name })) }))), c[b].fullSpecKV = /* @__PURE__ */ new Map(), c[b].specList = Iu(V, g.specConfig), c[b].fullSpecMap = new Map(c[b].specList.map((S) => [S.spec, S])), Object.assign(g.specKV, Uo(c[b].specList, "sn")), Object.assign(c[b], g), Object.assign(c.specKV, g.specKV);
      }
      n.push(y);
    });
  }
  await Promise.all(n);
}, async fetchMonomer({ state: e }, o) {
  const n = e.monomers, { content: c = [] } = await Cw(o);
  n[o] = c;
}, async fetchChangeReasonConfig({ commit: e }) {
  const { content: o = [] } = await kI();
  return e("SET_CHANGE_REASON_CONFIG", o), e("SET_LOADED", { key: "changeReasonConfig" }), o;
}, async fetchSubcontractType({ commit: e }) {
  const { content: o = [] } = await KI();
  return e("SET_SUBCONTRACT_TYPE", o), e("SET_LOADED", { key: "subcontractType" }), o;
}, async fetchQualityProblemType({ commit: e }) {
  const { content: o = [] } = await BI();
  return e("SET_QUALITY_PROBLEM_TYPE", o), e("SET_LOADED", { key: "qualityProblemType" }), o;
}, async fetchVisaReason({ commit: e }) {
  const { content: o = [] } = await ZI();
  return e("SET_VISA_REASON", o), e("SET_LOADED", { key: "visaReason" }), o;
}, async fetchAllDecimal({ commit: e }) {
  const o = {}, n = [{ name: "合同管理", key: "contract" }, { name: "桥梁MES", key: "bridge" }, { name: "配置管理", key: "config" }, { name: "套料切割", key: "cutting" }, { name: "围护MES", key: "enclosure" }, { name: "建钢MES", key: "mes" }, { name: "运营分析", key: "operation" }, { name: "计划管理", key: "plan" }, { name: "项目管理", key: "project" }, { name: "发运管理", key: "shipment" }, { name: "供应链", key: "supplyChain" }, { name: "WMS", key: "wms" }];
  n.forEach((u) => {
    o[u.key] = Ze.YUAN;
  });
  const { content: c = [] } = await fC();
  return n.forEach((u) => {
    const r = c.find((E) => u.name.indexOf(E.menuName) > -1) || {};
    A(r) && (o[u.key] = r.scale);
  }), e("SET_DECIMAL_PRECISION", o), e("SET_LOADED", { key: "decimalPrecision" }), c;
}, async fetchSteelMinLengthConfig({ commit: e }) {
  const o = await EI();
  return e("SET_STEEL_MINLENGTH_CONFIG", o), e("SET_LOADED", { key: "steelMinLengthConfig" }), o;
}, async fetchSectionAll({ commit: e }) {
  const o = await _I(), n = { [li.ARTIFACT.V]: { [Oo.PRODUCT_NAME.V]: [], [Oo.PRODUCT_TYPE_ENUM.V]: [], [Oo.SECTION_TYPE_ENUM.V]: [] }, [li.ASSEMBLE.V]: { [Oo.PRODUCT_TYPE_ENUM.V]: [], [Oo.SECTION_TYPE_ENUM.V]: [] }, [li.MACHINE_PART.V]: { [Oo.PRODUCT_TYPE_ENUM.V]: [], [Oo.SECTION_TYPE_ENUM.V]: [] }, [li.AUXILIARY_MATERIAL.V]: { [Oo.PRODUCT_NAME.V]: [] } };
  for (const c in n) for (const u in n[c]) {
    const r = o.filter((E) => Number(E.productType) === Number(c) && +(E.productSectionNameEnum === Number(u))) || [];
    n[c][u] = r;
  }
  return e("SET_SECTION_ALL", n), e("SET_LOADED", { key: "sectionAll" }), o;
}, async fetchClassAll({ commit: e }) {
  const o = await bI();
  return e("SET_CLASS_ALL", o), e("SET_LOADED", { key: "classAll" }), o;
}, async fetchFilterItemsEnumConfig({ commit: e }) {
  const o = {};
  for (let n = 1; n < 4; n++) {
    const c = await aC(n);
    o[n] = c;
  }
  return e("FILTER_ITEMS_ENUM", o), e("SET_LOADED", { key: "filterItemsEnum" }), o;
}, async fetchBusinessModuleEnumConfig({ commit: e }) {
  const o = await lC();
  return e("BUSINESS_MODULE_ENUM", o), e("SET_LOADED", { key: "BusinessModuleEnum" }), o;
}, async fetchBranchCompanyEnumConfig({ commit: e }) {
  const { content: o } = await Pw();
  return e("SET_BRANCH_COMPANY_ENUM", o), e("SET_LOADED", { key: "branchCompanyEnum" }), o;
}, async fetchSupplyUsedProject({ commit: e }) {
  const o = await j5();
  return e("SET_SUPPLY_USED_PROJECT", o), e("SET_LOADED", { key: "supplyUsedProject" }), o;
}, async fetchEnclosureList({ commit: e }, o) {
  const { content: n } = await IC(o);
  return e("SET_ENCLOSURE_LIST", n), e("SET_LOADED", { key: "enclosureList" }), n;
}, async fetchCatalogContentConfig({ commit: e }) {
  var c;
  const o = {}, n = await Ow();
  for (const u in Ja.V) {
    const r = ((c = n == null ? void 0 : n.find((E) => E.fieldEnumType === Number(u))) == null ? void 0 : c.list) || [];
    o[u] = r || [];
  }
  return e("SET_CATALOG_CONTENT_CONFIG", o), e("SET_LOADED", { key: "catalogContentConfig" }), o;
}, async fetchCloseTime({ commit: e }) {
  const o = await VI();
  return o.map((n) => {
    n.label = n.name + Qi(n.startTime, "{y}-{m}-{d}") + "~" + Qi(n.endTime, "{y}-{m}-{d}");
  }), e("SET_CLOSE_TIMES", o), e("SET_LOADED", { key: "closeTimes" }), o;
}, async fetchClosingTimeConfig({ commit: e }) {
  NA();
  const o = await SI();
  return AA(o == null ? void 0 : o.weightedExecutionType), e("SET_CLOSE_TIME_CONFIG", o == null ? void 0 : o.weightedExecutionType), e("SET_LOADED", { key: "closingTimeConfig" }), o;
}, async fetchCappDict({ commit: e }) {
  const o = await DC(), n = {};
  for (const c in o) {
    const u = o[c] || [];
    n[c] = {}, o[c] = u.filter((r) => (n[c][r.id] = r, r.enabledFlag));
  }
  return e("SET_CAPP_DICT", o), e("SET_LOADED", { key: "cappDict" }), o;
} };
function Iu(e, o, n) {
  if (Ae(o)) return [{ classify: e, index: [0], specificationLabels: "无规格", arr: [], spec: "", specKV: {}, specNameKV: {}, specArrKV: [], serialNumber: e.serialNumber, sn: e.serialNumber, nationalStandardOptions: [], status: true }];
  const c = [], u = o.reduce((b, V) => (c.push(V.list.length), b * V.list.length), 1), r = new Array(u);
  for (let b = 0; b < r.length; b++) r[b] = { classify: e, index: new Array(c.length), arr: new Array(c.length), code: new Array(c.length) };
  let E = u, y = 1;
  for (let b = 0; b < c.length; b++) {
    E = E / c[b];
    for (let V = 0; V < y; V++) for (let M = 0; M < c[b]; M++) {
      const g = o[b].list[M];
      for (let S = 0; S < E; S++) {
        const h = V * c[b] * E + M * E + S;
        r[h].index[b] = g.index, r[h].arr[b] = g.name, r[h].code[b] = g.code, e.basicClass === Ge.SECTION_STEEL.V && g.boolStandard && (r[h].specStandardName = g.name, r[h].unitWeight = g.unitWeight, r[h].boolStandard = g.boolStandard, r[h].status = g.status);
      }
    }
    y = y * c[b];
  }
  return r.forEach((b) => {
    b.serialNumber = e.serialNumber + "-" + b.code.join("") || void 0, b.spec = b.arr.join(" * "), b.specKV = {}, b.specificationLabels = o.map((V) => V.name).join(" * "), b.specNameKV = {}, b.specArrKV = [], b.arr.forEach((V, M) => {
      b.specArrKV.push({ key: o[M].id, value: V }), b.specKV[o[M].id] = V, b.specNameKV[o[M].name] = V;
    }), b.specMap = new Map(b.arr.map((V, M) => [o[M].id, V])), b.specNameMap = new Map(b.arr.map((V, M) => [o[M].name, V])), b.sn = b.serialNumber, e.basicClass === Ge.SECTION_STEEL.V && (b.nationalStandardOptions = A(n[b.specStandardName]) ? n[b.specStandardName] : []);
  }), r;
}
