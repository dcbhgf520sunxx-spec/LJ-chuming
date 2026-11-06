import { ref as n } from "vue";
import { inject as Q } from "vue";
import { computed as S } from "vue";
import { resolveComponent as s } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as x } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { withKeys as k } from "vue";
import { withModifiers as C } from "vue";
import { createTextVNode as z } from "vue";
import { createElementVNode as B } from "vue";
import { withDirectives as I } from "vue";
import { unref as p } from "vue";
import { toDisplayString as W } from "vue";
import { isRef as A } from "vue";
import { ElInput as P } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { g as J } from "../../../../../modules/wip-statistics-f9d24ea0.js";
import { u as X, o as Y } from "../../../../../shared/runtime.js";
const Z = { style: { width: "300px" } }, oe = { __name: "task-mete", props: { visible: { type: Boolean, default: false }, info: { type: Object } }, emits: ["update:visible"], setup(M, { emit: N }) {
  const v = n(), u = n(), m = n(), R = N, _ = M, j = Q("permission"), { visible: c, handleClose: H } = X({ emit: R, props: _, field: "visible", showHook: w }), { maxHeight: D } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, v), d = n(false), f = n([]), h = S(() => {
    var l;
    return { projectId: (l = _.info.project) == null ? void 0 : l.id };
  });
  async function w() {
    try {
      f.value = [], d.value = true;
      const { content: l } = await J({ ...h.value });
      f.value = l.map((t, i) => (t.rowId = i + "" + Math.random(), t));
    } catch (l) {
      console.log("获取任务量详情失败", l);
    } finally {
      d.value = false;
    }
  }
  function b() {
    w();
  }
  function K() {
    u.value = void 0, m.value = void 0, w();
  }
  return (l, t) => {
    const i = P, y = s("common-button"), q = s("print-table"), o = F, L = s("common-table"), U = s("common-drawer"), E = T("permission"), O = G;
    return x(), V(U, { ref_key: "drawerRef", ref: v, title: "任务量详情", modelValue: p(c), "onUpdate:modelValue": t[2] || (t[2] = (a) => A(c) ? c.value = a : null), direction: "rtl", "before-close": p(H), size: "70%" }, { titleAfter: r(() => [e(i, { modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => u.value = a), modelModifiers: { trim: true }, size: "default", placeholder: "输入单体搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: k(b, ["enter"]) }, null, 8, ["modelValue"]), e(i, { modelValue: m.value, "onUpdate:modelValue": t[1] || (t[1] = (a) => m.value = a), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px", "margin-left": "8px" }, class: "filter-item", clearable: "", onKeyup: k(b, ["enter"]) }, null, 8, ["modelValue"]), e(y, { class: "filter-item", size: "default", style: { "margin-left": "8px" }, type: "success", icon: "el-icon-search", onClick: C(b, ["stop"]) }, { default: r(() => t[3] || (t[3] = [z(" 搜索 ")])), _: 1, __: [3] }), e(y, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: C(K, ["stop"]) }, { default: r(() => t[4] || (t[4] = [z(" 重置 ")])), _: 1, __: [4] })]), titleRight: r(() => [B("div", Z, [I(e(q, { "api-key": l.apiKey, params: { ...h.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[E, p(j).print]])])]), content: r(() => [I((x(), V(L, { returnSourceData: "", data: f.value, "max-height": p(D), "show-empty-symbol": false, "row-key": "rowId", style: { width: "100%" } }, { default: r(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: r(({ row: a }) => {
      var g;
      return [B("span", null, W(a.monomer ? (g = a.monomer) == null ? void 0 : g.name : "/"), 1)];
    }), _: 1 }), e(o, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "单重", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "总重", align: "center" })]), _: 1 }, 8, ["data", "max-height"])), [[O, d.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  oe as default
};
