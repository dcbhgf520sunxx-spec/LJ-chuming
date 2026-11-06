import { ref as y } from "vue";
import { inject as P } from "vue";
import { watchEffect as S } from "vue";
import { watch as B } from "vue";
import { computed as A } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { withDirectives as F } from "vue";
import { vShow as D } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as g } from "vue";
import { Fragment as O } from "vue";
import { renderList as R } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as U } from "vue";
import { ElDatePicker as H } from "element-plus";
import { ElButton as q } from "element-plus";
import { ElCascader as z } from "element-plus";
import { ElOption as Q } from "element-plus";
import { ElSelect as Y } from "element-plus";
import { _ as Z, a as G, e6 as J, kY as K, kZ as W } from "../../../../../shared/runtime.js";
const X = { class: "header-container" }, $ = { class: "box-container top-head" }, ee = { class: "select" }, ae = { class: "select-container" }, te = { __name: "HeaderTwo", setup(le) {
  const n = y([]), { formData: a, tableRef: p, isPutAway: j, particularsRef: w, _commonFn: b, projectLeaderList: V } = P("parent_data"), r = y("请选择项目经理"), I = () => {
    j.value = false;
  }, _ = () => {
    J(a, { sustainable: ["year"] }), p.value.isShowAlert = true, p.value.tableList = [];
  }, k = async () => {
    try {
      const { content: t } = await K({ projectManagerId: a.projectManagerId, year: a.year });
      n.value = t, (!t || !t.length) && (r.value = "暂无项目", a.projectId = null, n.value = []);
    } catch (t) {
      n.value = [], r.value = "请求错误", console.error("获取类型项目列表失败:getProjectTypeList", t);
    }
  };
  S(async () => {
    a.projectManagerId ? await k() : (n.value = [], a.projectId = null, r.value = "请先选择项目经理");
  });
  function x(t) {
    return Object.entries(t).every(([e, c]) => e === "year" ? true : c === null || c === "");
  }
  B(() => a, async (t, e) => {
    if (x(a)) return _();
    await b.value.getTableList();
  }, { deep: true });
  const M = A(() => Object.entries(a).some(([t, e]) => t === "year" ? false : e != null && e !== "")), L = W(["projectManagerId", "projectId"], a), C = () => {
    L("projectManagerId", () => {
      n.value = [];
    });
  };
  return (t, e) => {
    var f;
    const c = H, m = q, E = z, T = Q, N = Y;
    return i(), v("div", X, [d("div", $, [d("div", ee, [s(c, { modelValue: o(a).year, "onUpdate:modelValue": e[0] || (e[0] = (l) => o(a).year = l), clearable: "", editable: "", placeholder: "请选择年份", type: "year", "value-format": "x" }, null, 8, ["modelValue"]), F(s(m, { class: "animate__animated animate__fadeIn animate__faster", icon: "el-icon-refresh", size: "default", type: "warning", onClick: _ }, { default: u(() => e[3] || (e[3] = [g("重置 ")])), _: 1, __: [3] }, 512), [[D, M.value]])])]), d("div", ae, [s(E, { modelValue: o(a).projectManagerId, "onUpdate:modelValue": e[1] || (e[1] = (l) => o(a).projectManagerId = l), options: o(V), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "项目经理", style: { width: "100%" }, onChange: C }, null, 8, ["modelValue", "options"]), s(N, { modelValue: o(a).projectId, "onUpdate:modelValue": e[2] || (e[2] = (l) => o(a).projectId = l), "no-data-text": r.value, clearable: "", filterable: "", placeholder: "项目", style: { width: "100%" } }, { default: u(() => [(i(true), v(O, null, R(n.value, (l) => (i(), h(T, { key: l.id, label: l.serialNumber + "-" + l.shortName, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "no-data-text"]), (f = o(w)) != null && f.drawerVisible ? (i(), h(m, { key: 0, class: "animate__animated animate__fadeIn animate__faster", type: "primary", onClick: I }, { default: u(() => [s(G, { class: "icon", "icon-class": "contract-shouqi" }), e[4] || (e[4] = g(" 收起 "))]), _: 1, __: [4] })) : U("", true)])]);
  };
} }, re = Z(te, [["__scopeId", "data-v-3fc34fd1"]]);
export {
  re as default
};
