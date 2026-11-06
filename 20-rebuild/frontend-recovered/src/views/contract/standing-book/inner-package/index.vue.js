import { ref as e } from "vue";
import { reactive as m } from "vue";
import { provide as x } from "vue";
import { computed as b } from "vue";
import { watch as w } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as c } from "vue";
import { normalizeClass as l } from "vue";
import { createVNode as t } from "vue";
import { createCommentVNode as k } from "vue";
import { withCtx as R } from "vue";
import { Transition as T } from "vue";
import { ElDivider as g } from "element-plus";
import j from "./module/HeaderTwo.vue.js";
import C from "./module/table.vue.js";
import D from "./module/particulars/index.vue.js";
import { u as I } from "../../../../modules/useSelect-654af12a.js";
import { _ as V } from "../../../../shared/runtime.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/useTableTotal-3d22365a.js";
import "../../../../modules/contract-9b18cc88.js";
const A = { class: "app-container" }, B = { class: "item-container" }, L = { key: 0 }, N = { __name: "index", setup(E) {
  const { projectLeaderList: f } = I(), d = e(null), s = e(null), v = m({ projectManagerId: "", year: (/* @__PURE__ */ new Date()).getTime() }), _ = m({}), r = e(null), n = e(true), i = e("");
  x("parent_data", { headerRef: d, tableRef: s, projectInfo: _, formData: v, particularsRef: r, isPutAway: n, projectLeaderList: f, _commonFn: e({}), _commonAttribute: e({}) });
  const h = b(() => s.value && s.value.tableList.length && !r.value.drawerVisible);
  return w(() => {
    var a;
    return (a = _.project) == null ? void 0 : a.id;
  }, (a, o) => {
    a !== o && (i.value = "animate__animated animate__fadeIn animate__faster", setTimeout(() => {
      i.value = "";
    }, 1e3));
  }), (a, o) => {
    const y = g;
    return u(), p("div", A, [c("div", B, [c("div", { class: l([{ collapsed: !n.value }, "card-container"]) }, [t(j, { ref_key: "headerRef", ref: d, class: "head-container" }, null, 512), t(C, { ref_key: "tableRef", ref: s }, null, 512)], 2), t(y, { class: l([{ collapsed: !n.value }, "direction"]), direction: "vertical" }, null, 8, ["class"]), h.value ? (u(), p("div", L, o[0] || (o[0] = [c("div", { class: "my-code" }, "*点击左侧行项目查看详情", -1)]))) : k("", true), t(T, { name: "fade" }, { default: R(() => [t(D, { ref_key: "particularsRef", ref: r, class: l(["particular-container", i.value]) }, null, 8, ["class"])]), _: 1 })])]);
  };
} }, K = V(N, [["__scopeId", "data-v-24369fd9"]]);
export {
  K as default
};
