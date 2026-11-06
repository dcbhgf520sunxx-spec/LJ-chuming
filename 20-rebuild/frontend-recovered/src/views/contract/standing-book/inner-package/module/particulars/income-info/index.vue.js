import { _ as z, a as S, l4 as U, ec as F, j0 as C } from "../../../../../../../shared/runtime.js";
import { ref as s } from "vue";
import { reactive as G } from "vue";
import { inject as M } from "vue";
import { computed as i } from "vue";
import { watch as T } from "vue";
import { onMounted as $ } from "vue";
import { provide as q } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as J } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as n } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as x } from "vue";
import { createBlock as f } from "vue";
import { unref as I } from "vue";
import { createCommentVNode as g } from "vue";
import { resolveDynamicComponent as K } from "vue";
import { Fragment as Q } from "vue";
import { defineAsyncComponent as A } from "vue";
import { ElRadioButton as W } from "element-plus";
import { ElRadioGroup as X } from "element-plus";
import { ElButton as Y } from "element-plus";
import Z from "../components/ProjectInfo.vue.js";
import ee from "../components/establish/detailed.vue.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
const te = { class: "box-container" }, ae = { class: "header-btn-container" }, ne = { class: "left" }, oe = { class: "right" }, ie = { __name: "index", setup(se) {
  const o = s("collection"), v = s([]), r = G({}), R = M("parent_data"), { projectInfo: a, _commonFn: w, _commonAttribute: j } = R, k = s(null), c = s(false), D = s(null), E = i(() => j.value.isShowPrintTable), P = i(() => j.value.isInfoPrintType), B = { collection: A(() => C(() => import("./record/collection-invoice/index.vue.js"), ["static/js/index-45d2027f.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/css/index-7db00ba4.css"])), expend: A(() => C(() => import("./record/ExpendTable.vue.js"), ["static/js/ExpendTable-a58d95ad.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/index-28735ccc.js", "static/css/index-58effffe.css", "static/css/ExpendTable-bcd803c5.css"])) }, L = i(() => B[o.value]);
  T(D, (e) => {
    e && c && e != null && e.detailedList && e.detailedList();
  });
  const d = async () => {
    try {
      const e = await U({ projectId: a.project.id }), t = F([e], ["date"]);
      v.value = [];
      const { collectionDetailsDto: _ } = t[0];
      Object.keys(r).forEach((y) => {
        delete r[y];
      }), Object.assign(r, t[0]), v.value.push(_);
    } catch (e) {
      console.log("获取收支信息失败" + e);
    }
  };
  w.value.getExpendIdDetail = d, $(() => {
    var e;
    (e = a == null ? void 0 : a.project) != null && e.id && d();
  });
  const V = i(() => E.value && o.value === "collection" && P.value === "collection"), h = i(() => E.value && o.value === "collection" && P.value === "invoice"), N = i(() => o.value === "expend");
  return q("info_parent_data", { collectionTable: v, projectInfo: a, endLogTableData: r, currentComRef: k, getExpendIdDetail: d }), T(() => {
    var e;
    return (e = a == null ? void 0 : a.project) == null ? void 0 : e.id;
  }, (e) => {
    d();
  }), (e, t) => {
    const _ = W, y = X, O = Y, b = H("print-table");
    return l(), J(Q, null, [p("div", te, [n(Z)]), p("div", ae, [p("div", ne, [n(y, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (u) => o.value = u), class: "box-container" }, { default: m(() => [n(_, { value: "collection" }, { default: m(() => t[3] || (t[3] = [x("收款及开票")])), _: 1, __: [3] }), n(_, { value: "expend" }, { default: m(() => t[4] || (t[4] = [x("支出及开票")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"]), n(O, { type: "primary", onClick: t[1] || (t[1] = (u) => c.value = true) }, { default: m(() => [n(S, { class: "icon", "icon-class": "contract-detail" }), t[5] || (t[5] = x(" 收支明细 "))]), _: 1 })]), p("div", oe, [V.value ? (l(), f(b, { key: 0, params: { projectId: I(a).project.id }, "api-key": "collectionInfo", class: "filter-item animate__animated animate__fadeIn animate__faster", size: "default", type: "warning" }, null, 8, ["params"])) : g("", true), h.value ? (l(), f(b, { key: 1, params: { projectId: I(a).project.id }, "api-key": "invoiceInfo", class: "filter-item animate__animated animate__fadeIn animate__faster", size: "default", type: "warning" }, null, 8, ["params"])) : g("", true), N.value ? (l(), f(b, { key: 2, params: { projectId: I(a).project.id }, "api-key": "expendInfo", class: "filter-item animate__animated animate__fadeIn animate__faster", size: "default", type: "warning" }, null, 8, ["params"])) : g("", true)])]), (l(), f(K(L.value), { ref_key: "currentComRef", ref: k, class: "animate__animated animate__fadeIn animate__faster" }, null, 512)), n(ee, { ref_key: "detailedRef", ref: D, visible: c.value, "onUpdate:visible": t[2] || (t[2] = (u) => c.value = u) }, null, 8, ["visible"])], 64);
  };
} }, me = z(ie, [["__scopeId", "data-v-8ccb1f57"]]);
export {
  me as default
};
