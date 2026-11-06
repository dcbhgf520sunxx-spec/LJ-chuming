import { ref as r } from "vue";
import { computed as S } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as g } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as $ } from "vue";
import { toDisplayString as y } from "vue";
import { isRef as j } from "vue";
import { ElDivider as I } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as N } from "element-plus";
import { d as O } from "../../../../../modules/common-b3e76e54.js";
import { _ as q, u as z, o as A, a3 as F, ba as U } from "../../../../../shared/runtime.js";
import G from "../components/item-detail-info.vue.js";
import { _ as J } from "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/mes-ee117a22.js";
import "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/index-897a9ea4.js";
const K = { __name: "schedule-detail-preview-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(c, { emit: k }) {
  const x = r(), w = r(), H = k, d = c, { visible: p, handleClose: T } = z({ emit: H, props: d, field: "visible", showHook: C, closeHook: V }), { maxHeight: D } = A({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, w), m = r(false), f = r([]), v = r(), P = S(() => Object.assign(d.info, { handleQuantity: v }));
  function V() {
    f.value = [];
  }
  async function C() {
    var i;
    try {
      m.value = true;
      const { preview: t, handleQuantity: _ } = await O({ id: (i = d.info) == null ? void 0 : i.id });
      f.value = t.map((e) => (e.canHandleQuantity = e.taskQuantity - e.inProductionQuantity, e)), v.value = _;
    } catch {
      console.log("获取处理列表失败");
    } finally {
      m.value = false;
    }
  }
  function B(i) {
    return U(i, { props: ["taskQuantity", "inProductionQuantity", "canHandleQuantity", "dealQuantity"] });
  }
  return (i, t) => {
    var b;
    const _ = I, e = M, R = h("common-table"), L = h("common-drawer"), E = N;
    return g(), Q(L, { ref_key: "drawerRef", ref: w, title: `${n(F).VL[(b = c.info) == null ? void 0 : b.productType]}处理预览详情`, modelValue: n(p), "onUpdate:modelValue": t[0] || (t[0] = (s) => j(p) ? p.value = s : null), direction: "rtl", "before-close": n(T), size: "80%" }, { content: o(() => {
      var s;
      return [a(n(G), { productType: (s = c.info) == null ? void 0 : s.productType, data: P.value, showTaskQ: "" }, null, 8, ["productType", "data"]), a(_, null, { default: o(() => t[1] || (t[1] = [u("span", { class: "title" }, "排产变更", -1)])), _: 1, __: [1] }), $((g(), Q(R, { ref_key: "tableRef", ref: x, "summary-method": B, "show-summary": "", data: f.value, "max-height": n(D), style: { width: "100%" } }, { default: o(() => [a(e, { label: "序号", type: "index", align: "center", width: "60" }), a(e, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "要求完成日期", align: "center" }, { default: o(({ row: l }) => [u("span", null, y(l.askCompleteTime), 1)]), _: 1 }), a(n(J), { showProductionLine: "", showFactory: "" }), a(e, { prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数量", align: "center" }, { default: o(({ row: l }) => [u("span", null, y(l.taskQuantity), 1)]), _: 1 }), a(e, { prop: "inProductionQuantity", "show-overflow-tooltip": true, label: "已生产数量", align: "center" }, { default: o(({ row: l }) => [u("span", null, y(l.inProductionQuantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[E, m.value]])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ie = q(K, [["__scopeId", "data-v-fea1675d"]]);
export {
  ie as default
};
