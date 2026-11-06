import { ref as p } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as P } from "vue";
import { toDisplayString as H } from "vue";
import { unref as e } from "vue";
import { createElementBlock as q } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as M } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as V } from "vue";
import { ElMessageBox as k } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElSwitch as Y } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElCard as z } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as K, _ as J, e as Q } from "./module/header.vue.js";
import { a as W, s as X } from "../../../../../modules/base-6bc46ddf.js";
import { _ as Z, x as ee, dm as y, o as te, G as v, aS as o, dn as ae } from "../../../../../shared/runtime.js";
import oe from "./module/form.vue.js";
const ne = { style: { "line-height": "28px" } }, le = { key: 0, style: { float: "right" } }, ie = { __name: "index", emits: ["click-line"], setup(se, { emit: F }) {
  const L = F, U = { add: true, edit: false, del: false, download: false }, x = p(), T = p(), w = p([]), i = p(true), { crud: n, columns: _, CRUD: g } = ee({ title: "围护配置", sort: [], permission: { ...y }, optShow: { ...U }, crudApi: { ...K }, hasPagination: false }, x, T), { maxHeight: A } = te({ extraHeight: 160 });
  R();
  async function R() {
    try {
      const { technicalType: t = true } = await W();
      i.value = t;
    } catch (t) {
      console.log("获取技术交底配置状态", t), i.value = true;
    }
  }
  async function B(t) {
    try {
      await k.confirm('此操作将 "' + o.VL[t] + '" 技术交底配置, 是否继续？', "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await X({ technicalType: t }), n.notify("技术交底配置" + o.VL[t] + "成功", g.NOTIFICATION_TYPE.SUCCESS);
    } catch (a) {
      console.log("变更技术交底配置状态", a), i.value = !i.value;
    }
  }
  async function I(t, a) {
    try {
      await k.confirm('此操作将 "' + o.VL[a] + '" ' + t.code + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const s = { code: t.code, status: a };
      await Q(s), n.refresh(), n.notify(o.VL[a] + "成功", g.NOTIFICATION_TYPE.SUCCESS);
    } catch (s) {
      console.log("变更桁架楼层板配置状态", s), t.status = t.status === o.TRUE.V ? o.FALSE.V : o.TRUE.V;
    }
  }
  function f(t) {
    t && L("click-line", t);
  }
  function N(t) {
    w.value = t;
  }
  return g.HOOK.handleRefresh = (t, a) => (a.data.content.length > 0 && a.data.content.forEach((s) => {
    s.type = t.query.type;
  }), a), (t, a) => {
    const s = $, C = Y, r = j, S = D("common-table"), O = z, b = G;
    return u(), d(O, { class: "line-box box-card" }, { header: m(() => [P("span", ne, H(e(n).title) + "列表", 1), e(v)(e(y).get) ? (u(), q("span", le, [l(s, { size: "large", style: { "margin-right": "10px" } }, { default: m(() => a[2] || (a[2] = [M("是否关联技术交底")])), _: 1, __: [2] }), l(C, { modelValue: i.value, "onUpdate:modelValue": a[0] || (a[0] = (c) => i.value = c), disabled: !e(v)(e(y).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(o).TRUE.V, "inactive-value": e(o).FALSE.V, "active-text": e(o).TRUE.L, "inactive-text": e(o).FALSE.L, onChange: a[1] || (a[1] = (c) => B(i.value)) }, null, 8, ["modelValue", "disabled", "active-value", "inactive-value", "active-text", "inactive-text"])])) : h("", true)]), default: m(() => [l(e(J), { onTypeChange: f, selectArr: w.value }, null, 8, ["selectArr"]), e(n).query.type != e(ae).TRUSS_FLOOR_PLATE.V ? V((u(), d(S, { key: 0, ref_key: "tableRef", ref: x, "highlight-current-row": "", data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(A), style: { width: "100%", "margin-top": "10px" }, onCurrentChange: f, "return-source-data": "", showEmptySymbol: false }, { default: m(() => [l(r, { label: "序号", type: "index", align: "center", width: "60" }), e(_).visible("remark") ? (u(), d(r, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "描述", "min-width": "140px" })) : h("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[b, e(n).loading]]) : V((u(), d(S, { key: 1, ref_key: "multipleTable", ref: T, "highlight-current-row": "", data: e(n).data, "empty-text": e(n).emptyText, "max-height": 600, style: { width: "100%", "margin-top": "10px" }, onCurrentChange: f, onSelectionChange: N, "return-source-data": "", showEmptySymbol: false }, { default: m(() => [l(r, { key: "selection", type: "selection", width: "55" }), l(r, { label: "序号", type: "index", align: "center", width: "60" }), e(_).visible("code") ? (u(), d(r, { key: "code", prop: "code", "show-overflow-tooltip": true, label: "板型" })) : h("", true), e(_).visible("sort") ? (u(), d(r, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序" })) : h("", true), l(r, { key: "status", prop: "status", label: "状态" }, { default: m((c) => [l(C, { modelValue: c.row.status, "onUpdate:modelValue": (E) => c.row.status = E, disabled: !e(v)(e(y).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(o).TRUE.V, "inactive-value": e(o).FALSE.V, onChange: (E) => I(c.row, c.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text"])), [[b, e(n).loading]]), l(e(oe))]), _: 1 });
  };
} }, pe = Z(ie, [["__scopeId", "data-v-a2321c7d"]]);
export {
  pe as default
};
