import { ref as i } from "vue";
import { computed as Q } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { unref as r } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as I } from "vue";
import { toDisplayString as w } from "vue";
import { isRef as S } from "vue";
import { ElDivider as $ } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { vLoading as M } from "element-plus";
import { d as N } from "../../../../../modules/common-b3e76e54.js";
import { _ as O, u as z, o as A, na as F, a3 as U, ba as G } from "../../../../../shared/runtime.js";
import J from "../components/item-detail-info.vue.js";
import { _ as K } from "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/mes-ee117a22.js";
import "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/index-897a9ea4.js";
const W = { __name: "production-detail-preview-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(p, { emit: T }) {
  const V = i(), y = i(), D = T, u = p, { visible: d, handleClose: H } = z({ emit: D, props: u, field: "visible", showHook: L, closeHook: B }), { maxHeight: R } = A({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, y), m = i(false), f = i([]), b = i(), k = Q(() => Object.assign(u.info, { handleQuantity: b }));
  function B() {
    f.value = [];
  }
  async function L() {
    var n;
    try {
      m.value = true;
      const { preview: t, handleQuantity: _ } = await N({ id: (n = u.info) == null ? void 0 : n.id });
      f.value = t.map((e) => (e.reportTypeText = F.VL[e.reportType], e)), b.value = _;
    } catch {
      console.log("获取处理列表失败");
    } finally {
      m.value = false;
    }
  }
  function P(n) {
    return G(n, { props: ["quantity"] });
  }
  return (n, t) => {
    var v;
    const _ = $, e = j, C = h("common-table"), q = h("common-drawer"), E = M;
    return g(), x(q, { ref_key: "drawerRef", ref: y, title: `${r(U).VL[(v = p.info) == null ? void 0 : v.productType]}处理预览详情`, modelValue: r(d), "onUpdate:modelValue": t[0] || (t[0] = (s) => S(d) ? d.value = s : null), direction: "rtl", "before-close": r(H), size: "80%" }, { content: a(() => {
      var s;
      return [o(r(J), { productType: (s = p.info) == null ? void 0 : s.productType, data: k.value, showInProductionQ: "" }, null, 8, ["productType", "data"]), o(_, null, { default: a(() => t[1] || (t[1] = [c("span", { class: "title" }, "生产变更", -1)])), _: 1, __: [1] }), I((g(), x(C, { ref_key: "tableRef", ref: V, "summary-method": P, "show-summary": "", data: f.value, "max-height": r(R), style: { width: "100%" } }, { default: a(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), o(r(K), { showProductionLine: "", showFactory: "", showProcess: "" }), o(e, { prop: "reportTypeText", "show-overflow-tooltip": true, label: "上报类型", align: "center" }, { default: a(({ row: l }) => [c("span", null, w(l.reportTypeText), 1)]), _: 1 }), o(e, { prop: "completeTime", "show-overflow-tooltip": true, label: "上报时间", align: "center", width: "160" }, { default: a(({ row: l }) => [c("span", null, w(l.completeTime), 1)]), _: 1 }), o(e, { prop: "quantity", "show-overflow-tooltip": true, label: "生产数量", align: "center" }, { default: a(({ row: l }) => [c("span", null, w(l.quantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[E, m.value]])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, le = O(W, [["__scopeId", "data-v-c6b06674"]]);
export {
  le as default
};
