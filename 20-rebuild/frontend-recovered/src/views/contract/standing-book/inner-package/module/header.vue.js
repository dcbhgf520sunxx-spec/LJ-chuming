import { ref as v } from "vue";
import { inject as C } from "vue";
import { watchEffect as P } from "vue";
import { watch as B } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as b } from "vue";
import { Fragment as T } from "vue";
import { renderList as D } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as M } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElButton as F } from "element-plus";
import { ElCascader as O } from "element-plus";
import { ElOption as R } from "element-plus";
import { ElSelect as S } from "element-plus";
import { _ as q, a as z, e6 as Q, kY as Y } from "../../../../../shared/runtime.js";
const G = { class: "header-container" }, H = { class: "box-container top-head" }, J = { class: "select" }, K = { class: "select-container" }, W = { __name: "header", setup(X) {
  const n = v([]), V = C("parent_data"), { formData: e, tableRef: _, isPutAway: j, particularsRef: g, _commonFn: w } = V, i = v("请选择项目类型或项目经理"), k = () => {
    j.value = false;
  }, p = () => {
    Q(e, { sustainable: ["year"] }), _.value.isShowAlert = true, _.value.tableList = [];
  }, x = async () => {
    try {
      const { content: l } = await Y(e);
      n.value = l, l.length || (i.value = "无数据");
    } catch (l) {
      n.value = [], console.error("获取类型项目列表失败:", l);
    }
  }, I = () => {
    e.projectAttribute || (e.projectId = "");
  };
  P(async () => {
    e.projectAttribute || e.projectManagerId ? await x() : (n.value = [], i.value = "请选择项目类型或项目经理");
  });
  function E(l) {
    return Object.entries(l).every(([a, r]) => a === "year" ? true : r === null || r === "");
  }
  return B(() => e, async (l) => {
    if (E(e)) return p();
    await w.value.getTableList();
  }, { deep: true }), (l, a) => {
    var f;
    const r = U, m = F, L = O, A = R, N = S;
    return c(), y("div", G, [d("div", H, [d("div", J, [s(r, { modelValue: o(e).year, "onUpdate:modelValue": a[0] || (a[0] = (t) => o(e).year = t), clearable: "", editable: "", placeholder: "请选择年份", type: "year", "value-format": "x" }, null, 8, ["modelValue"]), s(m, { class: "animate__animated animate__fadeIn animate__faster", icon: "el-icon-refresh", size: "default", type: "warning", onClick: p }, { default: u(() => a[3] || (a[3] = [b("重置 ")])), _: 1, __: [3] })])]), d("div", K, [s(L, { modelValue: o(e).projectManagerId, "onUpdate:modelValue": a[1] || (a[1] = (t) => o(e).projectManagerId = t), options: l.projectLeaderList, props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "项目经理", onChange: I }, null, 8, ["modelValue", "options"]), s(N, { modelValue: o(e).projectId, "onUpdate:modelValue": a[2] || (a[2] = (t) => o(e).projectId = t), "no-data-text": i.value, clearable: "", filterable: "", placeholder: "项目" }, { default: u(() => [(c(true), y(T, null, D(n.value, (t) => (c(), h(A, { key: t.id, label: t.serialNumber + "-" + t.shortName, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "no-data-text"]), (f = o(g)) != null && f.drawerVisible ? (c(), h(m, { key: 0, class: "animate__animated animate__fadeIn animate__faster", type: "primary", onClick: k }, { default: u(() => [s(z, { class: "icon", "icon-class": "contract-shouqi" }), a[4] || (a[4] = b(" 收起 "))]), _: 1, __: [4] })) : M("", true)])]);
  };
} }, ee = q(W, [["__scopeId", "data-v-8400e710"]]);
export {
  ee as default
};
