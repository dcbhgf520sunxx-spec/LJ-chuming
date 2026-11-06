function K5(e) {
  return W({ url: `/api/v2/scm/purchase-order/PurchaseExcel/${e.id}`, responseType: "blob", method: "get" });
}
function W5() {
  return W({ url: "/api/v2/scm/purchase-order/StagingListCount", method: "get", params: { boolTemporaryStorage: 1, projectAttribute: [2, 3] }, cancelKey: false });
}
function j5(e) {
  return W({ url: "/api/v2/scm/purchase-order/selectCreatedProject", method: "get", params: e, cancelKey: false });
}
function Rot(e) {
  return W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/inboundDetail/${e.id}`, method: "get", params: e });
}
function Mot(e) {
  return W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/preSettleDetail/${e.id}`, method: "get", params: e });
}
function F5(e) {
  return W({ url: "/api/v2/scm/purchase-order/deleteType", method: "put", data: e });
}
function z5(e) {
  return W({ url: "/api/oa/flow/withdrawRequest", method: "post", params: e });
}
const Aot = { get: C5, add: x1, edit: Pc, del: P5, detail: Tr, download: O5 };
function B5() {
  return W({ url: "/api/v2/wms/outbound/application/getRemindNumbers", method: "get" });
}
function H5() {
  return W({ url: "/api/v2/wms/outbound/application/getRemindList", method: "get" });
}
function q5(e) {
  return W({ url: "/api/v2/wms/outbound/application/closeByIds", method: "post", data: e });
}
const G5 = { isRefresh: false, approvalNum: 0, approvalScm_Num: 0, approvalBg_Num: 0, approvalSelfOrder_Num: 0, approvalProfit_Num: 0, APPModel_Num: 0, APPDrawing_Num: 0, APPNumerical_Num: 0, APP_XML_Num: 0, APPChange_Num: 0, APPconstruction_Num: 0, APPprocess_Num: 0, wmsInbound: 0, TSScm_Num: 0, TSScm_Num_bg: 0, TSScm_Num_self: 0, SubScm_Num: 0, SubScm_Num_bg: 0, SubScm_Num_self: 0, SubModel_Num: 0, SubDrawing_Num: 0, SubNumerical_Num: 0, Sub_XML_Num: 0, SubChange_Num: 0, Subconstruction_Num: 0, Subprocess_Num: 0, SubScm_Num_wms_Inbound: 0, SubScm_Num_Profit: 0, rejScm_Num: 0, rejScm_Num_bg: 0, rejScm_Num_self: 0, rejScm_Num_wms_Inbound: 0, rejScm_Num_Profit: 0, rejModel_Num: 0, rejDrawing_Num: 0, rejNumerical_Num: 0, rej_XML_Num: 0, rejChange_Num: 0, rejconstruction_Num: 0, rejprocess_Num: 0, remindNumbers: 0 }, Q5 = { SET_APPROVAL_NUM(e, o) {
  e.approvalNum = o;
}, SET_APPROVAL_SCM(e, o) {
  e.approvalScm_Num = o;
}, SET_APPROVAL_BG(e, o) {
  e.approvalBg_Num = o;
}, SET_APPROVAL_SELF_ORDER(e, o) {
  e.approvalSelfOrder_Num = o;
}, SET_PROFIT(e, o) {
  e.approvalProfit_Num = o;
}, SET_WMS_INBOUND(e, o) {
  e.wmsInbound = o;
}, APP_MOBEL(e, o) {
  e.APPModel_Num = o;
}, APP_DRAWING(e, o) {
  e.APPDrawing_Num = o;
}, APP_NUMERICAL_CONTROL_DOCUMENT_MANAGE(e, o) {
  e.APPNumerical_Num = o;
}, APP_XML_DOCUMENT_MANAGE(e, o) {
  e.APP_XML_Num = o;
}, APP_CHANGE_FILE(e, o) {
  e.APPChange_Num = o;
}, APP_CONSTRUCTION_BLUEPRINT(e, o) {
  e.APPconstruction_Num = o;
}, APP_PROCESS_DOCUMENT(e, o) {
  e.APPprocess_Num = o;
}, SET_TS_SCM(e, o) {
  e.TSScm_Num = o;
}, SET_TS_SCM_bg(e, o) {
  e.TSScm_Num_bg = o;
}, SET_TS_SCM_SELF(e, o) {
  e.TSScm_Num_self = o;
}, SET_SUB_SCM(e, o) {
  e.SubScm_Num = o;
}, SET_SUB_SCM_BG(e, o) {
  e.SubScm_Num_bg = o;
}, SET_SUB_SCM_SELF(e, o) {
  e.SubScm_Num_self = o;
}, SUB_MOBEL(e, o) {
  e.SubModel_Num = o;
}, SUB_DRAWING(e, o) {
  e.SubDrawing_Num = o;
}, SUB_NUMERICAL_CONTROL_DOCUMENT_MANAGE(e, o) {
  e.SubNumerical_Num = o;
}, SUB_XML_DOCUMENT_MANAGE(e, o) {
  e.Sub_XML_Num = o;
}, SUB_CHANGE_FILE(e, o) {
  e.SubChange_Num = o;
}, SUB_CONSTRUCTION_BLUEPRINT(e, o) {
  e.Subconstruction_Num = o;
}, SUB_PROCESS_DOCUMENT(e, o) {
  e.Subprocess_Num = o;
}, SET_SUB_WMS_INBOUND(e, o) {
  e.SubScm_Num_wms_Inbound = o;
}, SET_SUB_WMS_PROFIT(e, o) {
  e.SubScm_Num_Profit = o;
}, SET_REJ_SCM(e, o) {
  e.rejScm_Num = o;
}, SET_REJ_SCM_BG(e, o) {
  e.rejScm_Num_bg = o;
}, SET_REJ_SCM_SELF(e, o) {
  e.rejScm_Num_self = o;
}, SET_REJ_WMS_INBOUND(e, o) {
  e.rejScm_Num_wms_Inbound = o;
}, SET_REJ_PROFIT(e, o) {
  e.rejScm_Num_Profit = o;
}, REJ_MOBEL(e, o) {
  e.rejModel_Num = o;
}, REJ_DRAWING(e, o) {
  e.rejDrawing_Num = o;
}, REJ_NUMERICAL_CONTROL_DOCUMENT_MANAGE(e, o) {
  e.rejNumerical_Num = o;
}, REJ_XML_DOCUMENT_MANAGE(e, o) {
  e.rej_XML_Num = o;
}, REJ_CHANGE_FILE(e, o) {
  e.rejChange_Num = o;
}, REJ_CONSTRUCTION_BLUEPRINT(e, o) {
  e.rejconstruction_Num = o;
}, REJ_PROCESS_DOCUMENT(e, o) {
  e.rejprocess_Num = o;
}, SET_REMIND_NUMBERS(e, o) {
  e.remindNumbers = o;
}, SET_REFRESH(e, o) {
  e.isRefresh = o;
} }, Z5 = { async fetchApprovalNum({ commit: e }, o) {
  const n = o === ps.INBOUND.V ? { componentNameList: o } : { componentNameList: [o] }, c = await o5(n);
  switch (o) {
    case at.REQUISITIONS_V2.V:
      e("SET_APPROVAL_SCM", c);
      break;
    case at.PURCHASE_ORDER_BG.V:
      e("SET_APPROVAL_BG", c);
      break;
    case at.PURCHASE_ORDER_V2.V:
      e("SET_APPROVAL_SELF_ORDER", c);
      break;
    case ps.INBOUND.V:
      e("SET_WMS_INBOUND", c);
      break;
    case at.INVENTORY_PROFIT.V:
      e("SET_PROFIT", c);
      break;
    case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
      e("APP_MOBEL", c);
      break;
    case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
      e("APP_DRAWING", c);
      break;
    case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
      e("APP_NUMERICAL_CONTROL_DOCUMENT_MANAGE", c);
      break;
    case at.PLAN_CHANGE_FILE.V:
      e("APP_CHANGE_FILE", c);
      break;
    case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
      e("APP_CONSTRUCTION_BLUEPRINT", c);
      break;
    case at.PLAN_PROCESS_DOCUMENT.V:
      e("APP_PROCESS_DOCUMENT", c);
      break;
    default:
      e("SET_APPROVAL_NUM", c);
      break;
  }
  return c;
}, async fetchTSNum({ commit: e }, o) {
  let n;
  switch (o) {
    case at.REQUISITIONS_V2.V:
      n = await g5(), e("SET_TS_SCM", n);
      break;
    case at.PURCHASE_ORDER_BG.V:
      n = await L5(), e("SET_TS_SCM_bg", n);
      break;
    case at.PURCHASE_ORDER_V2.V:
      n = await W5(), e("SET_TS_SCM_SELF", n);
      break;
  }
  return n;
}, async fetchSubNum({ commit: e }, o) {
  const c = await n5({ componentNameList: [o] });
  switch (o) {
    case at.REQUISITIONS_V2.V:
      e("SET_SUB_SCM", c);
      break;
    case at.PURCHASE_ORDER_BG.V:
      e("SET_SUB_SCM_BG", c);
      break;
    case at.PURCHASE_ORDER_V2.V:
      e("SET_SUB_SCM_SELF", c);
      break;
    case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
      e("SUB_MOBEL", c);
      break;
    case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
      e("SUB_DRAWING", c);
      break;
    case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
      e("SUB_NUMERICAL_CONTROL_DOCUMENT_MANAGE", c);
      break;
    case at.PLAN_CHANGE_FILE.V:
      e("SUB_CHANGE_FILE", c);
      break;
    case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
      e("SUB_CONSTRUCTION_BLUEPRINT", c);
      break;
    case at.PLAN_PROCESS_DOCUMENT.V:
      e("SUB_PROCESS_DOCUMENT", c);
      break;
    case ps.INBOUND.V:
      e("SET_SUB_WMS_INBOUND", c);
      break;
    case at.INVENTORY_PROFIT.V:
      e("SET_SUB_WMS_PROFIT", c);
      break;
  }
  return c;
}, async fetchRejNum({ commit: e }, o) {
  const c = await s5({ componentNameList: [o] });
  switch (o) {
    case at.REQUISITIONS_V2.V:
      e("SET_REJ_SCM", c);
      break;
    case at.PURCHASE_ORDER_BG.V:
      e("SET_REJ_SCM_BG", c);
      break;
    case at.PURCHASE_ORDER_V2.V:
      e("SET_REJ_SCM_SELF", c);
      break;
    case ps.INBOUND.V:
      e("SET_REJ_WMS_INBOUND", c);
      break;
    case at.INVENTORY_PROFIT.V:
      e("SET_REJ_PROFIT", c);
      break;
    case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
      e("REJ_MOBEL", c);
      break;
    case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
      e("REJ_DRAWING", c);
      break;
    case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
      e("REJ_NUMERICAL_CONTROL_DOCUMENT_MANAGE", c);
      break;
    case at.PLAN_CHANGE_FILE.V:
      e("REJ_CHANGE_FILE", c);
      break;
    case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
      e("REJ_CONSTRUCTION_BLUEPRINT", c);
      break;
    case at.PLAN_PROCESS_DOCUMENT.V:
      e("REJ_PROCESS_DOCUMENT", c);
      break;
  }
  return c;
}, async fetchRemindNumbers({ commit: e }, o) {
  const n = await B5();
  return e("SET_REMIND_NUMBERS", n), o;
}, fetchRefresh({ commit: e }, o) {
  return e("SET_REFRESH", o), o;
} }, J5 = { namespaced: true, state: G5, mutations: Q5, actions: Z5 }, X5 = Object.freeze(Object.defineProperty({ __proto__: null, default: J5 }, Symbol.toStringTag, { value: "Module" }));
function $5() {
  return W({ module: "config", url: "classification/material/tree", method: "get" });
}
function eL(e) {
  return W({ module: "config", url: "classification/tree-new", method: "get", params: e });
}
function tL() {
  return W({ module: "config", url: "classification/tree/all", method: "get" });
}
function iL(e) {
  return W({ module: "config", url: "classification", method: "post", data: e });
}
function aL(e) {
  return W({ module: "config", url: "classification", method: "put", data: e });
}
function lL(e) {
  return W({ module: "config", url: "classification", method: "delete", data: e });
}
function Not(e) {
  return W({ url: "/api/config/classification/exportClassificationList", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function Lot(e) {
  return W({ url: "/api/config/classification/updateStatus", method: "post", data: e });
}
function Iot(e) {
  return W({ url: "/api/config/classification/update", method: "put", data: e });
}
const Cot = { get: eL, batchAdd: iL, save: aL, del: lL };
function oL(e) {
  return W({ module: "config", url: `classification/final-material/${e}`, method: "get", cancelKey: false });
}
function Pot(e) {
  return W({ module: "config", url: `classification/${e}`, method: "get", cancelKey: false });
}
function nL(e) {
  return W({ module: "config", url: "classification/final-materials", method: "get", params: e, cancelKey: false });
}
function sL(e) {
  return W({ module: "system", url: "dictDetail/all", method: "get", cancelKey: false, params: { name: e } });
}
function rL(e) {
  return W({ module: "system", url: "dictDetail", method: "get", params: e });
}
function uL(e) {
  return W({ module: "system", url: "dictDetail", method: "post", data: e });
}
function cL(e) {
  return W({ module: "system", url: "dictDetail", method: "put", data: e });
}
function dL(e) {
  return W({ module: "system", url: "dictDetail/" + e, method: "delete" });
}
const Oot = { add: uL, edit: cL, del: dL, get: rL };
function mL() {
  return W({ module: "config", url: "base-config/unit/all", method: "get" });
}
function pL(e) {
  return W({ module: "config", url: "base-config/unit", method: "get", cancelKey: false, params: e });
}
function hL(e) {
  return W({ module: "config", url: "base-config/unit/batch", method: "post", data: e });
}
function kot(e) {
  return W({ module: "config", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "base-config/unit/enabled", cancelKey: false, method: "put", data: e });
}
function fL(e) {
  return W({ module: "config", url: "base-config/unit", method: "delete", data: e });
}
const Dot = { get: pL, batchAdd: hL, del: fL };
function gL(e) {
  return W({ module: "mes", url: "factory", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function EL(e) {
  return W({ module: "mes", url: "workshop", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function yL(e) {
  return W({ module: "mes", url: "process", method: "get", params: e });
}
function TL(e) {
  return W({ module: "mes", url: "team", method: "get", params: e });
}
function _L(e) {
  return W({ module: "mes", url: "inspectionTeam", method: "get", params: e });
}
function bL(e) {
  return W({ module: "mes", url: "productionLine", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function VL(e) {
  return W({ module: "mes", url: "factory/production_line_group", method: "get", params: { boolEnabledEnum: true, ...e } });
}
function wL(e) {
  return W({ module: "mes", url: "cut", method: "get", params: e });
}
function xot(e) {
  return W({ module: "mes", url: "package/list", method: "get", params: e });
}
function Uot(e) {
  return W({ module: "bridge", url: "package/list", method: "get", params: e });
}
function Yot({ projectId: e, areaId: o, monomerId: n, productType: c, areaBatchId: u }) {
  return W({ module: "mes", url: "task/productionLine/hasTask", method: "get", params: { projectId: e, areaId: o, monomerId: n, productType: c, areaBatchId: u } });
}
function Kot(e) {
  return W({ url: `/api/enclosurePlanDetail/tech/${e}`, method: "get" });
}
function SL(e) {
  return W({ url: "/api/mes/building/warehouse/list/public", method: "get", params: e });
}
