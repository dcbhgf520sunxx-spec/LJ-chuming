import { ref as l } from "vue";
import { watch as D } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as f } from "vue";
import { withCtx as i } from "vue";
import { unref as o } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as C } from "vue";
import { createCommentVNode as M } from "vue";
import { ElCol as P } from "element-plus";
import { ElRow as L } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { vLoading as F } from "element-plus";
import { a as W, b as j } from "../../../../../modules/production-order-028b54f6.js";
import { _ as H, a3 as s, o as O, es as $, bV as G, D as K, i as U } from "../../../../../shared/runtime.js";
import z from "./type-detail.vue.js";
import w from "./components/Panel/index.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const J = { style: { display: "flex", "margin-top": "15px" } }, X = { style: { width: "45%", "padding-right": "10px" }, class: "tree-list" }, Y = { key: 0, style: { color: "red" } }, Z = { key: 1 }, tt = { key: 0 }, et = { key: 1 }, at = { style: { width: "54%", "padding-left": "10px" } }, ot = { key: 1, class: "my-code" }, rt = { __name: "structure-list", props: { currentId: { type: [String, Number], default: void 0 }, drawerVisible: { type: Boolean, require: true } }, setup(I) {
  const u = I, h = l([]), c = l(false), r = l(s.ARTIFACT.V), y = l({}), m = l({}), { maxHeight: N } = O({ extraBox: ".tag-div", wrapperBox: [".app-container", ".tree-list"] }), V = l([["artifactType", ["parse-enum", $]], ["auditReceiptTime", "parse-time"]]), A = l([s.ARTIFACT, s.ASSEMBLE, s.MACHINE_PART]);
  D(() => u.drawerVisible, (t) => {
    t && (r.value = s.ARTIFACT.V, y.value = {}, b(), q());
  }, { deep: true, immediate: true });
  async function q() {
    if (m.value = {}, !!u.currentId) {
      c.value = true;
      try {
        const t = await W({ projectId: u.currentId, productType: r.value });
        m.value = { artifactQuantity: [{ quantity: t.artifactQuantity || 0, unit: "件", precision: 0 }, { quantity: t.artifactMete || 0, unit: "kg", precision: 2 }], assembleQuantity: [{ quantity: t.assembleQuantity, unit: "件", precision: 0 }, { quantity: t.assembleMete, unit: "kg", precision: 2 }], machinePartQuantity: [{ quantity: t.machinePartQuantity, unit: "件", precision: 0 }, { quantity: t.machinePartMete, unit: "kg", precision: 2 }] };
      } catch (t) {
        console.log("获取构零件清单汇总失败", t);
      }
    }
  }
  async function b() {
    if (h.value = [], !!u.currentId) {
      c.value = true;
      try {
        const t = await j({ projectId: u.currentId, type: r.value });
        t.map((p) => {
          p.projectId = u.currentId;
        }), h.value = t || [], c.value = false;
      } catch (t) {
        console.log("获取构零件清单失败", t), c.value = false;
      }
    }
  }
  function R(t) {
    y.value = t;
  }
  return (t, p) => {
    const B = x("common-radio-button"), g = P, E = L, _ = S, Q = x("common-table"), T = F;
    return a(), d("div", null, [e(B, { modelValue: r.value, "onUpdate:modelValue": p[0] || (p[0] = (n) => r.value = n), options: A.value, type: "enum", style: { "margin-bottom": "10px" }, onChange: b }, null, 8, ["modelValue", "options"]), k((a(), f(E, { gutter: 30, class: "panel-group" }, { default: i(() => [e(g, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(w), { name: "构件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.artifactQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), e(g, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(w), { name: "部件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.assembleQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), e(g, { span: 8, class: "card-panel-col" }, { default: i(() => [e(o(w), { name: "零件总数", "text-color": "#626262", "num-color": "#1890ff", "num-arr": m.value.machinePartQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 })]), _: 1 })), [[T, c.value]]), v("div", J, [v("div", X, [k((a(), f(Q, { data: h.value, onCurrentChange: R, "data-format": V.value, "highlight-current-row": "", "max-height": o(N) - 70 }, { default: i(() => [e(_, { key: "classificationName", prop: "classificationName", label: `${o(s).VL[r.value]}分类`, align: "center", "show-overflow-tooltip": true }, { default: i((n) => [n.row.classificationId === null ? (a(), d("span", Y, "未知类型")) : (a(), d("span", Z, C(n.row.classificationName), 1))]), _: 1 }, 8, ["label"]), r.value === o(s).ARTIFACT.V ? (a(), f(_, { key: "artifactType", prop: "artifactType", label: "构件类型", align: "center", "show-overflow-tooltip": true })) : M("", true), e(_, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true }), e(_, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), e(_, { key: "totalNetWeight", prop: "totalNetWeight", label: "重量（kg）", align: "center", "show-overflow-tooltip": true }, { default: i((n) => [n.row.totalNetWeight ? (a(), d("span", tt, C(o(G)(n.row.totalNetWeight, o(K).COM_WT__KG)), 1)) : (a(), d("span", et, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[T, c.value]])]), p[1] || (p[1] = v("div", { style: { "border-right": "1px solid #ededed", height: "calc(100vh - 260px)" } }, null, -1)), v("div", at, [o(U)(y.value) ? (a(), f(o(z), { key: 0, currentRow: y.value, productType: r.value }, null, 8, ["currentRow", "productType"])) : (a(), d("div", ot, "*点击左表操作查看明细"))])])]);
  };
} }, pt = H(rt, [["__scopeId", "data-v-4a67b8ad"]]);
export {
  pt as default
};
