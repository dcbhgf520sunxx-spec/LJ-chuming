import { ref as c } from "vue";
import { inject as K } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as w } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as X } from "vue";
import { unref as n } from "vue";
import { createElementVNode as r } from "vue";
import { withModifiers as I } from "vue";
import { createCommentVNode as R } from "vue";
import { withDirectives as Y } from "vue";
import { isRef as Z } from "vue";
import { ElMessage as z } from "element-plus";
import { ElTag as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { ElPopconfirm as le } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { b as ne, u as re, a as se } from "../../../../../../modules/process-611d795f.js";
import { _ as ie, u as ue, J as de, o as ce, ts as me, bb as pe, q as fe, G as be } from "../../../../../../shared/runtime.js";
import { u as N } from "../../../../../../modules/plan-d12d7ccf.js";
const ge = { style: { display: "flex" } }, ve = { style: { margin: "10px 0" } }, _e = { style: { "margin-bottom": "10px" } }, we = { style: { "margin-bottom": "10px" } }, ye = { style: { "margin-bottom": "10px" } }, xe = { style: { "margin-bottom": "10px" } }, he = { style: { "text-align": "right", "margin-bottom": "10px" } }, Ve = { style: { flex: "1", "padding-left": "10px" } }, Ce = { style: { "margin-bottom": "10px", "text-align": "right" } }, je = { __name: "artifact-bind-detail", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(p, { emit: S }) {
  const u = p, t = c({}), V = c([]), C = c(false), y = S, { visible: f, handleClose: k } = ue({ emit: y, props: u }), { handleSizeChange: P, handleCurrentChange: B, total: E, setTotalPage: U, queryPage: x } = de({ fetchHook: d }), L = c([["project", "parse-project"]]), D = K("structureClassList"), j = c(), { maxHeight: H } = ce({ mainBox: ".already-form", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, j);
  Q(() => f.value, (a) => {
    if (a) {
      for (const e in t.value) u.currentRow.boolSingleProject && e === "projectId" ? t.value[e] = u.currentRow.projectId : t.value[e] = void 0;
      d();
    }
  }, { deep: true, immediate: true });
  async function T() {
    try {
      await re(u.currentRow.id), z.success("一键解绑构件成功"), d(), y("success");
    } catch (a) {
      console.log("解绑失败", a);
    }
  }
  async function q(a) {
    try {
      await se({ processFileId: u.currentRow.id, details: [{ monomerId: a.monomerId, serialNumber: a.serialNumber }] }), z.success("构件：" + a.serialNumber + "解绑成功"), d(), y("success");
    } catch (e) {
      console.log("绑定失败", e);
    }
  }
  async function d() {
    let a = [];
    C.value = true;
    try {
      const { content: e = [], totalElements: h } = await ne({ ...t.value, processFileId: u.currentRow.id, ...x });
      U(h), a = e;
    } catch (e) {
      console.log("构件绑定明细", e);
    } finally {
      V.value = a, C.value = false;
    }
  }
  function M() {
    for (const a in t.value) u.currentRow.boolSingleProject && a === "projectId" ? t.value[a] = u.currentRow.projectId : t.value[a] = void 0;
    d();
  }
  return (a, e) => {
    const h = ee, F = v("common-select"), b = te, g = v("common-button"), A = le, i = oe, $ = v("common-table"), G = ae, J = v("common-drawer"), O = W("permission");
    return _(), w(J, { "append-to-body": "", ref_key: "drawerRef", ref: j, modelValue: n(f), "onUpdate:modelValue": e[7] || (e[7] = (o) => Z(f) ? f.value = o : null), top: "10vh", width: "600px", "before-close": n(k), title: `构件绑定列表：${p.currentRow.fileName}`, "wrapper-closable": false, size: "90%", "custom-class": "already-form" }, { titleAfter: s(() => [l(h, null, { default: s(() => [m("文件类型:" + X(n(me).VL[p.currentRow.processType]), 1)]), _: 1 })]), content: s(() => [r("div", ge, [r("div", null, [l(pe, { modelValue: t.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (o) => t.value.projectId = o), clearable: "", class: "filter-item", style: { width: "270px", "margin-bottom": "10px" }, placeholder: "项目搜索" }, null, 8, ["modelValue"]), r("div", null, [l(n(fe), { ref: "monomerSelectRef", modelValue: t.value.monomerId, "onUpdate:modelValue": e[1] || (e[1] = (o) => t.value.monomerId = o), style: { width: "270px" }, default: false, "project-id": t.value.projectId, class: "filter-item" }, null, 8, ["modelValue", "project-id"])]), r("div", ve, [l(F, { modelValue: t.value.structureClassId, "onUpdate:modelValue": e[2] || (e[2] = (o) => t.value.structureClassId = o), options: n(D), type: "other", clearable: "", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", style: { width: "270px" }, placeholder: "构件类型" }, null, 8, ["modelValue", "options"])]), r("div", _e, [l(b, { modelValue: t.value.name, "onUpdate:modelValue": e[3] || (e[3] = (o) => t.value.name = o), placeholder: "构件名称搜索", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), r("div", we, [l(b, { modelValue: t.value.serialNumber, "onUpdate:modelValue": e[4] || (e[4] = (o) => t.value.serialNumber = o), placeholder: "构件编号", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), r("div", ye, [l(b, { modelValue: t.value.specification, "onUpdate:modelValue": e[5] || (e[5] = (o) => t.value.specification = o), placeholder: "构件规格", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), r("div", xe, [l(b, { modelValue: t.value.material, "onUpdate:modelValue": e[6] || (e[6] = (o) => t.value.material = o), placeholder: "构件材质", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), r("div", he, [l(g, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: I(d, ["stop"]) }, { default: s(() => e[8] || (e[8] = [m("搜索")])), _: 1, __: [8] }), l(g, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh", onClick: I(M, ["stop"]) }, { default: s(() => e[9] || (e[9] = [m(" 重置 ")])), _: 1, __: [9] })]), e[10] || (e[10] = r("div", { style: { color: "#999", "font-size": "13px", "margin-bottom": "10px" } }, " * 注意： ", -1)), e[11] || (e[11] = r("div", { style: { color: "#999", "font-size": "13px" } }, "1. 解绑操作即刻生效，无需提交。", -1))]), r("div", Ve, [r("div", Ce, [n(be)(n(N).unbind) ? (_(), w(A, { key: 0, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定解绑吗?", onConfirm: T }, { reference: s(() => [l(g, { type: "primary" }, { default: s(() => e[12] || (e[12] = [m("一键解绑")])), _: 1, __: [12] })]), _: 1 })) : R("", true)]), l($, { ref: "detailRef", border: "", data: V.value, "max-height": n(H) - 100, style: { width: "100%" }, class: "table-form", "data-format": L.value }, { default: s(() => [l(i, { label: "序号", type: "index", align: "center", width: "55" }), p.currentRow.boolSingleProject ? R("", true) : (_(), w(i, { key: 0, prop: "project", label: "项目", align: "left", "min-width": "150", "show-overflow-tooltip": "" })), l(i, { prop: "monomerName", label: "单体", align: "left", "show-overflow-tooltip": "" }), l(i, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), l(i, { prop: "name", label: "构件名称", align: "center", "show-overflow-tooltip": "" }), l(i, { prop: "structureClassName", label: "构件类型", align: "center", "show-overflow-tooltip": "" }), l(i, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), l(i, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "", width: "80" }), l(i, { label: "操作", align: "center", width: "80" }, { default: s((o) => [Y((_(), w(g, { size: "default", type: "danger", onClick: (Ie) => q(o.row) }, { default: s(() => e[13] || (e[13] = [m("解绑")])), _: 2, __: [13] }, 1032, ["onClick"])), [[O, n(N).unbind]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"]), l(G, { total: n(E), "current-page": n(x).pageNumber, "page-size": n(x).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(P), onCurrentChange: n(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, ke = ie(je, [["__scopeId", "data-v-d0741157"]]);
export {
  ke as default
};
