import { ref as i } from "vue";
import { computed as E } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as h } from "vue";
import { createBlock as v } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as S } from "vue";
import { toDisplayString as g } from "vue";
import { isRef as $ } from "vue";
import { ElDivider as j } from "element-plus";
import { ElTableColumn as I } from "element-plus";
import { vLoading as M } from "element-plus";
import { a as N } from "../../../../../modules/common-b3e76e54.js";
import { _ as O, u as P, o as z, a3 as A, ba as F } from "../../../../../shared/runtime.js";
import U from "../components/item-detail-info.vue.js";
import { _ as G } from "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/mes-ee117a22.js";
import "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/index-897a9ea4.js";
const J = { __name: "schedule-detail-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(r, { emit: x }) {
  const k = i(), y = i(), T = x, c = r, { visible: u, handleClose: D } = P({ emit: T, props: c, field: "visible", showHook: B, closeHook: H }), { maxHeight: V } = z({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, y), d = i(false), m = i([]), C = E(() => Object.assign(c.info));
  function H() {
    m.value = [];
  }
  async function B() {
    var n;
    try {
      d.value = true;
      const { content: e } = await N({ id: (n = c.info) == null ? void 0 : n.id });
      m.value = e.map((t) => (t.canHandleQuantity = t.taskQuantity - t.inProductionQuantity, t));
    } catch {
      console.log("获取处理列表失败");
    } finally {
      d.value = false;
    }
  }
  function R(n) {
    return F(n, { props: ["quantity"] });
  }
  return (n, e) => {
    var b;
    const t = j, p = I, L = w("common-table"), q = w("common-drawer"), Q = M;
    return h(), v(q, { ref_key: "drawerRef", ref: y, title: `${o(A).VL[(b = r.info) == null ? void 0 : b.productType]}处理详情`, modelValue: o(u), "onUpdate:modelValue": e[0] || (e[0] = (s) => $(u) ? u.value = s : null), direction: "rtl", "before-close": o(D), size: "80%" }, { content: l(() => {
      var s;
      return [a(o(U), { productType: (s = r.info) == null ? void 0 : s.productType, data: C.value, showTaskQ: "" }, null, 8, ["productType", "data"]), a(t, null, { default: l(() => e[1] || (e[1] = [_("span", { class: "title" }, "排产变更", -1)])), _: 1, __: [1] }), S((h(), v(L, { ref_key: "tableRef", ref: k, "summary-method": R, "show-summary": "", data: m.value, "max-height": o(V), style: { width: "100%" } }, { default: l(() => [a(p, { label: "序号", type: "index", align: "center", width: "60" }), a(p, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "要求完成日期", align: "center" }, { default: l(({ row: f }) => [_("span", null, g(f.askCompleteTime), 1)]), _: 1 }), a(o(G), { showProductionLine: "", showFactory: "" }), a(p, { prop: "quantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: l(({ row: f }) => [_("span", null, g(f.quantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[Q, d.value]])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ne = O(J, [["__scopeId", "data-v-90e2a7f7"]]);
export {
  ne as default
};
