import { ref as c } from "vue";
import { computed as I } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as v } from "vue";
import { createBlock as g } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as P } from "vue";
import { toDisplayString as y } from "vue";
import { isRef as S } from "vue";
import { ElDivider as $ } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { vLoading as M } from "element-plus";
import { a as N } from "../../../../../modules/common-b3e76e54.js";
import { _ as O, u as z, o as A, na as F, a3 as Q, ba as U } from "../../../../../shared/runtime.js";
import G from "../components/item-detail-info.vue.js";
import { _ as J } from "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/mes-ee117a22.js";
import "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/index-897a9ea4.js";
const K = { __name: "production-detail-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(u, { emit: x }) {
  const T = c(), w = c(), V = x, d = u, { visible: m, handleClose: D } = z({ emit: V, props: d, field: "visible", showHook: H, closeHook: B }), { maxHeight: R } = A({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, w), f = c(false), _ = c([]), k = I(() => Object.assign(d.info));
  function B() {
    _.value = [];
  }
  async function H() {
    var r;
    try {
      f.value = true;
      const { content: e } = await N({ id: (r = d.info) == null ? void 0 : r.id });
      _.value = e.map((n) => (n.reportTypeText = F.VL[n.reportType], n));
    } catch {
      console.log("获取处理列表失败");
    } finally {
      f.value = false;
    }
  }
  function L(r) {
    return U(r, { props: ["quantity"] });
  }
  return (r, e) => {
    var b;
    const n = $, s = j, C = h("common-table"), q = h("common-drawer"), E = M;
    return v(), g(q, { ref_key: "drawerRef", ref: w, title: `${a(Q).VL[(b = u.info) == null ? void 0 : b.productType]}处理详情`, modelValue: a(m), "onUpdate:modelValue": e[0] || (e[0] = (i) => S(m) ? m.value = i : null), direction: "rtl", "before-close": a(D), size: "80%" }, { content: o(() => {
      var i;
      return [t(a(G), { productType: (i = u.info) == null ? void 0 : i.productType, data: k.value, showInProductionQ: "" }, null, 8, ["productType", "data"]), t(n, null, { default: o(() => e[1] || (e[1] = [p("span", { class: "title" }, "生产变更", -1)])), _: 1, __: [1] }), P((v(), g(C, { ref_key: "tableRef", ref: T, "summary-method": L, "show-summary": "", data: _.value, "max-height": a(R), style: { width: "100%" } }, { default: o(() => [t(s, { label: "序号", type: "index", align: "center", width: "60" }), t(a(J), { showProductionLine: "", showFactory: "", showProcess: "" }), t(s, { prop: "reportTypeText", "show-overflow-tooltip": true, label: "上报类型", align: "center" }, { default: o(({ row: l }) => [p("span", null, y(l.reportTypeText), 1)]), _: 1 }), t(s, { prop: "completeTime", "show-overflow-tooltip": true, label: "上报时间", align: "center", width: "160" }, { default: o(({ row: l }) => [p("span", null, y(l.completeTime), 1)]), _: 1 }), t(s, { prop: "quantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: o(({ row: l }) => [p("span", null, y(l.quantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[E, f.value]])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ne = O(K, [["__scopeId", "data-v-348cf8c3"]]);
export {
  ne as default
};
