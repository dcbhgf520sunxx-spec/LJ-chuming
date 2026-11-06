import { ref as d } from "vue";
import { inject as S } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as y } from "vue";
import { vShow as W } from "vue";
import { unref as e } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as o } from "vue";
import { normalizeStyle as q } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as c } from "vue";
import { Fragment as z } from "vue";
import { renderList as G } from "vue";
import { createBlock as V } from "vue";
import { toDisplayString as p } from "vue";
import { ElRadioGroup as B } from "element-plus";
import { ElRadioButton as D } from "element-plus";
import { ElInput as M } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { s as Q, d as H } from "../../../../../modules/artifact-bbca1257.js";
import { B as $, G as F, jv as K, q as X, m8 as Y, C as J, L as Z, E as ee } from "../../../../../shared/runtime.js";
import { a as ae } from "../../../../../modules/index-8356a01a.js";
const ne = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(_) {
  const w = _, I = { name: "", serialNumber: "", specification: "", material: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, status: { value: void 0, resetAble: false } }, N = d(), T = d({}), i = d([]), g = d({}), s = d({ loading: false, quantity: 0, totalNetWeight: 0, totalGrossWeight: 0 }), b = S("permission"), { crud: v, query: t, CRUD: k } = $(I);
  k.HOOK.handleRefresh = (n, a) => {
    U();
  };
  async function U() {
    if (F(b.get)) {
      s.value.loading = true;
      try {
        const { quantity: n = 0, totalNetWeight: a = 0, totalGrossWeight: u = 0 } = await Q(t) || {};
        s.value.quantity = n, s.value.totalNetWeight = a, s.value.totalGrossWeight = u;
      } catch (n) {
        console.log("获取构件清单汇总数据", n);
      } finally {
        s.value.loading = false;
      }
    }
  }
  function x(n) {
    const { name: a, label: u } = n;
    T.value = { id: a, name: u }, v.toQuery();
  }
  function A(n) {
    i.value = n || [], i.value.length > 0 ? g.value = { id: i.value[0].id + "", name: i.value[0].name } : g.value = {};
  }
  return (n, a) => {
    const u = D, f = M, E = O, L = C("permission"), R = P;
    return m(), h("div", null, [y(j("div", null, [o(e(X), { ref_key: "monomerSelectRef", ref: N, modelValue: e(t).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).monomerId = l), "project-id": w.projectId, class: "filter-item", mainProductType: e(K).AUXILIARY_MATERIAL.V, onGetAreaInfo: A, "show-tips": i.value.length <= 0 }, null, 8, ["modelValue", "project-id", "mainProductType", "show-tips"]), o(e(ae), { class: "filter-item", style: q(i.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), modelValue: e(t).areaId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).areaId = l), "area-info": i.value, "default-tab": g.value, onTabClick: x }, null, 8, ["style", "modelValue", "area-info", "default-tab"]), o(e(B), { modelValue: e(t).status, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).status = l), size: "small", class: "filter-item", onChange: e(v).toQuery }, { default: r(() => [o(u, { label: void 0 }, { default: r(() => a[7] || (a[7] = [c("全部")])), _: 1, __: [7] }), (m(true), h(z, null, G(e(Y).ENUM, (l) => (m(), V(u, { key: l.V, label: l.V }, { default: r(() => [c(p(l.L), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), o(f, { modelValue: e(t).name, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).name = l), size: "small", placeholder: "输入名称搜索", style: { width: "170px", "margin-left": "0" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(f, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).serialNumber = l), size: "small", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(f, { modelValue: e(t).specification, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).specification = l), size: "small", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(f, { modelValue: e(t).material, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).material = l), size: "small", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), o(e(J))], 512), [[W, e(v).searchToggle]]), o(e(ee), null, { optLeft: r(() => [y((m(), V(Z, { params: e(t), fn: e(H) }, { default: r(() => a[8] || (a[8] = [c(" 构件清单（根据查询条件） ")])), _: 1, __: [8] }, 8, ["params", "fn"])), [[L, e(b).download]])]), viewLeft: r(() => [y((m(), V(E, { effect: "plain", size: "medium" }, { default: r(() => [c(" 构件清单量合计（数量/总净重/总毛重）：" + p(s.value.quantity) + "件 / " + p(s.value.totalNetWeight) + "kg / " + p(s.value.totalGrossWeight) + "kg ", 1)]), _: 1 })), [[R, s.value.loading]])]), _: 1 })]);
  };
} };
export {
  ne as default
};
