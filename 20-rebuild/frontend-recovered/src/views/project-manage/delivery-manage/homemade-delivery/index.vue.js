import { ref as d } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as u } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as p } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as y } from "vue";
import { Fragment as $ } from "vue";
import { renderList as q } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as h } from "vue";
import { ElTableColumn as z } from "element-plus";
import { ElTag as F } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as G, _ as Q } from "./module/delivery-detail.vue.js";
import { _ as K, m as Y, x as J, bN as E, tU as g, o as W, i as X, p as Z, z as ee, aN as te, bv as oe, bi as b, G as v, P as ae } from "../../../../shared/runtime.js";
import { h as c } from "../../../../modules/project-19a12d6b.js";
import le from "./module/header.vue.js";
const re = { class: "app-container" }, ie = { key: 0 }, se = { style: { "margin-left": "14px" } }, ne = { class: "project-name" }, ce = { key: 1 }, de = { __name: "index", setup(pe) {
  const { globalProjectId: k, globalProject: m } = Y(["globalProjectId", "globalProject"]), S = { add: false, edit: false, del: false, download: false }, T = d(), _ = d(false), x = d("detail"), N = d({}), { crud: s, CRUD: D } = J({ title: "自制收货", sort: ["id.desc"], permission: { ...c }, optShow: { ...S }, requiredQuery: ["projectId"], crudApi: { ...G }, hasPagination: true }, T);
  D.HOOK.beforeRefresh = () => (s.query.projectId = m.value.businessType === E.INSTALLATION.V ? k.value : void 0, !!s.query.projectId);
  const L = d([["status", ["parse-enum", g]], ["auditReceiptTime", "parse-time"]]), { maxHeight: A } = W({ wrapperBox: ".homemade-delivery", paginate: true, extraHeight: 40 });
  function w(P, n) {
    _.value = true, N.value = P.sourceRow, x.value = n;
  }
  return (P, n) => {
    var R;
    const a = z, B = f("table-cell-tag"), j = F, I = f("common-button"), U = f("common-table"), H = M;
    return l(), u("div", re, [((R = e(m)) == null ? void 0 : R.businessType) === e(E).INSTALLATION.V ? (l(), u("div", ie, [o(e(le), { projectId: e(k) }, null, 8, ["projectId"]), O((l(), p(U, { ref_key: "tableRef", ref: T, data: e(s).data, "data-format": L.value, "empty-text": e(s).emptyText, "max-height": e(A), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: i(() => [o(a, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), o(a, { key: "auditTime", prop: "auditTime", label: "发运日期", align: "center", width: "160", "show-overflow-tooltip": true }, { default: i((t) => {
      var r;
      return [o(B, { show: e(X)(t.row.boolProblemReceiving) && ((r = t.row.sourceRow) == null ? void 0 : r.status) === e(g).DELIVERY.V, name: t.row.boolProblemReceiving ? "问题收货" : "正常收货", color: t.row.boolProblemReceiving ? "#f56c6c" : "#67c23a", onClick: (ue) => w(t.row, "detail") }, null, 8, ["show", "name", "color", "onClick"]), V("span", se, y(t.row.auditTime ? e(Z)(t.row.auditTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)];
    }), _: 1 }), o(a, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "150" }, { default: i((t) => [V("span", ne, y(e(ee)(t.row.project)), 1)]), _: 1 }), o(a, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": true }), o(a, { key: "serialNumber", prop: "serialNumber", label: "车次/船次", align: "center", "show-overflow-tooltip": true }), o(a, { key: "driverName", prop: "driverName", label: "司机姓名", align: "center", "show-overflow-tooltip": true }), o(a, { key: "driverPhone", prop: "driverPhone", label: "司机电话", align: "center", "show-overflow-tooltip": true }), o(a, { key: "auditUserName", prop: "auditUserName", label: "办理人", align: "center", "show-overflow-tooltip": true }), o(a, { key: "productType", prop: "productType", label: "装载物品", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: i((t) => [(l(true), u($, null, q(e(te)(e(oe).getBits(e(b), t.row.productType, "V")), (r) => (l(), p(j, { style: { "margin-right": "5px" }, key: r, type: e(b).V[r].T, effect: "light", "disable-transitions": "" }, { default: i(() => [C(y(e(b).VL[r]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), o(a, { key: "status", prop: "status", label: "状态", align: "center", "show-overflow-tooltip": true }), o(a, { key: "auditReceiptName", prop: "auditReceiptName", label: "收货人", align: "center", "show-overflow-tooltip": true }), o(a, { key: "auditReceiptTime", prop: "auditReceiptTime", label: "收货日期", align: "center", "min-width": "120", "show-overflow-tooltip": true }), e(v)([...e(c).detail, ...e(c).audit]) ? (l(), p(a, { key: 0, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: i((t) => [e(v)(e(c).detail) ? (l(), p(I, { key: 0, size: "default", icon: "el-icon-view", type: "primary", onClick: (r) => w(t.row, "detail") }, null, 8, ["onClick"])) : h("", true), e(v)(e(c).audit) && t.row.sourceRow.status === e(g).SHIPMENT.V ? (l(), p(I, { key: 1, size: "default", icon: "el-icon-stamp", type: "primary", onClick: (r) => w(t.row, "edit") }, null, 8, ["onClick"])) : h("", true)]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[H, e(s).loading]]), o(e(ae))])) : (l(), u("div", ce, [o(j, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: i(() => n[1] || (n[1] = [C(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [1] })])), o(e(Q), { modelValue: _.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => _.value = t), showType: x.value, detailInfo: N.value, onSuccess: e(s).toQuery, permission: e(c), globalProject: e(m) }, null, 8, ["modelValue", "showType", "detailInfo", "onSuccess", "permission", "globalProject"])]);
  };
} }, he = K(de, [["__scopeId", "data-v-9035a004"]]);
export {
  he as default
};
