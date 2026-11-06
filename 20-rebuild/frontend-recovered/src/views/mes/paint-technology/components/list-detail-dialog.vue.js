import { computed as p } from "vue";
import { ref as S } from "vue";
import { reactive as W } from "vue";
import { watch as X } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as N } from "vue";
import { createBlock as P } from "vue";
import { withCtx as o } from "vue";
import { unref as f } from "vue";
import { createCommentVNode as Y } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as y } from "vue";
import { withKeys as Z } from "vue";
import { createTextVNode as A } from "vue";
import { withDirectives as ee } from "vue";
import { ElFormItem as te } from "element-plus";
import { ElCol as ae } from "element-plus";
import { ElRow as le } from "element-plus";
import { ElForm as oe } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElPagination as re } from "element-plus";
import { vLoading as se } from "element-plus";
import { l as u, _ as ce, op as K, p as ue, J as pe, G as de, oq as me, kb as ge } from "../../../../shared/runtime.js";
function fe(l) {
  return u({ url: "/api/mes/building/paint/technology/groupByProject/list", method: "get", params: l });
}
function _e(l) {
  return u({ url: "/api/mes/building/paint/technology/paintCalculateRecord/remove", method: "delete", data: l });
}
function he(l) {
  return u({ url: "/api/mes/building/paint/technology/related/artifact/list", method: "get", params: l });
}
function be(l) {
  return u({ url: "/api/mes/building/paint/technology/notCalculate/structureClass/list", method: "get", params: l });
}
function ye(l) {
  return u({ url: "/api/mes/building/paint/technology/paintCalculateRecord/list", method: "get", params: l });
}
function we(l) {
  return u({ url: "/api/mes/building/paint/technology/paintCalculateRecord/structureClass/artifact/list", method: "get", params: l });
}
function ve(l) {
  return u({ url: "/api/mes/building/paint/technology/save/calculate", method: "post", data: l });
}
function Ce(l) {
  return u({ url: "/api/mes/building/craft/paint-config/painting-craft-select-list", method: "get", params: l, cancelKey: false });
}
function De(l) {
  return u({ url: "/api/mes/building/craft/paint-config/listAll", method: "get", params: l, cancelKey: false });
}
const B = { get: fe, delete: _e, getDetail: he, getPaintCalcList: be, getPaintCalculateRecordList: ye, getPaintCalculateRecordArtifactList: we, saveCalculate: ve, getPaintingCraftSelectList: Ce, getPaintConfigListAll: De };
const xe = { class: "list-detail" }, Ie = { class: "detail-header" }, Ne = { class: "search-row" }, Pe = { __name: "list-detail-dialog", props: { modelValue: { type: Boolean, default: false }, rowData: { type: Object, default: null }, apiType: { type: String, default: "default" } }, emits: ["update:modelValue"], setup(l, { emit: q }) {
  const a = l, O = q, T = p({ get: () => a.modelValue, set: (e) => O("update:modelValue", e) }), U = p(() => a.apiType === "record" ? K.statListPrint : K.listPrint), V = p(() => {
    var e, n, i, r, d;
    return a.apiType === "record" ? { apiKey: "mesPaintTechnologyRecordArtifactPrint", params: { calculateRecordId: (e = a.rowData) == null ? void 0 : e.id, structureClassId: (n = a.rowData) == null ? void 0 : n.structureClassId, projectId: (i = a.rowData) == null ? void 0 : i.projectId } } : { apiKey: "mesPaintTechnologyListDetail", params: { paintTechnologyId: (r = a.rowData) == null ? void 0 : r.id, projectId: (d = a.rowData) == null ? void 0 : d.projectId } };
  }), w = S(false), z = p(() => {
    var e;
    return ((e = a.rowData) == null ? void 0 : e.projectName) || "-";
  }), j = p(() => {
    var e;
    return ((e = a.rowData) == null ? void 0 : e.createUserName) || "-";
  }), R = p(() => {
    var e;
    return ((e = a.rowData) == null ? void 0 : e.serialNumber) || "-";
  }), k = p(() => {
    var e;
    return (e = a.rowData) != null && e.createTime ? ue(a.rowData.createTime, "{y}/{m}/{d} {h}:{i}") : "-";
  }), F = p(() => ({ project: z.value, creator: j.value, processNumber: R.value, date: k.value })), _ = W({ serialNumber: "" }), v = S([]), { handleSizeChange: M, handleCurrentChange: G, total: H, setTotalPage: L, queryPage: h } = pe({ fetchHook: D });
  function C() {
    h.pageNumber = 1, D();
  }
  function J() {
    _.serialNumber = "", C();
  }
  async function D() {
    var e, n, i, r, d, b;
    w.value = true;
    try {
      const c = { projectId: (e = a.rowData) == null ? void 0 : e.projectId, monomerId: (n = a.rowData) == null ? void 0 : n.monomerId, areaId: (i = a.rowData) == null ? void 0 : i.areaId, serialNumber: _.serialNumber || void 0, ...h };
      let g;
      a.apiType === "record" ? (c.calculateRecordId = (r = a.rowData) == null ? void 0 : r.id, c.structureClassId = (d = a.rowData) == null ? void 0 : d.structureClassId, g = await B.getPaintCalculateRecordArtifactList(c)) : (c.paintTechnologyId = (b = a.rowData) == null ? void 0 : b.id, g = await B.getDetail(c));
      const { content: s = [], totalElements: x } = g || {};
      v.value = s || [], L(x || 0);
    } catch (c) {
      console.error("加载详情失败", c), v.value = [], L(0);
    } finally {
      w.value = false;
    }
  }
  return X(() => a.modelValue, (e) => {
    e && (_.serialNumber = "", h.pageNumber = 1, D());
  }), (e, n) => {
    const i = te, r = ae, d = le, b = oe, c = ne, g = E("common-button"), s = ie, x = E("common-table"), $ = re, Q = se;
    return N(), P(ge, { modelValue: T.value, "onUpdate:modelValue": n[1] || (n[1] = (I) => T.value = I), title: "清单表", size: "100%", direction: "rtl", "show-close": true }, { titleRight: o(() => [f(de)(U.value) ? (N(), P(me, { key: 0, "api-key": V.value.apiKey, params: V.value.params, size: "default", "btn-type": "warning" }, null, 8, ["api-key", "params"])) : Y("", true)]), content: o(() => [m("div", xe, [m("div", Ie, [t(b, { model: F.value, "label-width": "90px", class: "info-form" }, { default: o(() => [t(d, { gutter: 20 }, { default: o(() => [t(r, { span: 6 }, { default: o(() => [t(i, { label: "项目：" }, { default: o(() => [m("span", null, y(z.value), 1)]), _: 1 })]), _: 1 }), t(r, { span: 6 }, { default: o(() => [t(i, { label: "创建人：" }, { default: o(() => [m("span", null, y(j.value), 1)]), _: 1 })]), _: 1 }), t(r, { span: 6 }, { default: o(() => [t(i, { label: "工艺编号：" }, { default: o(() => [m("span", null, y(R.value), 1)]), _: 1 })]), _: 1 }), t(r, { span: 6 }, { default: o(() => [t(i, { label: "创建日期：" }, { default: o(() => [m("span", null, y(k.value), 1)]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])]), m("div", Ne, [t(c, { modelValue: _.serialNumber, "onUpdate:modelValue": n[0] || (n[0] = (I) => _.serialNumber = I), placeholder: "输入编号搜索", style: { width: "200px", "margin-right": "10px" }, size: "default", clearable: "", onKeyup: Z(C, ["enter"]) }, null, 8, ["modelValue"]), t(g, { type: "primary", size: "default", icon: "el-icon-search", onClick: C }, { default: o(() => n[2] || (n[2] = [A("查询")])), _: 1, __: [2] }), t(g, { type: "warning", size: "default", icon: "el-icon-refresh-left", onClick: J }, { default: o(() => n[3] || (n[3] = [A("重置")])), _: 1, __: [3] })]), ee((N(), P(x, { data: v.value, "max-height": 600, style: { width: "100%" } }, { default: o(() => [t(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s, { prop: "monomer.name", label: "单体", "min-width": "120px" }), t(s, { prop: "area.name", label: "区域", "min-width": "150px" }), t(s, { prop: "name", label: "名称", "min-width": "120px" }), t(s, { prop: "serialNumber", label: "编号", "min-width": "120px" }), t(s, { prop: "specification", label: "规格", "min-width": "150px" }), t(s, { prop: "quantity", label: "数量", align: "center", "min-width": "80px" }), t(s, { prop: "totalArea", label: "总面积(㎡)", align: "center", "min-width": "100px" })]), _: 1 }, 8, ["data"])), [[Q, w.value]]), t($, { total: f(H), "current-page": f(h).pageNumber, "page-size": f(h).pageSize, "page-sizes": [10, 20, 50, 100], layout: "total, prev, pager, next, sizes", class: "list-detail-pagination", style: { "margin-top": "10px" }, onSizeChange: f(M), onCurrentChange: f(G) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])]), _: 1 }, 8, ["modelValue"]);
  };
} }, Te = ce(Pe, [["__scopeId", "data-v-a5e6a5ce"]]), je = Object.freeze(Object.defineProperty({ __proto__: null, default: Te }, Symbol.toStringTag, { value: "Module" }));
export {
  je as a,
  B as c,
  Te as l
};
