import { ref as C } from "vue";
import { reactive as ee } from "vue";
import { watch as te } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as u } from "vue";
import { createBlock as p } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as r } from "vue";
import { unref as a } from "vue";
import { withDirectives as D } from "vue";
import { createCommentVNode as T } from "vue";
import { createElementBlock as S } from "vue";
import { isRef as ne } from "vue";
import { ElMessage as oe } from "element-plus";
import { ElNotification as le } from "element-plus";
import { ElTag as ie } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { Check as re } from "@element-plus/icons-vue";
import { ElIcon as ce } from "element-plus";
import { ElPagination as ue } from "element-plus";
import { vLoading as me } from "element-plus";
import { l as L, aU as d, u as pe, J as de, o as fe, nt as ge, nv as _e, a3 as be, ms as ye, nw as he, nu as ve } from "../../../../../../shared/runtime.js";
import { _ as Ne } from "../../../../../../modules/SingleFileUploadBtn-17bec156.js";
function Ee(c) {
  return L({ module: "mes", url: "section_steel/nesting/project/status", method: "get", params: c });
}
function Se(c) {
  return L({ module: "mes", url: "section_steel/nesting/project/status/detail", method: "get", params: c });
}
function Ce(c) {
  return L({ module: "mes", url: "section_steel/nesting/area/status/detail", method: "get", params: c });
}
function Te(c) {
  return L({ module: "mes", url: "section_steel/nesting/area/status/number", method: "get", params: c });
}
const ze = { get: Ee }, Le = { class: "content-container", style: { display: "flex", "margin-bottom": "8px" } }, ke = { key: 0 }, we = { key: 1 }, xe = { __name: "index", props: { visible: { type: Boolean, default: false }, assembleList: { type: Object, default: () => {
} } }, emits: ["success"], setup(c, { emit: z }) {
  const H = z, f = C(d.TRADITION.V), g = C(), V = C([]), I = ee({ summaryList: 0 }), k = C(false), h = c;
  te(() => g.value, (i) => {
    v();
  }, { deep: true });
  const { visible: w, handleClose: P } = pe({ emit: H, props: h, field: "visible", showHook: M }), { handleSizeChange: j, handleCurrentChange: A, total: O, setTotalPage: B, queryPage: x } = de({ fetchHook: _ });
  function M() {
    h.assembleList.id && (f.value = d.TRADITION.V, g.value = void 0, _(), v());
  }
  function U(i, o) {
    const b = i.name.substring(0, i.name.indexOf("."));
    return o && o !== b ? (oe.error(`上传文件编号需为${o}`), false) : true;
  }
  function R() {
    le({ title: "上传成功", type: "success", duration: 2500 }), _(), v();
  }
  async function _() {
    let i = [];
    k.value = true;
    try {
      const { content: o = [], totalElements: b } = await Ce({ areaId: h.assembleList.id, productionLineTypeEnum: f.value, boolHaveNC1: g.value, ...x });
      i = o.map((m) => {
        var N, l;
        return m.artifactStr = (N = m.artifactTypesettingDTO) == null ? void 0 : N.serialNumber, m.classificationName = (l = m.artifactTypesettingDTO) == null ? void 0 : l.classificationName, m;
      }), B(b);
    } catch (o) {
      console.log("获取部件清单失败", o);
    } finally {
      V.value = i, k.value = false;
    }
  }
  async function v() {
    try {
      const i = await Te({ areaId: h.assembleList.id, productionLineTypeEnum: f.value });
      I.summaryList = i;
    } catch (i) {
      console.log("获取缺失nc1文件数量失败", i);
    }
  }
  function q() {
    _();
  }
  function F() {
    _(), v();
  }
  const { maxHeight: W } = fe({ extraBox: [".head-container"], paginate: true });
  return (i, o) => {
    const b = ie, m = y("common-radio-button"), N = y("common-select"), l = se, E = y("table-cell-tag"), $ = re, G = ce, J = y("common-table"), K = ue, Q = y("common-drawer"), X = ae("permission"), Y = me;
    return u(), p(Q, { "before-close": a(P), size: "80%", title: "部件清单", modal: "", "append-to-body": "", visible: a(w), "onUpdate:visible": o[2] || (o[2] = (e) => ne(w) ? w.value = e : null) }, { titleAfter: n(() => [t(b, { effect: "plain", type: "danger", class: "filter-item", size: "default" }, { default: n(() => [s("span", null, "提示：缺少NC1文件：" + r(I.summaryList), 1)]), _: 1 })]), content: n(() => [s("div", Le, [t(m, { modelValue: f.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => f.value = e), options: a(ge).ENUM, type: "enum", style: { "align-self": "center" }, class: "filter-item", onChange: F }, null, 8, ["modelValue", "options"]), t(N, { modelValue: g.value, "onUpdate:modelValue": o[1] || (o[1] = (e) => g.value = e), options: a(_e).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "是否导入NC1文件", style: { width: "180px", "margin-left": "8px" }, onChange: q }, null, 8, ["modelValue", "options"])]), D((u(), p(J, { ref: "tableDrawerRef", data: V.value, "max-height": a(W), style: { width: "100%" } }, { default: n(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { key: "monomer.name", prop: "monomer", "show-overflow-tooltip": true, label: "单体", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.monomer.name), 1)]), _: 1 }), t(l, { key: "area.name", prop: "areaName", "show-overflow-tooltip": true, label: "区域", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.area.name), 1)]), _: 1 }), t(l, { key: "artifactStr", prop: "artifactStr", "show-overflow-tooltip": true, label: "关联构件编号", "min-width": "120px", align: "center" }, { default: n(({ row: e }) => [e.productionLineTypeEnum === a(d).INTELLECT.V && e.classificationName === "钢柱" ? (u(), p(E, { key: 0, name: e.classificationName, color: "#fad400", offset: 15 }, null, 8, ["name"])) : T("", true), e.productionLineTypeEnum === a(d).INTELLECT.V && e.classificationName === "钢梁" ? (u(), p(E, { key: 1, name: e.classificationName, color: "#40ed8d", offset: 15 }, null, 8, ["name"])) : T("", true), e.productionLineTypeEnum === a(d).INTELLECT.V && e.classificationName === "短梁" ? (u(), p(E, { key: 2, name: e.classificationName, color: "#00babd", offset: 15 }, null, 8, ["name"])) : T("", true), e.productionLineTypeEnum === a(d).INTELLECT.V && e.classificationName === "长短梁" ? (u(), p(E, { key: 3, name: e.classificationName, color: "#ff7800", offset: 15 }, null, 8, ["name"])) : T("", true), s("span", null, r(e.artifactStr), 1)]), _: 1 }), t(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "部件编号", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.serialNumber), 1)]), _: 1 }), t(l, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.specification), 1)]), _: 1 }), t(l, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.length), 1)]), _: 1 }), t(l, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.material), 1)]), _: 1 }), t(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "60px" }, { default: n(({ row: e }) => [s("span", null, r(e.quantity), 1)]), _: 1 }), t(l, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", align: "center" }, { default: n(({ row: e }) => [s("span", null, r(e.netWeight), 1)]), _: 1 }), t(l, { key: "boolHaveNC1", prop: "boolHaveNC1", "show-overflow-tooltip": true, label: "套料文件", align: "center" }, { default: n(({ row: e }) => [e.boolHaveNC1 ? (u(), S("div", ke, [t(G, { style: { color: "#5ded5d" } }, { default: n(() => [t($)]), _: 1 })])) : (u(), S("div", we, [D(t(Ne, { data: { monomerId: e.monomer.id, projectId: e.project.id, productType: a(be).ASSEMBLE.V, dataType: a(ye).NC_DRAWING.V }, accept: ".nc1", tip: ".nc1", "upload-fun": a(he), "before-upload-hook": (Z) => U(Z, e.serialNumber), "btn-type": "primary", "btn-name": "文件导入", "btn-size": "default", class: "filter-item", onSuccess: R }, null, 8, ["data", "upload-fun", "before-upload-hook"]), [[X, a(ve).import]])]))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[Y, k.value]]), t(K, { total: a(O), "current-page": a(x).pageNumber, "page-size": a(x).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(j), onCurrentChange: a(A) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, He = Object.freeze(Object.defineProperty({ __proto__: null, default: xe }, Symbol.toStringTag, { value: "Module" }));
export {
  xe as _,
  ze as c,
  Se as g,
  He as i
};
